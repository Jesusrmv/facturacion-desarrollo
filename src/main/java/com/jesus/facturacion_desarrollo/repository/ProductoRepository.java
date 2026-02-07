package com.jesus.facturacion_desarrollo.repository;

import com.jesus.facturacion_desarrollo.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto,Integer> {
}
