package com.bancolombia;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Main {

    public static void main(String[] args) {


        ArrayList<Empleado> empleados = new ArrayList<>();

        empleados.add(new Empleado(101,"Mario", "Analista"));
        empleados.add(new Empleado(28,"Pedro", "Gerente"));
        empleados.add(new Empleado(3,"Juanita", "Ingeniero"));
        empleados.add(new Empleado(46,"Luis", "Analista"));
        empleados.add(new Empleado(500,"Paola", "Ingeniera"));

        CodigoPrimo<Empleado> cp = new CodigoPrimo<>();

        //empleados.stream().filter(cp).forEach(System.out::println);

        Consumer<List<Empleado>> consumer = list -> list.stream()
                .forEach(a -> System.out.println(a.getCodigoInterno()));

        List<Empleado> empleados1 = new ArrayList<>();

        empleados1.add(new Empleado(101,"Mario", "Analista"));
        empleados1.add(new Empleado(28,"Pedro", "Gerente"));
        empleados1.add(new Empleado(3,"Juanita", "Ingeniero"));
        empleados1.add(new Empleado(46,"Luis", "Analista"));
        empleados1.add(new Empleado(500,"Paola", "Ingeniera"));

        consumer.accept(empleados1);

        System.out.println("*********");

        Consumer<List<Empleado>> consumerx2 = list -> list.stream()
                .forEach(a -> System.out.println(a.getCodigoInterno() * 2));


        consumerx2.accept(empleados1);


    }
}
