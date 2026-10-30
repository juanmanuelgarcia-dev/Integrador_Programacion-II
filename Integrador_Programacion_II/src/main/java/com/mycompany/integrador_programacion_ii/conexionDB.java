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
import java.sql.PreparedStatement; //Permite enviar sentencias sql seguras
import java.sql.ResultSet;// Maneja el cursor que recibe los resultados de una consulta SELECT

public class conexionDB {
    //conecto con la base de datos local
    private String URL = "jdbc:sqlite:agenda.sqlite";
    private Connection conn;
    
    //se ejecuta al hacer new ConexionBD y abre la conexion una vez
    public conexionDB() {
        try {
            this.conn = DriverManager.getConnection(URL);
            System.out.println("[INFO] Conexión a la base de datos abierta.");
        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos: " + e.getMessage());
        }
    }
    
    public void inicializarBaseDeDatos(){
        //Primero borramos las tablas si ya existen
        String borrarGaseosa = "DROP TABLE IF EXISTS gaseosas";
        String borrarCerveza = "DROP TABLE IF EXISTS cerveza";
        
        //Creamos ambas tablas gaseosas y cerveza
        String sqlgaseosas = """
                CREATE TABLE gaseosas(
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    marca TEXT NOT NULL,
                    precio REAL NOT NULL,
                    stock INTEGER NOT NULL CHECK (stock >= 0),
                    cantidadAzucar REAL NOT NULL,
                    esZero INTEGER NOT NULL   
                                          );
                             """;
        
        String sqlcerveza = """
                CREATE TABLE IF NOT EXISTS cerveza(
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    marca TEXT NOT NULL,
                    precio REAL NOT NULL,
                    stock INTEGER NOT NULL CHECK (stock >= 0),
                    graduacionAlcoholica REAL NOT NULL,
                    esRetornable INTEGER NOT NULL
                                );
                            """;
        
        try (Statement stmt = conn.createStatement()) {
        
        stmt.execute(sqlgaseosas);
        stmt.execute(sqlcerveza);
        
        System.out.println("Base de datos y tablas listas para usar.");
        
    } catch (SQLException e) {
        System.out.println("Error al crear las tablas: " + e.getMessage());
    }
    }
    
    public void insertarGaseosas(String marca,double precio,int stock,double cantidadAzucar,int esZero){
        //definimos la sentencia sql con ? como comodines para evitar inyecciones
        String sql = "INSERT INTO gaseosas (marca,precio,stock,cantidadAzucar,esZero) VALUES (?,?,?,?,?)";
        
        //Preparamos la consulta usando la conexion ya abierta
        try (PreparedStatement pstmt = this.conn.prepareStatement(sql)){
            
            //asignamos valores a nuestros ?
            pstmt.setString(1,marca);
            pstmt.setDouble(2,precio);
            pstmt.setInt(3,stock);
            pstmt.setDouble(4,cantidadAzucar);
            pstmt.setInt(5,esZero);
            
            //usamos executeupdate para modificar datos
            pstmt.executeUpdate();
            
            System.out.println("Gaseosa " + marca + " guardada en la base de datos exitosamente");
        }catch (SQLException e){
            System.out.println("Error el insertar gaseosa en la base de datos " + e.getMessage());
        }
    }
    
    public void insertarCerveza(String marca,double precio,int stock,double graduacionAlcoholica,int esRetornable){
        //defino la sentencia sql con ? para evitar inyecciones
        String sql = "Insert INTO cerveza (marca,precio,stock,graduacionAlcoholica,esRetornable) VALUES (?,?,?,?,?)";
        
        //preparamos la consulta nuevamente utilizando la conexion ya abierta
        try (PreparedStatement pstmt = this.conn.prepareStatement(sql)){
            
            //asignamos los valores a nuestros ? de cerveza
            pstmt.setString(1, marca);
            pstmt.setDouble(2, precio);
            pstmt.setInt(3,stock);
            pstmt.setDouble(4, graduacionAlcoholica);
            pstmt.setInt(5,esRetornable);
            
            //modificamos los datos
            pstmt.executeUpdate();
            
            System.out.println("Cerveza " + marca + " guardado en la base de datos exitosamente");
            
        }catch (SQLException e){
            System.out.println("Error al insertar cerveza en la base de datos " + e.getMessage());
        }
    }
    
