package com.innovasoft.donacionesapi.controller;

import com.innovasoft.donacionesapi.dto.TransaccionInternacionalDTO;
import com.innovasoft.donacionesapi.servic.TransaccionInternacionalService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transacciones-internacionales")
public class TransaccionInternacionalController {
    private final TransaccionInternacionalService transaccionService;

    public TransaccionInternacionalController(TransaccionInternacionalService transaccionService) {
        this.transaccionService = transaccionService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransaccionInternacionalDTO> getTransaccionInternacionalById(@PathVariable("id") Long id) {
        TransaccionInternacionalDTO transaccionDTO = transaccionService.getTransaccionInternacionalById(id);
        return ResponseEntity.ok(transaccionDTO);
    }

    @PostMapping
    public ResponseEntity<TransaccionInternacionalDTO> createTransaccionInternacional(@RequestBody TransaccionInternacionalDTO transaccionDTO) {
        TransaccionInternacionalDTO createdTransaccion = transaccionService.createTransaccionInternacional(transaccionDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTransaccion);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TransaccionInternacionalDTO> updateTransaccionInternacional(@PathVariable("id") Long id, @RequestBody TransaccionInternacionalDTO transaccionDTO) {
        TransaccionInternacionalDTO updatedTransaccion = transaccionService.updateTransaccionInternacional(id, transaccionDTO);
        return ResponseEntity.ok(updatedTransaccion);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTransaccionInternacional(@PathVariable("id") Long id) {
        transaccionService.deleteTransaccionInternacional(id);
        return ResponseEntity.noContent().build();
    }

    // Implementa otros métodos de controlador según tus necesidades
}