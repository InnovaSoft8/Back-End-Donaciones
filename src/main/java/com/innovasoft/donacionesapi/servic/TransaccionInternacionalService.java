package com.innovasoft.donacionesapi.servic;

import com.innovasoft.donacionesapi.dto.TransaccionInternacionalDTO;

public interface TransaccionInternacionalService {
    TransaccionInternacionalDTO getTransaccionInternacionalById(Long id);
    TransaccionInternacionalDTO createTransaccionInternacional(TransaccionInternacionalDTO transaccionDTO);
    TransaccionInternacionalDTO updateTransaccionInternacional(Long id, TransaccionInternacionalDTO transaccionDTO);
    void deleteTransaccionInternacional(Long id);
    // Otros métodos según tus necesidades
}