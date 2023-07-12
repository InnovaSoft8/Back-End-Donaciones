package com.innovasoft.donacionesapi.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Recursos")
@Data
public class Recurso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRecurso;

    private String nombre;
    private String descripcion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idProyecto")
    private Proyecto proyecto;

    // Constructor, getters y setters
}