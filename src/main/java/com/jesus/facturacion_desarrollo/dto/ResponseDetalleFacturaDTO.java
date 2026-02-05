package com.jesus.facturacion_desarrollo.dto;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class ResponseDetalleFacturaDTO {

    private Integer idProducto;
    private Integer cantidad;
    private Double precio;
    private BigDecimal total;

}
