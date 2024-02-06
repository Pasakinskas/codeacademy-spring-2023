package lt.codeacademy.eshop.user.repository;

import java.util.Optional;

import lt.codeacademy.eshop.user.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {

  @Query(value =
    "SELECT u FROM User u" +
      " JOIN FETCH u.authorities" +
      " WHERE u.email = :email")
  Optional<User> findUserByEmailWithAuthorities(String email);
}
