package com.example.zy6r_4E_Alexis_Arriola_CC7.controller;

import com.example.zy6r_4E_Alexis_Arriola_CC7.controller.dto.PrestamoDTO;
import com.example.zy6r_4E_Alexis_Arriola_CC7.model.Prestamo;

import com.example.zy6r_4E_Alexis_Arriola_CC7.service.PrestamoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController("/prestamos")
public class PrestamoController {

    private PrestamoService prestamoService;

    public PrestamoController(PrestamoService prestamoService) {
        this.prestamoService = prestamoService;
    }

    @PostMapping
    public ResponseEntity<Prestamo> crear(@Valid @RequestBody PrestamoDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(prestamoService.crear(dto));
    }

    @PutMapping("/{id}/devolver")
    public ResponseEntity<Prestamo> devolver(@PathVariable Long id) {

        return ResponseEntity.ok(prestamoService.devolver(id));
    }



}
