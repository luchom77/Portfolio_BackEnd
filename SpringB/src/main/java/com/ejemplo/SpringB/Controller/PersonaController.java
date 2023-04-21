package com.ejemplo.SpringB.Controller;

import com.ejemplo.SpringB.model.PersonaDTO;
import com.ejemplo.SpringB.model.response.OrigenDTO;
import com.ejemplo.SpringB.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PersonaController {


        @Autowired
        private final PersonaService personaService;


        public PersonaController(PersonaService personaService) {

            this.personaService = personaService;
        }

        @PostMapping("/new/persona")
        public void agregarPersona (@RequestBody PersonaDTO pers){

            personaService.createPersona(pers);
        }

        @GetMapping("/personas")
        @ResponseBody
        public List<PersonaDTO> verPersonas(){

            return personaService.verPersonas();
        }

        @GetMapping("/persona/{id}/origen")
        public ResponseEntity<OrigenDTO> getOrigen(
               @PathVariable("id") Long id
        ) {
//            String idString= Long.toString(id);
//            String nacionalidad= "argentino".concat(idString);
            PersonaDTO personaDTON = personaService.getPersona(id);
            OrigenDTO respuesta = new OrigenDTO(personaDTON.getOrigen());

            return new ResponseEntity<>(respuesta, HttpStatus.OK);
        }

        @GetMapping("/persona/{id}")
        public ResponseEntity<PersonaDTO> getPersona(
                @PathVariable("id") Long id
        ) {
        //            String idString= Long.toString(id);
        //            String nacionalidad= "argentino".concat(idString);
            PersonaDTO personaDTON = personaService.getPersona(id);


            return new ResponseEntity<>(personaDTON, HttpStatus.OK);
        }
}


