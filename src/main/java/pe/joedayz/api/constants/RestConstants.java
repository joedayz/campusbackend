package pe.joedayz.api.constants;

import java.util.HashMap;
import java.util.Map;

public class RestConstants {

	public static String STATUS_OK = "OK";
	public static String STATUS_ERR = "ERR";

	public static String MSG_RESULT = "result";
	public static String MSG_STATUS = "status";

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Map SUCCESS_MSG(Object message) {
		Map result = new HashMap<>();
		result.put(MSG_STATUS, STATUS_OK);
		result.put(MSG_RESULT, message);
		return result;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Map ERROR_MSG(Object message) {
		Map result = new HashMap<>();
		result.put(MSG_STATUS, STATUS_ERR);
		result.put(MSG_RESULT, message);
		return result;
	}
}
