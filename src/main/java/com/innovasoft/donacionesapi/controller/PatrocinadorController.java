package com.innovasoft.donacionesapi.controller;

import com.innovasoft.donacionesapi.dto.PatrocinadorDTO;
import com.innovasoft.donacionesapi.servic.PatrocinadorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patrocinadores")
public class PatrocinadorController {

    private final PatrocinadorService patrocinadorService;

    public PatrocinadorController(PatrocinadorService patrocinadorService) {
        this.patrocinadorService = patrocinadorService;
    }

    @GetMapping
    public ResponseEntity<List<PatrocinadorDTO>> getAllPatrocinadores() {
        List<PatrocinadorDTO> patrocinadores = patrocinadorService.getAllPatrocinadores();
        return new ResponseEntity<>(patrocinadores, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatrocinadorDTO> getPatrocinadorById(@PathVariable("id") Long id) {
        PatrocinadorDTO patrocinador = patrocinadorService.getPatrocinadorById(id);
        return new ResponseEntity<>(patrocinador, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PatrocinadorDTO> createPatrocinador(@RequestBody PatrocinadorDTO patrocinadorDTO) {
        PatrocinadorDTO createdPatrocinador = patrocinadorService.createPatrocinador(patrocinadorDTO);
        return new ResponseEntity<>(createdPatrocinador, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PatrocinadorDTO> updatePatrocinador(@PathVariable("id") Long id,
                                                              @RequestBody PatrocinadorDTO patrocinadorDTO) {
        PatrocinadorDTO updatedPatrocinador = patrocinadorService.updatePatrocinador(id, patrocinadorDTO);
        return new ResponseEntity<>(updatedPatrocinador, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatrocinador(@PathVariable("id") Long id) {
        patrocinadorService.deletePatrocinador(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}