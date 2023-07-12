package com.innovasoft.donacionesapi.repository;

import com.innovasoft.donacionesapi.model.Transaccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransaccionRepository extends JpaRepository<Transaccion, Long> {
    // Métodos personalizados de consulta si es necesario
}