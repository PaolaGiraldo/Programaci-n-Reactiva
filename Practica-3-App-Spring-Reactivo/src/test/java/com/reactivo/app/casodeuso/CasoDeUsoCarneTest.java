package com.reactivo.app.casodeuso;


import com.reactivo.app.data.CarneRepository;
import com.reactivo.app.data.LacteoRespository;
import com.reactivo.app.modelos.Carne;
import com.reactivo.app.modelos.Lacteo;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.mockito.ArgumentMatchers.any;

@AutoConfigureMockMvc
@SpringBootTest
@AllArgsConstructor
class CasoDeUsoCarneTest {


    private CasoDeUsoCarne casoDeUsoCarne;

    @MockBean
    private CarneRepository repository;

    @BeforeEach
    void beforeEach() {
        repository = Mockito.mock(CarneRepository.class);
        casoDeUsoCarne = new CasoDeUsoCarne(repository);
    }


    @Test
    public void givenLacteo_whenGetLacteo_thenReturnMonoLacteo() {
        Mockito.when(casoDeUsoCarne.getCarneById(any())).thenReturn(Mono.just(new Carne()));

    }


    @Test
    public void givenLacteos_whenGetLacteos_thenReturnFluxLacteos(){
        Mockito.when(casoDeUsoCarne.getCarnes()).thenReturn(Flux.just(new Carne()));

    }



    @Test
    public void givenLacteo_whenCreateLacteo_thenReturnMonoLacteo() {
        Mockito.when(casoDeUsoCarne.newCarne(any())).thenReturn(Mono.just(new Carne()));

    }

    @Test
    public void givenLacteo_whenDeleteLacteo_thenReturnMonoLacteo() {
        Mockito.when(casoDeUsoCarne.deleteCarneById(any())).thenReturn(Mono.just(new Carne()));

    }



}