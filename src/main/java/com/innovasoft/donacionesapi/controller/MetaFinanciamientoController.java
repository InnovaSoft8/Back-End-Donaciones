package com.innovasoft.donacionesapi.controller;

import com.innovasoft.donacionesapi.dto.MetaFinanciamientoDTO;
import com.innovasoft.donacionesapi.servic.MetaFinanciamientoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/metas-financiamiento")
public class MetaFinanciamientoController {

    private final MetaFinanciamientoService metaFinanciamientoService;

    public MetaFinanciamientoController(MetaFinanciamientoService metaFinanciamientoService) {
        this.metaFinanciamientoService = metaFinanciamientoService;
    }

    @GetMapping
    public ResponseEntity<List<MetaFinanciamientoDTO>> getAllMetasFinanciamiento() {
        List<MetaFinanciamientoDTO> metasFinanciamiento = metaFinanciamientoService.getAllMetasFinanciamiento();
        return new ResponseEntity<>(metasFinanciamiento, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MetaFinanciamientoDTO> getMetaFinanciamientoById(@PathVariable("id") Long id) {
        MetaFinanciamientoDTO metaFinanciamiento = metaFinanciamientoService.getMetaFinanciamientoById(id);
        return new ResponseEntity<>(metaFinanciamiento, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<MetaFinanciamientoDTO> createMetaFinanciamiento(
            @RequestBody MetaFinanciamientoDTO metaFinanciamientoDTO) {
        MetaFinanciamientoDTO createdMetaFinanciamiento =
                metaFinanciamientoService.createMetaFinanciamiento(metaFinanciamientoDTO);
        return new ResponseEntity<>(createdMetaFinanciamiento, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MetaFinanciamientoDTO> updateMetaFinanciamiento(
            @PathVariable("id") Long id, @RequestBody MetaFinanciamientoDTO metaFinanciamientoDTO) {
        MetaFinanciamientoDTO updatedMetaFinanciamiento =
                metaFinanciamientoService.updateMetaFinanciamiento(id, metaFinanciamientoDTO);
        return new ResponseEntity<>(updatedMetaFinanciamiento, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMetaFinanciamiento(@PathVariable("id") Long id) {
        metaFinanciamientoService.deleteMetaFinanciamiento(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}