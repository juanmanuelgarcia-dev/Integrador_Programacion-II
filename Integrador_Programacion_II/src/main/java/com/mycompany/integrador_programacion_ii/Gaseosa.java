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
    public Gaseosa(String marca, int cantidad, double precio) {
        super(marca, cantidad, precio);
    }

    public Gaseosa(double cantidadAzucar, boolean esZero, String marca, int cantidad, double precio) {
        super(marca, cantidad, precio);
        this.cantidadAzucar = cantidadAzucar;
        this.esZero = false;
    }
    
    public void calcularCantidadAzucar(){
        if (this.esZero == true){
            System.out.println("No posee azúcar");
        }else{
            System.out.println("Su cantidad de azucar es " + this.cantidadAzucar);
        }
    }  
}
