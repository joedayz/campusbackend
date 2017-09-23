package pe.joedayz.api.repository;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import pe.joedayz.api.domain.model.repository.GeneralTableJdbcRepository;
import pe.joedayz.api.dto.GeneralTableDto;
import pe.joedayz.api.dto.GeneralTableFilterDto;
import pe.joedayz.api.dto.GeneralTableViewRsl;
import pe.joedayz.api.enums.StatusEnum;
import pe.joedayz.api.support.PageableQuery;
import pe.joedayz.api.support.WhereParams;

@Repository
public class GeneralTableJdbcRepositoryImpl implements GeneralTableJdbcRepository {

	@Autowired
	DataSource dataSource;

	private NamedParameterJdbcTemplate jdbcTemplate;

	@PostConstruct
	public void init() {
		jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	private String generateGeneralTableSearchQuery(GeneralTableFilterDto filter, WhereParams params) {
		StringBuilder sql = new StringBuilder();
		sql.append(" select ");
		sql.append("  gt.general_table_id generalTableId, ");
		sql.append("  gt.table_name tableName, ");
		sql.append("  gt.code code, ");
		sql.append("  gt.value \"value\", ");
		sql.append("  gt.sort_order sortOrder, ");
		sql.append("  es.value status ");
		sql.append(" from general_table gt ");
		sql.append(" left outer join general_table es on gt.status=es.code and es.table_name='").append(StatusEnum.class.getTypeName()).append("' ");
		sql.append(" where 1 = 1 ");
		sql.append(params.filter(" and gt.table_name = :tableName ", filter.getGroup()));
		sql.append(params.filter(" and upper(gt.code) like upper(:code || '%') ", filter.getCode()));
		return sql.toString();
	}
	
	private String generateGeneralTableSearchQueryCodeUnique(GeneralTableFilterDto filter, WhereParams params) {
		StringBuilder sql = new StringBuilder();
		sql.append("select * ");
		sql.append(" from general_table gt ");
		sql.append("    where 1 = 1 ");
		sql.append(params.filter(" and gt.table_name = :group ", filter.getGroup()));
		sql.append(params.filter(" and gt.code = :code ", filter.getCode()));
		sql.append(params.filter(" and gt.general_table_id != :toValidateNotId   ",filter.getValidateNotGeneralTableId()));
		return sql.toString();
	}
	
	private String generateGeneralTableFindByGroupQuery() {
		StringBuilder sql = new StringBuilder();
		sql.append(" select ");
		sql.append("  gt.table_name \"value\", ");
		sql.append("  gt.table_name code ");
		sql.append(" from general_table gt ");
		sql.append(" group by gt.table_name ");
		return sql.toString();
	}
	
	@Override
	public long searchGeneralTablePageableTotalCount(GeneralTableFilterDto filter) {
		WhereParams params = new WhereParams();
		String sql = generateGeneralTableSearchQuery(filter, params);
		return calculateTotalRows(sql, params);
		
	}

	@Override
	public List<GeneralTableViewRsl> searchGeneralTable(GeneralTableFilterDto filter, String paginable) {
		WhereParams params = new WhereParams();
		String sql = generateGeneralTableSearchQuery(filter, params);
		String query = "";
		if ("T".equals(paginable)) {
			PageableQuery pageableQuery = new PageableQuery(filter);
			pageableQuery.addMainSection(sql);
			query = pageableQuery.buildQuery();
		} else {
			query = sql;

		}
		return jdbcTemplate.query(query, params.getParams(), new BeanPropertyRowMapper<GeneralTableViewRsl>(GeneralTableViewRsl.class));

	}
	
	private long calculateTotalRows(String queryBase, WhereParams params) {
		String query = "SELECT COUNT(1) FROM (" + queryBase + ") X";
		return jdbcTemplate.queryForObject(query, params.getParams(), Long.class);
	}

	@Override
	public long generateGeneralTableSearchQueryCodeUniqueTotalCount(GeneralTableFilterDto filter) {
		WhereParams params = new WhereParams();
		String sql = generateGeneralTableSearchQueryCodeUnique(filter, params);
		return calculateTotalRows(sql, params);
	}

	@Override
	public List<GeneralTableDto> findGeneralTableByGroup() {
		String sql = generateGeneralTableFindByGroupQuery();
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<GeneralTableDto>(GeneralTableDto.class) );
	}
	
}
