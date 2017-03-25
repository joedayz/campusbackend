package pe.joedayz.api.service.intf;

import pe.joedayz.api.dto.ParameterDto;

public interface ParameterService {

	Long createParameter(ParameterDto value);
	ParameterDto searchUniqueParameter(Long vendorId);

	
}
