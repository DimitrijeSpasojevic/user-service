package rs.edu.raf.userservice.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import rs.edu.raf.userservice.dto.*;

public interface UserService {

    ClientDto registerClient(CreateClientDto createClientDto);

    ManagerDto registerManager(CreateManagerDto createManagerDto);

    TokenResponseDto login(TokenRequestDto tokenRequestDto);

    ClientDto editProfile(String authToken, UpdateClientDto updateClientDto);

    Page<ClientDto> findAllClients(Pageable pageable);

    Long confirmEmailValidation(Long id);

    Long addReservation(Long clientId);

    Long deleteReservation(Long clientId);

    RankDto getRankForClient(Long clientId);

    ClientDto getClient(Long id);
}
