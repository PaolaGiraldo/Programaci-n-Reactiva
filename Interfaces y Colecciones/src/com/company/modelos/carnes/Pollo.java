package com.company.modelos.carnes;

public class Pollo implements Carnes {

    protected String id;

    public Pollo(String id) {
        this.id = id;
    }

    @Override
    public void asar() {
        System.out.println("Asar carne de Pollo " + id );
    }

    @Override
    public void hervir() {
        System.out.println("Hervir carne de Pollo " + id );

    }

    @Override
    public void empacar() {
        System.out.println("Empacar carne de Pollo " + id );

    }

    @Override
    public void pesar() {
        System.out.println("Pesar carne de Pollo " + id );

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
