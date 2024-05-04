package com.upc.jpa_chambav1.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrabajorOficioDTO {
    private String nombreTranajador;
    private int cantidad;
}
