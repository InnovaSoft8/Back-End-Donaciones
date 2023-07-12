package com.innovasoft.donacionesapi.dto;

import lombok.Data;

@Data
public class ProyectoDTO {

    private Long idProyecto;
    private String nombre;
    private String descripcion;
    private Long idReceptor;
    private Long idDesastre;
    private String fechaInicio;
    private String fechaFin;
    private double montoMeta;
    private double montoRecaudado;

    // Constructor, getters y setters
}