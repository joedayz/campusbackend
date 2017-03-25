package pe.joedayz.api.service.impl;

import java.util.List;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.joedayz.api.domain.model.repository.jdbc.TemasCursoCustomRepository;
import pe.joedayz.api.dto.TemasCursoDto;

@Service
public class TemasCursoServiceImpl {

	@Autowired
	Mapper mapper;

	@Autowired
	TemasCursoCustomRepository temasCursoCustomRepository;


	public List<TemasCursoDto> getTemasCursoByKey(String keyCurso) {
		List<TemasCursoDto> temasCursos = temasCursoCustomRepository.findTemasCursoByKey(keyCurso);
		return temasCursos;
	}
}
