package com.example.zy6r_4E_Alexis_Arriola_CC7.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Getter
@Setter
@Entity
@Table(name = "prestamos")
public class Prestamo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombreSolicitante;
    private LocalDateTime fechaPrestamo;
    private LocalDateTime fechaDevolucion;

    @ManyToOne(optional = false)
    @JoinColumn(name = "videojuego_id")
    private Videojuego videojuego;


    @Enumerated(EnumType.STRING)
    private Estado estado;
}