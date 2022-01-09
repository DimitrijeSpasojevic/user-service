package rs.edu.raf.userservice.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rs.edu.raf.userservice.domain.Client;
import rs.edu.raf.userservice.dto.ClientDto;
import rs.edu.raf.userservice.mapper.ClientMapper;
import rs.edu.raf.userservice.repository.ClientRepository;
import rs.edu.raf.userservice.repository.ManagerRepository;
import rs.edu.raf.userservice.service.AdminService;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

    private ClientRepository clientRepository;
    private ClientMapper clientMapper;

    public AdminServiceImpl(ClientRepository clientRepository, ClientMapper clientMapper) {
        this.clientRepository = clientRepository;
        this.clientMapper = clientMapper;
    }

    @Override
    public ClientDto denyAccess(Long userId) {
        Client client = clientRepository.getById(userId);
        client.setAllowedAccess(false);
        clientRepository.save(client);
        return clientMapper.clientToClientDto(client);
    }

    @Override
    public ClientDto allowAccess(Long userId) {
        Client client = clientRepository.getById(userId);
        client.setAllowedAccess(true);
        clientRepository.save(client);
        return clientMapper.clientToClientDto(client);
    }
}
