package com.innovasoft.donacionesapi.servic.Impl;

import com.innovasoft.donacionesapi.dto.SubastaDTO;
import com.innovasoft.donacionesapi.exception.CustomException;
import com.innovasoft.donacionesapi.model.Proyecto;
import com.innovasoft.donacionesapi.model.Subasta;
import com.innovasoft.donacionesapi.repository.ProyectoRepository;
import com.innovasoft.donacionesapi.repository.SubastaRepository;
import com.innovasoft.donacionesapi.servic.SubastaService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubastaServiceImpl implements SubastaService {

    private final SubastaRepository subastaRepository;
    private final ProyectoRepository proyectoRepository;
    private final ModelMapper modelMapper;

    public SubastaServiceImpl(SubastaRepository subastaRepository, ProyectoRepository proyectoRepository,
                              ModelMapper modelMapper) {
        this.subastaRepository = subastaRepository;
        this.proyectoRepository = proyectoRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<SubastaDTO> getAllSubastas() {
        List<Subasta> subastas = subastaRepository.findAll();
        return subastas.stream()
                .map(subasta -> modelMapper.map(subasta, SubastaDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public SubastaDTO getSubastaById(Long id) {
        Subasta subasta = subastaRepository.findById(id)
                .orElseThrow(() -> new CustomException("Subasta no encontrada con ID: " + id));
        return modelMapper.map(subasta, SubastaDTO.class);
    }

    @Override
    public SubastaDTO createSubasta(SubastaDTO subastaDTO) {
        Proyecto proyecto = proyectoRepository.findById(subastaDTO.getIdProyecto())
                .orElseThrow(() -> new CustomException("Proyecto no encontrado con ID: " +
                        subastaDTO.getIdProyecto()));

        Subasta subasta = new Subasta();
        subasta.setNombre(subastaDTO.getNombre());
        subasta.setDescripcion(subastaDTO.getDescripcion());
        subasta.setFechaInicio(subastaDTO.getFechaInicio());
        subasta.setFechaFin(subastaDTO.getFechaFin());
        subasta.setProyecto(proyecto);

        subastaRepository.save(subasta);

        return modelMapper.map(subasta, SubastaDTO.class);
    }

    @Override
    public SubastaDTO updateSubasta(Long id, SubastaDTO subastaDTO) {
        Subasta subasta = subastaRepository.findById(id)
                .orElseThrow(() -> new CustomException("Subasta no encontrada con ID: " + id));

        Proyecto proyecto = proyectoRepository.findById(subastaDTO.getIdProyecto())
                .orElseThrow(() -> new CustomException("Proyecto no encontrado con ID: " +
                        subastaDTO.getIdProyecto()));

        subasta.setNombre(subastaDTO.getNombre());
        subasta.setDescripcion(subastaDTO.getDescripcion());
        subasta.setFechaInicio(subastaDTO.getFechaInicio());
        subasta.setFechaFin(subastaDTO.getFechaFin());
        subasta.setProyecto(proyecto);

        subastaRepository.save(subasta);

        return modelMapper.map(subasta, SubastaDTO.class);
    }

    @Override
    public void deleteSubasta(Long id) {
        Subasta subasta = subastaRepository.findById(id)
                .orElseThrow(() -> new CustomException("Subasta no encontrada con ID: " + id));

        subastaRepository.delete(subasta);
    }
}