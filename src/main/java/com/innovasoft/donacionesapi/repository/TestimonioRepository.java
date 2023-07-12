package com.innovasoft.donacionesapi.repository;

import com.innovasoft.donacionesapi.model.Testimonio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestimonioRepository extends JpaRepository<Testimonio, Long> {
    // Métodos personalizados de consulta si es necesario
}