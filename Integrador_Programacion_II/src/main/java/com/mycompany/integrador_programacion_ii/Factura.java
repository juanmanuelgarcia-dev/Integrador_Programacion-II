/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.integrador_programacion_ii;

/**
 *
 * @author danie
 */
public class Factura {
    private double total;
    private VentaRealizada tipoDeVenta;

    public Factura(double total, VentaRealizada tipoDeVenta) {
        this.total = total;
        this.tipoDeVenta = tipoDeVenta;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public VentaRealizada getTipoDeVenta() {
        return tipoDeVenta;
    }

    public void setTipoDeVenta(VentaRealizada tipoDeVenta) {
        this.tipoDeVenta = tipoDeVenta;
    }
    
    //completar
    public void imprimirFactura(){
        System.out.println("En el dia " + this.tipoDeVenta.getFecha() + 
                " el cliente " + this.tipoDeVenta.getCliente().getNombre() + 
                " realizo una compra por el total de " + this.total);
    }
}
