package com.innovasoft.donacionesapi.dto;

import lombok.Data;

import java.util.Date;

@Data
public class SubastaDTO {

    private Long idSubasta;
    private String nombre;
    private String descripcion;
    private Date fechaInicio;
    private Date fechaFin;
    private Long idProyecto;

    // Constructor, getters y setters
}