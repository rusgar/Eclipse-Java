package com.erc.bdhelpers;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.erc.helpers.CommonHelpers;
import com.erc.model.tablaClientes;
import com.erc.model.tablaDirecciones;
import com.erc.model.tablaSalidas;
import com.erc.model.tablaTrabajadores;
import com.erc.model.tablaTrabajadoresSalidas;



public class BDDAO {


	// CREAMOS UNA SERIE DE CONSTANTES CON LOS NOMBRES DE LAS TABLAS Y CAMPOS ES LA FORMA
	// MAS SENCILLA DE LOCALIZAR ERRORES DE NOMBRADO DE LOS CAMPOS EN LOS METODOS

	// NOMBRE DE LAS TABLAS

	private static final String TABLA_CLIENTES="clientes";
	private static final String TABLA_DIRECCIONES="direcciones";
	private static final String TABLA_TRABAJADORES="trabajadores";
	private static final String TABLA_SALIDAS="salidas";
	private static final String TABLA_TRABAJADORES_SALIDAS="trabajadores_salidas";



	// CAMPOS DE LA TABLA CLIENTES
	private static final String CLIENTES_ID = "id";
	private static final String CLIENTES_NOMBRE = "Nombre";
	private static final String CLIENTES_APELLIDOS = "Apellidos";	
	private static final String CLIENTES_DNI = "DNI";
	private static final String CLIENTES_TELEFONO = "Telefono";
	private static final String CLIENTES_CORREO = "Correo";


	// CAMPOS DE LA TABLA DIRECCIONES
	private static final String DIRECCIONES_ID = "id";
	private static final String DIRECCIONES_DIRECCION = "Direccion";
	private static final String DIRECCIONES_CODIGO_POSTAL = "Codigo_Postal";
	private static final String DIRECCIONES_LOCALIDAD = "Localidad";
	private static final String DIRECCIONES_LATITUD = "Latitud";
	private static final String DIRECCIONES_LONGITUD = "Longitud";
	private static final String DIRECCIONES_ID_CLIENTE = "id_cliente";



	// CAMPOS DE LA TABLA TRABAJADORES
	private static final String TRABAJADORES_ID = "id";
	private static final String TRABAJADORES_NOMBRE = "Nombre";
	private static final String TRABAJADORES_APELLIDOS = "Apellidos";
	private static final String TRABAJADORES_TELEFONO = "Telefono";
	private static final String TRABAJADORES_SS = "SS";
	private static final String TRABAJADORES_PUESTO = "Puesto";
	private static final String TRABAJADORES_ID_DIRECCION = "id_direccion";

	// CAMPOS DE LA TABLA SALIDAS
	private static final String SALIDAS_ID = "id";
	private static final String SALIDAS_TAREA= "Tarea";
	private static final String SALIDAS_INSTALACIONES = "Instalaciones";
	private static final String SALIDAS_INCIDENCIAS = "Incidencias";
	private static final String SALIDAS_SOLUCION = "Solucion";
	private static final String SALIDAS_DESCRIPCION = "Descripcion";
	private static final String SALIDAS_COSTE_CLIENTE = "Coste_Cliente";	
	private static final String SALIDAS_FECHA_TAREA = "FechaTarea";
	private static final String SALIDAS_ID_CLIENTE = "id_cliente";
	private static final String SALIDAS_ID_TRABAJADOR = "id_trabajador";	
	private static final String SALIDAS_ID_DIRECCION = "id_direccion";	    


	// CAMPOS DE LA TABLA TRABAJDORES_SALIDAS
	private static final String TRABAJADORES_SALIDAS_ID= "id";
	private static final String TRABAJADORES_SALIDAS_ID_TRABAJADOR = "id_trabajador";
	private static final String TRABAJADORES_SALIDAS_ID_SALIDA = "id_salida";
	
	
	


	// ********************************* CRUD DE LA TABLA CLIENTES****************************
	// ***********************************************************************************

	public tablaClientes obtenerClientePorId(Connection conexion, int id) throws SQLException {
		tablaClientes retorno = null; 

		String sqlSeleccion = "SELECT * FROM " + TABLA_CLIENTES + " WHERE " + CLIENTES_ID + " = ?";
		try (PreparedStatement prdStat = conexion.prepareStatement(sqlSeleccion)) {
			prdStat.setInt(1, id);

			try (ResultSet resultado = prdStat.executeQuery()) {
				if (resultado.next()) {
					retorno = new tablaClientes(); 
					retorno.setId(id);
					retorno.setNombre(resultado.getString(CLIENTES_NOMBRE));
					retorno.setApellidos(resultado.getString(CLIENTES_APELLIDOS));					
					retorno.setDni(resultado.getString(CLIENTES_DNI));
					retorno.setTelefono(resultado.getString(CLIENTES_TELEFONO));
					retorno.setCorreo(resultado.getString(CLIENTES_CORREO));
				}
			}
		}

		return retorno; 
	}


