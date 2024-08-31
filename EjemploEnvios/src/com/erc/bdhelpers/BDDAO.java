package com.erc.bdhelpers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.erc.helpers.CommonHelpers;
import com.erc.model.tablaPaquetes;
import com.erc.model.tablaRemitentes;
import com.erc.model.tablaTarifas;



public class BDDAO {

    // CREAMOS TODAS LAS STATIC FINALES DE CADA TABLA QUE VAMOS A EJECUTAR
    private static final String TABLA_PAQUETES = "paquetes";
    private static final String TABLA_REMITENTES = "remitentes";
    private static final String TABLA_TARIFAS = "tarifas";
   

    // CAMPOS DE DATOS DE LA TABLA PAQUETES
    private static final String TARIFAS_ID = "id";
    private static final String TARIFAS_NOMBRE = "nombre";
    private static final String TARIFAS_PRECIO = "precio";
    
    // CAMPOS DE DATOS DE LA TABLA REMITENTES
    private static final String REMITENTES_ID = "id";
    private static final String REMITENTES_NOMBRE = "nombre";
    private static final String REMITENTES_APELLIDO = "apellido";
    private static final String REMITENTES_DIRECCION = "direccion";
    
    
 // CAMPOS DE DATOS DE LA TABLA PAQUETES
    private static final String PAQUETES_ID = "id";
    private static final String PAQUETES_REFERENCIA = "referencia";
    private static final String PAQUETES_DESTINATARIO = "destinatario";
    private static final String PAQUETES_DIRECCION = "direccion";
    private static final String PAQUETES_PESO = "peso";
    private static final String PAQUETES_ID_REMITENTE = "id_remitente";
    private static final String PAQUETES_ID_TARIFA = "id_tarifa";


    
    
    
    


    // ********************************* CRUD DE LA TABLA TARIFAS ******************************
    // ***********************************************************************************

    public tablaTarifas obtenerTarifasPorId(Connection conexion, int id) throws SQLException {
    	tablaTarifas retorno = new tablaTarifas();
        String sqlSeleccion = "SELECT * FROM " + TABLA_TARIFAS + " WHERE " + TARIFAS_ID + " = ?";
        PreparedStatement prdStat = conexion.prepareStatement(sqlSeleccion);
        prdStat.setInt(1, id);
        ResultSet resultado = prdStat.executeQuery();
        if (resultado.next()) {
            retorno.setId(id);
            retorno.setNombre(resultado.getString(TARIFAS_NOMBRE));
            retorno.setPrecio(resultado.getDouble(TARIFAS_PRECIO));
        }
        return retorno;
    }

    public void insertarTarifas(Connection conexion, String nombre, double precio) throws SQLException {
        CommonHelpers ayudaHelpers = new CommonHelpers();
        String sqlInsercion = "INSERT INTO " + TABLA_TARIFAS + " (" + TARIFAS_NOMBRE + ", " + TARIFAS_PRECIO + ")"
                + " VALUES (?, ?)";
        PreparedStatement prdstInsercion = conexion.prepareStatement(sqlInsercion);
        prdstInsercion.setString(1, nombre);
        prdstInsercion.setDouble(2, precio);
        int filasAfectadas = prdstInsercion.executeUpdate();
        if (filasAfectadas > 0) {
            ayudaHelpers.imprimirSalto("Inserción realizada en la tabla tarifas");
        } else {
            ayudaHelpers.imprimirSalto("Inserción no Realizada, hay un error");
        }
    }

