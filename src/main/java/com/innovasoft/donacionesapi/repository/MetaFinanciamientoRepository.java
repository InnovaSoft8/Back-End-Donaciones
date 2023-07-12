package com.innovasoft.donacionesapi.repository;

import com.innovasoft.donacionesapi.model.MetaFinanciamiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetaFinanciamientoRepository extends JpaRepository<MetaFinanciamiento, Long> {
    // Métodos personalizados de consulta si es necesario
}