package com.innovasoft.donacionesapi.repository;

import com.innovasoft.donacionesapi.model.Receptor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceptorRepository extends JpaRepository<Receptor, Long> {
}