package com.innovasoft.donacionesapi.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class DonacionDTO {

    private Long idDonacion;
    private double monto;
    private LocalDateTime fechaHora;
    private Long idDonante;
    private Long idProyecto;
    private Long idTipoDonacion;

    // Constructor, getters y setters
}