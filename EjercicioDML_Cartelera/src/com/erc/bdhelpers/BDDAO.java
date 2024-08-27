package com.erc.bdhelpers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.erc.helpers.CommonHelpers;
import com.erc.model.tablaNacionalidades;
import com.erc.model.tablaPersonas;

public class BDDAO {

    // CREAMOS TODAS LAS STATIC FINALES DE CADA TABLA QUE VAMOS A EJECUTAR
    private static final String TABLA_NACIONALIDADES = "nacionalidades";
    private static final String TABLA_PERSONAS = "personas";
    private static final String TABLA_TIPOS = "tipos";
    private static final String TABLA_GENEROS = "generos";
    private static final String TABLA_PEGUIS = "peguis";

    // CAMPOS DE DATOS DE LA TABLA NACIONALIDADES
    private static final String NACIONALIDADES_ID = "id";
    private static final String NACIONALIDADES_GENTILICIO = "gentilicio";
    private static final String NACIONALIDADES_PAIS = "pais";
    
    // CAMPOS DE DATOS DE LA TABLA PERSONAS
    private static final String PERSONAS_ID = "id";
    private static final String PERSONAS_NOMBRE = "nombre";
    private static final String PERSONAS_APELLIDO = "apellidos";
    private static final String PERSONAS_FECHA_NACIMIENTO = "fecha_nacimiento";
    private static final String PERSONAS_ID_NACIONALIDAD = "id_nacionalidad";


    // ********************************* CRUD DE NACIONALIDADES ******************************

    public tablaNacionalidades obtenerNacionalidadesPorId(Connection conexion, int id) throws SQLException {
        tablaNacionalidades retorno = new tablaNacionalidades();
        String sqlSeleccion = "SELECT * FROM " + TABLA_NACIONALIDADES + " WHERE " + NACIONALIDADES_ID + " = ?";
        PreparedStatement prdStat = conexion.prepareStatement(sqlSeleccion);
        prdStat.setInt(1, id);
        ResultSet resultado = prdStat.executeQuery();
        if (resultado.next()) {
            retorno.setId(id);
            retorno.setGentilicio(resultado.getString(NACIONALIDADES_GENTILICIO));
            retorno.setPais(resultado.getString(NACIONALIDADES_PAIS));
        }
        return retorno;
    }

    public void insertarNacionalidades(Connection conexion, String gentilicio, String pais) throws SQLException {
        CommonHelpers ayudaHelpers = new CommonHelpers();
        String sqlInsercion = "INSERT INTO " + TABLA_NACIONALIDADES + " (" + NACIONALIDADES_GENTILICIO + ", " + NACIONALIDADES_PAIS + ")"
                + " VALUES (?, ?)";
        PreparedStatement prdstInsercion = conexion.prepareStatement(sqlInsercion);
        prdstInsercion.setString(1, gentilicio);
        prdstInsercion.setString(2, pais);
        int filasAfectadas = prdstInsercion.executeUpdate();
        if (filasAfectadas > 0) {
            ayudaHelpers.imprimirSalto("Inserción Realizada");
        } else {
            ayudaHelpers.imprimirSalto("Inserción no Realizada");
        }
    }

    public void actualizarNacionalidades(Connection conexion, int id, String gentilicio, String pais) throws SQLException {
        CommonHelpers ayuHelpers = new CommonHelpers();
        tablaNacionalidades auxNacionalidad = obtenerNacionalidadesPorId(conexion, id);
        String sqlActualizacion = "UPDATE " + TABLA_NACIONALIDADES + " SET " + NACIONALIDADES_GENTILICIO + " = ?, "
                + NACIONALIDADES_PAIS + " = ? WHERE " + NACIONALIDADES_ID + " = ?";
        PreparedStatement prdstActualizacion = conexion.prepareStatement(sqlActualizacion);
        if (!gentilicio.equalsIgnoreCase("")) {
            prdstActualizacion.setString(1, gentilicio);
        } else {
            prdstActualizacion.setString(1, auxNacionalidad.getGentilicio());
        }
        if (!pais.equalsIgnoreCase("")) {
            prdstActualizacion.setString(2, pais);
        } else {
            prdstActualizacion.setString(2, auxNacionalidad.getPais());
        }
        prdstActualizacion.setInt(3, id);
        int filasAfectadas = prdstActualizacion.executeUpdate();
        if (filasAfectadas > 0) {
            ayuHelpers.imprimirSalto("Actualización Realizada");
        } else {
            ayuHelpers.imprimirSalto("Actualización no Realizada");
        }
    }

