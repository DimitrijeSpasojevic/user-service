package rs.edu.raf.userservice.dto;

import rs.edu.raf.userservice.domain.Rank;

import javax.validation.constraints.NotEmpty;
import java.util.Date;


public class ClientDto {
    private Long userId;
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
    private Boolean allowedAccess;
    @NotEmpty(message = "passportId ne moze da bude prazno")
    private Long passportId;
    @NotEmpty(message = "numberOfReservations ne moze da bude prazno")
    private Long numberOfReservations;
    @NotEmpty(message = "rank ne moze da bude prazno")
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

    public Boolean getAllowedAccess() {
        return allowedAccess;
    }

    public void setAllowedAccess(Boolean allowedAccess) {
        this.allowedAccess = allowedAccess;
    }
}
