package com.innovasoft.donacionesapi.servic;

import com.innovasoft.donacionesapi.dto.DonanteDTO;

import java.util.List;

public interface DonanteService {

    DonanteDTO getDonanteById(Long id);

    List<DonanteDTO> getAllDonantes();

    DonanteDTO createDonante(DonanteDTO donanteDTO);

    DonanteDTO updateDonante(Long id, DonanteDTO donanteDTO);

    void deleteDonante(Long id);

    // Otros métodos del servicio según tus necesidades
}