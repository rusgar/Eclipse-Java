package com.erc.main;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import com.erc.bdhelpers.BDDAO;
import com.erc.bdhelpers.ConexionBd;
import com.erc.helpers.CommonHelpers;
import com.erc.helpers.MenuHelpers;
import com.erc.model.tablaPaquetes;
import com.erc.model.tablaRemitentes;
import com.erc.model.tablaTarifas;

public class MainDMLEnvios {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
							ayudaHelpers.imprimirSalto("Volvemos al inicio del curso, sera posible?😉😉");
							ejecutarOpciones=false;
							break;
						}
//					 	
						case "1":{
							try {
							// pedir los valores
							ayudaHelpers.imprimirSalto("Introduzca Id de Tarifas:");
							int id=ayudaHelpers.stringtoInt(ayudaHelpers.leerTeclado());
							tablaTarifas auxUsuario=bdDao.obtenerTarifasPorId(conexion, id);
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
								ayudaHelpers.imprimirSalto("Introduzca Nombre:");
								String nombre=ayudaHelpers.leerTeclado();
								ayudaHelpers.imprimirSalto("Introduzca Precio:");
								double precio = ayudaHelpers.stringToDouble(ayudaHelpers.leerTeclado());
								precio = ayudaHelpers.redondear(precio);
								
								
								//aqui irían las comprobaciones de datos
								bdDao.insertarTarifas(conexion, nombre, precio);
								
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
								ayudaHelpers.imprimirSalto("Introduce la Id de la Tarifa");
								int id=ayudaHelpers.stringtoInt(ayudaHelpers.leerTeclado());
								ayudaHelpers.imprimirSalto("Introduzca Nombre:");
								String nombre=ayudaHelpers.leerTeclado();
								ayudaHelpers.imprimirSalto("Introduzca Precio:");
								double precio = ayudaHelpers.stringToDouble(ayudaHelpers.leerTeclado());
								precio = ayudaHelpers.redondear(precio);
								
								//aquí realizaría la comprobaciones si fuera necesario
								bdDao.actualizarTarifas(conexion, id, nombre, precio);
								
								
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
								ayudaHelpers.imprimirSalto("Introduce la Id de la tarifa");
								int id=ayudaHelpers.stringtoInt(ayudaHelpers.leerTeclado());
								bdDao.borrarTaifasPorId(conexion, id);
							
							}catch(SQLException sqlEx) {
								sqlEx.printStackTrace();
							}catch(Exception ex) {
								ex.printStackTrace();
							}
							
							break;
						}
						case "5": {
							try {
								ArrayList<tablaTarifas> listaTarifas=new ArrayList<tablaTarifas>();
								listaTarifas=  bdDao.listartablaTarifass(conexion);
								for (int i = 0; i < listaTarifas.size(); i++) {
									ayudaHelpers.imprimirSalto(listaTarifas.get(i).toString());
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
				
				case "2": {
				    ejecutarOpciones = true;
				    // bucle para ejecución continua del menú
				    while (ejecutarOpciones) {
				        MenuHelpers.imprimirMenuOpciones(ayudaHelpers);
				        opcionLeida = ayudaHelpers.leerTeclado();
				        switch (opcionLeida) {

				            case "0": {
				                ayudaHelpers.imprimirSalto("Volvemos al menú principal");
				                ejecutarOpciones = false;
				                break;
				            }

				            case "1": {
				                // Buscar Remitente por ID
				                try {
				                    ayudaHelpers.imprimirSalto("Introduzca ID del remitente:");
				                    int id = ayudaHelpers.stringtoInt(ayudaHelpers.leerTeclado());
				                    tablaRemitentes remitente = bdDao.obtenerRemitentesPorId(conexion, id);
				                    ayudaHelpers.imprimirSalto(remitente.toString());
				                } catch (SQLException sqlEx) {
				                    sqlEx.printStackTrace();
				                } catch (Exception e) {
				                    e.printStackTrace();
				                }
				                break;
				            }

				            case "2": {
				                // Insertar un nuevo remitente
				                try {
				                    ayudaHelpers.imprimirSalto("Introduzca Nombre del remitente:");
				                    String nombre = ayudaHelpers.leerTeclado();
				                    ayudaHelpers.imprimirSalto("Introduzca Apellido del remitente:");
				                    String apellido = ayudaHelpers.leerTeclado();
				                    ayudaHelpers.imprimirSalto("Introduzca Dirección del remitente:");
				                    String direccion = ayudaHelpers.leerTeclado();

				                    // Insertar el nuevo remitente
				                    bdDao.insertarRemitentes(conexion, nombre, apellido, direccion);

				                } catch (SQLException sqlEx) {
				                    sqlEx.printStackTrace();
				                } catch (Exception ex) {
				                    ex.printStackTrace();
				                }
				                break;
				            }

				            case "3": {
				                // Actualizar un remitente
				                try {
				                    ayudaHelpers.imprimirSalto("Introduzca ID del remitente a actualizar:");
				                    int id = ayudaHelpers.stringtoInt(ayudaHelpers.leerTeclado());
				                    ayudaHelpers.imprimirSalto("Introduzca nuevo Nombre (dejar en blanco para no cambiar):");
				                    String nombre = ayudaHelpers.leerTeclado();
				                    ayudaHelpers.imprimirSalto("Introduzca nuevo Apellido (dejar en blanco para no cambiar):");
				                    String apellido = ayudaHelpers.leerTeclado();
				                    ayudaHelpers.imprimirSalto("Introduzca nueva Dirección (dejar en blanco para no cambiar):");
				                    String direccion = ayudaHelpers.leerTeclado();

				                    // Actualizar el remitente
				                    bdDao.actualizarRemitentes(conexion, id, nombre, apellido, direccion);

				                } catch (SQLException sqlEx) {
				                    sqlEx.printStackTrace();
				                } catch (Exception eX) {
				                    eX.printStackTrace();
				                }
				                break;
				            }

				            case "4": {
				                // Borrar un remitente por ID
				                try {
				                    ayudaHelpers.imprimirSalto("Introduzca ID del remitente a borrar:");
				                    int id = ayudaHelpers.stringtoInt(ayudaHelpers.leerTeclado());
				                    bdDao.borrarRemitentesPorId(conexion, id);
				                } catch (SQLException sqlEx) {
				                    sqlEx.printStackTrace();
				                } catch (Exception ex) {
				                    ex.printStackTrace();
				                }
				                break;
				            }

				            case "5": {
				                // Listar todos los remitentes
				                try {
				                    ArrayList<tablaRemitentes>  listaRemitentes = new ArrayList<tablaRemitentes>();
				                    listaRemitentes = bdDao.listarRemitentes(conexion);
				                    for (int i = 0; i < listaRemitentes.size(); i++) {
										ayudaHelpers.imprimirSalto(listaRemitentes.get(i).toString());
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

				case "3": {
				    ejecutarOpciones = true;
				    // bucle para ejecución continua del menú
				    while (ejecutarOpciones) {
				        MenuHelpers.imprimirMenuOpciones(ayudaHelpers);
				        opcionLeida = ayudaHelpers.leerTeclado();
				        switch (opcionLeida) {

				            case "0": {
				                ayudaHelpers.imprimirSalto("Volvemos al menú principal");
				                ejecutarOpciones = false;
				                break;
				            }

				            case "1": {
				                // Buscar Paquete por ID
				                try {
				                    ayudaHelpers.imprimirSalto("Introduzca ID del paquete:");
				                    int id = ayudaHelpers.stringtoInt(ayudaHelpers.leerTeclado());
				                    tablaPaquetes paquete = bdDao.obtenerPaquetesPorId(conexion, id);
				                    ayudaHelpers.imprimirSalto(paquete.toString());
				                } catch (SQLException sqlEx) {
				                    sqlEx.printStackTrace();
				                } catch (Exception e) {
				                    e.printStackTrace();
				                }
				                break;
				            }

				            case "2": {
				                // Insertar un nuevo paquete
				                try {
				                    ayudaHelpers.imprimirSalto("Introduzca Referencia del paquete:");
				                    String referencia = ayudaHelpers.leerTeclado();
				                    ayudaHelpers.imprimirSalto("Introduzca Destinatario del paquete:");
				                    String destinatario = ayudaHelpers.leerTeclado();
				                    ayudaHelpers.imprimirSalto("Introduzca Dirección del paquete:");
				                    String direccion = ayudaHelpers.leerTeclado();
				                    ayudaHelpers.imprimirSalto("Introduzca Peso del paquete:");
				                    double peso = ayudaHelpers.stringToDouble(ayudaHelpers.leerTeclado());
				                    peso = ayudaHelpers.redondear(peso);
				                    ayudaHelpers.imprimir("Introduza el id_remitente para asociarlo");
				                    int id_remitente = ayudaHelpers.stringtoInt(ayudaHelpers.leerTeclado());
				                    ayudaHelpers.imprimir("Introduza el id_tarifa para asociarlo");
				                    int id_tarifa = ayudaHelpers.stringtoInt(ayudaHelpers.leerTeclado());
				                    
				                 

				                    // Insertar el nuevo paquete
				                    bdDao.insertarPaquetes(conexion, referencia, destinatario, direccion, peso, id_remitente, id_tarifa);

				                } catch (SQLException sqlEx) {
				                    sqlEx.printStackTrace();
				                } catch (Exception ex) {
				                    ex.printStackTrace();
				                }
				                break;
				            }

				            case "3": {
				                // Actualizar un paquete
				                try {
				                    ayudaHelpers.imprimirSalto("Introduzca ID del paquete a actualizar:");
				                    int id = ayudaHelpers.stringtoInt(ayudaHelpers.leerTeclado());
				                    
				                    ayudaHelpers.imprimirSalto("Introduzca nueva Referencia (dejar en blanco para no cambiar):");
				                    String referencia = ayudaHelpers.leerTeclado();
				                    
				                    ayudaHelpers.imprimirSalto("Introduzca nuevo Destinatario (dejar en blanco para no cambiar):");
				                    String destinatario = ayudaHelpers.leerTeclado();
				                    
				                    ayudaHelpers.imprimirSalto("Introduzca nueva Dirección (dejar en blanco para no cambiar):");
				                    String direccion = ayudaHelpers.leerTeclado();
				                    
				                    ayudaHelpers.imprimirSalto("Introduzca nuevo Peso (0 para no cambiar):");
				                    double peso = ayudaHelpers.stringToDouble(ayudaHelpers.leerTeclado());
				                    peso = peso != 0.0 ? ayudaHelpers.redondear(peso) : 0.0;

				                    
				                    ayudaHelpers.imprimir("Introduza el id_remitente para asociarlo (poner el mismo sino cambia)");
				                    String idRemitente = ayudaHelpers.leerTeclado();				                    
				                    int id_remitente = idRemitente.isEmpty() ? 0 : ayudaHelpers.stringtoInt(idRemitente);		
				                    
				                    ayudaHelpers.imprimir("Introduza el id_tarifa para asociarlo (poner el mismo sino cambia):");
				                    String idTarifa = ayudaHelpers.leerTeclado();
				                    int id_tarifa = idTarifa.isEmpty() ? 0 : ayudaHelpers.stringtoInt(idTarifa);  
				                   
				                    // Verificar existencia de id_tarifa y id_remitente si son mayores que 0
				                    boolean validIdRemitente = id_remitente == 0 || BDDAO.existeRemitente(conexion, id_remitente);
				                    boolean validIdTarifa = id_tarifa == 0 || BDDAO.existeTarifa(conexion, id_tarifa);

				                    if (!validIdRemitente || !validIdTarifa) {
				                        ayudaHelpers.imprimirSalto("Error: Id Remitente o Id Tarifa no existe.");
				                        break;
				                    }

				                    // Actualizar el paquete
				                    bdDao.actualizarPaquetes(conexion, id, referencia, destinatario, direccion, peso, id_remitente, id_tarifa);

				                } catch (SQLException sqlEx) {
				                    sqlEx.printStackTrace();
				                } catch (Exception eX) {
				                    eX.printStackTrace();
				                }
				                break;
				            }

				            case "4": {
				                // Borrar un paquete por ID
				                try {
				                    ayudaHelpers.imprimirSalto("Introduzca ID del paquete a borrar:");
				                    int id = ayudaHelpers.stringtoInt(ayudaHelpers.leerTeclado());
				                    bdDao.borrarPaquetesPorId(conexion, id);
				                } catch (SQLException sqlEx) {
				                    sqlEx.printStackTrace();
				                } catch (Exception ex) {
				                    ex.printStackTrace();
				                }
				                break;
				            }

				            case "5": {
				                // Listar todos los paquetes
				                try {
				                    ArrayList<tablaPaquetes> listaPaquetes  = new ArrayList<tablaPaquetes>();
				                    listaPaquetes = bdDao.listarPaquetes(conexion);
				                    for (tablaPaquetes paquete : listaPaquetes) {
				                        ayudaHelpers.imprimirSalto(paquete.toString());
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
					ayudaHelpers.imprimirSalto("Hasta luego, nos vemos en el proximno certificado 🔝🔝");
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
