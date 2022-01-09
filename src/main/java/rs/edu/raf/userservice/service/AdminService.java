package rs.edu.raf.userservice.service;


import rs.edu.raf.userservice.dto.ClientDto;

public interface AdminService {

    ClientDto denyAccess(Long userId);

    ClientDto allowAccess(Long userId);
}
