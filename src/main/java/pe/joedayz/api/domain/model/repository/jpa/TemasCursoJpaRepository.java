package pe.joedayz.api.domain.model.repository.jpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pe.joedayz.api.domain.model.entities.TemasCurso;

@Repository
public interface TemasCursoJpaRepository extends CrudRepository<TemasCurso, Long> {

}
