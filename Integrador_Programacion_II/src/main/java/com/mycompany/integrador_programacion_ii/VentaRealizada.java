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
    private Date fecha;
    private double precioUnitario;
    private Clientes cliente;
    private Empleados empleado;
    private Factura factura;
    
    //Constructor
    public VentaRealizada(int cantidad, Date fecha, double precioUnitario, Clientes cliente, Empleados empleado,double totalVenta) {
        this.cantidad = cantidad;
        this.fecha = fecha;
        this.precioUnitario = precioUnitario;
        this.cliente = cliente;
        this.empleado = empleado;
        //Instanciamos el objeto dentro del constructor
        //Uno de los parámetros es un objeto de la instancia venta por eso le pasamos this
        this.factura = new Factura(totalVenta,this);
    }

    //Getters y Setters
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

    public Empleados getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleados empleado) {
        this.empleado = empleado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }
    
    

    //Metodos
    public void registrarVentaRealizada(Empleados empleado){
        //SQL
    }
    
    public void mostrarDetallesVenta(Bebida bebida,int numeroLote,Empleados empleado){
        double totalVenta = this.precioUnitario * this.cantidad;
        System.out.println("La bebida " + bebida.getMarca() + " del lote " + numeroLote + " por el costo de " + totalVenta + " fue realizada en el dia de " + this.fecha + " por el empleado " + empleado.getNombre());
    }
}
