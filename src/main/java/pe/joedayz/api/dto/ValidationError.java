package pe.joedayz.api.dto;

/**
 * User: RAC
 * Date: 15/03/12
 */
public class ValidationError {
    private String property;
    private String message;
    private String code;
    private Object[] arguments;


    public ValidationError(String property, String message) {
        this.property = property;
        this.message = message;
    }

    public ValidationError(String code, Object[] arguments) {
        this.code = code;
        this.arguments = arguments;
    }

    public String getProperty() {
        return property;
    }

    public String getMessage() {
        return message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object[] getArguments() {
        return arguments;
    }

    public void setArguments(Object[] arguments) {
        this.arguments = arguments;
    }
}

