/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.integrador_programacion_ii;

/**
 *
 * @author danie
 */
import java.util.Date;

public class VentaRealizada {
    //Atributos
    private int cantidad;
    private Date date;
    private double precioUnitario;
    private double total;
    
    //Constructor

    public VentaRealizada(int cantidad, Date date, double precioUnitario, double total) {
        this.cantidad = cantidad;
        this.date = date;
        this.precioUnitario = precioUnitario;
        this.total = total;
    }
    
    //Getters y Setters

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    //Metodos
    public void registrarVentaRealizada(Empleados empleado){
        //SQL
    }
    
    public void mostrarDetallesVenta(Bebida bebida,int numeroLote,Empleados empleado){
        double totalVenta = this.precioUnitario * this.cantidad;
        System.out.println("La bebida " + bebida.getMarca() + " del lote " + numeroLote + " por el costo de " + totalVenta + " fue realizada en el dia de " + this.date + " por el empleado " + empleado.getNombre());
    }
}
