/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.integrador_programacion_ii;

/**
 *
 * @author danie
 */
import java.util.ArrayList;
import java.util.Iterator;

public class DistribuidoraBebidas {
    //Defino el primer atributo
    private String nombre;
    //ArrayList para representar la asociacion con clientes y proveedores
    private ArrayList<Clientes> listaClientes = new ArrayList<Clientes>();
    private ArrayList<Proveedores> listaProveedores = new ArrayList<Proveedores>();
    //ArrayList para representar la agregacion con empleados
    private ArrayList<Empleados> listaEmpleados = new ArrayList<Empleados>();
    
    //Constructor
    public DistribuidoraBebidas(String nombre) {
        this.nombre = nombre;
    }
    
    //Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Clientes> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(ArrayList<Clientes> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public ArrayList<Proveedores> getListaProveedores() {
        return listaProveedores;
    }

    public void setListaProveedores(ArrayList<Proveedores> listaProveedores) {
        this.listaProveedores = listaProveedores;
    }

    public ArrayList<Empleados> getListaEmpleados() {
        return listaEmpleados;
    }

    public void setListaEmpleados(ArrayList<Empleados> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }

}
