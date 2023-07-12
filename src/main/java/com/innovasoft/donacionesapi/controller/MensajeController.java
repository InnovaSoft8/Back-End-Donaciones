package com.innovasoft.donacionesapi.controller;

import com.innovasoft.donacionesapi.dto.MensajeDTO;
import com.innovasoft.donacionesapi.servic.MensajeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mensajes")
public class MensajeController {

    private final MensajeService mensajeService;

    public MensajeController(MensajeService mensajeService) {
        this.mensajeService = mensajeService;
    }

    @GetMapping
    public ResponseEntity<List<MensajeDTO>> getAllMensajes() {
        List<MensajeDTO> mensajes = mensajeService.getAllMensajes();
        return new ResponseEntity<>(mensajes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MensajeDTO> getMensajeById(@PathVariable("id") Long id) {
        MensajeDTO mensaje = mensajeService.getMensajeById(id);
        return new ResponseEntity<>(mensaje, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<MensajeDTO> createMensaje(@RequestBody MensajeDTO mensajeDTO) {
        MensajeDTO createdMensaje = mensajeService.createMensaje(mensajeDTO);
        return new ResponseEntity<>(createdMensaje, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MensajeDTO> updateMensaje(@PathVariable("id") Long id, @RequestBody MensajeDTO mensajeDTO) {
        MensajeDTO updatedMensaje = mensajeService.updateMensaje(id, mensajeDTO);
        return new ResponseEntity<>(updatedMensaje, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMensaje(@PathVariable("id") Long id) {
        mensajeService.deleteMensaje(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}