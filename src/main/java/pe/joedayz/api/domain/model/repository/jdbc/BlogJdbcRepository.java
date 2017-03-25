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

import pe.joedayz.api.dto.ArticuloDto;
import pe.joedayz.api.dto.HangoutDto;

@Repository
public class BlogJdbcRepository implements BlogCustomRepository {

	
	
	
	
	private static final Logger LOGGER = LoggerFactory.getLogger(BlogJdbcRepository.class);

	private final NamedParameterJdbcTemplate jdbcTemplate;
	
	@Autowired
	BlogJdbcRepository(NamedParameterJdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	private static final String SEARCH_ARTICULOS_DESTACADOS = "select b.blog_id as \"articuloId\",\n"
			+ "  b.titulo as \"titulo\",\n" + "  b.url as \"url\",\n" + "  b.descripcion as \"descripcion\",\n"
			+ "  b.fecha as \"fecha\",\n"
			+ "  b.status as \"status\",\n"
			+ "  b.autor as \"autor\"\n"
			+ " from blog b where b.status='A'"
			+ " order by b.titulo";

	
	
	@Override
	public List<ArticuloDto> getArticulosDestacados() {
		LOGGER.info("Finding articulos destacados");

		Map<String, String> queryParams = new HashMap<>();


        List<ArticuloDto> searchResults = jdbcTemplate.query(SEARCH_ARTICULOS_DESTACADOS,
                queryParams,
                new BeanPropertyRowMapper<>(ArticuloDto.class)
        );
        LOGGER.info("Found {} articulos destacados", searchResults.size());

        return searchResults;
	}

}
