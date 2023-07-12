package com.innovasoft.donacionesapi.repository;

import com.innovasoft.donacionesapi.model.Patrocinador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatrocinadorRepository extends JpaRepository<Patrocinador, Long> {
    // Métodos personalizados de consulta si es necesario
}