package com.upc.jpa_chambav1.dtos;

import com.upc.jpa_chambav1.entities.Solicitud;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class PagoDTO {
    private Long id;
    private String nombre;
    private String descripcion;
    private Float monto;
    private Solicitud solicitud;
}
