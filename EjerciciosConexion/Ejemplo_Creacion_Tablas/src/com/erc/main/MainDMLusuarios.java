package com.erc.main;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.erc.helpers.CommonHelpers;
import com.erc.helpers.ConexionBd;

public class MainDMLusuarios {

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

			/*String InsercionUsuario =  "INSERT INTO usuarios "
					+ "(dni, nombre, apellido, direccion, telefono, mail) "
					+ "VALUES ('10101458C', 'Legolas', 'Del Bosque Oscuro', 'Palacio del arbol gordo 2 1',"
					+ " '999999999', '');";*/
			String InsercionUsuario =  "INSERT INTO usuarios "
					+ "(dni, nombre, apellido, direccion, telefono, mail) "
					+ "VALUES ('10000458C', 'Legolas', 'Del Bosque Claro', 'Palacio del arbol gordo 2 1',"
					+ " '999999999', '');";

			int filasAfectadas = statement.executeUpdate(InsercionUsuario);
			
			if (filasAfectadas > 0) {
				helpers.imprimirContinuo("Insercion realizada");
			} else {
				helpers.imprimirContinuo("Loser no se inserto");
			}
			

            String actualizarUsuario="update usuarios set nombre= 'Elrond' "
            		+"where id=3; ";

            filasAfectadas = statement.executeUpdate(actualizarUsuario);
            if (filasAfectadas > 0) {
				helpers.imprimirContinuo("\nActualizacion realizada");
			} else {
				helpers.imprimirContinuo("Loser no se actualiazo");
			}
            
            String Borrado="DELETE FROM usuarios where id=4;";
            filasAfectadas = statement.executeUpdate(Borrado);
            
            if (filasAfectadas > 0) {
				helpers.imprimirContinuo("\nBorrado realizad0");
			} else {
				helpers.imprimirContinuo("Loser no se ha borrado");
			}


		} catch (SQLException sqlException ) {
			bd.muestraErrorSQL(sqlException);
		} catch(Exception exception) {
			exception.printStackTrace();
		}


	}
}


