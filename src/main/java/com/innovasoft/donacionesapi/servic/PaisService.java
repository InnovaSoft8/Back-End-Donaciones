package com.innovasoft.donacionesapi.servic;

import com.innovasoft.donacionesapi.dto.PaisDTO;

import java.util.List;

public interface PaisService {

    List<PaisDTO> getAllPaises();

    PaisDTO getPaisById(Long id);

    PaisDTO createPais(PaisDTO paisDTO);

    PaisDTO updatePais(Long id, PaisDTO paisDTO);

    void deletePais(Long id);
}