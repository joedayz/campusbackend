package pe.joedayz.api.service.intf;

import java.util.List;

import pe.joedayz.api.dto.CursoDto;

public interface CursoService {

	List<CursoDto> getCursosPresenciales();

	List<CursoDto> getCursosOnline();
	
	List<CursoDto> getVideoCursos();

	CursoDto getDatosCurso(String keyCurso);

	List<CursoDto> getCursosPresencialesDestacados();

	List<CursoDto> getCursosOnlineDestacados();
}
