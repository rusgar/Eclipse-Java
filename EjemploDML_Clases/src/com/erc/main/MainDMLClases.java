package com.erc.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import com.erc.bdhelpers.BDDAO;
import com.erc.bdhelpers.ConexionBd;
import com.erc.helpers.CommonHelpers;
import com.erc.helpers.MenuHelpers;
import com.erc.model.Usuario;


public class MainDMLClases {
	
	
	public static void main(String [] args) {
		
		// creo objetos y variables necesarias para trabajar
				CommonHelpers helpers = new CommonHelpers();
				ConexionBd bd= new ConexionBd();
				BDDAO bdDao=new BDDAO();
				//MenuHelpers menuHelpers= new MenuHelpers();
				String baseDatos="",usuario="",password="";
				// variables para control del menú
				boolean ejecutarPrincipal=true,ejecutarOpciones=false;// control del bucle del menú
				String opcionLeida="";
				// petición de lso datos para conexión
				helpers.imprimirSalto("Introduce nombre Base de Datos");
				baseDatos=helpers.leerTeclado();
				helpers.imprimirSalto("Introduce usuario");
				usuario=helpers.leerTeclado();
				helpers.imprimirSalto("Introduce Password");
				password=helpers.leerTeclado();
				// setear los valor en bd
				//antes de asignar deberia hacer comprobación de errores si fuera nacesaria
				bd.setBaseDatos(baseDatos);
				bd.setUsuario(usuario);
				bd.setPassword(password);
		
				try (Connection conexion = bd.generarConexion()) {

				    while (ejecutarPrincipal) {
				        MenuHelpers.imprimirMenuPrincipal(helpers);
				        opcionLeida = helpers.leerTeclado();

				        switch (opcionLeida) {
				            case "1": {
				                ejecutarOpciones = true;

				                while (ejecutarOpciones) {
				                    MenuHelpers.imprimirMenuOpciones(helpers);
				                    opcionLeida = helpers.leerTeclado();

				                    switch (opcionLeida) {
				                        case "0": {
				                            helpers.imprimirSalto("Volvemos a la comarca");
				                            ejecutarOpciones = false;
				                            break;
				                        }
				                        case "1": {
				                            try {
				                                // Pedir los valores
				                                helpers.imprimirSalto("Introduzca Id:");
				                                int id = helpers.stringtoInt(helpers.leerTeclado());
				                                Usuario auxUsuario = bdDao.obtenerUsuarioporID(conexion, id);
				                                helpers.imprimirSalto(auxUsuario.toString());
				                            } catch (SQLException sqlEx) {
				                                sqlEx.printStackTrace();
				                            } catch (Exception e) {
				                                e.printStackTrace();
				                            }
				                            break;
				                        }
				                        case "2": {
				                            try {
				                                // Pedir los valores
				                                helpers.imprimirSalto("Introduzca DNI:");
				                                String dni = helpers.leerTeclado();
				                                helpers.imprimirSalto("Introduzca Nombre:");
				                                String nombre = helpers.leerTeclado();
				                                helpers.imprimirSalto("Introduzca Apellidos:");
				                                String apellidos = helpers.leerTeclado();
				                                helpers.imprimirSalto("Introduzca Dirección:");
				                                String direccion = helpers.leerTeclado();
				                                helpers.imprimirSalto("Introduzca Teléfono:");
				                                String telefono = helpers.leerTeclado();
				                                helpers.imprimirSalto("Introduzca Email:");
				                                String email = helpers.leerTeclado();
				                                // Aquí irían las comprobaciones de datos
				                                bdDao.insertarUsuario(conexion, dni, nombre, apellidos, direccion, telefono, email);
				                            } catch (SQLException sqlEx) {
				                                sqlEx.printStackTrace();
				                            } catch (Exception ex) {
				                                ex.printStackTrace();
				                            }
				                            break;
				                        }
				                        case "3": {
				                            try {
				                                // Pedir los valores y la ID
				                                helpers.imprimirSalto("Introduce la ID:");
				                                int id = helpers.stringtoInt(helpers.leerTeclado());
				                                helpers.imprimirSalto("Introduzca DNI:");
				                                String dni = helpers.leerTeclado();
				                                helpers.imprimirSalto("Introduzca Nombre:");
				                                String nombre = helpers.leerTeclado();
				                                helpers.imprimirSalto("Introduzca Apellidos:");
				                                String apellidos = helpers.leerTeclado();
				                                helpers.imprimirSalto("Introduzca Dirección:");
				                                String direccion = helpers.leerTeclado();
				                                helpers.imprimirSalto("Introduzca Teléfono:");
				                                String telefono = helpers.leerTeclado();
				                                helpers.imprimirSalto("Introduzca Email:");
				                                String email = helpers.leerTeclado();
				                                // Aquí realizaría las comprobaciones si fuera necesario
				                                bdDao.actualizarUsuario(conexion, id, dni, nombre, apellidos, direccion, telefono, email);
				                            } catch (SQLException sqlEx) {
				                                sqlEx.printStackTrace();
				                            } catch (Exception ex) {
				                                ex.printStackTrace();
				                            }
				                            break;
				                        }
				                        case "4": {
				                            try {
				                                // Pedir los datos necesarios
				                                helpers.imprimirSalto("Introduzca la ID:");
				                                int id = helpers.stringtoInt(helpers.leerTeclado());
				                                bdDao.borrarUsuarioporId(conexion, id);
				                            } catch (SQLException sqlEx) {
				                                sqlEx.printStackTrace();
				                            } catch (Exception ex) {
				                                ex.printStackTrace();
				                            }
				                            break;
				                        }
				                        case "5": {
				                            try {
				                            	ArrayList<Usuario> listaUsuarios=new ArrayList<Usuario>();
				                            	listaUsuarios=  bdDao.listarUsuarios(conexion);
				                            	for (int i = 0; i < listaUsuarios.size(); i++) {
		                                            helpers.imprimirSalto(listaUsuarios.get(i).toString());
				                            	}
				                            } catch (SQLException sqlEx) {
				                                sqlEx.printStackTrace();
				                            } catch (Exception ex) {
				                                ex.printStackTrace();
				                            }
				                            break;
				                        }
				                        default: {
				                            helpers.imprimirSalto("Opción no disponible");
				                        }
				                    }
				                }
				                break;
				            }
				            case "0": {
				                helpers.imprimirSalto("Hasta luego, vamos de camino a Valinor");
				                ejecutarPrincipal = false;
				                break;
				            }
				            default: {
				                helpers.imprimirSalto("Opción no contemplada");
				            }
				        }
				    }

				} catch (SQLException sqlEX) {
				    sqlEX.printStackTrace();
				} catch (Exception ex) {
				    ex.printStackTrace();
				}
	
	
	
	

	}
}
