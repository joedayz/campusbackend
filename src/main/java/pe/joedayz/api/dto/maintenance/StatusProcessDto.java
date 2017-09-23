package pe.joedayz.api.dto.maintenance;

public class StatusProcessDto {

    private String status;
    private String message;

    public StatusProcessDto(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public StatusProcessDto() {

    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
