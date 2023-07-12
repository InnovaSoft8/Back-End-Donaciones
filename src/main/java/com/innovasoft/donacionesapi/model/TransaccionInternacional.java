package com.innovasoft.donacionesapi.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "transacciones_internacionales")
@Data
public class TransaccionInternacional {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "monto")
    private Double monto;

    @Column(name = "fecha_hora")
    private LocalDateTime fechaHora;

    @ManyToOne
    @JoinColumn(name = "donante_id")
    private Donante donante;

    @ManyToOne
    @JoinColumn(name = "pais_id")
    private Pais pais;

    // Otros campos según tus necesidades

    // Constructor, getters/setters y otros métodos según tus necesidades
}