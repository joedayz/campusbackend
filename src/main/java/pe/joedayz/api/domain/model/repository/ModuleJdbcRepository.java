package pe.joedayz.api.domain.model.repository;

import org.springframework.stereotype.Repository;
import pe.joedayz.api.dto.ModuleFilterDto;
import pe.joedayz.api.dto.ModuleViewDto;
import pe.joedayz.api.dto.ModuleViewRsl;

import java.util.List;

/**
 * Created by josediaz on 17/08/2016.
 */
@Repository
public interface ModuleJdbcRepository {

    long searchModulePageableTotalCount(ModuleFilterDto filter);

    List<ModuleViewRsl> searchModule(ModuleFilterDto filter, String paginable);

    ModuleViewDto findModuleById(Long moduleId);

    List<ModuleViewDto> searchModulesExceptItself(String query,Long moduleId);

}
