package pe.joedayz.api.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import java.util.List;
import java.util.Objects;

import pe.joedayz.api.domain.model.repository.ModuleJdbcRepository;
import pe.joedayz.api.dto.ModuleFilterDto;
import pe.joedayz.api.dto.ModuleViewDto;
import pe.joedayz.api.dto.ModuleViewRsl;
import pe.joedayz.api.enums.YesNoEnum;
import pe.joedayz.api.support.PageableQuery;
import pe.joedayz.api.support.WhereParams;

@Repository
public class ModuleJdbcRepositoryImpl implements ModuleJdbcRepository {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ModuleJdbcRepositoryImpl.class);

	@Autowired
	DataSource dataSource;

	private NamedParameterJdbcTemplate jdbcTemplate;

	@PostConstruct
	public void init() {
		jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	private String generateModuleSearchQuery(ModuleFilterDto filter, WhereParams params) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT ");
		sql.append("  M1.MODULE_ID moduleId, ");
		sql.append("  M1.CODE code, ");
		sql.append("  M1.NAME name, ");		
		sql.append("  M1.MENU_LABEL menuLabel, ");		
		sql.append("  M1.MENU_ORDER menuOrder, ");
		sql.append("  ES.VALUE visible, ");
		sql.append("  M2.NAME parentName ");
		sql.append(" FROM MODULE M1 ");	
		sql.append(" LEFT OUTER JOIN  MODULE M2 ON M1.PARENT_MODULE_ID = M2.MODULE_ID ");
		sql.append(" LEFT OUTER JOIN  GENERAL_TABLE ES ON M1.VISIBLE=ES.CODE AND ES.TABLE_NAME='").append(YesNoEnum.class.getTypeName()).append("' ");
		sql.append("    WHERE 1 = 1 ");		
		sql.append(params.filter(" AND UPPER(M1.CODE) LIKE UPPER('%' ||:code || '%') ", filter.getCode()));
		sql.append(params.filter(" AND UPPER(M1.NAME) LIKE UPPER('%' ||:name || '%') ", filter.getName()));
		sql.append(params.filter(" AND UPPER(M2.NAME) LIKE UPPER('%' ||:parentName || '%') ", filter.getParentName()));
		LOGGER.info("generateModuleSearchQuery --> "+sql.toString());
		return sql.toString();
	}
	
	private String generateModuleFindQuery(Long moduleId, WhereParams params) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT ");
		sql.append("  M.MODULE_ID moduleId, ");
		sql.append("  M.CODE code, ");
		sql.append("  M.NAME name, ");		
		sql.append("  M.MENU_LABEL menuLabel, ");		
		sql.append("  M.MENU_ORDER menuOrder, ");
		sql.append("  M.URL url, ");
		sql.append("  M.HELP_URL helpUrl, ");
		sql.append("  M.VISIBLE visible, ");
		sql.append("  M.PARENT_MODULE_ID parentModuleId, ");
		sql.append("  M.CREATED_BY createdBy, ");
		sql.append("  M.CREATED_DATE createdDate, ");
		sql.append("  M.UPDATED_BY updatedBy, ");
		sql.append("  M.UPDATED_DATE updatedDate, ");
		sql.append("  M.ROW_VERSION rowVersion ");
		sql.append(" FROM MODULE M ");	
		sql.append("    WHERE 1 = 1 ");		
		sql.append(params.filter(" AND M.MODULE_ID =:moduleId ", moduleId));
		LOGGER.info("generateModuleFindQuery --> "+sql.toString());
		return sql.toString();
	}
	
	private String generateModulesFindExceptItselfQuery(Long moduleId, WhereParams params) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT ");
		sql.append("  M.MODULE_ID moduleId, ");
		sql.append("  M.NAME name ");
		sql.append(" FROM MODULE M ");	
		sql.append("    WHERE 1 = 1 ");		
		sql.append(params.filter(" AND M.MODULE_ID !=:moduleId ", moduleId));
		LOGGER.info("generateModuleFindQuery --> "+sql.toString());
		return sql.toString();
	}

	@Override
	public List<ModuleViewRsl> searchModule(ModuleFilterDto filter, String paginable) {

		WhereParams params = new WhereParams();
		String sql = generateModuleSearchQuery(filter, params);
		String query = "";
		if (Objects.equals(paginable, "T")) {
			PageableQuery pageableQuery = new PageableQuery(filter);
			pageableQuery.addMainSection(sql);
			query = pageableQuery.buildQuery();
		} else {
			query = sql;
		}		
		return jdbcTemplate.query(query, params.getParams(),
				new BeanPropertyRowMapper<ModuleViewRsl>(ModuleViewRsl.class));
	}

	@Override
	public long searchModulePageableTotalCount(ModuleFilterDto filter) {
		WhereParams params = new WhereParams();
		String sql = generateModuleSearchQuery(filter, params);
		
		return calculateTotalRows(sql, params);
	}

	private long calculateTotalRows(String queryBase, WhereParams params) {
		String query = "SELECT COUNT(1) FROM (" + queryBase + ") X";
		return jdbcTemplate.queryForObject(query, params.getParams(), Long.class);
	}

	@Override
	public ModuleViewDto findModuleById(Long moduleId) {
		
		WhereParams params = new WhereParams();
        String sql = generateModuleFindQuery(moduleId, params);
        List<ModuleViewDto> searchResults = jdbcTemplate.query(sql,params.getParams(), new BeanPropertyRowMapper<ModuleViewDto>(ModuleViewDto.class));

        LOGGER.info("Found module {}", searchResults);

        if (searchResults.size() > 0) {
            return searchResults.get(0);
        }

        return null;
	}

	@Override
	public List<ModuleViewDto> searchModulesExceptItself(String query, Long moduleId) {
		WhereParams params = new WhereParams();
        String sql = generateModulesFindExceptItselfQuery(moduleId, params);
        List<ModuleViewDto> searchResults = jdbcTemplate.query(sql,params.getParams(), new BeanPropertyRowMapper<ModuleViewDto>(ModuleViewDto.class));
		return searchResults;
	}

}
