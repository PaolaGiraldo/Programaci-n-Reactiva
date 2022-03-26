package com.reactivo.app.controlador;

import com.reactivo.app.casodeuso.CasoDeUsoLacteo;
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
@WebFluxTest(controllers = LacteoController.class)
public class LacteoControllerTest {

    String serialLacteoPrueba;
    Lacteo lacteoPrueba;

    @MockBean
    CasoDeUsoLacteo casoDeUsoLacteo;

    @Autowired
    private WebTestClient webTestClient;

    @BeforeEach
    void beforeEach(){
        serialLacteoPrueba = "LC003";
        lacteoPrueba = new Lacteo(serialLacteoPrueba,"Leche",2000,"Bolsa",4000);

    }


    @Test
    void getLacteoById() {


       Mockito.when(casoDeUsoLacteo.getLacteoById(serialLacteoPrueba)).thenReturn(Mono.just(lacteoPrueba));

        webTestClient.get()
                .uri("/lacteos/"+serialLacteoPrueba)
                .header(HttpHeaders.ACCEPT, "application/json")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Lacteo.class);

        Mockito.verify(casoDeUsoLacteo, Mockito.times(1)).getLacteoById(serialLacteoPrueba);

    }

    @Test
    void getLacteos() {

        Mockito.when(casoDeUsoLacteo.getLacteos()).thenReturn(Flux.just(new Lacteo()));

        webTestClient.get()
                .uri("/lacteos")
                .header(HttpHeaders.ACCEPT, "application/json")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Lacteo.class);

        Mockito.verify(casoDeUsoLacteo, Mockito.times(1)).getLacteos();

    }

    @Test
    void createLacteo() {

        Mockito.when(casoDeUsoLacteo.newLacteo(lacteoPrueba)).thenReturn(Mono.just(lacteoPrueba));

        webTestClient.post()
                .uri("/lacteos/crear")
                .body(Mono.just(lacteoPrueba), Lacteo.class)
                .header(HttpHeaders.ACCEPT, "application/json")
                .exchange()
                .expectStatus().isCreated()
                .expectBodyList(Lacteo.class);


        Mockito.verify(casoDeUsoLacteo, Mockito.times(1)).newLacteo(lacteoPrueba);

    }

    @Test
    void deleteLacteoById() {

        Mockito.when(casoDeUsoLacteo.deleteLacteoById(serialLacteoPrueba)).thenReturn(Mono.just(lacteoPrueba));

        webTestClient.delete()
                .uri("/lacteos/eliminar/"+serialLacteoPrueba)
                .header(HttpHeaders.ACCEPT, "application/json")
                .exchange()
                .expectStatus().isNotFound()
                .expectBodyList(Lacteo.class);


        Mockito.verify(casoDeUsoLacteo, Mockito.times(1)).deleteLacteoById(serialLacteoPrueba);

    }

    @Test
    void updateLacteo() {

        Mockito.when(casoDeUsoLacteo.newLacteo(lacteoPrueba)).thenReturn(Mono.just(lacteoPrueba));

        webTestClient.put()
                .uri("/lacteos/actualizar/"+serialLacteoPrueba)
                .body(Mono.just(lacteoPrueba), Lacteo.class)
                .header(HttpHeaders.ACCEPT, "application/json")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Lacteo.class);


        Mockito.verify(casoDeUsoLacteo, Mockito.times(1)).newLacteo(lacteoPrueba);

    }



}



