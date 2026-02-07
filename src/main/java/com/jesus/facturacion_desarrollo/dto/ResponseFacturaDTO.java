package com.jesus.facturacion_desarrollo.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;
@Getter
@Setter
public class ResponseFacturaDTO {

    private Integer id;
    private String numeroFactura;
    private Integer subTotal;
    private BigDecimal total;
    private LocalDate fechaCreacion;
    private Set<ResponseDetalleFacturaDTO> detalleFactura;
}

