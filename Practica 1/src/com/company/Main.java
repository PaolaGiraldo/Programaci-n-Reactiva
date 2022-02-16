package com.company;

import com.company.model.Carne;
import com.company.model.Lacteo;
import com.company.model.Vegetal;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {

        ArrayList<Carne> carnes = new ArrayList<>();

        carnes.add(new Carne("Res",5000,10,1200));
        carnes.add(new Carne("Res",2000,3,3400));
        carnes.add(new Carne("Cerdo",5300,4,100));
        carnes.add(new Carne("Res",5000,5,2000));
        carnes.add(new Carne("Cerdo",5400,5,3000));
        carnes.add(new Carne("Res",4000,7,5600));
        carnes.add(new Carne("Res",3000,8,8000));
        carnes.add(new Carne("Pollo",2800,12,5000));
        carnes.add(new Carne("Cerdo",8000,4,500));
        carnes.add(new Carne("Res",5000,3,1000));
        carnes.add(new Carne("Pollo",4500,6,3000));
        carnes.add(new Carne("Res",900,9,4000));
        carnes.add(new Carne("Pollo",6000,8,3500));
        carnes.add(new Carne("Cerdo",5700,3,2200));
        carnes.add(new Carne("Pollo",7500,1,4300));



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

        lacteos.add(new Lacteo("Leche",2000,"Bolsa",4000));
        lacteos.add(new Lacteo("Yogurt",3000,"Bolsa",3000));
        lacteos.add(new Lacteo("Leche",2000,"Vaso",5000));
        lacteos.add(new Lacteo("Kumis",3000,"Bolsa",3200));
        lacteos.add(new Lacteo("Kumis",2300,"Vaso",3500));
        lacteos.add(new Lacteo("Queso",2500,"Bolsa",6000));
        lacteos.add(new Lacteo("Leche",4000,"Bolsa",4500));
        lacteos.add(new Lacteo("Yogurt",2000,"Bolsa",3200));
        lacteos.add(new Lacteo("Kumis",4000,"Vaso",5600));
        lacteos.add(new Lacteo("Leche",7000,"Vaso",400));
        lacteos.add(new Lacteo("Queso",2000,"Barra",3000));
        lacteos.add(new Lacteo("Yogurt",8000,"Bolsa",5300));
        lacteos.add(new Lacteo("Leche",2000,"Bolsa",600));
        lacteos.add(new Lacteo("Yogurt",3000,"Bolsa",5300));
        lacteos.add(new Lacteo("Kumis",4500,"Bolsa",4000));


        System.out.println("Listado de lacteos por: tipo descendente y precio descendente");

        lacteos.sort(new OrdenarLacteosPorTipoYPrecio());
        for (Lacteo lacteo : lacteos){
            System.out.println(lacteo);
        }
        System.out.println("______________________________________________");


        ArrayList<Vegetal> vegetales = new ArrayList<>();

        vegetales.add(new Vegetal("Brocoli",2000,1000,"Bolsa","Arcilloso",2000));
        vegetales.add(new Vegetal("Coliflor",4000,1200,"Bolsa","Arcilloso",2000));
        vegetales.add(new Vegetal("Brocoli",500,300,"Bolsa","Limoso",3000));
        vegetales.add(new Vegetal("Cebolla",5000,1000,"Bolsa","Calizo",1900));
        vegetales.add(new Vegetal("Zanahoria",3000,2000,"Bolsa","Arcilloso",2100));
        vegetales.add(new Vegetal("Espinaca",4000,3000,"Bolsa","Arenoso",2500));
        vegetales.add(new Vegetal("Brocoli",700,1000,"Bolsa","Limoso",2800));
        vegetales.add(new Vegetal("Espinaca",3600,1000,"Bolsa","Calizo",3100));
        vegetales.add(new Vegetal("Brocoli",4000,4000,"Bolsa","Arcilloso",1500));
        vegetales.add(new Vegetal("Coliflor",8000,5800,"Bolsa","Calizo",2900));
        vegetales.add(new Vegetal("Brocoli",3200,5000,"Bolsa","Arcilloso",1100));
        vegetales.add(new Vegetal("Brocoli",4000,1000,"Bolsa","Calizo",2300));
        vegetales.add(new Vegetal("Cebolla",3000,300,"Bolsa","Limoso",2000));
        vegetales.add(new Vegetal("Brocoli",2500,8600,"Bolsa","Arenoso",2000));
        vegetales.add(new Vegetal("Zanahoria",4000,1000,"Bolsa","Calizo",2000));




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
}