	public void insertarCliente(Connection conexion, String nombre, String apellidos, 
			                    String dni, String telefono,String correo) throws SQLException {
		CommonHelpers ayudaHelpers = new CommonHelpers();
		String sqlInsercion = "INSERT INTO " + TABLA_CLIENTES + " (" 
				+ CLIENTES_NOMBRE + ", " + CLIENTES_APELLIDOS + ", " 
			    + CLIENTES_DNI + ", "    + CLIENTES_TELEFONO + ", " + CLIENTES_CORREO +  ") VALUES (?, ?, ?, ?, ?)";

		PreparedStatement prdstInsercion = conexion.prepareStatement(sqlInsercion);
		prdstInsercion.setString(1, nombre);
		prdstInsercion.setString(2, apellidos);
		prdstInsercion.setString(3, dni);
		prdstInsercion.setString(4, telefono);
		prdstInsercion.setString(5, correo);

		int filasAfectadas = prdstInsercion.executeUpdate();
		if (filasAfectadas > 0) {
			ayudaHelpers.imprimirSalto("Inserción realizada en la tabla cliente");
		} else {
			ayudaHelpers.imprimirSalto("Inserción no realizada, hay un error");
		}
	}

	public void actualizarCliente(Connection conexion, int id, String nombre, String apellidos, 
			                      String dni, String telefono,  String correo) throws SQLException {
		CommonHelpers ayuHelpers = new CommonHelpers();
		tablaClientes auxClientes = obtenerClientePorId(conexion, id);

		String sqlActualizacion = "UPDATE " + TABLA_CLIENTES + " SET " 
				+ CLIENTES_NOMBRE + " = ?, "
				+ CLIENTES_APELLIDOS + " = ?, "
				+ CLIENTES_DNI + " = ?, "
				+ CLIENTES_TELEFONO + " = ?, "
	            + CLIENTES_CORREO + " = ?"
	          	+ " WHERE " + CLIENTES_ID + " = ?";

		PreparedStatement prdstActualizacion = conexion.prepareStatement(sqlActualizacion);

		if (!nombre.equalsIgnoreCase("")) {
			prdstActualizacion.setString(1, nombre);
		} else {
			prdstActualizacion.setString(1, auxClientes.getNombre());
		}
		if (!apellidos.equalsIgnoreCase("")) {
			prdstActualizacion.setString(2, apellidos);
		} else {
			prdstActualizacion.setString(2, auxClientes.getApellidos());
		}
		if (!dni.equalsIgnoreCase("")) {
			prdstActualizacion.setString(3, dni);
		} else {
			prdstActualizacion.setString(3, auxClientes.getDni());
		}
		if (!telefono.equalsIgnoreCase("")) {
			prdstActualizacion.setString(4, telefono);
		} else {
			prdstActualizacion.setString(4, auxClientes.getTelefono());
		}
		if (!correo.equalsIgnoreCase("")) {
			prdstActualizacion.setString(5, correo);
		} else {
			prdstActualizacion.setString(5, auxClientes.getCorreo());
		}

		prdstActualizacion.setInt(6, id);

		int filasAfectadas = prdstActualizacion.executeUpdate();
		if (filasAfectadas > 0) {
			ayuHelpers.imprimirSalto("Actualización realizada en la tabla cliente");
		} else {
			ayuHelpers.imprimirSalto("Actualización no realizada, hay un error");
		}
	}

	public void borrarClientePorId(Connection conexion, int id) throws SQLException {
		CommonHelpers ayudaHelpers = new CommonHelpers();
		String sqlBorrado = "DELETE FROM " + TABLA_CLIENTES + " WHERE " + CLIENTES_ID + " = ?";

		PreparedStatement prdstBorrado = conexion.prepareStatement(sqlBorrado);
		prdstBorrado.setInt(1, id);

		int filasAfectadas = prdstBorrado.executeUpdate();
		if (filasAfectadas > 0) {
			ayudaHelpers.imprimirSalto("Borrado realizado en la tabla cliente");
		} else {
			ayudaHelpers.imprimirSalto("Borrado no realizado, hay un error");
		}
	}

	public ArrayList<tablaClientes> listarClientes(Connection conexion) throws SQLException {
		ArrayList<tablaClientes> listadoCliente = new ArrayList<>();
		String sqlListado = "SELECT * FROM " + TABLA_CLIENTES;

		PreparedStatement prdStat = conexion.prepareStatement(sqlListado);
		ResultSet resultado = prdStat.executeQuery();

		while (resultado.next()) {
			tablaClientes auxCliente = new tablaClientes();
			auxCliente.setId(resultado.getInt(CLIENTES_ID));
			auxCliente.setNombre(resultado.getString(CLIENTES_NOMBRE));
			auxCliente.setApellidos(resultado.getString(CLIENTES_APELLIDOS));
			auxCliente.setDni(resultado.getString(CLIENTES_DNI));
			auxCliente.setTelefono(resultado.getString(CLIENTES_TELEFONO));
			auxCliente.setCorreo(resultado.getString(CLIENTES_CORREO));

			listadoCliente.add(auxCliente); 
		}

		return listadoCliente;
	}



	// ********************************* CRUD DE LA TABLA DIRRECIONES*****************************
	// ***********************************************************************************



