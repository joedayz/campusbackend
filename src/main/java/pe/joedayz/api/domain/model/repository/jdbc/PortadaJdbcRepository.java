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
import org.springframework.transaction.annotation.Transactional;

import pe.joedayz.api.dto.PortadaDto;

@Repository
public class PortadaJdbcRepository implements PortadaCustomRepository {

	
	private static final Logger LOGGER = LoggerFactory.getLogger(TemasCursoJdbcRepository.class);

	private final NamedParameterJdbcTemplate jdbcTemplate;

	@Autowired
	PortadaJdbcRepository(NamedParameterJdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	
	
	

	private static final String SEARCH_FOTOS_PORTADA = "select p.portada_id as \"portadaId\",\n"
			+ "  p.titulo_foto as \"tituloFoto\",\n" + "  p.descripcion_foto as \"descripcionFoto\",\n" + "  p.url_foto as \"urlFoto\",\n"
			+ "  p.status as \"status\"\n" 
			+ "from portada p";

	@Transactional(readOnly = true)
	@Override
	public List<PortadaDto> getFotosPrincipalesDelHome() {
		LOGGER.info("Finding fotos de portada...");

		Map<String, String> queryParams = new HashMap<>();

        List<PortadaDto> searchResults = jdbcTemplate.query(SEARCH_FOTOS_PORTADA,
        		queryParams,
                new BeanPropertyRowMapper<>(PortadaDto.class)
        );
        LOGGER.info("Found {} fotos de portada", searchResults.size());

        return searchResults;
	}


}
