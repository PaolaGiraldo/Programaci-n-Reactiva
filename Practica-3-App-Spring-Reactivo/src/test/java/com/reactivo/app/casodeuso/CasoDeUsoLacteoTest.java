package com.reactivo.app.casodeuso;


import org.junit.jupiter.api.Test;
import com.reactivo.app.data.LacteoRespository;
import com.reactivo.app.modelos.Lacteo;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
@AllArgsConstructor
class CasoDeUsoLacteoTest {


    private CasoDeUsoLacteo casoDeUsoLacteo;

    @MockBean
    private LacteoRespository repository;

    @BeforeEach
    void beforeEach() {
        repository = Mockito.mock(LacteoRespository.class);
        casoDeUsoLacteo = new CasoDeUsoLacteo(repository);
    }


    @Test
    public void givenLacteo_whenGetLacteo_thenReturnMonoLacteo() {
        Mockito.when(casoDeUsoLacteo.getLacteoById(any())).thenReturn(Mono.just(new Lacteo()));

    }


    @Test
    public void givenLacteos_whenGetLacteos_thenReturnFluxLacteos(){
        Mockito.when(casoDeUsoLacteo.getLacteos()).thenReturn(Flux.just(new Lacteo()));

    }



    @Test
    public void givenLacteo_whenCreateLacteo_thenReturnMonoLacteo() {
        Mockito.when(casoDeUsoLacteo.newLacteo(any())).thenReturn(Mono.just(new Lacteo()));

    }

    @Test
    public void givenLacteo_whenDeleteLacteo_thenReturnMonoLacteo() {
        Mockito.when(casoDeUsoLacteo.deleteLacteoById(any())).thenReturn(Mono.just(new Lacteo()));

    }



}