	public tablaDirecciones obtenerDireccionPorId(Connection conexion, int id) throws SQLException {
		tablaDirecciones retorno = null;

		String sqlSeleccion = "SELECT * FROM " + TABLA_DIRECCIONES + " WHERE " + DIRECCIONES_ID + " = ?";
		try (PreparedStatement prdStat = conexion.prepareStatement(sqlSeleccion)) {
			prdStat.setInt(1, id);

			try (ResultSet resultado = prdStat.executeQuery()) {
				if (resultado.next()) {
					retorno = new tablaDirecciones();
					retorno.setId(resultado.getInt(DIRECCIONES_ID));
					retorno.setDireccion(resultado.getString(DIRECCIONES_DIRECCION));
					retorno.setCodigoPostal(resultado.getString(DIRECCIONES_CODIGO_POSTAL));
					retorno.setLocalidad(resultado.getString(DIRECCIONES_LOCALIDAD));
					retorno.setLatitud(resultado.getDouble(DIRECCIONES_LATITUD));
					retorno.setLongitud(resultado.getDouble(DIRECCIONES_LONGITUD));
					retorno.setIdCliente(resultado.getInt(DIRECCIONES_ID_CLIENTE));
					
				}
			}
		}

		return retorno;
	}


	public void insertarDireccion(Connection conexion, String direccion, String codigoPostal, 
			String localidad, double latitud, double longitud, int idCliente) throws SQLException {
		CommonHelpers ayudaHelpers = new CommonHelpers();
		String sqlInsercion = "INSERT INTO " + TABLA_DIRECCIONES + " (" 
				+ DIRECCIONES_DIRECCION + ", " + DIRECCIONES_CODIGO_POSTAL + ", " 
				+ DIRECCIONES_LOCALIDAD + ", " + DIRECCIONES_LATITUD + ", " 
				+ DIRECCIONES_LONGITUD + ", " + DIRECCIONES_ID_CLIENTE + ") VALUES (?, ?, ?, ?, ?, ?)";

		PreparedStatement prdstInsercion = conexion.prepareStatement(sqlInsercion);
		prdstInsercion.setString(1, direccion);
		prdstInsercion.setString(2, codigoPostal);
		prdstInsercion.setString(3, localidad);
		prdstInsercion.setDouble(4, latitud);
		prdstInsercion.setDouble(5, longitud);
		prdstInsercion.setInt(6, idCliente);

		int filasAfectadas = prdstInsercion.executeUpdate();
		if (filasAfectadas > 0) {
			ayudaHelpers.imprimirSalto("Inserción realizada en la tabla direcciones");
		} else {
			ayudaHelpers.imprimirSalto("Inserción no realizada, hay un error");
		}
	}

	public void actualizarDireccion(Connection conexion, int id, String direccion, String codigoPostal, 
			String localidad, String latitud, String longitud, int idCliente) throws SQLException {
		CommonHelpers ayudaHelpers = new CommonHelpers();
		tablaDirecciones auxDireccion = obtenerDireccionPorId(conexion, id);
		if (auxDireccion== null) {
			ayudaHelpers.imprimirSalto("Cliente no encontrado.");
			return;
		}

		String sqlActualizacion = "UPDATE " + TABLA_DIRECCIONES + " SET " 
				+ DIRECCIONES_DIRECCION + " = ?, "
				+ DIRECCIONES_CODIGO_POSTAL + " = ?, "
				+ DIRECCIONES_LOCALIDAD + " = ?, "
				+ DIRECCIONES_LATITUD + " = ?, "
				+ DIRECCIONES_LONGITUD + " = ?, "
				+ DIRECCIONES_ID_CLIENTE + " = ? WHERE " + DIRECCIONES_ID + " = ?";

		PreparedStatement prdstActualizacion = conexion.prepareStatement(sqlActualizacion);

		if (!direccion.equalsIgnoreCase("")) {
			prdstActualizacion.setString(1, direccion);
		} else {
			prdstActualizacion.setString(1, auxDireccion.getDireccion());
		}
		if (!codigoPostal.equalsIgnoreCase("")) {
			prdstActualizacion.setString(2, codigoPostal);
		} else {
			prdstActualizacion.setString(2, auxDireccion.getCodigoPostal());
		}
		if (!localidad.equalsIgnoreCase("")) {
			prdstActualizacion.setString(3, localidad);
		} else {
			prdstActualizacion.setString(3, auxDireccion.getLocalidad());
		}
		if (!latitud.equalsIgnoreCase("")) {
			prdstActualizacion.setString(4, latitud);
		} else {
			prdstActualizacion.setDouble(4, auxDireccion.getLatitud());
		}
		if (!longitud.equalsIgnoreCase("")) {
			prdstActualizacion.setString(5, longitud);
		} else {
			prdstActualizacion.setDouble(5, auxDireccion.getLongitud());
		}

		prdstActualizacion.setInt(6, id);

		int filasAfectadas = prdstActualizacion.executeUpdate();
		if (filasAfectadas > 0) {
			ayudaHelpers.imprimirSalto("Actualización realizada en la tabla usuarios");
		} else {
			ayudaHelpers.imprimirSalto("Actualización no realizada, hay un error");
		}
	}

	public void borrarDireccionPorId(Connection conexion, int id) throws SQLException {
		CommonHelpers ayudaHelpers = new CommonHelpers();
		String sqlBorrado = "DELETE FROM " + TABLA_DIRECCIONES + " WHERE " + DIRECCIONES_ID + " = ?";

		PreparedStatement prdstBorrado = conexion.prepareStatement(sqlBorrado);
		prdstBorrado.setInt(1, id);

		int filasAfectadas = prdstBorrado.executeUpdate();
		if (filasAfectadas > 0) {
			ayudaHelpers.imprimirSalto("Borrado realizado en la tabla direcciones");
		} else {
			ayudaHelpers.imprimirSalto("Borrado no realizado, hay un error");
		}
	}

