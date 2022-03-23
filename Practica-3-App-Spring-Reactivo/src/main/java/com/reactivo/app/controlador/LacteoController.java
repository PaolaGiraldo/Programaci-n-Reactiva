package com.reactivo.app.controlador;


import com.reactivo.app.casodeuso.CasoDeUsoLacteo;
import com.reactivo.app.modelos.Lacteo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/lacteos")
@AllArgsConstructor
@NoArgsConstructor

public class LacteoController {

    @Autowired
    CasoDeUsoLacteo casoDeUsoLacteo;

    @GetMapping("/{id}")
    public Mono<Lacteo> getLacteoBySerial(@PathVariable String id){
        return casoDeUsoLacteo.getLacteoById(id);
    }

    @GetMapping("")
    public Flux<Lacteo> getLacteos(){
        return casoDeUsoLacteo.getLacteos();
    }

    @PostMapping("/crear")
    public ResponseEntity<Lacteo> createLacteo(@RequestBody Lacteo lacteo){
        Mono<Lacteo> newLacteo = casoDeUsoLacteo.newLacteo(lacteo);
        return new ResponseEntity(newLacteo, HttpStatus.CREATED);
    }


    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Lacteo> deleteLacteo(@PathVariable String id){
        return new ResponseEntity(casoDeUsoLacteo.deleteLacteo(id), HttpStatus.NOT_FOUND);
    }

    @PutMapping("/actualizar/{id}")
    public Mono<Lacteo> updateLacteo(@RequestBody Lacteo newLacteo, @PathVariable String id){
        return casoDeUsoLacteo.newLacteo(newLacteo);
    }



}
