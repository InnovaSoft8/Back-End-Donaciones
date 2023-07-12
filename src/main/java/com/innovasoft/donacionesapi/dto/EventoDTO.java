package com.innovasoft.donacionesapi.dto;

import lombok.Data;

@Data
public class EventoDTO {

    private Long idEvento;
    private String nombre;
    private String descripcion;
    private String fechaHora;
    private Long idProyecto;

    // Constructor, getters y setters
}