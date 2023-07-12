package com.innovasoft.donacionesapi.dto;

import lombok.Data;

@Data
public class DesastreDTO {

    private Long idDesastre;
    private String nombre;
    private String descripcion;
    private String fecha;

    // Constructor, getters y setters
}