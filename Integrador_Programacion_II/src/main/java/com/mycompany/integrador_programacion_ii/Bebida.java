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
    protected double precio;
    private int stock;

    //Contructor
    public Bebida(String marca, double precio,int stock) {
        this.marca = marca;
        this.precio = precio;
        setStock(stock); //usamos el setter para validar que el stock no sea cero
    }
    
    //Getters y Setters
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        if (stock < 0) { //setter con validacion
            throw new IllegalArgumentException("El stock no puede ser negativo.");
        }
        this.stock = stock;
    }
    
    
    
    //Metodos
    public void registrarNumeroLote(int numeroLote){
        System.out.println("La bebida " + this.marca + " corresponde al numero de lote " + numeroLote);
    }
    
    public void mostrarDetalles(){
        System.out.println("La bebida " + this.marca + " cuesta " + this.precio);
    }
    
    public void calcularPrecio(int cantidadAgregar){
        double total = cantidadAgregar * this.precio;
        System.out.println("El precio por la cantidad de " + cantidadAgregar + " unidades es de " + total);
    }
    
    public void agregarStock(int cantidadAgregar){
        if (cantidadAgregar < 0) {
            System.out.println("No se puede agregar una cantidad negativa.");
        } else {
            this.stock += cantidadAgregar;
            System.out.println("Stock sumado. Nuevo stock: " + this.stock);
        }
    }
    
    public void eliminarStock(int cantidadAgregar){
        if (cantidadAgregar > this.stock) {
            System.out.println("¡Error! No hay suficiente stock. Stock actual: " + this.stock);
        } else {
            this.stock -= cantidadAgregar;
            System.out.println("Stock actualizado con éxito. Restante: " + this.stock);
        }
    }
    
}
