package com.innovasoft.donacionesapi.servic;

import com.innovasoft.donacionesapi.dto.TransaccionDTO;

import java.util.List;

public interface TransaccionService {

    List<TransaccionDTO> getAllTransacciones();

    TransaccionDTO getTransaccionById(Long id);

    TransaccionDTO createTransaccion(TransaccionDTO transaccionDTO);

    TransaccionDTO updateTransaccion(Long id, TransaccionDTO transaccionDTO);

    void deleteTransaccion(Long id);
}