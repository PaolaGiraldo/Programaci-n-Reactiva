package com.reactivo.app.modelos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Tienda {

    String id;
    List<Lacteo> lacteos;
    List<Vegetal> vegetales;
    List<Carne> carnes;
    Integer montoAcumulado;
    String nombreCajero;

}
