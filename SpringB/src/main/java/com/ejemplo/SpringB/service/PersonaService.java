package com.ejemplo.SpringB.service;

import com.ejemplo.SpringB.model.PersonaDTO;
import org.hibernate.event.internal.DefaultPersistOnFlushEventListener;

import java.util.List;

public interface PersonaService {

    PersonaDTO getPersona(Long id);

    List<PersonaDTO> verPersonas();

    PersonaDTO createPersona(PersonaDTO persona);

    PersonaDTO deletePersona(Long id);



}
