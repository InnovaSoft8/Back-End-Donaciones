package com.innovasoft.donacionesapi.repository;

import com.innovasoft.donacionesapi.model.ProductoDonado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoDonadoRepository extends JpaRepository<ProductoDonado, Long> {
    // Métodos personalizados de consulta si es necesario
}