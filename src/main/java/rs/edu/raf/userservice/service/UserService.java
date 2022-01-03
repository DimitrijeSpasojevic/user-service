package rs.edu.raf.userservice.service;

import rs.edu.raf.userservice.dto.*;

public interface UserService {

    ClientDto registerClient(CreateClientDto createClientDto);

    ManagerDto registerManager(CreateManagerDto createManagerDto);

    TokenResponseDto login(TokenRequestDto tokenRequestDto);

    ClientDto editProfile(Long userId, UpdateClientDto updateClientDto);
}
