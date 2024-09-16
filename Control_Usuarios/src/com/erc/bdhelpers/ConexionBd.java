package com.erc.bdhelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBd {

	// constante paradic
	public static final String PARADIC="?useUnicode=true&"
    		+ "useJDBCCompliantTimezoneShift"
    		+ "=true&useLegacyDatetimeCode"
    		+ "=false&serverTimezone=UTC";
	//atributos o propiedades
	private String baseDatos, host, puerto,
	usuario,password;
	// getter y setter
	public String getBaseDatos() {
		return baseDatos;
	}
	public void setBaseDatos(String baseDatos) {
		this.baseDatos = baseDatos;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getPuerto() {
		return puerto;
	}
	public void setPuerto(String puerto) {
		this.puerto = puerto;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	//CONTRUCTOR POR DEFECTO PERO AÑADIMOS DE INICIO LOS DATOSS PARA NO PEDIRLOS
	public ConexionBd() {
		super();
		// TODO Auto-generated constructor stub
		this.host = "localhost";
		this.puerto = "3306";
		this.baseDatos = "oxon3";
		this.usuario = "root";
		this.password = "xana2120";
	}

	//CONSTRUCTOR PARAMETRIZADO
	public ConexionBd(String baseDatos, String host, String puerto, String usuario, String password) {
		super();
		this.baseDatos = baseDatos;
		this.host = host;
		this.puerto = puerto;
		this.usuario = usuario;
		this.password = password;
	}

	
	// METODO QUE GENERAQ LA CONEXION
	public Connection generarConexion()throws SQLException {
		Connection conexion;
		String urlConnection = 	"jdbc:mysql://"
	+host+":"
	+puerto+
	"/"+baseDatos
	+PARADIC;
	conexion= DriverManager.getConnection
			(urlConnection, usuario, password);
	return conexion;
	}
	
	 public void muestraErrorSQL(SQLException e) {
		    System.err.println
		    ("SQL ERROR mensaje: " + e.getMessage());
		    System.err.println
		    ("SQL Estado: " + e.getSQLState());
		    System.err.println
		    ("SQL código específico: " + e.getErrorCode());
		  }

}