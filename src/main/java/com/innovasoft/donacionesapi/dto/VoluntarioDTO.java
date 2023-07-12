package com.innovasoft.donacionesapi.dto;

import lombok.Data;

@Data
public class VoluntarioDTO {

    private Long idVoluntario;
    private String nombre;
    private String direccion;
    private String correoElectronico;
    private String telefono;
    private String fechaRegistro;
    private Long idPais;

    // Constructor, getters y setters
}