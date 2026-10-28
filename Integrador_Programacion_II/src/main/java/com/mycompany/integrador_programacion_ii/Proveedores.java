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
    private Cerveza tipoCerveza;
    private Gaseosa tipoGaseosa;
    
    //Constructores

    public Proveedores(String razonSocial, Cerveza tipoCerveza, Gaseosa tipoGaseosa) {
        this.razonSocial = razonSocial;
        this.tipoCerveza = tipoCerveza;
        this.tipoGaseosa = tipoGaseosa;
    }

    //Getters and setters
    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public Cerveza getTipoCerveza() {
        return tipoCerveza;
    }

    public void setTipoCerveza(Cerveza tipoCerveza) {
        this.tipoCerveza = tipoCerveza;
    }

    public Gaseosa getTipoGaseosa() {
        return tipoGaseosa;
    }

    public void setTipoGaseosa(Gaseosa tipoGaseosa) {
        this.tipoGaseosa = tipoGaseosa;
    }
    
    //Metodos
    public void enviarBebida(){
        System.out.println("El proveedor " + this.razonSocial + " envio la cerveza de marca " + this.tipoCerveza.getMarca() + " y la gaseosa " + this.tipoGaseosa.getMarca());
    }
    
    public void enviarPresupuesto(){
        double presupuestoCerveza = this.tipoCerveza.cantidad * this.tipoCerveza.precio;
        double presupuestoGaseosa = this.tipoGaseosa.cantidad * this.tipoGaseosa.precio;
        System.out.println("El presupuesto por cerveza de marca " + this.tipoCerveza.getMarca() + " es de " + presupuestoCerveza);
        System.out.println("El presupuesto por cerveza de marca " + this.tipoGaseosa.getMarca() + " es de " + presupuestoGaseosa);
    }
}