    public void borrarNacionalidadesPorId(Connection conexion, int id) throws SQLException {
        CommonHelpers ayudaHelpers = new CommonHelpers();
        String sqlBorrado = "DELETE FROM " + TABLA_NACIONALIDADES + " WHERE " + NACIONALIDADES_ID + " = ?";
        PreparedStatement prdstBorrado = conexion.prepareStatement(sqlBorrado);
        prdstBorrado.setInt(1, id);
        int filasAfectadas = prdstBorrado.executeUpdate();
        if (filasAfectadas > 0) {
            ayudaHelpers.imprimirSalto("Borrado Realizado");
        } else {
            ayudaHelpers.imprimirSalto("Borrado no Realizado");
        }
    }

    public ArrayList<tablaNacionalidades> listartablaNacionalidadess(Connection conexion) throws SQLException {
        ArrayList<tablaNacionalidades> listadotablaNacionalidadess = new ArrayList<>();
        String sqlListado = "SELECT * FROM " + TABLA_NACIONALIDADES;
        PreparedStatement prdStat = conexion.prepareStatement(sqlListado);
        ResultSet resultado = prdStat.executeQuery();
        while (resultado.next()) {
            tablaNacionalidades auxtablaNacionalidades = new tablaNacionalidades();
            auxtablaNacionalidades.setId(resultado.getInt(NACIONALIDADES_ID));
            auxtablaNacionalidades.setGentilicio(resultado.getString(NACIONALIDADES_GENTILICIO));
            auxtablaNacionalidades.setPais(resultado.getString(NACIONALIDADES_PAIS));
            listadotablaNacionalidadess.add(auxtablaNacionalidades); // AÑADIR A LA LISTA
        }
        return listadotablaNacionalidadess;
    }
    
    // ********************************* CRUD DE PERSONAS ******************************

    public tablaPersonas obtenerPersonasPorId(Connection conexion, int id) throws SQLException {
        tablaPersonas retorno = new tablaPersonas();
        String sqlSeleccion = "SELECT * FROM " + TABLA_PERSONAS + " WHERE " + PERSONAS_ID + " = ?";
        PreparedStatement prdStat = conexion.prepareStatement(sqlSeleccion);
        prdStat.setInt(1, id);
        ResultSet resultado = prdStat.executeQuery();
        if (resultado.next()) {
            retorno.setId(id);
            retorno.setNombre(resultado.getString(PERSONAS_NOMBRE));
            retorno.setApellido(resultado.getString(PERSONAS_APELLIDO));
            retorno.setFechaNacimiento(null);
            retorno.setIdNacionalidad(resultado.getInt(PERSONAS_ID_NACIONALIDAD));
        }
        return retorno;
    }

