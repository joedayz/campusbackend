package pe.joedayz.api.domain.model.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.joedayz.api.domain.model.entities.Permission;

@Repository
public interface PermissionJpaRepository extends CrudRepository<Permission, Long> , JpaRepository<Permission,Long> {
    Permission save(Permission permission);

    @Query("SELECT t FROM Permission t WHERE t.module.moduleId = :moduleId AND t.role.roleId = :roleId ")
    Permission findOneByName(@Param("moduleId") Long moduleId, @Param("roleId") Long roleId);

    @Modifying
    @Query("DELETE FROM Permission t WHERE t.role.roleId = :roleId  ")
    void deletePermisionByRole(@Param("roleId") Long roleId);

}
