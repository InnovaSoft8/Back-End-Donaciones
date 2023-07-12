package com.innovasoft.donacionesapi.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class MetaFinanciamientoDTO {

    private Long idMetaFinanciamiento;
    private Double montoObjetivo;
    private LocalDate fechaLimite;
    private Long idProyecto;

    // Constructor, getters y setters
}