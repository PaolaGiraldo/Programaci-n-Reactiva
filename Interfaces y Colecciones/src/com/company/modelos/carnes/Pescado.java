package com.company.modelos.carnes;

public class Pescado implements Carnes {

    protected String id;


    public Pescado(String id) {
        this.id = id;
    }



    @Override
    public void asar() {
        System.out.println("Asar carne de Pescado  " + id );
    }

    @Override
    public void hervir() {
        System.out.println("Hervir carne de Pescado " + id );

    }

    @Override
    public void empacar() {
        System.out.println("Empacar carne de Pescado " + id );

    }

    @Override
    public void pesar() {
        System.out.println("Pesar carne de Pescado");

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
