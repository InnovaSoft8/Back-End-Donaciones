package com.innovasoft.donacionesapi.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Voluntarios")
@Data
public class Voluntario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVoluntario;

    private String nombre;
    private String direccion;
    private String correoElectronico;
    private String telefono;
    private String fechaRegistro;

    @ManyToOne
    @JoinColumn(name = "idPais")
    private Pais pais;

    // Constructor, getters y setters
}