package com.erc.helpers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ModeloUsuarios {

    private Connection conexion;
    private CommonHelpers helpers;

    public ModeloUsuarios(Connection conexion, CommonHelpers helpers) {
        this.conexion = conexion;
        this.helpers = helpers;
    }

    public void crearUsuario(String dni, String nombre, String apellido, String direccion, String telefono, String mail) throws SQLException {
        String sql = "INSERT INTO usuarios (dni, nombre, apellido, direccion, telefono, mail) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, dni);
            stmt.setString(2, nombre);
            stmt.setString(3, apellido);
            stmt.setString(4, direccion);
            stmt.setString(5, telefono);
            stmt.setString(6, mail);
            stmt.executeUpdate();
        }
    }

    public ResultSet leerUsuarios() throws SQLException {
        helpers.imprimirContinuo("Leyendo usuarios...");

        String sql = "SELECT * FROM usuarios";
        PreparedStatement stmt = conexion.prepareStatement(sql);
        return stmt.executeQuery();

       
    }


    public void actualizarUsuario(int id, String dni, String nombre, String apellido, String direccion, String telefono, String mail) throws SQLException {
        String sql = "UPDATE usuarios SET dni = ?, nombre = ?, apellido = ?, direccion = ?, telefono = ?, mail = ? WHERE id = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, dni);
            stmt.setString(2, nombre);
            stmt.setString(3, apellido);
            stmt.setString(4, direccion);
            stmt.setString(5, telefono);
            stmt.setString(6, mail);
            stmt.setInt(7, id);
            stmt.executeUpdate();
        }
    }

    public void eliminarUsuario(int id) throws SQLException {
        String sql = "DELETE FROM usuarios WHERE id = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    public ResultSet buscarUsuarioPorID(int id) throws SQLException {
        String sql = "SELECT * FROM usuarios WHERE id = ?";
        PreparedStatement stmt = conexion.prepareStatement(sql);
        stmt.setInt(1, id); // Asigna el ID al parámetro de la consulta
        return stmt.executeQuery();
    }
}
