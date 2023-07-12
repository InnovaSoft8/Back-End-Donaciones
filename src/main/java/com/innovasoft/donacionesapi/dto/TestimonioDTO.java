package com.innovasoft.donacionesapi.dto;

import lombok.Data;

@Data
public class TestimonioDTO {

    private Long idTestimonio;
    private String contenido;
    private Long idDonante;
    private Long idProyecto;

    // Constructor, getters y setters
}