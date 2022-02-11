package com.company.model;

public class Lacteo {

    private String tipo;
    private int peso;
    private String presentacion;
    private int precio;

    public Lacteo(String tipo, int peso, String presentacion, int precio) {
        this.tipo = tipo;
        this.peso = peso;
        this.presentacion = presentacion;
        this.precio = precio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Lacteo{" +
                "tipo='" + tipo + '\'' +
                ", peso=" + peso +
                ", presentacion='" + presentacion + '\'' +
                ", precio=" + precio +
                '}';
    }

}
