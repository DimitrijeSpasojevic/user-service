package rs.edu.raf.userservice.service.impl;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rs.edu.raf.userservice.domain.Client;
import rs.edu.raf.userservice.domain.Manager;
import rs.edu.raf.userservice.domain.Rank;
import rs.edu.raf.userservice.domain.User;
import rs.edu.raf.userservice.dto.*;
import rs.edu.raf.userservice.exception.NotFoundException;
import rs.edu.raf.userservice.mapper.ClientMapper;
import rs.edu.raf.userservice.mapper.ManagerMapper;
import rs.edu.raf.userservice.mapper.RankMapper;
import rs.edu.raf.userservice.repository.ClientRepository;
import rs.edu.raf.userservice.repository.ManagerRepository;
import rs.edu.raf.userservice.repository.RankRepository;
import rs.edu.raf.userservice.repository.UserRepository;
import rs.edu.raf.userservice.security.service.TokenService;
import rs.edu.raf.userservice.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private ClientRepository clientRepository;
    private ManagerRepository managerRepository;
    private ClientMapper clientMapper;
    private ManagerMapper managerMapper;
    private TokenService tokenService;
    private String sendNotificationDestination;
    private JmsTemplate jmsTemplate;
    private ObjectMapper objectMapper;
    private UserRepository userRepository;
    private RankRepository rankRepository;
    private RankMapper rankMapper;

    public UserServiceImpl(ClientRepository clientRepository, ManagerRepository managerRepository, ClientMapper clientMapper, ManagerMapper managerMapper, TokenService tokenService
    ,@Value("${destination.sendNotification}") String sendNotificationDestination
    ,ObjectMapper objectMapper
    ,JmsTemplate jmsTemplate
    ,UserRepository userRepository
    ,RankRepository rankRepository
    ,RankMapper rankMapper) {
        this.clientRepository = clientRepository;
        this.managerRepository = managerRepository;
        this.clientMapper = clientMapper;
        this.managerMapper = managerMapper;
        this.tokenService = tokenService;
        this.sendNotificationDestination = sendNotificationDestination;
        this.objectMapper = objectMapper;
        this.jmsTemplate = jmsTemplate;
        this.userRepository = userRepository;
        this.rankRepository = rankRepository;
        this.rankMapper = rankMapper;
    }

    @Override
    public ClientDto registerClient(CreateClientDto createClientDto) {
        Client client = clientMapper.createClientDtoToClient(createClientDto);
        clientRepository.save(client);
        NotificationParameterDto notificationParameterDto1= new NotificationParameterDto("firstName",createClientDto.getFirstName());
        NotificationParameterDto notificationParameterDto2 = new NotificationParameterDto("lastName",createClientDto.getLastName());
        NotificationParameterDto notificationParameterDto3 = new NotificationParameterDto("url", "http://localhost:8081/api/user/validate/" + client.getUserId());

        List<NotificationParameterDto> notificationParameterDtos = new ArrayList<>();
        notificationParameterDtos.add(notificationParameterDto1);
        notificationParameterDtos.add(notificationParameterDto2);
        notificationParameterDtos.add(notificationParameterDto3);
        NotificationSendDto notificationSendDto = new NotificationSendDto("activation",
                                                                          createClientDto.getEmail(),
                                                                          notificationParameterDtos);
        try {
            jmsTemplate.convertAndSend(this.sendNotificationDestination
                    ,objectMapper.writeValueAsString(notificationSendDto));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return clientMapper.clientToClientDto(client);
    }

    @Override
    public ManagerDto registerManager(CreateManagerDto createManagerDto) {
        Manager manager = managerMapper.createManagerDtoToManager(createManagerDto);
        managerRepository.save(manager);
        NotificationParameterDto notificationParameterDto1= new NotificationParameterDto("firstName",createManagerDto.getFirstName());
        NotificationParameterDto notificationParameterDto2 = new NotificationParameterDto("lastName",createManagerDto.getLastName());
        NotificationParameterDto notificationParameterDto3 = new NotificationParameterDto("url", "http://localhost:8081/api/user/validate/" + manager.getUserId());
        List<NotificationParameterDto> notificationParameterDtos = new ArrayList<>();
        notificationParameterDtos.add(notificationParameterDto1);
        notificationParameterDtos.add(notificationParameterDto2);
        notificationParameterDtos.add(notificationParameterDto3);
        NotificationSendDto notificationSendDto = new NotificationSendDto("activation",
                                                                            createManagerDto.getEmail(),
                                                                            notificationParameterDtos);
        try {
            jmsTemplate.convertAndSend(this.sendNotificationDestination
                    ,objectMapper.writeValueAsString(notificationSendDto));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return managerMapper.managerToManagerDto(manager);
    }


    @Override
    public TokenResponseDto login(TokenRequestDto tokenRequestDto) {
        //Try to find active user for specified credentials
        User user = userRepository
                .findUserByEmailAndPassword(tokenRequestDto.getEmail(), tokenRequestDto.getPassword())
                .orElseThrow(() -> new NotFoundException(String
                        .format("User with email: %s and password: %s not found.", tokenRequestDto.getEmail(),
                                tokenRequestDto.getPassword())));
        //Create token payload
        Claims claims = Jwts.claims();
        claims.put("id", user.getUserId());
        if(user.getRole().equals("ROLE_CLIENT"))
            claims.put("role", "ROLE_CLIENT");
        else if(user.getRole().equals("ROLE_MANAGER")) {
            claims.put("role", "ROLE_MANAGER");
            claims.put("hotel", managerRepository.findById(user.getUserId()).get().getHotelName());
        }else if(user.getRole().equals("ROLE_ADMIN"))
            claims.put("role", "ROLE_ADMIN");
        //Generate token
        return new TokenResponseDto(tokenService.generate(claims));
    }

    @Override
    public ClientDto editProfile(String b_token, UpdateClientDto updateClientDto) {
        String token = b_token.split(" ")[1];
        Claims claims = tokenService.parseToken(token);
        Long userId = claims.get("id", Long.class);
        Client client = clientRepository.getById(userId);
        client.setUsername(updateClientDto.getUsername());
        client.setFirstName(updateClientDto.getFirstName());
        client.setLastName(updateClientDto.getLastName());
        client.setPassportId(updateClientDto.getPassportId());
        client.setEmail(updateClientDto.getEmail());
        client.setContact(updateClientDto.getContact());
        client.setPassword(updateClientDto.getPassword());
        clientRepository.save(client);
        return clientMapper.clientToClientDto(client);
    }

    @Override
    public Page<ClientDto> findAllClients(Pageable pageable) {
        return clientRepository.findAll(pageable)
                .map(clientMapper::clientToClientDto);
    }

    @Override
    public Long confirmEmailValidation(Long id) {
        User user = userRepository.getById(id);
        user.setEmailConfirmed(true);
        userRepository.save(user);
        return user.getUserId();
    }

    @Override
    public Long addReservation(Long clientId) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new NotFoundException(String.format("Client with id: %d not found", clientId)));
        client.setNumberOfReservations(client.getNumberOfReservations() + 1);
        clientRepository.save(client);
        return client.getNumberOfReservations();
    }

    @Override
    public Long deleteReservation(Long clientId) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new NotFoundException(String.format("Client with id: %d not found", clientId)));
        client.setNumberOfReservations(client.getNumberOfReservations() - 1);
        clientRepository.save(client);
        return client.getNumberOfReservations();
    }

    @Override
    public RankDto getRankForClient(Long clientId) {
        Client client = clientRepository.getById(clientId);
        Rank rank = rankRepository.findRankByMinReservationLessThanAndMaxReservationGreaterThan(client.getNumberOfReservations(), client.getNumberOfReservations())
                .orElseThrow(() -> new NotFoundException(String.format("Rank koji obuhvata date opsege ne postoji")));
        return rankMapper.rankToRankDto(rank);
    }

    @Override
    public ClientDto getClient(Long id) {
        return clientMapper.clientToClientDto(clientRepository.getById(id));
    }
}
