
package ar.miapp.pi.fer.Repository;

import ar.miapp.pi.fer.Entity.Persona;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Fernando
 */
@Repository 
public interface IPersonaRepository extends JpaRepository<Persona,Integer>  {
    
        public Optional<Persona> findByNombre(String nombre);
    public boolean existsByNombre(String nombre);
}
