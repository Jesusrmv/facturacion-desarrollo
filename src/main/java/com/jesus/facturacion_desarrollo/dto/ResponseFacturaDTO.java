package com.jesus.facturacion_desarrollo.dto;

import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

public class ResponseFacturaDTO {

    private Integer id;
    private Integer numeroFactura;
    private Integer subTotal;
    private BigDecimal total;
    private LocalDate fechaCreado;
    private Set<ResponseDetalleFacturaDTO> detallesFactura;
}

