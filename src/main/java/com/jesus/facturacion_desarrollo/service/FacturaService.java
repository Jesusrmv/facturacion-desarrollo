package com.jesus.facturacion_desarrollo.service;

import com.jesus.facturacion_desarrollo.dto.RequestDetalleFacturaDTO;
import com.jesus.facturacion_desarrollo.dto.RequestFacturaDTO;
import com.jesus.facturacion_desarrollo.dto.ResponseFacturaDTO;
import com.jesus.facturacion_desarrollo.model.DetalleFactura;
import com.jesus.facturacion_desarrollo.model.Factura;
import com.jesus.facturacion_desarrollo.model.Producto;
import com.jesus.facturacion_desarrollo.repository.DetalleFacturaRepository;
import com.jesus.facturacion_desarrollo.repository.FacturaRepository;
import com.jesus.facturacion_desarrollo.repository.ProductoRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class FacturaService {


    private final FacturaRepository facturaRepository;
    private final ProductoRepository productoRepository;
    private final ModelMapper modelMapper;

    public FacturaService(FacturaRepository facturaRepository, ProductoRepository productoRepository, ModelMapper modelMapper) {
        this.facturaRepository = facturaRepository;
        this.productoRepository = productoRepository;
        this.modelMapper = modelMapper;
    }

    //tener todas las facturas
    public List<ResponseFacturaDTO> findAll() {
        return facturaRepository.findAll().stream().map(
                factura -> modelMapper.map(factura,ResponseFacturaDTO.class)
        ).collect(Collectors.toList());
    }

    //obtener facturas por id
    public Optional<ResponseFacturaDTO> findById(Integer id) {
        return facturaRepository.findById(id).map(
                factura -> modelMapper.map(factura,ResponseFacturaDTO.class)
        );
    }

    //elimnar las facturas por id
    public void deleteById(Integer id) {
        facturaRepository.deleteById(id);

    }
@Transactional
    public ResponseFacturaDTO save(RequestFacturaDTO requestFacturaDTO) {
        Factura factura = new Factura();
        BigDecimal subtotalFactura = BigDecimal.ZERO;
        Set<DetalleFactura> detalles = new HashSet<>();

        factura.setNumeroFactura(requestFacturaDTO.getNumeroFactura());

        for (RequestDetalleFacturaDTO detalleFacturaDTO: requestFacturaDTO.getDetallesFactura()) {
            //Producto producto = productoRepository.findById(detalleFacturaDTO.getIdProducto()).get();
            Producto producto = productoRepository.findById(detalleFacturaDTO.getIdProducto()).orElseThrow(
                    ()-> new RuntimeException("Producto no encontrado")
            );


            BigDecimal totalProducto = producto.getPrecio().multiply(BigDecimal.valueOf(detalleFacturaDTO.getCantidad()));
            subtotalFactura = subtotalFactura.add(totalProducto);

            DetalleFactura detalleFactura = new DetalleFactura();
            detalleFacturaDTO.setIdProducto(detalleFacturaDTO.getIdProducto());
            detalleFactura.setPrecio(subtotalFactura);
            detalleFactura.setCantidad(detalleFacturaDTO.getCantidad());
            detalleFactura.setTotal(totalProducto);
            detalleFactura.setFactura(factura);

            detalles.add(detalleFactura);
        }

        factura.setDetalleFacturas(detalles);
        factura.setSubTotal(subtotalFactura);
        factura.setTotal(subtotalFactura.add(subtotalFactura.multiply(BigDecimal.valueOf(factura.getIVA()))));

        Factura savedFactura = facturaRepository.save(factura);

        return modelMapper.map(savedFactura, ResponseFacturaDTO.class);
    }

}
