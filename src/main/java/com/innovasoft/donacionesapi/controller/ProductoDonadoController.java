package com.innovasoft.donacionesapi.controller;

import com.innovasoft.donacionesapi.dto.ProductoDonadoDTO;
import com.innovasoft.donacionesapi.servic.ProductoDonadoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos-donados")
public class ProductoDonadoController {

    private final ProductoDonadoService productoDonadoService;

    public ProductoDonadoController(ProductoDonadoService productoDonadoService) {
        this.productoDonadoService = productoDonadoService;
    }

    @GetMapping
    public ResponseEntity<List<ProductoDonadoDTO>> getAllProductosDonados() {
        List<ProductoDonadoDTO> productosDonados = productoDonadoService.getAllProductosDonados();
        return new ResponseEntity<>(productosDonados, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductoDonadoDTO> getProductoDonadoById(@PathVariable("id") Long id) {
        ProductoDonadoDTO productoDonado = productoDonadoService.getProductoDonadoById(id);
        return new ResponseEntity<>(productoDonado, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProductoDonadoDTO> createProductoDonado(@RequestBody ProductoDonadoDTO productoDonadoDTO) {
        ProductoDonadoDTO createdProductoDonado = productoDonadoService.createProductoDonado(productoDonadoDTO);
        return new ResponseEntity<>(createdProductoDonado, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductoDonadoDTO> updateProductoDonado(@PathVariable("id") Long id,
                                                                  @RequestBody ProductoDonadoDTO productoDonadoDTO) {
        ProductoDonadoDTO updatedProductoDonado = productoDonadoService.updateProductoDonado(id, productoDonadoDTO);
        return new ResponseEntity<>(updatedProductoDonado, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProductoDonado(@PathVariable("id") Long id) {
        productoDonadoService.deleteProductoDonado(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}