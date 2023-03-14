
package ar.miapp.pi.fer.Controller;

import ar.miapp.pi.fer.Dto.dtoPersona;
import ar.miapp.pi.fer.Entity.Persona;
import ar.miapp.pi.fer.Security.Controller.Mensaje;
import ar.miapp.pi.fer.Service.ImpPersonaService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Fernando
 */
@RestController
@RequestMapping("/personas")
@CrossOrigin (origins = "http://localhost:4200")
public class PersonaController {
    
    /////Alternativa
       @Autowired
    ImpPersonaService personaService;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Persona>> list(){
        List<Persona> list = personaService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Persona> getById(@PathVariable("id")int id){
        if(!personaService.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }
        
        Persona persona = personaService.getOne(id).get();
        return new ResponseEntity(persona, HttpStatus.OK);
    }
    
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoPersona dtopersona){
        if(!personaService.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        if(personaService.existsByNombre(dtopersona.getNombre()) && personaService.getByNombre(dtopersona.getNombre()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtopersona.getNombre())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        
        Persona persona = personaService.getOne(id).get();
        
        persona.setNombre(dtopersona.getNombre());
        persona.setApellido(dtopersona.getApellido());
        persona.setAcercademi(dtopersona.getDescripcion());
        persona.setImg(dtopersona.getImg());
        
        personaService.save(persona);
        
        return new ResponseEntity(new Mensaje("Persona actualizada"), HttpStatus.OK);
    }
   
    
    
    
    
    
    
    
    
    
    
    
    
   /* @Autowired IPersonaService ipersonaService;
    
    ///metodos que usaremos
    
    ///implementamos un getmaping dependiendo de la URL el metodo a usar
    
    
    ///obtenemos
    @GetMapping("/personas/traer")
    public List<Persona> getPersona(){
        return ipersonaService.getPersona();
    }
    
///autorizamos
    @PreAuthorize("hasRole('ADMIN')")
///Guardamos
    @PostMapping("/personas/crear")
    public String createPersona(@RequestBody Persona persona){
        
        ipersonaService.savePersona(persona);
        return "El registro de la persona fue creada correctamente";

    }
    ///Borramos segun el id cual le borramos, atravez de un parametro le encviamos el dato del id
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/personas/borrar/{id}")
    public String deletePersona(@PathVariable Long id){
    ipersonaService.deletePersona(id);
     return "El registro de la persona fue BORRADO correctamente";
    
     }
    
    ///Editar segun el id
    
    @PutMapping("/personas/editar/{id}")
    
    public Persona editPersona(@PathVariable Long id,
            ///por parametros de repuesta
           @RequestParam("nombre") String nuevoNombre,
           @RequestParam("apellido") String nuevoApellido,
           @RequestParam("img") String nuevoImg){
        
        Persona persona = ipersonaService.findPersona(id);
        persona.setNombre(nuevoNombre);
        persona.setApellido(nuevoApellido);
        persona.setImg(nuevoImg);
        
        ipersonaService.savePersona(persona);
        return persona;
    }
    
    @GetMapping("/personas/traer/perfil")
    public Persona findPerona(){
         //return ipersonaService.findPersona(Long.MIN_VALUE);
        //return ipersonaService.findPersona(1L);
        //return ipersonaService.getPersona();
         return ipersonaService.findPersona(Long.valueOf(1));


    }*/
}
