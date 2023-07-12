package com.innovasoft.donacionesapi.controller;

import com.innovasoft.donacionesapi.dto.DonanteDTO;
import com.innovasoft.donacionesapi.servic.DonanteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/donantes")
public class DonanteController {

    private final DonanteService donanteService;

    public DonanteController(DonanteService donanteService) {
        this.donanteService = donanteService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<DonanteDTO> getDonanteById(@PathVariable Long id) {
        DonanteDTO donanteDTO = donanteService.getDonanteById(id);
        return ResponseEntity.ok(donanteDTO);
    }

    @GetMapping
    public ResponseEntity<List<DonanteDTO>> getAllDonantes() {
        List<DonanteDTO> donantes = donanteService.getAllDonantes();
        return ResponseEntity.ok(donantes);
    }

    @PostMapping
    public ResponseEntity<DonanteDTO> createDonante(@RequestBody DonanteDTO donanteDTO) {
        DonanteDTO createdDonante = donanteService.createDonante(donanteDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdDonante);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DonanteDTO> updateDonante(@PathVariable Long id, @RequestBody DonanteDTO donanteDTO) {
        DonanteDTO updatedDonante = donanteService.updateDonante(id, donanteDTO);
        return ResponseEntity.ok(updatedDonante);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDonante(@PathVariable Long id) {
        donanteService.deleteDonante(id);
        return ResponseEntity.noContent().build();
    }

    // Otros métodos del controlador según tus necesidades
}