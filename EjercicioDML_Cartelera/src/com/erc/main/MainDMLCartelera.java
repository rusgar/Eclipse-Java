package com.erc.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import com.erc.bdhelpers.BDDAO;
import com.erc.bdhelpers.ConexionBd;
import com.erc.helpers.CommonHelpers;
import com.erc.helpers.MenuHelpers;
import com.erc.model.tablaNacionalidades;




public class MainDMLCartelera {
	
	
	public static void main(String [] args) {
		
		
		        // CREAMOS LOS OBJETOS Y LAS VARIABLE NECESARIAS PARA TRABAJAAR
				CommonHelpers ayudaHelpers = new CommonHelpers();
				ConexionBd bd= new ConexionBd();
				BDDAO bdDao=new BDDAO();
				MenuHelpers menuHelpers= new MenuHelpers();
				String baseDatos="",usuario="",password="";
				
				// VARIABES PARA EL CONTROL DEL MENU
				boolean ejecutarPrincipal=true,ejecutarOpciones=false;
				String opcionLeida="";
				//  PETICION DE DATOS PARA LA CONEXION
				ayudaHelpers.imprimir("Introduce nombre Base de Datos:  ");
				baseDatos=ayudaHelpers.leerTeclado();
				ayudaHelpers.imprimirSalto("");
				
				ayudaHelpers.imprimir("Introduce usuario:  ");
				usuario=ayudaHelpers.leerTeclado();
				ayudaHelpers.imprimirSalto("");
				
				ayudaHelpers.imprimir("Introduce Password:  ");
				password=ayudaHelpers.leerTeclado();
				ayudaHelpers.imprimirSalto("");
				
			
				bd.setBaseDatos(baseDatos);
				bd.setUsuario(usuario);
				bd.setPassword(password);
		
		try(Connection conexion=bd.generarConexion()){
			
			while(ejecutarPrincipal) {
				MenuHelpers.imprimirMenuPrincipal(ayudaHelpers);
				opcionLeida=ayudaHelpers.leerTeclado();
				switch (opcionLeida) {
				case "1": {
					ejecutarOpciones=true;
					// bucle para ejecuacion continua del menú
					while(ejecutarOpciones) {
					menuHelpers.imprimirMenuOpciones(ayudaHelpers);
					opcionLeida=ayudaHelpers.leerTeclado();
						switch(opcionLeida) {
						
						case "0":{
							ayudaHelpers.imprimirSalto("Volvemos a la comarca");
							ejecutarOpciones=false;
							break;
						}
						case "1":{
							try {
							// pedir los valores
							ayudaHelpers.imprimirSalto("Introduzca Id de Nacionalidad:");
							int id=ayudaHelpers.stringtoInt(ayudaHelpers.leerTeclado());
							tablaNacionalidades auxUsuario=bdDao.obtenerNacionalidadesPorId(conexion, id);
							ayudaHelpers.imprimirSalto(auxUsuario.toString());
							}catch (SQLException sqlEx) {
								// TODO: handle exception
								sqlEx.printStackTrace();
							}catch (Exception e) {
								// TODO: handle exception
								e.printStackTrace();
							}
							break;
						}
						case "2":{
							// insertar
							// sql para insercion de un usuario parametrizado
							
							try{
								// pedir los valores
								ayudaHelpers.imprimirSalto("Introduzca Gentilio:");
								String gentilicio=ayudaHelpers.leerTeclado();
								ayudaHelpers.imprimirSalto("Introduzca Pais:");
								String pais=ayudaHelpers.leerTeclado();
								
								
								//aqui irían las comprobaciones de datos
								bdDao.insertarNacionalidades(conexion, gentilicio, pais);
								
							}catch(SQLException sqlEx) {
								sqlEx.printStackTrace();
							}catch(Exception ex) {
								ex.printStackTrace();
							}
							
							
							
							break;
						}
						
						case "3":{
							///actualizacion o modificacion
							
							
							try{
								// pedir los valores y la id
								ayudaHelpers.imprimirSalto("Introduce la Id de nacionalidades");
								int id=ayudaHelpers.stringtoInt(ayudaHelpers.leerTeclado());
								ayudaHelpers.imprimirSalto("Introduzca Gentilicio:");
								String gentilicio=ayudaHelpers.leerTeclado();
								ayudaHelpers.imprimirSalto("Introduzca Pais:");
								String pais=ayudaHelpers.leerTeclado();
								
								//aquí realizaría la comprobaciones si fuera necesario
								bdDao.actualizarNacionalidades(conexion, id, gentilicio, pais);
								
								
							}catch(SQLException sqlEx) {
								sqlEx.printStackTrace();
							}catch(Exception eX) {
								eX.printStackTrace();
							}
							
							break;
						}
						case "4":{
							
							try{
								// pido los datos necesarios
								ayudaHelpers.imprimirSalto("Introduce la Id de nacionalidades");
								int id=ayudaHelpers.stringtoInt(ayudaHelpers.leerTeclado());
								bdDao.borrarNacionalidadesPorId(conexion, id);
							
							}catch(SQLException sqlEx) {
								sqlEx.printStackTrace();
							}catch(Exception ex) {
								ex.printStackTrace();
							}
							
							break;
						}
						case "5": {
							try {
								ArrayList<tablaNacionalidades> listaNacionalidades=new ArrayList<tablaNacionalidades>();
								listaNacionalidades=  bdDao.listartablaNacionalidadess(conexion);
								for (int i = 0; i < listaNacionalidades.size(); i++) {
									ayudaHelpers.imprimirSalto(listaNacionalidades.get(i).toString());
								}
							} catch (SQLException sqlEx) {
								sqlEx.printStackTrace();
							} catch (Exception ex) {
								ex.printStackTrace();
							}
							break;
						}
						
						default:
							ayudaHelpers.imprimirSalto("opción no disponible");
						}
						
						
						
					}
					
					break;
				}
				case "0":{
					ayudaHelpers.imprimirSalto("Hasta luego, vamos de camino a Valinor");
					ejecutarPrincipal=false;
					break;
				
				}
				default:
					ayudaHelpers.imprimirSalto("opcion no contemplada");;
				}
				
				
				
				
			}
			
			
			
			
		}catch(SQLException sqlEX) {
			sqlEX.printStackTrace();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		
	}
	
	
	
	
	

}
