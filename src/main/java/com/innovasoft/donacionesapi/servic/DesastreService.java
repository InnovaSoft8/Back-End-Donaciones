package com.innovasoft.donacionesapi.servic;

import com.innovasoft.donacionesapi.dto.DesastreDTO;

import java.util.List;

public interface DesastreService {

    List<DesastreDTO> getAllDesastres();

    DesastreDTO getDesastreById(Long id);

    DesastreDTO createDesastre(DesastreDTO desastreDTO);

    DesastreDTO updateDesastre(Long id, DesastreDTO desastreDTO);

    void deleteDesastre(Long id);
}