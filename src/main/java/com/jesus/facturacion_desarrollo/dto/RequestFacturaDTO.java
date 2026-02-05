package com.jesus.facturacion_desarrollo.dto;

import lombok.Data;

import java.util.Set;
@Data
public class RequestFacturaDTO {

    private Integer id;
    private  String numeroFactura;
    private Set<RequestDetalleFacturaDTO> detallesFactura;

}
