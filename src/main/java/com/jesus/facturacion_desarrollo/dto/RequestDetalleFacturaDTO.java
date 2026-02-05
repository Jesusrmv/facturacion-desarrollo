package com.jesus.facturacion_desarrollo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestDetalleFacturaDTO {
    private Integer idProducto;
    private Integer cantidad;
}
