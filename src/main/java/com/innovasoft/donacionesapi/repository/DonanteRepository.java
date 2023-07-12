package com.innovasoft.donacionesapi.repository;

import com.innovasoft.donacionesapi.model.Donante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonanteRepository extends JpaRepository<Donante, Long> {
    // Métodos personalizados de consulta si es necesario
}