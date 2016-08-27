package pe.joedayz.api.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.joedayz.api.domain.model.entities.Permission;
import pe.joedayz.api.domain.model.repository.jpa.ModuleJpaRepository;
import pe.joedayz.api.domain.model.repository.jpa.PermissionJpaRepository;
import pe.joedayz.api.domain.model.repository.jpa.RoleJpaRepository;
import pe.joedayz.api.dto.ModuleViewDto;
import pe.joedayz.api.dto.RoleViewDto;
import pe.joedayz.api.enums.PermissionTypeEnum;
import pe.joedayz.api.service.intf.PermissionService;

@Service
public class PermissionServiceImpl implements PermissionService {
	final Logger LOG = LoggerFactory.getLogger(getClass());

	@Autowired
	PermissionJpaRepository permissionJpaRepository;
	@Autowired
	ModuleJpaRepository moduleJpaRepository;

	@Autowired
	RoleJpaRepository roleJpaRepository;

	@Override
	@Transactional
	public String savePermissionRole(RoleViewDto dto) {

		List<ModuleViewDto> moduleViewDtos = dto.getModules().stream().filter(p->p.getModuleId()>=0).collect(Collectors.toList());

		for(ModuleViewDto viewDto :moduleViewDtos){

			  Permission permission = permissionJpaRepository.findOneByName(viewDto.getModuleId(), dto.getRoleId());

			  if (permission == null) {
				  permission = new Permission();
			  }

			 //permission.setId(new PermissionPK(viewDto.getModuleId(),dto.getRoleId()));

			 // permission.setModule(moduleJpaRepository.findOne(viewDto.getModuleId()));
			 // permission.setRole(roleJpaRepository.findOne(dto.getRoleId()));
			  permission.setPermissionType(PermissionTypeEnum.findByCode(viewDto.getPermissionType().getCode()));

			permissionJpaRepository.save(permission);
		}

		return "";
	}




}