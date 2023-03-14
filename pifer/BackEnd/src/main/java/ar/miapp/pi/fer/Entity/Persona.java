
package ar.miapp.pi.fer.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Fernando
 */

@Entity 
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    @Size(min =1, max= 50, message= "Para el campo Nombre debe respetar el caracter minimo = 1 y maximo = 50")
    private String nombre;
    @NotNull
    @Size(min =1, max= 50, message= "Para el campo Apellido debe respetar el caracter minimo = 1 y maximo = 50")
    private String apellido;
    @NotNull
    private String acercademi;
     
   @Size(min =1, max= 500, message= "Para el campo Apellido debe respetar el caracter minimo = 1 y maximo = 500")
    private String img;

    public Persona() {
    }

    public Persona(String nombre, String apellido, String acercademi, String img) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.acercademi = acercademi;
        this.img = img;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getAcercademi() {
        return acercademi;
    }

    public void setAcercademi(String acercademi) {
        this.acercademi = acercademi;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

  
    
}
