package com.innovasoft.donacionesapi.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Desastre")
@Data
public class Desastre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDesastre;

    private String nombre;
    private String descripcion;
    private String fecha;

    // Constructor, getters y setters
}