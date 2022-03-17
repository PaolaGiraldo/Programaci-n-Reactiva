package com.reactivo.app.data;

import com.reactivo.app.modelos.Lacteo;

import reactor.core.publisher.Mono;


//TODO: Crear conexion con base de datos
public interface LacteoRespository extends ReactiveMongoRepository {

    Mono<Lacteo> findLacteoById(String Id);
}
