package com.example.zy6r_4E_Alexis_Arriola_CC7.repository;

import com.example.zy6r_4E_Alexis_Arriola_CC7.model.Estado;
import com.example.zy6r_4E_Alexis_Arriola_CC7.model.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrestamoRepository extends JpaRepository<Prestamo, Long> {
    List<Prestamo> findByVideojuegoIdAndEstado(Long videojuegoId, Estado estado);
    List<Prestamo> findByEstado(Estado estado);
}
