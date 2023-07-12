package com.innovasoft.donacionesapi.servic.Impl;

import com.innovasoft.donacionesapi.dto.PublicacionRedesSocialesDTO;
import com.innovasoft.donacionesapi.exception.CustomException;
import com.innovasoft.donacionesapi.model.Proyecto;
import com.innovasoft.donacionesapi.model.PublicacionRedesSociales;
import com.innovasoft.donacionesapi.repository.ProyectoRepository;
import com.innovasoft.donacionesapi.repository.PublicacionRedesSocialesRepository;
import com.innovasoft.donacionesapi.servic.PublicacionRedesSocialesService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PublicacionRedesSocialesServiceImpl implements PublicacionRedesSocialesService {

    private final PublicacionRedesSocialesRepository publicacionRepository;
    private final ProyectoRepository proyectoRepository;
    private final ModelMapper modelMapper;

    public PublicacionRedesSocialesServiceImpl(PublicacionRedesSocialesRepository publicacionRepository,
                                               ProyectoRepository proyectoRepository, ModelMapper modelMapper) {
        this.publicacionRepository = publicacionRepository;
        this.proyectoRepository = proyectoRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<PublicacionRedesSocialesDTO> getAllPublicaciones() {
        List<PublicacionRedesSociales> publicaciones = publicacionRepository.findAll();
        return publicaciones.stream()
                .map(publicacion -> modelMapper.map(publicacion, PublicacionRedesSocialesDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public PublicacionRedesSocialesDTO getPublicacionById(Long id) {
        PublicacionRedesSociales publicacion = publicacionRepository.findById(id)
                .orElseThrow(() -> new CustomException("Publicación no encontrada con ID: " + id));
        return modelMapper.map(publicacion, PublicacionRedesSocialesDTO.class);
    }

    @Override
    public PublicacionRedesSocialesDTO createPublicacion(PublicacionRedesSocialesDTO publicacionDTO) {
        Proyecto proyecto = proyectoRepository.findById(publicacionDTO.getIdProyecto())
                .orElseThrow(() -> new CustomException("Proyecto no encontrado con ID: " +
                        publicacionDTO.getIdProyecto()));

        PublicacionRedesSociales publicacion = new PublicacionRedesSociales();
        publicacion.setContenido(publicacionDTO.getContenido());
        publicacion.setFechaHora(publicacionDTO.getFechaHora());
        publicacion.setProyecto(proyecto);

        publicacionRepository.save(publicacion);

        return modelMapper.map(publicacion, PublicacionRedesSocialesDTO.class);
    }

    @Override
    public PublicacionRedesSocialesDTO updatePublicacion(Long id, PublicacionRedesSocialesDTO publicacionDTO) {
        PublicacionRedesSociales publicacion = publicacionRepository.findById(id)
                .orElseThrow(() -> new CustomException("Publicación no encontrada con ID: " + id));

        Proyecto proyecto = proyectoRepository.findById(publicacionDTO.getIdProyecto())
                .orElseThrow(() -> new CustomException("Proyecto no encontrado con ID: " +
                        publicacionDTO.getIdProyecto()));

        publicacion.setContenido(publicacionDTO.getContenido());
        publicacion.setFechaHora(publicacionDTO.getFechaHora());
        publicacion.setProyecto(proyecto);

        publicacionRepository.save(publicacion);

        return modelMapper.map(publicacion, PublicacionRedesSocialesDTO.class);
    }

    @Override
    public void deletePublicacion(Long id) {
        PublicacionRedesSociales publicacion = publicacionRepository.findById(id)
                .orElseThrow(() -> new CustomException("Publicación no encontrada con ID: " + id));

        publicacionRepository.delete(publicacion);
    }
}