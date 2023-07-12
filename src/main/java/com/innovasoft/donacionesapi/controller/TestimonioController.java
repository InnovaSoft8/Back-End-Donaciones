package com.innovasoft.donacionesapi.controller;

import com.innovasoft.donacionesapi.dto.TestimonioDTO;
import com.innovasoft.donacionesapi.servic.TestimonioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/testimonios")
public class TestimonioController {

    private final TestimonioService testimonioService;

    public TestimonioController(TestimonioService testimonioService) {
        this.testimonioService = testimonioService;
    }

    @GetMapping
    public ResponseEntity<List<TestimonioDTO>> getAllTestimonios() {
        List<TestimonioDTO> testimonios = testimonioService.getAllTestimonios();
        return new ResponseEntity<>(testimonios, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TestimonioDTO> getTestimonioById(@PathVariable("id") Long id) {
        TestimonioDTO testimonio = testimonioService.getTestimonioById(id);
        return new ResponseEntity<>(testimonio, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TestimonioDTO> createTestimonio(@RequestBody TestimonioDTO testimonioDTO) {
        TestimonioDTO createdTestimonio = testimonioService.createTestimonio(testimonioDTO);
        return new ResponseEntity<>(createdTestimonio, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TestimonioDTO> updateTestimonio(@PathVariable("id") Long id,
                                                          @RequestBody TestimonioDTO testimonioDTO) {
        TestimonioDTO updatedTestimonio = testimonioService.updateTestimonio(id, testimonioDTO);
        return new ResponseEntity<>(updatedTestimonio, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTestimonio(@PathVariable("id") Long id) {
        testimonioService.deleteTestimonio(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}