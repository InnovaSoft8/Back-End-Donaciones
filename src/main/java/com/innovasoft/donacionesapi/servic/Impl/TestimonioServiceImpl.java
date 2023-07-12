package com.innovasoft.donacionesapi.servic.Impl;

import com.innovasoft.donacionesapi.dto.TestimonioDTO;
import com.innovasoft.donacionesapi.exception.CustomException;
import com.innovasoft.donacionesapi.model.Donante;
import com.innovasoft.donacionesapi.model.Testimonio;
import com.innovasoft.donacionesapi.repository.DonanteRepository;
import com.innovasoft.donacionesapi.repository.TestimonioRepository;
import com.innovasoft.donacionesapi.servic.TestimonioService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TestimonioServiceImpl implements TestimonioService {

    private final TestimonioRepository testimonioRepository;
    private final DonanteRepository donanteRepository;
    private final ModelMapper modelMapper;

    public TestimonioServiceImpl(TestimonioRepository testimonioRepository, DonanteRepository donanteRepository,
                                 ModelMapper modelMapper) {
        this.testimonioRepository = testimonioRepository;
        this.donanteRepository = donanteRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<TestimonioDTO> getAllTestimonios() {
        List<Testimonio> testimonios = testimonioRepository.findAll();
        return testimonios.stream()
                .map(testimonio -> modelMapper.map(testimonio, TestimonioDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public TestimonioDTO getTestimonioById(Long id) {
        Testimonio testimonio = testimonioRepository.findById(id)
                .orElseThrow(() -> new CustomException("Testimonio no encontrado con ID: " + id));
        return modelMapper.map(testimonio, TestimonioDTO.class);
    }

    @Override
    public TestimonioDTO createTestimonio(TestimonioDTO testimonioDTO) {
        Testimonio testimonio = new Testimonio();
        testimonio.setContenido(testimonioDTO.getContenido());
        Donante donante = donanteRepository.findById(testimonioDTO.getIdDonante())
                .orElseThrow(() -> new CustomException("Donante no encontrado con ID: " + testimonioDTO.getIdDonante()));
        testimonio.setDonante(donante);
        testimonioRepository.save(testimonio);
        return modelMapper.map(testimonio, TestimonioDTO.class);
    }

    @Override
    public TestimonioDTO updateTestimonio(Long id, TestimonioDTO testimonioDTO) {
        Testimonio testimonio = testimonioRepository.findById(id)
                .orElseThrow(() -> new CustomException("Testimonio no encontrado con ID: " + id));
        testimonio.setContenido(testimonioDTO.getContenido());
        Donante donante = donanteRepository.findById(testimonioDTO.getIdDonante())
                .orElseThrow(() -> new CustomException("Donante no encontrado con ID: " + testimonioDTO.getIdDonante()));
        testimonio.setDonante(donante);
        testimonioRepository.save(testimonio);
        return modelMapper.map(testimonio, TestimonioDTO.class);
    }

    @Override
    public void deleteTestimonio(Long id) {
        Testimonio testimonio = testimonioRepository.findById(id)
                .orElseThrow(() -> new CustomException("Testimonio no encontrado con ID: " + id));
        testimonioRepository.delete(testimonio);
    }
}