package lt.codeacademy.security.core.jpa.repository;

import lt.codeacademy.security.core.jpa.entity.AuthorityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<AuthorityEntity, Long> {
}
