package com.innovasoft.donacionesapi.repository;

import com.innovasoft.donacionesapi.model.Pais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaisRepository extends JpaRepository<Pais, Long> {
    // Métodos personalizados de consulta si es necesario
}