package pe.joedayz.api.domain.model.repository.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.joedayz.api.domain.model.entities.GeneralTable;

/**
 * Created by JULIO JUAREZ on 05/05/2016.
 */
@Repository
public interface GeneralTableJpaRepository extends CrudRepository<GeneralTable, Long> ,  JpaRepository<GeneralTable,Long> {

	@Query("SELECT t FROM GeneralTable t " + "WHERE t.tableName =:tableName ")
	List<GeneralTable> findByTableName(@Param("tableName") String tableName);
	
	@Query("SELECT t FROM GeneralTable t " + "WHERE LOWER(t.tableName) LIKE LOWER(CONCAT('%',:tableName, '%')) ")
	List<GeneralTable> findLikeTableName(@Param("tableName") String tableName);
	
	@Query("SELECT t FROM GeneralTable t WHERE  t.code =:code AND t.tableName LIKE :tableName ")
	GeneralTable findByCode(@Param("code") String code, @Param("tableName") String tableName);
	
}
