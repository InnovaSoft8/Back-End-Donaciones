package com.innovasoft.donacionesapi.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "ProductosDonados")
@Data
public class ProductoDonado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProductoDonado;

    private String nombre;
    private String descripcion;
    private double valorEstimado;

    @ManyToOne
    @JoinColumn(name = "idDonante")
    private Donante donante;

    @ManyToOne
    @JoinColumn(name = "idProyecto")
    private Proyecto proyecto;

    @ManyToOne
    @JoinColumn(name = "idTipoDonacion")
    private TipoDonacion tipoDonacion;

    // Constructor, getters y setters
}