package com.upc.jpa_chambav1.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrabajadorOficioDTO {
    private String nombreOficio;
    private Long numeroTrabajadores;
}