    public void actualizarTarifas(Connection conexion, int id, String nombre, double precio) throws SQLException {
        CommonHelpers ayuHelpers = new CommonHelpers();
        tablaTarifas auxTarifas = obtenerTarifasPorId(conexion, id);
        String sqlActualizacion = "UPDATE " + TABLA_TARIFAS + " SET " + TARIFAS_NOMBRE + " = ?, "
                + TARIFAS_PRECIO + " = ? WHERE " + TARIFAS_ID + " = ?";
        PreparedStatement prdstActualizacion = conexion.prepareStatement(sqlActualizacion);
        if (!nombre.equalsIgnoreCase("")) {
            prdstActualizacion.setString(1, nombre);
        } else {
            prdstActualizacion.setString(1, auxTarifas.getNombre());
        }
        if (precio !=0.0) {
            prdstActualizacion.setDouble(2, precio);
        } else {
            prdstActualizacion.setDouble(2, auxTarifas.getPrecio());
        }
        prdstActualizacion.setInt(3, id);
        int filasAfectadas = prdstActualizacion.executeUpdate();
        if (filasAfectadas > 0) {
            ayuHelpers.imprimirSalto("Actualización realizada de la tabla tarifas");
        } else {
            ayuHelpers.imprimirSalto("Actualización no Realizada, hay un error");
        }
    }

    public void borrarTaifasPorId(Connection conexion, int id) throws SQLException {
        CommonHelpers ayudaHelpers = new CommonHelpers();
        String sqlBorrado = "DELETE FROM " + TABLA_TARIFAS + " WHERE " + TARIFAS_ID + " = ?";
        PreparedStatement prdstBorrado = conexion.prepareStatement(sqlBorrado);
        prdstBorrado.setInt(1, id);
        int filasAfectadas = prdstBorrado.executeUpdate();
        if (filasAfectadas > 0) {
            ayudaHelpers.imprimirSalto("Borrado realizado de la tabla tarifas");
        } else {
            ayudaHelpers.imprimirSalto("Borrado no realizado, hay un error");
        }
    }

    public ArrayList<tablaTarifas> listartablaTarifass(Connection conexion) throws SQLException {
        ArrayList<tablaTarifas> listadotablaTarifas = new ArrayList<>();
        String sqlListado = "SELECT * FROM " + TABLA_TARIFAS;
        PreparedStatement prdStat = conexion.prepareStatement(sqlListado);
        ResultSet resultado = prdStat.executeQuery();
        while (resultado.next()) {
            tablaTarifas auxtablaTarifas = new tablaTarifas();
            auxtablaTarifas.setId(resultado.getInt(TARIFAS_ID));
            auxtablaTarifas.setNombre(resultado.getString(TARIFAS_NOMBRE));
            auxtablaTarifas.setPrecio(resultado.getDouble(TARIFAS_PRECIO));
            listadotablaTarifas.add(auxtablaTarifas); // AÑADIR A LA LISTA
        }
        return listadotablaTarifas;
    }
    
    
    // ********************************* CRUD DE LA TABLA PAQUETES ******************************
    // ***********************************************************************************

    
    public tablaPaquetes obtenerPaquetesPorId(Connection conexion, int id) throws SQLException {
        tablaPaquetes retorno = new tablaPaquetes();
        String sqlSeleccion = "SELECT * FROM " + TABLA_PAQUETES + " WHERE " + PAQUETES_ID + " = ?";
        PreparedStatement prdStat = conexion.prepareStatement(sqlSeleccion);
        prdStat.setInt(1, id);
        ResultSet resultado = prdStat.executeQuery();
        if (resultado.next()) {
            retorno.setId(id);
            retorno.setReferencia(resultado.getString(PAQUETES_REFERENCIA));
            retorno.setDestinatario(resultado.getString(PAQUETES_DESTINATARIO));
            retorno.setDireccion(resultado.getString(PAQUETES_DIRECCION));
            retorno.setPeso(resultado.getDouble(PAQUETES_PESO));
        }
        return retorno;
    }

