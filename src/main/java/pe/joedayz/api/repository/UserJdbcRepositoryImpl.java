package pe.joedayz.api.repository;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import pe.joedayz.api.domain.model.repository.jdbc.UserJdbcRepository;
import pe.joedayz.api.dto.UserFilterDto;
import pe.joedayz.api.dto.UserViewDto;
import pe.joedayz.api.support.ExtendedBeanPropertyRowMapper;
import pe.joedayz.api.support.PageableQuery;
import pe.joedayz.api.support.WhereParams;

@Repository
public class UserJdbcRepositoryImpl implements UserJdbcRepository{

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    DataSource dataSource;

    @PostConstruct
    public void init() {
        jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public long searchPageableTotalCount(UserFilterDto filter) {
        WhereParams params = new WhereParams();
        String sql = generateSearchQuery(filter,params);
        return calculateTotalRows(sql, params);
    }

    @Override
    public List<UserViewDto> searchPageable(UserFilterDto filter) {
        WhereParams params = new WhereParams();
        String sql = generateSearchQuery(filter,params);
        PageableQuery pageableQuery = new PageableQuery(filter);
        pageableQuery.addMainSection(sql);
        String query = pageableQuery.buildQuery();
          return jdbcTemplate.query(query,params.getParams(), new ExtendedBeanPropertyRowMapper<UserViewDto>(UserViewDto.class));
    }

    @Override
    public boolean validCurrentPassword(String username, String password) {
        WhereParams params = new WhereParams();
        String sql = generateConfirmPasswordQuery(username,password,params);
        Long valid = jdbcTemplate.queryForObject(sql,params.getParams(),Long.class);
        if(valid>0) return true;
        return false;
    }

    private String generateSearchQuery(UserFilterDto filter, WhereParams params){
        StringBuilder sql = new StringBuilder();

        sql.append("SELECT \n");
        sql.append(" US.USER_ID  AS \"id\", \n");
        sql.append(" US.USER_NAME  AS \"name\", \n");
        sql.append(" US.FIRST_NAME  AS \"firstName\", \n");
        sql.append(" US.LAST_NAME  AS \"lastName\", \n");
        sql.append(" US.STATUS  AS \"status\" \n");
        sql.append(" FROM USERS US \n" );
        sql.append(" WHERE 1=1 ");
        sql.append(params.filter(" AND upper(US.FIRST_NAME) LIKE upper('%'|| :firstName ||'%') ",filter.getFirstName()));
        sql.append(params.filter(" AND upper(US.LAST_NAME) LIKE upper('%'|| :lastName ||'%') ",filter.getLastName()));
        sql.append(params.filter(" AND upper(US.USER_NAME) LIKE upper('%'|| :userName ||'%') ",filter.getUserName()));
        

        LOG.info(sql.toString());
        return sql.toString();
    }

    private String generateConfirmPasswordQuery(String username, String password, WhereParams params){
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT \n");
        sql.append(" count(US.USER_ID) ");
        sql.append(" FROM USERS US \n" );
        sql.append(" WHERE 1=1 ");
        sql.append(params.filter(" AND US.USER_NAME = :firstName  ",username));
        sql.append(params.filter(" AND US.PASSWORD = :password  ",password));

        return sql.toString();
    }

    private long calculateTotalRows(String queryBase, WhereParams params){
        String query = "SELECT COUNT(1) FROM (" + queryBase + ") X";
        return jdbcTemplate.queryForObject(query, params.getParams(), Long.class);
    }
}
