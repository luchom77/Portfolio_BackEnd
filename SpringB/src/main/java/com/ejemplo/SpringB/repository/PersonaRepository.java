package com.ejemplo.SpringB.repository;

import com.ejemplo.SpringB.model.PersonaDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PersonaRepository extends JpaRepository<PersonaDTO, Long> {

}
