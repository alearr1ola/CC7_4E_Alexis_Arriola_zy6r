package com.example.zy6r_4E_Alexis_Arriola_CC7.controller.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PrestamoDTO(
        @NotNull(message = "El id del videojuego es obligatorio")
        Long videojuegoId,

        @NotBlank(message = "El nombre del solicitante es obligatorio")
        String nombreSolicitante) {
}