package com.innovasoft.donacionesapi.controller;

import com.innovasoft.donacionesapi.dto.DesastreUbicacionDTO;
import com.innovasoft.donacionesapi.servic.DesastreUbicacionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/desastre-ubicaciones")
public class DesastreUbicacionController {

    private final DesastreUbicacionService desastreUbicacionService;

    public DesastreUbicacionController(DesastreUbicacionService desastreUbicacionService) {
        this.desastreUbicacionService = desastreUbicacionService;
    }

    @GetMapping
    public ResponseEntity<List<DesastreUbicacionDTO>> getAllDesastreUbicaciones() {
        List<DesastreUbicacionDTO> desastreUbicaciones = desastreUbicacionService.getAllDesastreUbicaciones();
        return new ResponseEntity<>(desastreUbicaciones, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DesastreUbicacionDTO> getDesastreUbicacionById(@PathVariable("id") Long id) {
        DesastreUbicacionDTO desastreUbicacion = desastreUbicacionService.getDesastreUbicacionById(id);
        return new ResponseEntity<>(desastreUbicacion, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DesastreUbicacionDTO> createDesastreUbicacion(@RequestBody DesastreUbicacionDTO desastreUbicacionDTO) {
        DesastreUbicacionDTO createdDesastreUbicacion = desastreUbicacionService.createDesastreUbicacion(desastreUbicacionDTO);
        return new ResponseEntity<>(createdDesastreUbicacion, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DesastreUbicacionDTO> updateDesastreUbicacion(@PathVariable("id") Long id,
                                                                        @RequestBody DesastreUbicacionDTO desastreUbicacionDTO) {
        DesastreUbicacionDTO updatedDesastreUbicacion = desastreUbicacionService.updateDesastreUbicacion(id, desastreUbicacionDTO);
        return new ResponseEntity<>(updatedDesastreUbicacion, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDesastreUbicacion(@PathVariable("id") Long id) {
        desastreUbicacionService.deleteDesastreUbicacion(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}