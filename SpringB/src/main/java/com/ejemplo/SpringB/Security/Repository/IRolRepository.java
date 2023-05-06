package com.ejemplo.SpringB.Security.Repository;

import com.ejemplo.SpringB.Security.Entity.Rol;
import com.ejemplo.SpringB.Security.Enums.RolNombre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IRolRepository extends JpaRepository <Rol, Integer>{
    Optional<Rol> findByRolNombre (RolNombre rolNombre);
}
