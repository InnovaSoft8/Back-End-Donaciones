package com.innovasoft.donacionesapi.servic.Impl;

import com.innovasoft.donacionesapi.dto.TransaccionDTO;
import com.innovasoft.donacionesapi.exception.CustomException;
import com.innovasoft.donacionesapi.model.Donante;
import com.innovasoft.donacionesapi.model.Pais;
import com.innovasoft.donacionesapi.model.Proyecto;
import com.innovasoft.donacionesapi.model.Transaccion;
import com.innovasoft.donacionesapi.repository.DonanteRepository;
import com.innovasoft.donacionesapi.repository.PaisRepository;
import com.innovasoft.donacionesapi.repository.ProyectoRepository;
import com.innovasoft.donacionesapi.repository.TransaccionRepository;
import com.innovasoft.donacionesapi.servic.TransaccionService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransaccionServiceImpl implements TransaccionService {

    private final TransaccionRepository transaccionRepository;
    private final DonanteRepository donanteRepository;
    private final ProyectoRepository proyectoRepository;
    private final PaisRepository paisRepository;
    private final ModelMapper modelMapper;

    public TransaccionServiceImpl(TransaccionRepository transaccionRepository,
                                  DonanteRepository donanteRepository,
                                  ProyectoRepository proyectoRepository,
                                  PaisRepository paisRepository,
                                  ModelMapper modelMapper) {
        this.transaccionRepository = transaccionRepository;
        this.donanteRepository = donanteRepository;
        this.proyectoRepository = proyectoRepository;
        this.paisRepository = paisRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<TransaccionDTO> getAllTransacciones() {
        List<Transaccion> transacciones = transaccionRepository.findAll();
        return transacciones.stream()
                .map(transaccion -> modelMapper.map(transaccion, TransaccionDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public TransaccionDTO getTransaccionById(Long id) {
        Transaccion transaccion = transaccionRepository.findById(id)
                .orElseThrow(() -> new CustomException("Transacción no encontrada con ID: " + id));
        return modelMapper.map(transaccion, TransaccionDTO.class);
    }

    @Override
    public TransaccionDTO createTransaccion(TransaccionDTO transaccionDTO) {
        Transaccion transaccion = new Transaccion();
        transaccion.setMonto(transaccionDTO.getMonto());
        transaccion.setFechaHora(transaccionDTO.getFechaHora());
        Donante donante = donanteRepository.findById(transaccionDTO.getIdDonante())
                .orElseThrow(() -> new CustomException("Donante no encontrado con ID: " + transaccionDTO.getIdDonante()));
        transaccion.setDonante(donante);
        Proyecto proyecto = proyectoRepository.findById(transaccionDTO.getIdProyecto())
                .orElseThrow(() -> new CustomException("Proyecto no encontrado con ID: " + transaccionDTO.getIdProyecto()));
        transaccion.setProyecto(proyecto);
        Pais pais = paisRepository.findById(transaccionDTO.getIdPais())
                .orElseThrow(() -> new CustomException("País no encontrado con ID: " + transaccionDTO.getIdPais()));
        transaccion.setPais(pais);
        transaccionRepository.save(transaccion);
        return modelMapper.map(transaccion, TransaccionDTO.class);
    }

    @Override
    public TransaccionDTO updateTransaccion(Long id, TransaccionDTO transaccionDTO) {
        Transaccion transaccion = transaccionRepository.findById(id)
                .orElseThrow(() -> new CustomException("Transacción no encontrada con ID: " + id));
        transaccion.setMonto(transaccionDTO.getMonto());
        transaccion.setFechaHora(transaccionDTO.getFechaHora());
        Donante donante = donanteRepository.findById(transaccionDTO.getIdDonante())
                .orElseThrow(() -> new CustomException("Donante no encontrado con ID: " + transaccionDTO.getIdDonante()));
        transaccion.setDonante(donante);
        Proyecto proyecto = proyectoRepository.findById(transaccionDTO.getIdProyecto())
                .orElseThrow(() -> new CustomException("Proyecto no encontrado con ID: " + transaccionDTO.getIdProyecto()));
        transaccion.setProyecto(proyecto);
        Pais pais = paisRepository.findById(transaccionDTO.getIdPais())
                .orElseThrow(() -> new CustomException("País no encontrado con ID: " + transaccionDTO.getIdPais()));
        transaccion.setPais(pais);
        transaccionRepository.save(transaccion);
        return modelMapper.map(transaccion, TransaccionDTO.class);
    }

    @Override
    public void deleteTransaccion(Long id) {
        Transaccion transaccion = transaccionRepository.findById(id)
                .orElseThrow(() -> new CustomException("Transacción no encontrada con ID: " + id));
        transaccionRepository.delete(transaccion);
    }
}