package com.jesus.facturacion_desarrollo.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
public class ProductoDTO {

    private Integer id;
    private String nombre;
    private String detalle;
    private BigDecimal precio;
}
