package com.company;

import com.company.model.Carne;

import java.util.Comparator;

public class OrdenarCarnePorNombrePrecioYMaduracionV2 implements Comparator<Carne> {

    @Override
    public int compare(Carne o1, Carne o2) {
        return Comparator.comparing(Carne::getNombre)
                .thenComparing(Carne::getPrecio)
                .thenComparing(Carne::getMaduracion)
                .compare(o1, o2);
    }

}
