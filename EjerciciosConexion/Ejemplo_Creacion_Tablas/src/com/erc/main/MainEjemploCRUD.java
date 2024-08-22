package com.erc.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.erc.helpers.CommonHelpers;
import com.erc.helpers.ConexionBd;

public class MainEjemploCRUD {

    private static CommonHelpers helpers;
    private static ConexionBd bd;
    private static Connection conexion;

    public static void main(String[] args) {
        inicializar();
        
        try {
            ejecutarCRUD();
        } catch (SQLException e) {
            bd.muestraErrorSQL(e);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            cerrarConexion();
        }
    }

    private static void inicializar() {
        helpers = new CommonHelpers();
        bd = new ConexionBd();

        // Configuración de la conexión
        helpers.imprimirContinuo("Introduce Base de datos: ");
        String baseDatos = helpers.leerTeclado();

        helpers.imprimirContinuo("Introduce el usuario: ");
        String usuario = helpers.leerTeclado();

        helpers.imprimirContinuo("Introduce la contraseña: ");
        String password = helpers.leerTeclado();

        bd.setBaseDatos(baseDatos);
        bd.setUsuario(usuario);
        bd.setPassword(password);

        try {
            conexion = bd.generarConexion();
            helpers.imprimirContinuo("Conexion realizada.");
        } catch (SQLException e) {
            bd.muestraErrorSQL(e);
            throw new RuntimeException("Error al establecer la conexión con la base de datos.");
        }
    }

    private static void ejecutarCRUD() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            mostrarMenu();
            int opcion = Integer.parseInt(helpers.leerTeclado());

            switch (opcion) {
                case 1:
                    crearUsuario(scanner);
                    break;
                case 2:
                    leerUsuarios();
                    break;
                case 3:
                    actualizarUsuario(scanner);
                    break;
                case 4:
                    eliminarUsuario(scanner);
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

    private static void mostrarMenu() {
        System.out.println("\nSeleccione una opción:");
        System.out.println("1. Crear usuario");
        System.out.println("2. Leer usuarios");
        System.out.println("3. Actualizar usuario");
        System.out.println("4. Eliminar usuario");
        System.out.println("5. Salir");
    }

    private static void crearUsuario(Scanner scanner) throws SQLException {
        System.out.println("Creando nuevo usuario...");

        System.out.print("Introduce DNI: ");
        String dni = helpers.leerTeclado();

        System.out.print("Introduce nombre: ");
        String nombre = helpers.leerTeclado();

        System.out.print("Introduce apellido: ");
        String apellido = helpers.leerTeclado();

        System.out.print("Introduce dirección: ");
        String direccion = helpers.leerTeclado();

        System.out.print("Introduce teléfono: ");
        String telefono = helpers.leerTeclado();

        System.out.print("Introduce email: ");
        String email = helpers.leerTeclado();

        String sql = "INSERT INTO usuarios (dni, nombre, apellido, direccion, telefono, mail) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            pstmt.setString(1, dni);
            pstmt.setString(2, nombre);
            pstmt.setString(3, apellido);
            pstmt.setString(4, direccion);
            pstmt.setString(5, telefono);
            pstmt.setString(6, email);
            pstmt.executeUpdate();
            helpers.imprimirContinuo("Usuario creado con éxito.");
        }
    }

    private static void leerUsuarios() throws SQLException {
        System.out.println("Leyendo usuarios...");

        String sql = "SELECT * FROM usuarios";

        try (PreparedStatement pstmt = conexion.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("DNI: " + rs.getString("dni"));
                System.out.println("Nombre: " + rs.getString("nombre"));
                System.out.println("Apellido: " + rs.getString("apellido"));
                System.out.println("Dirección: " + rs.getString("direccion"));
                System.out.println("Teléfono: " + rs.getString("telefono"));
                System.out.println("Email: " + rs.getString("mail"));
                System.out.println("----------------------------");
            }
        }
    }

    private static void actualizarUsuario(Scanner scanner) throws SQLException {
        System.out.println("Actualizando usuario...");

        System.out.print("Introduce ID del usuario a actualizar: ");
        int id = Integer.parseInt(helpers.leerTeclado());

        System.out.print("Introduce nuevo nombre: ");
        String nombre = helpers.leerTeclado();

        System.out.print("Introduce nuevo apellido: ");
        String apellido = helpers.leerTeclado();

        System.out.print("Introduce nueva dirección: ");
        String direccion = helpers.leerTeclado();

        System.out.print("Introduce nuevo teléfono: ");
        String telefono = helpers.leerTeclado();

        System.out.print("Introduce nuevo email: ");
        String email = helpers.leerTeclado();

        String sql = "UPDATE usuarios SET nombre = ?, apellido = ?, direccion = ?, telefono = ?, mail = ? WHERE id = ?";

        try (PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            pstmt.setString(1, nombre);
            pstmt.setString(2, apellido);
            pstmt.setString(3, direccion);
            pstmt.setString(4, telefono);
            pstmt.setString(5, email);
            pstmt.setInt(6, id);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                helpers.imprimirContinuo("Usuario actualizado con éxito.");
            } else {
                helpers.imprimirContinuo("No se encontró un usuario con ese ID.");
            }
        }
    }

    private static void eliminarUsuario(Scanner scanner) throws SQLException {
        System.out.println("Eliminando usuario...");

        System.out.print("Introduce ID del usuario a eliminar: ");
        int id = Integer.parseInt(helpers.leerTeclado());

        String sql = "DELETE FROM usuarios WHERE id = ?";

        try (PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                helpers.imprimirContinuo("Usuario eliminado con éxito.");
            } else {
                helpers.imprimirContinuo("No se encontró un usuario con ese ID.");
            }
        }
    }

    private static void cerrarConexion() {
        try {
            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
                helpers.imprimirContinuo("Conexión cerrada.");
            }
        } catch (SQLException e) {
            bd.muestraErrorSQL(e);
        }
    }
}
