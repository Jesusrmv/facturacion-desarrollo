package com.jesus.facturacion_desarrollo.dto;

import lombok.Data;
import lombok.ToString;

import java.util.Set;
@ToString
@Data
public class RequestFacturaDTO {

    private Integer id;
    private  String numeroFactura;
    private Set<RequestDetalleFacturaDTO> detalleFactura;

}
