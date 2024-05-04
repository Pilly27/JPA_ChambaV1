package com.upc.jpa_chambav1.dtos;

import com.upc.jpa_chambav1.entities.Oficio;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class TrabajadorDTO {
    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private Oficio oficio;
}
