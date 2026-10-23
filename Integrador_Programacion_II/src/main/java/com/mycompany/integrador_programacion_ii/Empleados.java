/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.integrador_programacion_ii;

/**
 *
 * @author danie
 */
public class Empleados {
    //Atributos
    private int id;
    private String telefono;
    private String nombre;
    
    //Constructor
    public Empleados(int id, String telefono, String nombre) {
        this.id = id;
        this.telefono = telefono;
        this.nombre = nombre;
    }
    
    //Getters y Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void insertaeVenta(){
        
    }
    
    public void mostrarInformacionProducto(){
        
    }
}
