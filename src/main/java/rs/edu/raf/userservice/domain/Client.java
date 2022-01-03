package rs.edu.raf.userservice.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Client extends User{
    private Long passportId;
    private Long numberOfReservations;
    @ManyToOne
    private Rank rank;

    public Long getPassportId() {
        return passportId;
    }

    public void setPassportId(Long passportId) {
        this.passportId = passportId;
    }

    public Long getNumberOfReservations() {
        return numberOfReservations;
    }

    public void setNumberOfReservations(Long numberOfReservations) {
        this.numberOfReservations = numberOfReservations;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }
}
