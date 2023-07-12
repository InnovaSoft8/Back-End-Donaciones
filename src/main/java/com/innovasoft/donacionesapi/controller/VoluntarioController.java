package com.innovasoft.donacionesapi.controller;

import com.innovasoft.donacionesapi.dto.VoluntarioDTO;
import com.innovasoft.donacionesapi.servic.VoluntarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/voluntarios")
public class VoluntarioController {

    private final VoluntarioService voluntarioService;

    public VoluntarioController(VoluntarioService voluntarioService) {
        this.voluntarioService = voluntarioService;
    }

    @GetMapping
    public ResponseEntity<List<VoluntarioDTO>> getAllVoluntarios() {
        List<VoluntarioDTO> voluntarios = voluntarioService.getAllVoluntarios();
        return new ResponseEntity<>(voluntarios, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VoluntarioDTO> getVoluntarioById(@PathVariable("id") Long id) {
        VoluntarioDTO voluntario = voluntarioService.getVoluntarioById(id);
        return new ResponseEntity<>(voluntario, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<VoluntarioDTO> createVoluntario(@RequestBody VoluntarioDTO voluntarioDTO) {
        VoluntarioDTO createdVoluntario = voluntarioService.createVoluntario(voluntarioDTO);
        return new ResponseEntity<>(createdVoluntario, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VoluntarioDTO> updateVoluntario(@PathVariable("id") Long id,
                                                          @RequestBody VoluntarioDTO voluntarioDTO) {
        VoluntarioDTO updatedVoluntario = voluntarioService.updateVoluntario(id, voluntarioDTO);
        return new ResponseEntity<>(updatedVoluntario, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVoluntario(@PathVariable("id") Long id) {
        voluntarioService.deleteVoluntario(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}