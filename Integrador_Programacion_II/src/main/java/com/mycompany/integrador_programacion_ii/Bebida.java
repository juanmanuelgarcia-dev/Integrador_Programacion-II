/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.integrador_programacion_ii;

/**
 *
 * @author danie
 */
public abstract class Bebida {
    //Atributos
    private String marca;
    private int cantidad;
    private double precio;

    //Contructor
    public Bebida(String marca, int cantidad, double precio) {
        this.marca = marca;
        this.cantidad = cantidad;
        this.precio = precio;
    }
    
    //Getters y Setters
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    //Metodos
    public void registrarNumeroLote(int numeroLote){
        System.out.println("La bebida " + this.marca + " corresponde al numero de lote " + numeroLote);
    }
    
    
}
