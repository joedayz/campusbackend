package pe.joedayz.api.service.intf;

import pe.joedayz.api.dto.PageableResult;
import pe.joedayz.api.dto.UserDto;
import pe.joedayz.api.dto.UserFilterDto;
import pe.joedayz.api.dto.UserViewDto;

import java.util.List;

public interface UserService {

    PageableResult find(UserFilterDto filter);
    List<UserViewDto> searchUser(UserFilterDto value);
    List<UserViewDto> searchManager(String query);
    int inactive(String username);
    int locked(String username);
    UserDto loadUserByUsername(String username);

    UserDto findById(long userId);
    Long mergeUser(UserDto value);
    String deleteUser(long userId);

    UserDto findByUsername(String userName);
    Long updateProfile(UserDto value);
}
