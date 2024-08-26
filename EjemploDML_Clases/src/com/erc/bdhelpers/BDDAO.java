	package com.erc.bdhelpers;
	
	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.util.ArrayList;
	
	import com.erc.helpers.CommonHelpers;
	import com.erc.model.Usuario;
	import com.erc.model.Cliente;
import com.erc.model.Trabajador;
	
	public class BDDAO {
		
		// creamos una serie de constantes con los nombre de las tablas y campos es la forma
		// mas sencilla de localizar errores de nombrado de los campos en lso métodos
		
		// nombre de Tablas
		// utilizamos el modificador de private para forzar que sólo se acceda a la base de datos a través de estos métodos
		private static final String TABLA_USUARIOS="usuarios";
		private static final String TABLA_CLIENTES="clientes";
		private static final String TABLA_TRABAJADORES="trabajadores";
		
		//nombre campos tabla usuarios
		private static final String USUARIOS_ID="id";
		private static final String USUARIOS_DNI="dni";
		private static final String USUARIOS_NOMBRE="nombre";
		private static final String USUARIOS_APELLIDOS="apellido";
		private static final String USUARIOS_DIRECCION="direccion";
		private static final String USUARIOS_TELEFONO="telefono";
		private static final String USUARIOS_EMAIL="mail";
		
		//nombre campos tabla clientes
		private static final String CLIENTES_ID="id";
		private static final String CLIENTES_PUNTOS="punto";
		private static final String CLIENTES_ID_USUARIO="id_usuario";
		
		
	
		
		//nombre campos tabla trabajadores
		private static final String TRABAJADORES_ID="id";
		private static final String TRABAJADORES_SS="ss";
		private static final String TRABAJADORES_SALARIO="salario";
		private static final String TRABAJADORES_ID_USUARIO="id_usuario";
			
		
		
		// métodos CRUD Usuarios
		public Usuario obtenerUsuarioporID(Connection conexion, int id) throws SQLException {
			// obtiene un usuario por ID
			Usuario retorno= new Usuario();
			// preparo el SQL a ejecutar
			String sqlSeleccion="SELECT * FROM "+TABLA_USUARIOS+" WHERE "+USUARIOS_ID+" = ?";
			// creo el preparedStatement para ejecutar la sentencia
			PreparedStatement prdStat=conexion.prepareStatement(sqlSeleccion);
			// asigno valor al parámetro
			prdStat.setInt(1, id);
			//ejecuto la consulta
			ResultSet resultado= prdStat.executeQuery();
			// voy al único elemento que contendrá el resultSet
			resultado.next();
			retorno.setId(id);
			retorno.setDni(resultado.getString(USUARIOS_DNI));
			retorno.setNombre(resultado.getString(USUARIOS_NOMBRE));
			retorno.setApellidos(resultado.getString(USUARIOS_APELLIDOS));
			retorno.setDireccion(resultado.getString(USUARIOS_DIRECCION));
			retorno.setTelefono(resultado.getString(USUARIOS_TELEFONO));
			retorno.setEmail(resultado.getString(USUARIOS_EMAIL));
			return retorno;
		}
		
		public ArrayList<Usuario> obtenerUsuariosPorNombre(Connection conexion,String nombre)throws SQLException{
			//obtiene lista de usuarios por nombre
			// creo la lista de devolución de los usuarios
			ArrayList<Usuario>retornoUsuarios= new ArrayList<Usuario>();
			String sqlSeleccion="SELECT * FROM "+TABLA_USUARIOS+" WHERE "+USUARIOS_NOMBRE+" LIKE %?%";
			PreparedStatement prdStat=conexion.prepareStatement(sqlSeleccion);
			// asigno valor al parámetro
			prdStat.setString(1, nombre);
			//ejecuto la consulta
			ResultSet resultado= prdStat.executeQuery();
			while(resultado.next()) {
				Usuario auxUsuario= new Usuario();
				auxUsuario.setId(resultado.getInt(USUARIOS_ID));
				auxUsuario.setDni(resultado.getString(USUARIOS_DNI));
				auxUsuario.setNombre(resultado.getString(USUARIOS_NOMBRE));
				auxUsuario.setApellidos(resultado.getString(USUARIOS_APELLIDOS));
				auxUsuario.setDireccion(resultado.getString(USUARIOS_DIRECCION));
				auxUsuario.setTelefono(resultado.getString(USUARIOS_TELEFONO));
				auxUsuario.setEmail(resultado.getString(USUARIOS_EMAIL));
				retornoUsuarios.add(auxUsuario);
			}
			return retornoUsuarios;
		}
		
		public void insertarUsuario(Connection conexion,String dni,String nombre, String apellidos,
				String direccion, String telefono, String email) throws SQLException {
			// inserta un usuario
			CommonHelpers helpers= new CommonHelpers();
			// sql para insercion de un usuario parametrizado
			String sqlInsercion="INSERT INTO "+TABLA_USUARIOS+ "("+USUARIOS_DNI+","+USUARIOS_NOMBRE+","+
			USUARIOS_APELLIDOS+","+USUARIOS_DIRECCION+","+USUARIOS_TELEFONO+","+USUARIOS_EMAIL+")"+" VALUES "
					+ "(?,?,?,?,?,?)";
			PreparedStatement prdstInsercion=conexion.prepareStatement(sqlInsercion);
			// asignar los valores
			prdstInsercion.setString(1,dni);
			prdstInsercion.setString(2,nombre);
			prdstInsercion.setString(3,apellidos);
			prdstInsercion.setString(4,direccion);
			prdstInsercion.setString(5,telefono);
			prdstInsercion.setString(6,email);
			//ejecuación del prepared
			int filasAfectadas=prdstInsercion.executeUpdate();
			if(filasAfectadas>0) {
				helpers.imprimirSalto("Inserción Realizada");
			}
			else {
				helpers.imprimirSalto("Inserción no Realizada");
			}
			
			
		}
		
		public void actualizarUsuario(Connection conexion,int id,String dni,String nombre, String apellidos,
				String direccion, String telefono, String email) throws SQLException {
			// ACtualiza un usuario
			CommonHelpers helpers= new CommonHelpers();
			// obtenemos el valor actual de los campos
			Usuario auxUsuario= obtenerUsuarioporID(conexion,id);
			// sql para insercion de un usuario parametrizado
			String sqlActualizacion="UPDATE "+TABLA_USUARIOS+ " SET "+USUARIOS_DNI+" = ?, "
					+USUARIOS_NOMBRE+"= ?, "+USUARIOS_APELLIDOS+" = ?, "
							+ USUARIOS_DIRECCION+" = ?, "
							+ USUARIOS_TELEFONO+" = ?, "+USUARIOS_EMAIL+" = ? "
									+ "WHERE "+USUARIOS_ID+" = ?;";
			PreparedStatement prdstActualizacion=conexion.prepareStatement(sqlActualizacion);
			// asignar los valores
			prdstActualizacion.setInt(7, id);
			if(!dni.equalsIgnoreCase("")) {
			prdstActualizacion.setString(1,dni);
			}else {
				prdstActualizacion.setString(1,auxUsuario.getDni());
			}
			
			if(!nombre.equalsIgnoreCase("")) {
				prdstActualizacion.setString(2,nombre);
				}else {
					prdstActualizacion.setString(2,auxUsuario.getNombre());
				}
			
			if(!apellidos.equalsIgnoreCase("")) {
				prdstActualizacion.setString(3,apellidos);
				}else {
					prdstActualizacion.setString(3,auxUsuario.getApellidos());
				}
			
			if(!direccion.equalsIgnoreCase("")) {
				prdstActualizacion.setString(4,direccion);
				}else {
					prdstActualizacion.setString(4,auxUsuario.getDireccion());
				}
			
			if(!telefono.equalsIgnoreCase("")) {
				prdstActualizacion.setString(5,telefono);
				}else {
					prdstActualizacion.setString(5,auxUsuario.getTelefono());
				}
			
			if(!email.equalsIgnoreCase("")) {
				prdstActualizacion.setString(6,email);
				}else {
					prdstActualizacion.setString(6,auxUsuario.getEmail());
				}
			
			//ejecuación del prepared
			int filasAfectadas=prdstActualizacion.executeUpdate();
			if(filasAfectadas>0) {
				helpers.imprimirSalto("Actualización Realizada");
			}
			else {
				helpers.imprimirSalto("Actualización no Realizada");
			}
			
			
		}
		public void borrarUsuarioporId(Connection conexion, int id) throws SQLException {
			CommonHelpers helpers= new CommonHelpers();
			//borramos usuario por su id
			// preparo el SQL a ejecutar
			String sqlBorrado="DELETE FROM "+TABLA_USUARIOS+" WHERE "+USUARIOS_ID+" = ?";
			// creo el preparedStatement para ejecutar la sentencia
			PreparedStatement prdstBorrado=conexion.prepareStatement(sqlBorrado);
			// asigno valor al parámetro
			prdstBorrado.setInt(1, id);
			//ejecuto la consulta
			//ejecuación del prepared
					int filasAfectadas=prdstBorrado.executeUpdate();
					if(filasAfectadas>0) {
						helpers.imprimirSalto("Borrado Realizado");
					}
					else {
						helpers.imprimirSalto("Borrado no Realizado");
					}
		}
		
		public ArrayList<Usuario> listarUsuarios(Connection conexion)throws SQLException{
			
			ArrayList<Usuario>listadoUsuarios= new ArrayList<Usuario>();
			String sqlListar="SELECT * FROM "+TABLA_USUARIOS;
			PreparedStatement prdStat = conexion.prepareStatement(sqlListar);
			ResultSet resultado= prdStat.executeQuery();
			while(resultado.next()) {
				Usuario auxUsuario= new Usuario();
				auxUsuario.setId(resultado.getInt(USUARIOS_ID));
				auxUsuario.setDni(resultado.getString(USUARIOS_DNI));
				auxUsuario.setNombre(resultado.getString(USUARIOS_NOMBRE));
				auxUsuario.setApellidos(resultado.getString(USUARIOS_APELLIDOS));
				auxUsuario.setDireccion(resultado.getString(USUARIOS_DIRECCION));
				auxUsuario.setTelefono(resultado.getString(USUARIOS_TELEFONO));
				auxUsuario.setEmail(resultado.getString(USUARIOS_EMAIL));
				listadoUsuarios.add(auxUsuario);
			}
			return listadoUsuarios;
		}
		
		//******************************************************************************************************
		
		// métodos CRUD Clientes
		public Cliente obtenerClientesporID(Connection conexion, int id) throws SQLException {
			// obtiene un usuario por ID
			Cliente retorno= new Cliente();
			// preparo el SQL a ejecutar
			String sqlSeleccion="SELECT * FROM "+TABLA_CLIENTES+" WHERE "+USUARIOS_ID+ " = ?";
			// creo el preparedStatement para ejecutar la sentencia
			PreparedStatement prdStat=conexion.prepareStatement(sqlSeleccion);
			// asigno valor al parámetro
			prdStat.setInt(1, id);
			//ejecuto la consulta
			ResultSet resultado= prdStat.executeQuery();
			// voy al único elemento que contendrá el resultSet
			 if(resultado.next()) {
			retorno.setId(id);
			retorno.setPunto(resultado.getInt(CLIENTES_PUNTOS));
			retorno.setIdUsuario(resultado.getInt(CLIENTES_ID_USUARIO));
			 }else {
				 throw new SQLException("Cliente con ID " + id + " no encontrado.");
			 }
			
			return retorno;
		
	
	}
		public ArrayList<Cliente> obtenerClientesPorID_Usuario(Connection conexion,String id_usuario)throws SQLException{
			//obtiene lista de clientes por Id_usuario
			// creo la lista de devolución de los clientes
			ArrayList<Cliente>retornoClientes= new ArrayList<Cliente>();
			String sqlSeleccion="SELECT * FROM "+TABLA_CLIENTES+" WHERE "+CLIENTES_ID_USUARIO+" = ";
			PreparedStatement prdStat=conexion.prepareStatement(sqlSeleccion);
			// asigno valor al parámetro
			prdStat.setString(1, id_usuario);
			//ejecuto la consulta
			ResultSet resultado= prdStat.executeQuery();
			while(resultado.next()) {
				Cliente auxCliente= new Cliente();
				auxCliente.setId(resultado.getInt(CLIENTES_ID));
				auxCliente.setPunto(resultado.getInt(CLIENTES_PUNTOS));	
				auxCliente.setIdUsuario(resultado.getInt(CLIENTES_ID_USUARIO));
				retornoClientes.add(auxCliente);
			}
			return retornoClientes;
		}
		
		public void insertarCliente(Connection conexion,int puntos,int id_usuario) throws SQLException {
			// inserta un cliente
			CommonHelpers helpers= new CommonHelpers();
			// sql para insercion de un cliente parametrizado
			String sqlInsercion="INSERT INTO "+TABLA_CLIENTES+ "("+CLIENTES_PUNTOS+","+CLIENTES_ID_USUARIO+")"+" VALUES "
					+ "(?,?)";
			PreparedStatement prdstInsercion=conexion.prepareStatement(sqlInsercion);
			// asignar los valores
			prdstInsercion.setInt(1,puntos);
			prdstInsercion.setInt(2,id_usuario);
			
			//ejecuación del prepared
			int filasAfectadas=prdstInsercion.executeUpdate();
			if(filasAfectadas>0) {
				helpers.imprimirSalto("Inserción Realizada");
			}
			else {
				helpers.imprimirSalto("Inserción no Realizada");
			}
			
			
		}
		public void actualizarClientes(Connection conexion, int id, int puntos, int id_usuario) throws SQLException {
			// ACtualiza un cliente
			CommonHelpers helpers= new CommonHelpers();
			// obtenemos el valor actual de los campos
			Cliente auxCliente= obtenerClientesporID(conexion,id);
			// sql para insercion de un usuario parametrizado
			String sqlActualizacion="UPDATE "+TABLA_CLIENTES+ " SET "+ CLIENTES_PUNTOS+" = ?, "
							+ CLIENTES_ID_USUARIO+" = ?, "+ "WHERE "+CLIENTES_ID+" = ?;";
			PreparedStatement prdstActualizacion=conexion.prepareStatement(sqlActualizacion);
			// asignar los valores
			prdstActualizacion.setInt(7, id);
			  if (puntos != 0) {
			        prdstActualizacion.setInt(1, puntos);
			    } else {
			        prdstActualizacion.setInt(1, auxCliente.getPunto());
			    }
			
			  if (id_usuario != 0) {
			        prdstActualizacion.setInt(2, id_usuario);
			    } else {
			        prdstActualizacion.setInt(2, auxCliente.getIdUsuario());
			    }
			    
			
			
			//ejecuación del prepared
			int filasAfectadas=prdstActualizacion.executeUpdate();
			if(filasAfectadas>0) {
				helpers.imprimirSalto("Actualización Realizada");
			}
			else {
				helpers.imprimirSalto("Actualización no Realizada");
			}
			
			
		}
		
		public void borrarClientePorId(Connection conexion, int id) throws SQLException {
		    CommonHelpers helpers = new CommonHelpers();
		    // Preparo el SQL para la eliminación
		    String sqlBorrado = "DELETE FROM " + TABLA_CLIENTES + " WHERE " + CLIENTES_ID + " = ?";
		    // Creo el PreparedStatement
		    PreparedStatement prdstBorrado = conexion.prepareStatement(sqlBorrado);
		    // Asigno el valor al parámetro
		    prdstBorrado.setInt(1, id);
		    // Ejecuto la consulta
		    int filasAfectadas = prdstBorrado.executeUpdate();
		    if (filasAfectadas > 0) {
		        helpers.imprimirSalto("Borrado Realizado");
		    } else {
		        helpers.imprimirSalto("Borrado no Realizado");
		    }
		}
	     
		public ArrayList<Cliente> listarClientes(Connection conexion) throws SQLException {
		    ArrayList<Cliente> listadoClientes = new ArrayList<Cliente>();
		    // Preparo el SQL para listar todos los clientes
		    String sqlListar = "SELECT * FROM " + TABLA_CLIENTES;
		    PreparedStatement prdStat = conexion.prepareStatement(sqlListar);
		    ResultSet resultado = prdStat.executeQuery();
		    while (resultado.next()) {
		        Cliente auxCliente = new Cliente();
		        auxCliente.setId(resultado.getInt(CLIENTES_ID));
		        auxCliente.setPunto(resultado.getInt(CLIENTES_PUNTOS));
		        auxCliente.setIdUsuario(resultado.getInt(CLIENTES_ID_USUARIO));
		        listadoClientes.add(auxCliente);
		    }
		    return listadoClientes;
		}
	
		//******************************************************************************************************
		// Métodos CRUD Trabajadores
	    public Trabajador obtenerTrabajadorPorID(Connection conexion, int id) throws SQLException {
	        Trabajador retorno = new Trabajador();
	        String sqlSeleccion = "SELECT * FROM " + TABLA_TRABAJADORES + " WHERE " + TRABAJADORES_ID + " = ?";
	        PreparedStatement prdStat = conexion.prepareStatement(sqlSeleccion);
	        prdStat.setInt(1, id);
	        ResultSet resultado = prdStat.executeQuery();
	        if (resultado.next()) {
	            retorno.setId(id);
	            retorno.setSs(resultado.getString(TRABAJADORES_SS));
	            retorno.setSalario(resultado.getDouble(TRABAJADORES_SALARIO));
	            retorno.setIdUsuario(resultado.getInt(TRABAJADORES_ID_USUARIO));
	        } else {
	            throw new SQLException("Trabajador con ID " + id + " no encontrado.");
	        }
	        return retorno;
	    }

	    public ArrayList<Trabajador> obtenerTrabajadoresPorNombre(Connection conexion, String ss) throws SQLException {
	        ArrayList<Trabajador> retornoTrabajadores = new ArrayList<>();
	        String sqlSeleccion = "SELECT * FROM " + TABLA_TRABAJADORES + " WHERE " + TRABAJADORES_SS + " LIKE ?";
	        PreparedStatement prdStat = conexion.prepareStatement(sqlSeleccion);
	        prdStat.setString(1, "%" + ss + "%");
	        ResultSet resultado = prdStat.executeQuery();
	        while (resultado.next()) {
	            Trabajador auxTrabajador = new Trabajador();
	            auxTrabajador.setId(resultado.getInt(TRABAJADORES_ID));
	            auxTrabajador.setSs(resultado.getString(TRABAJADORES_SS));
	            auxTrabajador.setSalario(resultado.getDouble(TRABAJADORES_SALARIO));
	            auxTrabajador.setIdUsuario(resultado.getInt(TRABAJADORES_ID_USUARIO));
	            retornoTrabajadores.add(auxTrabajador);
	        }
	        return retornoTrabajadores;
	    }

	    public void insertarTrabajador(Connection conexion, String ss, double salario, int id_usuario) throws SQLException {
	        CommonHelpers helpers = new CommonHelpers();
	        String sqlInsercion = "INSERT INTO " + TABLA_TRABAJADORES + " (" + TRABAJADORES_SS + ", " + TRABAJADORES_SALARIO + ", " + TRABAJADORES_ID_USUARIO + ") VALUES (?, ?, ?)";
	        PreparedStatement prdstInsercion = conexion.prepareStatement(sqlInsercion);
	        prdstInsercion.setString(1, ss);
	        prdstInsercion.setDouble(2, salario);
	        prdstInsercion.setInt(3, id_usuario);
	        int filasAfectadas = prdstInsercion.executeUpdate();
	        if (filasAfectadas > 0) {
	            helpers.imprimirSalto("Inserción Realizada");
	        } else {
	            helpers.imprimirSalto("Inserción no Realizada");
	        }
	    }

	    public void actualizarTrabajador(Connection conexion, int id, String ss, double salario, int id_usuario) throws SQLException {
	        CommonHelpers helpers = new CommonHelpers();
	        Trabajador auxTrabajador = obtenerTrabajadorPorID(conexion, id);
	        String sqlActualizacion = "UPDATE " + TABLA_TRABAJADORES + " SET " + TRABAJADORES_SS + " = ?, " + TRABAJADORES_SALARIO + " = ?, " + TRABAJADORES_ID_USUARIO + " = ? WHERE " + TRABAJADORES_ID + " = ?";
	        PreparedStatement prdstActualizacion = conexion.prepareStatement(sqlActualizacion);
	        prdstActualizacion.setString(1, !ss.isEmpty() ? ss : auxTrabajador.getSs());
	        prdstActualizacion.setDouble(2, salario != 0 ? salario : auxTrabajador.getSalario());
	        prdstActualizacion.setInt(3, id_usuario != 0 ? id_usuario : auxTrabajador.getIdUsuario());
	        prdstActualizacion.setInt(4, id);
	        int filasAfectadas = prdstActualizacion.executeUpdate();
	        if (filasAfectadas > 0) {
	            helpers.imprimirSalto("Actualización Realizada");
	        } else {
	            helpers.imprimirSalto("Actualización no Realizada");
	        }
	    }

	    public void borrarTrabajadorPorId(Connection conexion, int id) throws SQLException {
	        CommonHelpers helpers = new CommonHelpers();
	        String sqlBorrado = "DELETE FROM " + TABLA_TRABAJADORES + " WHERE " + TRABAJADORES_ID + " = ?";
	        PreparedStatement prdstBorrado = conexion.prepareStatement(sqlBorrado);
	        prdstBorrado.setInt(1, id);
	        int filasAfectadas = prdstBorrado.executeUpdate();
	        if (filasAfectadas > 0) {
	            helpers.imprimirSalto("Borrado Realizado");
	        } else {
	            helpers.imprimirSalto("Borrado no Realizado");
	        }
	    }

	    public ArrayList<Trabajador> listarTrabajadores(Connection conexion) throws SQLException {
	        ArrayList<Trabajador> listadoTrabajadores = new ArrayList<>();
	        String sqlListar = "SELECT * FROM " + TABLA_TRABAJADORES;
	        PreparedStatement prdStat = conexion.prepareStatement(sqlListar);
	        ResultSet resultado = prdStat.executeQuery();
	        while (resultado.next()) {
	            Trabajador auxTrabajador = new Trabajador();
	            auxTrabajador.setId(resultado.getInt(TRABAJADORES_ID));
	            auxTrabajador.setSs(resultado.getString(TRABAJADORES_SS));
	            auxTrabajador.setSalario(resultado.getDouble(TRABAJADORES_SALARIO));
	            auxTrabajador.setIdUsuario(resultado.getInt(TRABAJADORES_ID_USUARIO));
	            listadoTrabajadores.add(auxTrabajador);
	        }
	        return listadoTrabajadores;
	    }
	}
