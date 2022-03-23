package com.reactivo.app.casodeuso;

import com.reactivo.app.data.LacteoRespository;
import com.reactivo.app.modelos.Lacteo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component

public class CasoDeUsoLacteo{

    @Autowired
    LacteoRespository repository;

    public Mono<Lacteo> getLacteoById(String serial){
        return repository.findLacteoBySerial(serial);
    }

    public Flux<Lacteo> getLacteos(){
        return repository.findAll();
    }

    public Mono<Lacteo> newLacteo(Lacteo lacteo){
        return repository.save(lacteo);
    }

    public Mono<Lacteo> deleteLacteo(String id){
        return repository.deleteLacteoBySerial(id);
    }






}
