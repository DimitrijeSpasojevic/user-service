package rs.edu.raf.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.edu.raf.userservice.domain.Rank;


@Repository
public interface RankRepository extends JpaRepository<Rank, Long> {
    Rank findRankByMinReservation(Long minReservation);
}
