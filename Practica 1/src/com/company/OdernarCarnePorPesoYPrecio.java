package com.company;

import com.company.model.Carne;

import java.util.Comparator;

public class OdernarCarnePorPesoYPrecio implements Comparator<Carne> {

    @Override
    public int compare(Carne o1, Carne o2) {
        return Comparator.comparing(Carne::getPesoEnGramos).reversed()
                .thenComparing(Carne::getPrecio)
                .compare(o1, o2);
    }



}
