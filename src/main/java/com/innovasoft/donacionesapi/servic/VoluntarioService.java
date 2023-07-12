package com.innovasoft.donacionesapi.servic;

import com.innovasoft.donacionesapi.dto.VoluntarioDTO;

import java.util.List;

public interface VoluntarioService {

    List<VoluntarioDTO> getAllVoluntarios();

    VoluntarioDTO getVoluntarioById(Long id);

    VoluntarioDTO createVoluntario(VoluntarioDTO voluntarioDTO);

    VoluntarioDTO updateVoluntario(Long id, VoluntarioDTO voluntarioDTO);

    void deleteVoluntario(Long id);
}