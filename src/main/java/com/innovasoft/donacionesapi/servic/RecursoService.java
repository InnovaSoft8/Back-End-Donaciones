package com.innovasoft.donacionesapi.servic;

import com.innovasoft.donacionesapi.dto.RecursoDTO;

import java.util.List;

public interface RecursoService {

    List<RecursoDTO> getAllRecursos();

    RecursoDTO getRecursoById(Long id);

    RecursoDTO createRecurso(RecursoDTO recursoDTO);

    RecursoDTO updateRecurso(Long id, RecursoDTO recursoDTO);

    void deleteRecurso(Long id);
}