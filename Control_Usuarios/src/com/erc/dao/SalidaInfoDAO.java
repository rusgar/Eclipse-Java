package com.erc.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.erc.bdhelpers.BDDAO;
import com.erc.model.SalidaInfo;
import com.erc.model.tablaSalidas;
import com.erc.model.tablaTrabajadores;
import com.erc.model.tablaDirecciones;
import com.erc.model.tablaClientes;

public class SalidaInfoDAO {

    private final Connection conexion;
    private final BDDAO bdDAO; // Suponiendo que tienes una clase BDDAO con los métodos CRUD

    public SalidaInfoDAO(Connection conexion, BDDAO bdDAO) {
        this.conexion = conexion;
        this.bdDAO = bdDAO;
    }

    // Método que obtiene la información de salida y la combina en una lista de SalidaInfo
    public List<SalidaInfo> obtenerSalidaInfo(LocalDate fechaSeleccionada, Integer id) throws SQLException {
        List<SalidaInfo> salidaInfos = new ArrayList<>();
        List<tablaSalidas> salidas = listarSalidas(); // Método que obtiene la lista de salidas

        for (tablaSalidas salida : salidas) {
            if (salida.getFechaTarea().isEqual(fechaSeleccionada) && (id == null || salida.getId() == id)) {
                int idTrabajador = salida.getIdTrabajador();
                int idDireccion = salida.getIdDireccion();

                // Obtener trabajador y dirección usando BDDAO
                tablaTrabajadores trabajador = bdDAO.obtenerTrabajadorPorId(conexion, idTrabajador);
                tablaDirecciones direccion = obtenerDireccionPorId(idDireccion); // Implementa este método
                tablaClientes cliente = null;

                if (direccion != null) {
                    int idCliente = direccion.getIdCliente();
                    cliente = obtenerClientePorId(idCliente); // Implementa este método
                }

                if (trabajador != null && direccion != null && cliente != null) {
                    // Crear un nuevo objeto SalidaInfo combinando la información
                    SalidaInfo salidaInfo = new SalidaInfo(
                        salida,
                        trabajador.getPuesto(),
                        direccion.getLocalidad(),
                        cliente.getNombre(),
                        "https://www.google.com/maps/?q=" + direccion.getLatitud() + "," + direccion.getLongitud()
                    );
                    salidaInfos.add(salidaInfo);
                }
            }
        }

        return salidaInfos;
    }

    // Métodos auxiliares para obtener datos de la BD (deben estar implementados)
    private List<tablaSalidas> listarSalidas() throws SQLException {
        // Implementación que obtiene las salidas de la BD
    	return bdDAO.listarSalidas(conexion); // Retorna un array vacío como placeholder
    }

    private tablaDirecciones obtenerDireccionPorId(int idDireccion) throws SQLException {
        // Implementación para obtener una dirección por su ID
    	 return bdDAO.obtenerDireccionPorId(conexion, idDireccion);
    }

    private tablaClientes obtenerClientePorId(int idCliente) throws SQLException {
        // Implementación para obtener un cliente por su ID
        return bdDAO.obtenerClientePorId(conexion, idCliente);
    }
}
