package com.innovasoft.donacionesapi.controller;

import com.innovasoft.donacionesapi.dto.TransaccionDTO;
import com.innovasoft.donacionesapi.servic.TransaccionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transacciones")
public class TransaccionController {

    private final TransaccionService transaccionService;

    public TransaccionController(TransaccionService transaccionService) {
        this.transaccionService = transaccionService;
    }

    @GetMapping
    public ResponseEntity<List<TransaccionDTO>> getAllTransacciones() {
        List<TransaccionDTO> transacciones = transaccionService.getAllTransacciones();
        return new ResponseEntity<>(transacciones, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransaccionDTO> getTransaccionById(@PathVariable("id") Long id) {
        TransaccionDTO transaccion = transaccionService.getTransaccionById(id);
        return new ResponseEntity<>(transaccion, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TransaccionDTO> createTransaccion(@RequestBody TransaccionDTO transaccionDTO) {
        TransaccionDTO createdTransaccion = transaccionService.createTransaccion(transaccionDTO);
        return new ResponseEntity<>(createdTransaccion, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TransaccionDTO> updateTransaccion(@PathVariable("id") Long id,
                                                            @RequestBody TransaccionDTO transaccionDTO) {
        TransaccionDTO updatedTransaccion = transaccionService.updateTransaccion(id, transaccionDTO);
        return new ResponseEntity<>(updatedTransaccion, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTransaccion(@PathVariable("id") Long id) {
        transaccionService.deleteTransaccion(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
