/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.integrador_programacion_ii;

/**
 *
 * @author danie
 */
public class Cerveza extends Bebida{
    //Atributos
    private double graduacionAlcoholica;
    private boolean esRetornable;
    
    //Constructor
    public Cerveza(double graduacionAlcoholica, boolean esRetornable, String marca, int cantidad, double precio) {
        super(marca, cantidad, precio);
        this.graduacionAlcoholica = graduacionAlcoholica;
        this.esRetornable = esRetornable;
    }

    
    //Getters y Setters
    public double getGraduacionAlcoholica() {
        return graduacionAlcoholica;
    }

    public void setGraduacionAlcoholica(double graduacionAlcoholica) {
        this.graduacionAlcoholica = graduacionAlcoholica;
    }

    public boolean isEsRetornable() {
        return esRetornable;
    }

    public void setEsRetornable(boolean esRetornable) {
        this.esRetornable = esRetornable;
    }
    
    //Metodos
    public void calcularGraduacionAlcoholica(){
        System.out.println("La graduacion alcoholica de esta cerveza marca " + this.getMarca() + " es " + this.graduacionAlcoholica);
    }
    
    //Overloading=Sobrecarga
    public void calcularPrecio(int descuento){
        if (esRetornable == true){
            double descuentoTotal = 1 - (descuento / 100.0);
        double total = this.cantidad * this.precio * descuentoTotal;
        System.out.println("El precio por la cantidad de " + this.cantidad + " unidades es de " + total);
        }else{
            double total = this.cantidad * this.precio;
            System.out.println("El precio por la cantidad de " + this.cantidad + " unidades es de " + total);
        }
    }
    
    //Override=Sobreescritura
    @Override
    public void mostrarDetalles(){
        if (esRetornable == true){
            System.out.println("La cerveza de la marca " + this.marca + " cuesta " + this.precio + " tiene graduacion alcoholica " + this.graduacionAlcoholica + " y es retornable");      
        }else{
            System.out.println("La cerveza de la marca " + this.marca + " cuesta " + this.precio + " tiene graduacion alcoholica " + this.graduacionAlcoholica + " y NO es retornable");
        }
    }  
}
