package com.innovasoft.donacionesapi.dto;

import lombok.Data;

@Data
public class PatrocinadorDTO {

    private Long idPatrocinador;
    private String nombre;
    private String direccion;
    private String correoElectronico;
    private String telefono;
    private String fechaRegistro;
    private Long idProyecto;

    // Constructor, getters y setters
}