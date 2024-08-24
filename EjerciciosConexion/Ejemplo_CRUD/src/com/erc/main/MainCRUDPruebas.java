package com.erc.main;


import com.erc.helpers.ModeloClientesCRUD;
import com.erc.helpers.ModeloTrabajadoresCRUD;
import com.erc.helpers.ModeloUsuariosCRUD;
import com.erc.helpers.CommonHelpers;
import com.erc.helpers.ConexionBd;

import java.sql.Connection;
import java.sql.SQLException;

public class MainCRUDPruebas {

    public static void main(String[] args) {
    	CommonHelpers helpers = new CommonHelpers();
        ConexionBd bd = new ConexionBd();
        Connection conexion = null;
        boolean ejecutar = true;
        
        // SOLICITUD DE LOS DATOS DE CONEXION
        
        String baseDatos = "", usuario = "", password = "";
        
        helpers.imprimirContinuo("Introduce Base de datos: ");
        baseDatos = helpers.leerTeclado();
        helpers.imprimirSalto("");

        helpers.imprimirContinuo("Introduce el usuario: ");
        usuario = helpers.leerTeclado();
        helpers.imprimirSalto("");

        helpers.imprimirContinuo("Introduce la contraseña: ");
        password = helpers.leerTeclado();
        helpers.imprimirSalto("");

        // PASO LOS DATOS A LA AYUDA DE CONEXION
        bd.setBaseDatos(baseDatos);
        bd.setUsuario(usuario);
        bd.setPassword(password);
        
        //COMPROBAMOS LA CONEXION CON EL TRY- CATCH

        try {
            conexion = bd.generarConexion();
            helpers.imprimirContinuo("Conexion realizada.");
        } catch (SQLException e) {
            bd.muestraErrorSQL(e);
            throw new RuntimeException("Error al establecer la conexión con la base de datos.");
        }catch (Exception exception) {
            exception.printStackTrace();
        }
        
        
        
    // CREAMOS EL BUCLE PARA LLAMAR EN CADA CASO AL MODELO QUE NECESITAMOS DE GESTION DE CADA TABLA
        while (ejecutar) {
            mostrarMenuPrincipal(helpers);
            int opcion = helpers.leerTecladoInt();

            switch (opcion) {
                case 1:
                	ejecutarUsuariosCRUD(conexion, helpers);
                    break;
                case 2:
                	 ejecutarClientesCRUD(conexion, helpers);
                    break;
                case 3:
                	ejecutarTrabajadoresCRUD(conexion, helpers);
                    break;
                case 4:
                    ejecutar = false;
                    helpers.imprimirContinuo("Saliendo del programa...");
                    break;
                default:
                    helpers.imprimirContinuo("Opción no válida.");
            }
        }
        
        try {
            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
                helpers.imprimirContinuo("Conexión cerrada.");
            }
        } catch (SQLException e) {
            bd.muestraErrorSQL(e);
        }catch (Exception exception) {
            exception.printStackTrace();
        }
        
    }

    
 // CREAMOS UN MENU DONDE SELECCIONAMOS CADA TABLA SEGUN NUESTRAS NECESITADES
    private static void mostrarMenuPrincipal(CommonHelpers helpers) {
        helpers.imprimirSalto("\n|************************************|");
        helpers.imprimirSalto("| \tSELECCIONE UNA OPCIÓN:       |");
        helpers.imprimirSalto("| \t1. Gestionar Usuarios        |");
        helpers.imprimirSalto("| \t2. Gestionar Clientes        |");
        helpers.imprimirSalto("| \t3. Gestionar Trabajadores    |");
        helpers.imprimirSalto("| \t4. Salir                     |");
        helpers.imprimirSalto("|************************************|");
    }

    private static void ejecutarUsuariosCRUD(Connection conexion, CommonHelpers helpers) {
        ModeloUsuariosCRUD usuariosCRUD = new ModeloUsuariosCRUD(conexion, helpers);
        try {
            usuariosCRUD.ejecutarCRUD();
        } catch (SQLException e) {
            e.printStackTrace();
        }catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private static void ejecutarClientesCRUD(Connection conexion, CommonHelpers helpers) {
        ModeloClientesCRUD clientesCRUD = new ModeloClientesCRUD(conexion, helpers);
        try {
            clientesCRUD.ejecutarCRUD();
        } catch (SQLException e) {
            e.printStackTrace();
        }catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private static void ejecutarTrabajadoresCRUD(Connection conexion, CommonHelpers helpers) {
        ModeloTrabajadoresCRUD trabajadoresCRUD = new ModeloTrabajadoresCRUD(conexion, helpers);
        try {
            trabajadoresCRUD.ejecutarCRUD();
        } catch (SQLException e) {
            e.printStackTrace();
        }catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
