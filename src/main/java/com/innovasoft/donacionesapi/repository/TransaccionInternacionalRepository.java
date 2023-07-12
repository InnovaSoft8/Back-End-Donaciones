package com.innovasoft.donacionesapi.repository;

import com.innovasoft.donacionesapi.model.TransaccionInternacional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransaccionInternacionalRepository extends JpaRepository<TransaccionInternacional, Long> {
    // Métodos personalizados de consulta si es necesario
}