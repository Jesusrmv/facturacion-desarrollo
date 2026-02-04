package com.jesus.facturacion_desarrollo.repository;

import com.jesus.facturacion_desarrollo.model.Factura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacturaRepository extends JpaRepository<Factura, Integer> {
}
