package com.bancolombia;

public class Empleado {

    private int codigoInterno;
    private String nombre;



    private String cargo;

    public Empleado(int codigoInterno, String nombre, String cargo) {
        this.codigoInterno = codigoInterno;
        this.nombre = nombre;
        this.cargo = cargo;
    }


    public int getCodigoInterno() {
        return codigoInterno;
    }

    public void setCodigoInterno(int codigoInterno) {
        this.codigoInterno = codigoInterno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "codigoInterno=" + codigoInterno +
                ", nombre='" + nombre + '\'' +
                ", cargo='" + cargo + '\'' +
                '}';
    }

}
