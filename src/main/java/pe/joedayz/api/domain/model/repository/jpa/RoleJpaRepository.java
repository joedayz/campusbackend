package pe.joedayz.api.domain.model.repository.jpa;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.joedayz.api.domain.model.entities.Role;

import java.util.List;

/**
 * Created by josediaz on 17/08/2016.
 */
@Repository
public interface RoleJpaRepository extends CrudRepository<Role, Long> {
    Role save(Role Role);

    @Query("SELECT r FROM Role r WHERE r.code = :code")
    List<Role> findByCode(@Param("code") String code);

}
