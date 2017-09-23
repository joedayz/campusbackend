package pe.joedayz.api.service.impl;

import pe.joedayz.api.rest.GenericRestException;

public class CampusException extends GenericRestException {


    public CampusException(String errorCode) {
        super(errorCode);
    }

    public CampusException(String errorCode, String message) {
        super(errorCode, message);
    }
}
