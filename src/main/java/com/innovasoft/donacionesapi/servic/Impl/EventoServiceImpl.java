package com.innovasoft.donacionesapi.servic.Impl;

import com.innovasoft.donacionesapi.dto.EventoDTO;
import com.innovasoft.donacionesapi.exception.CustomException;
import com.innovasoft.donacionesapi.model.Evento;
import com.innovasoft.donacionesapi.model.Proyecto;
import com.innovasoft.donacionesapi.repository.EventoRepository;
import com.innovasoft.donacionesapi.repository.ProyectoRepository;
import com.innovasoft.donacionesapi.servic.EventoService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventoServiceImpl implements EventoService {

    private final EventoRepository eventoRepository;
    private final ProyectoRepository proyectoRepository;
    private final ModelMapper modelMapper;

    public EventoServiceImpl(EventoRepository eventoRepository,
                             ProyectoRepository proyectoRepository,
                             ModelMapper modelMapper) {
        this.eventoRepository = eventoRepository;
        this.proyectoRepository = proyectoRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<EventoDTO> getAllEventos() {
        List<Evento> eventos = eventoRepository.findAll();
        return eventos.stream()
                .map(evento -> modelMapper.map(evento, EventoDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public EventoDTO getEventoById(Long id) {
        Evento evento = eventoRepository.findById(id)
                .orElseThrow(() -> new CustomException("Evento no encontrado con ID: " + id));
        return modelMapper.map(evento, EventoDTO.class);
    }

    @Override
    public EventoDTO createEvento(EventoDTO eventoDTO) {
        Evento evento = new Evento();
        evento.setNombre(eventoDTO.getNombre());
        evento.setDescripcion(eventoDTO.getDescripcion());
        evento.setFechaHora(eventoDTO.getFechaHora());
        Proyecto proyecto = proyectoRepository.findById(eventoDTO.getIdProyecto())
                .orElseThrow(() -> new CustomException("Proyecto no encontrado con ID: " + eventoDTO.getIdProyecto()));
        evento.setProyecto(proyecto);
        eventoRepository.save(evento);
        return modelMapper.map(evento, EventoDTO.class);
    }

    @Override
    public EventoDTO updateEvento(Long id, EventoDTO eventoDTO) {
        Evento evento = eventoRepository.findById(id)
                .orElseThrow(() -> new CustomException("Evento no encontrado con ID: " + id));
        evento.setNombre(eventoDTO.getNombre());
        evento.setDescripcion(eventoDTO.getDescripcion());
        evento.setFechaHora(eventoDTO.getFechaHora());
        Proyecto proyecto = proyectoRepository.findById(eventoDTO.getIdProyecto())
                .orElseThrow(() -> new CustomException("Proyecto no encontrado con ID: " + eventoDTO.getIdProyecto()));
        evento.setProyecto(proyecto);
        eventoRepository.save(evento);
        return modelMapper.map(evento, EventoDTO.class);
    }

    @Override
    public void deleteEvento(Long id) {
        Evento evento = eventoRepository.findById(id)
                .orElseThrow(() -> new CustomException("Evento no encontrado con ID: " + id));
        eventoRepository.delete(evento);
    }
}
