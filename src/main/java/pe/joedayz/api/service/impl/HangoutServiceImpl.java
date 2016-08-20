package pe.joedayz.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.joedayz.api.domain.model.repository.jdbc.HangoutCustomRepository;
import pe.joedayz.api.dto.HangoutDto;
import pe.joedayz.api.service.intf.HangoutService;

@Service
public class HangoutServiceImpl implements HangoutService {
	
	@Autowired
	HangoutCustomRepository hangoutCustomRepository;

	@Override
	public List<HangoutDto> getHangoutsDestacados() {
		return hangoutCustomRepository.getHangoutsDestacados();
	}

}
