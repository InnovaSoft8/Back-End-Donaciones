package com.innovasoft.donacionesapi.servic.Impl;

import com.innovasoft.donacionesapi.dto.PatrocinadorDTO;
import com.innovasoft.donacionesapi.exception.CustomException;
import com.innovasoft.donacionesapi.model.Patrocinador;
import com.innovasoft.donacionesapi.model.Proyecto;
import com.innovasoft.donacionesapi.repository.PatrocinadorRepository;
import com.innovasoft.donacionesapi.repository.ProyectoRepository;
import com.innovasoft.donacionesapi.servic.PatrocinadorService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatrocinadorServiceImpl implements PatrocinadorService {

    private final PatrocinadorRepository patrocinadorRepository;
    private final ProyectoRepository proyectoRepository;
    private final ModelMapper modelMapper;

    public PatrocinadorServiceImpl(PatrocinadorRepository patrocinadorRepository,
                                   ProyectoRepository proyectoRepository,
                                   ModelMapper modelMapper) {
        this.patrocinadorRepository = patrocinadorRepository;
        this.proyectoRepository = proyectoRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<PatrocinadorDTO> getAllPatrocinadores() {
        List<Patrocinador> patrocinadores = patrocinadorRepository.findAll();
        return patrocinadores.stream()
                .map(patrocinador -> modelMapper.map(patrocinador, PatrocinadorDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public PatrocinadorDTO getPatrocinadorById(Long id) {
        Patrocinador patrocinador = patrocinadorRepository.findById(id)
                .orElseThrow(() -> new CustomException("Patrocinador no encontrado con ID: " + id));
        return modelMapper.map(patrocinador, PatrocinadorDTO.class);
    }

    @Override
    public PatrocinadorDTO createPatrocinador(PatrocinadorDTO patrocinadorDTO) {
        Patrocinador patrocinador = new Patrocinador();
        patrocinador.setNombre(patrocinadorDTO.getNombre());
        patrocinador.setDireccion(patrocinadorDTO.getDireccion());
        patrocinador.setCorreoElectronico(patrocinadorDTO.getCorreoElectronico());
        patrocinador.setTelefono(patrocinadorDTO.getTelefono());
        patrocinador.setFechaRegistro(patrocinadorDTO.getFechaRegistro());
        Proyecto proyecto = proyectoRepository.findById(patrocinadorDTO.getIdProyecto())
                .orElseThrow(() -> new CustomException("Proyecto no encontrado con ID: " + patrocinadorDTO.getIdProyecto()));
        patrocinador.setProyecto(proyecto);
        patrocinadorRepository.save(patrocinador);
        return modelMapper.map(patrocinador, PatrocinadorDTO.class);
    }

    @Override
    public PatrocinadorDTO updatePatrocinador(Long id, PatrocinadorDTO patrocinadorDTO) {
        Patrocinador patrocinador = patrocinadorRepository.findById(id)
                .orElseThrow(() -> new CustomException("Patrocinador no encontrado con ID: " + id));
        patrocinador.setNombre(patrocinadorDTO.getNombre());
        patrocinador.setDireccion(patrocinadorDTO.getDireccion());
        patrocinador.setCorreoElectronico(patrocinadorDTO.getCorreoElectronico());
        patrocinador.setTelefono(patrocinadorDTO.getTelefono());
        patrocinador.setFechaRegistro(patrocinadorDTO.getFechaRegistro());
        Proyecto proyecto = proyectoRepository.findById(patrocinadorDTO.getIdProyecto())
                .orElseThrow(() -> new CustomException("Proyecto no encontrado con ID: " + patrocinadorDTO.getIdProyecto()));
        patrocinador.setProyecto(proyecto);
        patrocinadorRepository.save(patrocinador);
        return modelMapper.map(patrocinador, PatrocinadorDTO.class);
    }

    @Override
    public void deletePatrocinador(Long id) {
        Patrocinador patrocinador = patrocinadorRepository.findById(id)
                .orElseThrow(() -> new CustomException("Patrocinador no encontrado con ID: " + id));
        patrocinadorRepository.delete(patrocinador);
    }
}