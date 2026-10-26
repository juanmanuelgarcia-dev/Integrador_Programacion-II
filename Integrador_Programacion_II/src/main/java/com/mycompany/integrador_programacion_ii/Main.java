/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.integrador_programacion_ii;

/**
 *
 * @author danie
 */

import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DistribuidoraBebidas distribuidora = new DistribuidoraBebidas("Distribuidora de Bebidas S.A.");
        int opcion;
        System.out.println("Bienvenido a la Distribuidora de bebidas S.A.");
        do{
            //Primer switch para ingresar al sistema o al control de stock
            System.out.println("Seleccione una de las siguientes opciones para decidir que desea hacer");
            System.out.println("1. Gestión de Inventario y Base de Datos");
            System.out.println("2. Sistema de control sobre la información de la distribuidora");
            System.out.println("3. salir");
            opcion = sc.nextInt();
            sc.nextLine();
            
            switch (opcion){
                case 1:
                    System.out.println("Bienvenido a la Gestion de Inventario y Base de datos");
                    
                case 2:
                    System.out.println("Bienvenido al Sistema de control sobre la información de la distribuidora");
                    do{
                        System.out.println("Seleccione la opcion que desee");
                        System.out.println("1. Agregar empleados");
                        System.out.println("2. Eliminar empleados");
                        System.out.println("3. Agregar clientes");
                        System.out.println("4. Eliminar clientes");
                        System.out.println("5. Agregar proveedores");
                        System.out.println("6. Eliminar proveedores");
                        System.out.println("7. Realizar factura");
                        System.out.println("8. Registrar venta de bebida");
                        System.out.println("9. Calcular precios de las bebidas");
                        System.out.println("10. Mostrar detalles de las bebidas");
                        System.out.println("11. Salir");
                        switch (opcion){
                            case 1:
                                
                        }
                    }while (opcion != 9);
                
                case 3:
                    System.out.println("Gracias por utilizar el programa de la distribuidora S.A.");
                    break;
            }
        }while (opcion != 3);
    }
}
