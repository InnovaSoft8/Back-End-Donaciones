package com.innovasoft.donacionesapi.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TransaccionInternacionalDTO {
    private Long id;
    private Double monto;
    private LocalDateTime fechaHora;
    private Long donanteId;
    private Long paisId;
    // Otros campos y métodos getter/setter según tus necesidades
}