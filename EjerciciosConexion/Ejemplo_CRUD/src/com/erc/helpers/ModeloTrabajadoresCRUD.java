package com.erc.helpers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ModeloTrabajadoresCRUD {

	private CommonHelpers helpers;
    private Connection conexion;

    public ModeloTrabajadoresCRUD(Connection conexion, CommonHelpers helpers) {
        this.conexion = conexion;
        this.helpers = helpers;
    }
 

    private void mostrarMenu() {
        helpers.imprimirSalto("\n|************************************|");
        helpers.imprimirSalto("| \tSELECCION UNA OPCION:        |");
        helpers.imprimirSalto("| \t1. Crear trabajador          |");
        helpers.imprimirSalto("| \t2. Leer trabajadores         |");
        helpers.imprimirSalto("| \t3. Actualizar trabajador     |");
        helpers.imprimirSalto("| \t4. Eliminar trabajador       |");
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
                    crearTrabajador();
                    break;
                case 2:
                    leerTrabajadores();
                    break;
                case 3:
                    actualizarTrabajador();
                    break;
                case 4:
                    eliminarTrabajador();
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

  

    private void crearTrabajador() throws SQLException {
        helpers.imprimirContinuo("Creando nuevo trabajador...");

        helpers.imprimirSalto("Introduce ID del usuario: ");
        int idUsuario = helpers.leerTecladoInt();

        helpers.imprimirSalto("Introduce Número de Seguridad Social: ");
        String ss = helpers.leerTeclado();

        helpers.imprimirSalto("Introduce Salario: ");
        double salario = helpers.leerTecladoDouble();

        String sqlInsercion = "INSERT INTO trabajadores (id_usuario, ss, salario) VALUES (?, ?, ?)";

        try (PreparedStatement insercion = conexion.prepareStatement(sqlInsercion)) {
            insercion.setInt(1, idUsuario);
            insercion.setString(2, ss);
            insercion.setDouble(3, salario);
            insercion.executeUpdate();
            helpers.imprimirContinuo("Trabajador creado con éxito.");
        }
    }

    private void leerTrabajadores() throws SQLException {
        helpers.imprimirContinuo("Leyendo trabajadores...");

        String sql = "SELECT t.id, t.ss, t.salario, u.dni, u.nombre, u.apellido FROM trabajadores t JOIN usuarios u ON t.id_usuario = u.id";

        try (PreparedStatement consulta = conexion.prepareStatement(sql);
             ResultSet resultado = consulta.executeQuery()) {

            while (resultado.next()) {
                helpers.imprimirSalto("ID: " + resultado.getInt("id"));
                helpers.imprimirSalto("DNI: " + resultado.getString("dni"));
                helpers.imprimirSalto("Nombre: " + resultado.getString("nombre"));
                helpers.imprimirSalto("Apellido: " + resultado.getString("apellido"));
                helpers.imprimirSalto("SS: " + resultado.getString("ss"));
                helpers.imprimirSalto("Salario: " + resultado.getDouble("salario"));
                helpers.imprimirSalto("----------------------------");
            }
        }
    }

    private void actualizarTrabajador() throws SQLException {
        helpers.imprimirContinuo("Actualizando trabajador...");

        helpers.imprimirSalto("Introduce ID del trabajador a actualizar: ");
        int id = helpers.leerTecladoInt();

        helpers.imprimirSalto("Introduce nuevo Número de Seguridad Social: ");
        String ss = helpers.leerTeclado();

        helpers.imprimirSalto("Introduce nuevo Salario: ");
        double salario = helpers.leerTecladoDouble();

        String sqlUpdate = "UPDATE trabajadores SET ss = ?, salario = ? WHERE id = ?";

        try (PreparedStatement actualizacion = conexion.prepareStatement(sqlUpdate)) {
            actualizacion.setString(1, ss);
            actualizacion.setDouble(2, salario);
            actualizacion.setInt(3, id);
            int filasAfectadas = actualizacion.executeUpdate();
            if (filasAfectadas > 0) {
                helpers.imprimirContinuo("Trabajador actualizado con éxito.");
            } else {
                helpers.imprimirContinuo("No se encontró un trabajador con ese ID.");
            }
        }
    }

    private void eliminarTrabajador() throws SQLException {
        helpers.imprimirContinuo("Eliminando trabajador...");

        helpers.imprimirSalto("Introduce ID del trabajador a eliminar: ");
        int id = helpers.leerTecladoInt();

        String sqlEliminar = "DELETE FROM trabajadores WHERE id = ?";

        try (PreparedStatement eliminacion = conexion.prepareStatement(sqlEliminar)) {
            eliminacion.setInt(1, id);
            int filasAfectadas = eliminacion.executeUpdate();
            if (filasAfectadas > 0) {
                helpers.imprimirContinuo("Trabajador eliminado con éxito.");
            } else {
                helpers.imprimirContinuo("No se encontró un trabajador con ese ID.");
            }
        }
    }
}
