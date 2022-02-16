package com.company;

import com.company.model.Carne;
import com.company.model.Lacteo;

import java.util.Comparator;

public class OrdenarLacteosPorTipoYPrecio implements Comparator<Lacteo> {

    @Override
    public int compare(Lacteo o1, Lacteo o2) {
        return Comparator.comparing(Lacteo::getTipo)
                .thenComparing(Lacteo::getPrecio).reversed()
                .compare(o1, o2);
    }

}
