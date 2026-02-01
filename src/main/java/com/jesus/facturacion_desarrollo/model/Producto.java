package com.jesus.facturacion_desarrollo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "productos")
@Getter
@Setter
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // llenado automatico
    private Integer id;
    private String nombre;
    private String detalle;
    private BigDecimal precio;

    @Column(updatable = false)
    @CreationTimestamp // cuando se crea el registro llena ese campo
    private LocalDateTime fechaCreado;
    @UpdateTimestamp // cuando se actualize se llena el campo
    private LocalDateTime fechaActualizado;
}
