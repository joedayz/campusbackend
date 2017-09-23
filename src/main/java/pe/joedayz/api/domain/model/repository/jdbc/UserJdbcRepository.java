package pe.joedayz.api.domain.model.repository.jdbc;

import pe.joedayz.api.dto.UserFilterDto;
import pe.joedayz.api.dto.UserViewDto;

import java.util.List;

/**
 * Created by josediaz on 17/08/2016.
 */

public interface UserJdbcRepository {
    long searchPageableTotalCount(UserFilterDto filter);
    List<UserViewDto> searchPageable(UserFilterDto filter);
    boolean validCurrentPassword(String username, String password);
}
