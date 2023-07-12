package com.innovasoft.donacionesapi.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class DonanteDTO {

    private Long idDonante;
    private String nombre;
    private String direccion;
    private String correoElectronico;
    private String telefono;
    private LocalDateTime fechaRegistro;
    private Long idPais;

    // Constructor, getters y setters
}

