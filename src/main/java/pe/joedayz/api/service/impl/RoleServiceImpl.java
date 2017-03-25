package pe.joedayz.api.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.joedayz.api.domain.model.entities.Permission;
import pe.joedayz.api.domain.model.entities.Role;
import pe.joedayz.api.domain.model.entities.UserRole;
import pe.joedayz.api.domain.model.repository.RoleJdbcRepository;
import pe.joedayz.api.domain.model.repository.jdbc.ModuleCustomRepository;
import pe.joedayz.api.domain.model.repository.jpa.ModuleJpaRepository;
import pe.joedayz.api.domain.model.repository.jpa.PermissionJpaRepository;
import pe.joedayz.api.domain.model.repository.jpa.RoleJpaRepository;
import pe.joedayz.api.domain.model.repository.jpa.UserRoleJpaRepository;
import pe.joedayz.api.dto.ListResultModule;
import pe.joedayz.api.dto.ListResultRole;
import pe.joedayz.api.dto.ModuleViewDto;
import pe.joedayz.api.dto.PageableResult;
import pe.joedayz.api.dto.PermissionTypeDto;
import pe.joedayz.api.dto.RoleFilterDto;
import pe.joedayz.api.dto.RoleViewDto;
import pe.joedayz.api.enums.ActiveInactiveStatusEnum;
import pe.joedayz.api.enums.PermissionTypeEnum;
import pe.joedayz.api.enums.RoleEnum;
import pe.joedayz.api.enums.YesNoEnum;
import pe.joedayz.api.service.intf.PermissionService;
import pe.joedayz.api.service.intf.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
	final Logger LOG = LoggerFactory.getLogger(getClass());


	@Autowired
	PermissionService permissionService ;


	@Autowired
	ModuleCustomRepository moduleCustomRepository ;


	@Autowired
	ModuleJpaRepository moduleJpaRepository;

	@Autowired
	PermissionJpaRepository permissionJpaRepository;


	@Autowired
	RoleJpaRepository roleJpaRepository;


	@Autowired
	RoleJdbcRepository roleJdbcRepository;

	@Autowired
	UserRoleJpaRepository userRoleJpaRepository;


	@Override
	public PageableResult find(RoleFilterDto filter) {

		PageableResult result= new PageableResult();
		result.setResultList(new ArrayList<>());

		long totalCount=roleJdbcRepository.searchRampAreaPageableTotalCount(filter);
		result.setTotal(totalCount);

		if(totalCount>0){
			List<RoleViewDto> items=roleJdbcRepository.searchRampAreaPageable(filter);
			result.setResultList(items);
		}

		return result;
	}


	@Override
	public ListResultRole find() {
       List<RoleViewDto> roleViewDtos = roleJdbcRepository.searchRoleList();
		ListResultRole listResultRole = new ListResultRole();
		listResultRole.setResultList(roleViewDtos);
		return listResultRole;
	}




	@Override
	public ListResultModule findModuleActive(Long roleId) {
		ListResultModule listResultModule = new ListResultModule();
		List<ModuleViewDto> moduleViewDtos = moduleCustomRepository.getModulesActive();
        List<String> moduleParentViewDto = moduleViewDtos.stream().map(p->p.getParentCode()).distinct().collect(Collectors.toList());
		List<ModuleViewDto> moduleViewSendDtos =  new ArrayList<>();


        for(String moduleViewDto : moduleParentViewDto){
			List<ModuleViewDto> moduleViewDtoParent = moduleViewDtos.stream().filter(p->p.getParentCode().equalsIgnoreCase(moduleViewDto)).collect(Collectors.toList());



			if(moduleViewDtoParent.size()!=0){

				Collections.sort(moduleViewDtoParent, new Comparator() {
					@Override
					public int compare(Object softDrinkOne, Object softDrinkTwo) {
						//use instanceof to verify the references are indeed of the type in question
						return ((ModuleViewDto)softDrinkOne).getCode()
								.compareTo(((ModuleViewDto)softDrinkTwo).getCode());
					}
				});

				ModuleViewDto moduleMenu = new ModuleViewDto();
				moduleMenu.setModuleId(-1L);
				moduleMenu.setCode(moduleViewDto);
				moduleMenu.setName(moduleViewDtoParent.get(0).getParentName());
				moduleViewSendDtos.add(moduleMenu);
				for(ModuleViewDto moduleUseViewDto :moduleViewDtoParent){
					PermissionTypeDto permissionTypeDto = new PermissionTypeDto();
					permissionModule(permissionTypeDto,moduleUseViewDto.getModuleId(),roleId);
					moduleUseViewDto.setPermissionType(permissionTypeDto);
					moduleViewSendDtos.add(moduleUseViewDto);
				}
			}
		}
		listResultModule.setResultList(moduleViewSendDtos);
		return listResultModule;
	}

	private void permissionModule(PermissionTypeDto permissionTypeDto, Long moduleId, Long roleId){
		if(roleId!=null){
			Permission permission = permissionJpaRepository.findOneByName(moduleId,roleId);
			if(permission!=null&&permission.getPermissionType()!=null){
				permissionTypeDto.setCode(permission.getPermissionType().getCode());
				permissionTypeDto.setName(permission.getPermissionType().getLabel());
			}else{
				permissionTypeDto.setCode(PermissionTypeEnum.NONE_NO_ACCESS.getCode());
				permissionTypeDto.setName(PermissionTypeEnum.NONE_NO_ACCESS.getLabel());
			}
		}else{
			permissionTypeDto.setCode(PermissionTypeEnum.NONE_NO_ACCESS.getCode());
			permissionTypeDto.setName(PermissionTypeEnum.NONE_NO_ACCESS.getLabel());
		}
	}

	@Override
	@Transactional
	public String save(RoleViewDto dto) {

		vadidateRole(dto);
		Role role;

		if(dto.getRoleId()!=null){
			 role = roleJpaRepository.findOne(dto.getRoleId());
			if(role==null) role= new Role();
		}else{
			role= new Role();
		}

		role.setCode(dto.getRoleCode().toUpperCase());
        role.setRoleName(dto.getRoleName().toUpperCase());
		role.setStatus(ActiveInactiveStatusEnum.findByCode(dto.getRoleStatus()));

		Role roleSave = roleJpaRepository.save(role);

		dto.setRoleId(roleSave.getRoleId());
		permissionService.savePermissionRole(dto);

		return  "{\"message\":\"Role was saved\",\"roleId\":"+roleSave.getRoleId()+"}" ;

	}

	private void vadidateRole(RoleViewDto dto) {

		List<Role> roleViewDtos = roleJpaRepository.findByCode(dto.getRoleCode().toUpperCase().trim());

		List<Role> roleViewDuplicate;
		if(dto.getRoleId()!=null){

			 roleViewDuplicate = roleViewDtos.stream().filter(p->p.getRoleId()!=dto.getRoleId()).collect(Collectors.toList());

		}else{
			 roleViewDuplicate = roleViewDtos;
		}


		if(roleViewDuplicate.size() >0){
			throw new CampusException("ERR_201","Code Duplicate");
		}

	}

	@Override
	public RoleViewDto findById(Long id) {

		Role role = roleJpaRepository.findOne(id);

		ListResultModule listResultModule = findModuleActive(id);

		RoleViewDto roleViewDto = new RoleViewDto();
		roleViewDto.setRoleId(role.getRoleId());
		roleViewDto.setRoleName(role.getRoleName());
		roleViewDto.setRoleCode(role.getCode());
		roleViewDto.setRoleStatus(role.getStatus().getCode());

		roleViewDto.setIsEditCode(validateEditCode(role.getCode()).getCode());


		if(RoleEnum.SYSTEM.equals(RoleEnum.findByCode(role.getCode())))
			roleViewDto.setIsEditForceReadOnly("Y");

		roleViewDto.setModules(listResultModule.getResultList());

		return roleViewDto;
	}


	private YesNoEnum validateEditCode(String roleCode) {
		if(RoleEnum.findByCode(roleCode)!=null&&!RoleEnum.BLOCKED_AT_OFFICE.equals(RoleEnum.findByCode(roleCode))){
			return YesNoEnum.NO;
		}
		return YesNoEnum.YES;
	}

	@Override
	public String delete(RoleViewDto dto) {

		hasRoleAssignToAnyUser(dto.getRoleId());

		roleJpaRepository.delete(dto.getRoleId());

		return "Role was deleted";
	}

	private void hasRoleAssignToAnyUser(Long roleId) {


		List<UserRole> userRoles = userRoleJpaRepository.findByCodeRole(roleId);

		if(userRoles.size()>0){
			throw new CampusException("ERR_201","User assigned to this role, it is suggested to disable role.");
		}

	}

}