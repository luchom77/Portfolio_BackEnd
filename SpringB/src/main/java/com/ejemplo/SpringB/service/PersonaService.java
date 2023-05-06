package com.ejemplo.SpringB.service;

import com.ejemplo.SpringB.model.Persona;

import java.util.List;

public interface PersonaService {

    Persona getPersona(Long id);

    List<Persona> verPersonas();

    Persona createPersona(Persona persona);

    Persona deletePersona(Long id);


}
