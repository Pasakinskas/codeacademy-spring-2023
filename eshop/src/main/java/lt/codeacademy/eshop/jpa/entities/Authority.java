package lt.codeacademy.eshop.jpa.entities;

import java.io.Serial;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Authority implements GrantedAuthority {

  @Serial
  private static final long serialVersionUID = -2759184906241814492L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Getter
  @Column(nullable = false)
  private String name;
  private String description;

  @Override
  public String getAuthority() {
    return "ROLE_" + name;
  }
}
