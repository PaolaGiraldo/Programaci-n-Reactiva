package com.reactivo.app.casodeuso;

import com.reactivo.app.data.CarneRepository;
import com.reactivo.app.modelos.Carne;
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

public class CasoDeUsoCarne{

    @Autowired
    CarneRepository repository;

    public Mono<Carne> getCarneById(String serial){
        return repository.findCarneBySerial(serial);
    }

    public Flux<Carne> getCarnes(){
        return repository.findAll();
    }

    public Mono<Carne> newCarne(Carne carne){
        return repository.save(carne);
    }

    public Mono<Carne> deleteCarneById(String id){
        return repository.deleteCarneBySerial(id);
    }






}
