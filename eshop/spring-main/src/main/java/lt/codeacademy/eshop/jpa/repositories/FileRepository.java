package lt.codeacademy.eshop.jpa.repositories;

import lt.codeacademy.eshop.jpa.entities.File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<File, Long> {}
