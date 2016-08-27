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
		sql.append(" SELECT ");
		sql.append("  GT.GENERAL_TABLE_ID generalTableId, ");
		sql.append("  GT.TABLE_NAME tableName, ");
		sql.append("  GT.CODE code, ");
		sql.append("  GT.VALUE \"value\", ");
		sql.append("  GT.SORT_ORDER sortOrder, ");	
		sql.append("  ES.VALUE status ");
		sql.append(" FROM GENERAL_TABLE GT ");	
		sql.append(" LEFT OUTER JOIN GENERAL_TABLE ES ON GT.STATUS=ES.CODE AND ES.TABLE_NAME='").append(StatusEnum.class.getTypeName()).append("' ");	
		sql.append(" WHERE 1 = 1 ");
		sql.append(params.filter(" AND GT.TABLE_NAME = :tableName ", filter.getGroup()));
		sql.append(params.filter(" AND UPPER(GT.CODE) LIKE UPPER(:code || '%') ", filter.getCode()));
		return sql.toString();
	}
	
	private String generateGeneralTableSearchQueryCodeUnique(GeneralTableFilterDto filter, WhereParams params) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * ");		
		sql.append(" FROM GENERAL_TABLE GT ");			
		sql.append("    WHERE 1 = 1 ");
		sql.append(params.filter(" AND GT.TABLE_NAME = :group ", filter.getGroup()));
		sql.append(params.filter(" AND GT.CODE = :code ", filter.getCode()));
		sql.append(params.filter(" AND GT.GENERAL_TABLE_ID != :toValidateNotId   ",filter.getValidateNotGeneralTableId()));
		return sql.toString();
	}
	
	private String generateGeneralTableFindByGroupQuery() {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");
		sql.append("  GT.TABLE_NAME \"value\", ");		
		sql.append("  GT.TABLE_NAME code ");	
		sql.append(" FROM GENERAL_TABLE GT ");			
		sql.append(" GROUP BY GT.TABLE_NAME ");
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
