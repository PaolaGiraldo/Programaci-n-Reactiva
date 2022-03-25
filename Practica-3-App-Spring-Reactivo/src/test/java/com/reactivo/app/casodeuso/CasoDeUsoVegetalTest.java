package com.reactivo.app.casodeuso;



import com.reactivo.app.data.VegetalRepository;
import com.reactivo.app.modelos.Vegetal;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
@AllArgsConstructor
class CasoDeUsoVegetalTest {


    private CasoDeUsoVegetal casoDeUsoVegetal;

    @MockBean
    private VegetalRepository repository;

    @BeforeEach
    void beforeEach() {
        repository = Mockito.mock(VegetalRepository.class);
        casoDeUsoVegetal = new CasoDeUsoVegetal(repository);
    }

    @Test
    public void givenLacteo_whenGetLacteo_thenReturnMonoLacteo() {
        Mockito.when(casoDeUsoVegetal.getVegetalById(any())).thenReturn(Mono.just(new Vegetal()));

    }

    @Test
    public void givenLacteos_whenGetLacteos_thenReturnFluxLacteos(){
        Mockito.when(casoDeUsoVegetal.getVegetales()).thenReturn(Flux.just(new Vegetal()));

    }

    @Test
    public void givenLacteo_whenCreateLacteo_thenReturnMonoLacteo() {
        Mockito.when(casoDeUsoVegetal.newVegetal(any())).thenReturn(Mono.just(new Vegetal()));

    }

    @Test
    public void givenLacteo_whenDeleteLacteo_thenReturnMonoLacteo() {
        Mockito.when(casoDeUsoVegetal.deleteVegetalById(any())).thenReturn(Mono.just(new Vegetal()));

    }



}