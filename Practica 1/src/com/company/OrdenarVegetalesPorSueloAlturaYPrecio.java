package com.company;

import com.company.model.Lacteo;
import com.company.model.Vegetal;

import java.util.Comparator;

public class OrdenarVegetalesPorSueloAlturaYPrecio implements Comparator<Vegetal> {

    @Override
    public int compare(Vegetal o1, Vegetal o2) {
        return Comparator.comparing(Vegetal::getSueloDeCultivo)
                .thenComparing(Vegetal::getAlturaDeCultivo,Comparator.reverseOrder())
                .thenComparing(Vegetal::getPrecio,Comparator.reverseOrder())
                .compare(o1, o2);
    }

}
