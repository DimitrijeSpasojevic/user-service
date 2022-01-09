package rs.edu.raf.userservice.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Rank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long minReservation;
    private Long maxReservation;
    private Long discount;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getMinReservation() {
        return minReservation;
    }

    public void setMinReservation(Long minReservation) {
        this.minReservation = minReservation;
    }

    public Long getMaxReservation() {
        return maxReservation;
    }

    public void setMaxReservation(Long maxReservation) {
        this.maxReservation = maxReservation;
    }

    public Long getDiscount() {
        return discount;
    }

    public void setDiscount(Long discount) {
        this.discount = discount;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