    //metodo para actualizar el precio y stock de una gaseosa buscandola con el id
    public void actualizarGaseosa(int id,double precio,int stock){
        //definimos la sentencia sql para modificar registros ya existentes
        String sql = "UPDATE gaseosas SET precio = ?, stock = ? WHERE id = ?";
        
        //preparamos la consulta utilizando la conexion ya existente
        try (PreparedStatement pstmt = this.conn.prepareStatement(sql)){
            
            //asignamos los nuevos valores para actualizar a cada ?
            pstmt.setDouble(1, precio);
            pstmt.setInt(2,stock);
            pstmt.setInt(3,id);
            
            //realizamos execute update que devuelve cuantas filas fueron actualizadas
            int filasActualizadas = pstmt.executeUpdate();
            
            //si es mayor que 0, la actualizacion fue exitosa
            if (filasActualizadas > 0){
                System.out.println("Gaseosa actualizada exitosamente");
            }else{
                System.out.println("No se encontro ninguna gaseosa con el id " + id);
            }
        }catch (SQLException e){
            System.out.println("Error al actualizar gaseosa " + e.getMessage());
        }
    }
    
    //Metodo para actualizar el precio y stock de cerveza trabajando con su id
    public void actualizarCerveza(int id,double precio,int stock){
        //definimos la sentencia sql para modificar registros ya existentes
        String sql = "UPDATE cerveza SET precio = ?,stock = ? WHERE id = ?";
        
        //preparamos la consulta utilizando la conexion ya existente
        try (PreparedStatement pstmt = this.conn.prepareStatement(sql)){
            
            //asignamos los nuevos valores para actualizar a cada ?
            pstmt.setDouble(1, precio);
            pstmt.setInt(2,stock);
            pstmt.setInt(3,id);
            
            //realizamos execute update que devuelve cuantas filas fueron actualizadas
            int filasActualizadas = pstmt.executeUpdate();
            
            //si es mayor que 0, la actualizacion fue exitosa
            if (filasActualizadas > 0){
                System.out.println("Cerveza actualizada exitosamente");
            }else{
                System.out.println("No se encontro ninguna cerveza con el id " + id);
            }
        }catch (SQLException e){
            System.out.println("Error al actualizar cerveza " + e.getMessage());
        }
    }
    
    //Metodo para eliminar una gaseosa con su id
    public void eliminarGaseosa(int id){
        //sentencia para eliminar el registro con el id que nosotros deseemos
        String sql = "DELETE FROM gaseosas WHERE id = ?";
        
        //preparamos la consulta utilizando la instancia de la conexion
        try (PreparedStatement pstmt = this.conn.prepareStatement(sql)){
            
            //asignamos el id de gaseosa al unico comodin
            pstmt.setInt(1, id);
            
            //ejecutamos la sentencia y guardamos las filas eliminadas
            int filasEliminadas = pstmt.executeUpdate();
            
            //si las filas eliminadas son > 0 se borro exitosamente
            if (filasEliminadas > 0){
                System.out.println("La eliminacion de gaseosa fue realizada exitosamente");
            }else{
                System.out.println("La gaseosa con el id " + id + " no fue encontrada");
            }
        }catch (SQLException e){
            System.out.println("Error al eliminar gaseosa " + e.getMessage());
        }
    }
    
