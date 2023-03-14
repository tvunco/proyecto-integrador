
package ar.miapp.pi.fer.Security.Entity;

import ar.miapp.pi.fer.Security.Enums.RolNombre;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Fernando
 */

@Entity
public class Rol {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY )
    private int id;
    @NotNull
    @Enumerated(EnumType.STRING)///solo podemos poner texto y numero juntos
    private RolNombre rolNombre;
    
    ///constructor

    public Rol() {
    }

    public Rol(RolNombre rolNombre) {
        this.rolNombre = rolNombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public RolNombre getRolNombre() {
        return rolNombre;
    }

    public void setRolNombre(RolNombre rolNombre) {
        this.rolNombre = rolNombre;
    }
    
    
}
