/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.integrador_programacion_ii;

/**
 *
 * @author danie
 */
//Excepcion personalizada por si no encuentra al proveedor
public class ProveedorNoEncontradoException extends Exception{
    public ProveedorNoEncontradoException(String message) {
        super(message);
    }
}
