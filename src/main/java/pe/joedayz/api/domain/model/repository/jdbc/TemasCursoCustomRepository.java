package pe.joedayz.api.domain.model.repository.jdbc;

import java.util.List;

import pe.joedayz.api.dto.TemasCursoDto;

public interface TemasCursoCustomRepository {

	List<TemasCursoDto> findTemasCursoByKey(String keyCurso) ;
	

 
}
