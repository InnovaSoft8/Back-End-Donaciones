package com.innovasoft.donacionesapi.servic.Impl;

import com.innovasoft.donacionesapi.dto.MensajeDTO;
import com.innovasoft.donacionesapi.exception.CustomException;
import com.innovasoft.donacionesapi.model.Donante;
import com.innovasoft.donacionesapi.model.Mensaje;
import com.innovasoft.donacionesapi.model.Voluntario;
import com.innovasoft.donacionesapi.repository.DonanteRepository;
import com.innovasoft.donacionesapi.repository.MensajeRepository;
import com.innovasoft.donacionesapi.repository.VoluntarioRepository;
import com.innovasoft.donacionesapi.servic.MensajeService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MensajeServiceImpl implements MensajeService {

    private final MensajeRepository mensajeRepository;
    private final DonanteRepository donanteRepository;
    private final VoluntarioRepository voluntarioRepository;
    private final ModelMapper modelMapper;

    public MensajeServiceImpl(MensajeRepository mensajeRepository, DonanteRepository donanteRepository,
                              VoluntarioRepository voluntarioRepository, ModelMapper modelMapper) {
        this.mensajeRepository = mensajeRepository;
        this.donanteRepository = donanteRepository;
        this.voluntarioRepository = voluntarioRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<MensajeDTO> getAllMensajes() {
        List<Mensaje> mensajes = mensajeRepository.findAll();
        return mensajes.stream()
                .map(mensaje -> modelMapper.map(mensaje, MensajeDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public MensajeDTO getMensajeById(Long id) {
        Mensaje mensaje = mensajeRepository.findById(id)
                .orElseThrow(() -> new CustomException("Mensaje no encontrado con ID: " + id));
        return modelMapper.map(mensaje, MensajeDTO.class);
    }

    @Override
    public MensajeDTO createMensaje(MensajeDTO mensajeDTO) {
        Mensaje mensaje = new Mensaje();
        mensaje.setFechaHoraMensaje(LocalDateTime.now());
        mensaje.setContenidoMensaje(mensajeDTO.getContenidoMensaje());
        mensaje.setEstadoMensaje(mensajeDTO.getEstadoMensaje());
        Donante donanteEmisor = donanteRepository.findById(mensajeDTO.getIdDonanteEmisor())
                .orElseThrow(() -> new CustomException("Donante emisor no encontrado con ID: " + mensajeDTO.getIdDonanteEmisor()));
        mensaje.setDonanteEmisor(donanteEmisor);
        Voluntario voluntarioEmisor = voluntarioRepository.findById(mensajeDTO.getIdVoluntarioEmisor())
                .orElseThrow(() -> new CustomException("Voluntario emisor no encontrado con ID: " + mensajeDTO.getIdVoluntarioEmisor()));
        mensaje.setVoluntarioEmisor(voluntarioEmisor);
        Donante donanteReceptor = donanteRepository.findById(mensajeDTO.getIdDonanteReceptor())
                .orElseThrow(() -> new CustomException("Donante receptor no encontrado con ID: " + mensajeDTO.getIdDonanteReceptor()));
        mensaje.setDonanteReceptor(donanteReceptor);
        Voluntario voluntarioReceptor = voluntarioRepository.findById(mensajeDTO.getIdVoluntarioReceptor())
                .orElseThrow(() -> new CustomException("Voluntario receptor no encontrado con ID: " + mensajeDTO.getIdVoluntarioReceptor()));
        mensaje.setVoluntarioReceptor(voluntarioReceptor);
        Mensaje savedMensaje = mensajeRepository.save(mensaje);
        return modelMapper.map(savedMensaje, MensajeDTO.class);
    }

    @Override
    public MensajeDTO updateMensaje(Long id, MensajeDTO mensajeDTO) {
        Mensaje mensaje = mensajeRepository.findById(id)
                .orElseThrow(() -> new CustomException("Mensaje no encontrado con ID: " + id));
        mensaje.setFechaHoraMensaje(LocalDateTime.now());
        mensaje.setContenidoMensaje(mensajeDTO.getContenidoMensaje());
        mensaje.setEstadoMensaje(mensajeDTO.getEstadoMensaje());
        Donante donanteEmisor = donanteRepository.findById(mensajeDTO.getIdDonanteEmisor())
                .orElseThrow(() -> new CustomException("Donante emisor no encontrado con ID: " + mensajeDTO.getIdDonanteEmisor()));
        mensaje.setDonanteEmisor(donanteEmisor);
        Voluntario voluntarioEmisor = voluntarioRepository.findById(mensajeDTO.getIdVoluntarioEmisor())
                .orElseThrow(() -> new CustomException("Voluntario emisor no encontrado con ID: " + mensajeDTO.getIdVoluntarioEmisor()));
        mensaje.setVoluntarioEmisor(voluntarioEmisor);
        Donante donanteReceptor = donanteRepository.findById(mensajeDTO.getIdDonanteReceptor())
                .orElseThrow(() -> new CustomException("Donante receptor no encontrado con ID: " + mensajeDTO.getIdDonanteReceptor()));
        mensaje.setDonanteReceptor(donanteReceptor);
        Voluntario voluntarioReceptor = voluntarioRepository.findById(mensajeDTO.getIdVoluntarioReceptor())
                .orElseThrow(() -> new CustomException("Voluntario receptor no encontrado con ID: " + mensajeDTO.getIdVoluntarioReceptor()));
        mensaje.setVoluntarioReceptor(voluntarioReceptor);
        Mensaje updatedMensaje = mensajeRepository.save(mensaje);
        return modelMapper.map(updatedMensaje, MensajeDTO.class);
    }

    @Override
    public void deleteMensaje(Long id) {
        Mensaje mensaje = mensajeRepository.findById(id)
                .orElseThrow(() -> new CustomException("Mensaje no encontrado con ID: " + id));
        mensajeRepository.delete(mensaje);
    }
}