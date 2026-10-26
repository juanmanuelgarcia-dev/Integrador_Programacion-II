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
    protected String marca;
    protected int cantidad;
    protected double precio;

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
    
    public void mostrarDetalles(){
        System.out.println("La bebida " + this.marca + " cuesta " + this.precio);
    }
    
    public void calcularPrecio(){
        double total = this.cantidad* this.precio;
        System.out.println("El precio por la cantidad de " + this.cantidad + " unidades es de " + total);
    }
    
    
}
