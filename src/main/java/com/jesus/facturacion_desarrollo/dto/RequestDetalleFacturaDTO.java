package com.jesus.facturacion_desarrollo.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class RequestDetalleFacturaDTO {
    private Integer idProducto;
    private Integer cantidad;
}
