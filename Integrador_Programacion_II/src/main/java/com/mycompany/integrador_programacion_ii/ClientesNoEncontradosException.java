/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.integrador_programacion_ii;

/**
 *
 * @author danie
 */
    //Excepcion personalizada si no encontramos un cliente
public class ClientesNoEncontradosException extends Exception {
    public ClientesNoEncontradosException(String mensaje) {
        super(mensaje);
    }
}
