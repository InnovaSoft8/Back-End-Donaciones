package com.innovasoft.donacionesapi.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Paises")
@Data
public class Pais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPais;

    private String nombre;

    // Constructor, getters y setters
}