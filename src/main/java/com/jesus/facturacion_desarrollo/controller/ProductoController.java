package com.jesus.facturacion_desarrollo.controller;

import com.jesus.facturacion_desarrollo.dto.ProductoDTO;
import com.jesus.facturacion_desarrollo.service.ProductoServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("api/v1/productos")
public class ProductoController {

    private final ProductoServices productoServices;

    public ProductoController(ProductoServices productoServices) {
        this.productoServices = productoServices;
    }

    @PostMapping
    public ResponseEntity<ProductoDTO> save(@RequestBody ProductoDTO productoDTO){
        return new ResponseEntity<>(productoServices.save(productoDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ProductoDTO>> findAll(){
        List<ProductoDTO> productosDTOS = productoServices.findAll();
        if (productosDTOS.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return new ResponseEntity<>(productosDTOS, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductoDTO> findById(@PathVariable Integer id){
        return productoServices.findById(id).map(
                ResponseEntity::ok
        ).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id){
        if (productoServices.deleteById(id)){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping
    public ResponseEntity<ProductoDTO> update(@RequestBody ProductoDTO productoDTO){
        return productoServices.update(productoDTO).map(
                ResponseEntity::ok
        ).orElseGet(
                () -> ResponseEntity.notFound().build()
        );
    }

}
