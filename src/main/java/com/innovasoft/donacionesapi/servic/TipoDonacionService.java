package com.innovasoft.donacionesapi.servic;


import com.innovasoft.donacionesapi.dto.TipoDonacionDTO;

import java.util.List;

public interface TipoDonacionService {

    List<TipoDonacionDTO> getAllTipoDonaciones();

    TipoDonacionDTO getTipoDonacionById(Long id);

    TipoDonacionDTO createTipoDonacion(TipoDonacionDTO tipoDonacionDTO);

    TipoDonacionDTO updateTipoDonacion(Long id, TipoDonacionDTO tipoDonacionDTO);

    void deleteTipoDonacion(Long id);
}