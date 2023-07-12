package com.innovasoft.donacionesapi.repository;

import com.innovasoft.donacionesapi.model.Subasta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubastaRepository extends JpaRepository<Subasta, Long> {
    // Métodos personalizados de consulta si es necesario
}