package com.innovasoft.donacionesapi.servic;

import com.innovasoft.donacionesapi.dto.EventoDTO;

import java.util.List;

public interface EventoService {

    List<EventoDTO> getAllEventos();

    EventoDTO getEventoById(Long id);

    EventoDTO createEvento(EventoDTO eventoDTO);

    EventoDTO updateEvento(Long id, EventoDTO eventoDTO);

    void deleteEvento(Long id);
}