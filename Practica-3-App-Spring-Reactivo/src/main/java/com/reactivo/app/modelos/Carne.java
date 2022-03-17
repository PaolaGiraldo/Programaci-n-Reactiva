package com.reactivo.app.modelos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Carne {

    private String nombre;
    private int precio;
    private int maduracion;
    private int pesoEnGramos;

}
