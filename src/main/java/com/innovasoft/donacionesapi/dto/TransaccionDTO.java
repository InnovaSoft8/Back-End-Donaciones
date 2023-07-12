package com.innovasoft.donacionesapi.dto;

import lombok.Data;

import java.util.Date;

@Data
public class TransaccionDTO {

    private Long idTransaccion;
    private double monto;
    private Date fechaHora;
    private Long idDonante;
    private Long idProyecto;
    private Long idPais;

    // Constructor, getters y setters
}