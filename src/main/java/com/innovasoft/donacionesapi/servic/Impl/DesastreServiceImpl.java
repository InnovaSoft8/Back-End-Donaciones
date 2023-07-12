package com.innovasoft.donacionesapi.servic.Impl;

import com.innovasoft.donacionesapi.dto.DesastreDTO;
import com.innovasoft.donacionesapi.exception.CustomException;
import com.innovasoft.donacionesapi.model.Desastre;
import com.innovasoft.donacionesapi.repository.DesastreRepository;
import com.innovasoft.donacionesapi.servic.DesastreService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DesastreServiceImpl implements DesastreService {

    private final DesastreRepository desastreRepository;
    private final ModelMapper modelMapper;

    public DesastreServiceImpl(DesastreRepository desastreRepository, ModelMapper modelMapper) {
        this.desastreRepository = desastreRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<DesastreDTO> getAllDesastres() {
        List<Desastre> desastres = desastreRepository.findAll();
        return desastres.stream()
                .map(desastre -> modelMapper.map(desastre, DesastreDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public DesastreDTO getDesastreById(Long id) {
        Desastre desastre = desastreRepository.findById(id)
                .orElseThrow(() -> new CustomException("Desastre no encontrado con ID: " + id));
        return modelMapper.map(desastre, DesastreDTO.class);
    }

    @Override
    public DesastreDTO createDesastre(DesastreDTO desastreDTO) {
        Desastre desastre = modelMapper.map(desastreDTO, Desastre.class);
        Desastre savedDesastre = desastreRepository.save(desastre);
        return modelMapper.map(savedDesastre, DesastreDTO.class);
    }

    @Override
    public DesastreDTO updateDesastre(Long id, DesastreDTO desastreDTO) {
        Desastre desastre = desastreRepository.findById(id)
                .orElseThrow(() -> new CustomException("Desastre no encontrado con ID: " + id));
        desastre.setNombre(desastreDTO.getNombre());
        desastre.setDescripcion(desastreDTO.getDescripcion());
        desastre.setFecha(desastreDTO.getFecha());
        Desastre updatedDesastre = desastreRepository.save(desastre);
        return modelMapper.map(updatedDesastre, DesastreDTO.class);
    }

    @Override
    public void deleteDesastre(Long id) {
        Desastre desastre = desastreRepository.findById(id)
                .orElseThrow(() -> new CustomException("Desastre no encontrado con ID: " + id));
        desastreRepository.delete(desastre);
    }
}