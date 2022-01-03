package rs.edu.raf.userservice.dto;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

public class CreateManagerDto {
    @NotEmpty(message = "username ne moze da bude prazno")
    private String username;
    @NotEmpty(message = "password ne moze da bude prazno")
    private String password;
    @NotEmpty(message = "email ne moze da bude prazno")
    private String email;
    @NotEmpty(message = "contact ne moze da bude prazno")
    private String contact;
    @NotEmpty(message = "dateOfBirth ne moze da bude prazno")
    private Date dateOfBirth;
    @NotEmpty(message = "firstName ne moze da bude prazno")
    private String firstName;
    @NotEmpty(message = "lastName ne moze da bude prazno")
    private String lastName;
    @NotEmpty(message = "hotelName ne moze da bude prazno")
    private String hotelName;
    @NotEmpty(message = "hireDate ne moze da bude prazno")
    private Date hireDate;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

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
