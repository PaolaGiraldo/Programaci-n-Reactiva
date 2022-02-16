package com.company.model;

public class Carne {

    private String nombre;
    private int precio;
    private int maduracion;
    private int pesoEnGramos;

    public Carne(String nombre, int precio, int maduracion, int pesoEnGramos) {
        this.nombre = nombre;
        this.precio = precio;
        this.maduracion = maduracion;
        this.pesoEnGramos = pesoEnGramos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getMaduracion() {
        return maduracion;
    }

    public void setMaduracion(int maduracion) {
        this.maduracion = maduracion;
    }

    public int getPesoEnGramos() {
        return pesoEnGramos;
    }

    public void setPesoEnGramos(int pesoEnGramos) {
        this.pesoEnGramos = pesoEnGramos;
    }

    @Override
    public String toString() {
        return "Carne{" +
                "nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", maduracion='" + maduracion + '\'' +
                ", pesoEnGramos=" + pesoEnGramos +
                '}';
    }
}
