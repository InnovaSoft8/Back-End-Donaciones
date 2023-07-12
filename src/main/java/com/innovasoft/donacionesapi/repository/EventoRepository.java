package com.innovasoft.donacionesapi.repository;

import com.innovasoft.donacionesapi.model.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long> {
    // Métodos personalizados de consulta si es necesario
}