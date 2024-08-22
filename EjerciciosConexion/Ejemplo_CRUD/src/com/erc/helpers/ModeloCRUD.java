package com.erc.helpers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ModeloCRUD {

    public static CommonHelpers helpers;
    public static ConexionBd bd;
    public static Connection conexion;
    
    public ModeloCRUD() {
        helpers = new CommonHelpers();
        bd = new ConexionBd();
    }

    public  void inicializar() {
    	 
        
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

        try {
            conexion = bd.generarConexion();
            helpers.imprimirContinuo("Conexion realizada.");
        } catch (SQLException e) {
            bd.muestraErrorSQL(e);
            throw new RuntimeException("Error al establecer la conexión con la base de datos.");
        }catch (Exception exception) {
            exception.printStackTrace();
        }
        
    }

    public  void cerrarConexion() {
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
    
    
    private void mostrarMenu() {
    	helpers.imprimirSalto("\n|************************************|");
    	helpers.imprimirSalto("| \tSELECCION UNA OPCION:        |");
    	helpers.imprimirSalto("| \t1. Crear usuario             |");
    	helpers.imprimirSalto("| \t2. Leer usuarios             |");
    	helpers.imprimirSalto("| \t3. Actualizar usuario        |");
    	helpers.imprimirSalto("| \t4. Eliminar usuario          |");
    	helpers.imprimirSalto("| \t5. Salir                     |");
    	helpers.imprimirSalto("|************************************|");
    }
    
    
    public void ejecutarCRUD() throws SQLException {
        
        boolean exit = false;

        while (!exit) {
            mostrarMenu();
            int opcion = helpers.leerTecladoInt();

            switch (opcion) {
                case 1:
                    crearUsuario();
                    break;
                case 2:
                    leerUsuarios();
                    break;
                case 3:
                    actualizarUsuario();
                    break;
                case 4:
                    eliminarUsuario();
                    break;
                case 5:
                    exit = true;
                    helpers.imprimirContinuo("Saliendo del programa...");
                    break;
                default:
                    helpers.imprimirContinuo("Opción no válida.");
            }
        }
    }

    
        private void crearUsuario() throws SQLException {
            helpers.imprimirContinuo("Creando nuevo usuario...");

            helpers.imprimirSalto("Introduce DNI: ");
            String dni = helpers.leerTeclado();

            helpers.imprimirSalto("Introduce nombre: ");
            String nombre = helpers.leerTeclado();

            helpers.imprimirSalto("Introduce apellido: ");
            String apellido = helpers.leerTeclado();

            helpers.imprimirSalto("Introduce dirección: ");
            String direccion = helpers.leerTeclado();

            helpers.imprimirSalto("Introduce teléfono: ");
            String telefono = helpers.leerTeclado();

            helpers.imprimirSalto("Introduce email: ");
            String email = helpers.leerTeclado();

            String sqlInsercion = "INSERT INTO usuarios (dni, nombre, apellido, direccion, telefono, mail) VALUES (?, ?, ?, ?, ?, ?)";

            try (PreparedStatement insercion = conexion.prepareStatement(sqlInsercion)) {
                insercion.setString(1, dni);
                insercion.setString(2, nombre);
                insercion.setString(3, apellido);
                insercion.setString(4, direccion);
                insercion.setString(5, telefono);
                insercion.setString(6, email);
                insercion.executeUpdate();
                helpers.imprimirContinuo("Usuario creado con éxito.");
            }
        }
        
        
        private void leerUsuarios() throws SQLException {
        	helpers.imprimirContinuo("Leyendo usuarios...");

            String sql = "SELECT * FROM usuarios";

            try (PreparedStatement actualizacion = conexion.prepareStatement(sql);
                 ResultSet resultado = actualizacion.executeQuery()) {

                while (resultado.next()) {
                	helpers.imprimirSalto("ID: " + resultado.getInt("id"));
                	helpers.imprimirSalto("DNI: " + resultado.getString("dni"));
                	helpers.imprimirSalto("Nombre: " + resultado.getString("nombre"));
                	helpers.imprimirSalto("Apellido: " + resultado.getString("apellido"));
                	helpers.imprimirSalto("Dirección: " + resultado.getString("direccion"));
                	helpers.imprimirSalto("Teléfono: " + resultado.getString("telefono"));
                	helpers.imprimirSalto("Email: " + resultado.getString("mail"));
                	helpers.imprimirSalto("----------------------------");
                }
            }
        }
        private void actualizarUsuario() throws SQLException {
        	helpers.imprimirContinuo("Actualizando usuario...");

        	helpers.imprimirSalto("Introduce ID del usuario a actualizar: ");
            int id = helpers.leerTecladoInt();

            helpers.imprimirSalto("Introduce nuevo nombre: ");
            String nombre = helpers.leerTeclado();

            helpers.imprimirSalto("Introduce nuevo apellido: ");
            String apellido = helpers.leerTeclado();

            helpers.imprimirSalto("Introduce nueva dirección: ");
            String direccion = helpers.leerTeclado();

            helpers.imprimirSalto("Introduce nuevo teléfono: ");
            String telefono = helpers.leerTeclado();

            helpers.imprimirSalto("Introduce nuevo email: ");
            String email = helpers.leerTeclado();

            String sqlUpdate = "UPDATE usuarios SET nombre = ?, apellido = ?, direccion = ?, telefono = ?, mail = ? WHERE id = ?";

            try (PreparedStatement actualizacion = conexion.prepareStatement(sqlUpdate)) {
                actualizacion.setString(1, nombre);
                actualizacion.setString(2, apellido);
                actualizacion.setString(3, direccion);
                actualizacion.setString(4, telefono);
                actualizacion.setString(5, email);
                actualizacion.setInt(6, id);
                int filasAfectadas = actualizacion.executeUpdate();
                if (filasAfectadas > 0) {
                    helpers.imprimirContinuo("Usuario actualizado con éxito.");
                } else {
                    helpers.imprimirContinuo("No se encontró un usuario con ese ID.");
                }
            }
        }
        private void eliminarUsuario() throws SQLException {
        	helpers.imprimirContinuo("Eliminando usuario...");

        	helpers.imprimirSalto("Introduce ID del usuario a eliminar: ");
            int id = helpers.leerTecladoInt();

            String sqlEliminar = "DELETE FROM usuarios WHERE id = ?";

            try (PreparedStatement eliminacion = conexion.prepareStatement(sqlEliminar)) {
                eliminacion.setInt(1, id);
                int filasAfectadas = eliminacion.executeUpdate();
                if (filasAfectadas > 0) {
                    helpers.imprimirContinuo("Usuario eliminado con éxito.");
                } else {
                    helpers.imprimirContinuo("No se encontró un usuario con ese ID.");
                }
            }
        }
}



