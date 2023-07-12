package com.innovasoft.donacionesapi.dto;

import lombok.Data;

@Data
public class UbicacionDTO {

    private Long idUbicacion;
    private String pais;
    private String estadoProvincia;
    private String ciudad;
    private String codigoPostal;
    private String latitud;
    private String longitud;

    // Constructor, getters y setters
}