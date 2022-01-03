package rs.edu.raf.userservice.mapper;

import org.springframework.stereotype.Component;
import rs.edu.raf.userservice.domain.Manager;
import rs.edu.raf.userservice.dto.ManagerDto;

@Component
public class ManagerMapper {

    public ManagerDto managerToManagerDto(Manager manager){
        ManagerDto managerDto = new ManagerDto();
        managerDto.setUserId(manager.getUserId());
        managerDto.setAllowedAccess(manager.getAllowedAccess());
        managerDto.setContact(manager.getContact());
        managerDto.setEmail(manager.getEmail());
        managerDto.setFirstName(manager.getFirstName());
        managerDto.setLastName(manager.getLastName());
        managerDto.setPassword(manager.getPassword());
        managerDto.setDateOfBirth(manager.getDateOfBirth());
        managerDto.setUsername(manager.getUsername());
        managerDto.setHotelName(manager.getHotelName());
        managerDto.setHireDate(manager.getHireDate());
        return managerDto;
    }
}
