package com.innovasoft.donacionesapi.controller;

import com.innovasoft.donacionesapi.dto.RecursoDTO;
import com.innovasoft.donacionesapi.servic.RecursoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recursos")
public class RecursoController {

    private final RecursoService recursoService;

    public RecursoController(RecursoService recursoService) {
        this.recursoService = recursoService;
    }

    @GetMapping
    public ResponseEntity<List<RecursoDTO>> getAllRecursos() {
        List<RecursoDTO> recursos = recursoService.getAllRecursos();
        return new ResponseEntity<>(recursos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecursoDTO> getRecursoById(@PathVariable("id") Long id) {
        RecursoDTO recurso = recursoService.getRecursoById(id);
        return new ResponseEntity<>(recurso, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<RecursoDTO> createRecurso(@RequestBody RecursoDTO recursoDTO) {
        RecursoDTO createdRecurso = recursoService.createRecurso(recursoDTO);
        return new ResponseEntity<>(createdRecurso, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RecursoDTO> updateRecurso(
            @PathVariable("id") Long id, @RequestBody RecursoDTO recursoDTO) {
        RecursoDTO updatedRecurso = recursoService.updateRecurso(id, recursoDTO);
        return new ResponseEntity<>(updatedRecurso, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecurso(@PathVariable("id") Long id) {
        recursoService.deleteRecurso(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}