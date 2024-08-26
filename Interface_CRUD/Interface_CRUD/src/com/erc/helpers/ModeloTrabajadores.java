package com.erc.helpers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ModeloTrabajadores {
    private Connection conexion;
    private CommonHelpers helpers;

    public ModeloTrabajadores(Connection conexion, CommonHelpers helpers) {
        this.conexion = conexion;
        this.helpers = helpers;
    }

    // Crear un nuevo trabajador
    public void crearTrabajador(String ss, double salario, int idUsuario) throws SQLException {
        String sql = "INSERT INTO trabajadores (ss, salario, id_usuario) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, ss);
            stmt.setDouble(2, salario);
            stmt.setInt(3, idUsuario);
            stmt.executeUpdate();
        }
    }

    // Leer (obtener) un trabajador por su ID
    public ResultSet leerTrabajador(int id) throws SQLException {
        String sql = "SELECT * FROM trabajadores WHERE id = ?";
        PreparedStatement stmt = conexion.prepareStatement(sql);
        stmt.setInt(1, id);
        return stmt.executeQuery();
    }

    // Actualizar un trabajador existente
    public void actualizarTrabajador(int id, String ss, double salario, int idUsuario) throws SQLException {
        String sql = "UPDATE trabajadores SET ss = ?, salario = ?, id_usuario = ? WHERE id = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, ss);
            stmt.setDouble(2, salario);
            stmt.setInt(3, idUsuario);
            stmt.setInt(4, id);
            stmt.executeUpdate();
        }
    }

    // Eliminar un trabajador por su ID
    public void eliminarTrabajador(int id) throws SQLException {
        String sql = "DELETE FROM trabajadores WHERE id = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}

