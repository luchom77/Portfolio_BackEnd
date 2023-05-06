package com.ejemplo.SpringB.service.implement;

import com.ejemplo.SpringB.model.Persona;
import com.ejemplo.SpringB.repository.PersonaRepository;
import com.ejemplo.SpringB.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServiceImp implements PersonaService {

    @Autowired
    private final PersonaRepository personaRepository;

    public PersonaServiceImp(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    @Override
    public Persona getPersona(Long id) {
        return personaRepository.findById(id).orElse(null);
    }

    @Override
    public List<Persona> verPersonas() {
        return personaRepository.findAll();
    }


    public Persona createPersona(Persona persona) {
        return personaRepository.save(persona);
    }

    @Override
        public Persona deletePersona(Long id) {
            personaRepository.deleteById(id);
        return null;
    }

}
