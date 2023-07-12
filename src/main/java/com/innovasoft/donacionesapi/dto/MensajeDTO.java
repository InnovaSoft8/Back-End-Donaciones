package com.innovasoft.donacionesapi.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MensajeDTO {

    private Long idMensaje;
    private Long idDonanteEmisor;
    private Long idVoluntarioEmisor;
    private Long idDonanteReceptor;
    private Long idVoluntarioReceptor;
    private LocalDateTime fechaHoraMensaje;
    private String contenidoMensaje;
    private String estadoMensaje;

    // Constructor, getters y setters
}