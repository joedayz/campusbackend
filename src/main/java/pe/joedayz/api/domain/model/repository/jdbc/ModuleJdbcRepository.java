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

import pe.joedayz.api.dto.ModuleParentDto;
import pe.joedayz.api.dto.ModuleViewDto;


@Repository
public class ModuleJdbcRepository implements ModuleCustomRepository {
    private static final Logger LOGGER = LoggerFactory.getLogger(ModuleJdbcRepository.class);

    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    ModuleJdbcRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static final String SEARCH_MODULES_VISIBLE_PER_USER = "select \n" +
            "  modprt.code as \"parentCode\", modprt.name as \"parentName\",\n" +
            "  m.module_id AS \"moduleId\", \n" +
            "  m.code AS \"code\",\n" +
            "  m.help_url AS \"helpUrl\",\n" +
            "  m.menu_label AS \"menuLabel\",\n" +
            "  m.name AS \"name\",\n" +
            "  m.url AS \"url\",\n" +
            "  p.permission_type as \"permissionType\" \n" +
            "from module m\n" +
            "inner join module modprt on m.parent_module_id = modprt.module_id\n" +
            "inner join permission p on p.module_id = m.module_id\n" +
            "inner join role r on r.role_id = p.role_id\n" +
            "inner join user_role ur on ur.role_id = r.role_id\n" +
            "inner join users u on u.user_id = ur.user_id\n" +
            "where 1=1\n" +
            "and modprt.visible = 'Y'\n" +
            "and m.visible = 'Y'\n" +
            "and p.permission_type != 'N'\n" +
            "and u.user_name = :userName \n" +
            "order by modprt.menu_order, modprt.code, m.menu_order";

    private static final String SEARCH_MODULES_PER_USER = "select \n" +
            "  modprt.code as \"parentCode\", modprt.name as \"parentName\",\n" +
            "  m.module_id as \"moduleId\", \n" +
            "  m.code as \"code\",\n" +
            "  m.help_url as \"helpUrl\",\n" +
            "  m.menu_label as \"menuLabel\",\n" +
            "  m.name as \"name\",\n" +
            "  m.url as \"url\",\n" +
            "  p.permission_type as \"permissionType\" \n" +
            "from module m\n" +
            "inner join module modprt on m.parent_module_id = modprt.module_id\n" +
            "inner join permission p on p.module_id = m.module_id\n" +
            "inner join role r on r.role_id = p.role_id\n" +
            "inner join user_role ur on ur.role_id = r.role_id\n" +
            "inner join users u on u.user_id = ur.user_id\n" +
            "where 1=1\n" +
            //"and modprt.visible = 'Y'\n" +
            //"and m.visible = 'Y'\n" +
            "and p.permission_type != 'N'\n" +
            "and u.user_name = :userName \n" +
            "order by modprt.menu_order, modprt.code, m.menu_order";


    private static final String SEARCH_PERMISSION_MODULES_PER_USER = "select \n" +
            "  modprt.code as \"parentCode\", modprt.name as \"parentName\",\n" +
            "  m.module_id AS \"moduleId\", \n" +
            "  m.code AS \"code\",\n" +
            "  m.help_url AS \"helpUrl\",\n" +
            "  m.menu_label AS \"menuLabel\",\n" +
            "  m.name AS \"name\",\n" +
            "  m.url AS \"url\",\n" +
            "  m.visible AS \"visible\",\n" +
            "  p.permission_type as \"permissionType\" \n" +
            "from module m\n" +
            "inner join module modprt on m.parent_module_id = modprt.module_id\n" +
            "inner join permission p on p.module_id = m.module_id\n" +
            "inner join role r on r.role_id = p.role_id\n" +
            "inner join user_role ur on ur.role_id = r.role_id\n" +
            "inner join users u on u.user_id = ur.user_id\n" +
            "where 1=1\n" +
            "and p.permission_type != 'N'\n" +
            "and u.user_name = :userName \n" +
            "order by modprt.menu_order, modprt.code, m.menu_order";

    private static final String SEARCH_MODULES_ACTIVE = "select\n" +
            "\n" +
            "             modprt.code as \"parentCode\", " +
            "             modprt.name as \"parentName\",\n" +
            "             m.module_id AS \"moduleId\",\n" +
            "             m.code AS \"code\",\n" +
            "             m.help_url AS \"helpUrl\",\n" +
            "             m.menu_label AS \"menuLabel\",\n" +
            "             m.name AS \"name\",\n" +
            "             m.url AS \"url\"\n" +
            "             --p.permission_type as \"permissionType\"\n" +
            "            from module m\n" +
            "            inner join module modprt on m.parent_module_id = modprt.module_id\n" +
            "            where  1=1 " ;
            //"and m.VISIBLE ='Y'";


    @Transactional(readOnly = true)
    @Override
    public List<ModuleParentDto> getAllowedModulesByUserId(String userName) {
        LOGGER.info("Finding visible modules with permission by user id: {}", userName);

        List<ModuleParentDto>searchResults =findModules(userName, SEARCH_MODULES_VISIBLE_PER_USER);

        return searchResults;
    }


    @Transactional(readOnly = true)
    @Override
    public List<ModuleParentDto> getPermissionModulesByUserId(String userName) {
        LOGGER.info("Finding modules with permission by user id: {}", userName);

        List<ModuleParentDto>searchResults =findModules(userName,SEARCH_PERMISSION_MODULES_PER_USER);

        return searchResults;
    }


    @Override
    public List<ModuleViewDto> getModulesActive () {
        LOGGER.info("Finding modules ");

        List<ModuleViewDto>searchResults =findModules(SEARCH_MODULES_ACTIVE);

        return searchResults;
    }


    private List<ModuleViewDto> findModules(String query){
        Map<String, String> queryParams = new HashMap<>();

        List<ModuleViewDto> searchResults = jdbcTemplate.query(query,
                queryParams,
                new BeanPropertyRowMapper<>(ModuleViewDto.class)
        );

        LOGGER.info("Found {} module entries", searchResults.size());

        return searchResults;
    }


    private List<ModuleParentDto> findModules(String userName, String query){
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("userName", userName);

        List<ModuleParentDto> searchResults = jdbcTemplate.query(query,
                queryParams,
                new BeanPropertyRowMapper<>(ModuleParentDto.class)
        );

        LOGGER.info("Found {} module entries", searchResults.size());

        return searchResults;
    }
}
