package com.innovasoft.donacionesapi.controller;

import com.innovasoft.donacionesapi.dto.UbicacionDTO;
import com.innovasoft.donacionesapi.servic.UbicacionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ubicaciones")
public class UbicacionController {

    private final UbicacionService ubicacionService;

    public UbicacionController(UbicacionService ubicacionService) {
        this.ubicacionService = ubicacionService;
    }

    @GetMapping
    public ResponseEntity<List<UbicacionDTO>> getAllUbicaciones() {
        List<UbicacionDTO> ubicaciones = ubicacionService.getAllUbicaciones();
        return ResponseEntity.ok(ubicaciones);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UbicacionDTO> getUbicacionById(@PathVariable("id") Long id) {
        UbicacionDTO ubicacionDTO = ubicacionService.getUbicacionById(id);
        return ResponseEntity.ok(ubicacionDTO);
    }

    @PostMapping
    public ResponseEntity<UbicacionDTO> createUbicacion(@RequestBody UbicacionDTO ubicacionDTO) {
        UbicacionDTO createdUbicacion = ubicacionService.createUbicacion(ubicacionDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUbicacion);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UbicacionDTO> updateUbicacion(@PathVariable("id") Long id, @RequestBody UbicacionDTO ubicacionDTO) {
        UbicacionDTO updatedUbicacion = ubicacionService.updateUbicacion(id, ubicacionDTO);
        return ResponseEntity.ok(updatedUbicacion);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUbicacion(@PathVariable("id") Long id) {
        ubicacionService.deleteUbicacion(id);
        return ResponseEntity.noContent().build();
    }
}