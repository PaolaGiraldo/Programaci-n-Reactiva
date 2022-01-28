package com.company.modelos.lacteos;

public class Leche implements Lacteos{

    protected Integer id;

    public Leche(Integer id) {
        this.id = id;
    }




    @Override
    public void preparar() {
        System.out.println("Preparar leche " + id );
    }

    @Override
    public void almacenar() {
        System.out.println("Almacenar leche " + id );

    }

    @Override
    public void empacar() {
        System.out.println("Empacar leche " + id );

    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
