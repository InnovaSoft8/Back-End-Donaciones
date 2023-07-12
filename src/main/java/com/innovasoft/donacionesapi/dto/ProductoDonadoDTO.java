package com.innovasoft.donacionesapi.dto;

import lombok.Data;

@Data
public class ProductoDonadoDTO {

    private Long idProductoDonado;
    private String nombre;
    private String descripcion;
    private double valorEstimado;
    private Long idDonante;
    private Long idProyecto;
    private Long idTipoDonacion;

    // Constructor, getters y setters
}