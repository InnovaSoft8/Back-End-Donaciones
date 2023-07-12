package com.innovasoft.donacionesapi.servic;

import com.innovasoft.donacionesapi.dto.PublicacionRedesSocialesDTO;

import java.util.List;

public interface PublicacionRedesSocialesService {

    List<PublicacionRedesSocialesDTO> getAllPublicaciones();

    PublicacionRedesSocialesDTO getPublicacionById(Long id);

    PublicacionRedesSocialesDTO createPublicacion(PublicacionRedesSocialesDTO publicacionDTO);

    PublicacionRedesSocialesDTO updatePublicacion(Long id, PublicacionRedesSocialesDTO publicacionDTO);

    void deletePublicacion(Long id);
}