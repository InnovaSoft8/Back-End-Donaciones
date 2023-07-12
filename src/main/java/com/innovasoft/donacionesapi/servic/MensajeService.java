package com.innovasoft.donacionesapi.servic;

import com.innovasoft.donacionesapi.dto.MensajeDTO;

import java.util.List;

public interface MensajeService {

    List<MensajeDTO> getAllMensajes();

    MensajeDTO getMensajeById(Long id);

    MensajeDTO createMensaje(MensajeDTO mensajeDTO);

    MensajeDTO updateMensaje(Long id, MensajeDTO mensajeDTO);

    void deleteMensaje(Long id);
}