package com.erc.main;


import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.erc.helpers.CommonHelpers;
import com.erc.helpers.ConexionBd;

public class MainEjemploCreacionTablas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//DEFINICION E INICIALIAZIZACION DE VARIBALES CREANDO LOS OBEJTOS PARA LAS LLAMADAS
		CommonHelpers helpers= new CommonHelpers();
		ConexionBd bd= new ConexionBd();

		String baseDatos= "", usuario="",password ="";
		// SIGUEINTE PASO LOS SOLICITO Y LOS GUARDO, LOS CAMPOS PARA LA CONEXION

		helpers.imprimirContinuo("Introduce Base de datos: ");		 
		baseDatos=helpers.leerTeclado();
		helpers.imprimirSalto("");

		helpers.imprimirContinuo("Introduce el usuario: ");
		usuario=helpers.leerTeclado();
		helpers.imprimirSalto("");

		helpers.imprimirContinuo("Introduce la contraseña: ");
		password=helpers.leerTeclado();
		helpers.imprimirSalto("");

		// PASO LOS DATOS A LA AYUDA DE CONEXION
		bd.setBaseDatos(baseDatos);
		bd.setUsuario(usuario);
		bd.setPassword(password);

		try(Connection conexion= bd.generarConexion();
				Statement statement= conexion.createStatement()){

			helpers.imprimirContinuo("Conexion realizada	");	
			
			String dropTrabajadores = "DROP TABLE IF EXISTS trabajadores;";			
			String dropClientes = "DROP TABLE IF EXISTS clientes;";			
			String dropUsuarios = "DROP TABLE IF EXISTS usuarios;";
			
			statement.execute(dropClientes);
			statement.execute(dropTrabajadores);
			statement.execute(dropUsuarios);
			
			helpers.imprimirContinuo("Las tablas han sido borradas	");				



			String creacionTablaUsuarios="CREATE TABLE IF NOT EXISTS usuarios"
					+ "(id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,"
					+ "dni CHAR(9) NOT NULL UNIQUE,"
					+ "nombre VARCHAR(30) NOT NULL,"
					+ "apellido VARCHAR(80) NOT NULL,"
					+ "direccion VARCHAR(150) NOT NULL,"
					+ "telefono CHAR(9) NOT NULL,"
					+ "mail VARCHAR(100));";



			String creacionTablaClientes = "CREATE TABLE IF NOT EXISTS clientes"
					+ "(id INT NOT NULL AUTO_INCREMENT,"
					+ "puntos int NOT NULL,"
					+ "PRIMARY KEY(id));";


			String creacionTablaTrabajadores = "CREATE TABLE IF NOT EXISTS trabajadores"
					+ "(id INT NOT NULL AUTO_INCREMENT,"
					+ "ss CHAR(12) NOT NULL,"
					+ "salario DOUBLE,"
					+ "PRIMARY KEY(id));";

			statement.execute(creacionTablaUsuarios);
			statement.execute(creacionTablaClientes);
			statement.execute(creacionTablaTrabajadores);
			helpers.imprimirContinuo("Insercion de tablas creadas	");	


			String addColumnClientes = "ALTER TABLE clientes "
					+ "ADD COLUMN id_usuario INT, "
					+ "ADD CONSTRAINT fk_clientes_usuarios "
					+ "FOREIGN KEY (id_usuario) "
					+ "REFERENCES usuarios(id);";


			String addColumnTrabajadores = "ALTER TABLE trabajadores "
					+ "ADD COLUMN id_usuario INT, "
					+ "ADD CONSTRAINT FOREIGN KEY fk_trabajadores_id_usuario "
					+ "(id_usuario) REFERENCES usuarios(id);";

			statement.execute(addColumnClientes);
			statement.execute(addColumnTrabajadores);
			helpers.imprimirContinuo("Insercion realiada	");	
			
		
			



		} catch (SQLException sqlException ) {
			bd.muestraErrorSQL(sqlException);
		} catch(Exception exception) {
			exception.printStackTrace();
		}


	}

}
