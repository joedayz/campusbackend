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

        sql.append("select \n");
        sql.append(" us.user_id  as \"id\", \n");
        sql.append(" us.user_name  as \"name\", \n");
        sql.append(" us.first_name  as \"firstName\", \n");
        sql.append(" us.last_name  as \"lastName\", \n");
        sql.append(" us.status  as \"status\" \n");
        sql.append(" from users us \n" );
        sql.append(" where 1=1 ");
        sql.append(params.filter(" and upper(us.first_name) LIKE upper('%'|| :firstName ||'%') ",filter.getFirstName()));
        sql.append(params.filter(" and upper(us.last_name) LIKE upper('%'|| :lastName ||'%') ",filter.getLastName()));
        sql.append(params.filter(" and upper(us.user_name) LIKE upper('%'|| :userName ||'%') ",filter.getUserName()));


        LOG.info(sql.toString());
        return sql.toString();
    }

    private String generateConfirmPasswordQuery(String username, String password, WhereParams params){
        StringBuilder sql = new StringBuilder();
        sql.append("select \n");
        sql.append(" count(us.user_id) ");
        sql.append(" from users us \n" );
        sql.append(" where 1=1 ");
        sql.append(params.filter(" and us.user_name = :firstName  ",username));
        sql.append(params.filter(" and us.password = :password  ",password));

        return sql.toString();
    }

    private long calculateTotalRows(String queryBase, WhereParams params){
        String query = "SELECT COUNT(1) FROM (" + queryBase + ") X";
        return jdbcTemplate.queryForObject(query, params.getParams(), Long.class);
    }
}
