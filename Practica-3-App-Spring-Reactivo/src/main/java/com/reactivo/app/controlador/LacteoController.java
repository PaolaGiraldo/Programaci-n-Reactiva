package com.reactivo.app.controlador;


import com.reactivo.app.casodeuso.CasoDeUsoLacteo;
import com.reactivo.app.data.LacteoRespository;
import com.reactivo.app.modelos.Lacteo;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


//TODO: Agregar logica para soportar casos de uso y usar bases de datos
@RestController
@RequestMapping("/lacteo")
@AllArgsConstructor

public class LacteoController {


    private final CasoDeUsoLacteo casoDeUsoLacteo;

    @GetMapping("/{id}")
    public Mono<Lacteo> getLacteoById(@PathVariable String id){
        return casoDeUsoLacteo.getLacteoById(id);
    }

    @GetMapping("/")
    public Flux<Lacteo> getLacteos(){
        return casoDeUsoLacteo.getLacteos();
    }

}
