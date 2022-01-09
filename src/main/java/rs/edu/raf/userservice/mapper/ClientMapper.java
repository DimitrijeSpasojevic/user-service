package rs.edu.raf.userservice.mapper;

import org.springframework.stereotype.Component;
import rs.edu.raf.userservice.domain.Client;
import rs.edu.raf.userservice.dto.ClientDto;
import rs.edu.raf.userservice.dto.CreateClientDto;
import rs.edu.raf.userservice.exception.NotFoundException;
import rs.edu.raf.userservice.repository.RankRepository;

@Component
public class ClientMapper {

    private RankRepository rankRepository;

    public ClientMapper(RankRepository rankRepository) {
        this.rankRepository = rankRepository;
    }

    public ClientDto clientToClientDto(Client client){
        ClientDto clientDto = new ClientDto();
        clientDto.setUserId(client.getUserId());
        clientDto.setAllowedAccess(client.getAllowedAccess());
        clientDto.setContact(client.getContact());
        clientDto.setEmail(client.getEmail());
        clientDto.setFirstName(client.getFirstName());
        clientDto.setLastName(client.getLastName());
        clientDto.setPassword(client.getPassword());
        clientDto.setDateOfBirth(client.getDateOfBirth());
        clientDto.setNumberOfReservations(client.getNumberOfReservations());
        clientDto.setPassportId(client.getPassportId());
        return clientDto;
    }

    public Client createClientDtoToClient(CreateClientDto createClientDto){
        Client client = new Client();
        client.setAllowedAccess(true);
        client.setContact(createClientDto.getContact());
        client.setEmail(createClientDto.getEmail());
        client.setFirstName(createClientDto.getFirstName());
        client.setLastName(createClientDto.getLastName());
        client.setPassword(createClientDto.getPassword());
        client.setDateOfBirth(createClientDto.getDateOfBirth());
        client.setRole("ROLE_CLIENT");
        client.setEmailConfirmed(false);
        client.setNumberOfReservations(Long.valueOf(0));
        client.setPassportId(createClientDto.getPassportId());
        return client;
    }
}
