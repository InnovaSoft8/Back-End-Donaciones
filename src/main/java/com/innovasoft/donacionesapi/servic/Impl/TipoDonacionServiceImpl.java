package com.innovasoft.donacionesapi.servic.Impl;

import com.innovasoft.donacionesapi.dto.TipoDonacionDTO;
import com.innovasoft.donacionesapi.exception.CustomException;
import com.innovasoft.donacionesapi.model.TipoDonacion;
import com.innovasoft.donacionesapi.repository.TipoDonacionRepository;
import com.innovasoft.donacionesapi.servic.TipoDonacionService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TipoDonacionServiceImpl implements TipoDonacionService {

    private final TipoDonacionRepository tipoDonacionRepository;
    private final ModelMapper modelMapper;

    public TipoDonacionServiceImpl(TipoDonacionRepository tipoDonacionRepository, ModelMapper modelMapper) {
        this.tipoDonacionRepository = tipoDonacionRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<TipoDonacionDTO> getAllTipoDonaciones() {
        List<TipoDonacion> tipoDonaciones = tipoDonacionRepository.findAll();
        return tipoDonaciones.stream()
                .map(tipoDonacion -> modelMapper.map(tipoDonacion, TipoDonacionDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public TipoDonacionDTO getTipoDonacionById(Long id) {
        TipoDonacion tipoDonacion = tipoDonacionRepository.findById(id)
                .orElseThrow(() -> new CustomException("Tipo de Donación no encontrado con ID: " + id));
        return modelMapper.map(tipoDonacion, TipoDonacionDTO.class);
    }

    @Override
    public TipoDonacionDTO createTipoDonacion(TipoDonacionDTO tipoDonacionDTO) {
        TipoDonacion tipoDonacion = new TipoDonacion();
        tipoDonacion.setDescripcion(tipoDonacionDTO.getDescripcion());
        tipoDonacionRepository.save(tipoDonacion);
        return modelMapper.map(tipoDonacion, TipoDonacionDTO.class);
    }

    @Override
    public TipoDonacionDTO updateTipoDonacion(Long id, TipoDonacionDTO tipoDonacionDTO) {
        TipoDonacion tipoDonacion = tipoDonacionRepository.findById(id)
                .orElseThrow(() -> new CustomException("Tipo de Donación no encontrado con ID: " + id));
        tipoDonacion.setDescripcion(tipoDonacionDTO.getDescripcion());
        tipoDonacionRepository.save(tipoDonacion);
        return modelMapper.map(tipoDonacion, TipoDonacionDTO.class);
    }

    @Override
    public void deleteTipoDonacion(Long id) {
        TipoDonacion tipoDonacion = tipoDonacionRepository.findById(id)
                .orElseThrow(() -> new CustomException("Tipo de Donación no encontrado con ID: " + id));
        tipoDonacionRepository.delete(tipoDonacion);
    }
}