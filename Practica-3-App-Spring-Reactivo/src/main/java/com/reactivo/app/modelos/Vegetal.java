package com.reactivo.app.modelos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vegetal {

    private String nombre;
    private int precio;
    private int peso;
    private String presentacion;
    private String sueloDeCultivo;
    private int alturaDeCultivo;

}
