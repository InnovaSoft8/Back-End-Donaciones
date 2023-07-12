package com.innovasoft.donacionesapi.servic;

import com.innovasoft.donacionesapi.dto.TestimonioDTO;

import java.util.List;

public interface TestimonioService {

    List<TestimonioDTO> getAllTestimonios();

    TestimonioDTO getTestimonioById(Long id);

    TestimonioDTO createTestimonio(TestimonioDTO testimonioDTO);

    TestimonioDTO updateTestimonio(Long id, TestimonioDTO testimonioDTO);

    void deleteTestimonio(Long id);
}