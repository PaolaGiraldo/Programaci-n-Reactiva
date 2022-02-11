package com.bancolombia;

import java.util.function.Predicate;

public class CodigoPrimo<E> implements Predicate<Empleado> {


    @Override
    public boolean test(Empleado empleado) {

        for (int i = 2; i <= empleado.getCodigoInterno(); i++){
            if(empleado.getCodigoInterno() % 2 == 0){
                return false;
            }

        }


        return true;
    }
}
