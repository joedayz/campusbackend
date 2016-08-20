package pe.joedayz.api.domain.model.repository.jdbc;

import java.util.List;

import pe.joedayz.api.dto.CursoDto;

public interface CursoCustomRepository {

	
	List<CursoDto> findCursosByCode(String code) ;

	CursoDto getDatosCurso(String keyCurso);

	List<CursoDto> findCursosDestacados(String code);
	

}
