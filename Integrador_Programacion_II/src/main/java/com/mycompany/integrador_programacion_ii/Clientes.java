/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.integrador_programacion_ii;

/**
 *
 * @author danie
 */
public class Clientes {
    //Atributos
    private String dni;
    private String nombre;
    private boolean estaInteresado;
    
    //Constructor
    public Clientes(String dni, String nombre, boolean estaInteresado) {
        this.dni = dni;
        this.nombre = nombre;
        this.estaInteresado = estaInteresado;
    }
    
    //Getters y Setters
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isEstaInteresado() {
        return estaInteresado;
    }

    public void setEstaInteresado(boolean estaInteresado) {
        this.estaInteresado = estaInteresado;
    }
    
    //Metodos
    public void realizarCompra(){
        
    }
    
    public void PedirFactura(){
        
    }
}
