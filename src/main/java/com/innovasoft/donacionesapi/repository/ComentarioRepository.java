package com.innovasoft.donacionesapi.repository;

import com.innovasoft.donacionesapi.model.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario, Long> {
    // Métodos personalizados de consulta si es necesario
}