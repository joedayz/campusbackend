package pe.joedayz.api.domain.model.repository.jdbc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import pe.joedayz.api.dto.HangoutDto;

@Repository
public class HangoutJdbcRepository implements HangoutCustomRepository {

	
	
	private static final Logger LOGGER = LoggerFactory.getLogger(HangoutJdbcRepository.class);

	private final NamedParameterJdbcTemplate jdbcTemplate;
	
	@Autowired
	HangoutJdbcRepository(NamedParameterJdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	
	private static final String SEARCH_HANGOUTS_DESTACADOS = "select h.hangout_id as \"hangoutId\",\n"
			+ "  h.titulo as \"titulo\",\n" + "  h.url as \"url\",\n" + "  h.descripcion as \"descripcion\",\n"
			+ "  h.fecha as \"fecha\",\n"
			+ "  h.status as \"status\",\n"
			+ "  h.ponente as \"ponente\"\n"
			+ " from hangout h where h.status='A'"
			+ " order by h.titulo";


	@Override
	public List<HangoutDto> getHangoutsDestacados() {
		LOGGER.info("Finding hangouts destacados");

		Map<String, String> queryParams = new HashMap<>();


        List<HangoutDto> searchResults = jdbcTemplate.query(SEARCH_HANGOUTS_DESTACADOS,
                queryParams,
                new BeanPropertyRowMapper<>(HangoutDto.class)
        );
        LOGGER.info("Found {} hangouts destacados", searchResults.size());

        return searchResults;
	}

}
