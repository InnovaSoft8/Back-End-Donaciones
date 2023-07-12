package com.innovasoft.donacionesapi.servic;

import com.innovasoft.donacionesapi.dto.PatrocinadorDTO;

import java.util.List;

public interface PatrocinadorService {

    List<PatrocinadorDTO> getAllPatrocinadores();

    PatrocinadorDTO getPatrocinadorById(Long id);

    PatrocinadorDTO createPatrocinador(PatrocinadorDTO patrocinadorDTO);

    PatrocinadorDTO updatePatrocinador(Long id, PatrocinadorDTO patrocinadorDTO);

    void deletePatrocinador(Long id);
}
