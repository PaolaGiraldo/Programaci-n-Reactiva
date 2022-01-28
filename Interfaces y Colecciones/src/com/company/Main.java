package com.company;

import com.company.modelos.carnes.Carnes;
import com.company.modelos.carnes.Cerdo;
import com.company.modelos.carnes.Pescado;
import com.company.modelos.carnes.Pollo;
import com.company.modelos.lacteos.Kumis;
import com.company.modelos.lacteos.Lacteos;
import com.company.modelos.lacteos.Leche;
import com.company.modelos.lacteos.Yogur;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Map<String,Carnes> mapCarnes = new HashMap<>();

        Cerdo canion = new Cerdo("cañon");
        Cerdo tocino = new Cerdo("tocino");
        Pollo muslo = new Pollo("muslo");
        Pescado atun = new Pescado("atun");

        mapCarnes.put(canion.getId(),canion);
        mapCarnes.put(tocino.getId(),tocino);
        mapCarnes.put(muslo.getId(),muslo);
        mapCarnes.put(atun.getId(), atun);

        System.out.println(mapCarnes.toString());

        ArrayList<Lacteos> listaLacteos = new ArrayList<>();

        Leche leche = new Leche(1);
        Yogur yogur = new Yogur(2);
        Kumis kumis = new Kumis(3);

        listaLacteos.add(leche);
        listaLacteos.add(yogur);
        listaLacteos.add(kumis);


        System.out.println(listaLacteos);




    }
}
