package com.erc.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionParametros {
	
    public static final String PARADIC = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	
    // ATRIBUTOS O PROPIEDADES
    private String baseDatos;
    private String host;
    private String puerto;
    private String usuario;
    private String password;
    private Connection conexion; // CONEXION DE A LA BASE DE DATOS

    // CONSTRUCTORES
    public ConexionParametros(String baseDatos, String host, String puerto, String usuario, String password) {
        this.baseDatos = baseDatos;
        this.host = host;
        this.puerto = puerto;
        this.usuario = usuario;
        this.password = password;
    }

    
    // CONSTRUCTORES POR DEFECTO CON VALORES PREDETERMINADOS
    public ConexionParametros() {
        this.host = "localhost";
        this.puerto = "3306";
    }

    // GETTERS Y SETTERS
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

    
    
    @Override
	public String toString() {
		return "ConexionParametros [baseDatos=" + baseDatos + ", host=" + host + ", puerto=" + puerto + ", usuario="
				+ usuario + ", password=" + password + ", conexion=" + conexion + "]";
	}


	public Connection conectar() throws SQLException {
        String urlConnection = "jdbc:mysql://" + host + ":" + puerto + "/" + baseDatos + PARADIC;

        try {
            conexion = DriverManager.getConnection(urlConnection, usuario, password);
            System.out.println("Conexión realizada exitosamente a " + baseDatos);
            return conexion;
        } catch (SQLException e) {
            muestraErrorSQL(e);
            throw e;
        } catch (Exception e) {
            e.printStackTrace(System.err);
            throw new SQLException("Error inesperado al conectar a la base de datos", e);
        }
    }

   
    //METODO PARA CERRAR LA CONEXION
    public void cerrarConexion() {
        if (conexion != null) {
            try {
                conexion.close();
                System.out.println("Conexión cerrada exitosamente");
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }

   
    // METODO PARA MOSTRAR ERRORES DEL SQL
    public static void muestraErrorSQL(SQLException e) {
        System.err.println("SQL ERROR mensaje: " + e.getMessage());
        System.err.println("SQL Estado: " + e.getSQLState());
        System.err.println("SQL código específico: " + e.getErrorCode());
    }
}
