package rs.edu.raf.userservice.mapper;

import org.springframework.stereotype.Component;
import rs.edu.raf.userservice.domain.Client;
import rs.edu.raf.userservice.dto.ClientDto;

@Component
public class ClientMapper {

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
        clientDto.setRank(client.getRank());
        return clientDto;
    }
}
