package lt.codeacademy.eshop.security.jpa.repository;

import lt.codeacademy.eshop.security.jpa.entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {
}
