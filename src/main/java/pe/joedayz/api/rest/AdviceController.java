package pe.joedayz.api.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.hateoas.VndErrors;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class AdviceController {
	public static final String ERR_MSG_PREFIX = "errors.";

	final Logger LOG = LoggerFactory.getLogger(getClass());

	@Autowired
	MessageSource messageSource;

	@ResponseBody
	@ExceptionHandler(GenericRestException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	VndErrors handleGenericExcepcion(GenericRestException ex) {

		LOG.error(ex.getMessage(), ex);

        return new VndErrors(ex.getErrorCode(),
                ex.getMessage());

	}



}
