package com.jesus.facturacion_desarrollo.service;

import com.jesus.facturacion_desarrollo.repository.ProductoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ProductoServices {

    private final ProductoRepository productoRepository;
    private final ModelMapper modelMapper;
    public ProductoServices(ProductoRepository productoRepository, ModelMapper modelMapper) {
        this.productoRepository = productoRepository;
        this.modelMapper = modelMapper;
    }
}
