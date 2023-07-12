package com.innovasoft.donacionesapi.model;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "Ubicacion")
@Data
public class Ubicacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUbicacion;

    private String pais;
    private String estadoProvincia;
    private String ciudad;
    private String codigoPostal;
    private String latitud;
    private String longitud;

    // Constructor, getters y setters
}