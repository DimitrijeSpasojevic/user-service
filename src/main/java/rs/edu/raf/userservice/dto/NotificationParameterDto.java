package rs.edu.raf.userservice.dto;

import javax.validation.constraints.NotEmpty;

public class NotificationParameterDto {
    @NotEmpty(message = "Parameter name can't be empty")
    private String name;
    @NotEmpty(message = "Parameter value can't be empty")
    private String value;

    public NotificationParameterDto() { }

    public NotificationParameterDto(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
