package com.innovasoft.donacionesapi.dto;

import lombok.Data;

@Data
public class ProgramaRecompensasDTO {

    private Long idProgramaRecompensas;
    private String nombre;
    private String descripcion;
    private Long idProyecto;

    // Constructor, getters y setters
}