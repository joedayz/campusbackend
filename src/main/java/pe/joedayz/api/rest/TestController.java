package pe.joedayz.api.rest;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.JsonObject;

import pe.joedayz.api.service.intf.TestService;

@RestController
public class TestController {

	@Autowired
	private TestService testService;
	
	@RequestMapping(value="/test/get/json", method=RequestMethod.GET, produces="application/json")
	public String testGetJson() {
		JsonObject jsonObject = new JsonObject();
		JsonObject message = new JsonObject();

		String result = testService.test();

		message.addProperty("message", result);
		jsonObject.add("test", message);

		return jsonObject.toString();
	}
	
	@RequestMapping(value="/test/get/multiparams", method=RequestMethod.GET, produces="application/json")
	public MyParams testGetParamsAsObject(MyParams requestParams) {
		return requestParams;
	}

	@RequestMapping(value="/test/post/multiparams", method=RequestMethod.POST, produces="application/json")
	public MyParams testPostParamsAsObject(@RequestBody MyParams requestParams, HttpServletRequest request) {
		return requestParams;
	}


	@RequestMapping(value="/test/get/error", method=RequestMethod.GET, produces="application/json")
	public MyParams testErrorHandlerAdvice(MyParams requestParams) {
		if (true) {
			throw new GenericRestException("ERR1");
		}
		return requestParams;
	}
	
}
