package com.reactivo.app.controlador;


import com.reactivo.app.casodeuso.CasoDeUsoCarne;
import com.reactivo.app.modelos.Carne;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/carnes")
@AllArgsConstructor
@NoArgsConstructor

public class CarneController {

    @Autowired
    CasoDeUsoCarne casoDeUsoCarne;

    @GetMapping("/{id}")
    public Mono<Carne> getCarneBySerial(@PathVariable String id){
        return casoDeUsoCarne.getCarneById(id);
    }

    @GetMapping("")
    public Flux<Carne> getCarnes(){
        return casoDeUsoCarne.getCarnes();
    }

    @PostMapping("/crear")
    public ResponseEntity<Carne> createCarne(@RequestBody Carne carne){
        Mono<Carne> newCarne = casoDeUsoCarne.newCarne(carne);
        return new ResponseEntity(newCarne, HttpStatus.CREATED);
    }


    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Carne> deleteCarneById(@PathVariable String id){
        return new ResponseEntity(casoDeUsoCarne.deleteCarneById(id), HttpStatus.NOT_FOUND);
    }

    @PutMapping("/actualizar/{id}")
    public Mono<Carne> updateLacteo(@RequestBody Carne newCarne, @PathVariable String id){
        return casoDeUsoCarne.newCarne(newCarne);
    }



}
