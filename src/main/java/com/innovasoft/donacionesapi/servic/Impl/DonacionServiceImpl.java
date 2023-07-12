package com.innovasoft.donacionesapi.servic.Impl;

import com.innovasoft.donacionesapi.dto.DonacionDTO;
import com.innovasoft.donacionesapi.exception.CustomException;
import com.innovasoft.donacionesapi.model.Donacion;
import com.innovasoft.donacionesapi.model.Donante;
import com.innovasoft.donacionesapi.model.Proyecto;
import com.innovasoft.donacionesapi.model.TipoDonacion;
import com.innovasoft.donacionesapi.repository.DonacionRepository;
import com.innovasoft.donacionesapi.repository.DonanteRepository;
import com.innovasoft.donacionesapi.repository.ProyectoRepository;
import com.innovasoft.donacionesapi.repository.TipoDonacionRepository;
import com.innovasoft.donacionesapi.servic.DonacionService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DonacionServiceImpl implements DonacionService {

    private final DonacionRepository donacionRepository;
    private final DonanteRepository donanteRepository;
    private final ProyectoRepository proyectoRepository;
    private final TipoDonacionRepository tipoDonacionRepository;
    private final ModelMapper modelMapper;

    public DonacionServiceImpl(DonacionRepository donacionRepository, DonanteRepository donanteRepository,
                               ProyectoRepository proyectoRepository, TipoDonacionRepository tipoDonacionRepository,
                               ModelMapper modelMapper) {
        this.donacionRepository = donacionRepository;
        this.donanteRepository = donanteRepository;
        this.proyectoRepository = proyectoRepository;
        this.tipoDonacionRepository = tipoDonacionRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<DonacionDTO> getAllDonaciones() {
        List<Donacion> donaciones = donacionRepository.findAll();
        return donaciones.stream()
                .map(donacion -> modelMapper.map(donacion, DonacionDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public DonacionDTO getDonacionById(Long id) {
        Donacion donacion = donacionRepository.findById(id)
                .orElseThrow(() -> new CustomException("Donación no encontrada con ID: " + id));
        return modelMapper.map(donacion, DonacionDTO.class);
    }

    @Override
    public DonacionDTO createDonacion(DonacionDTO donacionDTO) {
        Donacion donacion = new Donacion();
        donacion.setMonto(donacionDTO.getMonto());
        donacion.setFechaHora(LocalDateTime.now());
        Donante donante = donanteRepository.findById(donacionDTO.getIdDonante())
                .orElseThrow(() -> new CustomException("Donante no encontrado con ID: " + donacionDTO.getIdDonante()));
        donacion.setDonante(donante);
        Proyecto proyecto = proyectoRepository.findById(donacionDTO.getIdProyecto())
                .orElseThrow(() -> new CustomException("Proyecto no encontrado con ID: " + donacionDTO.getIdProyecto()));
        donacion.setProyecto(proyecto);
        TipoDonacion tipoDonacion = tipoDonacionRepository.findById(donacionDTO.getIdTipoDonacion())
                .orElseThrow(() -> new CustomException("Tipo de Donación no encontrado con ID: " + donacionDTO.getIdTipoDonacion()));
        donacion.setTipoDonacion(tipoDonacion);
        Donacion savedDonacion = donacionRepository.save(donacion);
        return modelMapper.map(savedDonacion, DonacionDTO.class);
    }

    @Override
    public DonacionDTO updateDonacion(Long id, DonacionDTO donacionDTO) {
        Donacion donacion = donacionRepository.findById(id)
                .orElseThrow(() -> new CustomException("Donación no encontrada con ID: " + id));
        donacion.setMonto(donacionDTO.getMonto());
        Donante donante = donanteRepository.findById(donacionDTO.getIdDonante())
                .orElseThrow(() -> new CustomException("Donante no encontrado con ID: " + donacionDTO.getIdDonante()));
        donacion.setDonante(donante);
        Proyecto proyecto = proyectoRepository.findById(donacionDTO.getIdProyecto())
                .orElseThrow(() -> new CustomException("Proyecto no encontrado con ID: " + donacionDTO.getIdProyecto()));
        donacion.setProyecto(proyecto);
        TipoDonacion tipoDonacion = tipoDonacionRepository.findById(donacionDTO.getIdTipoDonacion())
                .orElseThrow(() -> new CustomException("Tipo de Donación no encontrado con ID: " + donacionDTO.getIdTipoDonacion()));
        donacion.setTipoDonacion(tipoDonacion);
        Donacion updatedDonacion = donacionRepository.save(donacion);
        return modelMapper.map(updatedDonacion, DonacionDTO.class);
    }

    @Override
    public void deleteDonacion(Long id) {
        Donacion donacion = donacionRepository.findById(id)
                .orElseThrow(() -> new CustomException("Donación no encontrada con ID: " + id));
        donacionRepository.delete(donacion);
    }
}