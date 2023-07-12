package com.innovasoft.donacionesapi.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(name = "Proyectos")
@Data
public class Proyecto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProyecto;

    private String nombre;
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "idReceptor")
    private Receptor receptor;

    @ManyToOne
    @JoinColumn(name = "idDesastre")
    private Desastre desastre;

    private String fechaInicio;
    private String fechaFin;
    private double montoMeta;
    private double montoRecaudado;

    // Constructor, getters y setters
}