    public void insertarPersonas(Connection conexion, String nombre, String apellido, java.util.Date fechaNacimiento, int idNacionalidad) throws SQLException {
        CommonHelpers ayudaHelpers = new CommonHelpers();
        String sqlInsercion = "INSERT INTO " + TABLA_PERSONAS + " (" + PERSONAS_NOMBRE + ", " + PERSONAS_APELLIDO + ", " 
                + PERSONAS_FECHA_NACIMIENTO + ", " + PERSONAS_ID_NACIONALIDAD + ") VALUES (?, ?, ?, ?)";
        PreparedStatement prdstInsercion = conexion.prepareStatement(sqlInsercion);
        prdstInsercion.setString(1, nombre);
        prdstInsercion.setString(2, apellido);
        prdstInsercion.setTimestamp(3, new java.sql.Timestamp(fechaNacimiento.getTime()));
        prdstInsercion.setInt(4, idNacionalidad);
        int filasAfectadas = prdstInsercion.executeUpdate();
        if (filasAfectadas > 0) {
            ayudaHelpers.imprimirSalto("Inserción Realizada");
        } else {
            ayudaHelpers.imprimirSalto("Inserción no Realizada");
        }
    }

    public void actualizarPersonas(Connection conexion, int id, String nombre, String apellido, java.util.Date fechaNacimiento, int idNacionalidad) throws SQLException {
        CommonHelpers ayudaHelpers = new CommonHelpers();
        tablaPersonas auxPersonas = obtenerPersonasPorId(conexion, id);
        String sqlActualizacion = "UPDATE " + TABLA_PERSONAS + " SET " + PERSONAS_NOMBRE + " = ?, " 
                + PERSONAS_APELLIDO + " = ?, " + PERSONAS_FECHA_NACIMIENTO + " = ?, " 
                + PERSONAS_ID_NACIONALIDAD + " = ? WHERE " + PERSONAS_ID + " = ?";
        PreparedStatement prdstActualizacion = conexion.prepareStatement(sqlActualizacion);
        prdstActualizacion.setString(1, nombre.equals("") ? auxPersonas.getNombre() : nombre);
        prdstActualizacion.setString(2, apellido.equals("") ? auxPersonas.getApellido() : apellido);
        prdstActualizacion.setDate(3, fechaNacimiento == null ? auxPersonas.getFechaNacimiento();
        prdstActualizacion.setInt(4, idNacionalidad == 0 ? auxPersonas.getIdNacionalidad() : idNacionalidad);
        prdstActualizacion.setInt(5, id);
        int filasAfectadas = prdstActualizacion.executeUpdate();
        if (filasAfectadas > 0) {
            ayudaHelpers.imprimirSalto("Actualización Realizada");
        } else {
            ayudaHelpers.imprimirSalto("Actualización no Realizada");
        }
    }

    public void borrarPersonasPorId(Connection conexion, int id) throws SQLException {
        CommonHelpers ayudaHelpers = new CommonHelpers();
        String sqlBorrado = "DELETE FROM " + TABLA_PERSONAS + " WHERE " + PERSONAS_ID + " = ?";
        PreparedStatement prdstBorrado = conexion.prepareStatement(sqlBorrado);
        prdstBorrado.setInt(1, id);
        int filasAfectadas = prdstBorrado.executeUpdate();
        if (filasAfectadas > 0) {
            ayudaHelpers.imprimirSalto("Borrado Realizado");
        } else {
            ayudaHelpers.imprimirSalto("Borrado no Realizado");
        }
    }

    public ArrayList<tablaPersonas> listarPersonas(Connection conexion) throws SQLException {
        ArrayList<tablaPersonas> listadoPersonas = new ArrayList<>();
        String sqlListado = "SELECT * FROM " + TABLA_PERSONAS;
        PreparedStatement prdStat = conexion.prepareStatement(sqlListado);
        ResultSet resultado = prdStat.executeQuery();
        while (resultado.next()) {
            tablaPersonas auxPersonas = new tablaPersonas();
            auxPersonas.setId(resultado.getInt(PERSONAS_ID));
            auxPersonas.setNombre(resultado.getString(PERSONAS_NOMBRE));
            auxPersonas.setApellido(resultado.getString(PERSONAS_APELLIDO));
            auxPersonas.setFechaNacimiento(null);
            auxPersonas.setIdNacionalidad(resultado.getInt(PERSONAS_ID_NACIONALIDAD));
            listadoPersonas.add(auxPersonas);
        }
        return listadoPersonas;
    }
}
