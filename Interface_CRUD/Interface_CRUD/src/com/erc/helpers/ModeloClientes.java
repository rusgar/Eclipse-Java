package com.erc.helpers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ModeloClientes {
    private Connection conexion;
    private CommonHelpers helpers;

    public ModeloClientes(Connection conexion, CommonHelpers helpers) {
        this.conexion = conexion;
        this.helpers = helpers;
    }

    // Crear un nuevo cliente
    public void crearCliente(int puntos, int idUsuario) throws SQLException {
        String sql = "INSERT INTO clientes (puntos, id_usuario) VALUES (?, ?)";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, puntos);
            stmt.setInt(2, idUsuario);
            stmt.executeUpdate();
        }
    }

    // Leer (obtener) un cliente por su ID
    public ResultSet leerCliente(int id) throws SQLException {
        String sql = "SELECT * FROM clientes WHERE id = ?";
        PreparedStatement stmt = conexion.prepareStatement(sql);
        stmt.setInt(1, id);
        return stmt.executeQuery();
    }

    // Actualizar un cliente existente
    public void actualizarCliente(int id, int puntos, int idUsuario) throws SQLException {
        String sql = "UPDATE clientes SET puntos = ?, id_usuario = ? WHERE id = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, puntos);
            stmt.setInt(2, idUsuario);
            stmt.setInt(3, id);
            stmt.executeUpdate();
        }
    }

    // Eliminar un cliente por su ID
    public void eliminarCliente(int id) throws SQLException {
        String sql = "DELETE FROM clientes WHERE id = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
