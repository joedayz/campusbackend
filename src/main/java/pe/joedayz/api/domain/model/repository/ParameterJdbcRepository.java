package pe.joedayz.api.domain.model.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import pe.joedayz.api.dto.ParameterFilterDto;
import pe.joedayz.api.dto.ParameterViewRsl;

@Repository
public interface ParameterJdbcRepository {
	
	 long searchParameterPageableTotalCount(ParameterFilterDto filter);

	 List<ParameterViewRsl> searchParameter(ParameterFilterDto filter, String paginable);

}
