package com.reactivo.app.casodeuso;

import com.reactivo.app.data.VegetalRepository;
import com.reactivo.app.modelos.Lacteo;
import com.reactivo.app.modelos.Vegetal;
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
public class CasoDeUsoVegetal {

    @Autowired
    VegetalRepository repository;

    public Mono<Vegetal> getVegetalById(String serial){
        return repository.findVegetalBySerial(serial);
    }

    public Flux<Vegetal> getVegetales(){
        return repository.findAll();
    }

    public Mono<Vegetal> newVegetal(Vegetal vegetal){
        return repository.save(vegetal);
    }

    public Mono<Vegetal> deleteVegetalById(String id){
        return repository.deleteVegetalBySerial(id);
    }



}
