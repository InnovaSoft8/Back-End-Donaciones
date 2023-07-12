package com.innovasoft.donacionesapi.repository;

import com.innovasoft.donacionesapi.model.Recurso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecursoRepository extends JpaRepository<Recurso, Long> {
    // Métodos personalizados de consulta si es necesario
}