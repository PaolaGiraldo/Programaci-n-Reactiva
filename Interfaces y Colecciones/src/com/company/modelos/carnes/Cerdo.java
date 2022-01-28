package com.company.modelos.carnes;

public class Cerdo implements Carnes{

    protected String id;

    public Cerdo(String id) {
        this.id = id;
    }

    @Override
    public void asar() {
        System.out.println("Asar carne de Cerdo " + id );
    }

    @Override
    public void hervir() {
        System.out.println("Hervir carne de Cerdo " + id );

    }

    @Override
    public void empacar() {
        System.out.println("Empacar carne de Cerdo " + id);

    }

    @Override
    public void pesar() {
        System.out.println("Pesar carne de Cerdo " + id );

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
