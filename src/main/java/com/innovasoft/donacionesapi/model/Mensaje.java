package com.innovasoft.donacionesapi.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "Mensajes")
@Data
public class Mensaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMensaje;

    @ManyToOne
    @JoinColumn(name = "idDonanteEmisor")
    private Donante donanteEmisor;

    @ManyToOne
    @JoinColumn(name = "idVoluntarioEmisor")
    private Voluntario voluntarioEmisor;

    @ManyToOne
    @JoinColumn(name = "idDonanteReceptor")
    private Donante donanteReceptor;

    @ManyToOne
    @JoinColumn(name = "idVoluntarioReceptor")
    private Voluntario voluntarioReceptor;

    private LocalDateTime fechaHoraMensaje;
    private String contenidoMensaje;
    private String estadoMensaje;

    // Constructor, getters y setters
}