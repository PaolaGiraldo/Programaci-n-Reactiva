package com.company;

import com.company.model.Vegetal;

import java.util.Comparator;

public class OdenarVegetalesPorNombrePesoYPrecioV2 implements Comparator<Vegetal> {

    @Override
    public int compare(Vegetal o1, Vegetal o2) {
        return Comparator.comparing(Vegetal::getNombre)
                .thenComparing(Vegetal::getPeso).reversed()
                .thenComparing(Vegetal::getPrecio)
                .compare(o1, o2);
    }

}
