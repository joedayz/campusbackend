package pe.joedayz.api.repository;

import java.util.List;
import java.util.Objects;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import pe.joedayz.api.domain.model.repository.ParameterJdbcRepository;
import pe.joedayz.api.dto.ParameterFilterDto;
import pe.joedayz.api.dto.ParameterViewRsl;
import pe.joedayz.api.enums.StatusEnum;
import pe.joedayz.api.support.PageableQuery;
import pe.joedayz.api.support.WhereParams;

@Repository
public class ParameterJdbcRepositoryImpl implements ParameterJdbcRepository {

	private static final Logger LOGGER = LoggerFactory.getLogger(ParameterJdbcRepositoryImpl.class);

	@Autowired
	DataSource dataSource;

	private NamedParameterJdbcTemplate jdbcTemplate;

	@PostConstruct
	public void init() {
		jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	private String generateParameterSearchQuery(ParameterFilterDto filter, WhereParams params) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT P.PARAMETER_ID parameterId, ");
		sql.append("  P.CODE code, ");
		sql.append("  P.DESCRIPTION description, ");
		sql.append("  P.VALUE value, ");
		sql.append("  ES.VALUE status ");
		sql.append(" FROM PARAMETER P ");
		sql.append(" INNER JOIN GENERAL_TABLE ES ON P.STATUS=ES.CODE AND ES.TABLE_NAME='").append(StatusEnum.class.getTypeName()).append("' ");		
		sql.append("    WHERE 1 = 1 ");
		sql.append(params.filter(" AND UPPER(P.CODE) LIKE UPPER('%'||:code || '%') ", filter.getCode()));
		sql.append(params.filter(" AND UPPER(P.DESCRIPTION) LIKE UPPER('%'||:description || '%') ", filter.getDescription()));
		
		LOGGER.info("generateParameterSearchQuery --> " + sql.toString());
		
		return sql.toString();
	}

	@Override
	public List<ParameterViewRsl> searchParameter(ParameterFilterDto filter, String paginable) {

		WhereParams params = new WhereParams();
		String sql = generateParameterSearchQuery(filter, params);
		String query = "";
		if (Objects.equals(paginable, "T")) {
			PageableQuery pageableQuery = new PageableQuery(filter);
			pageableQuery.addMainSection(sql);
			query = pageableQuery.buildQuery();
		} else {
			query = sql;
		}		
		return jdbcTemplate.query(query, params.getParams(),
				new BeanPropertyRowMapper<ParameterViewRsl>(ParameterViewRsl.class));
	}

	@Override
	public long searchParameterPageableTotalCount(ParameterFilterDto filter) {
		WhereParams params = new WhereParams();
		String sql = generateParameterSearchQuery(filter, params);
		return calculateTotalRows(sql, params);
	}

	private long calculateTotalRows(String queryBase, WhereParams params) {
		String query = "SELECT COUNT(1) FROM (" + queryBase + ") X";
		return jdbcTemplate.queryForObject(query, params.getParams(), Long.class);
	}

}
