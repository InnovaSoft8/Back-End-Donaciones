package com.innovasoft.donacionesapi.servic;

import com.innovasoft.donacionesapi.dto.ReceptorDTO;

import java.util.List;

public interface ReceptorService {

    List<ReceptorDTO> getAllReceptores();

    ReceptorDTO getReceptorById(Long id);

    ReceptorDTO createReceptor(ReceptorDTO receptorDTO);

    ReceptorDTO updateReceptor(Long id, ReceptorDTO receptorDTO);

    void deleteReceptor(Long id);

}