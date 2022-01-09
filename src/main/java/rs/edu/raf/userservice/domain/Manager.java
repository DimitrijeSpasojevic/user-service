package rs.edu.raf.userservice.domain;

import javax.persistence.Entity;
import java.time.LocalDate;
import java.util.Date;


@Entity
public class Manager extends User {
    private String hotelName;
    private LocalDate hireDate;

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }
}
