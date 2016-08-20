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
import org.springframework.transaction.annotation.Transactional;

import pe.joedayz.api.dto.UserDto;
import pe.joedayz.api.support.WhereParams;

/**
 * Created by JVergara on 12/05/2016.
 */
@Repository
public class UsersJdbcRepository implements UsersCustomRepository {
    private static final Logger LOGGER = LoggerFactory.getLogger(UsersJdbcRepository.class);

    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    UsersJdbcRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static final String SEARCH_USER =
            "select  \n" +
                    "  user_id as \"id\",\n" +
                    "  user_name as \"userName\",\n" +
                    "  password as \"password\",\n" +
                    "  first_name as \"firstName\",\n" +
                    "  status as \"status\",\n" +
                    "  last_name as \"lastName\" " +
                    " from users " +
                    " where user_name = :userName";

    @Transactional(readOnly = true)
    @Override
    public UserDto findByUserName(String userName) {
        LOGGER.info("Finding users for authentication ", userName);

        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("userName", userName);

        List<UserDto> searchResults = jdbcTemplate.query(SEARCH_USER,
                queryParams,
                new BeanPropertyRowMapper<>(UserDto.class)
        );

        LOGGER.info("Found user {}", searchResults);

        if (searchResults.size() > 0) {
            return searchResults.get(0);
        }

        return null;
    }


    @Transactional(readOnly = true)
    @Override
    public List<UserDto> findUsersByName(String name) {

        StringBuilder query= new StringBuilder();

        WhereParams params = new WhereParams();

        query.append(" select ");
        query.append(" user_id as \"id\", ");
        query.append(" first_name, ");
        query.append(" last_name, ");
        query.append(" user_name, ");
        query.append(" first_name || ' '||last_name as \"fullName\" ");
        query.append(" from users ");
        query.append(" where 1=1");

        query.append(params.filter(" and lower(first_name || ' '||last_name) LIKE '%'|| :firstName ||'%' ", name));



        return jdbcTemplate.query(query.toString(), params.getParams(), new BeanPropertyRowMapper<UserDto>(UserDto.class));

//        LOGGER.info("Found user {}", searchResults);

//        return searchResults;
    }
}
