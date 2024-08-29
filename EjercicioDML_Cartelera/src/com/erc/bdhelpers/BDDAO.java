package com.erc.bdhelpers;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.erc.helpers.CommonHelpers;
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

public class BDDAO {

    // CREAMOS TODAS LAS STATIC FINALES DE CADA TABLA QUE VAMOS A EJECUTAR
    private static final String TABLA_NACIONALIDADES = "nacionalidades";
    private static final String TABLA_PERSONAS = "personas";
    private static final String TABLA_PERSONAJES = "personaJES";
    private static final String TABLA_TIPOS = "tipos";
    private static final String TABLA_GENEROS = "generos";
    private static final String TABLA_PEGUIS = "peguis";
    private static final String TABLA_DIRECTORES = "directores";
    private static final String TABLA_ACTORES = "actores";
    private static final String TABLA_PRODUCTORES = "actores";
    private static final String TABLA_PELICULAS = "peliculas";
    

    // CAMPOS DE DATOS DE LA TABLA NACIONALIDADES
    private static final String NACIONALIDADES_ID = "id";
    private static final String NACIONALIDADES_GENTILICIO = "gentilicio";
    private static final String NACIONALIDADES_PAIS = "pais";
    
    // CAMPOS DE DATOS DE LA TABLA PERSONAS
    private static final String PERSONAS_ID = "id";
    private static final String PERSONAS_NOMBRE = "nombre";
    private static final String PERSONAS_APELLIDO = "apellido";
    private static final String PERSONAS_FECHA_NACIMIENTO = "fecha_nacimiento";
    private static final String PERSONAS_ID_NACIONALIDAD = "id_nacionalidad";
    
    // CAMPOS DE DATOS DE LA TABLA PERSONAS
    private static final String PERSONAJES_ID = "id";
    private static final String PERSONAJES_NOMBRE = "nombre";
    private static final String PERSONAJES_EDAD = "edad";
    private static final String PERSONAJES_DESCRIPCION = "descripcion";
    
    // CAMPOS DE DATOS DE LA TABLA TIPOS
    private static final String TIPOS_ID = "id";
    private static final String TIPOS_NOMBRE = "nombre";
    
    // CAMPOS DE DATOS DE LA TABLA GENEROS
    private static final String GENEROS_ID = "id";
    private static final String GENEROS_NOMBRE = "nombre";
    
    // CAMPOS DE DATOS DE LA TABLA PEGUIS
    private static final String PEGUIS_ID = "id";
    private static final String PEGUIS_NOMBRE = "nombre";
    private static final String PEGUIS_EDAD = "edad";
    
    // CAMPOS DE DATOS DE LA TABLA DIRECTORES
    private static final String DIRECTORES_ID = "id";
    private static final String DIRECTORES_ALMA_MATER = "alma_mater";
    private static final String DIRECTORES_ID_PERSONA = "id_persona";
    
    // CAMPOS DE DATOS DE LA TABLA ACTORES
    private static final String ACTORES_ID = "id";
    private static final String ACTORES_SALARIO = "salario";
    private static final String ACTORES_ID_PERSONA = "id_persona";
    
 // CAMPOS DE DATOS DE LA TABLA PRODUCTORES
    private static final String PRODUCTORES_ID = "id";
    private static final String PRODUCTORES_INVERSION = "inversion";
    private static final String PRODUCTORES_ID_PERSONA = "id_persona";
    
    // CAMPOS DE DATOS DE LA TABLA PELICULAS
    private static final String PELICULAS_ID = "id";
    private static final String PELICULAS_TITULO = "titulo";
    private static final String PELICULAS_FECHA = "fecha";
    private static final String PELICULAS_DURACION = "duracion";
    private static final String PELICULAS_ID_DIRECTOR = "id_director";
    private static final String PELICULAS_ID_PRODUCTOR= "id_productor";
    private static final String PELICULAS_ID_PEGUI= "id_pegui";
    
    
    