    public void insertarPaquetes(Connection conexion, String referencia, String destinatario, String direccion, double peso, int id_remitente, int id_tarifa) throws SQLException {
        CommonHelpers ayudaHelpers = new CommonHelpers();
        
        // Validar existencia de id_remitente e id_tarifa
        if (!existeRemitente(conexion, id_remitente)) {
            ayudaHelpers.imprimirSalto("Error: El Id Remitente no existe.");
            return;
        }
        
        if (!existeTarifa(conexion, id_tarifa)) {
            ayudaHelpers.imprimirSalto("Error: El Id Tarifa no existe.");
            return;
        }
        String sqlInsercion = "INSERT INTO " + TABLA_PAQUETES + " (" + PAQUETES_REFERENCIA + ", " + PAQUETES_DESTINATARIO + ", " 
                                                                     + PAQUETES_DIRECCION + ", " + PAQUETES_PESO + ","
                                                                     + PAQUETES_ID_REMITENTE + ", " + PAQUETES_ID_TARIFA + ")"
                + " VALUES (?, ?, ?, ?,?,?)";
        PreparedStatement prdstInsercion = conexion.prepareStatement(sqlInsercion);
        prdstInsercion.setString(1, referencia);
        prdstInsercion.setString(2, destinatario);
        prdstInsercion.setString(3, direccion);
        prdstInsercion.setDouble(4, peso);
        prdstInsercion.setInt(5, id_remitente);
        prdstInsercion.setInt(6, id_tarifa);
        int filasAfectadas = prdstInsercion.executeUpdate();
        if (filasAfectadas > 0) {
            ayudaHelpers.imprimirSalto("Inserción realizada en la tabla paquetes");
        } else {
            ayudaHelpers.imprimirSalto("Inserción no realizada, hay un error");
        }
    }

    public void actualizarPaquetes(Connection conexion, int id, String referencia, String destinatario, String direccion, double peso,int id_remitente, int id_tarifa) throws SQLException {
        CommonHelpers ayuHelpers = new CommonHelpers();
        tablaPaquetes auxPaquetes = obtenerPaquetesPorId(conexion, id);
        
        // Validar existencia de id_remitente e id_tarifa si se proporcionan
        if (id_remitente > 0 && !existeRemitente(conexion, id_remitente)) {
            ayuHelpers.imprimirSalto("Error: El Id Remitente no existe.");
            return;
        }

        if (id_tarifa > 0 && !existeTarifa(conexion, id_tarifa)) {
            ayuHelpers.imprimirSalto("Error: El Id Tarifa no existe.");
            return;
        }
        String sqlActualizacion = "UPDATE " + TABLA_PAQUETES + " SET " + PAQUETES_REFERENCIA + " = ?, "
                + PAQUETES_DESTINATARIO + " = ?, " + PAQUETES_DIRECCION + " = ?, " + PAQUETES_PESO + " = ?," 
        		+ PAQUETES_ID_REMITENTE + " = ?, " + PAQUETES_ID_TARIFA + " = ? WHERE " + PAQUETES_ID + " = ?";
        PreparedStatement prdstActualizacion = conexion.prepareStatement(sqlActualizacion);
        if (!referencia.equalsIgnoreCase("")) {
            prdstActualizacion.setString(1, referencia);
        } else {
            prdstActualizacion.setString(1, auxPaquetes.getReferencia());
        }
        if (!destinatario.equalsIgnoreCase("")) {
            prdstActualizacion.setString(2, destinatario);
        } else {
            prdstActualizacion.setString(2, auxPaquetes.getDestinatario());
        }
        if (!direccion.equalsIgnoreCase("")) {
            prdstActualizacion.setString(3, direccion);
        } else {
            prdstActualizacion.setString(3, auxPaquetes.getDireccion());
        }
        if (peso != 0.0) {
            prdstActualizacion.setDouble(4, peso);
        } else {
            prdstActualizacion.setDouble(4, auxPaquetes.getPeso());
        }   
        
        if (id_remitente ==0) {
            prdstActualizacion.setInt(5, id_remitente);
        } else {
            prdstActualizacion.setInt(5, auxPaquetes.getId_remitente());
        }
        if (id_tarifa ==0) {
            prdstActualizacion.setInt(6, id_tarifa);
        } else {
            prdstActualizacion.setInt(6, auxPaquetes.getId_tarifa());
        }
        prdstActualizacion.setInt(7, id);
        int filasAfectadas = prdstActualizacion.executeUpdate();
        if (filasAfectadas > 0) {
            ayuHelpers.imprimirSalto("Actualización realizada en la tabla paquetes");
        } else {
            ayuHelpers.imprimirSalto("Actualización no realizada, hay un error");
        }
    }

