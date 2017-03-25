package pe.joedayz.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.joedayz.api.domain.model.repository.jdbc.BlogCustomRepository;
import pe.joedayz.api.domain.model.repository.jdbc.HangoutCustomRepository;
import pe.joedayz.api.dto.ArticuloDto;
import pe.joedayz.api.service.intf.BlogService;

@Service
public class BlogServiceImpl implements BlogService{
	
	
	
	@Autowired
	BlogCustomRepository blogCustomRepository;

	@Override
	public List<ArticuloDto> getArticulosDestacados() {
		return blogCustomRepository.getArticulosDestacados();
	}

}
