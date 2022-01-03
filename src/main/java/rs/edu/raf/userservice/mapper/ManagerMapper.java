package rs.edu.raf.userservice.mapper;

import org.springframework.stereotype.Component;
import rs.edu.raf.userservice.domain.Manager;
import rs.edu.raf.userservice.dto.CreateManagerDto;
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

    public Manager createManagerDtoToManager(CreateManagerDto createManagerDto){
        Manager manager = new Manager();
        manager.setAllowedAccess(true);
        manager.setContact(createManagerDto.getContact());
        manager.setEmail(createManagerDto.getEmail());
        manager.setFirstName(createManagerDto.getFirstName());
        manager.setLastName(createManagerDto.getLastName());
        manager.setPassword(createManagerDto.getPassword());
        manager.setDateOfBirth(createManagerDto.getDateOfBirth());
        manager.setUsername(createManagerDto.getUsername());
        manager.setHotelName(createManagerDto.getHotelName());
        manager.setHireDate(createManagerDto.getHireDate());
        return manager;
    }
}
