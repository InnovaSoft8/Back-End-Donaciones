package com.innovasoft.donacionesapi.controller;

import com.innovasoft.donacionesapi.dto.SubastaDTO;
import com.innovasoft.donacionesapi.servic.SubastaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subastas")
public class SubastaController {

    private final SubastaService subastaService;

    public SubastaController(SubastaService subastaService) {
        this.subastaService = subastaService;
    }

    @GetMapping
    public ResponseEntity<List<SubastaDTO>> getAllSubastas() {
        List<SubastaDTO> subastas = subastaService.getAllSubastas();
        return new ResponseEntity<>(subastas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubastaDTO> getSubastaById(@PathVariable("id") Long id) {
        SubastaDTO subasta = subastaService.getSubastaById(id);
        return new ResponseEntity<>(subasta, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<SubastaDTO> createSubasta(@RequestBody SubastaDTO subastaDTO) {
        SubastaDTO createdSubasta = subastaService.createSubasta(subastaDTO);
        return new ResponseEntity<>(createdSubasta, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SubastaDTO> updateSubasta(
            @PathVariable("id") Long id, @RequestBody SubastaDTO subastaDTO) {
        SubastaDTO updatedSubasta = subastaService.updateSubasta(id, subastaDTO);
        return new ResponseEntity<>(updatedSubasta, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSubasta(@PathVariable("id") Long id) {
        subastaService.deleteSubasta(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}