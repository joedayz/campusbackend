package pe.joedayz.api.domain.model.repository.jdbc;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import pe.joedayz.api.domain.model.entities.UserRole;

/**
 * Created by JVergara on 12/05/2016.
 */
public interface UserRolJpaRepository extends CrudRepository<UserRole, Long> {

	@Query("select t " + " from UserRole t " + "where t.user.userId = :userId ")
	List<UserRole> findByUserId(@Param("userId") Long userId);
}
