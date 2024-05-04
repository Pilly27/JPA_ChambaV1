package com.upc.jpa_chambav1.dtos;

import com.upc.jpa_chambav1.entities.Cliente;
import com.upc.jpa_chambav1.entities.Trabajador;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class SolicitudDTO {
    private Long id;
    private String nombre;
    private String descripcion;
    private Boolean estado;
    private String ubicacion;
    private Trabajador trabajador;
    private Cliente cliente;
}
