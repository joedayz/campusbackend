package pe.joedayz.api.domain.model.repository.jpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.joedayz.api.domain.model.entities.ResetRegistry;


/**
 * Created by JVergara on 25/04/2016.
 */
@Repository
public interface ResetRegistryJpaRepository extends CrudRepository<ResetRegistry, Long> {

    ResetRegistry findByToken(@Param("token") String token);

    ResetRegistry save(ResetRegistry resetRegistry);

}
