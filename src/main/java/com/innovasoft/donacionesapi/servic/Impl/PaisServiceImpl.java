package com.innovasoft.donacionesapi.servic.Impl;

import com.innovasoft.donacionesapi.dto.PaisDTO;
import com.innovasoft.donacionesapi.exception.CustomException;
import com.innovasoft.donacionesapi.model.Pais;
import com.innovasoft.donacionesapi.repository.PaisRepository;
import com.innovasoft.donacionesapi.servic.PaisService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaisServiceImpl implements PaisService {

    private final PaisRepository paisRepository;
    private final ModelMapper modelMapper;

    public PaisServiceImpl(PaisRepository paisRepository, ModelMapper modelMapper) {
        this.paisRepository = paisRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<PaisDTO> getAllPaises() {
        List<Pais> paises = paisRepository.findAll();
        return paises.stream()
                .map(pais -> modelMapper.map(pais, PaisDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public PaisDTO getPaisById(Long id) {
        Pais pais = paisRepository.findById(id)
                .orElseThrow(() -> new CustomException("País no encontrado con ID: " + id));
        return modelMapper.map(pais, PaisDTO.class);
    }

    @Override
    public PaisDTO createPais(PaisDTO paisDTO) {
        Pais pais = new Pais();
        pais.setNombre(paisDTO.getNombre());
        paisRepository.save(pais);
        return modelMapper.map(pais, PaisDTO.class);
    }

    @Override
    public PaisDTO updatePais(Long id, PaisDTO paisDTO) {
        Pais pais = paisRepository.findById(id)
                .orElseThrow(() -> new CustomException("País no encontrado con ID: " + id));
        pais.setNombre(paisDTO.getNombre());
        paisRepository.save(pais);
        return modelMapper.map(pais, PaisDTO.class);
    }

    @Override
    public void deletePais(Long id) {
        Pais pais = paisRepository.findById(id)
                .orElseThrow(() -> new CustomException("País no encontrado con ID: " + id));
        paisRepository.delete(pais);
    }
}