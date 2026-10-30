package com.example.zy6r_4E_Alexis_Arriola_CC7.service;

import com.example.zy6r_4E_Alexis_Arriola_CC7.controller.dto.PrestamoDTO;
import com.example.zy6r_4E_Alexis_Arriola_CC7.exception.CustomException;
import com.example.zy6r_4E_Alexis_Arriola_CC7.model.Estado;
import com.example.zy6r_4E_Alexis_Arriola_CC7.model.Prestamo;
import com.example.zy6r_4E_Alexis_Arriola_CC7.model.Videojuego;
import com.example.zy6r_4E_Alexis_Arriola_CC7.repository.PrestamoRepository;
import com.example.zy6r_4E_Alexis_Arriola_CC7.repository.VideojuegoRepository;
import jakarta.transaction.Transactional;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Getter
@Setter
@Service
public class PrestamoService {


    private final PrestamoRepository prestamoRepository;
    private final VideojuegoRepository videojuegoRepository;

    public PrestamoService(PrestamoRepository prestamoRepository, VideojuegoRepository videojuegoRepository) {
        this.prestamoRepository = prestamoRepository;
        this.videojuegoRepository = videojuegoRepository;
    }

    @Transactional
    public Prestamo crear(PrestamoDTO dto) {
        Videojuego videojuego = videojuegoRepository.findById(dto.videojuegoId()).orElseThrow(() -> new CustomException("No existe") );

        if(!videojuego.getDisponible()){
            throw new CustomException("no existe este videojuego");
        }

        Prestamo prestamo = new Prestamo();
        prestamo.setNombreSolicitante(dto.nombreSolicitante().trim());
        prestamo.setVideojuego(videojuego);
        prestamo.setEstado(Estado.ACTIVO);
        prestamo.setFechaPrestamo(LocalDateTime.now());
        prestamo.setFechaDevolucion(null);

        videojuego.setDisponible(false);
        videojuegoRepository.save(videojuego);

        return prestamoRepository.save(prestamo);

    }

    @Transactional
    public Prestamo devolver(Long prestamoId) {
        Prestamo prestamo = new Prestamo();

        prestamo.setEstado(Estado.ACTIVO);
        prestamo.setFechaDevolucion(LocalDateTime.now());


        return prestamoRepository.save(prestamo);
    }
}


