package pe.joedayz.api.service.intf;

import pe.joedayz.api.domain.model.entities.Parameter;

public interface ParamService {

    Parameter getByCode(String code);
}
