package com.innovasoft.donacionesapi.servic;

import com.innovasoft.donacionesapi.dto.ProyectoDTO;

import java.util.List;

public interface ProyectoService {

    List<ProyectoDTO> getAllProyectos();

    ProyectoDTO getProyectoById(Long id);

    ProyectoDTO createProyecto(ProyectoDTO proyectoDTO);

    ProyectoDTO updateProyecto(Long id, ProyectoDTO proyectoDTO);

    void deleteProyecto(Long id);
}