package com.innovasoft.donacionesapi.servic.Impl;

import com.innovasoft.donacionesapi.dto.VoluntarioDTO;
import com.innovasoft.donacionesapi.exception.CustomException;
import com.innovasoft.donacionesapi.model.Pais;
import com.innovasoft.donacionesapi.model.Voluntario;
import com.innovasoft.donacionesapi.repository.PaisRepository;
import com.innovasoft.donacionesapi.repository.VoluntarioRepository;
import com.innovasoft.donacionesapi.servic.VoluntarioService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VoluntarioServiceImpl implements VoluntarioService {

    private final VoluntarioRepository voluntarioRepository;
    private final PaisRepository paisRepository;
    private final ModelMapper modelMapper;

    public VoluntarioServiceImpl(VoluntarioRepository voluntarioRepository,
                                 PaisRepository paisRepository,
                                 ModelMapper modelMapper) {
        this.voluntarioRepository = voluntarioRepository;
        this.paisRepository = paisRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<VoluntarioDTO> getAllVoluntarios() {
        List<Voluntario> voluntarios = voluntarioRepository.findAll();
        return voluntarios.stream()
                .map(voluntario -> modelMapper.map(voluntario, VoluntarioDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public VoluntarioDTO getVoluntarioById(Long id) {
        Voluntario voluntario = voluntarioRepository.findById(id)
                .orElseThrow(() -> new CustomException("Voluntario no encontrado con ID: " + id));
        return modelMapper.map(voluntario, VoluntarioDTO.class);
    }

    @Override
    public VoluntarioDTO createVoluntario(VoluntarioDTO voluntarioDTO) {
        Voluntario voluntario = new Voluntario();
        voluntario.setNombre(voluntarioDTO.getNombre());
        voluntario.setDireccion(voluntarioDTO.getDireccion());
        voluntario.setCorreoElectronico(voluntarioDTO.getCorreoElectronico());
        voluntario.setTelefono(voluntarioDTO.getTelefono());
        voluntario.setFechaRegistro(voluntarioDTO.getFechaRegistro());
        Pais pais = paisRepository.findById(voluntarioDTO.getIdPais())
                .orElseThrow(() -> new CustomException("País no encontrado con ID: " + voluntarioDTO.getIdPais()));
        voluntario.setPais(pais);
        voluntarioRepository.save(voluntario);
        return modelMapper.map(voluntario, VoluntarioDTO.class);
    }

    @Override
    public VoluntarioDTO updateVoluntario(Long id, VoluntarioDTO voluntarioDTO) {
        Voluntario voluntario = voluntarioRepository.findById(id)
                .orElseThrow(() -> new CustomException("Voluntario no encontrado con ID: " + id));
        voluntario.setNombre(voluntarioDTO.getNombre());
        voluntario.setDireccion(voluntarioDTO.getDireccion());
        voluntario.setCorreoElectronico(voluntarioDTO.getCorreoElectronico());
        voluntario.setTelefono(voluntarioDTO.getTelefono());
        voluntario.setFechaRegistro(voluntarioDTO.getFechaRegistro());
        Pais pais = paisRepository.findById(voluntarioDTO.getIdPais())
                .orElseThrow(() -> new CustomException("País no encontrado con ID: " + voluntarioDTO.getIdPais()));
        voluntario.setPais(pais);
        voluntarioRepository.save(voluntario);
        return modelMapper.map(voluntario, VoluntarioDTO.class);
    }

    @Override
    public void deleteVoluntario(Long id) {
        Voluntario voluntario = voluntarioRepository.findById(id)
                .orElseThrow(() -> new CustomException("Voluntario no encontrado con ID: " + id));
        voluntarioRepository.delete(voluntario);
    }
}