package com.innovasoft.donacionesapi.controller;

import com.innovasoft.donacionesapi.dto.PublicacionRedesSocialesDTO;
import com.innovasoft.donacionesapi.servic.PublicacionRedesSocialesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/publicaciones-redes-sociales")
public class PublicacionRedesSocialesController {

    private final PublicacionRedesSocialesService publicacionService;

    public PublicacionRedesSocialesController(PublicacionRedesSocialesService publicacionService) {
        this.publicacionService = publicacionService;
    }

    @GetMapping
    public ResponseEntity<List<PublicacionRedesSocialesDTO>> getAllPublicaciones() {
        List<PublicacionRedesSocialesDTO> publicaciones = publicacionService.getAllPublicaciones();
        return new ResponseEntity<>(publicaciones, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PublicacionRedesSocialesDTO> getPublicacionById(@PathVariable("id") Long id) {
        PublicacionRedesSocialesDTO publicacion = publicacionService.getPublicacionById(id);
        return new ResponseEntity<>(publicacion, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PublicacionRedesSocialesDTO> createPublicacion(
            @RequestBody PublicacionRedesSocialesDTO publicacionDTO) {
        PublicacionRedesSocialesDTO createdPublicacion = publicacionService.createPublicacion(publicacionDTO);
        return new ResponseEntity<>(createdPublicacion, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PublicacionRedesSocialesDTO> updatePublicacion(
            @PathVariable("id") Long id, @RequestBody PublicacionRedesSocialesDTO publicacionDTO) {
        PublicacionRedesSocialesDTO updatedPublicacion = publicacionService.updatePublicacion(id, publicacionDTO);
        return new ResponseEntity<>(updatedPublicacion, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePublicacion(@PathVariable("id") Long id) {
        publicacionService.deletePublicacion(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}