	public ArrayList<tablaDirecciones> listarDirecciones(Connection conexion) throws SQLException {
		ArrayList<tablaDirecciones> listadoDirecciones = new ArrayList<>();
		String sqlListado = "SELECT * FROM " + TABLA_DIRECCIONES;

		PreparedStatement prdStat = conexion.prepareStatement(sqlListado);
		ResultSet resultado = prdStat.executeQuery();
		while (resultado.next()) {
			tablaDirecciones auxDireccion = new tablaDirecciones();
			auxDireccion.setId(resultado.getInt(DIRECCIONES_ID));
			auxDireccion.setDireccion(resultado.getString(DIRECCIONES_DIRECCION));
			auxDireccion.setCodigoPostal(resultado.getString(DIRECCIONES_CODIGO_POSTAL));
			auxDireccion.setLocalidad(resultado.getString(DIRECCIONES_LOCALIDAD));
			auxDireccion.setLatitud(resultado.getDouble(DIRECCIONES_LATITUD));
			auxDireccion.setLongitud(resultado.getDouble(DIRECCIONES_LONGITUD));
			auxDireccion.setIdCliente(resultado.getInt(DIRECCIONES_ID_CLIENTE));

			listadoDirecciones.add(auxDireccion);
		}


		return listadoDirecciones;
	}

	
		
	
	
	
	
	// ********************************* CRUD DE LA TABLA TRABAJADORES****************************
	// ***********************************************************************************

	//  OBTENEMOS UN TRABAJADOR POR ID
	public tablaTrabajadores obtenerTrabajadorPorId(Connection conexion, int id) throws SQLException {
		tablaTrabajadores retorno = null;

		String sqlSeleccion = "SELECT * FROM " + TABLA_TRABAJADORES + " WHERE " + TRABAJADORES_ID + " = ?";
		try (PreparedStatement prdStat = conexion.prepareStatement(sqlSeleccion)) {
			prdStat.setInt(1, id);

			try (ResultSet resultado = prdStat.executeQuery()) {
				if (resultado.next()) {
					retorno = new tablaTrabajadores();
					retorno.setId(id);
					retorno.setNombre(resultado.getString(TRABAJADORES_NOMBRE)); 
	                retorno.setApellidos(resultado.getString(TRABAJADORES_APELLIDOS)); 
	                retorno.setTelefono(resultado.getString(TRABAJADORES_TELEFONO));
					retorno.setSs(resultado.getString(TRABAJADORES_SS));
					retorno.setPuesto(resultado.getString(TRABAJADORES_PUESTO));
					retorno.setIdDireccion(resultado.getInt(TRABAJADORES_ID_DIRECCION));
					
				}
			}
		}

		return retorno;
	}

	// INSERTAMOS UN NUEVO TRABAJADOR

	public void insertarTrabajador(Connection conexion,String nombre, String apellidos, String telefono, String ss, String puesto,  int idDireccion) throws SQLException {
		CommonHelpers ayudaHelpers = new CommonHelpers();
		String sqlInsercion = "INSERT INTO " + TABLA_TRABAJADORES + " ("
			    + TRABAJADORES_NOMBRE + ", "  
		        + TRABAJADORES_APELLIDOS + ", " 
		        + TRABAJADORES_TELEFONO + ", "  
				+ TRABAJADORES_SS + ", " 
				+ TRABAJADORES_PUESTO + ", " 
				+ TRABAJADORES_ID_DIRECCION + ") "
				+ "VALUES (?, ?, ?, ?, ?, ?)";

		try (PreparedStatement prdstInsercion = conexion.prepareStatement(sqlInsercion)) {
			prdstInsercion.setString(1, nombre); 
	        prdstInsercion.setString(2, apellidos);
	        prdstInsercion.setString(3, telefono); 
			prdstInsercion.setString(4, ss);
			prdstInsercion.setString(5, puesto);
			prdstInsercion.setInt(6, idDireccion);

			int filasAfectadas = prdstInsercion.executeUpdate();
			if (filasAfectadas > 0) {
				ayudaHelpers.imprimirSalto("Inserción realizada en la tabla trabajadores");
			} else {
				ayudaHelpers.imprimirSalto("Inserción no realizada, hay un error");
			}
		}
	}

