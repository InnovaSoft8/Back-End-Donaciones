package com.innovasoft.donacionesapi.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "MetasFinanciamiento")
@Data
public class MetaFinanciamiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMetaFinanciamiento;

    private Double montoObjetivo;
    private LocalDate fechaLimite;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idProyecto")
    private Proyecto proyecto;

    // Constructor, getters y setters
}