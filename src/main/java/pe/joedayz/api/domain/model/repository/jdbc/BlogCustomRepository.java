package pe.joedayz.api.domain.model.repository.jdbc;

import java.util.List;

import pe.joedayz.api.dto.ArticuloDto;

public interface BlogCustomRepository {

	List<ArticuloDto> getArticulosDestacados();

}
