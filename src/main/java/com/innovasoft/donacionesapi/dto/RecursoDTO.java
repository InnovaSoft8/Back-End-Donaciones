package com.innovasoft.donacionesapi.dto;

import lombok.Data;

@Data
public class RecursoDTO {

    private Long idRecurso;
    private String nombre;
    private String descripcion;
    private Long idProyecto;

    // Constructor, getters y setters
}