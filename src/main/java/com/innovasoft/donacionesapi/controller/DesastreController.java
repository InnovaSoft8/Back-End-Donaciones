package com.innovasoft.donacionesapi.controller;

import com.innovasoft.donacionesapi.dto.DesastreDTO;
import com.innovasoft.donacionesapi.servic.DesastreService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/desastres")
public class DesastreController {

    private final DesastreService desastreService;

    public DesastreController(DesastreService desastreService) {
        this.desastreService = desastreService;
    }

    @GetMapping
    public ResponseEntity<List<DesastreDTO>> getAllDesastres() {
        List<DesastreDTO> desastres = desastreService.getAllDesastres();
        return ResponseEntity.ok(desastres);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DesastreDTO> getDesastreById(@PathVariable("id") Long id) {
        DesastreDTO desastreDTO = desastreService.getDesastreById(id);
        return ResponseEntity.ok(desastreDTO);
    }

    @PostMapping
    public ResponseEntity<DesastreDTO> createDesastre(@RequestBody DesastreDTO desastreDTO) {
        DesastreDTO createdDesastre = desastreService.createDesastre(desastreDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdDesastre);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DesastreDTO> updateDesastre(@PathVariable("id") Long id, @RequestBody DesastreDTO desastreDTO) {
        DesastreDTO updatedDesastre = desastreService.updateDesastre(id, desastreDTO);
        return ResponseEntity.ok(updatedDesastre);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDesastre(@PathVariable("id") Long id) {
        desastreService.deleteDesastre(id);
        return ResponseEntity.noContent().build();
    }
}