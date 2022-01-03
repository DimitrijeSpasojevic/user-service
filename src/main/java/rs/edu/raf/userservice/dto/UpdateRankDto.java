package rs.edu.raf.userservice.dto;

import javax.validation.constraints.NotEmpty;

public class UpdateRankDto {
    @NotEmpty(message = "name ne moze da bude prazno")
    private String name;
    @NotEmpty(message = "minReservation ne moze da bude prazno")
    private Long minReservation;
    @NotEmpty(message = "maxReservation ne moze da bude prazno")
    private Long maxReservation;
    @NotEmpty(message = "discount ne moze da bude prazno")
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
}
