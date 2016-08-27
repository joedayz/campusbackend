package pe.joedayz.api.service.intf;

import pe.joedayz.api.dto.ListResultModule;
import pe.joedayz.api.dto.ListResultRole;
import pe.joedayz.api.dto.PageableResult;
import pe.joedayz.api.dto.RoleFilterDto;
import pe.joedayz.api.dto.RoleViewDto;

public interface RoleService {

	PageableResult find(RoleFilterDto filter);

	ListResultModule findModuleActive(Long roleId);

	String save(RoleViewDto dto);

	ListResultRole find();

	RoleViewDto findById(Long id);

	String delete(RoleViewDto dto);


}
