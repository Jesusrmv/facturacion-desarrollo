package com.jesus.facturacion_desarrollo.service;

import com.jesus.facturacion_desarrollo.dto.ResponseFacturaDTO;
import com.jesus.facturacion_desarrollo.repository.DetalleFacturaRepository;
import com.jesus.facturacion_desarrollo.repository.FacturaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class FacturaService {


    private final FacturaRepository facturaRepository;
    private final FacturaRepository detalleFacturaRepository;
    private final ModelMapper modelMapper;

    public FacturaService(FacturaRepository facturaRepository, FacturaRepository detalleFacturaRepository, ModelMapper modelMapper) {
        this.facturaRepository = facturaRepository;
        this.detalleFacturaRepository = detalleFacturaRepository;
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
}