    public void borrarPaquetesPorId(Connection conexion, int id) throws SQLException {
        CommonHelpers ayudaHelpers = new CommonHelpers();
        String sqlBorrado = "DELETE FROM " + TABLA_PAQUETES + " WHERE " + PAQUETES_ID + " = ?";
        PreparedStatement prdstBorrado = conexion.prepareStatement(sqlBorrado);
        prdstBorrado.setInt(1, id);
        int filasAfectadas = prdstBorrado.executeUpdate();
        if (filasAfectadas > 0) {
            ayudaHelpers.imprimirSalto("Borrado realizado en la tabla paquetes");
        } else {
            ayudaHelpers.imprimirSalto("Borrado no realizado, hay un error");
        }
    }

    public ArrayList<tablaPaquetes> listarPaquetes(Connection conexion) throws SQLException {
        ArrayList<tablaPaquetes> listadoPaquetes = new ArrayList<>();
        String sqlListado = "SELECT * FROM " + TABLA_PAQUETES;
        PreparedStatement prdStat = conexion.prepareStatement(sqlListado);
        ResultSet resultado = prdStat.executeQuery();
        while (resultado.next()) {
            tablaPaquetes auxPaquetes = new tablaPaquetes();
            auxPaquetes.setId(resultado.getInt(PAQUETES_ID));
            auxPaquetes.setReferencia(resultado.getString(PAQUETES_REFERENCIA));
            auxPaquetes.setDestinatario(resultado.getString(PAQUETES_DESTINATARIO));
            auxPaquetes.setDireccion(resultado.getString(PAQUETES_DIRECCION));
            auxPaquetes.setPeso(resultado.getDouble(PAQUETES_PESO));
            auxPaquetes.setId_remitente(resultado.getInt(PAQUETES_ID_REMITENTE)); 
            auxPaquetes.setId_tarifa(resultado.getInt(PAQUETES_ID_TARIFA)); 
            listadoPaquetes.add(auxPaquetes);
        }
        return listadoPaquetes;
    }
 // Método para verificar si un ID de tarifa existe
    public static boolean existeTarifa(Connection conexion, int idTarifa) throws SQLException {
        String sqlExistencia = "SELECT COUNT(*) FROM tarifas WHERE id = ?";
        try (PreparedStatement prdStat = conexion.prepareStatement(sqlExistencia)) {
            prdStat.setInt(1, idTarifa);
            try (ResultSet resultado = prdStat.executeQuery()) {
                if (resultado.next()) {
                    return resultado.getInt(1) > 0;
                }
            }
        }
        return false;
    }
    
    public static  boolean existeRemitente(Connection conexion, int idRemitente) throws SQLException {
        String sqlExistencia = "SELECT COUNT(*) FROM remitentes WHERE id = ?";
        try (PreparedStatement prdStat = conexion.prepareStatement(sqlExistencia)) {
            prdStat.setInt(1, idRemitente);
            try (ResultSet resultado = prdStat.executeQuery()) {
                if (resultado.next()) {
                    return resultado.getInt(1) > 0;
                }
            }
        }
        return false;
    }
    
    
    
           
    // ********************************* CRUD DE LA TABLA REMITENTES ******************************
    // ***********************************************************************************

    public tablaRemitentes obtenerRemitentesPorId(Connection conexion, int id) throws SQLException {
        tablaRemitentes retorno = new tablaRemitentes();
        String sqlSeleccion = "SELECT * FROM " + TABLA_REMITENTES + " WHERE " + REMITENTES_ID + " = ?";
        PreparedStatement prdStat = conexion.prepareStatement(sqlSeleccion);
        prdStat.setInt(1, id);
        ResultSet resultado = prdStat.executeQuery();
        if (resultado.next()) {
            retorno.setId(id);
            retorno.setNombre(resultado.getString(REMITENTES_NOMBRE));
            retorno.setApellidos(resultado.getString(REMITENTES_APELLIDO));
            retorno.setDireccion(resultado.getString(REMITENTES_DIRECCION));
        }
        return retorno;
    }