	// ACTUALIZAMOS UN TRABAJADOR EXISTENTE
	public void actualizarTrabajador(Connection conexion,String nombre, String apellidos, String telefono, int id, String ss, String puesto,  int idDireccion) throws SQLException {
		CommonHelpers ayudaHelpers = new CommonHelpers();
		tablaTrabajadores auxTrabajador = obtenerTrabajadorPorId(conexion, id);

		if (auxTrabajador== null) {
			ayudaHelpers.imprimirSalto("Cliente no encontrado.");
			return;
		}

		String sqlActualizacion = "UPDATE " + TABLA_TRABAJADORES + " SET " 
				+ TRABAJADORES_NOMBRE + " = ?, "  
		        + TRABAJADORES_APELLIDOS + " = ?, " 
		        + TRABAJADORES_TELEFONO + " = ? " 
				+ TRABAJADORES_SS + " = ?, " 
				+ TRABAJADORES_PUESTO + " = ?, " 
				+ TRABAJADORES_ID_DIRECCION + " = ? WHERE " 
				+ TRABAJADORES_ID + " = ?";

		PreparedStatement prdstActualizacion = conexion.prepareStatement(sqlActualizacion);

		if (!nombre.equalsIgnoreCase("")) {
			prdstActualizacion.setString(1, nombre);
		} else {
			prdstActualizacion.setString(1, auxTrabajador.getNombre());
		}

		if (!apellidos.equalsIgnoreCase("")) {
			prdstActualizacion.setString(2, apellidos);
		} else {
			prdstActualizacion.setString(2, auxTrabajador.getApellidos());
		}
		if (!telefono.equalsIgnoreCase("")) {
			prdstActualizacion.setString(3, telefono);
		} else {
			prdstActualizacion.setString(3, auxTrabajador.getTelefono());
		}
		if (!ss.equalsIgnoreCase("")) {
			prdstActualizacion.setString(4, ss);
		} else {
			prdstActualizacion.setString(4, auxTrabajador.getSs());
		}

		if (!puesto.equalsIgnoreCase("")) {
			prdstActualizacion.setString(5, puesto);
		} else {
			prdstActualizacion.setString(5, auxTrabajador.getPuesto());
		}
		
		if (idDireccion != 0) {
			prdstActualizacion.setInt(6, idDireccion);
		} else {
			prdstActualizacion.setInt(6, auxTrabajador.getIdDireccion());
		}

		prdstActualizacion.setInt(7, id); 


		int filasAfectadas = prdstActualizacion.executeUpdate();
		if (filasAfectadas > 0) {
			ayudaHelpers.imprimirSalto("Actualización realizada en la tabla trabajadores");
		} else {
			ayudaHelpers.imprimirSalto("Actualización no realizada, hay un error");
		}
	}


	public void borrarTrabajadorPorId(Connection conexion, int id) throws SQLException {
		CommonHelpers ayudaHelpers = new CommonHelpers();
		String sqlBorrado = "DELETE FROM " + TABLA_TRABAJADORES + " WHERE " + TRABAJADORES_ID + " = ?";

		try (PreparedStatement prdstBorrado = conexion.prepareStatement(sqlBorrado)) {
			prdstBorrado.setInt(1, id);

			int filasAfectadas = prdstBorrado.executeUpdate();
			if (filasAfectadas > 0) {
				ayudaHelpers.imprimirSalto("Borrado realizado en la tabla trabajadores");
			} else {
				ayudaHelpers.imprimirSalto("Borrado no realizado, hay un error");
			}
		}
	}

	public ArrayList<tablaTrabajadores> listarTrabajadores(Connection conexion) throws SQLException {
		ArrayList<tablaTrabajadores> listadoTrabajadores = new ArrayList<>();
		String sqlListado = "SELECT * FROM " + TABLA_TRABAJADORES;

		try (PreparedStatement prdStat = conexion.prepareStatement(sqlListado);
				ResultSet resultado = prdStat.executeQuery()) {

			while (resultado.next()) {
				tablaTrabajadores auxTrabajador = new tablaTrabajadores();
				auxTrabajador.setId(resultado.getInt(TRABAJADORES_ID));
				auxTrabajador.setNombre(resultado.getString(TRABAJADORES_NOMBRE)); 
	            auxTrabajador.setApellidos(resultado.getString(TRABAJADORES_APELLIDOS));
	            auxTrabajador.setTelefono(resultado.getString(TRABAJADORES_TELEFONO));
				auxTrabajador.setSs(resultado.getString(TRABAJADORES_SS));
				auxTrabajador.setPuesto(resultado.getString(TRABAJADORES_PUESTO));
				auxTrabajador.setIdDireccion(resultado.getInt(TRABAJADORES_ID_DIRECCION));

				listadoTrabajadores.add(auxTrabajador);
			}
		}

		return listadoTrabajadores;
	}


	// ********************************* CRUD DE LA TABLA SALIDAS*****************************
	// ***********************************************************************************

	//  OBTENEMOS UN SALIDA POR ID
	public tablaSalidas obtenerSalidaPorId(Connection conexion, int id) throws SQLException {
		tablaSalidas retorno = null;

		String sqlSeleccion = "SELECT * FROM " + TABLA_SALIDAS + " WHERE " + SALIDAS_ID + " = ?";
		try (PreparedStatement prdStat = conexion.prepareStatement(sqlSeleccion)) {
			prdStat.setInt(1, id);

			try (ResultSet resultado = prdStat.executeQuery()) {
				if (resultado.next()) {
					retorno = new tablaSalidas();
					retorno.setId(resultado.getInt(SALIDAS_ID));
					retorno.setTarea(resultado.getString(SALIDAS_TAREA));
					retorno.setInstalaciones(resultado.getBoolean(SALIDAS_INSTALACIONES));
					retorno.setIncidencias(resultado.getBoolean(SALIDAS_INCIDENCIAS));
					retorno.setSolucion(resultado.getBoolean(SALIDAS_SOLUCION));
					retorno.setDescripcion(resultado.getString(SALIDAS_DESCRIPCION));	
					retorno.setCosteCliente(resultado.getDouble(SALIDAS_COSTE_CLIENTE));					
					// CONVERSION A LOCALDATE
	                java.sql.Date sqlDate = resultado.getDate(SALIDAS_FECHA_TAREA);
	                if (sqlDate != null) {
	                    retorno.setFechaTarea(sqlDate.toLocalDate());
	                } else {
	                    retorno.setFechaTarea(null); 
	                }
					retorno.setIdCliente(resultado.getInt(SALIDAS_ID_CLIENTE));
					retorno.setIdDireccion(resultado.getInt(SALIDAS_ID_DIRECCION));
					retorno.setIdTrabajador(resultado.getInt(SALIDAS_ID_TRABAJADOR));
				}
			}
		}

		return retorno;
	}


