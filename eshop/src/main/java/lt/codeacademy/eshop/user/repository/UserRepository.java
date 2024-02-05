package lt.codeacademy.eshop.user.repository;

import java.util.Optional;

import lt.codeacademy.eshop.user.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

  Optional<User> findUserByEmail(String email);
}
