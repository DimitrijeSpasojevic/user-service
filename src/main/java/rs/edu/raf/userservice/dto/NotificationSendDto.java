package rs.edu.raf.userservice.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.validation.constraints.NotEmpty;
import java.util.List;

public class NotificationSendDto {
    @NotEmpty(message = "Notification type can't be empty")
    @JsonSerialize
    private String notificationType;
    @NotEmpty(message = "Email can't be empty")
    @JsonSerialize
    private String email;
    @JsonSerialize
    private List<NotificationParameterDto> parameters;

    public NotificationSendDto() {
    }

    public NotificationSendDto(String notificationType, String email, List<NotificationParameterDto> parameters) {
        this.notificationType = notificationType;
        this.email = email;
        this.parameters = parameters;
    }

    public String getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(String notificationType) {
        this.notificationType = notificationType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<NotificationParameterDto> getParameters() {
        return parameters;
    }

    public void setParameters(List<NotificationParameterDto> parameters) {
        this.parameters = parameters;
    }
}
