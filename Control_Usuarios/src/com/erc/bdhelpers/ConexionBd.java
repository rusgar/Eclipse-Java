package com.erc.bdhelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *  CLASE QUE SE ENCARGA DE GESTIONAR LA CONEXIÓN A LA BASE DE DATOS MYSQL.
 *  PROPORCIONA MÉTODOS PARA CONFIGURAR LOS PARÁMETROS DE CONEXIÓN Y PARA GENERAR LA CONEXIÓN A LA BASE DE DATOS.
 *  @author EDU RUS
 */
public class ConexionBd {

	/** PARÁMETRO ADICIONAL UTILIZADO PARA GARANTIZAR LA COMPATIBILIDAD CON LA ZONA HORARIA
	 *  DEL SERVIDOR Y LA CODIFICACIÓN UNICODE. */
	public static final String PARADIC="?useUnicode=true&"
    		+ "useJDBCCompliantTimezoneShift"
    		+ "=true&useLegacyDatetimeCode"
    		+ "=false&serverTimezone=UTC";
	//ATRIBUTOS DEL MODELO
	private String baseDatos, host, puerto,
	usuario,password;
	
	
	// GETTER Y SETTER
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
		
		this.host = "localhost";
		this.puerto = "3306";
		this.baseDatos = "oxon3";
		this.usuario = "";
		this.password = "";
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

	
	// METODO QUE GENERA LA CONEXION
	/**
	 * GENERA UNA CONEXIÓN A LA BASE DE DATOS MYSQL UTILIZANDO LOS PARÁMETROS PROPORCIONADOS
	 * (HOST, PUERTO, BASE DE DATOS, USUARIO Y CONTRASEÑA).
	 * @return Connection
	 * @throws SQLException
	 */
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