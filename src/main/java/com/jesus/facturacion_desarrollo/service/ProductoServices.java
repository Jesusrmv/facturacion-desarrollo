package com.jesus.facturacion_desarrollo.service;

import com.jesus.facturacion_desarrollo.dto.ProductoDTO;
import com.jesus.facturacion_desarrollo.model.Producto;
import com.jesus.facturacion_desarrollo.repository.ProductoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductoServices {

    private final ProductoRepository productoRepository;
    private final ModelMapper modelMapper;
    public ProductoServices(ProductoRepository productoRepository, ModelMapper modelMapper) {
        this.productoRepository = productoRepository;
        this.modelMapper = modelMapper;
    }

    public ProductoDTO save(ProductoDTO productoDTO) {
        Producto producto = modelMapper.map(productoDTO, Producto.class);
    return  modelMapper.map(productoRepository.save(producto), ProductoDTO.class);
    }

    public List<ProductoDTO> findAll() {
        return productoRepository.findAll().stream().map(
                producto -> {
                    return  modelMapper.map(producto, ProductoDTO.class);
                }
        ).collect(Collectors.toList());

    }

    public Optional<ProductoDTO> findById(Integer id) {
        return  productoRepository.findById(id).map(
                producto -> {
                    return  modelMapper.map(producto, ProductoDTO.class);
                }
        );
    }

    public boolean deleteById(Integer id) {
        return productoRepository.findById(id).map(
                producto ->  {
                    productoRepository.deleteById(id);
                    return  true;
                }

        ).orElse(false);
    }

    public Optional<ProductoDTO> update(ProductoDTO productoDTO) {
        return productoRepository.findById(productoDTO.getId())
                .map(productoDB -> {
                    // Copia los datos nuevos del DTO a la entidad existente
                    modelMapper.map(productoDTO, productoDB);

                    // Guarda (JPA hace UPDATE porque ya existe el ID)
                    Producto actualizado = productoRepository.save(productoDB);

                    // Devuelve el DTO actualizado
                    return modelMapper.map(actualizado, ProductoDTO.class);
                });
    }


}
