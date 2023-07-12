package com.innovasoft.donacionesapi.servic.Impl;

import com.innovasoft.donacionesapi.dto.ComentarioDTO;
import com.innovasoft.donacionesapi.exception.CustomException;
import com.innovasoft.donacionesapi.model.Comentario;
import com.innovasoft.donacionesapi.model.Donante;
import com.innovasoft.donacionesapi.model.Proyecto;
import com.innovasoft.donacionesapi.repository.ComentarioRepository;
import com.innovasoft.donacionesapi.repository.DonanteRepository;
import com.innovasoft.donacionesapi.repository.ProyectoRepository;
import com.innovasoft.donacionesapi.servic.ComentarioService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ComentarioServiceImpl implements ComentarioService {

    private final ComentarioRepository comentarioRepository;
    private final DonanteRepository donanteRepository;
    private final ProyectoRepository proyectoRepository;
    private final ModelMapper modelMapper;

    public ComentarioServiceImpl(ComentarioRepository comentarioRepository, DonanteRepository donanteRepository,
                                 ProyectoRepository proyectoRepository, ModelMapper modelMapper) {
        this.comentarioRepository = comentarioRepository;
        this.donanteRepository = donanteRepository;
        this.proyectoRepository = proyectoRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ComentarioDTO> getAllComentarios() {
        List<Comentario> comentarios = comentarioRepository.findAll();
        return comentarios.stream()
                .map(comentario -> modelMapper.map(comentario, ComentarioDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ComentarioDTO getComentarioById(Long id) {
        Comentario comentario = comentarioRepository.findById(id)
                .orElseThrow(() -> new CustomException("Comentario no encontrado con ID: " + id));
        return modelMapper.map(comentario, ComentarioDTO.class);
    }

    @Override
    public ComentarioDTO createComentario(ComentarioDTO comentarioDTO) {
        Comentario comentario = new Comentario();
        comentario.setContenido(comentarioDTO.getContenido());
        comentario.setFechaHora(LocalDateTime.now());
        Donante donante = donanteRepository.findById(comentarioDTO.getIdDonante())
                .orElseThrow(() -> new CustomException("Donante no encontrado con ID: " + comentarioDTO.getIdDonante()));
        comentario.setDonante(donante);
        Proyecto proyecto = proyectoRepository.findById(comentarioDTO.getIdProyecto())
                .orElseThrow(() -> new CustomException("Proyecto no encontrado con ID: " + comentarioDTO.getIdProyecto()));
        comentario.setProyecto(proyecto);
        Comentario savedComentario = comentarioRepository.save(comentario);
        return modelMapper.map(savedComentario, ComentarioDTO.class);
    }

    @Override
    public ComentarioDTO updateComentario(Long id, ComentarioDTO comentarioDTO) {
        Comentario comentario = comentarioRepository.findById(id)
                .orElseThrow(() -> new CustomException("Comentario no encontrado con ID: " + id));
        comentario.setContenido(comentarioDTO.getContenido());
        Donante donante = donanteRepository.findById(comentarioDTO.getIdDonante())
                .orElseThrow(() -> new CustomException("Donante no encontrado con ID: " + comentarioDTO.getIdDonante()));
        comentario.setDonante(donante);
        Proyecto proyecto = proyectoRepository.findById(comentarioDTO.getIdProyecto())
                .orElseThrow(() -> new CustomException("Proyecto no encontrado con ID: " + comentarioDTO.getIdProyecto()));
        comentario.setProyecto(proyecto);
        Comentario updatedComentario = comentarioRepository.save(comentario);
        return modelMapper.map(updatedComentario, ComentarioDTO.class);
    }

    @Override
    public void deleteComentario(Long id) {
        Comentario comentario = comentarioRepository.findById(id)
                .orElseThrow(() -> new CustomException("Comentario no encontrado con ID: " + id));
        comentarioRepository.delete(comentario);
    }
}