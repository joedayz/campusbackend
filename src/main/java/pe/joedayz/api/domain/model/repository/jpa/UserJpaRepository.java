package pe.joedayz.api.domain.model.repository.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.joedayz.api.domain.model.entities.User;



@Repository
public interface UserJpaRepository extends CrudRepository<User, Long> {

    @Query("SELECT t FROM User t " +
            "WHERE LOWER(t.firstName) LIKE LOWER(CONCAT('%',:firstName, '%')) ")
    List<User> findByFirstName(@Param("firstName") String firstName);


    @Query("SELECT t FROM User t " +
            "WHERE LOWER(t.firstName) LIKE LOWER(CONCAT('%',:name, '%')) "+
    " OR LOWER(t.lastName) LIKE LOWER(CONCAT('%',:name, '%'))")
    List<User> findUsersByName(@Param("name") String name);

    @Modifying
    @Query("update User usr set usr.status = 'I' where usr.userName = :username")
    int setAsInactive(@Param("username") String username);

    @Modifying
    @Query("update User usr set usr.status = 'L' where usr.userName = :username")
    int setAsLocked(@Param("username") String username);

    User findByUserName(@Param("username") String userName);

    @Query("SELECT t FROM User t WHERE LOWER(t.userName) = LOWER(:userName) AND t.userId <> :userId")
    User findDistinct(@Param("userName") String userName,@Param("userId") Long userId);

    @Query("SELECT t FROM User t WHERE t.userId = :userId")
    List<User> findManagerReference(@Param("userId") Long userId);

    User save(User customer);


}
