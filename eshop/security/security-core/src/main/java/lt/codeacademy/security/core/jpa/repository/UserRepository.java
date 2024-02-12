package lt.codeacademy.security.core.jpa.repository;

import java.util.Optional;

import lt.codeacademy.security.core.jpa.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

  @Query(value =
    "SELECT u FROM UserEntity u" +
      " JOIN FETCH u.authorities" +
      " WHERE u.email = :email")
  Optional<UserEntity> findUserByEmailWithAuthorities(String email);
}
