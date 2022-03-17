package com.reactivo.app.modelos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Lacteo {

    private String id;
    private String tipo;
    private int peso;
    private String presentacion;
    private int precio;

}
