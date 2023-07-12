package com.innovasoft.donacionesapi.controller;

import com.innovasoft.donacionesapi.dto.ReceptorDTO;
import com.innovasoft.donacionesapi.servic.ReceptorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/receptores")
public class ReceptorController {

    private final ReceptorService receptorService;

    public ReceptorController(ReceptorService receptorService) {
        this.receptorService = receptorService;
    }

    @GetMapping
    public ResponseEntity<List<ReceptorDTO>> getAllReceptores() {
        List<ReceptorDTO> receptores = receptorService.getAllReceptores();
        return ResponseEntity.ok(receptores);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReceptorDTO> getReceptorById(@PathVariable("id") Long id) {
        ReceptorDTO receptor = receptorService.getReceptorById(id);
        return ResponseEntity.ok(receptor);
    }

    @PostMapping
    public ResponseEntity<ReceptorDTO> createReceptor(@RequestBody ReceptorDTO receptorDTO) {
        ReceptorDTO createdReceptor = receptorService.createReceptor(receptorDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdReceptor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReceptorDTO> updateReceptor(@PathVariable("id") Long id, @RequestBody ReceptorDTO receptorDTO) {
        ReceptorDTO updatedReceptor = receptorService.updateReceptor(id, receptorDTO);
        return ResponseEntity.ok(updatedReceptor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReceptor(@PathVariable("id") Long id) {
        receptorService.deleteReceptor(id);
        return ResponseEntity.noContent().build();
    }
}