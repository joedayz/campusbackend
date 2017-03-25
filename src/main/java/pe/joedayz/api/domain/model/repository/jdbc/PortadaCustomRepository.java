package pe.joedayz.api.domain.model.repository.jdbc;

import java.util.List;

import pe.joedayz.api.dto.PortadaDto;

public interface PortadaCustomRepository {

    List<PortadaDto> getFotosPrincipalesDelHome();
}
