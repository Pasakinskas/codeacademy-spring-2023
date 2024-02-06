package lt.codeacademy.eshop.user.repository;

import lt.codeacademy.eshop.user.pojo.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {
}
