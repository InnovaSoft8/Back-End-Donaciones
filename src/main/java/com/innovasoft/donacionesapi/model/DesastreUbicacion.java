package com.innovasoft.donacionesapi.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "DesastreUbicaciones")
@Data
public class DesastreUbicacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDesastreUbicacion;

    @ManyToOne
    @JoinColumn(name = "idDesastre")
    private Desastre desastre;

    @ManyToOne
    @JoinColumn(name = "idUbicacion")
    private Ubicacion ubicacion;

    // Constructor, getters y setters
}