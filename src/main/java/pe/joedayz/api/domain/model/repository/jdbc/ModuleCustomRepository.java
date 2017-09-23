package pe.joedayz.api.domain.model.repository.jdbc;

import java.util.List;

import pe.joedayz.api.dto.ModuleParentDto;
import pe.joedayz.api.dto.ModuleViewDto;


public interface ModuleCustomRepository {
	 List<ModuleParentDto> getAllowedModulesByUserId(String userName);

    List<ModuleParentDto> getPermissionModulesByUserId(String userName);

    List<ModuleViewDto> getModulesActive ();
}
