package com.reactivo.app.controlador;

import com.reactivo.app.casodeuso.CasoDeUsoCarne;
import com.reactivo.app.modelos.Carne;
import com.reactivo.app.modelos.Lacteo;
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
@WebFluxTest(controllers = CarneController.class)
public class CarneControllerTest {

    String serialCarnePrueba;
    Carne carnePrueba;

    @MockBean
    CasoDeUsoCarne casoDeUsoCarne;

    @Autowired
    private WebTestClient webTestClient;

    @BeforeEach
    void beforeEach(){
        serialCarnePrueba = "CR003";
        carnePrueba = new Carne(serialCarnePrueba,"Res",5000,10,1200);

    }


    @Test
    void getCarneById() {


       Mockito.when(casoDeUsoCarne.getCarneById(serialCarnePrueba)).thenReturn(Mono.just(carnePrueba));

        webTestClient.get()
                .uri("/carnes/"+ serialCarnePrueba)
                .header(HttpHeaders.ACCEPT, "application/json")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Carne.class);

        Mockito.verify(casoDeUsoCarne, Mockito.times(1)).getCarneById(serialCarnePrueba);

    }

    @Test
    void getCarnes() {

        Mockito.when(casoDeUsoCarne.getCarnes()).thenReturn(Flux.just(new Carne()));

        webTestClient.get()
                .uri("/carnes")
                .header(HttpHeaders.ACCEPT, "application/json")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Carne.class);

        Mockito.verify(casoDeUsoCarne, Mockito.times(1)).getCarnes();

    }

    @Test
    void createCarne() {

        Mockito.when(casoDeUsoCarne.newCarne(carnePrueba)).thenReturn(Mono.just(carnePrueba));

        webTestClient.post()
                .uri("/carnes/crear")
                .body(Mono.just(carnePrueba), Carne.class)
                .header(HttpHeaders.ACCEPT, "application/json")
                .exchange()
                .expectStatus().isCreated()
                .expectBodyList(Carne.class);


        Mockito.verify(casoDeUsoCarne, Mockito.times(1)).newCarne(carnePrueba);

    }

    @Test
    void deleteLacteoById() {

        Mockito.when(casoDeUsoCarne.deleteCarneById(serialCarnePrueba)).thenReturn(Mono.just(carnePrueba));

        webTestClient.delete()
                .uri("/carnes/eliminar/"+ serialCarnePrueba)
                .header(HttpHeaders.ACCEPT, "application/json")
                .exchange()
                .expectStatus().isNotFound()
                .expectBodyList(Carne.class);


        Mockito.verify(casoDeUsoCarne, Mockito.times(1)).deleteCarneById(serialCarnePrueba);

    }

    @Test
    void updateLacteo() {

        Mockito.when(casoDeUsoCarne.newCarne(carnePrueba)).thenReturn(Mono.just(carnePrueba));

        webTestClient.put()
                .uri("/carnes/actualizar/"+ serialCarnePrueba)
                .body(Mono.just(carnePrueba), Lacteo.class)
                .header(HttpHeaders.ACCEPT, "application/json")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Carne.class);


        Mockito.verify(casoDeUsoCarne, Mockito.times(1)).newCarne(carnePrueba);

    }



}



