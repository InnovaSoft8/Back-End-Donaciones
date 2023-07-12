package com.innovasoft.donacionesapi.servic.Impl;

import com.innovasoft.donacionesapi.dto.ProyectoDTO;
import com.innovasoft.donacionesapi.exception.CustomException;
import com.innovasoft.donacionesapi.model.Desastre;
import com.innovasoft.donacionesapi.model.Proyecto;
import com.innovasoft.donacionesapi.model.Receptor;
import com.innovasoft.donacionesapi.repository.DesastreRepository;
import com.innovasoft.donacionesapi.repository.ProyectoRepository;
import com.innovasoft.donacionesapi.repository.ReceptorRepository;
import com.innovasoft.donacionesapi.servic.ProyectoService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProyectoServiceImpl implements ProyectoService {

    private final ProyectoRepository proyectoRepository;
    private final ReceptorRepository receptorRepository;
    private final DesastreRepository desastreRepository;
    private final ModelMapper modelMapper;

    public ProyectoServiceImpl(ProyectoRepository proyectoRepository, ReceptorRepository receptorRepository, DesastreRepository desastreRepository, ModelMapper modelMapper) {
        this.proyectoRepository = proyectoRepository;
        this.receptorRepository = receptorRepository;
        this.desastreRepository = desastreRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ProyectoDTO> getAllProyectos() {
        List<Proyecto> proyectos = proyectoRepository.findAll();
        return proyectos.stream()
                .map(proyecto -> modelMapper.map(proyecto, ProyectoDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ProyectoDTO getProyectoById(Long id) {
        Proyecto proyecto = proyectoRepository.findById(id)
                .orElseThrow(() -> new CustomException("Proyecto no encontrado con ID: " + id));
        return modelMapper.map(proyecto, ProyectoDTO.class);
    }

    @Override
    public ProyectoDTO createProyecto(ProyectoDTO proyectoDTO) {
        Proyecto proyecto = modelMapper.map(proyectoDTO, Proyecto.class);
        Receptor receptor = receptorRepository.findById(proyectoDTO.getIdReceptor())
                .orElseThrow(() -> new CustomException("Receptor no encontrado con ID: " + proyectoDTO.getIdReceptor()));
        Desastre desastre = desastreRepository.findById(proyectoDTO.getIdDesastre())
                .orElseThrow(() -> new CustomException("Desastre no encontrado con ID: " + proyectoDTO.getIdDesastre()));
        proyecto.setReceptor(receptor);
        proyecto.setDesastre(desastre);
        Proyecto savedProyecto = proyectoRepository.save(proyecto);
        return modelMapper.map(savedProyecto, ProyectoDTO.class);
    }

    @Override
    public ProyectoDTO updateProyecto(Long id, ProyectoDTO proyectoDTO) {
        Proyecto proyecto = proyectoRepository.findById(id)
                .orElseThrow(() -> new CustomException("Proyecto no encontrado con ID: " + id));
        proyecto.setNombre(proyectoDTO.getNombre());
        proyecto.setDescripcion(proyectoDTO.getDescripcion());
        Receptor receptor = receptorRepository.findById(proyectoDTO.getIdReceptor())
                .orElseThrow(() -> new CustomException("Receptor no encontrado con ID: " + proyectoDTO.getIdReceptor()));
        Desastre desastre = desastreRepository.findById(proyectoDTO.getIdDesastre())
                .orElseThrow(() -> new CustomException("Desastre no encontrado con ID: " + proyectoDTO.getIdDesastre()));
        proyecto.setReceptor(receptor);
        proyecto.setDesastre(desastre);
        proyecto.setFechaInicio(proyectoDTO.getFechaInicio());
        proyecto.setFechaFin(proyectoDTO.getFechaFin());
        proyecto.setMontoMeta(proyectoDTO.getMontoMeta());
        proyecto.setMontoRecaudado(proyectoDTO.getMontoRecaudado());
        Proyecto updatedProyecto = proyectoRepository.save(proyecto);
        return modelMapper.map(updatedProyecto, ProyectoDTO.class);
    }

    @Override
    public void deleteProyecto(Long id) {
        Proyecto proyecto = proyectoRepository.findById(id)
                .orElseThrow(() -> new CustomException("Proyecto no encontrado con ID: " + id));
        proyectoRepository.delete(proyecto);
    }
}