package com.innovasoft.donacionesapi.controller;

import com.innovasoft.donacionesapi.dto.ProyectoDTO;
import com.innovasoft.donacionesapi.servic.ProyectoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proyectos")
public class ProyectoController {

    private final ProyectoService proyectoService;

    public ProyectoController(ProyectoService proyectoService) {
        this.proyectoService = proyectoService;
    }

    @GetMapping
    public ResponseEntity<List<ProyectoDTO>> getAllProyectos() {
        List<ProyectoDTO> proyectos = proyectoService.getAllProyectos();
        return ResponseEntity.ok(proyectos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProyectoDTO> getProyectoById(@PathVariable("id") Long id) {
        ProyectoDTO proyectoDTO = proyectoService.getProyectoById(id);
        return ResponseEntity.ok(proyectoDTO);
    }

    @PostMapping
    public ResponseEntity<ProyectoDTO> createProyecto(@RequestBody ProyectoDTO proyectoDTO) {
        ProyectoDTO createdProyecto = proyectoService.createProyecto(proyectoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProyecto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProyectoDTO> updateProyecto(@PathVariable("id") Long id, @RequestBody ProyectoDTO proyectoDTO) {
        ProyectoDTO updatedProyecto = proyectoService.updateProyecto(id, proyectoDTO);
        return ResponseEntity.ok(updatedProyecto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProyecto(@PathVariable("id") Long id) {
        proyectoService.deleteProyecto(id);
        return ResponseEntity.noContent().build();
    }
}