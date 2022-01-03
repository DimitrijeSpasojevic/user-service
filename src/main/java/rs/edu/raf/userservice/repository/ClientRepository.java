package rs.edu.raf.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.edu.raf.userservice.domain.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}
