package com.upc.jpa_chambav1.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class OficioDTO {
    private Long id;
    private String nombre;
    private String descripcion;
}
