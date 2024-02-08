package lt.codeacademy.eshop.jpa.repositories;

import lt.codeacademy.eshop.jpa.entities.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {
}
