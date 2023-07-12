package com.innovasoft.donacionesapi.servic.Impl;

import com.innovasoft.donacionesapi.dto.MetaFinanciamientoDTO;
import com.innovasoft.donacionesapi.exception.CustomException;
import com.innovasoft.donacionesapi.model.MetaFinanciamiento;
import com.innovasoft.donacionesapi.model.Proyecto;
import com.innovasoft.donacionesapi.repository.MetaFinanciamientoRepository;
import com.innovasoft.donacionesapi.repository.ProyectoRepository;
import com.innovasoft.donacionesapi.servic.MetaFinanciamientoService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MetaFinanciamientoServiceImpl implements MetaFinanciamientoService {

    private final MetaFinanciamientoRepository metaFinanciamientoRepository;
    private final ProyectoRepository proyectoRepository;
    private final ModelMapper modelMapper;

    public MetaFinanciamientoServiceImpl(MetaFinanciamientoRepository metaFinanciamientoRepository,
                                         ProyectoRepository proyectoRepository, ModelMapper modelMapper) {
        this.metaFinanciamientoRepository = metaFinanciamientoRepository;
        this.proyectoRepository = proyectoRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<MetaFinanciamientoDTO> getAllMetasFinanciamiento() {
        List<MetaFinanciamiento> metasFinanciamiento = metaFinanciamientoRepository.findAll();
        return metasFinanciamiento.stream()
                .map(meta -> modelMapper.map(meta, MetaFinanciamientoDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public MetaFinanciamientoDTO getMetaFinanciamientoById(Long id) {
        MetaFinanciamiento metaFinanciamiento = metaFinanciamientoRepository.findById(id)
                .orElseThrow(() -> new CustomException("Meta de financiamiento no encontrada con ID: " + id));
        return modelMapper.map(metaFinanciamiento, MetaFinanciamientoDTO.class);
    }

    @Override
    public MetaFinanciamientoDTO createMetaFinanciamiento(MetaFinanciamientoDTO metaFinanciamientoDTO) {
        Proyecto proyecto = proyectoRepository.findById(metaFinanciamientoDTO.getIdProyecto())
                .orElseThrow(() -> new CustomException("Proyecto no encontrado con ID: " +
                        metaFinanciamientoDTO.getIdProyecto()));

        MetaFinanciamiento metaFinanciamiento = new MetaFinanciamiento();
        metaFinanciamiento.setMontoObjetivo(metaFinanciamientoDTO.getMontoObjetivo());
        metaFinanciamiento.setFechaLimite(metaFinanciamientoDTO.getFechaLimite());
        metaFinanciamiento.setProyecto(proyecto);

        metaFinanciamientoRepository.save(metaFinanciamiento);

        return modelMapper.map(metaFinanciamiento, MetaFinanciamientoDTO.class);
    }

    @Override
    public MetaFinanciamientoDTO updateMetaFinanciamiento(Long id, MetaFinanciamientoDTO metaFinanciamientoDTO) {
        MetaFinanciamiento metaFinanciamiento = metaFinanciamientoRepository.findById(id)
                .orElseThrow(() -> new CustomException("Meta de financiamiento no encontrada con ID: " + id));

        Proyecto proyecto = proyectoRepository.findById(metaFinanciamientoDTO.getIdProyecto())
                .orElseThrow(() -> new CustomException("Proyecto no encontrado con ID: " +
                        metaFinanciamientoDTO.getIdProyecto()));

        metaFinanciamiento.setMontoObjetivo(metaFinanciamientoDTO.getMontoObjetivo());
        metaFinanciamiento.setFechaLimite(metaFinanciamientoDTO.getFechaLimite());
        metaFinanciamiento.setProyecto(proyecto);

        metaFinanciamientoRepository.save(metaFinanciamiento);

        return modelMapper.map(metaFinanciamiento, MetaFinanciamientoDTO.class);
    }

    @Override
    public void deleteMetaFinanciamiento(Long id) {
        MetaFinanciamiento metaFinanciamiento = metaFinanciamientoRepository.findById(id)
                .orElseThrow(() -> new CustomException("Meta de financiamiento no encontrada con ID: " + id));

        metaFinanciamientoRepository.delete(metaFinanciamiento);
    }
}