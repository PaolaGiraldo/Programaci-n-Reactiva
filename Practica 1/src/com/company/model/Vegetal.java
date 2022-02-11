package com.company.model;

public class Vegetal {

    private String nombre;
    private int precio;
    private int peso;
    private String presentacion;
    private String sueloDeCultivo;
    private String alturaDeCultivo;

    public Vegetal(String nombre, int precio, int peso, String presentacion, String sueloDeCultivo, String alturaDeCultivo) {
        this.nombre = nombre;
        this.precio = precio;
        this.peso = peso;
        this.presentacion = presentacion;
        this.sueloDeCultivo = sueloDeCultivo;
        this.alturaDeCultivo = alturaDeCultivo;
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

    public String getSueloDeCultivo() {
        return sueloDeCultivo;
    }

    public void setSueloDeCultivo(String sueloDeCultivo) {
        this.sueloDeCultivo = sueloDeCultivo;
    }

    public String getAlturaDeCultivo() {
        return alturaDeCultivo;
    }

    public void setAlturaDeCultivo(String alturaDeCultivo) {
        this.alturaDeCultivo = alturaDeCultivo;
    }

    @Override
    public String toString() {
        return "Vegetal{" +
                "nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", peso=" + peso +
                ", presentacion='" + presentacion + '\'' +
                ", sueloDeCultivo='" + sueloDeCultivo + '\'' +
                ", alturaDeCultivo='" + alturaDeCultivo + '\'' +
                '}';
    }

}
