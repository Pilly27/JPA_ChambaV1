package com.upc.jpa_chambav1.repositories;

import com.upc.jpa_chambav1.entities.Pago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PagoRepository extends JpaRepository<Pago, Long> {
    @Query("SELECT p FROM Pago p WHERE p.monto > :monto")
    public List<Pago> obtenerPagosPorMonto(Float monto);




}
