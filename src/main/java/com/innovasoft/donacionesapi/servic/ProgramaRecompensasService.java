package com.innovasoft.donacionesapi.servic;

import com.innovasoft.donacionesapi.dto.ProgramaRecompensasDTO;

import java.util.List;

public interface ProgramaRecompensasService {

    List<ProgramaRecompensasDTO> getAllProgramasRecompensas();

    ProgramaRecompensasDTO getProgramaRecompensasById(Long id);

    ProgramaRecompensasDTO createProgramaRecompensas(ProgramaRecompensasDTO programaRecompensasDTO);

    ProgramaRecompensasDTO updateProgramaRecompensas(Long id, ProgramaRecompensasDTO programaRecompensasDTO);

    void deleteProgramaRecompensas(Long id);
}