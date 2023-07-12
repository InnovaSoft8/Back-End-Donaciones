package com.innovasoft.donacionesapi.repository;

import com.innovasoft.donacionesapi.model.Desastre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DesastreRepository extends JpaRepository<Desastre, Long> {
}