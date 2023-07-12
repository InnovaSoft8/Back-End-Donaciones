package com.innovasoft.donacionesapi.dto;

import lombok.Data;

import java.util.Date;

@Data
public class PublicacionRedesSocialesDTO {

    private Long idPublicacion;
    private String contenido;
    private Date fechaHora;
    private Long idProyecto;

    // Otros campos y métodos getter/setter según tus necesidades
}