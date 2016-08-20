package pe.joedayz.api.domain.model.repository.jdbc;

import java.util.List;

import pe.joedayz.api.dto.HangoutDto;

public interface HangoutCustomRepository {

	List<HangoutDto> getHangoutsDestacados();

}
