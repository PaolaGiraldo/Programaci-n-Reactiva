package com.reactivo.app.casodeuso;

import com.reactivo.app.data.CarneRepository;
import com.reactivo.app.data.LacteoRespository;
import com.reactivo.app.data.VegetalRepository;
import com.reactivo.app.modelos.Carne;
import com.reactivo.app.modelos.Lacteo;
import com.reactivo.app.modelos.Tienda;
import com.reactivo.app.modelos.Vegetal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Function;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component

//TODO: Agregar objetos que se traen desde base de datos
public class CasodeUsoTienda {

    @Autowired
    LacteoRespository lacteoRespository;

    @Autowired
    CarneRepository carneRepository;

    @Autowired
    VegetalRepository vegetalRepository;

    List<Lacteo> listaLacteosT1 = new ArrayList<>();
    List<Vegetal> listaVegetalesT1 = new ArrayList<>();
    List<Carne> listaCarnesT1 = new ArrayList<>();

    List<Lacteo> listaLacteosT2 = new ArrayList<>();
    List<Vegetal> listaVegetalesT2 = new ArrayList<>();
    List<Carne> listaCarnesT2 = new ArrayList<>();

    List<Lacteo> listaLacteosT3 = new ArrayList<>();
    List<Vegetal> listaVegetalesT3 = new ArrayList<>();
    List<Carne> listaCarnesT3 = new ArrayList<>();

    List<Lacteo> listaLacteosT4 = new ArrayList<>();
    List<Vegetal> listaVegetalesT4 = new ArrayList<>();
    List<Carne> listaCarnesT4 = new ArrayList<>();


    List<Tienda> tiendas = new ArrayList<>();


    public List<Tienda> crearTiendas(){
        if(tiendas.isEmpty()){
        Tienda tienda1 = new Tienda("T1",listaLacteosT1,listaVegetalesT1,listaCarnesT1,0,"Mario");
        Tienda tienda2 = new Tienda("T2",listaLacteosT2,listaVegetalesT2,listaCarnesT2,0,"Cristian");
        Tienda tienda3 = new Tienda("T3",listaLacteosT3,listaVegetalesT3,listaCarnesT3,0,"Mateo");
        Tienda tienda4 = new Tienda("T4",listaLacteosT4,listaVegetalesT4,listaCarnesT4,0,"Marcela");

        tiendas.add(tienda1);
        tiendas.add(tienda2);
        tiendas.add(tienda3);
        tiendas.add(tienda4);}


        return tiendas;
    };

    public Tienda comprarLacteo(Integer idTienda) throws InterruptedException {
        Tienda tienda = tiendas.get(idTienda - 1 );

        lacteoRespository.count()
                .map(count -> Integer.toString( ThreadLocalRandom.current().nextInt(1, count.intValue() + 1)))
                .subscribe(s -> {
                    lacteoRespository.findLacteoBySerial("LC-".concat(s)).subscribe(item -> {
                        tienda.getLacteos().add(item);
                        tienda.setMontoAcumulado(tienda.getMontoAcumulado() + item.getPrecio());
                    });
                });

        Thread.sleep(1000);
        return tienda;
    };


    public Tienda comprarCarne(Integer idTienda) throws InterruptedException {
        Tienda tienda = tiendas.get(idTienda - 1 );

        carneRepository.count()
                .map(count -> Integer.toString( ThreadLocalRandom.current().nextInt(1, count.intValue() + 1)))
                .subscribe(s -> {
                    carneRepository.findCarneBySerial("CR-".concat(s)).subscribe(item -> {
                        tienda.getCarnes().add(item);
                        tienda.setMontoAcumulado(tienda.getMontoAcumulado() + item.getPrecio());
                    });
                });

        Thread.sleep(1000);
        return tienda;
    };

    public Tienda comprarVegetal(Integer idTienda) throws InterruptedException {
        Tienda tienda = tiendas.get(idTienda - 1 );

        vegetalRepository.count()
                .map(count -> Integer.toString( ThreadLocalRandom.current().nextInt(1, count.intValue() + 1)))
                .subscribe(s -> {
                    vegetalRepository.findVegetalBySerial("VG-".concat(s)).subscribe(item -> {
                        tienda.getVegetales().add(item);
                        tienda.setMontoAcumulado(tienda.getMontoAcumulado() + item.getPrecio());
                    });
                });

        Thread.sleep(1000);
        return tienda;
    };

    public Tienda finzalizarCompra(Integer idTienda){
        Tienda tienda = tiendas.get(idTienda - 1 );

        return tienda;
    }

}
