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
		sql.append("select p.parameter_id parameterId, ");
		sql.append("  p.code code, ");
		sql.append("  p.description description, ");
		sql.append("  p.value value, ");
		sql.append("  es.value status ");
		sql.append(" from parameter p ");
		sql.append(" inner join general_table es on p.status=es.code and es.table_name='").append(StatusEnum.class.getTypeName()).append("' ");
		sql.append("    where 1 = 1 ");
		sql.append(params.filter(" and upper(p.code) like upper('%'||:code || '%') ", filter.getCode()));
		sql.append(params.filter(" and upper(p.description) like upper('%'||:description || '%') ", filter.getDescription()));
		
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
