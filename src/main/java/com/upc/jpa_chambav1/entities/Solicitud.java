package com.upc.jpa_chambav1.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Solicitud {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String descripcion;
    private Boolean estado;
    private String ubicacion;
    @ManyToOne
    @JoinColumn(name = "trabajador_id")
    private Trabajador trabajador;
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
}
