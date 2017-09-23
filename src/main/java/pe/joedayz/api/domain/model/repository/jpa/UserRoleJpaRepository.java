package pe.joedayz.api.domain.model.repository.jpa;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.joedayz.api.domain.model.entities.UserRole;

import java.util.List;

/**
 * Created by josediaz on 17/08/2016.
 */
@Repository
public interface UserRoleJpaRepository extends CrudRepository<UserRole,Long> {

    UserRole save(UserRole userRole);


    @Query("SELECT u FROM UserRole u WHERE u.role.roleId = :roleId")
    List<UserRole> findByCodeRole(@Param("roleId") long roleId);


}
