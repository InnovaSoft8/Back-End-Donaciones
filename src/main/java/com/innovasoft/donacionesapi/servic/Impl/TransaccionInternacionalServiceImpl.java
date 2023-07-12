package com.innovasoft.donacionesapi.servic.Impl;

import com.innovasoft.donacionesapi.dto.TransaccionInternacionalDTO;
import com.innovasoft.donacionesapi.exception.CustomException;
import com.innovasoft.donacionesapi.model.Donante;
import com.innovasoft.donacionesapi.model.Pais;
import com.innovasoft.donacionesapi.model.TransaccionInternacional;
import com.innovasoft.donacionesapi.repository.TransaccionInternacionalRepository;
import com.innovasoft.donacionesapi.servic.TransaccionInternacionalService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class TransaccionInternacionalServiceImpl implements TransaccionInternacionalService {
    private final TransaccionInternacionalRepository transaccionRepository;
    private final ModelMapper modelMapper;

    public TransaccionInternacionalServiceImpl(TransaccionInternacionalRepository transaccionRepository, ModelMapper modelMapper) {
        this.transaccionRepository = transaccionRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public TransaccionInternacionalDTO getTransaccionInternacionalById(Long id) {
        TransaccionInternacional transaccion = transaccionRepository.findById(id)
                .orElseThrow(() -> new CustomException("Transacción Internacional no encontrada con ID: " + id));

        return modelMapper.map(transaccion, TransaccionInternacionalDTO.class);
    }

    @Override
    public TransaccionInternacionalDTO createTransaccionInternacional(TransaccionInternacionalDTO transaccionDTO) {
        TransaccionInternacional transaccion = modelMapper.map(transaccionDTO, TransaccionInternacional.class);
        TransaccionInternacional savedTransaccion = transaccionRepository.save(transaccion);

        return modelMapper.map(savedTransaccion, TransaccionInternacionalDTO.class);
    }

    @Override
    public TransaccionInternacionalDTO updateTransaccionInternacional(Long id, TransaccionInternacionalDTO transaccionDTO) {
        TransaccionInternacional transaccion = transaccionRepository.findById(id)
                .orElseThrow(() -> new CustomException("Transacción Internacional no encontrada con ID: " + id));

        transaccion.setMonto(transaccionDTO.getMonto());
        transaccion.setFechaHora(transaccionDTO.getFechaHora());
        transaccion.setDonante(modelMapper.map(transaccionDTO.getDonanteId(), Donante.class));
        transaccion.setPais(modelMapper.map(transaccionDTO.getPaisId(), Pais.class));

        TransaccionInternacional updatedTransaccion = transaccionRepository.save(transaccion);
        return modelMapper.map(updatedTransaccion, TransaccionInternacionalDTO.class);
    }

    @Override
    public void deleteTransaccionInternacional(Long id) {
        TransaccionInternacional transaccion = transaccionRepository.findById(id)
                .orElseThrow(() -> new CustomException("Transacción Internacional no encontrada con ID: " + id));

        transaccionRepository.delete(transaccion);
    }

    // Implementa los demás métodos del servicio según tus necesidades
}
