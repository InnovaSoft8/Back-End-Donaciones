package com.innovasoft.donacionesapi.servic.Impl;

import com.innovasoft.donacionesapi.dto.RecursoDTO;
import com.innovasoft.donacionesapi.exception.CustomException;
import com.innovasoft.donacionesapi.model.Proyecto;
import com.innovasoft.donacionesapi.model.Recurso;
import com.innovasoft.donacionesapi.repository.ProyectoRepository;
import com.innovasoft.donacionesapi.repository.RecursoRepository;
import com.innovasoft.donacionesapi.servic.RecursoService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecursoServiceImpl implements RecursoService {

    private final RecursoRepository recursoRepository;
    private final ProyectoRepository proyectoRepository;
    private final ModelMapper modelMapper;

    public RecursoServiceImpl(RecursoRepository recursoRepository, ProyectoRepository proyectoRepository,
                              ModelMapper modelMapper) {
        this.recursoRepository = recursoRepository;
        this.proyectoRepository = proyectoRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<RecursoDTO> getAllRecursos() {
        List<Recurso> recursos = recursoRepository.findAll();
        return recursos.stream()
                .map(recurso -> modelMapper.map(recurso, RecursoDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public RecursoDTO getRecursoById(Long id) {
        Recurso recurso = recursoRepository.findById(id)
                .orElseThrow(() -> new CustomException("Recurso no encontrado con ID: " + id));
        return modelMapper.map(recurso, RecursoDTO.class);
    }

    @Override
    public RecursoDTO createRecurso(RecursoDTO recursoDTO) {
        Proyecto proyecto = proyectoRepository.findById(recursoDTO.getIdProyecto())
                .orElseThrow(() -> new CustomException("Proyecto no encontrado con ID: " +
                        recursoDTO.getIdProyecto()));

        Recurso recurso = new Recurso();
        recurso.setNombre(recursoDTO.getNombre());
        recurso.setDescripcion(recursoDTO.getDescripcion());
        recurso.setProyecto(proyecto);

        recursoRepository.save(recurso);

        return modelMapper.map(recurso, RecursoDTO.class);
    }

    @Override
    public RecursoDTO updateRecurso(Long id, RecursoDTO recursoDTO) {
        Recurso recurso = recursoRepository.findById(id)
                .orElseThrow(() -> new CustomException("Recurso no encontrado con ID: " + id));

        Proyecto proyecto = proyectoRepository.findById(recursoDTO.getIdProyecto())
                .orElseThrow(() -> new CustomException("Proyecto no encontrado con ID: " +
                        recursoDTO.getIdProyecto()));

        recurso.setNombre(recursoDTO.getNombre());
        recurso.setDescripcion(recursoDTO.getDescripcion());
        recurso.setProyecto(proyecto);

        recursoRepository.save(recurso);

        return modelMapper.map(recurso, RecursoDTO.class);
    }

    @Override
    public void deleteRecurso(Long id) {
        Recurso recurso = recursoRepository.findById(id)
                .orElseThrow(() -> new CustomException("Recurso no encontrado con ID: " + id));

        recursoRepository.delete(recurso);
    }
}