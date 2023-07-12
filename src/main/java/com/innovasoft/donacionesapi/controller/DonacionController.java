package com.innovasoft.donacionesapi.controller;

import com.innovasoft.donacionesapi.dto.DonacionDTO;
import com.innovasoft.donacionesapi.servic.DonacionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/donaciones")
public class DonacionController {

    private final DonacionService donacionService;

    public DonacionController(DonacionService donacionService) {
        this.donacionService = donacionService;
    }

    @GetMapping
    public ResponseEntity<List<DonacionDTO>> getAllDonaciones() {
        List<DonacionDTO> donaciones = donacionService.getAllDonaciones();
        return new ResponseEntity<>(donaciones, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DonacionDTO> getDonacionById(@PathVariable Long id) {
        DonacionDTO donacion = donacionService.getDonacionById(id);
        return new ResponseEntity<>(donacion, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DonacionDTO> createDonacion(@RequestBody DonacionDTO donacionDTO) {
        DonacionDTO createdDonacion = donacionService.createDonacion(donacionDTO);
        return new ResponseEntity<>(createdDonacion, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DonacionDTO> updateDonacion(@PathVariable Long id, @RequestBody DonacionDTO donacionDTO) {
        DonacionDTO updatedDonacion = donacionService.updateDonacion(id, donacionDTO);
        return new ResponseEntity<>(updatedDonacion, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDonacion(@PathVariable Long id) {
        donacionService.deleteDonacion(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}