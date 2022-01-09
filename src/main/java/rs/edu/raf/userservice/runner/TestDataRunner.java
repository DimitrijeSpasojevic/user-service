package rs.edu.raf.userservice.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import rs.edu.raf.userservice.domain.Client;
import rs.edu.raf.userservice.domain.Rank;
import rs.edu.raf.userservice.repository.ClientRepository;
import rs.edu.raf.userservice.repository.ManagerRepository;
import rs.edu.raf.userservice.repository.RankRepository;

import java.time.LocalDate;

@Profile({"default"})
@Component
public class TestDataRunner implements CommandLineRunner {

    private ClientRepository clientRepository;
    private ManagerRepository managerRepository;
    private RankRepository rankRepository;

    public TestDataRunner(ClientRepository clientRepository, ManagerRepository managerRepository, RankRepository rankRepository) {
        this.clientRepository = clientRepository;
        this.managerRepository = managerRepository;
        this.rankRepository = rankRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Rank rank1 = new Rank();
        rank1.setName("Bronza");
        rank1.setDiscount(Long.valueOf(0));
        rank1.setMinReservation(Long.valueOf(0));
        rank1.setMaxReservation(Long.valueOf(20));
        rankRepository.save(rank1);

        Client client = new Client();
        client.setPassword("123pass");
        client.setEmail("pera@gmail.com");
        client.setUsername("rope");
        client.setPassportId(Long.valueOf(12412));
        client.setContact("062-133-415");
        client.setFirstName("Petar");
        client.setLastName("Peric");

        client.setNumberOfReservations(Long.valueOf(0));
        client.setAllowedAccess(true);
        client.setDateOfBirth(LocalDate.of(1986, 1, 4));
        clientRepository.save(client);
    }
}
