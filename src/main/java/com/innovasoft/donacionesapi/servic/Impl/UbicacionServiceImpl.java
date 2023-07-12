package com.innovasoft.donacionesapi.servic.Impl;

import com.innovasoft.donacionesapi.dto.UbicacionDTO;
import com.innovasoft.donacionesapi.exception.CustomException;
import com.innovasoft.donacionesapi.model.Ubicacion;
import com.innovasoft.donacionesapi.repository.UbicacionRepository;
import com.innovasoft.donacionesapi.servic.UbicacionService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UbicacionServiceImpl implements UbicacionService {

    private final UbicacionRepository ubicacionRepository;
    private final ModelMapper modelMapper;

    public UbicacionServiceImpl(UbicacionRepository ubicacionRepository, ModelMapper modelMapper) {
        this.ubicacionRepository = ubicacionRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<UbicacionDTO> getAllUbicaciones() {
        List<Ubicacion> ubicaciones = ubicacionRepository.findAll();
        return ubicaciones.stream()
                .map(ubicacion -> modelMapper.map(ubicacion, UbicacionDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public UbicacionDTO getUbicacionById(Long id) {
        Ubicacion ubicacion = ubicacionRepository.findById(id)
                .orElseThrow(() -> new CustomException("Ubicación no encontrada con ID: " + id));
        return modelMapper.map(ubicacion, UbicacionDTO.class);
    }

    @Override
    public UbicacionDTO createUbicacion(UbicacionDTO ubicacionDTO) {
        Ubicacion ubicacion = modelMapper.map(ubicacionDTO, Ubicacion.class);
        Ubicacion savedUbicacion = ubicacionRepository.save(ubicacion);
        return modelMapper.map(savedUbicacion, UbicacionDTO.class);
    }

    @Override
    public UbicacionDTO updateUbicacion(Long id, UbicacionDTO ubicacionDTO) {
        Ubicacion ubicacion = ubicacionRepository.findById(id)
                .orElseThrow(() -> new CustomException("Ubicación no encontrada con ID: " + id));
        ubicacion.setPais(ubicacionDTO.getPais());
        ubicacion.setEstadoProvincia(ubicacionDTO.getEstadoProvincia());
        ubicacion.setCiudad(ubicacionDTO.getCiudad());
        ubicacion.setCodigoPostal(ubicacionDTO.getCodigoPostal());
        ubicacion.setLatitud(ubicacionDTO.getLatitud());
        ubicacion.setLongitud(ubicacionDTO.getLongitud());
        Ubicacion updatedUbicacion = ubicacionRepository.save(ubicacion);
        return modelMapper.map(updatedUbicacion, UbicacionDTO.class);
    }

    @Override
    public void deleteUbicacion(Long id) {
        Ubicacion ubicacion = ubicacionRepository.findById(id)
                .orElseThrow(() -> new CustomException("Ubicación no encontrada con ID: " + id));
        ubicacionRepository.delete(ubicacion);
    }
}