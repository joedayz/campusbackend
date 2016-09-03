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
		sql.append("select ");
		sql.append("  m1.module_id moduleId, ");
		sql.append("  m1.code code, ");
		sql.append("  m1.name name, ");
		sql.append("  m1.menu_label menuLabel, ");
		sql.append("  m1.menu_order menuOrder, ");
		sql.append("  es.value visible, ");
		sql.append("  m2.name parentName ");
		sql.append(" from module m1 ");
		sql.append(" left outer join  module m2 on  m1.parent_module_id = m2.module_id ");
		sql.append(" left outer join  general_table es on m1.visible=es.code and es.table_name='").append(YesNoEnum.class.getTypeName()).append("' ");
		sql.append("    where 1 = 1 ");
		sql.append(params.filter(" and upper(m1.code) like upper('%' ||:code || '%') ", filter.getCode()));
		sql.append(params.filter(" and upper(m1.name) like upper('%' ||:name || '%') ", filter.getName()));
		sql.append(params.filter(" and upper(m2.name) like upper('%' ||:parentName || '%') ", filter.getParentName()));
		LOGGER.info("generateModuleSearchQuery --> "+sql.toString());
		return sql.toString();
	}
	
	private String generateModuleFindQuery(Long moduleId, WhereParams params) {
		StringBuilder sql = new StringBuilder();
		sql.append("select ");
		sql.append("  m.module_id moduleId, ");
		sql.append("  m.code code, ");
		sql.append("  m.name name, ");
		sql.append("  m.menu_label menuLabel, ");
		sql.append("  m.menu_order menuOrder, ");
		sql.append("  m.url url, ");
		sql.append("  m.help_url helpUrl, ");
		sql.append("  m.visible visible, ");
		sql.append("  m.parent_module_id parentModuleId, ");
		sql.append("  m.created_by createdBy, ");
		sql.append("  m.created_date createdDate, ");
		sql.append("  m.updated_by updatedBy, ");
		sql.append("  m.updated_date updatedDate, ");
		sql.append("  m.row_version rowVersion ");
		sql.append(" from module m ");
		sql.append("    where 1 = 1 ");
		sql.append(params.filter(" and m.module_id =:moduleId ", moduleId));
		LOGGER.info("generateModuleFindQuery --> "+sql.toString());
		return sql.toString();
	}
	
	private String generateModulesFindExceptItselfQuery(Long moduleId, WhereParams params) {
		StringBuilder sql = new StringBuilder();
		sql.append("select ");
		sql.append("  m.module_id moduleId, ");
		sql.append("  m.name name ");
		sql.append(" from module m ");
		sql.append("    where 1 = 1 ");
		sql.append(params.filter(" and m.module_id !=:moduleId ", moduleId));
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
