package com.reactivo.app.data;

import com.reactivo.app.modelos.Lacteo;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface LacteoRespository extends ReactiveMongoRepository<Lacteo,String> {


    Mono<Lacteo> findLacteoBySerial(String serial);
    Flux<Lacteo> findAll();
    Mono<Lacteo> deleteLacteoBySerial(String serial);



}
