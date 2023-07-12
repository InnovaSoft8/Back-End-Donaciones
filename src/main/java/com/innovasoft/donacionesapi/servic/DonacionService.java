package com.innovasoft.donacionesapi.servic;

import com.innovasoft.donacionesapi.dto.DonacionDTO;

import java.util.List;

public interface DonacionService {

    List<DonacionDTO> getAllDonaciones();

    DonacionDTO getDonacionById(Long id);

    DonacionDTO createDonacion(DonacionDTO donacionDTO);

    DonacionDTO updateDonacion(Long id, DonacionDTO donacionDTO);

    void deleteDonacion(Long id);
}