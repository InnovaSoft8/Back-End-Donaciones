package com.innovasoft.donacionesapi.repository;

import com.innovasoft.donacionesapi.model.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProyectoRepository extends JpaRepository<Proyecto, Long> {
    // Métodos personalizados de consulta si es necesario
}