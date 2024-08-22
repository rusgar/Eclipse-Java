package com.erc.main;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.erc.helpers.CommonHelpers;
import com.erc.helpers.ConexionBd;

public class MainDMLClientes {

	public static void main(String[] args) {
		//DEFINICION E INICIALIAZIZACION DE VARIBALES CREANDO LOS OBEJTOS PARA LAS LLAMADAS
		CommonHelpers helpers = new CommonHelpers();
		ConexionBd bd = new ConexionBd();

		String baseDatos = "", usuario = "", password = "";
		// SIGUEINTE PASO LOS SOLICITO Y LOS GUARDO, LOS CAMPOS PARA LA CONEXION
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

		try (Connection conexion = bd.generarConexion();
				Statement statement = conexion.createStatement()) {

			helpers.imprimirContinuo("Conexión realizada");

			// TRES INSERCIONES A LA TABLA CLIENTE
			String insercionCliente1 = "INSERT INTO clientes (puntos, id_usuario) VALUES (100, 2);";
			String insercionCliente2 = "INSERT INTO clientes (puntos, id_usuario) VALUES (200, 3);";
			String insercionCliente3 = "INSERT INTO clientes (puntos, id_usuario) VALUES (300, 3);";

			int filasAfectadas = statement.executeUpdate(insercionCliente1);
			if (filasAfectadas > 0) {
				helpers.imprimirContinuo("\nInserción primera realizada");
			} else {
				helpers.imprimirContinuo("\nError en la inserción primera");
			}

			filasAfectadas = statement.executeUpdate(insercionCliente2);
			if (filasAfectadas > 0) {
				helpers.imprimirContinuo("\nInserción segunda realizada");
			} else {
				helpers.imprimirContinuo("\nError en la inserción segunda");
			}

			filasAfectadas = statement.executeUpdate(insercionCliente3);
			if (filasAfectadas > 0) {
				helpers.imprimirContinuo("\nInserción tercera realizada");
			} else {
				helpers.imprimirContinuo("\nError en la inserción tercera");
			}

			// DOS UPDATE DE LA TABLA CLIENTES
			String actualizarCliente1 = "UPDATE clientes SET puntos = 150 WHERE id = 2;";
			String actualizarCliente2 = "UPDATE clientes SET puntos = 250 WHERE id = 3;";

			filasAfectadas = statement.executeUpdate(actualizarCliente1);
			if (filasAfectadas > 0) {
				helpers.imprimirContinuo("\nActualización del primer cliente realizada");
			} else {
				helpers.imprimirContinuo("\nError en la actualización en el primer cliente");
			}

			filasAfectadas = statement.executeUpdate(actualizarCliente2);
			if (filasAfectadas > 0) {
				helpers.imprimirContinuo("\nActualización del segundo cliente realizada");
			} else {
				helpers.imprimirContinuo("\nError en la actualización del segundo cliente");
			}

			// BORRAR UN CLIENTE DE LA TABLA
			String borradoCliente = "DELETE FROM clientes WHERE id = 3;";
			filasAfectadas = statement.executeUpdate(borradoCliente);

			if (filasAfectadas > 0) {
				helpers.imprimirContinuo("\nBorrado realizado del cliente con id=3");
			} else {
				helpers.imprimirContinuo("\nError en el borrado sobre el cliente seleccionado");
			}

		} catch (SQLException sqlException) {
			bd.muestraErrorSQL(sqlException);
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}
}
