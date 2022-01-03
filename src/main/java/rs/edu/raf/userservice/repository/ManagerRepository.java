package rs.edu.raf.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.edu.raf.userservice.domain.Client;
import rs.edu.raf.userservice.domain.Manager;

import java.util.Optional;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Long> {
    Optional<Manager> findManagerByUsernameAndPassword(String username, String password);

}