    //Metodo para eliminar una cerveza con su id
    public void eliminarCerveza(int id){
        //sentencia para eliminar el registro con el id que nosotros deseemos
        String sql = "DELETE FROM cerveza WHERE id = ?";
        
        //preparamos la consulta utilizando la instancia de la conexion
        try (PreparedStatement pstmt = this.conn.prepareStatement(sql)){
            
            //asignamos el id de cerveza al unico comodin
            pstmt.setInt(1, id);
            
            //ejecutamos la sentencia y guardamos las filas eliminadas
            int filasEliminadas = pstmt.executeUpdate();
            
            //si las filas eliminadas son > 0 se borro exitosamente
            if (filasEliminadas > 0){
                System.out.println("La eliminacion de cerveza fue realizada exitosamente");
            }else{
                System.out.println("La cerveza con el id " + id + " no fue encontrada");
            }
        }catch (SQLException e){
            System.out.println("Error al eliminar cerveza " + e.getMessage());
        }
    }
    
    //metodo para ver toda la tabla de gaseosas
    public void verTablaGaseosa(){
        //definimos la sentencia para leer todos los registros de la tabla
        String sql = "SELECT * FROM gaseosas";
        
        //Al no haber ? usamos statement
        //excute query devuelve un objeto resultset que contiene todas las filas de la consulta
        try (Statement stmt = this.conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            System.out.println("LISTADO DE GASEOSAS");
            
            //iteramos con while mientras queden registros
            boolean hayRegistros = false;
            while (rs.next()){
                hayRegistros = true;
                
                //extraemos los valores de cada columna utilizando el tipo de dato correspondiente
                int id = rs.getInt("id");
                String marca = rs.getString("marca");
                double precio = rs.getDouble("precio");
                int stock = rs.getInt("stock");
                double cantidadAzucar = rs.getDouble("cantidadAzucar");
                int esZero = rs.getInt("esZero");
                
                //mostramos la tabla
                System.out.println("ID: " + id + ", Marca: " + marca + ", Precio: " + precio + ", Stock: " + stock + ",Cantidad de Azcuar: " + cantidadAzucar + " Es zero(0. si, 1. no) " + esZero);
                
                //si no hay registros es que no hemos cargado gaseosas
                if (!hayRegistros){
                    System.out.println("No hay gaseosas cargadas en la base de datos");
                }
            }
        } catch (SQLException e){
            //si se produce un error
            System.out.println("Error al consultar para ver las gaseosas " + e.getMessage());
        }
    }
    
    //Metodos para ver la tabla de cerveza
    public void verTablaCerveza(){
        //definimos la sentencia para leer los registros de la tabla
        String sql = "SELECT * FROM cerveza";
        
        //Al no haber ? usamos statement
        //excute query devuelve un objeto resultset que contiene todas las filas de la consulta
        try (Statement stmt = this.conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            System.out.println("LISTADO DE CERVEZAS");
            
            //iteramos con while mientras queden registros
            boolean hayRegistros = false;
            while (rs.next()){
                hayRegistros = true;
                
                //extraemos los valores de cada columna utilizando el tipo de dato correspondiente
                int id = rs.getInt("id");
                String marca = rs.getString("marca");
                double precio = rs.getDouble("precio");
                int stock = rs.getInt("stock");
                double graduacionAlcoholica = rs.getDouble("graduacionAlcoholica");
                int esRetornable = rs.getInt("esRetornable");
                
                //mostramos la tabla
                System.out.println("ID: " + id + ", Marca: " + marca + ", Precio: " + precio + ", Stock: " + stock + ",Graduacion Alcohólica: " + graduacionAlcoholica + " Es Retornable(0. No, 1. Si) " + esRetornable);
                
                //si no hay registros es que no hemos cargado cerveza
                if (!hayRegistros){
                    System.out.println("No hay cervezas cargadas en la base de datos");
                }
            }
        } catch (SQLException e){
            //si se produce un error
            System.out.println("Error al consultar para ver las cervezas " + e.getMessage());
        }
    }
}
