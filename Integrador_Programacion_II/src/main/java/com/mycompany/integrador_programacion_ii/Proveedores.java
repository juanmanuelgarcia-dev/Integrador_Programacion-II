/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.integrador_programacion_ii;

/**
 *
 * @author danie
 */
public class Proveedores {
    //Atributos
    private String razonSocial;
    private Bebida tipoBebida;
    
    //Constructores
    public Proveedores(String razonSocial, Bebida tipoBebida) {
        this.razonSocial = razonSocial;
        this.tipoBebida = tipoBebida;
    }

    //Getters and setters
    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public Bebida getTipoBebida() {
        return tipoBebida;
    }

    public void setTipoBebida(Bebida tipoBebida) {
        this.tipoBebida = tipoBebida;
    }
    
    //Metodos
    public void enviarBebida(int cantidad){
        System.out.println("La bebida " + this.tipoBebida.getMarca() + " fue enviada, se envió la cantidad de  " + cantidad);
    }
    
    public void enviarPresupuesto(int cantidad,double precioUnitarioMayorista){
        double costoTotal = cantidad * precioUnitarioMayorista;
        System.out.println("El proveedor " + this.razonSocial + " nos envia el presupuesto de la bebida " + this.tipoBebida.getMarca() + " que es por el total de " + costoTotal);
    }
 
}
