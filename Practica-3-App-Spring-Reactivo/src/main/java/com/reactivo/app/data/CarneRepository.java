package com.reactivo.app.data;

import com.reactivo.app.modelos.Carne;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface CarneRepository extends ReactiveMongoRepository<Carne,String> {


    Mono<Carne> findCarneBySerial(String serial);
    Flux<Carne> findAll();
    Mono<Carne> deleteCarneBySerial(String serial);

}
