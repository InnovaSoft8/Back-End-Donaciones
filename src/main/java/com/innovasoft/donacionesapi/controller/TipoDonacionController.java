package com.innovasoft.donacionesapi.controller;

import com.innovasoft.donacionesapi.dto.TipoDonacionDTO;
import com.innovasoft.donacionesapi.servic.TipoDonacionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tipo-donaciones")
public class TipoDonacionController {

    private final TipoDonacionService tipoDonacionService;

    public TipoDonacionController(TipoDonacionService tipoDonacionService) {
        this.tipoDonacionService = tipoDonacionService;
    }

    @GetMapping
    public ResponseEntity<List<TipoDonacionDTO>> getAllTipoDonaciones() {
        List<TipoDonacionDTO> tipoDonaciones = tipoDonacionService.getAllTipoDonaciones();
        return new ResponseEntity<>(tipoDonaciones, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoDonacionDTO> getTipoDonacionById(@PathVariable("id") Long id) {
        TipoDonacionDTO tipoDonacion = tipoDonacionService.getTipoDonacionById(id);
        return new ResponseEntity<>(tipoDonacion, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TipoDonacionDTO> createTipoDonacion(@RequestBody TipoDonacionDTO tipoDonacionDTO) {
        TipoDonacionDTO createdTipoDonacion = tipoDonacionService.createTipoDonacion(tipoDonacionDTO);
        return new ResponseEntity<>(createdTipoDonacion, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoDonacionDTO> updateTipoDonacion(@PathVariable("id") Long id,
                                                              @RequestBody TipoDonacionDTO tipoDonacionDTO) {
        TipoDonacionDTO updatedTipoDonacion = tipoDonacionService.updateTipoDonacion(id, tipoDonacionDTO);
        return new ResponseEntity<>(updatedTipoDonacion, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTipoDonacion(@PathVariable("id") Long id) {
        tipoDonacionService.deleteTipoDonacion(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}