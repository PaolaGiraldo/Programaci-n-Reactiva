package com.company.modelos.lacteos;

public class Yogur implements Lacteos {

    protected Integer id;

    public Yogur(Integer id) {
        this.id = id;
    }


    @Override
    public void preparar() {
        System.out.println("Preparar yogur " + id );
    }

    @Override
    public void almacenar() {
        System.out.println("Almacenar yogur " + id );

    }

    @Override
    public void empacar() {
        System.out.println("Empacar yogur " + id );

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
