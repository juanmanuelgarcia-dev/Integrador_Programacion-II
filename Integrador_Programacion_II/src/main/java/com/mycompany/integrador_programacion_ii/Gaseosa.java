/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.integrador_programacion_ii;

/**
 *
 * @author danie
 */
public class Gaseosa extends Bebida{
    private double cantidadAzucar;
    private boolean esZero;
    
    //Constructor
    public Gaseosa(double cantidadAzucar, boolean esZero, String marca, double precio,int stock) {
        super(marca, precio,stock);
        this.cantidadAzucar = cantidadAzucar;
        this.esZero = esZero;
    }
    
    public void calcularCantidadAzucar(){
        if (this.esZero == true){
            System.out.println("No posee azúcar");
        }else{
            System.out.println("Su cantidad de azucar es " + this.cantidadAzucar);
        }
    }
    
    //Overloading=Sobrecarga
    public void calcularPrecio(int descuento,boolean descuentoAplicado,int cantidad){
        if (descuentoAplicado == true){
            double descuentoTotal = 1 - (descuento / 100.0);
        double total = cantidad * this.precio * descuentoTotal;
        System.out.println("El precio por la cantidad de " + cantidad + " unidades es de " + total);
        }else{
            double total = cantidad * this.precio;
            System.out.println("El precio por la cantidad de " + cantidad + " unidades es de " + total);
        }
    }
    
    //Override=Sobreescritura
    @Override
    public void mostrarDetalles(){
        if (esZero == true){
            System.out.println("La gaseosa de la marca " + this.marca + " cuesta " + this.precio + " tiene una cantidad de azucar de " + this.cantidadAzucar + " gramos");      
        }else{
            System.out.println("La gaseosa de la marca " + this.marca + " cuesta " + this.precio + " y es zero, NO tiene azucar");
        }
    }  
    
    
}
