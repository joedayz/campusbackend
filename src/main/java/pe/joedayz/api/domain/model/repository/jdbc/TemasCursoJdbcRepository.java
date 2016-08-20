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

import pe.joedayz.api.dto.TemasCursoDto;

@Repository
public class TemasCursoJdbcRepository implements TemasCursoCustomRepository {

	private static final Logger LOGGER = LoggerFactory.getLogger(TemasCursoJdbcRepository.class);

	private final NamedParameterJdbcTemplate jdbcTemplate;

	@Autowired
	TemasCursoJdbcRepository(NamedParameterJdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	private static final String SEARCH_TEMAS_PER_KEY = "select tc.temas_curso_id as \"temasCursoId\",\n"
			+ "  tc.titulo as \"titulo\",\n" + "  tc.descripcion as \"descripcion\",\n" + "  tc.url as \"url\",\n"
			+ "  tc.status as \"status\",\n" 
			+ "  tc.tema_orden as \"temaOrden\",\n" + "  tc.curso_id as \"cursoId\"\n"
			+ "from temas_curso tc inner join curso c on tc.curso_id = c.curso_id and c.key_curso = :keyCurso ";

	@Transactional(readOnly = true)
	@Override
	public List<TemasCursoDto> findTemasCursoByKey(String keyCurso) {
		LOGGER.info("Finding temas por curso con Key: {}", keyCurso);

		Map<String, String> queryParams = new HashMap<>();
		queryParams.put("keyCurso", keyCurso);

        List<TemasCursoDto> searchResults = jdbcTemplate.query(SEARCH_TEMAS_PER_KEY,
                queryParams,
                new BeanPropertyRowMapper<>(TemasCursoDto.class)
        );
        LOGGER.info("Found {} temas curso entries", searchResults.size());

        return searchResults;
	}



}
