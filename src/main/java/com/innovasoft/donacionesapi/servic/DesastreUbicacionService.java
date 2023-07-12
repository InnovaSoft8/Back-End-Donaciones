package com.innovasoft.donacionesapi.servic;

import com.innovasoft.donacionesapi.dto.DesastreUbicacionDTO;

import java.util.List;

public interface DesastreUbicacionService {

    List<DesastreUbicacionDTO> getAllDesastreUbicaciones();

    DesastreUbicacionDTO getDesastreUbicacionById(Long id);

    DesastreUbicacionDTO createDesastreUbicacion(DesastreUbicacionDTO desastreUbicacionDTO);

    DesastreUbicacionDTO updateDesastreUbicacion(Long id, DesastreUbicacionDTO desastreUbicacionDTO);

    void deleteDesastreUbicacion(Long id);
}
