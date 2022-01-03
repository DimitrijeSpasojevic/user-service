package rs.edu.raf.userservice.service.impl;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rs.edu.raf.userservice.dto.*;
import rs.edu.raf.userservice.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Override
    public ClientDto registerClient(CreateClientDto createClientDto) {
        return null;
    }

    @Override
    public ManagerDto registerManager(CreateManagerDto createManagerDto) {
        return null;
    }

    @Override
    public TokenResponseDto login(TokenRequestDto tokenRequestDto) {
        return null;
    }

    @Override
    public ClientDto editProfile(Long userId, UpdateClientDto updateClientDto) {
        return null;
    }
}
