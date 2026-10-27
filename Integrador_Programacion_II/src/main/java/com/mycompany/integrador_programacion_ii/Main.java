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
        //Defino el tipo de variable para no tener que hacerlo cada vez que desee asignarle un valor
        int opcion;
        int id;
        String nombre;
        String telefono;
        String dni;
        String razonSocial;
        
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
                                //Manejo de excepciones por si se produce un error de ingreso
                                try{
                                    System.out.println("Ingrese el id del empleado: ");
                                    id = sc.nextInt();
                                    sc.nextLine();
                                    System.out.println("Ingrese el nombre del empleado");
                                    nombre = sc.nextLine();
                                    System.out.println("Ingrese el celular del empleado");
                                    telefono = sc.nextLine();
                                    
                                    //Instancio la clase empleado
                                    Empleados nuevoEmpleado = new Empleados(id,telefono,nombre);
                                    nuevoEmpleado.mostrarInformacion();
                                    distribuidora.agregarEmpleado(nuevoEmpleado);                                  
                                } catch (InputMismatchException e){
                                    System.out.println("Debe ingresar un valor entero");
                                }
                            case 2:
                               //Manejo de excepciones por si se produce un error de ingeso o de busqueda
                                try{
                                    System.out.println("Ingrese el id del empleado: ");
                                    id = sc.nextInt();
                                    sc.nextLine();
                                    distribuidora.eliminarEmpleado(id);
                                    
                                } catch (InputMismatchException e){
                                    System.out.println("Debe ingresar un valor entero");
                                } catch (EmpleadoNoEncontradoException e){
                                    System.out.println(e.getMessage());
                                }
                            
                            case 3:
                                //Manejo de excepciones por si se produce un error de ingreso
                                try{
                                    System.out.println("Ingrese el nombre del cliente");
                                nombre = sc.nextLine();
                                System.out.println("Ingresar el dni del clliente");
                                dni = sc.nextLine();
                                String respuesta;
                                boolean estaInteresado = false;
                                do{
                                    System.out.println("El cliente se muestra interesado (s/n");
                                    respuesta = sc.nextLine();
                                    
                                    if (respuesta.equalsIgnoreCase("s")) {
                                        estaInteresado = true;
                                    } else if (respuesta.equalsIgnoreCase("n")) {
                                        estaInteresado = false;
                                    } else {
                                        System.out.println("Ingrese s o n como respuesta.");
                                    }
                                } while (!respuesta.equalsIgnoreCase("s") && !respuesta.equalsIgnoreCase("n"));
                                Clientes nuevoCliente = new Clientes(dni,nombre,estaInteresado);
                                distribuidora.agregarClientes(nuevoCliente);
                                }catch (InputMismatchException e){
                                    System.out.println("Debe ingresar un valor entero");
                                }
                            
                            case 4:
                                //Manejo de excepciones por si se produce un error de ingeso o de busqueda
                                try{
                                    System.out.println("Ingrese el dni del cliente: ");
                                    dni = sc.nextLine();
                                    distribuidora.eliminarClientes(dni);
                                    
                                } catch (InputMismatchException e){
                                    System.out.println("Debe ingresar un valor entero");
                                } catch (ClientesNoEncontradosException e){
                                    System.out.println(e.getMessage());
                                }
                            
                            case 5:
                                //Manejo de excepciones por si se produce un error de ingreso
                                
                                //Ingresamos todos los datos que puede ingresar el usuario
                                System.out.println("Ingrese la razon social del proveedor");
                                razonSocial = sc.nextLine();
                                System.out.println("Ingrese la marca de la cerveza");
                                String marcaCerveza = sc.nextLine();
                                System.out.println("Ingrese la cantidad de botellas de cerveza");
                                int cantidadCerveza = sc.nextInt();
                                System.out.println("Ingrese el precio unitario por botella");
                                Double precioUnitarioCerveza = sc.nextDouble();
                                System.out.println("Ingrese la graduacion alcoholica de la cerveza");
                                double graduacionAlcoholica = sc.nextDouble();
                                
                                //Validamos que la botella sea retornable
                                boolean esRetornable = false;
                                String respuesta = "a";
                                do{
                                    System.out.println("La botella es retornable (s/n) ");
                                    if (respuesta.equalsIgnoreCase("s")){
                                        esRetornable = true;
                                    }else if (respuesta.equalsIgnoreCase("n")){
                                        esRetornable = false;
                                    }else {
                                        System.out.println("Debe ingresar (s/n)");
                                    }
                                }while (!respuesta.equalsIgnoreCase("s") && !respuesta.equalsIgnoreCase("n"));            
                                     
                        }
                    }while (opcion != 9);
                
                case 3:
                    System.out.println("Gracias por utilizar el programa de la distribuidora S.A.");
                    break;
            }
        }while (opcion != 3);
    }
}
