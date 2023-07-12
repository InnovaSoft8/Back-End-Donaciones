package com.innovasoft.donacionesapi.servic.Impl;

import com.innovasoft.donacionesapi.dto.ProductoDonadoDTO;
import com.innovasoft.donacionesapi.exception.CustomException;
import com.innovasoft.donacionesapi.model.Donante;
import com.innovasoft.donacionesapi.model.ProductoDonado;
import com.innovasoft.donacionesapi.model.Proyecto;
import com.innovasoft.donacionesapi.model.TipoDonacion;
import com.innovasoft.donacionesapi.repository.DonanteRepository;
import com.innovasoft.donacionesapi.repository.ProductoDonadoRepository;
import com.innovasoft.donacionesapi.repository.ProyectoRepository;
import com.innovasoft.donacionesapi.repository.TipoDonacionRepository;
import com.innovasoft.donacionesapi.servic.ProductoDonadoService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductoDonadoServiceImpl implements ProductoDonadoService {

    private final ProductoDonadoRepository productoDonadoRepository;
    private final DonanteRepository donanteRepository;
    private final ProyectoRepository proyectoRepository;
    private final TipoDonacionRepository tipoDonacionRepository;
    private final ModelMapper modelMapper;

    public ProductoDonadoServiceImpl(ProductoDonadoRepository productoDonadoRepository,
                                     DonanteRepository donanteRepository,
                                     ProyectoRepository proyectoRepository,
                                     TipoDonacionRepository tipoDonacionRepository,
                                     ModelMapper modelMapper) {
        this.productoDonadoRepository = productoDonadoRepository;
        this.donanteRepository = donanteRepository;
        this.proyectoRepository = proyectoRepository;
        this.tipoDonacionRepository = tipoDonacionRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ProductoDonadoDTO> getAllProductosDonados() {
        List<ProductoDonado> productosDonados = productoDonadoRepository.findAll();
        return productosDonados.stream()
                .map(productoDonado -> modelMapper.map(productoDonado, ProductoDonadoDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ProductoDonadoDTO getProductoDonadoById(Long id) {
        ProductoDonado productoDonado = productoDonadoRepository.findById(id)
                .orElseThrow(() -> new CustomException("Producto Donado no encontrado con ID: " + id));
        return modelMapper.map(productoDonado, ProductoDonadoDTO.class);
    }

    @Override
    public ProductoDonadoDTO createProductoDonado(ProductoDonadoDTO productoDonadoDTO) {
        ProductoDonado productoDonado = new ProductoDonado();
        productoDonado.setNombre(productoDonadoDTO.getNombre());
        productoDonado.setDescripcion(productoDonadoDTO.getDescripcion());
        productoDonado.setValorEstimado(productoDonadoDTO.getValorEstimado());
        Donante donante = donanteRepository.findById(productoDonadoDTO.getIdDonante())
                .orElseThrow(() -> new CustomException("Donante no encontrado con ID: " + productoDonadoDTO.getIdDonante()));
        productoDonado.setDonante(donante);
        Proyecto proyecto = proyectoRepository.findById(productoDonadoDTO.getIdProyecto())
                .orElseThrow(() -> new CustomException("Proyecto no encontrado con ID: " + productoDonadoDTO.getIdProyecto()));
        productoDonado.setProyecto(proyecto);
        TipoDonacion tipoDonacion = tipoDonacionRepository.findById(productoDonadoDTO.getIdTipoDonacion())
                .orElseThrow(() -> new CustomException("Tipo de Donación no encontrado con ID: " + productoDonadoDTO.getIdTipoDonacion()));
        productoDonado.setTipoDonacion(tipoDonacion);
        productoDonadoRepository.save(productoDonado);
        return modelMapper.map(productoDonado, ProductoDonadoDTO.class);
    }

    @Override
    public ProductoDonadoDTO updateProductoDonado(Long id, ProductoDonadoDTO productoDonadoDTO) {
        ProductoDonado productoDonado = productoDonadoRepository.findById(id)
                .orElseThrow(() -> new CustomException("Producto Donado no encontrado con ID: " + id));
        productoDonado.setNombre(productoDonadoDTO.getNombre());
        productoDonado.setDescripcion(productoDonadoDTO.getDescripcion());
        productoDonado.setValorEstimado(productoDonadoDTO.getValorEstimado());
        Donante donante = donanteRepository.findById(productoDonadoDTO.getIdDonante())
                .orElseThrow(() -> new CustomException("Donante no encontrado con ID: " + productoDonadoDTO.getIdDonante()));
        productoDonado.setDonante(donante);
        Proyecto proyecto = proyectoRepository.findById(productoDonadoDTO.getIdProyecto())
                .orElseThrow(() -> new CustomException("Proyecto no encontrado con ID: " + productoDonadoDTO.getIdProyecto()));
        productoDonado.setProyecto(proyecto);
        TipoDonacion tipoDonacion = tipoDonacionRepository.findById(productoDonadoDTO.getIdTipoDonacion())
                .orElseThrow(() -> new CustomException("Tipo de Donación no encontrado con ID: " + productoDonadoDTO.getIdTipoDonacion()));
        productoDonado.setTipoDonacion(tipoDonacion);
        productoDonadoRepository.save(productoDonado);
        return modelMapper.map(productoDonado, ProductoDonadoDTO.class);
    }

    @Override
    public void deleteProductoDonado(Long id) {
        ProductoDonado productoDonado = productoDonadoRepository.findById(id)
                .orElseThrow(() -> new CustomException("Producto Donado no encontrado con ID: " + id));
        productoDonadoRepository.delete(productoDonado);
    }
}