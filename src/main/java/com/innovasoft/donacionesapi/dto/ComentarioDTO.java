package com.innovasoft.donacionesapi.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ComentarioDTO {

    private Long idComentario;
    private String contenido;
    private LocalDateTime fechaHora;
    private Long idDonante;
    private Long idProyecto;

    // Constructor, getters y setters
}