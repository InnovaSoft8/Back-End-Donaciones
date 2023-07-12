package com.innovasoft.donacionesapi.servic;

import com.innovasoft.donacionesapi.dto.SubastaDTO;

import java.util.List;

public interface SubastaService {

    List<SubastaDTO> getAllSubastas();

    SubastaDTO getSubastaById(Long id);

    SubastaDTO createSubasta(SubastaDTO subastaDTO);

    SubastaDTO updateSubasta(Long id, SubastaDTO subastaDTO);

    void deleteSubasta(Long id);
}