package com.company;

import com.company.model.Carne;
import com.company.model.Lacteo;
import com.company.model.Vegetal;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {

        String rutaArchivoCarnes = null;
        String rutaArchivoLacteos = null;
        String rutaArchivoVegetales = null;
        Integer tamanoArchivos = 0;

        Scanner myObj = new Scanner(System.in);
        System.out.println("Usar archivos 1: menos de 200Kb o  1: más de 200Kb");
        String useFiles = myObj.nextLine();

        switch (useFiles){
            case "1":
                rutaArchivoCarnes = "src/com/company/resources/smallfiles/Carnes.txt";
                rutaArchivoLacteos = "src/com/company/resources/smallfiles/Lacteos.txt";
                rutaArchivoVegetales = "src/com/company/resources/smallfiles/Vegetales.txt";
                break;

            case "2":
                rutaArchivoCarnes = "src/com/company/resources/bigfiles/Carnes.txt";
                rutaArchivoLacteos = "src/com/company/resources/bigfiles/Lacteos.txt";
                rutaArchivoVegetales = "src/com/company/resources/bigfiles/Vegetales.txt";
                break;


        }

        tamanoArchivos = Integer.parseInt(Files.getAttribute(Path.of(rutaArchivoCarnes),"size").toString()) +
                Integer.parseInt(Files.getAttribute(Path.of(rutaArchivoLacteos),"size").toString()) +
                Integer.parseInt(Files.getAttribute(Path.of(rutaArchivoVegetales),"size").toString());


        //Tamaño de los archivos
        System.out.println("El tamaño de los archivos es: " + tamanoArchivos);
        List<Carne> carnes = leerArchivoCarnes(rutaArchivoCarnes);
        List<Lacteo> lacteos = leerArchivoLacteos(rutaArchivoLacteos);
        List<Vegetal> vegetales = leerArchivoVegetales(rutaArchivoVegetales);


        if (tamanoArchivos > 200 ){
            System.out.println("Usando funciones V2");
            funcionesV2(carnes,lacteos,vegetales);

        } else {
            System.out.println("Usando funciones V1");
            funcionesV1(carnes,lacteos,vegetales);
        }
    }

    private static void funcionesV1(List<Carne> carnes, List<Lacteo> lacteos,List<Vegetal> vegetales) {

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
        System.out.println("Listado de lacteos por: tipo descendente y precio descendente");

        lacteos.sort(new OrdenarLacteosPorTipoYPrecio());
        for (Lacteo lacteo : lacteos){
            System.out.println(lacteo);
        }
        System.out.println("______________________________________________");
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

    private static void funcionesV2(List<Carne> carnes, List<Lacteo> lacteos,List<Vegetal> vegetales) {

        System.out.println("Listado de carnes ordenado por: peso ascendente y precio ascendente \n");
        carnes.sort(new OdernarCarnePorPesoYPrecioV2());
        for (Carne carne : carnes){
            System.out.println(carne);
        }
        System.out.println("______________________________________________");
        System.out.println("Listado de carnes ordenado por: nombre ascendente, precio ascendente y maduracion ascendente \n");
        carnes.sort(new OrdenarCarnePorNombrePrecioYMaduracionV2());
        for (Carne carne : carnes){
            System.out.println(carne);
        }
        System.out.println("______________________________________________");
        System.out.println("Listado de lacteos por: tipo descendente y precio ascendente");
        lacteos.sort(new OrdenarLacteosPorTipoYPrecioV2());
        for (Lacteo lacteo : lacteos){
            System.out.println(lacteo);
        }
        System.out.println("______________________________________________");
        System.out.println("Listado de vegetales ordenados por: nombre, peso descendentes y precio ascendente\n");
        vegetales.sort(new OdenarVegetalesPorNombrePesoYPrecioV2());
        for (Vegetal vegetal : vegetales){
            System.out.println(vegetal);
        }
        System.out.println("______________________________________________");
        System.out.println("Listado de vegetales ordenado por: suelo de cultivo descendente, altura de cultivo descendente y precio descendentes\n");
        vegetales.sort(new OrdenarVegetalesPorSueloAlturaYPrecioV2());
        for (Vegetal vegetal : vegetales){
            System.out.println(vegetal);
        }
    }

    // Leer archivos
    private static List<Carne>    leerArchivoCarnes(String fileName) throws IOException {
        Path path = Path.of(fileName);
        String actual = Files.readString(path);
        Stream<String> lines = Files.lines(path);

        List<Carne> carnes = lines.map(line -> {
            String[] atr = line.split(",");
            return new Carne(
                    atr[0],
                    Integer.parseInt(atr[1]),
                    Integer.parseInt(atr[2]),
                    Integer.parseInt(atr[3]));
        }).collect(Collectors.toList());
        return carnes;

    }
    private static List<Lacteo>  leerArchivoLacteos(String fileName) throws IOException {
        Path path = Path.of(fileName);
        String actual = Files.readString(path);
        Stream<String> lines = Files.lines(path);

        List<Lacteo> lacteos = lines.map(line -> {
            String[] atr = line.split(",");
            return new Lacteo(
                    atr[0],
                    Integer.parseInt(atr[1]),
                    atr[2],
                    Integer.parseInt(atr[3]));
        }).collect(Collectors.toList());
        return lacteos;

    }
    private static List<Vegetal>  leerArchivoVegetales(String fileName) throws IOException {
        Path path = Path.of(fileName);
        String actual = Files.readString(path);
        Stream<String> lines = Files.lines(path);

        List<Vegetal> vegetales = lines.map(line -> {
            String[] atr = line.split(",");
            return new Vegetal(
                    atr[0],
                    Integer.parseInt(atr[1]),
                    Integer.parseInt(atr[2]),
                    atr[3],
                    atr[4],
                    Integer.parseInt(atr[5]));
        }).collect(Collectors.toList());
        return vegetales;

    }



}
