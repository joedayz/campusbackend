package pe.joedayz.api.domain.model.repository.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.joedayz.api.domain.model.entities.Parameter;
import pe.joedayz.api.domain.model.entities.User;

@Repository
public interface ParameterJpaRepository extends CrudRepository<Parameter, Long> {


    @Query("SELECT m FROM Parameter m WHERE m.code = :code and m.status='A'")
    List<Parameter> findByCode(@Param("code") String code);
    
    @Query("SELECT m FROM Parameter m WHERE m.code = :code and m.status='A'")
    Parameter findByCodeUnique(@Param("code") String code);
}
