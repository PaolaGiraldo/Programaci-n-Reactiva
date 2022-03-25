package com.reactivo.app.data;

import com.reactivo.app.modelos.Lacteo;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TiendaRepository extends ReactiveMongoRepository<Lacteo,String> {

}
