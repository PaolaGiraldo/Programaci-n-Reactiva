package com.company;

import com.company.model.Vegetal;

import java.util.Comparator;

public class OrdenarVegetalesPorSueloAlturaYPrecioV2 implements Comparator<Vegetal> {

    @Override
    public int compare(Vegetal o1, Vegetal o2) {
        return Comparator.comparing(Vegetal::getSueloDeCultivo,Comparator.reverseOrder())
                .thenComparing(Vegetal::getAlturaDeCultivo,Comparator.reverseOrder())
                .thenComparing(Vegetal::getPrecio)
                .compare(o1, o2);
    }

}
