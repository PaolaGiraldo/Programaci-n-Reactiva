package com.company;

import com.company.model.Carne;
import com.company.model.Lacteo;
import com.company.model.Vegetal;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {

        List<Carne> carnes = leerArchivoCarnes();
        System.out.println("Listado de carnes ordenado por: peso descendente y precio ascendente \n");

        carnes.sort(new OdernarCarnePorPesoYPrecio());
        for (Carne carne : carnes){
            System.out.println(carne);
        }
        System.out.println("______________________________________________");





    }

    private static void imprimir() {
        ArrayList<Carne> carnes = new ArrayList<>();

        System.out.println("Listado de carnes ordenado por: peso descendente y precio ascendente \n");

        carnes.sort(new OdernarCarnePorPesoYPrecio());
        for (Carne carne : carnes){
            System.out.println(carne);
        }
        System.out.println("______________________________________________");


        System.out.println("Listado de carnes ordenado por: nombre descendente, precio descendente y maduracion descendente \n");

        carnes.sort(new OrdenarCarnePorNombrePrecioYMaduracion());
        for (Carne carne : carnes){
            System.out.println(carne);
        }
        System.out.println("______________________________________________");

        ArrayList<Lacteo> lacteos = new ArrayList<>();


        System.out.println("Listado de lacteos por: tipo descendente y precio descendente");

        lacteos.sort(new OrdenarLacteosPorTipoYPrecio());
        for (Lacteo lacteo : lacteos){
            System.out.println(lacteo);
        }
        System.out.println("______________________________________________");


        ArrayList<Vegetal> vegetales = new ArrayList<>();




        System.out.println("Listado de vegetales ordenados por: nombre, peso y precio descendentes\n");

        vegetales.sort(new OdenarVegetalesPorNombrePesoYPrecio());
        for (Vegetal vegetal : vegetales){
            System.out.println(vegetal);
        }
        System.out.println("______________________________________________");

        System.out.println("Listado de vegetales ordenado por: suelo de cultivo ascendente, altura de cultivo descendente y precio descendente\n");

        vegetales.sort(new OrdenarVegetalesPorSueloAlturaYPrecio());
        for (Vegetal vegetal : vegetales){
            System.out.println(vegetal);
        }
    }


    private static List<Carne>  leerArchivoCarnes() throws IOException {
        Path fileName = Path.of("src/com/company/resources/Carnes.txt");
        String actual = Files.readString(fileName);
        Stream<String> lines = Files.lines(fileName);

        List<Carne> carnes = lines.skip(1).map(line -> {
            String[] atr = line.split(",");
            return new Carne(
                    atr[0],
                    Integer.parseInt(atr[1]),
                    Integer.parseInt(atr[2]),
                    Integer.parseInt(atr[3]));
        }).collect(Collectors.toList());
        return carnes;

    }



}