    public void insertarRemitentes(Connection conexion, String nombre, String apellido, String direccion) throws SQLException {
        CommonHelpers ayudaHelpers = new CommonHelpers();
        String sqlInsercion = "INSERT INTO " + TABLA_REMITENTES + " (" + REMITENTES_NOMBRE + ", " + REMITENTES_APELLIDO + ", " + REMITENTES_DIRECCION + ")"
                + " VALUES (?, ?, ?)";
        PreparedStatement prdstInsercion = conexion.prepareStatement(sqlInsercion);
        prdstInsercion.setString(1, nombre);
        prdstInsercion.setString(2, apellido);
        prdstInsercion.setString(3, direccion);
        int filasAfectadas = prdstInsercion.executeUpdate();
        if (filasAfectadas > 0) {
            ayudaHelpers.imprimirSalto("Inserción realizada en la tabla remitentes");
        } else {
            ayudaHelpers.imprimirSalto("Inserción no realizada, hay un error");
        }
    }

    public void actualizarRemitentes(Connection conexion, int id, String nombre, String apellido, String direccion) throws SQLException {
        CommonHelpers ayuHelpers = new CommonHelpers();
        tablaRemitentes auxRemitentes = obtenerRemitentesPorId(conexion, id);
        String sqlActualizacion = "UPDATE " + TABLA_REMITENTES + " SET " + REMITENTES_NOMBRE + " = ?, "
                + REMITENTES_APELLIDO + " = ?, " + REMITENTES_DIRECCION + " = ? WHERE " + REMITENTES_ID + " = ?";
        PreparedStatement prdstActualizacion = conexion.prepareStatement(sqlActualizacion);
        prdstActualizacion.setString(1, nombre.isEmpty() ? auxRemitentes.getNombre() : nombre);
        prdstActualizacion.setString(2, apellido.isEmpty() ? auxRemitentes.getApellidos() : apellido);
        prdstActualizacion.setString(3, direccion.isEmpty() ? auxRemitentes.getDireccion() : direccion);
        prdstActualizacion.setInt(4, id);
        int filasAfectadas = prdstActualizacion.executeUpdate();
        if (filasAfectadas > 0) {
            ayuHelpers.imprimirSalto("Actualización realizada en la tabla remitentes");
        } else {
            ayuHelpers.imprimirSalto("Actualización no realizada, hay un error");
        }
    }

    public void borrarRemitentesPorId(Connection conexion, int id) throws SQLException {
        CommonHelpers ayudaHelpers = new CommonHelpers();
        String sqlBorrado = "DELETE FROM " + TABLA_REMITENTES + " WHERE " + REMITENTES_ID + " = ?";
        PreparedStatement prdstBorrado = conexion.prepareStatement(sqlBorrado);
        prdstBorrado.setInt(1, id);
        int filasAfectadas = prdstBorrado.executeUpdate();
        if (filasAfectadas > 0) {
            ayudaHelpers.imprimirSalto("Borrado realizado en la tabla remitentes");
        } else {
            ayudaHelpers.imprimirSalto("Borrado no realizado, hay un error");
        }
    }

    public ArrayList<tablaRemitentes> listarRemitentes(Connection conexion) throws SQLException {
        ArrayList<tablaRemitentes> listadoRemitentes = new ArrayList<>();
        String sqlListado = "SELECT * FROM " + TABLA_REMITENTES;
        PreparedStatement prdStat = conexion.prepareStatement(sqlListado);
        ResultSet resultado = prdStat.executeQuery();
        while (resultado.next()) {
            tablaRemitentes auxRemitentes = new tablaRemitentes();
            auxRemitentes.setId(resultado.getInt(REMITENTES_ID));
            auxRemitentes.setNombre(resultado.getString(REMITENTES_NOMBRE));
            auxRemitentes.setApellidos(resultado.getString(REMITENTES_APELLIDO));
            auxRemitentes.setDireccion(resultado.getString(REMITENTES_DIRECCION));
            listadoRemitentes.add(auxRemitentes);
        }
        return listadoRemitentes;
    }
    
    }

    
 
    
    