	// INSERTAMOS UN NUEVA SALIDA

	public void insertarSalida(Connection conexion, String tareas, boolean instalaciones, boolean incidencias, 
			                   boolean solucion,String descripcion, double costeCliente,  Date fechaTarea,  
			                   int idCliente,int idDireccion,int idTrabajador ) throws SQLException {
		CommonHelpers ayudaHelpers = new CommonHelpers();
		String sqlInsercion = "INSERT INTO " + TABLA_SALIDAS + " (" 
				+ SALIDAS_TAREA + ", " 
				+ SALIDAS_INSTALACIONES + ", " 
				+ SALIDAS_INCIDENCIAS + ", " 
				+ SALIDAS_SOLUCION + ", " 
				+ SALIDAS_DESCRIPCION + ", " 
				+ SALIDAS_COSTE_CLIENTE + ", " 
				+ SALIDAS_FECHA_TAREA + ", "
				+ SALIDAS_ID_CLIENTE +", "
				+ SALIDAS_ID_DIRECCION + ", "
				+ SALIDAS_ID_TRABAJADOR + ") "
				+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try (PreparedStatement prdstInsercion = conexion.prepareStatement(sqlInsercion)) {
			prdstInsercion.setString(1, tareas);
			prdstInsercion.setBoolean(2, instalaciones);
			prdstInsercion.setBoolean(3, incidencias);
			prdstInsercion.setBoolean(4, solucion);
			prdstInsercion.setString(5, descripcion);
			prdstInsercion.setDouble(6, costeCliente);
     		prdstInsercion.setDate(7, new Date(fechaTarea.getTime()));			
			prdstInsercion.setInt(8, idCliente);
			prdstInsercion.setInt(9, idDireccion);
			prdstInsercion.setInt(10, idTrabajador);

			int filasAfectadas = prdstInsercion.executeUpdate();
			if (filasAfectadas > 0) {
				ayudaHelpers.imprimirSalto("Inserción realizada en la tabla salidas");
			} else {
				ayudaHelpers.imprimirSalto("Inserción no realizada, hay un error");
			}
		}
	}

	// ACTUALIZAMOS UNA SALIDA
	


	public void actualizarSalida(Connection conexion, int id, String tarea, String instalaciones, 
	                     		String incidencias, String solucion,String descripcion, 
	                     		String costeCliente, String fechaTarea,
			                    int idCliente, int idDireccion, int idTrabajador) throws SQLException {
		CommonHelpers ayudaHelpers = new CommonHelpers();
		tablaSalidas auxSalida = obtenerSalidaPorId(conexion, id);

		if (auxSalida == null) {
			ayudaHelpers.imprimirSalto("Salida no encontrada.");
			return;
		}

		String sqlActualizacion = "UPDATE " + TABLA_SALIDAS + " SET " 
		     	    + SALIDAS_TAREA + " = ?, " 
		            + SALIDAS_INSTALACIONES + " = ?, " 
		            + SALIDAS_INCIDENCIAS + " = ?, " 
		            + SALIDAS_SOLUCION + " = ?, " 
		            + SALIDAS_DESCRIPCION + " = ?, " 
		            + SALIDAS_COSTE_CLIENTE + " = ?, " 
		            + SALIDAS_FECHA_TAREA + " = ?, "
		            + SALIDAS_ID_CLIENTE + " = ?, "
		            + SALIDAS_ID_DIRECCION + " = ?, "
		            + SALIDAS_ID_TRABAJADOR + " = ? "
		            + "WHERE " + SALIDAS_ID + " = ?";

		PreparedStatement prdstActualizacion = conexion.prepareStatement(sqlActualizacion);
		   if (tarea .equalsIgnoreCase("")) {
             prdstActualizacion.setString(1, tarea);
             } else {
            prdstActualizacion.setString(1, auxSalida.getTarea());
            }
		   if (instalaciones.equalsIgnoreCase("SI")) {
	            prdstActualizacion.setBoolean(2, true);
	        } else if (instalaciones.equalsIgnoreCase("NO")) {
	            prdstActualizacion.setBoolean(2, false);
	        } else {
	            prdstActualizacion.setBoolean(2, auxSalida.isInstalaciones());
	        }

		   if (incidencias.equalsIgnoreCase("SI")) {
	            prdstActualizacion.setBoolean(3, true);
	        } else if (incidencias.equalsIgnoreCase("NO")) {
	            prdstActualizacion.setBoolean(3, false);
	        } else {
	            prdstActualizacion.setBoolean(3, auxSalida.isIncidencias());
	        }
		   if (solucion.equalsIgnoreCase("SI")) {
	            prdstActualizacion.setBoolean(4, true);
	        } else if (solucion.equalsIgnoreCase("NO")) {
	            prdstActualizacion.setBoolean(4, false);
	        } else {
	            prdstActualizacion.setBoolean(4, auxSalida.isSolucion());
	        }
	   
	        if (!descripcion .equalsIgnoreCase("")) {
	            prdstActualizacion.setString(5, descripcion);
	        } else {
	            prdstActualizacion.setString(5, auxSalida.getDescripcion());
	        }

	      
	        if (!costeCliente .equalsIgnoreCase("")) {
	        	prdstActualizacion.setString(6, costeCliente);
	        } else {
	        	
	                prdstActualizacion.setDouble(6, auxSalida.getCosteCliente());
	           
	            
	        }
	        
	        if (fechaTarea != null) {
	            prdstActualizacion.setDate(7, java.sql.Date.valueOf(fechaTarea));
	        } else {
	            prdstActualizacion.setNull(7, java.sql.Types.DATE);
	        }
	   
	        if (idCliente != 0) {
	            prdstActualizacion.setInt(8, idCliente);
	        } else {
	            prdstActualizacion.setInt(8, auxSalida.getIdCliente());
	        }
	        if (idDireccion != 0) {
	            prdstActualizacion.setInt(9, idDireccion);
	        } else {
	            prdstActualizacion.setInt(9, auxSalida.getIdDireccion());
	        }

	        if (idTrabajador != 0) {
	            prdstActualizacion.setInt(10, idTrabajador);
	        } else {
             prdstActualizacion.setInt(10, auxSalida.getIdTrabajador());
	        }

	       
	        prdstActualizacion.setInt(11, id);
			
			

			int filasAfectadas = prdstActualizacion.executeUpdate();
			if (filasAfectadas > 0) {
				ayudaHelpers.imprimirSalto("Actualización realizada en la tabla salidas");
			} else {
				ayudaHelpers.imprimirSalto("Actualización no realizada, hay un error");
			}
		}
	
	
	
