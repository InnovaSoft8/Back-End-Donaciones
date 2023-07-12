package com.innovasoft.donacionesapi.controller;

import com.innovasoft.donacionesapi.dto.PaisDTO;
import com.innovasoft.donacionesapi.servic.PaisService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paises")
public class PaisController {

    private final PaisService paisService;

    public PaisController(PaisService paisService) {
        this.paisService = paisService;
    }

    @GetMapping
    public ResponseEntity<List<PaisDTO>> getAllPaises() {
        List<PaisDTO> paises = paisService.getAllPaises();
        return new ResponseEntity<>(paises, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaisDTO> getPaisById(@PathVariable("id") Long id) {
        PaisDTO pais = paisService.getPaisById(id);
        return new ResponseEntity<>(pais, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PaisDTO> createPais(@RequestBody PaisDTO paisDTO) {
        PaisDTO createdPais = paisService.createPais(paisDTO);
        return new ResponseEntity<>(createdPais, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PaisDTO> updatePais(@PathVariable("id") Long id,
                                              @RequestBody PaisDTO paisDTO) {
        PaisDTO updatedPais = paisService.updatePais(id, paisDTO);
        return new ResponseEntity<>(updatedPais, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePais(@PathVariable("id") Long id) {
        paisService.deletePais(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}