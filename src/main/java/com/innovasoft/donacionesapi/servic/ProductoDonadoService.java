package com.innovasoft.donacionesapi.servic;

import com.innovasoft.donacionesapi.dto.ProductoDonadoDTO;

import java.util.List;

public interface ProductoDonadoService {

    List<ProductoDonadoDTO> getAllProductosDonados();

    ProductoDonadoDTO getProductoDonadoById(Long id);

    ProductoDonadoDTO createProductoDonado(ProductoDonadoDTO productoDonadoDTO);

    ProductoDonadoDTO updateProductoDonado(Long id, ProductoDonadoDTO productoDonadoDTO);

    void deleteProductoDonado(Long id);
}