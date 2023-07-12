package com.innovasoft.donacionesapi.controller;

import com.innovasoft.donacionesapi.dto.ProgramaRecompensasDTO;
import com.innovasoft.donacionesapi.servic.ProgramaRecompensasService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/programas-recompensas")
public class ProgramaRecompensasController {

    private final ProgramaRecompensasService programaRecompensasService;

    public ProgramaRecompensasController(ProgramaRecompensasService programaRecompensasService) {
        this.programaRecompensasService = programaRecompensasService;
    }

    @GetMapping
    public ResponseEntity<List<ProgramaRecompensasDTO>> getAllProgramasRecompensas() {
        List<ProgramaRecompensasDTO> programasRecompensas = programaRecompensasService.getAllProgramasRecompensas();
        return new ResponseEntity<>(programasRecompensas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProgramaRecompensasDTO> getProgramaRecompensasById(@PathVariable("id") Long id) {
        ProgramaRecompensasDTO programaRecompensas = programaRecompensasService.getProgramaRecompensasById(id);
        return new ResponseEntity<>(programaRecompensas, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProgramaRecompensasDTO> createProgramaRecompensas(
            @RequestBody ProgramaRecompensasDTO programaRecompensasDTO) {
        ProgramaRecompensasDTO createdProgramaRecompensas =
                programaRecompensasService.createProgramaRecompensas(programaRecompensasDTO);
        return new ResponseEntity<>(createdProgramaRecompensas, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProgramaRecompensasDTO> updateProgramaRecompensas(
            @PathVariable("id") Long id, @RequestBody ProgramaRecompensasDTO programaRecompensasDTO) {
        ProgramaRecompensasDTO updatedProgramaRecompensas =
                programaRecompensasService.updateProgramaRecompensas(id, programaRecompensasDTO);
        return new ResponseEntity<>(updatedProgramaRecompensas, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProgramaRecompensas(@PathVariable("id") Long id) {
        programaRecompensasService.deleteProgramaRecompensas(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}