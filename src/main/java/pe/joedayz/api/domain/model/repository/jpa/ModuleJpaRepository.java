package pe.joedayz.api.domain.model.repository.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.joedayz.api.domain.model.entities.Module;
import pe.joedayz.api.enums.ModuleVisibleEnum;
import pe.joedayz.api.enums.YesNoEnum;


@Repository
public interface ModuleJpaRepository extends CrudRepository<Module, Long>  {
    List<Module> findAll();

    @Query
    List<Module> findByVisibleTrue();

    @Query("SELECT m FROM Module m WHERE m.visible = :visible")
    List<Module> findByVisible(@Param("visible") YesNoEnum isVisible);



}
