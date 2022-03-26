package com.reactivo.app.controlador;

import com.reactivo.app.casodeuso.CasoDeUsoLacteo;
import com.reactivo.app.casodeuso.CasodeUsoTienda;
import com.reactivo.app.modelos.Carne;
import com.reactivo.app.modelos.Lacteo;
import com.reactivo.app.modelos.Tienda;
import com.reactivo.app.modelos.Vegetal;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.StreamingHttpOutputMessage;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/tiendas")
@AllArgsConstructor
@NoArgsConstructor

public class TiendaController {

    @Autowired
    CasodeUsoTienda casodeUsoTienda;

    @GetMapping("")
    public List<Tienda> consultarTiendas(){
        return casodeUsoTienda.getTiendas();
    }

    @GetMapping("/{idTienda}")
    public Tienda consultarTiendaPorId(@PathVariable Integer idTienda){
        return casodeUsoTienda.getTiendas().get(idTienda -1);
    }

    @PostMapping("/crear")
        public List<Tienda> crearTiendas(){
            return casodeUsoTienda.crearTiendas();
    }

    @GetMapping("/{idTienda}/comprar/lacteo")
    public ResponseEntity<Tienda> comprarLacteo(@PathVariable Integer idTienda) throws InterruptedException {
        return new ResponseEntity(casodeUsoTienda.comprarLacteo(idTienda), HttpStatus.OK);
    }

    @GetMapping("/{idTienda}/comprar/carne")
    public ResponseEntity<Tienda> comprarCarne(@PathVariable Integer idTienda) throws InterruptedException {
        return new ResponseEntity(casodeUsoTienda.comprarCarne(idTienda), HttpStatus.OK);
    }

    @GetMapping("/{idTienda}/comprar/vegetal")
    public ResponseEntity<Tienda> comprarVegetal(@PathVariable Integer idTienda) throws InterruptedException {
        return new ResponseEntity(casodeUsoTienda.comprarVegetal(idTienda), HttpStatus.OK);
    }

    @GetMapping("/{idTienda}/finalizarCompra")
    @ResponseBody
    public ResponseEntity<Map<String, String>> finalizarCompra(@PathVariable Integer idTienda) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Costo Total", casodeUsoTienda.finzalizarCompra(idTienda).getMontoAcumulado().toString());
        map.put("Cajero (a)", casodeUsoTienda.finzalizarCompra(idTienda).getNombreCajero());

        return new ResponseEntity(map, HttpStatus.OK);
    }


}
