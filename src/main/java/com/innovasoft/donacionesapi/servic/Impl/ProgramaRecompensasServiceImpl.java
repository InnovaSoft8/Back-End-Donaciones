package com.innovasoft.donacionesapi.servic.Impl;

import com.innovasoft.donacionesapi.dto.ProgramaRecompensasDTO;
import com.innovasoft.donacionesapi.exception.CustomException;
import com.innovasoft.donacionesapi.model.ProgramaRecompensas;
import com.innovasoft.donacionesapi.model.Proyecto;
import com.innovasoft.donacionesapi.repository.ProgramaRecompensasRepository;
import com.innovasoft.donacionesapi.repository.ProyectoRepository;
import com.innovasoft.donacionesapi.servic.ProgramaRecompensasService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProgramaRecompensasServiceImpl implements ProgramaRecompensasService {

    private final ProgramaRecompensasRepository programaRecompensasRepository;
    private final ProyectoRepository proyectoRepository;
    private final ModelMapper modelMapper;

    public ProgramaRecompensasServiceImpl(ProgramaRecompensasRepository programaRecompensasRepository,
                                          ProyectoRepository proyectoRepository, ModelMapper modelMapper) {
        this.programaRecompensasRepository = programaRecompensasRepository;
        this.proyectoRepository = proyectoRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ProgramaRecompensasDTO> getAllProgramasRecompensas() {
        List<ProgramaRecompensas> programasRecompensas = programaRecompensasRepository.findAll();
        return programasRecompensas.stream()
                .map(programa -> modelMapper.map(programa, ProgramaRecompensasDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ProgramaRecompensasDTO getProgramaRecompensasById(Long id) {
        ProgramaRecompensas programaRecompensas = programaRecompensasRepository.findById(id)
                .orElseThrow(() -> new CustomException("Programa de recompensas no encontrado con ID: " + id));
        return modelMapper.map(programaRecompensas, ProgramaRecompensasDTO.class);
    }

    @Override
    public ProgramaRecompensasDTO createProgramaRecompensas(ProgramaRecompensasDTO programaRecompensasDTO) {
        Proyecto proyecto = proyectoRepository.findById(programaRecompensasDTO.getIdProyecto())
                .orElseThrow(() -> new CustomException("Proyecto no encontrado con ID: " +
                        programaRecompensasDTO.getIdProyecto()));

        ProgramaRecompensas programaRecompensas = new ProgramaRecompensas();
        programaRecompensas.setNombre(programaRecompensasDTO.getNombre());
        programaRecompensas.setDescripcion(programaRecompensasDTO.getDescripcion());
        programaRecompensas.setProyecto(proyecto);

        programaRecompensasRepository.save(programaRecompensas);

        return modelMapper.map(programaRecompensas, ProgramaRecompensasDTO.class);
    }

    @Override
    public ProgramaRecompensasDTO updateProgramaRecompensas(Long id, ProgramaRecompensasDTO programaRecompensasDTO) {
        ProgramaRecompensas programaRecompensas = programaRecompensasRepository.findById(id)
                .orElseThrow(() -> new CustomException("Programa de recompensas no encontrado con ID: " + id));

        Proyecto proyecto = proyectoRepository.findById(programaRecompensasDTO.getIdProyecto())
                .orElseThrow(() -> new CustomException("Proyecto no encontrado con ID: " +
                        programaRecompensasDTO.getIdProyecto()));

        programaRecompensas.setNombre(programaRecompensasDTO.getNombre());
        programaRecompensas.setDescripcion(programaRecompensasDTO.getDescripcion());
        programaRecompensas.setProyecto(proyecto);

        programaRecompensasRepository.save(programaRecompensas);

        return modelMapper.map(programaRecompensas, ProgramaRecompensasDTO.class);
    }

    @Override
    public void deleteProgramaRecompensas(Long id) {
        ProgramaRecompensas programaRecompensas = programaRecompensasRepository.findById(id)
                .orElseThrow(() -> new CustomException("Programa de recompensas no encontrado con ID: " + id));

        programaRecompensasRepository.delete(programaRecompensas);
    }
}