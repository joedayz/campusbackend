package pe.joedayz.api.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.joedayz.api.domain.model.entities.User;
import pe.joedayz.api.domain.model.entities.UserRole;
import pe.joedayz.api.domain.model.repository.jdbc.UserJdbcRepository;
import pe.joedayz.api.domain.model.repository.jdbc.UserRolJpaRepository;
import pe.joedayz.api.domain.model.repository.jdbc.UsersCustomRepository;
import pe.joedayz.api.domain.model.repository.jpa.RoleJpaRepository;
import pe.joedayz.api.domain.model.repository.jpa.UserJpaRepository;
import pe.joedayz.api.domain.model.repository.jpa.UserRoleJpaRepository;
import pe.joedayz.api.dto.*;
import pe.joedayz.api.enums.StatusEnum;
import pe.joedayz.api.enums.UserStatusEnum;
import pe.joedayz.api.service.intf.UserService;
import pe.joedayz.api.support.WhereParams;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    DataSource dataSource;
    
    @Autowired
    UserJpaRepository userJpaRepository;

    @Autowired
    UsersCustomRepository usersCustomRepository;

    @Autowired
    UserRolJpaRepository userRolJpaRepository;

    @Autowired
    UserJdbcRepository userJdbcRepository;

    @Autowired
    UserRoleJpaRepository userRoleJpaRepository;



    @Autowired
    RoleJpaRepository roleJpaRepository;



    private NamedParameterJdbcTemplate jdbcTemplate;

    @PostConstruct
    public void init(){
        jdbcTemplate= new NamedParameterJdbcTemplate(dataSource);
    }
	
    @Override
    public PageableResult find(UserFilterDto filter) {
        PageableResult result= new PageableResult();
        result.setResultList(new ArrayList<>());
        long totalCount=userJdbcRepository.searchPageableTotalCount(filter);
        result.setTotal(totalCount);

        if(totalCount>0){
            List<UserViewDto> items= userJdbcRepository.searchPageable(filter);

            for(UserViewDto item:items){
                item.setStatus(StatusEnum.findByCode(item.getStatus()).getLabel());
            }

            result.setResultList(items);
        }

        return result;
    }

    @Override
    public UserDto findById(long userId) {
        UserDto dto= new UserDto();
        User entity= userJpaRepository.findOne(userId);

        dto.setId(entity.getUserId());
        dto.setUserName(entity.getUserName());

        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setEmail(entity.getEmail());
        dto.setStatus(entity.getStatus().getCode());
        dto.setPassword(entity.getPassword());
        dto.setConfirmPassword(entity.getPassword());
        dto.setTitle(entity.getTitle());

        List<UserRole> roles= entity.getUserRoles();


        if(roles!=null){
         RoleViewDto roleDto;
         List<RoleViewDto> lstRoles= new ArrayList<>();
            for(UserRole item: roles){
                roleDto= new RoleViewDto();
                roleDto.setRoleId(item.getRole().getRoleId());
                roleDto.setRoleName(item.getRole().getRoleName());
                lstRoles.add(roleDto);
            }

          dto.setRoleList(lstRoles);
        }


        return dto;
    }

    @Override
    public UserDto findByUsername(String userName) {
       User entity= userJpaRepository.findByUserName(userName);
       return findById(entity.getUserId());
    }

    @Override
    public Long mergeUser(UserDto dto) {

        if(userJpaRepository.findDistinct(dto.getUserName(),dto.getId()==null?-1:dto.getId() )!=null){
            return (long) -1;
        }

        User entity;
        if(dto.getId()==null)
            entity= new User();
        else entity= userJpaRepository.findOne(dto.getId());

        entity.setUserName(dto.getUserName());
        //entity.setUser(userJpaRepository.findOne(dto.getManagerId()));
        entity.setFirstName(dto.getFirstName());
        entity.setEmail(dto.getEmail());
        entity.setLastName(dto.getLastName());
        entity.setStatus(UserStatusEnum.findByCode(dto.getStatus()));
        entity.setPassword(dto.getPassword());
        entity.setTitle(dto.getTitle());

        userJpaRepository.save(entity);

        //LOG.info("Saving Roles...");
        if(entity.getUserRoles()!=null)
            for(UserRole existent:entity.getUserRoles())
            userRoleJpaRepository.delete(existent);

        UserRole userRole;
        for(RoleViewDto item: dto.getRoleList()){
            userRole= new UserRole();
            userRole.setUser(entity);
            userRole.setRole(roleJpaRepository.findOne(item.getRoleId()));
            userRoleJpaRepository.save(userRole);
        }


        // LOG.info("Processed USER Id <"+entity.getUserId()+">");
        return entity.getUserId();
    }

    @Override
    public Long updateProfile(UserDto dto) {
        User entity=userJpaRepository.findOne(dto.getId());

        if(!userJdbcRepository.validCurrentPassword(dto.getUserName(),dto.getPassword())){
            return (long) -1;
        }

        entity.setTitle(dto.getTitle());
        entity.setEmail(dto.getEmail());
        if(dto.getNewPassword()!=null)
         entity.setPassword(dto.getNewPassword());

        userJpaRepository.save(entity);
        //LOG.info("Processed User Edit Profile - Id <"+entity.getUserId()+">");
        return entity.getUserId();
    }

    @Override
    public String deleteUser(long userId) {
       //LOG.info("verifying constraints with: Manager, Customer, Rfq (pricingAnalyst), Rfq (salesAccountManager)");

        if(!userJpaRepository.findManagerReference(userId).isEmpty())
            return "User is referenced as Manager";

        userJpaRepository.delete(userId);
        //LOG.info("User ".concat(String.valueOf(userId)).concat(" Deleted successfully"));
        return "success";
    }

    @Override
    public List<UserViewDto> searchUser(UserFilterDto value) {
        StringBuffer sql= new StringBuffer();
        sql.append("SELECT \n");
        sql.append("  TU.USER_ID id, \n");
        sql.append("  TU.USER_NAME name, \n");
        sql.append("  TU.FIRST_NAME firstName, \n");
        sql.append("  TU.LAST_NAME lastName, \n");
        sql.append("  (TU.FIRST_NAME || ' ' ||TU.LAST_NAME) fullName \n");
        sql.append("FROM USERS TU \n");
        sql.append("INNER JOIN USER_ROLE TUR \n");
        sql.append("ON TUR.USER_ID = TU.USER_ID \n");
        sql.append("INNER JOIN ROLE R \n");
        sql.append("ON TUR.ROLE_ID = R.ROLE_ID \n");

        sql.append("WHERE 1=1 \n");
        WhereParams params= new WhereParams();

        sql.append(params.filter(" AND upper(TU.FIRST_NAME || ' '|| TU.LAST_NAME) LIKE upper('%'|| :name ||'%') ",value.getName()));
        sql.append(params.filter(" AND TU.STATUS = :status ", StatusEnum.ACTIVE.getCode()));
        sql.append(params.filter(" AND R.CODE = :roleCode ", value.getRole().getCode()));
        return jdbcTemplate.query(sql.toString(),params.getParams(),new BeanPropertyRowMapper<>(UserViewDto.class));
    }

    @Override
    public List<UserViewDto> searchManager(String query) {
        StringBuffer sql= new StringBuffer();

        sql.append("SELECT \n");
        sql.append("  TU.USER_ID id, \n");
        sql.append("  TU.USER_NAME name, \n");
        sql.append("  TU.FIRST_NAME firstName, \n");
        sql.append("  TU.LAST_NAME lastName \n");
        sql.append("FROM USERS TU \n");
        sql.append("WHERE 1=1 \n");
        WhereParams params= new WhereParams();
        sql.append(params.filter(" AND upper(TU.FIRST_NAME || ' '|| TU.LAST_NAME) LIKE upper('%'|| :name ||'%') ",query));

        return jdbcTemplate.query(sql.toString(),params.getParams(),new BeanPropertyRowMapper<>(UserViewDto.class));
    }

    @Override
    @Transactional
    public int inactive(String username) {
        int numRecs = userJpaRepository.setAsInactive(username);
        assert numRecs == 1;
        return numRecs;
    }

    @Override
    @Transactional
    public int locked(String username) {
        int numRecs = userJpaRepository.setAsLocked(username);
        assert numRecs == 1;
        return numRecs;
    }

    public UserDto loadUserByUsername(String username){
        UserDto result = usersCustomRepository.findByUserName(username);
        if (result != null) {
            List<UserRole> rolList =
                    userRolJpaRepository.findByUserId(result.getId());

            for (UserRole userRole : rolList) {

                RolDto rolDto=new RolDto();

                rolDto.setId(userRole.getRole().getRoleId());
                rolDto.setCode(userRole.getRole().getCode());
                rolDto.setRoleName(userRole.getRole().getRoleName());

                result.addRol(rolDto);

            }
        }

        return result;
    }


}
