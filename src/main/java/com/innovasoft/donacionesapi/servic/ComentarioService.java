package com.innovasoft.donacionesapi.servic;

import com.innovasoft.donacionesapi.dto.ComentarioDTO;

import java.util.List;

public interface ComentarioService {

    List<ComentarioDTO> getAllComentarios();

    ComentarioDTO getComentarioById(Long id);

    ComentarioDTO createComentario(ComentarioDTO comentarioDTO);

    ComentarioDTO updateComentario(Long id, ComentarioDTO comentarioDTO);

    void deleteComentario(Long id);
}