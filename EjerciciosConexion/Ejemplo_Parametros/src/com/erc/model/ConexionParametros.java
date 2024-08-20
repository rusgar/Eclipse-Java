package com.erc.model;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;








public class ConexionParametros {
    private String baseDatos;
    private String host;
    private String puerto;
    private String usuario;
    private String password;

    // Constructor, getters y setters
    public ConexionParametros(String baseDatos, String host, String puerto, String usuario, String password) {
        this.baseDatos = baseDatos;
        this.host = host;
        this.puerto = puerto;
        this.usuario = usuario;
        this.password = password;
    }

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






    public Connection conectar() throws SQLException {
		
        
		
		String parAdic = // PARAMTEROS DE CONFIGURACION PRA MYSQL
				"?useUnicode=true&"
				+ "useJDBCCompliantTimezoneShift"
				+ "=true&useLegacyDatetimeCode"
				+ "=false&serverTimezone=UTC";
		String urlConnection = "jdbc:mysql://"+host+":"+puerto+"/"+baseDatos+parAdic;
	
    
		// CONEXION A LA BD
		 try {
	            Connection conexion = DriverManager.getConnection(urlConnection, usuario, password);
	            System.out.println("Conexión realizada");
	            return conexion;
	        } catch (SQLException e) {
	            muestraErrorSQL(e);
	            throw e; // Re-lanzar la excepción para que el llamador pueda manejarla
	        } catch (Exception e) {
	            e.printStackTrace(System.err);
	            throw new SQLException("Error al conectar a la base de datos", e);
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
