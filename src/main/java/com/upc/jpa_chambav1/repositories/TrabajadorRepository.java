package com.upc.jpa_chambav1.repositories;

import com.upc.jpa_chambav1.entities.Trabajador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TrabajadorRepository extends JpaRepository<Trabajador, Long> {
    @Query("SELECT t FROM Trabajador t WHERE t.nombre like %:prefix%")
    public List<Trabajador> obtenerReportePorNombre(@Param("prefix") String prefix);

    @Query("SELECT t.oficio.nombre, COUNT(t) FROM Trabajador t GROUP BY t.oficio.nombre")
    List<Object[]> findNumeroTrabajadoresPorOficio();
}
