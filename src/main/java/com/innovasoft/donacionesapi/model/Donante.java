package com.innovasoft.donacionesapi.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "Donantes")
@Data
public class Donante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDonante;

    private String nombre;
    private String direccion;
    private String correoElectronico;
    private String telefono;
    private LocalDateTime fechaRegistro;

    @ManyToOne
    @JoinColumn(name = "idPais")
    private Pais pais;

    // Constructor, getters y setters
}