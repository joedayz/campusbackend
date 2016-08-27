package pe.joedayz.api.repository;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import pe.joedayz.api.domain.model.repository.RoleJdbcRepository;
import pe.joedayz.api.dto.RoleFilterDto;
import pe.joedayz.api.dto.RoleViewDto;
import pe.joedayz.api.enums.ActiveInactiveStatusEnum;
import pe.joedayz.api.support.ExtendedBeanPropertyRowMapper;
import pe.joedayz.api.support.PageableQuery;
import pe.joedayz.api.support.WhereParams;

@Repository
public class RoleJdbcRepositoryImpl implements RoleJdbcRepository {

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    DataSource dataSource;

    @PostConstruct
    public void init() {
        jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }



    @Override
    public List<RoleViewDto> searchRoleList() {

        WhereParams params = new WhereParams();
        String sql = generatRoleSearchListQuery(null,params);
        return jdbcTemplate.query(sql, params.getParams(), new ExtendedBeanPropertyRowMapper<RoleViewDto>(RoleViewDto.class) );
    }

    @Override
    public Long searchRampAreaPageableTotalCount(RoleFilterDto filter) {

        WhereParams params = new WhereParams();
        String sql = generatRoleSearchListQuery(filter.getRoleName(), params);
        return calculateTotalRows(sql, params);

    }

    private long calculateTotalRows(String queryBase, WhereParams params) {
        String query = "SELECT COUNT(1) FROM (" + queryBase + ") X";
        return jdbcTemplate.queryForObject(query, params.getParams(), Long.class);
    }


    @Override
    public List<RoleViewDto> searchRampAreaPageable(RoleFilterDto filter) {


        WhereParams params = new WhereParams();
        String sql = generatRoleSearchListQuery(filter.getRoleName(), params);

        PageableQuery pageableQuery = new PageableQuery(filter);

        pageableQuery.addMainSection(sql);

        String query = pageableQuery.buildQuery();

        return jdbcTemplate.query(query, params.getParams(), new ExtendedBeanPropertyRowMapper<RoleViewDto>(RoleViewDto.class));
    }

    private String generatRoleSearchListQuery(String name, WhereParams params) {

        StringBuilder sql = new StringBuilder();

        sql.append(" SELECT ");
        sql.append(" R.ROLE_ID \"roleId\", ");
        sql.append(" R.CODE \"roleCode\", ");
        sql.append(" R.ROLE_NAME \"roleName\", ");
        sql.append(" ( CASE WHEN R.CODE IN ('ADMIN','PRIAN','PRIMA','SAACM') THEN 'N' " +
                   "   ELSE 'Y'  END) \"isDeleteRole\", ");
        sql.append("  'Y'   \"isUpdateRole\", ");
        sql.append(" ( CASE WHEN R.CODE IN ('PRIAN','PRIMA','SAACM') THEN 'N' " +
                "   ELSE 'Y'  END) \"isEditCode\", ");


        sql.append(" STATUS.VALUE \"roleStatus\" ");

        sql.append(" FROM ");
        sql.append(" ROLE R ");
        sql.append(" LEFT JOIN GENERAL_TABLE STATUS ON STATUS.CODE=R.STATUS AND STATUS.TABLE_NAME='").append(ActiveInactiveStatusEnum.class.getTypeName()).append("'  \n");

        sql.append(" WHERE 1=1 ");

        sql.append(params.filter(" AND UPPER(R.ROLE_NAME)  LIKE upper('%'|| :rname ||'%')  ",name));
        sql.append(" order By  R.ROLE_ID ");
        return sql.toString();
    }

}
