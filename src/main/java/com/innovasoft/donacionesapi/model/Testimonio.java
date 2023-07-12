package com.innovasoft.donacionesapi.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Testimonios")
@Data
public class Testimonio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTestimonio;

    private String contenido;

    @ManyToOne
    @JoinColumn(name = "idDonante")
    private Donante donante;

    @ManyToOne
    @JoinColumn(name = "idProyecto")
    private Proyecto proyecto;

    // Constructor, getters y setters
}