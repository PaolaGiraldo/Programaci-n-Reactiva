package com.reactivo.app.casodeuso;

import com.reactivo.app.data.LacteoRespository;
import com.reactivo.app.modelos.Lacteo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class CasoDeUsoLacteo {

    private LacteoRespository lacteoRespository;

    public Mono<Lacteo> getLacteoById(@PathVariable String id){

        Lacteo lacteoPrueba = new Lacteo("LC-01","Leche",500,"Bolsa",5000);
        Lacteo lacteoPrueba2 = new Lacteo("LC-02","Leche",500,"Bolsa",5000);

        return Mono.just(lacteoPrueba);

    }


    public Flux<Lacteo> getLacteos(){
        Lacteo lacteoPrueba = new Lacteo("LC-01","Leche",500,"Bolsa",5000);
        Lacteo lacteoPrueba2 = new Lacteo("LC-02","Leche",500,"Bolsa",5000);
        Mono<Lacteo> lacteo1 = Mono.just(lacteoPrueba);
        Mono<Lacteo> lacteo2 = Mono.just(lacteoPrueba2);

        return Flux.merge(lacteo1,lacteo2);
    }



}