	public void borrarSalidaPorId(Connection conexion, int id) throws SQLException {
	    String sqlBorrado = "DELETE FROM " + TABLA_SALIDAS + " WHERE " + SALIDAS_ID + " = ?";

	    try (PreparedStatement prdstBorrado = conexion.prepareStatement(sqlBorrado)) {
	        prdstBorrado.setInt(1, id);

	        int filasAfectadas = prdstBorrado.executeUpdate();
	        if (filasAfectadas > 0) {
	            System.out.println("Borrado realizado en la tabla salidas");
	        } else {
	            System.out.println("Borrado no realizado, hay un error");
	        }
	    }
	}

	
	
	public ArrayList<tablaSalidas> listarSalidas(Connection conexion) throws SQLException {
	    ArrayList<tablaSalidas> listadoSalidas = new ArrayList<>();
	    String sqlListado = "SELECT * FROM " + TABLA_SALIDAS;

	    try (PreparedStatement prdStat = conexion.prepareStatement(sqlListado);
	         ResultSet resultado = prdStat.executeQuery()) {

	        while (resultado.next()) {
	            tablaSalidas salida = new tablaSalidas();

	            salida.setId(resultado.getInt(SALIDAS_ID));
	            salida.setTarea(resultado.getString(SALIDAS_TAREA));
	            salida.setInstalaciones(resultado.getBoolean(SALIDAS_INSTALACIONES));
	            salida.setIncidencias(resultado.getBoolean(SALIDAS_INCIDENCIAS));
	            salida.setSolucion(resultado.getBoolean(SALIDAS_SOLUCION));
	            salida.setDescripcion(resultado.getString(SALIDAS_DESCRIPCION));
	            salida.setCosteCliente(resultado.getDouble(SALIDAS_COSTE_CLIENTE));           
	            // OBTENMOS LA FECHA Y LA CONVERTIMOS A LOCATEDARE
	            java.sql.Date sqlDate = resultado.getDate(SALIDAS_FECHA_TAREA);
	            if (sqlDate != null) {
	                salida.setFechaTarea(sqlDate.toLocalDate());
	            } else {
	                salida.setFechaTarea(null);
	            }
	            
	            salida.setIdCliente(resultado.getInt(SALIDAS_ID_CLIENTE));
	            salida.setIdDireccion(resultado.getInt(SALIDAS_ID_DIRECCION));
	            salida.setIdTrabajador(resultado.getInt(SALIDAS_ID_TRABAJADOR));

	            listadoSalidas.add(salida);
	        }
	    } catch (SQLException e) {
	        System.err.println("Error al listar salidas: " + e.getMessage());
	        throw e; 
	    }

	    return listadoSalidas;
	}
	
	// ********************************* CRUD DE LA TABLA TRABAJADOR_SALIDAS*****************************
		// ***********************************************************************************

