package com.innovasoft.donacionesapi.servic.Impl;

import com.innovasoft.donacionesapi.dto.DesastreUbicacionDTO;
import com.innovasoft.donacionesapi.exception.CustomException;
import com.innovasoft.donacionesapi.model.Desastre;
import com.innovasoft.donacionesapi.model.DesastreUbicacion;
import com.innovasoft.donacionesapi.model.Ubicacion;
import com.innovasoft.donacionesapi.repository.DesastreUbicacionRepository;
import com.innovasoft.donacionesapi.servic.DesastreUbicacionService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DesastreUbicacionServiceImpl implements DesastreUbicacionService {

    private final DesastreUbicacionRepository desastreUbicacionRepository;
    private final ModelMapper modelMapper;

    public DesastreUbicacionServiceImpl(DesastreUbicacionRepository desastreUbicacionRepository, ModelMapper modelMapper) {
        this.desastreUbicacionRepository = desastreUbicacionRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<DesastreUbicacionDTO> getAllDesastreUbicaciones() {
        List<DesastreUbicacion> desastreUbicaciones = desastreUbicacionRepository.findAll();
        return desastreUbicaciones.stream()
                .map(desastreUbicacion -> modelMapper.map(desastreUbicacion, DesastreUbicacionDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public DesastreUbicacionDTO getDesastreUbicacionById(Long id) {
        DesastreUbicacion desastreUbicacion = desastreUbicacionRepository.findById(id)
                .orElseThrow(() -> new CustomException("DesastreUbicación no encontrada con ID: " + id));
        return modelMapper.map(desastreUbicacion, DesastreUbicacionDTO.class);
    }

    @Override
    public DesastreUbicacionDTO createDesastreUbicacion(DesastreUbicacionDTO desastreUbicacionDTO) {
        DesastreUbicacion desastreUbicacion = new DesastreUbicacion();
        desastreUbicacion.setDesastre(modelMapper.map(desastreUbicacionDTO.getIdDesastre(), Desastre.class));
        desastreUbicacion.setUbicacion(modelMapper.map(desastreUbicacionDTO.getIdUbicacion(), Ubicacion.class));
        desastreUbicacionRepository.save(desastreUbicacion);
        return modelMapper.map(desastreUbicacion, DesastreUbicacionDTO.class);
    }

    @Override
    public DesastreUbicacionDTO updateDesastreUbicacion(Long id, DesastreUbicacionDTO desastreUbicacionDTO) {
        DesastreUbicacion desastreUbicacion = desastreUbicacionRepository.findById(id)
                .orElseThrow(() -> new CustomException("DesastreUbicación no encontrada con ID: " + id));
        desastreUbicacion.setDesastre(modelMapper.map(desastreUbicacionDTO.getIdDesastre(), Desastre.class));
        desastreUbicacion.setUbicacion(modelMapper.map(desastreUbicacionDTO.getIdUbicacion(), Ubicacion.class));
        desastreUbicacionRepository.save(desastreUbicacion);
        return modelMapper.map(desastreUbicacion, DesastreUbicacionDTO.class);
    }

    @Override
    public void deleteDesastreUbicacion(Long id) {
        DesastreUbicacion desastreUbicacion = desastreUbicacionRepository.findById(id)
                .orElseThrow(() -> new CustomException("DesastreUbicación no encontrada con ID: " + id));
        desastreUbicacionRepository.delete(desastreUbicacion);
    }
}