package com.erc.main;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import com.erc.bdhelpers.BDDAO;
import com.erc.bdhelpers.ConexionBd;
import com.erc.helpers.CommonHelpers;
import com.erc.helpers.MenuHelpers;
import com.erc.model.tablaActores;
import com.erc.model.tablaDirectores;
import com.erc.model.tablaGeneros;
import com.erc.model.tablaNacionalidades;
import com.erc.model.tablaPeguis;
import com.erc.model.tablaPeliculas;
import com.erc.model.tablaPersonajes;
import com.erc.model.tablaPersonas;
import com.erc.model.tablaProductores;
import com.erc.model.tablaTipos;




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
			 // MENU PRINCIPAL***********************************************************************************
			//**************************************************************************************
			while(ejecutarPrincipal) {
				MenuHelpers.imprimirMenuPrincipal(ayudaHelpers);
				opcionLeida=ayudaHelpers.leerTeclado();
				switch (opcionLeida) {
				//TABLA DE NACIONALIDADES********************************************************************
				//**************************************************************************************
				case "1": {
					ejecutarOpciones=true;
					// bucle para ejecuacion continua del menú
					while(ejecutarOpciones) {
					MenuHelpers.imprimirMenuOpciones(ayudaHelpers);
					opcionLeida=ayudaHelpers.leerTeclado();
						switch(opcionLeida) {
						
						case "0":{
							ayudaHelpers.imprimirSalto("Volvemos a la comarca");
							ejecutarOpciones=false;
							break;
						}
//					 	
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
				
				// 	TABLA DE PERSONAS********************************************************************
				//**************************************************************************************
				case "2": {
				    ejecutarOpciones = true;
				    while (ejecutarOpciones) {
				        MenuHelpers.imprimirMenuOpciones(ayudaHelpers);
				        opcionLeida = ayudaHelpers.leerTeclado();
				        switch (opcionLeida) {

				            case "0": {
				                ayudaHelpers.imprimirSalto("Volvemos a la comarca");
				                ejecutarOpciones = false;
				                break;
				            }

				            case "1": {
				                try {
				                    ayudaHelpers.imprimirSalto("Introduzca Id de Persona:");
				                    int id = ayudaHelpers.stringtoInt(ayudaHelpers.leerTeclado());
				                    tablaPersonas auxPersona = bdDao.obtenerPersonasPorId(conexion, id);
				                    ayudaHelpers.imprimirSalto(auxPersona.toString());
				                } catch (SQLException sqlEx) {
				                    sqlEx.printStackTrace();
				                } catch (Exception e) {
				                    e.printStackTrace();
				                }
				                break;
				            }

				            case "2": {
				                try {
				                    ayudaHelpers.imprimirSalto("Introduzca Nombre:");
				                    String nombre = ayudaHelpers.leerTeclado();
				                    ayudaHelpers.imprimirSalto("Introduzca Apellido:");
				                    String apellido = ayudaHelpers.leerTeclado();
				                    ayudaHelpers.imprimirSalto("Introduzca Fecha de Nacimiento (yyyy-MM-dd):");
				                    Date fechaNacimiento = Date.valueOf(ayudaHelpers.leerTeclado());
				                    
				                    ayudaHelpers.imprimirSalto("Introduzca Id de Nacionalidad:");
				                    int idNacionalidad = ayudaHelpers.stringtoInt(ayudaHelpers.leerTeclado());

				                    bdDao.insertarPersonas(conexion, nombre, apellido, fechaNacimiento, idNacionalidad);

				                } catch (SQLException sqlEx) {
				                    sqlEx.printStackTrace();
				                } catch (Exception ex) {
				                    ex.printStackTrace();
				                }
				                break;
				            }

				            case "3": {
				                try {
				                    ayudaHelpers.imprimirSalto("Introduzca Id de Persona:");
				                    int id = ayudaHelpers.stringtoInt(ayudaHelpers.leerTeclado());
				                    ayudaHelpers.imprimirSalto("Introduzca Nombre :");
				                    String nombre = ayudaHelpers.leerTeclado();
				                    ayudaHelpers.imprimirSalto("Introduzca Apellido :");
				                    String apellido = ayudaHelpers.leerTeclado();
				                    ayudaHelpers.imprimirSalto("Introduzca Fecha de Nacimiento (yyyy-MM-dd):");
				                    Date fechaNacimiento = Date.valueOf(ayudaHelpers.leerTeclado());
				                    
				                    ayudaHelpers.imprimirSalto("Introduzca Id de Nacionalidad :");
				                    int idNacionalidad = ayudaHelpers.stringtoInt(ayudaHelpers.leerTeclado());

				                    bdDao.actualizarPersonas(conexion, id, nombre, apellido, fechaNacimiento, idNacionalidad);

				                } catch (SQLException sqlEx) {
				                    sqlEx.printStackTrace();
				                } catch (Exception eX) {
				                    eX.printStackTrace();
				                }
				                break;
				            }

				            case "4": {
				                try {
				                    ayudaHelpers.imprimirSalto("Introduce la Id de Persona:");
				                    int id = ayudaHelpers.stringtoInt(ayudaHelpers.leerTeclado());
				                    bdDao.borrarPersonasPorId(conexion, id);
				                } catch (SQLException sqlEx) {
				                    sqlEx.printStackTrace();
				                } catch (Exception ex) {
				                    ex.printStackTrace();
				                }
				                break;
				            }

				            case "5": {
				                try {
				                    ArrayList<tablaPersonas> listaPersonas = new ArrayList<tablaPersonas>();
				                    listaPersonas=bdDao.listarPersonas(conexion);
				                    
				                    for (int i = 0; i < listaPersonas.size(); i++) {
				                        ayudaHelpers.imprimirSalto(listaPersonas.get(i).toString());
				                    }
				                } catch (SQLException sqlEx) {
				                    sqlEx.printStackTrace();
				                } catch (Exception ex) {
				                    ex.printStackTrace();
				                }
				                break;
				            }

				            default:
				                ayudaHelpers.imprimirSalto("Opción no disponible");
				        }
				    }
				    break;
				}
                 //	TABLA DE PERSONAJES********************************************************************
				//**************************************************************************************
				case "3": {
				    ejecutarOpciones = true;
				    while (ejecutarOpciones) {
				        MenuHelpers.imprimirMenuOpciones(ayudaHelpers);
				        opcionLeida = ayudaHelpers.leerTeclado();
				        switch (opcionLeida) {

				            case "0": {
				                ayudaHelpers.imprimirSalto("Volvemos a la comarca");
				                ejecutarOpciones = false;
				                break;
				            }

				            case "1": {
				                try {
				                    ayudaHelpers.imprimirSalto("Introduzca Id de Personaje:");
				                    int id = ayudaHelpers.stringtoInt(ayudaHelpers.leerTeclado());
				                    tablaPersonajes auxPersona = bdDao.obtenerPersonajesPorId(conexion, id);
				                    ayudaHelpers.imprimirSalto(auxPersona.toString());
				                } catch (SQLException sqlEx) {
				                    sqlEx.printStackTrace();
				                } catch (Exception e) {
				                    e.printStackTrace();
				                }
				                break;
				            }

				            case "2": {
				                try {
				                    ayudaHelpers.imprimirSalto("Introduzca Nombre:");
				                    String nombre = ayudaHelpers.leerTeclado();
				                    ayudaHelpers.imprimirSalto("Introduzca Edad:");
				                    int edad = ayudaHelpers.stringtoInt(ayudaHelpers.leerTeclado());
				                    ayudaHelpers.imprimirSalto("Introduzca Descripcion del personaje:");
				                    String descripcion = ayudaHelpers.leerTeclado();				                    
				               

				                    bdDao.insertarPersonaje(conexion, nombre, edad, descripcion);

				                } catch (SQLException sqlEx) {
				                    sqlEx.printStackTrace();
				                } catch (Exception ex) {
				                    ex.printStackTrace();
				                }
				                break;
				            }

				            case "3": {
				                try {
				                    ayudaHelpers.imprimirSalto("Introduzca Id de Persona:");
				                    int id = ayudaHelpers.stringtoInt(ayudaHelpers.leerTeclado());
				                    ayudaHelpers.imprimirSalto("Introduzca Nombre:");
				                    String nombre = ayudaHelpers.leerTeclado();
				                    ayudaHelpers.imprimirSalto("Introduzca Edad:");
				                    int edad = ayudaHelpers.stringtoInt(ayudaHelpers.leerTeclado());
				                    ayudaHelpers.imprimirSalto("Introduzca Descripcion del personaje:");
				                    String descripcion = ayudaHelpers.leerTeclado();

				                    bdDao.actualizarPersonaje(conexion, id, nombre, edad, descripcion);

				                } catch (SQLException sqlEx) {
				                    sqlEx.printStackTrace();
				                } catch (Exception eX) {
				                    eX.printStackTrace();
				                }
				                break;
				            }

				            case "4": {
				                try {
				                    ayudaHelpers.imprimirSalto("Introduce la Id de Personaje:");
				                    int id = ayudaHelpers.stringtoInt(ayudaHelpers.leerTeclado());
				                    bdDao.borrarPersonajePorId(conexion, id);
				                } catch (SQLException sqlEx) {
				                    sqlEx.printStackTrace();
				                } catch (Exception ex) {
				                    ex.printStackTrace();
				                }
				                break;
				            }

				            case "5": {
				                try {
				                	
				                	
				                    ArrayList<tablaPersonajes> listaPersonas = new ArrayList<tablaPersonajes>();
				                    listaPersonas=	bdDao.listarPersonajes(conexion);
				                    for (int i = 0; i < listaPersonas.size(); i++) {
				                        ayudaHelpers.imprimirSalto(listaPersonas.get(i).toString());
				                    }
				                } catch (SQLException sqlEx) {
				                    sqlEx.printStackTrace();
				                } catch (Exception ex) {
				                    ex.printStackTrace();
				                }
				                break;
				            }

				            default:
				                ayudaHelpers.imprimirSalto("Opción no disponible");
				        }
				    }
				    break;
				}
				 //	TABLA DE TIPOS*********************************************************************************
				//**************************************************************************************
				case "4": {
				    ejecutarOpciones = true;
				    while (ejecutarOpciones) {
				        MenuHelpers.imprimirMenuOpciones(ayudaHelpers);
				        opcionLeida = ayudaHelpers.leerTeclado();
				        switch (opcionLeida) {
				            case "0": {
				                ayudaHelpers.imprimirSalto("Volvemos a la comarca");
				                ejecutarOpciones = false;
				                break;
				            }
				            case "1": {
				                try {
				                    ayudaHelpers.imprimirSalto("Introduzca Id de Tipo:");
				                    int id = ayudaHelpers.stringtoInt(ayudaHelpers.leerTeclado());
				                    tablaTipos auxTipo = bdDao.obtenerTiposPorId(conexion, id);
				                    ayudaHelpers.imprimirSalto(auxTipo.toString());
				                } catch (SQLException sqlEx) {
				                    sqlEx.printStackTrace();
				                } catch (Exception e) {
				                    e.printStackTrace();
				                }
				                break;
				            }
				            case "2": {
				                try {
				                    ayudaHelpers.imprimirSalto("Introduzca Nombre:");
				                    String nombre = ayudaHelpers.leerTeclado();

				                    bdDao.insertarTipos(conexion, nombre);

				                } catch (SQLException sqlEx) {
				                    sqlEx.printStackTrace();
				                } catch (Exception ex) {
				                    ex.printStackTrace();
				                }
				                break;
				            }
				            case "3": {
				                try {
				                    ayudaHelpers.imprimirSalto("Introduzca Id de Tipo:");
				                    int id = ayudaHelpers.stringtoInt(ayudaHelpers.leerTeclado());
				                    ayudaHelpers.imprimirSalto("Introduzca Nombre :");
				                    String nombre = ayudaHelpers.leerTeclado();

				                    bdDao.actualizarTipos(conexion, id, nombre);

				                } catch (SQLException sqlEx) {
				                    sqlEx.printStackTrace();
				                } catch (Exception eX) {
				                    eX.printStackTrace();
				                }
				                break;
				            }
				            case "4": {
				                try {
				                    ayudaHelpers.imprimirSalto("Introduce la Id de Tipo:");
				                    int id = ayudaHelpers.stringtoInt(ayudaHelpers.leerTeclado());
				                    bdDao.borrarTiposPorId(conexion, id);
				                } catch (SQLException sqlEx) {
				                    sqlEx.printStackTrace();
				                } catch (Exception ex) {
				                    ex.printStackTrace();
				                }
				                break;
				            }
				            case "5": {
				                try {
				                    ArrayList<tablaTipos> listaTipos =  new ArrayList<tablaTipos>();
				                    listaTipos=	bdDao.listarTipos(conexion);
				                    for (int i = 0; i < listaTipos.size(); i++) {
				                        ayudaHelpers.imprimirSalto(listaTipos.get(i).toString());
				                    }
				                } catch (SQLException sqlEx) {
				                    sqlEx.printStackTrace();
				                } catch (Exception ex) {
				                    ex.printStackTrace();
				                }
				                break;
				            }
				            default:
				                ayudaHelpers.imprimirSalto("Opción no disponible");
				        }
				    }
				    break;
				}

                //	TABLA DE GENEROS*********************************************************************************
				//**************************************************************************************
				case "5": {
				    ejecutarOpciones = true;
				    while (ejecutarOpciones) {
				        MenuHelpers.imprimirMenuOpciones(ayudaHelpers);
				        opcionLeida = ayudaHelpers.leerTeclado();
				        switch (opcionLeida) {
				            case "0": {
				                ayudaHelpers.imprimirSalto("Volvemos a la comarca");
				                ejecutarOpciones = false;
				                break;
				            }
				            case "1": {
				                try {
				                    ayudaHelpers.imprimirSalto("Introduzca Id del Genero:");
				                    int id = ayudaHelpers.stringtoInt(ayudaHelpers.leerTeclado());
				                    tablaGeneros auxGenero = bdDao.obtenerGenerosPorId(conexion, id);
				                    ayudaHelpers.imprimirSalto(auxGenero.toString());
				                } catch (SQLException sqlEx) {
				                    sqlEx.printStackTrace();
				                } catch (Exception e) {
				                    e.printStackTrace();
				                }
				                break;
				            }
				            case "2": {
				                try {
				                    ayudaHelpers.imprimirSalto("Introduzca Nombre:");
				                    String nombre = ayudaHelpers.leerTeclado();

				                    bdDao.insertarGeneros(conexion, nombre);

				                } catch (SQLException sqlEx) {
				                    sqlEx.printStackTrace();
				                } catch (Exception ex) {
				                    ex.printStackTrace();
				                }
				                break;
				            }
				            case "3": {
				                try {
				                    ayudaHelpers.imprimirSalto("Introduzca Id del Genero:");
				                    int id = ayudaHelpers.stringtoInt(ayudaHelpers.leerTeclado());
				                    ayudaHelpers.imprimirSalto("Introduzca Nombre :");
				                    String nombre = ayudaHelpers.leerTeclado();

				                    bdDao.actualizarGeneros(conexion, id, nombre);

				                } catch (SQLException sqlEx) {
				                    sqlEx.printStackTrace();
				                } catch (Exception eX) {
				                    eX.printStackTrace();
				                }
				                break;
				            }
				            case "4": {
				                try {
				                    ayudaHelpers.imprimirSalto("Introduce la Id del Genero:");
				                    int id = ayudaHelpers.stringtoInt(ayudaHelpers.leerTeclado());
				                    bdDao.borrarGenerosPorId(conexion, id);
				                } catch (SQLException sqlEx) {
				                    sqlEx.printStackTrace();
				                } catch (Exception ex) {
				                    ex.printStackTrace();
				                }
				                break;
				            }
				            case "5": {
				                try {
				                    ArrayList<tablaGeneros> listaGeneros =  new  ArrayList<tablaGeneros>();
				                    listaGeneros=bdDao.listarGeneros(conexion);
				                    for (int i = 0; i < listaGeneros.size(); i++) {
				                        ayudaHelpers.imprimirSalto(listaGeneros.get(i).toString());
				                    }
				                } catch (SQLException sqlEx) {
				                    sqlEx.printStackTrace();
				                } catch (Exception ex) {
				                    ex.printStackTrace();
				                }
				                break;
				            }
				            default:
				                ayudaHelpers.imprimirSalto("Opción no disponible");
				        }
				    }
				    break;
				}
				 //	TABLA DE PEGUIS********************************************************************
				//**************************************************************************************
				case "6": {
				    ejecutarOpciones = true;
				    while (ejecutarOpciones) {
				        MenuHelpers.imprimirMenuOpciones(ayudaHelpers);
				        opcionLeida = ayudaHelpers.leerTeclado();
				        switch (opcionLeida) {

				            case "0": {
				                ayudaHelpers.imprimirSalto("Volvemos a la comarca");
				                ejecutarOpciones = false;
				                break;
				            }

				            case "1": {
				                try {
				                    ayudaHelpers.imprimirSalto("Introduzca Id del Pegui:");
				                    int id = ayudaHelpers.stringtoInt(ayudaHelpers.leerTeclado());
				                    tablaPeguis auxPeguis = bdDao.obtenerPeguis(conexion, id);
				                    ayudaHelpers.imprimirSalto(auxPeguis.toString());
				                } catch (SQLException sqlEx) {
				                    sqlEx.printStackTrace();
				                } catch (Exception e) {
				                    e.printStackTrace();
				                }
				                break;
				            }

				            case "2": {
				                try {
				                    ayudaHelpers.imprimirSalto("Introduzca Nombre:");
				                    String nombre = ayudaHelpers.leerTeclado();
				                    ayudaHelpers.imprimirSalto("Introduzca Edad:");
				                    int edad = ayudaHelpers.stringtoInt(ayudaHelpers.leerTeclado());
				                    				                    
				               

				                    bdDao.insertarPeguis(conexion, nombre, edad);
				                } catch (SQLException sqlEx) {
				                    sqlEx.printStackTrace();
				                } catch (Exception ex) {
				                    ex.printStackTrace();
				                }
				                break;
				            }

				            case "3": {
				                try {
				                    ayudaHelpers.imprimirSalto("Introduzca Id del Peguis:");
				                    int id = ayudaHelpers.stringtoInt(ayudaHelpers.leerTeclado());
				                    ayudaHelpers.imprimirSalto("Introduzca Nombre:");
				                    String nombre = ayudaHelpers.leerTeclado();
				                    ayudaHelpers.imprimirSalto("Introduzca Edad:");
				                    int edad = ayudaHelpers.stringtoInt(ayudaHelpers.leerTeclado());
				                   

				                    bdDao.actualizarPeguis(conexion, id, nombre, edad);

				                } catch (SQLException sqlEx) {
				                    sqlEx.printStackTrace();
				                } catch (Exception eX) {
				                    eX.printStackTrace();
				                }
				                break;
				            }

				            case "4": {
				                try {
				                    ayudaHelpers.imprimirSalto("Introduce la Id del Peguis:");
				                    int id = ayudaHelpers.stringtoInt(ayudaHelpers.leerTeclado());
				                    bdDao.borrarPeguisPorId(conexion, id);
				                } catch (SQLException sqlEx) {
				                    sqlEx.printStackTrace();
				                } catch (Exception ex) {
				                    ex.printStackTrace();
				                }
				                break;
				            }

				            case "5": {
				                try {
				                	
				                	
				                    ArrayList<tablaPeguis> listaPeguis = new ArrayList<tablaPeguis>();
				                    listaPeguis=	bdDao.listarPeguis(conexion);
				                    for (int i = 0; i < listaPeguis.size(); i++) {
				                        ayudaHelpers.imprimirSalto(listaPeguis.get(i).toString());
				                    }
				                } catch (SQLException sqlEx) {
				                    sqlEx.printStackTrace();
				                } catch (Exception ex) {
				                    ex.printStackTrace();
				                }
				                break;
				            }

				            default:
				                ayudaHelpers.imprimirSalto("Opción no disponible");
				        }
				    }
				    break;
				}
				
				// *******************************TABLA DIRECTORES**********************************
				//**************************************************************************************
				case "7": {
				    ejecutarOpciones = true;
				    while (ejecutarOpciones) {
				        MenuHelpers.imprimirMenuOpciones(ayudaHelpers);
				        opcionLeida = ayudaHelpers.leerTeclado();
				        switch (opcionLeida) {

				            case "0": {
				                ayudaHelpers.imprimirSalto("Volvemos a la comarca");
				                ejecutarOpciones = false;
				                break;
				            }

				            case "1": {
				                try {
				                    ayudaHelpers.imprimirSalto("Introduzca Id del Director:");
				                    int id = ayudaHelpers.stringtoInt(ayudaHelpers.leerTeclado());
				                    tablaDirectores auxDirectores = bdDao.obtenerDirectoresPorId(conexion, id);
				                    ayudaHelpers.imprimirSalto(auxDirectores.toString());
				                } catch (SQLException sqlEx) {
				                    sqlEx.printStackTrace();
				                } catch (Exception e) {
				                    e.printStackTrace();
				                }
				                break;
				            }

				            case "2": {
				                try {
				                    ayudaHelpers.imprimirSalto("Introduzca el  Alma Mater del director:");
				                    String almaMater = ayudaHelpers.leerTeclado();
				                    ayudaHelpers.imprimirSalto("Introduzca Id de Persona:");
				                    int idPersona = ayudaHelpers.stringtoInt(ayudaHelpers.leerTeclado());

				                    bdDao.insertarDirectores(conexion, almaMater, idPersona);
				                } catch (SQLException sqlEx) {
				                    sqlEx.printStackTrace();
				                } catch (Exception ex) {
				                    ex.printStackTrace();
				                }
				                break;
				            }

				            case "3": {
				                try {
				                    ayudaHelpers.imprimirSalto("Introduzca Id del Director:");
				                    int id = ayudaHelpers.stringtoInt(ayudaHelpers.leerTeclado());
				                    ayudaHelpers.imprimirSalto("Introduzca Alma Mater :");
				                    String almaMater = ayudaHelpers.leerTeclado();
				                    ayudaHelpers.imprimirSalto("Introduzca Id de Persona :");
				                    int idPersona = ayudaHelpers.stringtoInt(ayudaHelpers.leerTeclado());

				                    bdDao.actualizarDirectores(conexion, id, almaMater, idPersona);
				                } catch (SQLException sqlEx) {
				                    sqlEx.printStackTrace();
				                } catch (Exception eX) {
				                    eX.printStackTrace();
				                }
				                break;
				            }

				            case "4": {
				                try {
				                    ayudaHelpers.imprimirSalto("Introduce la Id de Director:");
				                    int id = ayudaHelpers.stringtoInt(ayudaHelpers.leerTeclado());
				                    bdDao.borrarDirectoresPorId(conexion, id);
				                } catch (SQLException sqlEx) {
				                    sqlEx.printStackTrace();
				                } catch (Exception ex) {
				                    ex.printStackTrace();
				                }
				                break;
				            }

				            case "5": {
				                try {
				                    ArrayList<tablaDirectores> listaDirectores = new ArrayList<tablaDirectores>();
				                    listaDirectores = bdDao.listarDirectores(conexion);
				                    for (int i = 0; i < listaDirectores.size(); i++) {
				                        ayudaHelpers.imprimirSalto(listaDirectores.get(i).toString());
				                    }
				                } catch (SQLException sqlEx) {
				                    sqlEx.printStackTrace();
				                } catch (Exception ex) {
				                    ex.printStackTrace();
				                }
				                break;
				            }

				            default:
				                ayudaHelpers.imprimirSalto("Opción no disponible");
				        }
				    }
				    break;
				}

				// ********************************* CRUD DE ACTORES ******************************
				// **************************************************************************************

				case "8": {
				    ejecutarOpciones = true;
				    while (ejecutarOpciones) {
				        MenuHelpers.imprimirMenuOpciones(ayudaHelpers);
				        opcionLeida = ayudaHelpers.leerTeclado();
				        switch (opcionLeida) {

				            case "0": {
				                ayudaHelpers.imprimirSalto("Volvemos a la comarca");
				                ejecutarOpciones = false;
				                break;
				            }

				            case "1": {
				                try {
				                    ayudaHelpers.imprimirSalto("Introduzca Id del Actor:");
				                    int id = ayudaHelpers.stringtoInt(ayudaHelpers.leerTeclado());
				                    tablaActores auxActores = bdDao.obtenerActoresPorId(conexion, id);
				                    ayudaHelpers.imprimirSalto(auxActores.toString());
				                } catch (SQLException sqlEx) {
				                    sqlEx.printStackTrace();
				                } catch (Exception e) {
				                    e.printStackTrace();
				                }
				                break;
				            }

				            case "2": {
				                try {
				                    ayudaHelpers.imprimirSalto("Introduzca el Salario del actor:");
				                    double salario = ayudaHelpers.stringToDouble(ayudaHelpers.leerTeclado());
				                    ayudaHelpers.imprimirSalto("Introduzca Id de Persona:");
				                    int idPersona = ayudaHelpers.stringtoInt(ayudaHelpers.leerTeclado());

				                    bdDao.insertarActores(conexion, salario, idPersona);
				                } catch (SQLException sqlEx) {
				                    sqlEx.printStackTrace();
				                } catch (Exception ex) {
				                    ex.printStackTrace();
				                }
				                break;
				            }

				            case "3": {
				                try {
				                    ayudaHelpers.imprimirSalto("Introduzca Id del Actor:");
				                    int id = ayudaHelpers.stringtoInt(ayudaHelpers.leerTeclado());
				                    ayudaHelpers.imprimirSalto("Introduzca Salario:");
				                    double salario = ayudaHelpers.stringToDouble(ayudaHelpers.leerTeclado());
				                    ayudaHelpers.imprimirSalto("Introduzca Id de Persona:");
				                    int idPersona = ayudaHelpers.stringtoInt(ayudaHelpers.leerTeclado());

				                    bdDao.actualizarActores(conexion, id, salario, idPersona);
				                } catch (SQLException sqlEx) {
				                    sqlEx.printStackTrace();
				                } catch (Exception eX) {
				                    eX.printStackTrace();
				                }
				                break;
				            }

				            case "4": {
				                try {
				                    ayudaHelpers.imprimirSalto("Introduce la Id del Actor:");
				                    int id = ayudaHelpers.stringtoInt(ayudaHelpers.leerTeclado());
				                    bdDao.borrarActoresPorId(conexion, id);
				                } catch (SQLException sqlEx) {
				                    sqlEx.printStackTrace();
				                } catch (Exception ex) {
				                    ex.printStackTrace();
				                }
				                break;
				            }

				            case "5": {
				                try {
				                    ArrayList<tablaActores> listadoActores = new ArrayList<tablaActores>();
				                    listadoActores = bdDao.listardoActores(conexion);
				                    for (int i = 0; i < listadoActores.size(); i++) {
				                        ayudaHelpers.imprimirSalto(listadoActores.get(i).toString());
				                    }
				                } catch (SQLException sqlEx) {
				                    sqlEx.printStackTrace();
				                } catch (Exception ex) {
				                    ex.printStackTrace();
				                }
				                break;
				            }

				            default:
				                ayudaHelpers.imprimirSalto("Opción no disponible");
				        }
				    }
				    break;
				}
				// ********************************* CRUD DE PRODUCTORES ******************************
				// **************************************************************************************

				case "9": {
				    ejecutarOpciones = true;
				    while (ejecutarOpciones) {
				        MenuHelpers.imprimirMenuOpciones(ayudaHelpers);
				        opcionLeida = ayudaHelpers.leerTeclado();
				        switch (opcionLeida) {

				            case "0": {
				                ayudaHelpers.imprimirSalto("Volvemos a la comarca");
				                ejecutarOpciones = false;
				                break;
				            }

				            case "1": {
				                try {
				                    ayudaHelpers.imprimirSalto("Introduzca Id del Productor:");
				                    int id = ayudaHelpers.stringtoInt(ayudaHelpers.leerTeclado());
				                    tablaProductores auxProductores = bdDao.obtenerProductoresPorId(conexion, id);
				                    ayudaHelpers.imprimirSalto(auxProductores.toString());
				                } catch (SQLException sqlEx) {
				                    sqlEx.printStackTrace();
				                } catch (Exception e) {
				                    e.printStackTrace();
				                }
				                break;
				            }

				            case "2": {
				                try {
				                    ayudaHelpers.imprimirSalto("Introduzca la Inversión del productor:");
				                    double inversion = ayudaHelpers.stringToDouble(ayudaHelpers.leerTeclado());
				                    ayudaHelpers.imprimirSalto("Introduzca Id de la Persona:");
				                    int idPersona = ayudaHelpers.stringtoInt(ayudaHelpers.leerTeclado());

				                    bdDao.insertarProductores(conexion, inversion, idPersona);
				                } catch (SQLException sqlEx) {
				                    sqlEx.printStackTrace();
				                } catch (Exception ex) {
				                    ex.printStackTrace();
				                }
				                break;
				            }

				            case "3": {
				                try {
				                    ayudaHelpers.imprimirSalto("Introduzca Id del Productor:");
				                    int id = ayudaHelpers.stringtoInt(ayudaHelpers.leerTeclado());
				                    ayudaHelpers.imprimirSalto("Introduzca Inversión:");
				                    double inversion = ayudaHelpers.stringToDouble(ayudaHelpers.leerTeclado());
				                    ayudaHelpers.imprimirSalto("Introduzca Id de la Persona:");
				                    int idPersona = ayudaHelpers.stringtoInt(ayudaHelpers.leerTeclado());

				                    bdDao.actualizarProductores(conexion, id, inversion, idPersona);
				                } catch (SQLException sqlEx) {
				                    sqlEx.printStackTrace();
				                } catch (Exception eX) {
				                    eX.printStackTrace();
				                }
				                break;
				            }

				            case "4": {
				                try {
				                    ayudaHelpers.imprimirSalto("Introduce la Id del Productor:");
				                    int id = ayudaHelpers.stringtoInt(ayudaHelpers.leerTeclado());
				                    bdDao.borrarProductoresPorId(conexion, id);
				                } catch (SQLException sqlEx) {
				                    sqlEx.printStackTrace();
				                } catch (Exception ex) {
				                    ex.printStackTrace();
				                }
				                break;
				            }

				            case "5": {
				                try {
				                	ArrayList<tablaProductores> listadoProductores = new ArrayList<tablaProductores>();
				                    listadoProductores = bdDao.listarProductores(conexion);
				                    for (int i = 0; i < listadoProductores.size(); i++) {
				                        ayudaHelpers.imprimirSalto(listadoProductores.get(i).toString());
				                    }
				                } catch (SQLException sqlEx) {
				                    sqlEx.printStackTrace();
				                } catch (Exception ex) {
				                    ex.printStackTrace();
				                }
				                break;
				            }

				            default:
				                ayudaHelpers.imprimirSalto("Opción no disponible");
				        }
				    }
				    break;
				}
				// ********************************* CRUD DE PELICULAS******************************
				// **************************************************************************************
				
				case "10": {  
				    ejecutarOpciones = true;
				    while (ejecutarOpciones) {
				        MenuHelpers.imprimirMenuOpciones(ayudaHelpers);
				        opcionLeida = ayudaHelpers.leerTeclado();
				        switch (opcionLeida) {

				            case "0": {
				                ayudaHelpers.imprimirSalto("Volvemos a la comarca");
				                ejecutarOpciones = false;
				                break;
				            }

				            case "1": {
				                try {
				                    ayudaHelpers.imprimirSalto("Introduzca Id de la Película:");
				                    int id = ayudaHelpers.stringtoInt(ayudaHelpers.leerTeclado());
				                    tablaPeliculas auxPelicula = bdDao.obtenerPeliculaPorId(conexion, id);
				                    ayudaHelpers.imprimirSalto(auxPelicula.toString());
				                } catch (SQLException sqlEx) {
				                    sqlEx.printStackTrace();
				                } catch (Exception e) {
				                    e.printStackTrace();
				                }
				                break;
				            }

				            case "2": {
				                try {
				                    ayudaHelpers.imprimirSalto("Introduzca el Título de la Película:");
				                    String titulo = ayudaHelpers.leerTeclado();
				                    ayudaHelpers.imprimirSalto("Introduzca la Fecha de la Película (YYYY-MM-DD):");
				                    Date fecha = Date.valueOf(ayudaHelpers.leerTeclado());
				                    ayudaHelpers.imprimirSalto("Introduzca la Duración de la Película:");
				                    int duracion = ayudaHelpers.stringtoInt(ayudaHelpers.leerTeclado());
				                    ayudaHelpers.imprimirSalto("Introduzca Id del Director:");
				                    int id_director = ayudaHelpers.stringtoInt(ayudaHelpers.leerTeclado());
				                    ayudaHelpers.imprimirSalto("Introduzca Id del Productor:");
				                    int id_productor = ayudaHelpers.stringtoInt(ayudaHelpers.leerTeclado());
				                    ayudaHelpers.imprimirSalto("Introduzca Id de PEGUI:");
				                    int id_pegui = ayudaHelpers.stringtoInt(ayudaHelpers.leerTeclado());

				                    bdDao.insertarPelicula(conexion, titulo, fecha, duracion, id_director, id_productor, id_pegui);
				                } catch (SQLException sqlEx) {
				                    sqlEx.printStackTrace();
				                } catch (Exception ex) {
				                    ex.printStackTrace();
				                }
				                break;
				            }

				            case "3": {
				                try {
				                    ayudaHelpers.imprimirSalto("Introduzca Id de la Película:");
				                    int id = ayudaHelpers.stringtoInt(ayudaHelpers.leerTeclado());
				                    ayudaHelpers.imprimirSalto("Introduzca el Título de la Película:");
				                    String titulo = ayudaHelpers.leerTeclado();
				                    ayudaHelpers.imprimirSalto("Introduzca la Fecha de la Película (YYYY-MM-DD):");
				                    Date fecha = Date.valueOf(ayudaHelpers.leerTeclado());
				                    ayudaHelpers.imprimirSalto("Introduzca la Duración de la Película:");
				                    int duracion = ayudaHelpers.stringtoInt(ayudaHelpers.leerTeclado());
				                    ayudaHelpers.imprimirSalto("Introduzca Id del Director:");
				                    int id_director = ayudaHelpers.stringtoInt(ayudaHelpers.leerTeclado());
				                    ayudaHelpers.imprimirSalto("Introduzca Id del Productor:");
				                    int id_productor = ayudaHelpers.stringtoInt(ayudaHelpers.leerTeclado());
				                    ayudaHelpers.imprimirSalto("Introduzca Id de PEGUI:");
				                    int id_pegui = ayudaHelpers.stringtoInt(ayudaHelpers.leerTeclado());

				                    bdDao.actualizarPeliculas(conexion, id, titulo, fecha, duracion, id_director, id_productor, id_pegui);
				                } catch (SQLException sqlEx) {
				                    sqlEx.printStackTrace();
				                } catch (Exception eX) {
				                    eX.printStackTrace();
				                }
				                break;
				            }

				            case "4": {
				                try {
				                    ayudaHelpers.imprimirSalto("Introduce la Id de la Película:");
				                    int id = ayudaHelpers.stringtoInt(ayudaHelpers.leerTeclado());
				                    bdDao.borrarPeliculaPorId(conexion, id);
				                } catch (SQLException sqlEx) {
				                    sqlEx.printStackTrace();
				                } catch (Exception ex) {
				                    ex.printStackTrace();
				                }
				                break;
				            }

				            case "5": {
				                try {
				                    ArrayList<tablaPeliculas> listadoPeliculas = bdDao.listarPeliculas(conexion);
				                    for (tablaPeliculas pelicula : listadoPeliculas) {
				                        ayudaHelpers.imprimirSalto(pelicula.toString());
				                    }
				                } catch (SQLException sqlEx) {
				                    sqlEx.printStackTrace();
				                } catch (Exception ex) {
				                    ex.printStackTrace();
				                }
				                break;
				            }

				            default:
				                ayudaHelpers.imprimirSalto("Opción no disponible");
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
