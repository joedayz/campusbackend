package pe.joedayz.api.rest;

public class GenericRestException extends RuntimeException {
    private String errorCode;

    public GenericRestException(String errorCode) {
        //super("Has ocurred the Error " + errorCode + "'.");
        super(errorCode);
        this.errorCode = errorCode;
    }


    public GenericRestException(String errorCode,String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
