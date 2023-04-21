package com.ejemplo.SpringB.service.implement;

import com.ejemplo.SpringB.model.PersonaDTO;
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
    public PersonaDTO getPersona(Long id) {
        return personaRepository.findById(id).orElse(null);
    }

    @Override
    public List<PersonaDTO> verPersonas() {
        return personaRepository.findAll();
    }

    @Override
    public PersonaDTO createPersona(PersonaDTO persona) {
        return personaRepository.save(persona);
    }

    @Override
        public PersonaDTO deletePersona(Long id) {
            personaRepository.deleteById(id);
        return null;
    }

}
