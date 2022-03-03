package com.company;

import com.company.model.Lacteo;

import java.util.Comparator;

public class OrdenarLacteosPorTipoYPrecioV2 implements Comparator<Lacteo> {

    @Override
    public int compare(Lacteo o1, Lacteo o2) {
        return Comparator.comparing(Lacteo::getTipo).reversed()
                .thenComparing(Lacteo::getPrecio)
                .compare(o1, o2);
    }

}
