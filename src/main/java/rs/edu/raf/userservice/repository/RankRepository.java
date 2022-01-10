package rs.edu.raf.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.edu.raf.userservice.domain.Rank;

import java.util.Optional;


@Repository
public interface RankRepository extends JpaRepository<Rank, Long> {
    Optional<Rank> findRankByMinReservation(Long minReservation);
    Optional<Rank> findRankByMinReservationLessThanEqualAndMaxReservationGreaterThanEqual(Long numOfReservation, Long numLong);
}
