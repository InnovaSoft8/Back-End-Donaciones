package com.innovasoft.donacionesapi.repository;

import com.innovasoft.donacionesapi.model.PublicacionRedesSociales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublicacionRedesSocialesRepository extends JpaRepository<PublicacionRedesSociales, Long> {
    // Métodos personalizados de consulta si es necesario
}