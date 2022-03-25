package com.reactivo.app.controlador;

import com.reactivo.app.casodeuso.CasoDeUsoVegetal;
import com.reactivo.app.modelos.Vegetal;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/vegetales")
@AllArgsConstructor
@NoArgsConstructor

public class VegetalController {

    @Autowired
    CasoDeUsoVegetal casoDeUsoVegetal;

    @GetMapping("/{id}")
    public Mono<Vegetal> getVegetalBySerial(@PathVariable String id){
        return casoDeUsoVegetal.getVegetalById(id);
    }

    @GetMapping("")
    public Flux<Vegetal> getVegetales(){
        return casoDeUsoVegetal.getVegetales();
    }

    @PostMapping("/crear")
    public ResponseEntity<Vegetal> createVegetal(@RequestBody Vegetal vegetal){
        Mono<Vegetal> newVegetal = casoDeUsoVegetal.newVegetal(vegetal);
        return new ResponseEntity(newVegetal, HttpStatus.CREATED);
    }


    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Vegetal> deleteVegetal(@PathVariable String id){
        return new ResponseEntity(casoDeUsoVegetal.deleteVegetalById(id), HttpStatus.NOT_FOUND);
    }

    @PutMapping("/actualizar/{id}")
    public Mono<Vegetal> updateVegetal(@RequestBody Vegetal newVegetal, @PathVariable String id){
        return casoDeUsoVegetal.newVegetal(newVegetal);
    }


}
