package com.bancolombia;

import java.util.Comparator;

public class OrdenarPorCodigo implements Comparator<Empleado> {


    @Override
    public int compare(Empleado empleado1, Empleado empleado2) {
        return (int) empleado1.getCodigoInterno() - empleado2.getCodigoInterno();
    }
}
