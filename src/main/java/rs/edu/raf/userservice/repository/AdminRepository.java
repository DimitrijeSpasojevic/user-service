package rs.edu.raf.userservice.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.edu.raf.userservice.domain.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
}
