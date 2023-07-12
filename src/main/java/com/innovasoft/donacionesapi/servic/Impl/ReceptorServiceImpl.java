package com.innovasoft.donacionesapi.servic.Impl;


import com.innovasoft.donacionesapi.dto.ReceptorDTO;
import com.innovasoft.donacionesapi.exception.CustomException;
import com.innovasoft.donacionesapi.model.Pais;
import com.innovasoft.donacionesapi.model.Receptor;
import com.innovasoft.donacionesapi.repository.PaisRepository;
import com.innovasoft.donacionesapi.repository.ReceptorRepository;
import com.innovasoft.donacionesapi.servic.ReceptorService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReceptorServiceImpl implements ReceptorService {

    private final ReceptorRepository receptorRepository;
    private final PaisRepository paisRepository;
    private final ModelMapper modelMapper;

    public ReceptorServiceImpl(ReceptorRepository receptorRepository, PaisRepository paisRepository, ModelMapper modelMapper) {
        this.receptorRepository = receptorRepository;
        this.paisRepository = paisRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ReceptorDTO> getAllReceptores() {
        List<Receptor> receptores = receptorRepository.findAll();
        return receptores.stream()
                .map(receptor -> modelMapper.map(receptor, ReceptorDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ReceptorDTO getReceptorById(Long id) {
        Receptor receptor = receptorRepository.findById(id)
                .orElseThrow(() -> new CustomException("Receptor no encontrado con ID: " + id));
        return modelMapper.map(receptor, ReceptorDTO.class);
    }

    @Override
    public ReceptorDTO createReceptor(ReceptorDTO receptorDTO) {
        Receptor receptor = modelMapper.map(receptorDTO, Receptor.class);
        Pais pais = paisRepository.findById(receptorDTO.getIdPais())
                .orElseThrow(() -> new CustomException("País no encontrado con ID: " + receptorDTO.getIdPais()));
        receptor.setPais(pais);
        Receptor savedReceptor = receptorRepository.save(receptor);
        return modelMapper.map(savedReceptor, ReceptorDTO.class);
    }

    @Override
    public ReceptorDTO updateReceptor(Long id, ReceptorDTO receptorDTO) {
        Receptor receptor = receptorRepository.findById(id)
                .orElseThrow(() -> new CustomException("Receptor no encontrado con ID: " + id));
        receptor.setNombre(receptorDTO.getNombre());
        receptor.setDireccion(receptorDTO.getDireccion());
        receptor.setCorreoElectronico(receptorDTO.getCorreoElectronico());
        receptor.setTelefono(receptorDTO.getTelefono());
        receptor.setFechaRegistro(receptorDTO.getFechaRegistro());
        Pais pais = paisRepository.findById(receptorDTO.getIdPais())
                .orElseThrow(() -> new CustomException("País no encontrado con ID: " + receptorDTO.getIdPais()));
        receptor.setPais(pais);
        Receptor updatedReceptor = receptorRepository.save(receptor);
        return modelMapper.map(updatedReceptor, ReceptorDTO.class);
    }

    @Override
    public void deleteReceptor(Long id) {
        Receptor receptor = receptorRepository.findById(id)
                .orElseThrow(() -> new CustomException("Receptor no encontrado con ID: " + id));
        receptorRepository.delete(receptor);
    }
}