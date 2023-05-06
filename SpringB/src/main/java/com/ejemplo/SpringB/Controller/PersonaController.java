package com.ejemplo.SpringB.Controller;

import com.ejemplo.SpringB.Security.Entity.Usuario;
import com.ejemplo.SpringB.model.Persona;
import com.ejemplo.SpringB.model.response.OrigenDTO;
import com.ejemplo.SpringB.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class PersonaController {


        @Autowired
        private final PersonaService personaService;


        public PersonaController(PersonaService personaService) {

            this.personaService = personaService;
        }
        @PreAuthorize("hasRole('ADMIN')")
        @PostMapping("/new/persona")
        public String createPersona (@RequestBody Persona pers, @AuthenticationPrincipal Usuario usuario){

            personaService.createPersona(pers);
            return "La persona fue creada correctamente";
        }
        @PreAuthorize("hasRole('ADMIN')")
        @DeleteMapping("/del/{id}")
        public void deletePersona(@PathVariable Long id){

            personaService.deletePersona(id);
        }



        @GetMapping("/personas")
        @ResponseBody
        public List<Persona> verPersonas(){

            return personaService.verPersonas();
        }

        @GetMapping("/persona/{id}/origen")
        public ResponseEntity<OrigenDTO> getOrigen(
               @PathVariable("id") Long id
        ) {
            Persona personaDTON = personaService.getPersona(id);
            OrigenDTO respuesta = new OrigenDTO(personaDTON.getOrigen());

            return new ResponseEntity<>(respuesta, HttpStatus.OK);
        }

        @GetMapping("/persona/{id}")
        public ResponseEntity<Persona> getPersona(
                @PathVariable("id") Long id
        ) {
            Persona personaDTON = personaService.getPersona(id);


            return new ResponseEntity<>(personaDTON, HttpStatus.OK);
        }

        @PreAuthorize("hasRole('ADMIN')")
        @PutMapping("/personas/editar/{id}")
        public Persona editPersona(
                @PathVariable Long id,
                @RequestParam("nombre") String nuevoNombre,
                @RequestParam("apellido") String nuevoApellido,
                @RequestParam("url_foto") String nuevoUrl_foto
        ) {
            Persona persona = personaService.getPersona(id);

            persona.setNombre(nuevoNombre);
            persona.setApellido(nuevoApellido);
            persona.setUrl_foto(nuevoUrl_foto);

            personaService.createPersona(persona);

            return persona;


        }
}


