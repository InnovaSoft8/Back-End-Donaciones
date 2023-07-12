package com.innovasoft.donacionesapi.servic;

import com.innovasoft.donacionesapi.dto.MetaFinanciamientoDTO;

import java.util.List;

public interface MetaFinanciamientoService {

    List<MetaFinanciamientoDTO> getAllMetasFinanciamiento();

    MetaFinanciamientoDTO getMetaFinanciamientoById(Long id);

    MetaFinanciamientoDTO createMetaFinanciamiento(MetaFinanciamientoDTO metaFinanciamientoDTO);

    MetaFinanciamientoDTO updateMetaFinanciamiento(Long id, MetaFinanciamientoDTO metaFinanciamientoDTO);

    void deleteMetaFinanciamiento(Long id);
}