package pe.joedayz.api.domain.model.repository.jpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pe.joedayz.api.domain.model.entities.DetallesCurso;


@Repository
public interface DetallesCursoJpaRepository extends CrudRepository<DetallesCurso, Long> {

}
