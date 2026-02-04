package com.jesus.facturacion_desarrollo.repository;

import com.jesus.facturacion_desarrollo.model.DetalleFactura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetalleFacturaRepository extends JpaRepository<DetalleFactura, Integer> {
}
