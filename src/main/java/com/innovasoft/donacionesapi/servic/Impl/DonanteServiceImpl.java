package com.innovasoft.donacionesapi.servic.Impl;

import com.innovasoft.donacionesapi.dto.DonanteDTO;
import com.innovasoft.donacionesapi.exception.CustomException;
import com.innovasoft.donacionesapi.model.Donante;
import com.innovasoft.donacionesapi.model.Pais;
import com.innovasoft.donacionesapi.repository.DonanteRepository;
import com.innovasoft.donacionesapi.repository.PaisRepository;
import com.innovasoft.donacionesapi.servic.DonanteService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DonanteServiceImpl implements DonanteService {

    private final DonanteRepository donanteRepository;
    private final PaisRepository paisRepository;
    private final ModelMapper modelMapper;

    public DonanteServiceImpl(DonanteRepository donanteRepository, PaisRepository paisRepository, ModelMapper modelMapper) {
        this.donanteRepository = donanteRepository;
        this.paisRepository = paisRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public DonanteDTO getDonanteById(Long id) {
        Donante donante = donanteRepository.findById(id)
                .orElseThrow(() -> new CustomException("Donante no encontrado con ID: " + id));
        return modelMapper.map(donante, DonanteDTO.class);
    }

    @Override
    public List<DonanteDTO> getAllDonantes() {
        List<Donante> donantes = donanteRepository.findAll();
        return donantes.stream()
                .map(donante -> modelMapper.map(donante, DonanteDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public DonanteDTO createDonante(DonanteDTO donanteDTO) {
        Donante donante = modelMapper.map(donanteDTO, Donante.class);
        Pais pais = paisRepository.findById(donanteDTO.getIdPais())
                .orElseThrow(() -> new CustomException("País no encontrado con ID: " + donanteDTO.getIdPais()));
        donante.setPais(pais);
        Donante savedDonante = donanteRepository.save(donante);
        return modelMapper.map(savedDonante, DonanteDTO.class);
    }

    @Override
    public DonanteDTO updateDonante(Long id, DonanteDTO donanteDTO) {
        Donante donante = donanteRepository.findById(id)
                .orElseThrow(() -> new CustomException("Donante no encontrado con ID: " + id));
        donante.setNombre(donanteDTO.getNombre());
        donante.setDireccion(donanteDTO.getDireccion());
        donante.setCorreoElectronico(donanteDTO.getCorreoElectronico());
        donante.setTelefono(donanteDTO.getTelefono());
        donante.setFechaRegistro(donanteDTO.getFechaRegistro());
        Pais pais = paisRepository.findById(donanteDTO.getIdPais())
                .orElseThrow(() -> new CustomException("País no encontrado con ID: " + donanteDTO.getIdPais()));
        donante.setPais(pais);
        Donante updatedDonante = donanteRepository.save(donante);
        return modelMapper.map(updatedDonante, DonanteDTO.class);
    }

    @Override
    public void deleteDonante(Long id) {
        Donante donante = donanteRepository.findById(id)
                .orElseThrow(() -> new CustomException("Donante no encontrado con ID: " + id));
        donanteRepository.delete(donante);
    }

    // Otros métodos del servicio según tus necesidades
}