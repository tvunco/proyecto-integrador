
package ar.miapp.pi.fer.Security.Repository;

import ar.miapp.pi.fer.Security.Entity.Rol;
import ar.miapp.pi.fer.Security.Enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Fernando
 */
@Repository

public interface IRolRepository  extends JpaRepository<Rol, Integer> {
    Optional<Rol> findByRolNombre (RolNombre rolNombre);
}
