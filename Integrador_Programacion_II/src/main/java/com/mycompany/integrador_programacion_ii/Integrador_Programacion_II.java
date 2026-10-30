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
import java.util.Date;

public class Integrador_Programacion_II {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DistribuidoraBebidas distribuidora = new DistribuidoraBebidas("Distribuidora de Bebidas S.A.");
        int opciondb;
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
                    do{
                        System.out.println("1. Crea las tablas para controlar el stock y precios(solo si no existen las tablas) ");
                        System.out.println("2. Cargar valores en las tablas de gaseosa");
                        System.out.println("3. Cargar valores en las tablas de cerveza");
                        System.out.println("4. Actualizar valores de las tablas de gaseosa");
                        System.out.println("5. Actualizar valores de las tablas de cerveza");
                        System.out.println("6. Eliminar valores de las tablas de gaseosa");
                        System.out.println("7. Eliminar valores de las tablas de cerveza");
                        System.out.println("8. Ver valores de las tablas de gaseosa");
                        System.out.println("9. Ver valores de las tablas de cerveza");
                        System.out.println("10. Salir");
                        System.out.println("Seleccione una de las opciones: ");
                        
                        opciondb = sc.nextInt();
                        sc.nextLine();
                        
                        switch (opciondb){
                            
                            case 1:
                                //Creo las tablas, solo una vez ya que despues quedan guardadas
                                System.out.println("Configuracion base de datos");
                                conexionDB conexion = new conexionDB();
                                conexion.inicializarBaseDeDatos();
                                break;
                                
                            case 2:
                                try {
                                    System.out.println("Marca de la gaseosa: ");
                                    String marcaG = sc.nextLine();
                                    System.out.println("Precio unitario de la gaseosa: ");
                                    double precioUnitarioG = sc.nextDouble();
                                    System.out.println("Stock de la gaseosa: ");
                                    int stockG = sc.nextInt();
                                    System.out.println("Cantidad de azucar de la gaseosa(0 si no tiene) ");
                                    double cantidadAzcuarG = sc.nextDouble();
                                    int esZeroG = 1; //si tiene azucar
                                    if (cantidadAzcuarG == 0){
                                        esZeroG = 0; //si es zero no tiene azucar
                                    }
                                    
                                    //reutilizamos la variable ya existente para trabajar con la instancia de conexion
                                    conexion = new conexionDB();
                                    //llamamos al metodo para insertar gaseosas en la base de datos
                                    conexion.insertarGaseosas(marcaG, precioUnitarioG, stockG, cantidadAzcuarG, esZeroG);
                                    
                                }catch (InputMismatchException e){
                                    System.out.println("Ingrese los valores que son pedidos");
                                }
                                    break;
                            
                            case 3:
                                //Pido la informacion para agregar en la tabla de cerveza
                                try{
                                    System.out.println("Marca de la cerveza: ");
                                    String marcaC = sc.nextLine();
                                    System.out.println("Precio unitario de la cerveza: ");
                                    double precioUnitarioC = sc.nextDouble();
                                    System.out.println("Stock de las cervezas: ");
                                    int stockC = sc.nextInt();
                                    System.out.println("Graduacion alcoholica: ");
                                    double graduacionAlcoholicaG = sc.nextDouble();
                                    System.out.println("¿Es retornable la botella? (0. No, 1. Si");
                                    int esRetornableC = sc.nextInt();
                                    //Valido que si el usuario ingresa otra cosa es porque no es retornable
                                    if (esRetornableC != 1 || esRetornableC != 0){
                                        esRetornableC = 0; //si el usuario ingresa otra opcion la tomamos por no retornable
                                    }  
                                    //reutilizamos la variable ya existente para trabajar con la instancia de conexion
                                    conexion = new conexionDB();
                                    //llamamos al metodo para insertar cervezas en la base de datos
                                    conexion.insertarCerveza(marcaC, precioUnitarioC, stockC, graduacionAlcoholicaG, esRetornableC);
                                    
                                }catch (InputMismatchException e){
                                    System.out.println("Ingrese los valores que son pedidos");
                                }
                                break;
                            
                            case 4:
                                //valido que ingrese los valores que deseo
                                try{
                                    //pido la informacion que necesito para realizar la actualizacion de gaseosa
                                    System.out.println("Ingrese el id de la gaseosa a actualizar: ");
                                    int idActualizarG = sc.nextInt();
                                    System.out.println("Ingrese el nuevo precio: ");
                                    double nuevoPrecioG = sc.nextDouble();
                                    System.out.println("Ingrese el nuevo stock: ");
                                    int nuevoStockG = sc.nextInt();
                                    sc.nextLine();
                                    conexion = new conexionDB();
                                    conexion.actualizarGaseosa(opcion, nuevoPrecioG, nuevoStockG);
                                    
                                }catch (InputMismatchException e){
                                    System.out.println("Ingrese los valores que son pedidos");
                                }
                                break;
                            
                            case 5:
                                try{
                                    //pido informacion que necesito para realizar la actualizacion de cerveza
                                    System.out.println("Ingrese el id de la cerveza a actualizar: ");
                                    int idActualizarC = sc.nextInt();
                                    System.out.println("Ingrese el nuevo precio: ");
                                    double nuevoPrecioC = sc.nextDouble();
                                    System.out.println("Ingrese el nuevo stock: ");
                                    int nuevoStockC = sc.nextInt();
                                    sc.nextLine();
                                    
                                    conexion = new conexionDB();
                                    conexion.actualizarCerveza(idActualizarC, nuevoPrecioC, nuevoStockC);
                                }catch (InputMismatchException e){
                                    System.out.println("Ingrese los valores que son pedidos");
                                }
                                break;
                                
                            case 6:
                                try{
                                    //pido la informacion que necesito para realizar la eliminar de gaseosa
                                    System.out.println("Ingrese el id de la gaseosa a eliminar: ");
                                    int idEliminarG = sc.nextInt();
                                    sc.nextLine();
                                    //instancio conexion y llamo al metodo que la elimina
                                    conexion = new conexionDB();
                                    conexion.eliminarGaseosa(idEliminarG);
                                    
                                }catch (InputMismatchException e){
                                    System.out.println("Ingrese los valores que son pedidos");
                                }
                                break;
                                
                            case 7:
                                try{
                                    //Pido la info necesaria para eliminar cerveza
                                    System.out.println("Ingrese el id de la cerveza a eliminar: ");
                                    int idEliminarC = sc.nextInt();
                                    sc.nextLine();
                                    //instancio la conexion y llamo al metodo que lo elimina
                                    conexion = new conexionDB();
                                    conexion.eliminarCerveza(idEliminarC);
                                    break;
                                    
                                }catch (InputMismatchException e){
                                    System.out.println("Ingrese los valores que son pedidos");
                                }
                                break;
                            
                            
                            case 8:
                                //instancio conexion y llamo al metodo que muestra la tabla
                                conexion = new conexionDB();
                                conexion.verTablaGaseosa();
                                break;
                                    
                            case 9:
                                //instancio conexion y llamo al metodo que muestra la tabla
                                conexion = new conexionDB();
                                conexion.verTablaCerveza();
                                break;
                                
                            case 10:
                                System.out.println("Gracias por utilizar nuestra Gestion de Inventario y Base de datos");
                                break;
                                
                            default:
                                System.out.println("Ingrese una opcion valida");
                                break;
                                
                        }
                    } while (opciondb != 10);
                    
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
                        System.out.println("8. Calcular precios de las bebidas");
                        System.out.println("9. Mostrar detalles de las bebidas");
                        System.out.println("10. Salir");
                        opcion = sc.nextInt();
                        sc.nextLine();
                        
