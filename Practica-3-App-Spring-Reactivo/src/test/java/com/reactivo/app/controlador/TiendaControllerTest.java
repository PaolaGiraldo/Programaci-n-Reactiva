package com.reactivo.app.controlador;

import com.reactivo.app.casodeuso.CasoDeUsoVegetal;
import com.reactivo.app.casodeuso.CasodeUsoTienda;
import com.reactivo.app.data.LacteoRespository;
import com.reactivo.app.modelos.Carne;
import com.reactivo.app.modelos.Lacteo;
import com.reactivo.app.modelos.Tienda;
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

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(SpringExtension.class)
@WebFluxTest(controllers = TiendaController.class)
public class TiendaControllerTest {

    Integer idTiendaPrueba;
    String serialTiendaPrueba;

    Tienda tiendaPrueba;

    List<Lacteo> listaLacteosPruebasT1 = new ArrayList<>();
    List<Vegetal> listaVegetalesPruebasT1 = new ArrayList<>();
    List<Carne> listaCarnesPruebasT1 = new ArrayList<>();

    List<Tienda> tiendasPrueba = new ArrayList<>();

    @MockBean
    CasodeUsoTienda casoDeUsoTienda;

    @Autowired
    private WebTestClient webTestClient;

    @BeforeEach
    void beforeEach(){


        idTiendaPrueba = 1;
        serialTiendaPrueba = "T1";
        tiendaPrueba = new Tienda(serialTiendaPrueba,listaLacteosPruebasT1,listaVegetalesPruebasT1,listaCarnesPruebasT1,0,"Mario");

        tiendasPrueba.add(tiendaPrueba);

    }

    @Test
    void createTiendas() {

        Mockito.when(casoDeUsoTienda.crearTiendas()).thenReturn(tiendasPrueba);

        webTestClient.post()
                .uri("/tiendas/crear")
                .header(HttpHeaders.ACCEPT, "application/json")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Tienda.class);

        Mockito.verify(casoDeUsoTienda, Mockito.times(1)).crearTiendas();

    }


    @Test
    void getTiendas() {
        Mockito.when(casoDeUsoTienda.getTiendas()).thenReturn(tiendasPrueba);

        webTestClient.get()
                .uri("/tiendas")
                .header(HttpHeaders.ACCEPT, "application/json")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Tienda.class);

        Mockito.verify(casoDeUsoTienda, Mockito.times(1)).getTiendas();

    }






}