	public tablaTrabajadoresSalidas obtenerTrabajadorSalidaPorID(Connection conexion, int idSalida) throws SQLException {
	    tablaTrabajadoresSalidas retorno = null;
	    
	    String sqlSeleccion = "SELECT * FROM " + TABLA_TRABAJADORES_SALIDAS + " WHERE " + TRABAJADORES_SALIDAS_ID_SALIDA + " = ?";
	    try (PreparedStatement prdStat = conexion.prepareStatement(sqlSeleccion)) {
	        prdStat.setInt(1, idSalida);
	        try (ResultSet resultado = prdStat.executeQuery()) {
	            if (resultado.next()) {
	                retorno = new tablaTrabajadoresSalidas();
	                retorno.setId(resultado.getInt(TRABAJADORES_SALIDAS_ID)); 
	                retorno.setIdTrabajador(resultado.getInt(TRABAJADORES_SALIDAS_ID_TRABAJADOR)); 
	                retorno.setIdSalida(resultado.getInt(TRABAJADORES_SALIDAS_ID_SALIDA)); 
	                
	              // MENSAJES DE DEPURACION
	                System.out.println("TrabajadorSalida recuperado: ID=" + retorno.getId() +
	                                   ", ID Trabajador=" + retorno.getIdTrabajador() +
	                                   ", ID Salida=" + retorno.getIdSalida());
	            } else {
	                System.out.println("No se encontró ningún trabajador asociado a la salida con ID: " + idSalida);
	            }
	        }
	    }
	    return retorno;
	}

	

	
	public void insertarTrabajadorSalida(Connection conexion, int idTrabajador, int idSalida) throws SQLException {
	    String sqlInsercion = "INSERT INTO " + TABLA_TRABAJADORES_SALIDAS + " (" 
	            + TRABAJADORES_SALIDAS_ID_TRABAJADOR + ", " 
	            + TRABAJADORES_SALIDAS_ID_SALIDA + ") VALUES (?, ?)";
	    try (PreparedStatement prdstInsercion = conexion.prepareStatement(sqlInsercion)) {
	        prdstInsercion.setInt(1, idTrabajador);
	        prdstInsercion.setInt(2, idSalida);
	        prdstInsercion.executeUpdate();
	    }
	}
	
	

	
	
	public void eliminarTrabajadorSalidaPorId(Connection conexion, int id) throws SQLException {
	    String sqlBorrado = "DELETE FROM " + TABLA_TRABAJADORES_SALIDAS + " WHERE " + TRABAJADORES_SALIDAS_ID + " = ?";

	    try (PreparedStatement prdstBorrado = conexion.prepareStatement(sqlBorrado)) {
	        prdstBorrado.setInt(1, id);

	        int filasAfectadas = prdstBorrado.executeUpdate();
	        if (filasAfectadas > 0) {
	            System.out.println("Borrado realizado en la tabla trabajadores_salidas");
	        } else {
	            System.out.println("Borrado no realizado, hay un error");
	        }
	    }
	}
	
	public void actualizarTrabajadorSalida(Connection conexion, int idTrabajador, int idSalida) throws SQLException {
		CommonHelpers ayudaHelpers = new CommonHelpers();
		tablaTrabajadoresSalidas auxTrabajadorSalida = obtenerTrabajadorSalidaPorID(conexion, idSalida);
		if (auxTrabajadorSalida== null) {
			ayudaHelpers.imprimirSalto("Trabajador no encontrado.");
			return;
		}
		
	    String sqlActualizacion = "UPDATE " + TABLA_TRABAJADORES_SALIDAS 
	            + " SET " + TRABAJADORES_SALIDAS_ID_TRABAJADOR + " = ? "
	            + "WHERE " + TRABAJADORES_SALIDAS_ID_SALIDA + " = ?";

	    try (PreparedStatement prdstActualizacion = conexion.prepareStatement(sqlActualizacion)) {
	        prdstActualizacion.setInt(1, idTrabajador); 
	        prdstActualizacion.setInt(2, idSalida); 

	        int filasAfectadas = prdstActualizacion.executeUpdate();
			if (filasAfectadas > 0) {
				ayudaHelpers.imprimirSalto("Actualización realizada en la tabla clientes");
			} else {
				ayudaHelpers.imprimirSalto("Actualización no realizada, hay un error");
			}
		}
	}

	
	
	
	
	public ArrayList<tablaTrabajadoresSalidas> listarTrabajadoresSalidas(Connection conexion) throws SQLException {
	    ArrayList<tablaTrabajadoresSalidas> listadoTrabajadoresSalidas = new ArrayList<>();
	    String sqlListado = "SELECT * FROM " + TABLA_TRABAJADORES_SALIDAS;

	    try (PreparedStatement prdStat = conexion.prepareStatement(sqlListado);
	         ResultSet resultado = prdStat.executeQuery()) {

	        while (resultado.next()) {
	            
	            tablaTrabajadoresSalidas registro = new tablaTrabajadoresSalidas();	           
	            registro.setId(resultado.getInt(TRABAJADORES_SALIDAS_ID));
	            registro.setIdTrabajador(resultado.getInt(TRABAJADORES_SALIDAS_ID_TRABAJADOR)); 
	            registro.setIdSalida(resultado.getInt(TRABAJADORES_SALIDAS_ID_SALIDA)); 

	          
	            listadoTrabajadoresSalidas.add(registro);
	        }
	    }

	    return listadoTrabajadoresSalidas;
	}





	


	
	}

	
	




		



	
	

	


	






