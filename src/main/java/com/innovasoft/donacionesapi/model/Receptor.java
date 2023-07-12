package com.innovasoft.donacionesapi.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Receptores")
@Data
public class Receptor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReceptor;

    private String nombre;
    private String direccion;
    private String correoElectronico;
    private String telefono;
    private String fechaRegistro;

    @ManyToOne
    @JoinColumn(name = "idPais")
    private Pais pais;

    // Constructor, getters y setters
}