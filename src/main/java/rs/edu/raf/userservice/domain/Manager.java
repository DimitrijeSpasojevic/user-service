package rs.edu.raf.userservice.domain;

import javax.persistence.Entity;
import java.util.Date;


@Entity
public class Manager extends User {
    private String hotelName;
    private Date hireDate;

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }
}
