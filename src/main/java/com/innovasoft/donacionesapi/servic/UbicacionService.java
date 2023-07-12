package com.innovasoft.donacionesapi.servic;

import com.innovasoft.donacionesapi.dto.UbicacionDTO;

import java.util.List;

public interface UbicacionService {

    List<UbicacionDTO> getAllUbicaciones();

    UbicacionDTO getUbicacionById(Long id);

    UbicacionDTO createUbicacion(UbicacionDTO ubicacionDTO);

    UbicacionDTO updateUbicacion(Long id, UbicacionDTO ubicacionDTO);

    void deleteUbicacion(Long id);
}