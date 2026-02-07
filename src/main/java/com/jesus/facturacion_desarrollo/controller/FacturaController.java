package com.jesus.facturacion_desarrollo.controller;

import com.jesus.facturacion_desarrollo.dto.RequestFacturaDTO;
import com.jesus.facturacion_desarrollo.dto.ResponseFacturaDTO;
import com.jesus.facturacion_desarrollo.service.FacturaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/factura")
public class FacturaController {

    private final FacturaService facturaService;

    public FacturaController(FacturaService facturaService) {
        this.facturaService = facturaService;
    }

    @PostMapping
    public ResponseFacturaDTO saves(@RequestBody RequestFacturaDTO requestFacturaDTO) {
        return facturaService.save(requestFacturaDTO);
    }
    @GetMapping
    public ResponseEntity<List<ResponseFacturaDTO>> findAll() {
        List<ResponseFacturaDTO> responseFacturaDTOS = facturaService.findAll();
        if (responseFacturaDTOS.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(responseFacturaDTOS);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseFacturaDTO> findById(@PathVariable Integer id) {
        Optional<ResponseFacturaDTO> factura = facturaService.findById(id);
        return factura.map(
                ResponseEntity::ok
        ).orElseGet(
                ()->ResponseEntity.notFound().build()
        );
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        facturaService.deleteById(id);
    }


}


