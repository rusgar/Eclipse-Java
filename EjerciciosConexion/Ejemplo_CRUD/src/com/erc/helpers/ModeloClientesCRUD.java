package com.erc.helpers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ModeloClientesCRUD {

	  private CommonHelpers helpers;
	    private Connection conexion;

	    public ModeloClientesCRUD(Connection conexion, CommonHelpers helpers) {
	        this.conexion = conexion;
	        this.helpers = helpers;
	    }
        
 
    
    private void mostrarMenu() {
        helpers.imprimirSalto("\n|************************************|");
        helpers.imprimirSalto("| \tSELECCION UNA OPCION:        |");
        helpers.imprimirSalto("| \t1. Crear cliente             |");
        helpers.imprimirSalto("| \t2. Leer clientes             |");
        helpers.imprimirSalto("| \t3. Actualizar cliente        |");
        helpers.imprimirSalto("| \t4. Eliminar cliente          |");
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
                    crearCliente();
                    break;
                case 2:
                    leerClientes();
                    break;
                case 3:
                    actualizarCliente();
                    break;
                case 4:
                    eliminarCliente();
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



    private void crearCliente() throws SQLException {
        helpers.imprimirContinuo("Creando nuevo cliente...");

        helpers.imprimirSalto("Introduce ID del usuario: ");
        int idUsuario = helpers.leerTecladoInt();

        helpers.imprimirSalto("Introduce Puntos: ");
        int puntos = helpers.leerTecladoInt();

        String sqlInsercion = "INSERT INTO clientes (id_usuario, puntos) VALUES (?, ?)";

        try (PreparedStatement insercion = conexion.prepareStatement(sqlInsercion)) {
            insercion.setInt(1, idUsuario);
            insercion.setInt(2, puntos);
            insercion.executeUpdate();
            helpers.imprimirContinuo("Cliente creado con éxito.");
        }
    }

    private void leerClientes() throws SQLException {
        helpers.imprimirContinuo("Leyendo clientes...");

        String sql = "SELECT c.id, c.puntos, u.dni, u.nombre, u.apellido FROM clientes c JOIN usuarios u ON c.id_usuario = u.id";

        try (PreparedStatement consulta = conexion.prepareStatement(sql);
             ResultSet resultado = consulta.executeQuery()) {

            while (resultado.next()) {
                helpers.imprimirSalto("ID: " + resultado.getInt("id"));
                helpers.imprimirSalto("DNI: " + resultado.getString("dni"));
                helpers.imprimirSalto("Nombre: " + resultado.getString("nombre"));
                helpers.imprimirSalto("Apellido: " + resultado.getString("apellido"));
                helpers.imprimirSalto("Puntos: " + resultado.getInt("puntos"));
                helpers.imprimirSalto("----------------------------");
            }
        }
    }

    private void actualizarCliente() throws SQLException {
        helpers.imprimirContinuo("Actualizando cliente...");

        helpers.imprimirSalto("Introduce ID del cliente a actualizar: ");
        int id = helpers.leerTecladoInt();

        helpers.imprimirSalto("Introduce nuevo Puntos: ");
        int puntos = helpers.leerTecladoInt();

        String sqlUpdate = "UPDATE clientes SET puntos = ? WHERE id = ?";

        try (PreparedStatement actualizacion = conexion.prepareStatement(sqlUpdate)) {
            actualizacion.setInt(1, puntos);
            actualizacion.setInt(2, id);
            int filasAfectadas = actualizacion.executeUpdate();
            if (filasAfectadas > 0) {
                helpers.imprimirContinuo("Cliente actualizado con éxito.");
            } else {
                helpers.imprimirContinuo("No se encontró un cliente con ese ID.");
            }
        }
    }

    private void eliminarCliente() throws SQLException {
        helpers.imprimirContinuo("Eliminando cliente...");

        helpers.imprimirSalto("Introduce ID del cliente a eliminar: ");
        int id = helpers.leerTecladoInt();

        String sqlEliminar = "DELETE FROM clientes WHERE id = ?";

        try (PreparedStatement eliminacion = conexion.prepareStatement(sqlEliminar)) {
            eliminacion.setInt(1, id);
            int filasAfectadas = eliminacion.executeUpdate();
            if (filasAfectadas > 0) {
                helpers.imprimirContinuo("Cliente eliminado con éxito.");
            } else {
                helpers.imprimirContinuo("No se encontró un cliente con ese ID.");
            }
        }
    }
}
