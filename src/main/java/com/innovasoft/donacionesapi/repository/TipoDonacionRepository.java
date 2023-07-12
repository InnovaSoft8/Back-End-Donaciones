package com.innovasoft.donacionesapi.repository;

import com.innovasoft.donacionesapi.model.TipoDonacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoDonacionRepository extends JpaRepository<TipoDonacion, Long> {
}