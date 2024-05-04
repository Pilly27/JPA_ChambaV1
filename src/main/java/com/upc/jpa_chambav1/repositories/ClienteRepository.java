package com.upc.jpa_chambav1.repositories;

import com.upc.jpa_chambav1.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    @Query("SELECT c FROM Cliente c WHERE c.email like %:prefix%")
    public List<Cliente> obtenerReportePorEmail(@Param("prefix") String prefix);

}
