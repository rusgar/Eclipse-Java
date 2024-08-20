package com.erc.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MainEjemploConexion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// PARAMETROS DE CONEXION
		String baseDatos="cine"; // NOMBRE DE LA BD A LA QUE CONECTARSE
		String host="localhost"; // DIRRECION DEL SERVIDOR o IP
		String port="3306";// PUERTO PARA LA CONEXION DE MYSQL POR DEFECTO
		String parAdic = // PARAMTEROS DE CONFIGURACION PRA MYSQL
				"?useUnicode=true&"
				+ "useJDBCCompliantTimezoneShift"
				+ "=true&useLegacyDatetimeCode"
				+ "=false&serverTimezone=UTC";
		String urlConnection = "jdbc:mysql://"+host+":"+port+"/"+baseDatos+parAdic;
		String user="root";
		String pwd="root";
		
		// CONEXION A LA BD
		try (Connection c=DriverManager.getConnection(urlConnection, user,pwd)) {
			System.out.println("Conexion realizada");
		}catch ( SQLException e) {
			muestraErrorSQL(e);
		}catch(Exception eX) {
			eX.printStackTrace(System.err);
		}



	}
	// METODO PARA MOSTRAR ERRORES
	public static void muestraErrorSQL(SQLException e) {
		System.err.println
		("SQL ERROR mensaje: " + e.getMessage());
		System.err.println
		("SQL Estado: " + e.getSQLState());
		System.err.println
		("SQL código específico: " + e.getErrorCode());

	}

}
