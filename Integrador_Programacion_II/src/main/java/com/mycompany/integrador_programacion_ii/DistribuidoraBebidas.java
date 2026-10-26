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
    
    //Metodo para agregar empleados
    public void agregarEmpleado(Empleados empleado){
        listaEmpleados.add(empleado);
        System.out.println("Empleado agregado exitosamente");
    }
    
    //Metodo para eliminar empleados
    public void eliminarEmpleado(int id) throws EmpleadoNoEncontradoException{
        //Definimos el iterator y encontrado para buscar en la ArrayList
        Iterator<Empleados> listaEmpleadosIterator = this.listaEmpleados.iterator();
        boolean encontrado = false;
        
        while (listaEmpleadosIterator.hasNext()){
            Empleados empleadoBuscado = listaEmpleadosIterator.next();
            
            if (empleadoBuscado.getId() == id){
                listaEmpleadosIterator.remove();
                encontrado = true;
                System.out.println("El empleado " + empleadoBuscado.getId() + " fue removido con éxito");
                break; //Salimos del bucle
            }
            if (encontrado == false){
                throw new EmpleadoNoEncontradoException("El empleado NO se encuentra en la lista de empleados");
            }
        }
    }
    
    public void agregarClientes(Clientes cliente){
        listaClientes.add(cliente);
        System.out.println("El cliente fue agregado exitosamente");
    }
    
    public void eliminarClientes(String dni) throws ClientesNoEncontradosException {
        //Definimos el iterator y encontrado para buscar en la ArrayList
        Iterator<Clientes> listaClientesIterator = this.listaClientes.iterator();
        boolean encontrado = false;
        
        while (listaClientesIterator.hasNext()){
            Clientes clienteBuscado = listaClientesIterator.next();
            
            if (clienteBuscado.getDni() == dni){
                listaClientesIterator.remove();
                encontrado = true;
                System.out.println("El cliente " + clienteBuscado.getDni() + " fue removido con éxito");
                break; //Salimos del bucle
            }
        }
        if (!encontrado){
                throw new ClientesNoEncontradosException("El cliente NO se encuentra en la lista de clientes");
            }
    }
    
    public void agregarProveedores(Proveedores proveedor){
        listaProveedores.add(proveedor);
        System.out.println("El proveedor fue agregado exitosamente");
    }
    
    public void eliminarProveedores(String razonSocial) throws ProveedorNoEncontradoException{
        //Definimos el iterator y encontrado para buscar en la ArrayList
        Iterator<Proveedores> listaProveedoresIterator = this.listaProveedores.iterator();
        boolean encontrado = false;
        
        while (listaProveedoresIterator.hasNext()){
            Proveedores proveedorBuscado = listaProveedoresIterator.next();
            
            if (proveedorBuscado.getRazonSocial() == razonSocial){
                listaProveedoresIterator.remove();
                encontrado = true;
                System.out.println("El proveedor " + proveedorBuscado.getRazonSocial() + " fue removido con éxito");
                break; //Salimos del bucle
            }
        }
        if (!encontrado){
                throw new ProveedorNoEncontradoException("El proveedor NO se encuentra en la lista de proveedores");
            }
    }
}
    
