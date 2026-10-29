/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.integrador_programacion_ii;

/**
 *
 * @author danie
 */
import java.sql.Connection; //clase para manejar conexion con la base
import java.sql.DriverManager;//Importa el administrador de drivers que gestiona la conexión JDBC
import java.sql.SQLException;//clase de errores sql
import java.sql.Statement;//clase para enviar y ejecutar sentencias sql

public class conexionDB {
    //conecto con la base de datos local
    public static final String URL = "jdbc:sqlite:agenda.sqlite";
    
    // Método de instancia para conectar
    public Connection conectar() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL);
        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos: " + e.getMessage());
        }
        return conn;
    }
    
    
    
    
}
