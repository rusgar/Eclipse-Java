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

/**
 * CON ESTA CLASE GESTIONAMOS LA INFORMACIÓN RELACIONADA CON LAS SALIDAS Y COMBINA DATOS DE MÚLTIPLES TABLAS
 *  (SALIDAS, TRABAJADORES, DIRECCIONES, Y CLIENTES) PARA OBTENER INFORMACIÓN DETALLADA DE LAS SALIDAS.
 *  @author EDU RUS
 */
public class SalidaInfoDAO {

    //ATRIBUTOS
	private final Connection conexion;
    private final BDDAO bdDAO; 

    /**
     * CONSTRUCTOR DE LA CLASE
     * @param Connection 
     * @param bdDAO
     */
    public SalidaInfoDAO(Connection conexion, BDDAO bdDAO) {
        this.conexion = conexion;
        this.bdDAO = bdDAO;
    }

    
   
    
    /**
     * CON ESTE METODO OBTENEMOS LA INFORMACIÓN COMBINADA DE SALIDAS, TRABAJADORES, DIRECCIONES Y CLIENTES
     *  PARA UNA FECHA Y/O ID ESPECÍFICO.
     * @param fechaSeleccionada
     * @param id
     * @return list
     * @throws SQLException
     */
   
    public List<SalidaInfo> obtenerSalidaInfo(LocalDate fechaSeleccionada, Integer id) throws SQLException {
        List<SalidaInfo> salidaInfos = new ArrayList<>();
        List<tablaSalidas> salidas = listarSalidas();

        for (int i = 0; i < salidas.size(); i++) {
            tablaSalidas salida = salidas.get(i);
            if (salida.getFechaTarea().isEqual(fechaSeleccionada) && (id == null || salida.getId() == id)) {
                int idTrabajador = salida.getIdTrabajador();
                int idDireccion = salida.getIdDireccion();

           
                tablaTrabajadores trabajador = bdDAO.obtenerTrabajadorPorId(conexion, idTrabajador);
                tablaDirecciones direccion = obtenerDireccionPorId(idDireccion); 
                tablaClientes cliente = null;

                if (direccion != null) {
                    int idCliente = direccion.getIdCliente();
                    cliente = obtenerClientePorId(idCliente); 
                }

                if (trabajador != null && direccion != null && cliente != null) {
                    
                    SalidaInfo salidaInfo = new SalidaInfo(
                        salida,
                        trabajador.getNombre(),
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
    
    
    /**
     * CON ESTE METODO PODEMOS OBTIENER TODAS LAS SALIDAS RELACIONADAS CON UN CLIENTE ESPECÍFICO BASADO EN SU ID.
     * @param idCliente
     * @return list
     * @throws SQLException
     */
    public List<SalidaInfo> obtenerSalidasPorCliente(int idCliente) throws SQLException {
        List<SalidaInfo> salidaInfos = new ArrayList<>();
        List<tablaSalidas> salidas = listarSalidas(); // Obtén todas las salidas

        for (int i = 0; i < salidas.size(); i++) {
            tablaSalidas salida = salidas.get(i);
            int idDireccion = salida.getIdDireccion();
            tablaDirecciones direccion = obtenerDireccionPorId(idDireccion);
            
            if (direccion != null) {
                if (direccion.getIdCliente() == idCliente) {
                    int idTrabajador = salida.getIdTrabajador();
                    tablaTrabajadores trabajador = bdDAO.obtenerTrabajadorPorId(conexion, idTrabajador);

                    if (trabajador != null) {
                        SalidaInfo salidaInfo = new SalidaInfo(
                            salida,
                            trabajador.getNombre(),
                            direccion.getLocalidad(),
                            obtenerClientePorId(idCliente).getNombre(),
                            "https://www.google.com/maps/?q=" + direccion.getLatitud() + "," + direccion.getLongitud()
                        );
                        salidaInfos.add(salidaInfo);
                    }
                }
            }
        }

        return salidaInfos;
    }


    // METODOS AUXULIARES
    private List<tablaSalidas> listarSalidas() throws SQLException {
       
    	return bdDAO.listarSalidas(conexion); 
    }

    private tablaDirecciones obtenerDireccionPorId(int idDireccion) throws SQLException {
        
    	 return bdDAO.obtenerDireccionPorId(conexion, idDireccion);
    }

    private tablaClientes obtenerClientePorId(int idCliente) throws SQLException {
        
        return bdDAO.obtenerClientePorId(conexion, idCliente);
    }
}
