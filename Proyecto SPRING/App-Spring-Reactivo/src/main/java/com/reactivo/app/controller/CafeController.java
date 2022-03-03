package com.reactivo.app.controller;

//TODO: Agregar logica para soportar casos de uso

import com.reactivo.app.data.CafeRepository;
import com.reactivo.app.modelos.Cafe;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/cafe")
@AllArgsConstructor
public class CafeController {

    private final CafeRepository cafeRepository;

    //Usaremos
    @GetMapping("/{id}")
    public Mono<Cafe> getCafeById(@PathVariable String id){
        return cafeRepository.findCafeById(id);
    }



}
