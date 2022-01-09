package rs.edu.raf.userservice.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;

public class ManagerDto {
    private Long userId;
    @NotEmpty(message = "username ne moze da bude prazno")
    private String username;
    @NotEmpty(message = "password ne moze da bude prazno")
    private String password;
    @NotEmpty(message = "email ne moze da bude prazno")
    private String email;
    @NotEmpty(message = "contact ne moze da bude prazno")
    private String contact;
    @NotNull(message = "dateOfBirth ne moze da bude prazno")
    private LocalDate dateOfBirth;
    @NotEmpty(message = "firstName ne moze da bude prazno")
    private String firstName;
    @NotEmpty(message = "lastName ne moze da bude prazno")
    private String lastName;
    private Boolean allowedAccess;
    @NotEmpty(message = "hotelName ne moze da bude prazno")
    private String hotelName;
    @NotNull(message = "hireDate ne moze da bude prazno")
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

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

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
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

    public Boolean getAllowedAccess() {
        return allowedAccess;
    }

    public void setAllowedAccess(Boolean allowedAccess) {
        this.allowedAccess = allowedAccess;
    }
}
