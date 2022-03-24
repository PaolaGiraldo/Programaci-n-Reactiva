package com.reactivo.app.data;

import com.reactivo.app.modelos.Vegetal;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository

public interface VegetalRepository extends ReactiveMongoRepository<Vegetal,String> {
    Mono<Vegetal> findVegetalBySerial(String serial);
    Flux<Vegetal> findAll();
    Mono<Vegetal> deleteVegetalBySerial(String serial);



}
