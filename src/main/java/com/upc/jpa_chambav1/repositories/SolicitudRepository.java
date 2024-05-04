package com.upc.jpa_chambav1.repositories;

import com.upc.jpa_chambav1.entities.Solicitud;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SolicitudRepository extends JpaRepository<Solicitud, Long> {
    @Query("select s.trabajador.nombre, count(s) from Solicitud s group by s.trabajador.nombre")
    List<Object[]> findTrajadorNumberoSolicitudes();

    @Query("SELECT s FROM Solicitud s WHERE s.estado = true")
    List<Solicitud> findSolicitudesActivadas();

}
