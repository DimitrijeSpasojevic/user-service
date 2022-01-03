package rs.edu.raf.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.edu.raf.userservice.domain.Manager;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Long> {
}
