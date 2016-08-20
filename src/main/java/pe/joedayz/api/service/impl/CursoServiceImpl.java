package pe.joedayz.api.service.impl;

import java.util.List;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.joedayz.api.domain.model.repository.jdbc.CursoCustomRepository;
import pe.joedayz.api.dto.CursoDto;
import pe.joedayz.api.enums.TipoCursoEnum;
import pe.joedayz.api.service.intf.CursoService;

@Service
public class CursoServiceImpl implements CursoService {
	
	@Autowired
	Mapper mapper;

	@Autowired
	CursoCustomRepository cursoCustomRepository;


	@Override
	public List<CursoDto> getCursosPresenciales() {
		
		return cursoCustomRepository.findCursosByCode(TipoCursoEnum.PRESENCIAL.getCode());
	}
	
	@Override
	public List<CursoDto> getCursosOnline() {
		
		return cursoCustomRepository.findCursosByCode(TipoCursoEnum.ONLINE.getCode());
	}
	
	@Override
	public List<CursoDto> getVideoCursos() {
		return cursoCustomRepository.findCursosByCode(TipoCursoEnum.VIDEO_CURSO.getCode());
	}	

	
	@Override
	public CursoDto getDatosCurso(String keyCurso) {
		return cursoCustomRepository.getDatosCurso(keyCurso);
	}

	@Override
	public List<CursoDto> getCursosPresencialesDestacados() {
		return cursoCustomRepository.findCursosDestacados(TipoCursoEnum.PRESENCIAL.getCode());
	}

	@Override
	public List<CursoDto> getCursosOnlineDestacados() {
		return cursoCustomRepository.findCursosDestacados(TipoCursoEnum.ONLINE.getCode());
	}


}
