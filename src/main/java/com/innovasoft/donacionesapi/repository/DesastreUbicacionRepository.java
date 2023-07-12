package com.innovasoft.donacionesapi.repository;

import com.innovasoft.donacionesapi.model.DesastreUbicacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DesastreUbicacionRepository extends JpaRepository<DesastreUbicacion, Long> {
}