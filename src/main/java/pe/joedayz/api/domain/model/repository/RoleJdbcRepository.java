package pe.joedayz.api.domain.model.repository;

import pe.joedayz.api.dto.RoleFilterDto;
import pe.joedayz.api.dto.RoleViewDto;

import java.util.List;

/**
 * Created by josediaz on 17/08/2016.
 */
public interface RoleJdbcRepository {
    List<RoleViewDto> searchRoleList();

    Long searchRampAreaPageableTotalCount(RoleFilterDto filter);


    List<RoleViewDto> searchRampAreaPageable(RoleFilterDto filter);
}

