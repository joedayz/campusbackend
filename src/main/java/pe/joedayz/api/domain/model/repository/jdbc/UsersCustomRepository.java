package pe.joedayz.api.domain.model.repository.jdbc;

import java.util.List;

import pe.joedayz.api.dto.UserDto;


public interface UsersCustomRepository {
    UserDto findByUserName(String userName);

    List<UserDto> findUsersByName(String name) ;
}
