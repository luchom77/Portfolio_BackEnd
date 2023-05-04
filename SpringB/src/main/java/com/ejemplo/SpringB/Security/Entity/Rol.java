package com.ejemplo.SpringB.Security.Entity;

import com.ejemplo.SpringB.Security.Enums.RolNombre;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    @Enumerated(EnumType.STRING)
    private RolNombre rolNombre;

    //Constructor
    public Rol(){

    }
    public Rol(RolNombre rolNombre) {
        this.rolNombre = rolNombre;
    }


    //Getters y Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public RolNombre getRolNombre() {
        return rolNombre;
    }

    public void setRolNombre(RolNombre rolNombre) {
        this.rolNombre = rolNombre;
    }
}
