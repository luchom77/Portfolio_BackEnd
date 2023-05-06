package com.ejemplo.SpringB.model;
//import  javax.persistence.Id;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter //esto sirve para no tener que poner todos los setters y getters
@Entity
@Table(name="persona")
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nombre;
    private String apellido;
    private String profesion;
    private String origen;
    private String fecha_nac;
    private String sobre_mi;
    private String locacion_actual;
    private String telefono;

    @Email
    private String correo;
    private String url_foto;



}
