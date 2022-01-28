package com.company.modelos.lacteos;

public class Kumis implements Lacteos {

    protected Integer id;

    public Kumis(Integer id) {
        this.id = id;
    }

    @Override
    public void preparar() {
        System.out.println("Preparar Kumis " + id );
    }

    @Override
    public void almacenar() {
        System.out.println("Almacenar Kumis  " + id );

    }

    @Override
    public void empacar() {
        System.out.println("Empacar Kumis " + id );

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