                        switch (opcion){
                            
                            case 1:
                                //Manejo de excepciones por si se produce un error de ingreso
                                try{
                                    System.out.println("Ingrese el id del empleado: ");
                                    int id = sc.nextInt();
                                    sc.nextLine();
                                    System.out.println("Ingrese el nombre del empleado");
                                    String nombre = sc.nextLine();
                                    System.out.println("Ingrese el celular del empleado");
                                    String telefono = sc.nextLine();
                                    
                                    //Instancio la clase empleado
                                    Empleados nuevoEmpleado = new Empleados(id,telefono,nombre);
                                    nuevoEmpleado.mostrarInformacion();
                                    distribuidora.agregarEmpleado(nuevoEmpleado);                                  
                                } catch (InputMismatchException e){
                                    System.out.println("Debe ingresar un valor entero");
                                }
                                break;
                                
                            case 2:
                               //Manejo de excepciones por si se produce un error de ingeso o de busqueda
                                try{
                                    System.out.println("Ingrese el id del empleado: ");
                                    int id = sc.nextInt();
                                    sc.nextLine();
                                    distribuidora.eliminarEmpleado(id);
                                    
                                } catch (InputMismatchException e){
                                    System.out.println("Debe ingresar un valor entero");
                                } catch (EmpleadoNoEncontradoException e){
                                    System.out.println(e.getMessage());
                                }
                                break;
                            
                            case 3:
                                //Manejo de excepciones por si se produce un error de ingreso
                                try{
                                    System.out.println("Ingrese el nombre del cliente");
                                    String nombre = sc.nextLine();
                                    System.out.println("Ingresar el dni del clliente");
                                    String dni = sc.nextLine();
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
                                    
                                    boolean compraHecha = nuevoCliente.realizarCompra();
                                    
                                    if (compraHecha == true){
                                        System.out.println("Ingrese la compra que se realizo: ");
                                        String compras = sc.nextLine();
                                        nuevoCliente.agregarCompra(compras);
                                    }
                                    
                                    distribuidora.agregarClientes(nuevoCliente);
                                    
                                }catch (InputMismatchException e){
                                    System.out.println("Debe ingresar un valor entero");
                                }
                                break;
                            
                            case 4:
                                //Manejo de excepciones por si se produce un error de ingeso o de busqueda
                                try{
                                    System.out.println("Ingrese el dni del cliente: ");
                                    String dni = sc.nextLine();
                                    distribuidora.eliminarClientes(dni);
                                    
                                } catch (ClientesNoEncontradosException e){
                                    System.out.println(e.getMessage());
                                }
                                break;
                            
                            case 5:
                                //Manejo de excepciones por si se produce un error de ingreso
                                try{
                                    //Ingresamos todos los datos que puede ingresar el usuario para cerveza
                                    System.out.println("Ingrese la razon social del proveedor: ");
                                    String razonSocial = sc.nextLine();
                                    System.out.println("Ingrese la marca de la cerveza: ");
                                    String marcaCerveza = sc.nextLine();
                                    System.out.println("Ingrese la cantidad de botellas de cerveza que desea: ");
                                    int cantidadCerveza = sc.nextInt();
                                    System.out.println("Ingrese el stock de cerveza que tiene en bodega: ");
                                    int stockCerveza = sc.nextInt();
                                    System.out.println("Ingrese el precio unitario por cerveza");
                                    Double precioUnitarioCerveza = sc.nextDouble();
                                    System.out.println("Ingrese la graduacion alcoholica de la cerveza");
                                    double graduacionAlcoholica = sc.nextDouble();
                                    sc.nextLine();
                                    //Validamos que la botella sea retornable
                                    boolean esRetornable = false;
                                    String respuesta;
                                    do{
                                        System.out.println("La botella es retornable (s/n) ");
                                        respuesta = sc.nextLine();
                                        if (respuesta.equalsIgnoreCase("s")){
                                            esRetornable = true;
                                        }else if (respuesta.equalsIgnoreCase("n")){
                                            esRetornable = false;
                                        }else {
                                            System.out.println("Debe ingresar (s/n)");
                                        }
                                    }while (!respuesta.equalsIgnoreCase("s") && !respuesta.equalsIgnoreCase("n"));            
                                    //Instanciamos la clase cerveza
                                    Cerveza cerveza = new Cerveza(graduacionAlcoholica,esRetornable,marcaCerveza,precioUnitarioCerveza,stockCerveza);
                                
                                    //Ingresamos todos los datos que puede ingresar el usuario para gaseosa
                                    System.out.println("Ingrese la marca de la gaseosa: ");
                                    String marcaGaseosa = sc.nextLine();
                                    System.out.println("Ingrese la cantidad de botellas de gaseosa que desea: ");
                                    int cantidadGaseosa = sc.nextInt();
                                    System.out.println("Ingrese el stock de botellas de gaseosa que tiene en bodega: ");
                                    int stockGaseosa = sc.nextInt();
                                    System.out.println("Ingrese el precio unitario por gaseosa: ");
                                    double precioUnitarioGaseosa = sc.nextDouble();
                                    sc.nextLine();
                                    System.out.println("Ingrese la graduacion de azucar de la gaseosa (0 si no contiene): ");
                                    boolean esZero = false;
                                    double gradosAzucar = sc.nextDouble();
                                    if (gradosAzucar == 0){
                                        esZero = true;
                                    }
                                
                                    //Instanciamos la clase gaseosa
                                    Gaseosa gaseosa = new Gaseosa(gradosAzucar, esZero, marcaGaseosa, precioUnitarioGaseosa, stockGaseosa);
                                    //Instancio la clase proveedor para agregarla a mi arraylist
                                    Proveedores nuevoProveedor = new Proveedores(razonSocial,cerveza,gaseosa);
                                    //Llamo al metodo para pedirle presupuesto y enviar bebidas al proveedor
                                    nuevoProveedor.enviarPresupuesto(cantidadCerveza,cantidadGaseosa);
                                    nuevoProveedor.enviarBebida();
                                    
                                    distribuidora.agregarProveedores(nuevoProveedor);
                                }catch (InputMismatchException e){
                                    System.out.println(e.getMessage());
                                }
                                break;
                                
                            case 6:
                                //Manejo de excepciones por si se produce un error de ingeso o de busqueda
                                try{
                                    System.out.println("Ingrese la razon social del proveedor ");
                                    String razonSocial = sc.nextLine();
                                    distribuidora.eliminarClientes(razonSocial);
                                } catch (ClientesNoEncontradosException e){
                                    System.out.println(e.getMessage());
                                }
                                break;
                            
                            case 7:
                                Date fecha = new Date();
                                System.out.println("Ingrese el total de la venta: ");
                                double total = sc.nextDouble();
                                System.out.println("Ingrese la cantidad: ");
                                int cantidad = sc.nextInt();
                                System.out.println("Ingrese el precio unitario: ");
                                double precioUnitario = sc.nextDouble();
                                sc.nextLine();
                                
                                //Pedimos los atributos para instanciar cliente
                                System.out.println("Ingrese el nombre del cliente que compro: ");
                                String nombre = sc.nextLine();
                                System.out.println("Ingrese el dni del cliente que compro: ");
                                String dni = sc.nextLine();
                                //Ya realizo la compra asi que tomamos el interes del cliente
                                boolean interes = true;
                                
                                //Pedimos los atributos para instanciar empleado
                                System.out.println("Ingrese el id del empleado: ");
                                int id = sc.nextInt();
                                sc.nextLine();
                                System.out.println("Ingrese el nombre del empleado que realizo la venta: ");
                                nombre = sc.nextLine();
                                System.out.println("Ingrese el telefono del empleadp que realizo la venta: ");
                                String telefono = sc.nextLine();
                                
                                Clientes clienteQueRealizoCompra = new Clientes(nombre,dni,interes);
                                Empleados empleadoQueRealizoLaVenta = new Empleados(id,telefono,nombre);
                                
                                VentaRealizada venta = new VentaRealizada(cantidad,fecha,precioUnitario,clienteQueRealizoCompra,empleadoQueRealizoLaVenta,total);
                                
                                //Realizo la factura con la instanciacion de venta
                                venta.getFactura().imprimirFactura();
                                break;
                                
                            case 8:
                                //El for para que itere por cada proveedor guardado en la lista
                                System.out.println("Ingrese la cantidad de gaseosa que tiene: ");
                                int cantidadT = sc.nextInt();
                                sc.nextLine();
                                for (Proveedores proveedor : distribuidora.getListaProveedores()) {
                                    System.out.println("Bebidas del proveedor: " + proveedor.getRazonSocial());  
                                    
                                    //Descuento cerveza
                                    System.out.println("Ingrese el descuento para cerveza:");
                                    int descuentoCerveza = sc.nextInt();
                                    proveedor.getTipoCerveza().calcularPrecio(descuentoCerveza);
                                    
                                    //Descuento gaseosa
                                    System.out.println("Ingrese el descuento para gaseosa");
                                    int descuentoGaseosa = sc.nextInt();
                                    sc.nextLine();
                                    proveedor.getTipoGaseosa().calcularPrecio(descuentoGaseosa, true,cantidadT);
                                }
                                break;
                                
                            case 9:
                                //Se usa el for para mostrar todos los detalles de las bebidas de todos los proveedores
                                System.out.println("Mostrando los detales de las bebidas registradas");
                                for (Proveedores proveedor : distribuidora.getListaProveedores()) {
                                    proveedor.getTipoCerveza().mostrarDetalles();
                                    proveedor.getTipoGaseosa().mostrarDetalles();
                                }
                                break;
                                
                            case 10:
                                System.out.println("Gracias por usar el Sistema de control sobre la información de la distribuidora");
                                break;
                                
                            default:
                                System.out.println("Ingrese una opcion valida");
                                break;
                                
                        }
                    }while (opcion != 10);
                
                case 3:
                    System.out.println("Gracias por utilizar el programa de la distribuidora S.A.");
                    break;
            }
        }while (opcion != 3);
    }
}
