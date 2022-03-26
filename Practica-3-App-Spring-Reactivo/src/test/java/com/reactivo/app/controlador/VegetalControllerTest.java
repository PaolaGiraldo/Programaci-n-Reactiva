package com.reactivo.app.controlador;

import com.reactivo.app.casodeuso.CasoDeUsoLacteo;
import com.reactivo.app.casodeuso.CasoDeUsoVegetal;
import com.reactivo.app.modelos.Lacteo;
import com.reactivo.app.modelos.Vegetal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@ExtendWith(SpringExtension.class)
@WebFluxTest(controllers = VegetalController.class)
public class VegetalControllerTest {

    String serialVegetalPrueba;
    Vegetal VegetalPrueba;

    @MockBean
    CasoDeUsoVegetal casoDeUsoVegetal;

    @Autowired
    private WebTestClient webTestClient;

    @BeforeEach
    void beforeEach(){
        serialVegetalPrueba = "LC003";
        VegetalPrueba = new Vegetal(serialVegetalPrueba,"Brocoli",2000,1000,"Bolsa","Arcilloso",2000);

    }


    @Test
    void getVegetalById() {


       Mockito.when(casoDeUsoVegetal.getVegetalById(serialVegetalPrueba)).thenReturn(Mono.just(VegetalPrueba));

        webTestClient.get()
                .uri("/vegetales/"+ serialVegetalPrueba)
                .header(HttpHeaders.ACCEPT, "application/json")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Vegetal.class);

        Mockito.verify(casoDeUsoVegetal, Mockito.times(1)).getVegetalById(serialVegetalPrueba);

    }

    @Test
    void getVegetales() {

        Mockito.when(casoDeUsoVegetal.getVegetales()).thenReturn(Flux.just(new Vegetal()));

        webTestClient.get()
                .uri("/vegetales")
                .header(HttpHeaders.ACCEPT, "application/json")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Vegetal.class);

        Mockito.verify(casoDeUsoVegetal, Mockito.times(1)).getVegetales();

    }

    @Test
    void createVegetal() {

        Mockito.when(casoDeUsoVegetal.newVegetal(VegetalPrueba)).thenReturn(Mono.just(VegetalPrueba));

        webTestClient.post()
                .uri("/vegetales/crear")
                .body(Mono.just(VegetalPrueba), Lacteo.class)
                .header(HttpHeaders.ACCEPT, "application/json")
                .exchange()
                .expectStatus().isCreated()
                .expectBodyList(Vegetal.class);


        Mockito.verify(casoDeUsoVegetal, Mockito.times(1)).newVegetal(VegetalPrueba);

    }

    @Test
    void deleteVegetalById() {

        Mockito.when(casoDeUsoVegetal.deleteVegetalById(serialVegetalPrueba)).thenReturn(Mono.just(VegetalPrueba));

        webTestClient.delete()
                .uri("/vegetales/eliminar/"+ serialVegetalPrueba)
                .header(HttpHeaders.ACCEPT, "application/json")
                .exchange()
                .expectStatus().isNotFound()
                .expectBodyList(Vegetal.class);


        Mockito.verify(casoDeUsoVegetal, Mockito.times(1)).deleteVegetalById(serialVegetalPrueba);

    }

    @Test
    void updateVegetal() {

        Mockito.when(casoDeUsoVegetal.newVegetal(VegetalPrueba)).thenReturn(Mono.just(VegetalPrueba));

        webTestClient.put()
                .uri("/vegetales/actualizar/"+ serialVegetalPrueba)
                .body(Mono.just(VegetalPrueba), Lacteo.class)
                .header(HttpHeaders.ACCEPT, "application/json")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Vegetal.class);


        Mockito.verify(casoDeUsoVegetal, Mockito.times(1)).newVegetal(VegetalPrueba);

    }



}