    // ********************************* CRUD DE NACIONALIDADES ******************************
    // ***********************************************************************************

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
    // ***********************************************************************************

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
            retorno.setFechaNacimiento(resultado.getDate(PERSONAS_FECHA_NACIMIENTO));
            retorno.setIdNacionalidad(resultado.getInt(PERSONAS_ID_NACIONALIDAD));
        }
        return retorno;
    }

    public void insertarPersonas(Connection conexion, String nombre, String apellido, 
    		                     Date fechaNacimiento, int idNacionalidad) throws SQLException {
        CommonHelpers ayudaHelpers = new CommonHelpers();
        String sqlInsercion = "INSERT INTO " + TABLA_PERSONAS + 
        		              " (" + PERSONAS_NOMBRE + ", " + PERSONAS_APELLIDO + ", " 
                                   + PERSONAS_FECHA_NACIMIENTO + ", " + PERSONAS_ID_NACIONALIDAD + ")"
                                   + " VALUES (?, ?, ?, ?)";
        PreparedStatement prdstInsercion = conexion.prepareStatement(sqlInsercion);
        prdstInsercion.setString(1, nombre);
        prdstInsercion.setString(2, apellido);
        if (fechaNacimiento != null) {
        	 prdstInsercion.setDate(3, new Date(fechaNacimiento.getTime()));
        } else {
        	prdstInsercion.setNull(3, java.sql.Types.DATE);
        }
        prdstInsercion.setInt(4, idNacionalidad);
        int filasAfectadas = prdstInsercion.executeUpdate();
        if (filasAfectadas > 0) {
            ayudaHelpers.imprimirSalto("Inserción Realizada");
        } else {
            ayudaHelpers.imprimirSalto("Inserción no Realizada");
        }
    }
    

    

    public void actualizarPersonas(Connection conexion, int id, String nombre, String apellido,
    		                       Date fechaNacimiento, int idNacionalidad) throws SQLException {
        CommonHelpers ayudaHelpers = new CommonHelpers();
        tablaPersonas auxPersonas = obtenerPersonasPorId(conexion, id);
        String sqlActualizacion = "UPDATE " + TABLA_PERSONAS + " SET " + PERSONAS_NOMBRE + " = ?, " 
                + PERSONAS_APELLIDO + " = ?, " + PERSONAS_FECHA_NACIMIENTO + " = ?, " 
                + PERSONAS_ID_NACIONALIDAD + " = ? WHERE " + PERSONAS_ID + " = ?";
        PreparedStatement prdstActualizacion = conexion.prepareStatement(sqlActualizacion);
        
        if (!nombre.equalsIgnoreCase("")) {
            prdstActualizacion.setString(1, nombre);
        } else {
            prdstActualizacion.setString(1, auxPersonas.getNombre());
        }
        
        if (!apellido.equalsIgnoreCase("")) {
            prdstActualizacion.setString(2, apellido);
        } else {
            prdstActualizacion.setString(2, auxPersonas.getApellido());
        }
        
        if (fechaNacimiento != null) {
        	prdstActualizacion.setDate(3, new Date(fechaNacimiento.getTime()));
        } else {
            prdstActualizacion.setDate(3, auxPersonas.getFechaNacimiento());
        }
        
        if (idNacionalidad == 0) {            
            prdstActualizacion.setInt(4, auxPersonas.getIdNacionalidad());
        } else {
            
            prdstActualizacion.setInt(4, idNacionalidad);
        }
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
            auxPersonas.setFechaNacimiento(resultado.getDate(PERSONAS_FECHA_NACIMIENTO));
            auxPersonas.setIdNacionalidad(resultado.getInt(PERSONAS_ID_NACIONALIDAD));
            listadoPersonas.add(auxPersonas);
        }
        return listadoPersonas;
    }
    
    // ********************************* CRUD DE PERSONAJES******************************
    // ***********************************************************************************
    
    public tablaPersonajes obtenerPersonajesPorId(Connection conexion, int id) throws SQLException {
        tablaPersonajes retorno = new tablaPersonajes();
        String sqlSeleccion = "SELECT * FROM " + TABLA_PERSONAJES + " WHERE " + PERSONAJES_ID + " = ?";
        PreparedStatement prdStat = conexion.prepareStatement(sqlSeleccion);
        prdStat.setInt(1, id);
        ResultSet resultado = prdStat.executeQuery();
        if (resultado.next()) {
            retorno.setId(resultado.getInt(PERSONAJES_ID));
            retorno.setNombre(resultado.getString(PERSONAJES_NOMBRE));
            retorno.setEdad(resultado.getInt(PERSONAJES_EDAD));
            retorno.setDescripcion(resultado.getString(PERSONAJES_DESCRIPCION));
        }
        return retorno;
    }

    
    
    
    
    public void insertarPersonaje(Connection conexion, String nombre, 
    		                      int edad, String descripcion) throws SQLException {
        String sqlInsercion = "INSERT INTO " + TABLA_PERSONAJES +
        		              " (" + PERSONAJES_NOMBRE + ", " + PERSONAJES_EDAD + ", " 
                                   + PERSONAJES_DESCRIPCION + ") "
                                   + "VALUES (?, ?, ?)";
        PreparedStatement prdstInsercion = conexion.prepareStatement(sqlInsercion);
        prdstInsercion.setString(1, nombre);
        prdstInsercion.setInt(2, edad);
        prdstInsercion.setString(3, descripcion);
        int filasAfectadas = prdstInsercion.executeUpdate();
        if (filasAfectadas > 0) {
            System.out.println("Inserción Realizada");
        } else {
            System.out.println("Inserción no Realizada");
        }
    }
    
    public void actualizarPersonaje(Connection conexion, int id, String nombre, int edad, String descripcion) throws SQLException {
       
        tablaPersonajes auxPersonaje = obtenerPersonajesPorId(conexion, id);       
        String sqlActualizacion = "UPDATE " + TABLA_PERSONAJES + " SET " 
            + PERSONAJES_NOMBRE + " = ?, " 
            + PERSONAJES_EDAD + " = ?, " 
            + PERSONAJES_DESCRIPCION + " = ? WHERE " + PERSONAJES_ID + " = ?";

        PreparedStatement prdstActualizacion = conexion.prepareStatement(sqlActualizacion);       
        if (!nombre.isEmpty()) {
            prdstActualizacion.setString(1, nombre);
        } else {
            prdstActualizacion.setString(1, auxPersonaje.getNombre());
        }
       
        if (edad != -1) {
            prdstActualizacion.setInt(2, edad);
        } else {
            prdstActualizacion.setInt(2, auxPersonaje.getEdad()); 
        }
        
        if (!descripcion.isEmpty()) {
            prdstActualizacion.setString(3, descripcion);
        } else {
            prdstActualizacion.setString(3, auxPersonaje.getDescripcion());    
        }
       
        prdstActualizacion.setInt(4, id);
       
        int filasAfectadas = prdstActualizacion.executeUpdate();
        if (filasAfectadas > 0) {
            System.out.println("Actualización Realizada");
        } else {
            System.out.println("Actualización no Realizada");
        }
    }

    
    
    
    public void borrarPersonajePorId(Connection conexion, int id) throws SQLException {
        String sqlBorrado = "DELETE FROM " + TABLA_PERSONAJES + " WHERE " + PERSONAJES_ID + " = ?";
        PreparedStatement prdstBorrado = conexion.prepareStatement(sqlBorrado);
        prdstBorrado.setInt(1, id);
        int filasAfectadas = prdstBorrado.executeUpdate();
        if (filasAfectadas > 0) {
            System.out.println("Borrado Realizado");
        } else {
            System.out.println("Borrado no Realizado");
        }
    }

    public ArrayList<tablaPersonajes> listarPersonajes(Connection conexion) throws SQLException {
        ArrayList<tablaPersonajes> listadoPersonajes = new ArrayList<>();
        String sqlListado = "SELECT * FROM " + TABLA_PERSONAJES;
        PreparedStatement prdStat = conexion.prepareStatement(sqlListado);
        ResultSet resultado = prdStat.executeQuery();
        while (resultado.next()) {
            tablaPersonajes auxPersonaje = new tablaPersonajes();
            auxPersonaje.setId(resultado.getInt(PERSONAJES_ID));
            auxPersonaje.setNombre(resultado.getString(PERSONAJES_NOMBRE));
            auxPersonaje.setEdad(resultado.getInt(PERSONAJES_EDAD));
            auxPersonaje.setDescripcion(resultado.getString(PERSONAJES_DESCRIPCION));
            listadoPersonajes.add(auxPersonaje);
        }
        return listadoPersonajes;
    }

    // ********************************* CRUD DE TIPOS******************************
    // ***********************************************************************************
    
    public tablaTipos obtenerTiposPorId(Connection conexion, int id) throws SQLException {
    	tablaTipos retorno = new tablaTipos();
        String sqlSeleccion = "SELECT * FROM " + TABLA_TIPOS + " WHERE " + TIPOS_ID + " = ?";
        PreparedStatement prdStat = conexion.prepareStatement(sqlSeleccion);
        prdStat.setInt(1, id);
        ResultSet resultado = prdStat.executeQuery();       
        if (resultado.next()) {
        	retorno.setId(resultado.getInt(TIPOS_ID));
        	retorno.setNombre(resultado.getString(TIPOS_NOMBRE));
        
                }
        return retorno;
            }
    
    
    public void insertarTipos(Connection conexion, String nombre) throws SQLException {
        String sqlInsercion = "INSERT INTO " + TABLA_TIPOS +
        		              " (" + TIPOS_NOMBRE + ") VALUES (?)";
        try (PreparedStatement prdstInsercion = conexion.prepareStatement(sqlInsercion)) {
            prdstInsercion.setString(1, nombre);
            int filasAfectadas = prdstInsercion.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("Tipo insertado correctamente.");
            } else {
                System.out.println("No se pudo insertar el tipo.");
            }
        }
    }

    
    public void actualizarTipos(Connection conexion, int id, String nombre) throws SQLException {
       
        tablaTipos auxtipoActual = obtenerTiposPorId(conexion, id);

        String sqlActualizacion = "UPDATE " + TABLA_TIPOS + " SET " 
                                  + TIPOS_NOMBRE + " = ? WHERE " + TIPOS_ID + " = ?";
        
        PreparedStatement prdstActualizacion = conexion.prepareStatement(sqlActualizacion);      
        if (!nombre.isEmpty()) {
            prdstActualizacion.setString(1, nombre);
        } else {
            prdstActualizacion.setString(1, auxtipoActual.getNombre());
        }
            
            int filasAfectadas = prdstActualizacion.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("Actualización Realizada");
            } else {
                System.out.println("Actualización no Realizada");
            }
        }
    
        public void borrarTiposPorId(Connection conexion, int id) throws SQLException {
        String sqlEliminacion = "DELETE FROM " + TABLA_TIPOS + " WHERE " + TIPOS_ID + " = ?";
        try (PreparedStatement prdstEliminacion = conexion.prepareStatement(sqlEliminacion)) {
            prdstEliminacion.setInt(1, id);
            int filasAfectadas = prdstEliminacion.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("Tipo eliminado correctamente.");
            } else {
                System.out.println("No se pudo eliminar el tipo.");
            }
        }
    }
        public ArrayList<tablaTipos> listarTipos(Connection conexion) throws SQLException {
            ArrayList<tablaTipos> listaTipos = new ArrayList<>();
            String sqlListado = "SELECT * FROM " + TABLA_TIPOS;
            PreparedStatement prdStat = conexion.prepareStatement(sqlListado);
            ResultSet resultado = prdStat.executeQuery();
            while (resultado.next()) {
                tablaPersonajes auxPersonaje = new tablaPersonajes();
                auxPersonaje.setId(resultado.getInt(TIPOS_ID));
                auxPersonaje.setNombre(resultado.getString(TIPOS_NOMBRE));
            }
            return listaTipos;
        }

    
     // ********************************* CRUD DE GENEROS ******************************
        // ***********************************************************************************
        
        
        public tablaGeneros obtenerGenerosPorId(Connection conexion, int id) throws SQLException {
        	tablaGeneros retorno = new tablaGeneros();
            String sqlSeleccion = "SELECT * FROM " + TABLA_GENEROS + " WHERE " + GENEROS_ID + " = ?";
            PreparedStatement prdStat = conexion.prepareStatement(sqlSeleccion);
            prdStat.setInt(1, id);
            ResultSet resultado = prdStat.executeQuery();       
            if (resultado.next()) {
            	retorno.setId(resultado.getInt(GENEROS_ID));
            	retorno.setNombre(resultado.getString(GENEROS_NOMBRE));
            
                    }
            return retorno;
                }
        
        
        public void insertarGeneros(Connection conexion, String nombre) throws SQLException {
            String sqlInsercion = "INSERT INTO " + TABLA_GENEROS +
            		              " (" + GENEROS_NOMBRE + ") VALUES (?)";
            try (PreparedStatement prdstInsercion = conexion.prepareStatement(sqlInsercion)) {
                prdstInsercion.setString(1, nombre);
                int filasAfectadas = prdstInsercion.executeUpdate();
                if (filasAfectadas > 0) {
                    System.out.println("Tipo insertado correctamente.");
                } else {
                    System.out.println("No se pudo insertar el tipo.");
                }
            }
        }

        
        public void actualizarGeneros(Connection conexion, int id, String nombre) throws SQLException {
           
            tablaTipos auxGeneroActual = obtenerTiposPorId(conexion, id);

            String sqlActualizacion = "UPDATE " + TABLA_GENEROS + " SET " 
                                      + GENEROS_NOMBRE + " = ? WHERE " + GENEROS_ID + " = ?";
            
            PreparedStatement prdstActualizacion = conexion.prepareStatement(sqlActualizacion);      
            if (!nombre.isEmpty()) {
                prdstActualizacion.setString(1, nombre);
            } else {
                prdstActualizacion.setString(1, auxGeneroActual.getNombre());
            }
                
                int filasAfectadas = prdstActualizacion.executeUpdate();
                if (filasAfectadas > 0) {
                    System.out.println("Actualización Realizada");
                } else {
                    System.out.println("Actualización no Realizada");
                }
            }
        
            public void borrarGenerosPorId(Connection conexion, int id) throws SQLException {
            String sqlEliminacion = "DELETE FROM " + TABLA_GENEROS + " WHERE " + GENEROS_ID + " = ?";
            try (PreparedStatement prdstEliminacion = conexion.prepareStatement(sqlEliminacion)) {
                prdstEliminacion.setInt(1, id);
                int filasAfectadas = prdstEliminacion.executeUpdate();
                if (filasAfectadas > 0) {
                    System.out.println("Tipo eliminado correctamente.");
                } else {
                    System.out.println("No se pudo eliminar el tipo.");
                }
            }
        }
            public ArrayList<tablaGeneros> listarGeneros(Connection conexion) throws SQLException {
                ArrayList<tablaGeneros> listaGeneros = new ArrayList<>();
                String sqlListado = "SELECT * FROM " + TABLA_GENEROS;
                PreparedStatement prdStat = conexion.prepareStatement(sqlListado);
                ResultSet resultado = prdStat.executeQuery();
                while (resultado.next()) {
                    tablaPersonajes auxPersonaje = new tablaPersonajes();
                    auxPersonaje.setId(resultado.getInt(GENEROS_ID));
                    auxPersonaje.setNombre(resultado.getString(GENEROS_NOMBRE));
                }
                return listaGeneros;
            }

        
            // ********************************* CRUD DE EDAD ******************************
            // ***********************************************************************************
            
            
            
            public tablaPeguis obtenerPeguis(Connection conexion, int id) throws SQLException {
                tablaPeguis retorno = new tablaPeguis();
                String sqlSeleccion = "SELECT * FROM " + TABLA_PEGUIS + " WHERE " + PEGUIS_ID + " = ?";
                PreparedStatement prdStat = conexion.prepareStatement(sqlSeleccion);
                prdStat.setInt(1, id);
                ResultSet resultado = prdStat.executeQuery();
                if (resultado.next()) {
                    retorno.setId(resultado.getInt(PEGUIS_ID));
                    retorno.setNombre(resultado.getString(PEGUIS_NOMBRE));
                    retorno.setEdad(resultado.getInt(PEGUIS_EDAD));
                    
                }
                return retorno;
            }

            
            
            
            
            public void insertarPeguis(Connection conexion, String nombre, 
            		                      int edad) throws SQLException {
                String sqlInsercion = "INSERT INTO " + TABLA_PEGUIS +
                		              " (" + PEGUIS_NOMBRE + ", " + PEGUIS_EDAD + ", " + ") "
                                           + "VALUES (?, ?, ?)";
                PreparedStatement prdstInsercion = conexion.prepareStatement(sqlInsercion);
                prdstInsercion.setString(1, nombre);
                prdstInsercion.setInt(2, edad);
                
                int filasAfectadas = prdstInsercion.executeUpdate();
                if (filasAfectadas > 0) {
                    System.out.println("Inserción Realizada");
                } else {
                    System.out.println("Inserción no Realizada");
                }
            }
            
            public void actualizarPeguis(Connection conexion, int id, String nombre, int edad) throws SQLException {
               
                tablaPeguis auxPeguis = obtenerPeguis(conexion, id);       
                String sqlActualizacion = "UPDATE " + TABLA_PEGUIS + " SET " 
                    + PEGUIS_NOMBRE + " = ?, " 
                    + PEGUIS_EDAD + " = ?"
                    + "WHERE " + PEGUIS_ID + " = ?";

                PreparedStatement prdstActualizacion = conexion.prepareStatement(sqlActualizacion);       
                if (!nombre.isEmpty()) {
                    prdstActualizacion.setString(1, nombre);
                } else {
                    prdstActualizacion.setString(1, auxPeguis.getNombre());
                }
               
                if (edad != -1) {
                    prdstActualizacion.setInt(2, edad);
                } else {
                    prdstActualizacion.setInt(2, auxPeguis.getEdad()); 
                }
                
              
               
                prdstActualizacion.setInt(3, id);
               
                int filasAfectadas = prdstActualizacion.executeUpdate();
                if (filasAfectadas > 0) {
                    System.out.println("Actualización Realizada");
                } else {
                    System.out.println("Actualización no Realizada");
                }
            }

            
            
            
            public void borrarPeguisPorId(Connection conexion, int id) throws SQLException {
                String sqlBorrado = "DELETE FROM " + TABLA_PEGUIS + " WHERE " + PEGUIS_ID + " = ?";
                PreparedStatement prdstBorrado = conexion.prepareStatement(sqlBorrado);
                prdstBorrado.setInt(1, id);
                int filasAfectadas = prdstBorrado.executeUpdate();
                if (filasAfectadas > 0) {
                    System.out.println("Borrado Realizado");
                } else {
                    System.out.println("Borrado no Realizado");
                }
            }

            public ArrayList<tablaPeguis> listarPeguis(Connection conexion) throws SQLException {
                ArrayList<tablaPeguis> listadoPeguis = new ArrayList<>();
                String sqlListado = "SELECT * FROM " + TABLA_PEGUIS;
                PreparedStatement prdStat = conexion.prepareStatement(sqlListado);
                ResultSet resultado = prdStat.executeQuery();
                while (resultado.next()) {
                    tablaPeguis auxPeguis = new tablaPeguis();
                    auxPeguis.setId(resultado.getInt(PERSONAJES_ID));
                    auxPeguis.setNombre(resultado.getString(PERSONAJES_NOMBRE));
                    auxPeguis.setEdad(resultado.getInt(PERSONAJES_EDAD));
                   
                    listadoPeguis.add(auxPeguis);
                }
                return listadoPeguis;
            }
            
            // ********************************* CRUD DE DIRECTORES ******************************
            // *********************************************************************************** 
            
            
            public tablaDirectores obtenerDirectoresPorId(Connection conexion, int id) throws SQLException {
                tablaDirectores retorno = new tablaDirectores();
                String sqlSeleccion = "SELECT * FROM " + TABLA_DIRECTORES + " WHERE " + DIRECTORES_ID + " = ?";
                PreparedStatement prdStat = conexion.prepareStatement(sqlSeleccion);
                prdStat.setInt(1, id);
                ResultSet resultado = prdStat.executeQuery();
                if (resultado.next()) {
                    retorno.setId(resultado.getInt(DIRECTORES_ID));
                    retorno.setAlma_mater(resultado.getString(DIRECTORES_ALMA_MATER));
                    retorno.setId_persona(resultado.getInt(DIRECTORES_ID_PERSONA));
                    
                }
                return retorno;
            }

            
            
            
            
            public void insertarDirectores(Connection conexion, String alma_mater, 
            		                      int id_persona) throws SQLException {
                String sqlInsercion = "INSERT INTO " + TABLA_DIRECTORES +
                		              " (" + DIRECTORES_ALMA_MATER + ", " + DIRECTORES_ID_PERSONA + ", " 
                                           + ") "
                                           + "VALUES (?, ?)";
                PreparedStatement prdstInsercion = conexion.prepareStatement(sqlInsercion);
                prdstInsercion.setString(1, alma_mater);
                prdstInsercion.setInt(2, id_persona);
               
                int filasAfectadas = prdstInsercion.executeUpdate();
                if (filasAfectadas > 0) {
                    System.out.println("Inserción Realizada");
                } else {
                    System.out.println("Inserción no Realizada");
                }
            }
            
            public void actualizarDirectores(Connection conexion,int  id,String alma_mater, 
                                             int id_persona) throws SQLException {
               
                tablaDirectores auxdDirectores = obtenerDirectoresPorId(conexion, id_persona);       
                String sqlActualizacion = "UPDATE " + TABLA_DIRECTORES + " SET " 
                    + DIRECTORES_ALMA_MATER + " = ?, " 
                    + DIRECTORES_ID_PERSONA + " = ?, " 
                    + " WHERE " + DIRECTORES_ID + " = ?";

                PreparedStatement prdstActualizacion = conexion.prepareStatement(sqlActualizacion);       
                if (!alma_mater.isEmpty()) {
                    prdstActualizacion.setString(1, alma_mater);
                } else {
                    prdstActualizacion.setString(1, auxdDirectores.getAlma_mater());
                }
                if (id_persona!=0) {
                    prdstActualizacion.setInt(2, id_persona);
                } else {
                    prdstActualizacion.setInt(2, auxdDirectores.getId_persona());
                }
                
                
               
                prdstActualizacion.setInt(3, id);
               
                int filasAfectadas = prdstActualizacion.executeUpdate();
                if (filasAfectadas > 0) {
                    System.out.println("Actualización Realizada");
                } else {
                    System.out.println("Actualización no Realizada");
                }
            }

            
            
            
            public void borrarDirectoresPorId(Connection conexion, int id) throws SQLException {
                String sqlBorrado = "DELETE FROM " + TABLA_DIRECTORES + " WHERE " + DIRECTORES_ID + " = ?";
                PreparedStatement prdstBorrado = conexion.prepareStatement(sqlBorrado);
                prdstBorrado.setInt(1, id);
                int filasAfectadas = prdstBorrado.executeUpdate();
                if (filasAfectadas > 0) {
                    System.out.println("Borrado Realizado");
                } else {
                    System.out.println("Borrado no Realizado");
                }
            }

            public ArrayList<tablaDirectores> listarDirectores(Connection conexion) throws SQLException {
                ArrayList<tablaDirectores> listadoDirectores = new ArrayList<>();
                String sqlListado = "SELECT * FROM " + TABLA_DIRECTORES;
                PreparedStatement prdStat = conexion.prepareStatement(sqlListado);
                ResultSet resultado = prdStat.executeQuery();
                while (resultado.next()) {
                    tablaDirectores auxDirectores = new tablaDirectores();
                    auxDirectores.setId(resultado.getInt(DIRECTORES_ID));
                    auxDirectores.setAlma_mater(resultado.getString(DIRECTORES_ALMA_MATER));
                    auxDirectores.setId(resultado.getInt(DIRECTORES_ID_PERSONA));
                   
                    listadoDirectores.add(auxDirectores);
                }
                return listadoDirectores;
            }
            // ********************************* CRUD DE ACTORES ******************************
            // *********************************************************************************** 
            
            
            public tablaActores obtenerActoresPorId(Connection conexion, int id) throws SQLException {
                tablaActores retorno = new tablaActores();
                String sqlSeleccion = "SELECT * FROM " + TABLA_ACTORES + " WHERE " + ACTORES_ID + " = ?";
                PreparedStatement prdStat = conexion.prepareStatement(sqlSeleccion);
                prdStat.setInt(1, id);
                ResultSet resultado = prdStat.executeQuery();
                if (resultado.next()) {
                    retorno.setId(resultado.getInt(ACTORES_ID));
                    retorno.setSalario(resultado.getDouble(ACTORES_SALARIO));
                    retorno.setId_persona(resultado.getInt(ACTORES_ID_PERSONA));
                    
                }
                return retorno;
            }

            
            
            
            
            public void insertarActores(Connection conexion, double salario, 
            		                      int id_persona) throws SQLException {
                String sqlInsercion = "INSERT INTO " + TABLA_ACTORES +
                		              " (" + ACTORES_SALARIO + ", " + ACTORES_ID_PERSONA + ", " 
                                           + ") "
                                           + "VALUES (?, ?)";
                PreparedStatement prdstInsercion = conexion.prepareStatement(sqlInsercion);
                prdstInsercion.setDouble(1,salario);
                prdstInsercion.setInt(2, id_persona);
               
                int filasAfectadas = prdstInsercion.executeUpdate();
                if (filasAfectadas > 0) {
                    System.out.println("Inserción Realizada");
                } else {
                    System.out.println("Inserción no Realizada");
                }
            }
            
            public void actualizarActores(Connection conexion,int id, double salario, 
                    int id_persona) throws SQLException {
               
                tablaActores auxActores = obtenerActoresPorId(conexion, id_persona);       
                String sqlActualizacion = "UPDATE " + TABLA_ACTORES + " SET " 
                    + ACTORES_SALARIO + " = ?, " 
                    + ACTORES_ID_PERSONA + " = ?, " 
                    + " WHERE " +ACTORES_ID + " = ?";

                PreparedStatement prdstActualizacion = conexion.prepareStatement(sqlActualizacion);       
                if (salario!=0.0) {
                    prdstActualizacion.setDouble(1, salario);
                } else {
                    prdstActualizacion.setDouble(1, auxActores.getSalario());
                }
                if (id_persona!=0) {
                    prdstActualizacion.setInt(2, id_persona);
                } else {
                    prdstActualizacion.setInt(2, auxActores.getId_persona());
                }
                
                
               
                prdstActualizacion.setInt(3, id);
               
                int filasAfectadas = prdstActualizacion.executeUpdate();
                if (filasAfectadas > 0) {
                    System.out.println("Actualización Realizada");
                } else {
                    System.out.println("Actualización no Realizada");
                }
            }

            
            
            
            public void borrarActoresPorId(Connection conexion, int id) throws SQLException {
                String sqlBorrado = "DELETE FROM " + TABLA_ACTORES + " WHERE " + ACTORES_ID + " = ?";
                PreparedStatement prdstBorrado = conexion.prepareStatement(sqlBorrado);
                prdstBorrado.setInt(1, id);
                int filasAfectadas = prdstBorrado.executeUpdate();
                if (filasAfectadas > 0) {
                    System.out.println("Borrado Realizado");
                } else {
                    System.out.println("Borrado no Realizado");
                }
            }

            public ArrayList<tablaActores> listardoActores(Connection conexion) throws SQLException {
                ArrayList<tablaActores> listadoActores = new ArrayList<>();
                String sqlListado = "SELECT * FROM " + TABLA_ACTORES;
                PreparedStatement prdStat = conexion.prepareStatement(sqlListado);
                ResultSet resultado = prdStat.executeQuery();
                while (resultado.next()) {
                    tablaActores auxActores = new tablaActores();
                    auxActores.setId(resultado.getInt(ACTORES_ID));
                    auxActores.setSalario(resultado.getDouble(ACTORES_SALARIO));
                    auxActores.setId(resultado.getInt(ACTORES_ID_PERSONA));
                   
                    listadoActores.add(auxActores);
                }
                return listadoActores;
            }
            
         // ********************************* CRUD DE PRODUCTORES ******************************
            // *********************************************************************************** 
            
            public tablaProductores obtenerProductoresPorId(Connection conexion, int id) throws SQLException {
                tablaProductores retorno = new tablaProductores();
                String sqlSeleccion = "SELECT * FROM " + TABLA_PRODUCTORES + " WHERE " + PRODUCTORES_ID + " = ?";
                PreparedStatement prdStat = conexion.prepareStatement(sqlSeleccion);
                prdStat.setInt(1, id);
                ResultSet resultado = prdStat.executeQuery();
                if (resultado.next()) {
                    retorno.setId(resultado.getInt(PRODUCTORES_ID));
                    retorno.setInversion(resultado.getDouble(PRODUCTORES_INVERSION));
                    retorno.setId_persona(resultado.getInt(PRODUCTORES_ID_PERSONA));
                }
                return retorno;
            }
            
            public void insertarProductores(Connection conexion, double inversion, int id_persona) throws SQLException {
                String sqlInsercion = "INSERT INTO " + TABLA_PRODUCTORES +
                                      " (" + PRODUCTORES_INVERSION + ", " + PRODUCTORES_ID_PERSONA + ") " +
                                      "VALUES (?, ?)";
                PreparedStatement prdstInsercion = conexion.prepareStatement(sqlInsercion);
                prdstInsercion.setDouble(1, inversion);
                prdstInsercion.setInt(2, id_persona);
               
                int filasAfectadas = prdstInsercion.executeUpdate();
                if (filasAfectadas > 0) {
                    System.out.println("Inserción Realizada");
                } else {
                    System.out.println("Inserción no Realizada");
                }
            }

            public void actualizarProductores(Connection conexion, int id, double inversion, int id_persona) throws SQLException {
                tablaProductores auxProductores = obtenerProductoresPorId(conexion, id);
                String sqlActualizacion = "UPDATE " + TABLA_PRODUCTORES + " SET " 
                    + PRODUCTORES_INVERSION + " = ?, " 
                    + PRODUCTORES_ID_PERSONA + " = ? "
                    + "WHERE " + PRODUCTORES_ID + " = ?";

                PreparedStatement prdstActualizacion = conexion.prepareStatement(sqlActualizacion);
                if (inversion != 0.0) {
                    prdstActualizacion.setDouble(1, inversion);
                } else {
                    prdstActualizacion.setDouble(1, auxProductores.getInversion());
                }
                if (id_persona != 0) {
                    prdstActualizacion.setInt(2, id_persona);
                } else {
                    prdstActualizacion.setInt(2, auxProductores.getId_persona());
                }
                prdstActualizacion.setInt(3, id);
               
                int filasAfectadas = prdstActualizacion.executeUpdate();
                if (filasAfectadas > 0) {
                    System.out.println("Actualización Realizada");
                } else {
                    System.out.println("Actualización no Realizada");
                }
            }

            public void borrarProductoresPorId(Connection conexion, int id) throws SQLException {
                String sqlBorrado = "DELETE FROM " + TABLA_PRODUCTORES + " WHERE " + PRODUCTORES_ID + " = ?";
                PreparedStatement prdstBorrado = conexion.prepareStatement(sqlBorrado);
                prdstBorrado.setInt(1, id);
                int filasAfectadas = prdstBorrado.executeUpdate();
                if (filasAfectadas > 0) {
                    System.out.println("Borrado Realizado");
                } else {
                    System.out.println("Borrado no Realizado");
                }
            }

            public ArrayList<tablaProductores> listarProductores(Connection conexion) throws SQLException {
                ArrayList<tablaProductores> listadoProductores = new ArrayList<>();
                String sqlListado = "SELECT * FROM " + TABLA_PRODUCTORES;
                PreparedStatement prdStat = conexion.prepareStatement(sqlListado);
                ResultSet resultado = prdStat.executeQuery();
                while (resultado.next()) {
                    tablaProductores auxProductores = new tablaProductores();
                    auxProductores.setId(resultado.getInt(PRODUCTORES_ID));
                    auxProductores.setInversion(resultado.getDouble(PRODUCTORES_INVERSION));
                    auxProductores.setId_persona(resultado.getInt(PRODUCTORES_ID_PERSONA));
                   
                    listadoProductores.add(auxProductores);
                }
                return listadoProductores;
            }

            // ********************************* CRUD DE PELICULAS ******************************
            // ***********************************************************************************

            public tablaPeliculas obtenerPeliculaPorId(Connection conexion, int id) throws SQLException {
                tablaPeliculas retorno = new tablaPeliculas();
                String sqlSeleccion = "SELECT * FROM " + TABLA_PELICULAS + " WHERE " + PELICULAS_ID + " = ?";
                PreparedStatement prdStat = conexion.prepareStatement(sqlSeleccion);
                prdStat.setInt(1, id);
                ResultSet resultado = prdStat.executeQuery();
                if (resultado.next()) {
                    retorno.setId(resultado.getInt(PELICULAS_ID));
                    retorno.setTitulo(resultado.getString(PELICULAS_TITULO));
                    retorno.setFecha(resultado.getDate(PELICULAS_FECHA));
                    retorno.setDuracion(resultado.getInt(PELICULAS_DURACION));
                    retorno.setId_director(resultado.getInt(PELICULAS_ID_DIRECTOR));
                    retorno.setId_productor(resultado.getInt(PELICULAS_ID_PRODUCTOR));
                    retorno.setId_pegui(resultado.getInt(PELICULAS_ID_PEGUI));
                }
                return retorno;
            }
            public void insertarPelicula(Connection conexion, String titulo, Date fecha,
            		                    int duracion, int id_director, int id_productor, int id_pegui) throws SQLException {
                String sqlInsercion = "INSERT INTO " + TABLA_PELICULAS + " ("
                        + PELICULAS_TITULO + ", "
                        + PELICULAS_FECHA + ", "
                        + PELICULAS_DURACION + ", "
                        + PELICULAS_ID_DIRECTOR + ", "
                        + PELICULAS_ID_PRODUCTOR + ", "
                        + PELICULAS_ID_PEGUI + ") "
                        + "VALUES (?, ?, ?, ?, ?, ?)";
                PreparedStatement prdstInsercion = conexion.prepareStatement(sqlInsercion);
                prdstInsercion.setString(1, titulo);
                prdstInsercion.setDate(2, fecha);
                prdstInsercion.setInt(3, duracion);
                prdstInsercion.setInt(4, id_director);
                prdstInsercion.setInt(5, id_productor);
                prdstInsercion.setInt(6, id_pegui);
                
                int filasAfectadas = prdstInsercion.executeUpdate();
                if (filasAfectadas > 0) {
                    System.out.println("Inserción Realizada");
                } else {
                    System.out.println("Inserción no Realizada");
                }
            }
            
            public void actualizarPeliculas(Connection conexion, int id, String titulo, Date fecha, int duracion, int id_director, int id_productor, int id_pegui) throws SQLException {
                tablaPeliculas auxPelicula = obtenerPeliculaPorId(conexion, id);
                String sqlActualizacion = "UPDATE " + TABLA_PELICULAS + " SET "
                    + PELICULAS_TITULO + " = ?, "
                    + PELICULAS_FECHA + " = ?, "
                    + PELICULAS_DURACION + " = ?, "
                    + PELICULAS_ID_DIRECTOR + " = ?, "
                    + PELICULAS_ID_PRODUCTOR + " = ?, "
                    + PELICULAS_ID_PEGUI + " = ? "
                    + "WHERE " + PELICULAS_ID + " = ?";

                PreparedStatement prdstActualizacion = conexion.prepareStatement(sqlActualizacion);

             
                
                
                
                if (!titulo.isEmpty()) {
                    prdstActualizacion.setString(1, titulo);
                } else {
                    prdstActualizacion.setString(1, auxPelicula.getTitulo());
                }

                if (fecha != null) {
                    prdstActualizacion.setDate(2,new Date( fecha.getTime()));
                } else {
                    prdstActualizacion.setDate(2, auxPelicula.getFecha());
                }

                if (duracion ==0) {
                    prdstActualizacion.setInt(3, duracion);
                } else {
                    prdstActualizacion.setInt(3, auxPelicula.getDuracion());
                }

                if (id_director == 0) {
                    prdstActualizacion.setInt(4, id_director);
                } else {
                    prdstActualizacion.setInt(4, auxPelicula.getId_director());
                }

                if (id_productor == 0) {
                    prdstActualizacion.setInt(5, id_productor);
                } else {
                    prdstActualizacion.setInt(5, auxPelicula.getId_productor());
                }

                if (id_pegui == 0) {
                    prdstActualizacion.setInt(6, id_pegui);
                } else {
                    prdstActualizacion.setInt(6, auxPelicula.getId_pegui());
                }

                prdstActualizacion.setInt(7, id);

                int filasAfectadas = prdstActualizacion.executeUpdate();
                if (filasAfectadas > 0) {
                    System.out.println("Actualización Realizada");
                } else {
                    System.out.println("Actualización no Realizada");
                }
            }

            
            public void borrarPeliculaPorId(Connection conexion, int id) throws SQLException {
                String sqlBorrado = "DELETE FROM " + TABLA_PELICULAS + " WHERE " + PELICULAS_ID + " = ?";
                PreparedStatement prdstBorrado = conexion.prepareStatement(sqlBorrado);
                prdstBorrado.setInt(1, id);
                int filasAfectadas = prdstBorrado.executeUpdate();
                if (filasAfectadas > 0) {
                    System.out.println("Borrado Realizado");
                } else {
                    System.out.println("Borrado no Realizado");
                }
            }
            
            public ArrayList<tablaPeliculas> listarPeliculas(Connection conexion) throws SQLException {
                ArrayList<tablaPeliculas> listadoPeliculas = new ArrayList<>();
                String sqlListado = "SELECT * FROM " + TABLA_PELICULAS;
                PreparedStatement prdStat = conexion.prepareStatement(sqlListado);
                ResultSet resultado = prdStat.executeQuery();
                while (resultado.next()) {
                    tablaPeliculas auxPelicula = new tablaPeliculas();
                    auxPelicula.setId(resultado.getInt(PELICULAS_ID));
                    auxPelicula.setTitulo(resultado.getString(PELICULAS_TITULO));
                    auxPelicula.setFecha(resultado.getDate(PELICULAS_FECHA));
                    auxPelicula.setDuracion(resultado.getInt(PELICULAS_DURACION));
                    auxPelicula.setId_director(resultado.getInt(PELICULAS_ID_DIRECTOR));
                    auxPelicula.setId_productor(resultado.getInt(PELICULAS_ID_PRODUCTOR));
                    auxPelicula.setId_pegui(resultado.getInt(PELICULAS_ID_PEGUI));
                    
                    listadoPeliculas.add(auxPelicula);
                }
                return listadoPeliculas;
            }





    }

    
 
    
    

