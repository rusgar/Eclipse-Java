package com.erc.main;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.erc.bdhelpers.BDDAO;
import com.erc.model.tablaClientes;
import com.erc.model.tablaDirecciones;
import com.erc.model.tablaSalidas;
import com.erc.model.tablaTrabajadores;
import com.erc.model.SalidaInfo;
import com.toedter.calendar.JCalendar;
import com.erc.model.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;



public class OpcionesCRUD extends JFrame {

	// ATRIBUTOS  O VARIBALES PARA MANEJAR
    private Connection conexion;
    private BDDAO bdDao;
    private JTable tabla;
    private DefaultTableModel modeloTabla;
    private JTextField textFieldId; 
    private JButton btnBuscar; 
    private JComboBox<String> comboBoxTablas; 
    private JPanel panelTablaResultados; 
    private JTextField textFieldUrl;
    private JLabel lblEnlaceGoogle;
    private JButton btnVerCalendario;

    public OpcionesCRUD(Connection conexion) {
        this.conexion = conexion;
        this.bdDao = new BDDAO();
        inicializar();
    }

    private void inicializar() {
        setTitle("Opciones CRUD");
        setBounds(100, 100, 900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // CONFIGURACION DEL COMBOX PARA SELECCIONAR LAS TABLAS QUE DESEAMOS
        String[] tablas = {" ", "CLIENTES", "DIRECCIONES", "TRABAJADORES", "SALIDAS", "TRABAJDORES_SALIDAS"};
        comboBoxTablas = new JComboBox<>(tablas);
        comboBoxTablas.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
        comboBoxTablas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cambiarTabla();
            }
        });

        // CONFIGURACION DEL PANEL DE SELECCION
        JPanel panelSeleccionTabla = new JPanel();
        panelSeleccionTabla.setBounds(0, 0, 884, 83);
        panelSeleccionTabla.setLayout(new BorderLayout());
        JLabel label = new JLabel("Seleccionar Tabla:");
        label.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
        panelSeleccionTabla.add(label, BorderLayout.NORTH);
        panelSeleccionTabla.add(comboBoxTablas, BorderLayout.CENTER);

        // CONFIGURACION DEL JPANEL
        JPanel panelId = new JPanel();
        panelId.setLayout(new FlowLayout());
        JLabel lblId = new JLabel("ID");
        lblId.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
        panelId.add(lblId);

        textFieldId = new JTextField();
        textFieldId.setFont(new Font("Comic Sans MS", Font.PLAIN, 10));
        textFieldId.setColumns(10);
        panelId.add(textFieldId);

        btnBuscar = new JButton("Buscar");
        btnBuscar.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarPorId();
            }
        });
        panelId.add(btnBuscar);
        


       
        // CREAMOS EL BTN PARA VER CALENDARIO
        btnVerCalendario = new JButton("Ver Calendario");
        btnVerCalendario.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
        btnVerCalendario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
            	// NO BUSCA EL CALENDARIO NI BUSCA POR ID
                mostrarCalendario(null);
            }
        });
        panelId.add(btnVerCalendario);
        
        
        

        // CONFIGURACION DEL ENLACE DE GOOGLE
        lblEnlaceGoogle = new JLabel("Enlace Maps\r\n\r\n");
        lblEnlaceGoogle.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
        lblEnlaceGoogle.setVisible(false); // OCULTAMOS INICIALMENTE PUES NO LO NECESITAMOS DE INICIO
        panelId.add(lblEnlaceGoogle);

        textFieldUrl = new JTextField();
        textFieldUrl.setFont(new Font("Comic Sans MS", Font.PLAIN, 10));
        textFieldUrl.setColumns(30);
        textFieldUrl.setVisible(false); // OCULTAMOS INICIALMENTE PUES NO LO NECESITAMOS DE INICIO
        getContentPane().setLayout(null);
        panelId.add(textFieldUrl);

        panelSeleccionTabla.add(panelId, BorderLayout.SOUTH);
        getContentPane().add(panelSeleccionTabla);

        // CONFIGURAMOS EL PANEL DE LA TABLA
        panelTablaResultados = new JPanel(new BorderLayout());
        panelTablaResultados.setBounds(0, 83, 884, 445);
        modeloTabla = new tablaModeloFechas(); 
        tabla = new JTable(modeloTabla);
        tabla.setRowSelectionAllowed(false);
        tabla.setEnabled(false);
        JScrollPane scrollPane = new JScrollPane(tabla);
        panelTablaResultados.add(scrollPane, BorderLayout.CENTER);
        getContentPane().add(panelTablaResultados);

        // CREACION DE LOS PANELES CON LOS BOTONES DEL CRUD
        JPanel panelBotones = new JPanel();
        panelBotones.setBounds(0, 528, 884, 33);
        getContentPane().add(panelBotones);

        JButton btnListar = new JButton("Listar");
        panelBotones.add(btnListar);
        btnListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listar();
            }
        });

        JButton btnInsertar = new JButton("Insertar");
        panelBotones.add(btnInsertar);
        btnInsertar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertar();
            }
        });

        JButton btnActualizar = new JButton("Actualizar");
        panelBotones.add(btnActualizar);
        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizar();
            }
        });

        JButton btnEliminar = new JButton("Eliminar");
        panelBotones.add(btnEliminar);
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminar();
            }
        });
        

        // INICIALIZAMOS LA TABLA COMO VACIA
        panelTablaResultados.setVisible(true);
    }


    private void mostrarCalendario(Integer id) {
        JDialog calendarioDialog = new JDialog(this, "Calendario", true);
        calendarioDialog.getContentPane().setLayout(new BorderLayout());
        calendarioDialog.setSize(900, 700);

        // CREACION DEL CALENDARIO
        JCalendar calendario = new JCalendar();
        calendarioDialog.getContentPane().add(calendario, BorderLayout.NORTH);

        // CREAMOS EL MODELO DE LA TABLA  Y SU MODELO PARA MOSTRAR LA INFORMACION
        tablaModeloFechas tableModel = new tablaModeloFechas();
        JTable table = new JTable(tableModel);

        // CONFIGURACION DE LA TABLA Y FLEXIBILIDAD DE LA MISMA
        table.setCellSelectionEnabled(true);
        table.setRowSelectionAllowed(true);
        table.setColumnSelectionAllowed(true);

        // CONFIGURACION DE LAS CELDAS PARA CADA COLUMNA DEL ENLACE
        table.getColumnModel().getColumn(5).setCellRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component componente = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                if (column == 5 && value instanceof String) {
                    String url = (String) value;
                    JLabel label = new JLabel("<html><a href='" + url + "'>" + url + "</a></html>");
                    label.setForeground(Color.BLUE); // APLICAMOS UN COLOR AZUL AL ENLACE URL PARA QUE SEA MAS VISIBLE
                    label.setCursor(new Cursor(Cursor.HAND_CURSOR));
                    return label;
                }
                return componente;
            }
        });

        table.addMouseListener(new java.awt.event.MouseAdapter() { // NOS PERMITE HACER CLICK Y MUESTRA EN OTR PANTALLA EL URL
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = table.rowAtPoint(evt.getPoint());
                int column = table.columnAtPoint(evt.getPoint());
                if (column == 5) { // INDICE CONINCIDE CON EL STRING DE LA COLUMNA DE LA TABLA MODEELO DE FECHAS
                    String url = (String) table.getValueAt(row, column);
                    try {
                        Desktop.getDesktop().browse(new java.net.URI(url));
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Error al abrir el enlace: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
        // AÑADIMOS UN SCROLL POR SI SALEN TODAS LAS SALIDAS EN LA PANTALLA
        JScrollPane scrollPane = new JScrollPane(table);
        calendarioDialog.getContentPane().add(scrollPane, BorderLayout.CENTER);

        // DETECTAMOS LOS CAMBIOS DE FECHA
        calendario.getDayChooser().addPropertyChangeListener(evt -> {
            if ("day".equals(evt.getPropertyName())) {
                java.util.Date selectedDate = calendario.getDate();
                java.sql.Date sqlSelectedDate = new java.sql.Date(selectedDate.getTime());
                System.out.println("Fecha seleccionada: " + sqlSelectedDate); // MANERA DE DEPURACION PARA MOSTRAR POR CONSOLA
                marcarFechasEnTabla(tableModel, sqlSelectedDate, id); // ACTUALIZA LA TABLA CON LA NUEVA FECHA Y FILTRA POR ID

                // FORZAR ACTUALIZACIÓN DEL MODELO Y VISTA
                table.revalidate();
                table.repaint();
            }
        });

        calendarioDialog.setVisible(true);
    }




    private void marcarFechasEnTabla(tablaModeloFechas modelFechas, Date selectedDate, Integer id) {
        try {
            ArrayList<tablaSalidas> salidas = bdDao.listarSalidas(conexion);
            LocalDate fechaSeleccionada = selectedDate.toLocalDate();
            System.out.println("Número de salidas recuperadas: " + salidas.size());

            modelFechas.setRowCount(0); // Limpiar el modelo antes de agregar nuevas filas
            
            List<SalidaInfo> salidaInfos = new ArrayList<>();

            for (tablaSalidas salida : salidas) {
                LocalDate fechaTarea = salida.getFechaTarea();
                if (fechaTarea.isEqual(fechaSeleccionada) && (id == null || salida.getId() == id)) {
                    int idTrabajador = salida.getIdTrabajador();
                    int idDireccion = salida.getIdDireccion();
                    
                    tablaTrabajadores trabajador = bdDao.obtenerTrabajadorPorId(conexion, idTrabajador);
                    tablaDirecciones direccion = bdDao.obtenerDireccionPorId(conexion, idDireccion);
                    tablaClientes cliente = null;
                    
                    if (direccion != null) {
                        int idCliente = direccion.getIdCliente();
                        cliente = bdDao.obtenerClientePorId(conexion, idCliente);
                    }
                    
                    if (trabajador != null && direccion != null && cliente != null) {
                        SalidaInfo salidaInfo = new SalidaInfo(
                            salida,
                            trabajador.getPuesto(),
                            direccion.getLocalidad(),
                            cliente.getNombre(),
                            "https://www.google.com/maps/?q=" + direccion.getLatitud() + "," + direccion.getLongitud()
                        );
                        
                        modelFechas.addFecha(
                            salida.getFechaTarea(),
                            salida.getId(),
                            trabajador.getPuesto(),
                            direccion.getLocalidad(),
                            cliente.getNombre(),
                            "https://www.google.com/maps/?q=" + direccion.getLatitud() + "," + direccion.getLongitud(),
                            salida.getDescripcion(),
                            salida.isInstalaciones(),
                            salida.isIncidencias()
                        );
                        
                        salidaInfos.add(salidaInfo); // Añadir a la lista de SalidaInfo para el PDF
                    } else {
                        System.out.println("Datos incompletos para el trabajador con ID: " + idTrabajador);
                    }
                }
            }
            // Llamar al método para generar el PDF con las salidas filtradas
            modelPDF pdfGenerator = new modelPDF();
            pdfGenerator.generarPDF(salidaInfos, fechaSeleccionada);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener las fechas de las salidas: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }










    private void cambiarTabla() {
        String tablaSeleccionada = (String) comboBoxTablas.getSelectedItem();
        // CONFIGURAMOS LAS COLUNNAS DE LA TABLA
        if ("CLIENTES".equals(tablaSeleccionada)) {
            modeloTabla.setColumnIdentifiers(new String[]{"ID", "Nombre", "Apellidos", "DNI", "Teléfono"});
            lblEnlaceGoogle.setVisible(false);
            textFieldUrl.setVisible(false);
            btnVerCalendario.setVisible(false);
        } else if ("DIRECCIONES".equals(tablaSeleccionada)) {
            modeloTabla.setColumnIdentifiers(new String[]{"ID", "Dirección", "Código Postal", "Localidad", "Latitud", "Longitud", "ID Cliente"});
            lblEnlaceGoogle.setVisible(true);
            textFieldUrl.setVisible(true);
            btnVerCalendario.setVisible(false);
        } else if ("TRABAJADORES".equals(tablaSeleccionada)) {
            modeloTabla.setColumnIdentifiers(new String[]{"ID", "SS", "Puesto", "ID Dirección"});
            lblEnlaceGoogle.setVisible(false);
            textFieldUrl.setVisible(false);
            btnVerCalendario.setVisible(false);
        } else if ("SALIDAS".equals(tablaSeleccionada)) {
            modeloTabla.setColumnIdentifiers(new String[]{"ID", "Tarea", "Instalaciones", "Incidencias", "Solución", "Descripción", "Coste Cliente", "Fecha Tarea", "ID Cliente", "ID DIRECCION", "ID TRABAJADOR"});
            lblEnlaceGoogle.setVisible(false);
            textFieldUrl.setVisible(false);
            btnVerCalendario.setVisible(true);
        } else if ("TRABAJADORES SALIDAS".equals(tablaSeleccionada)) {
            modeloTabla.setColumnIdentifiers(new String[]{"ID", "ID Trabajador", "ID Salida"});
            lblEnlaceGoogle.setVisible(false);
            textFieldUrl.setVisible(false);
            btnVerCalendario.setVisible(false);
        }

        // LIMPIAMOS Y COULTAMOS LAS COLUNMAS DE LA TABLA AL PASAR DE UNA A OTRA
        panelTablaResultados.setVisible(false);
    }


    private void listar() {
        try {
            String tablaSeleccionada = (String) comboBoxTablas.getSelectedItem();
            modeloTabla.setRowCount(0); //AL LISTAR LIMPIAMOS LAS TABLAS
            
            // Lista de datos según la tabla seleccionada
            if ("CLIENTES".equals(tablaSeleccionada)) {
                ArrayList<tablaClientes> clientes = bdDao.listarClientes(conexion);
                for (tablaClientes cliente : clientes) {
                    modeloTabla.addRow(new Object[]{
                        cliente.getId(),
                        cliente.getNombre(),
                        cliente.getApellidos(),
                        cliente.getDni(),
                        cliente.getTelefono()
                    });
                }
            } else if ("DIRECCIONES".equals(tablaSeleccionada)) {
                ArrayList<tablaDirecciones> direcciones = bdDao.listarDirecciones(conexion);
                for (tablaDirecciones direccion : direcciones) {
                    modeloTabla.addRow(new Object[]{
                        direccion.getId(),
                        direccion.getDireccion(),
                        direccion.getCodigoPostal(),
                        direccion.getLocalidad(),
                        direccion.getLatitud(),
                        direccion.getLongitud(),
                        direccion.getIdCliente()
                    });
                }
            } else if ("TRABAJADORES".equals(tablaSeleccionada)) {
                ArrayList<tablaTrabajadores> trabajadores = bdDao.listarTrabajadores(conexion);
                for (tablaTrabajadores trabajador : trabajadores) {
                    modeloTabla.addRow(new Object[]{
                        trabajador.getId(),
                        trabajador.getSs(),
                        trabajador.getPuesto(),
                        trabajador.getIdDireccion()
                    });
                }
            } else if ("SALIDAS".equals(tablaSeleccionada)) {
                ArrayList<tablaSalidas> salidas = bdDao.listarSalidas(conexion);
                for (tablaSalidas salida : salidas) {
                    modeloTabla.addRow(new Object[]{
                        salida.getId(),
                        salida.getTarea(),
                        salida.isInstalaciones(),
                        salida.isIncidencias(),
                        salida.isSolucion(),
                        salida.getDescripcion(),
                        salida.getCosteCliente(),
                        salida.getFechaTarea(),
                        salida.getIdCliente(),
                        salida.getIdDireccion(),
                        salida.getIdTrabajador()
                    });
                }
                btnVerCalendario.setVisible(!salidas.isEmpty());
            } else if ("TRABAJADORES SALIDAS".equals(tablaSeleccionada)) {
                ArrayList<tablaTrabajadoresSalidas> trabajadoresSalidas = bdDao.listarTrabajadoresSalidas(conexion);
                for (tablaTrabajadoresSalidas trabajadorSalida : trabajadoresSalidas) {
                    modeloTabla.addRow(new Object[]{
                        trabajadorSalida.getId(),
                        trabajadorSalida.getIdTrabajador(),
                        trabajadorSalida.getIdSalida()
                    });
                }
            }
            panelTablaResultados.setVisible(true); // MUESTRA OS RESULTADOS DE LA TABLA
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al listar: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    private void buscarPorId() {
        String idStr = textFieldId.getText();
        if (idStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un ID.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            int id = Integer.parseInt(idStr);
            String tablaSeleccionada = (String) comboBoxTablas.getSelectedItem();
            modeloTabla.setRowCount(0); // LIMPIAMOS LA TABLA ANTES DE LISTARLA
            if ("CLIENTES".equals(tablaSeleccionada)) {
                tablaClientes cliente = bdDao.obtenerClientePorId(conexion, id);
                if (cliente != null) {
                    modeloTabla.addRow(new Object[]{
                            cliente.getId(),
                            cliente.getNombre(),
                            cliente.getApellidos(),                           
                            cliente.getDni(),
                            cliente.getTelefono()
                    });
                } else {
                    JOptionPane.showMessageDialog(this, "No se encontró el CLIENTE con ID: " + id, "Resultado", JOptionPane.INFORMATION_MESSAGE);
                }
            } else if ("DIRECCIONES".equals(tablaSeleccionada)) {
                tablaDirecciones direccion = bdDao.obtenerDireccionPorId(conexion, id);
                if (direccion != null) {
                    modeloTabla.addRow(new Object[]{
                            direccion.getId(),
                            direccion.getDireccion(),
                            direccion.getCodigoPostal(),
                            direccion.getLocalidad(),
                            direccion.getLatitud(),
                            direccion.getLongitud(),
                            direccion.getIdCliente()
                    });
                    // GENERAMOS EL ENLACE DE GOOGLE, CON LOS ATRINUTOS NECESARIOS
                    generarEnlaceGoogleMaps(direccion.getLatitud(), direccion.getLongitud());
                } else {
                    JOptionPane.showMessageDialog(this, "No se encontró la DIRECCION con ID: " + id, "Resultado", JOptionPane.INFORMATION_MESSAGE);
                }
            }
            else if ("TRABAJADORES".equals(tablaSeleccionada)) {
                tablaTrabajadores trabajador = bdDao.obtenerTrabajadorPorId(conexion, id);
                if (trabajador != null) {
                    modeloTabla.addRow(new Object[]{
                            trabajador.getId(),
                            trabajador.getSs(),
                            trabajador.getPuesto(),
                            trabajador.getIdDireccion()
                    });
                } else {
                    JOptionPane.showMessageDialog(this, "No se encontró el TRABAJADOR con ID: " + id, "Resultado", JOptionPane.INFORMATION_MESSAGE);
                }
            }else if ("SALIDAS".equals(tablaSeleccionada)) {
                tablaSalidas salida = bdDao.obtenerSalidaPorId(conexion, id);
                if (salida != null) {
                    modeloTabla.addRow(new Object[]{
                            salida.getId(),
                            salida.getTarea(),
                            salida.isInstalaciones(),
                            salida.isIncidencias(),
                            salida.isSolucion(),
                            salida.getDescripcion(),
                            salida.getCosteCliente(),                           
                            salida.getFechaTarea(),                            
                            salida.getIdCliente(),
                            salida.getIdDireccion(),
                            salida.getIdTrabajador(),
                    });
                    btnVerCalendario.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(this, "No se encontró la SALIDA con ID: " + id, "Resultado", JOptionPane.INFORMATION_MESSAGE);
                    btnVerCalendario.setVisible(false);
                }
            }else if ("TRABAJADORES SALIDAS".equals(tablaSeleccionada)) {
                tablaTrabajadoresSalidas trabajadorSalida = bdDao.obtenerTrabajadorSalidaPorID(conexion, id);
                if (trabajadorSalida != null) {
                    modeloTabla.addRow(new Object[]{
                            trabajadorSalida.getId(),
                            trabajadorSalida.getIdTrabajador(),
                            trabajadorSalida.getIdSalida()
                    });
                } else {
                    JOptionPane.showMessageDialog(this, "No se encontró el trabajador salida con ID: " + id, "Resultado", JOptionPane.INFORMATION_MESSAGE);
                }
            }
            panelTablaResultados.setVisible(true); // MOSTRAMOS LA TABLA DESEPUES DE LISTARLA
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "ID inválido. Debe ser un número entero.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al buscar: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void insertar() {
        String tablaSeleccionada = (String) comboBoxTablas.getSelectedItem();
        try {
            if ("CLIENTES".equals(tablaSeleccionada)) {
                String nombre = JOptionPane.showInputDialog("Nombre:");
                String apellidos = JOptionPane.showInputDialog("Apellidos:");
                String dni = JOptionPane.showInputDialog("DNI:");
                String telefono = JOptionPane.showInputDialog("Teléfono:");
                bdDao.insertarCliente(conexion, nombre, apellidos, dni, telefono);
                
            } else if ("DIRECCIONES".equals(tablaSeleccionada)) {
                String direccion = JOptionPane.showInputDialog("Dirección:");
                String codigoPostal = JOptionPane.showInputDialog("Código Postal:");
                String localidad = JOptionPane.showInputDialog("Localidad:");
                String latitudStr = JOptionPane.showInputDialog("Latitud:");
                String longitudStr = JOptionPane.showInputDialog("Longitud:");
                String idClienteStr = JOptionPane.showInputDialog("ID Usuario:");
                double latitud = Double.parseDouble(latitudStr);
                double longitud = Double.parseDouble(longitudStr);
                int idcliente = Integer.parseInt(idClienteStr);
                bdDao.insertarDireccion(conexion, direccion, codigoPostal, localidad, latitud, longitud, idcliente);
                
            } else if ("TRABAJADORES".equals(tablaSeleccionada)) {
                String ss = JOptionPane.showInputDialog("Número de Seguridad Social:");
                String puesto = JOptionPane.showInputDialog("Puesto:");
                String idDireccionStr = JOptionPane.showInputDialog("ID Dirección:");
                int idDireccion = Integer.parseInt(idDireccionStr);              
                bdDao.insertarTrabajador(conexion, ss, puesto, idDireccion);                
           
                
            }else if ("SALIDAS".equals(tablaSeleccionada)) {
            	String tarea = JOptionPane.showInputDialog("Tarea:");
                String instalacionesStr = JOptionPane.showInputDialog("Instalaciones (true/false):");
                String incidenciasStr = JOptionPane.showInputDialog("Incidencias (true/false):");
                String solucionStr = JOptionPane.showInputDialog("Solución (true/false):");
                String descripcion = JOptionPane.showInputDialog("Descripción:");
                String costeCliente = JOptionPane.showInputDialog("Coste Cliente:");                
                String fechaTareaStr = JOptionPane.showInputDialog("Fecha Tarea :");                
                String idClienteStr = JOptionPane.showInputDialog("ID Cliente:");
                String idDireccionStr = JOptionPane.showInputDialog("ID Direccion:");
                String idTrabajdorStr = JOptionPane.showInputDialog("ID Trabajador:");
                boolean instalaciones = Boolean.parseBoolean(instalacionesStr);
                boolean incidencias = Boolean.parseBoolean(incidenciasStr);
                boolean solucion = Boolean.parseBoolean(solucionStr);
                Date fechaTarea = Date.valueOf(fechaTareaStr);
                int idCliente = Integer.parseInt(idClienteStr);
                int idTarea = Integer.parseInt(idDireccionStr);
                int idTrabajador = Integer.parseInt(idTrabajdorStr);
                bdDao.insertarSalida(conexion,tarea, instalaciones, incidencias, solucion, costeCliente, descripcion, fechaTarea, idCliente, idTarea,idTrabajador);
                
            }else if ("TRABAJADOR SALIDAS".equals(tablaSeleccionada)) {
                String idTrabajadorStr = JOptionPane.showInputDialog("ID Trabajador:");
                String idSalidaStr = JOptionPane.showInputDialog("ID Salida:");
                int idTrabajador = Integer.parseInt(idTrabajadorStr);
                int idSalida = Integer.parseInt(idSalidaStr);
                bdDao.insertarTrabajadorSalida(conexion, idTrabajador, idSalida);
            }
            
            listar(); // ACTUALIZA LA TABLA DESPUES DE INSERTAR LOS DATOS
        } catch (SQLException | NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Error al insertar datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void actualizar() {
        String tablaSeleccionada = (String) comboBoxTablas.getSelectedItem();
        try {
            if ("CLIENTES".equals(tablaSeleccionada)) {
                String idStr = JOptionPane.showInputDialog("ID del Cliente a Actualizar:");
                int id = Integer.parseInt(idStr);
                String nombre = JOptionPane.showInputDialog("Nombre:");
                String apellidos = JOptionPane.showInputDialog("Apellidos:");
                String dni = JOptionPane.showInputDialog("DNI:");
                String telefono = JOptionPane.showInputDialog("Teléfono:");
                bdDao.actualizarCliente(conexion, id, nombre, apellidos, dni, telefono);

            } else if ("DIRECCIONES".equals(tablaSeleccionada)) {
            	String idStr = JOptionPane.showInputDialog("ID de la Dirección a Actualizar:");
                int id = Integer.parseInt(idStr);
                String direccion = JOptionPane.showInputDialog("Dirección:");
                String codigoPostal = JOptionPane.showInputDialog("Código Postal:");
                String localidad = JOptionPane.showInputDialog("Localidad:");
                String latitudStr = JOptionPane.showInputDialog("Latitud:");
                String longitudStr = JOptionPane.showInputDialog("Longitud:");
                String idClienteStr = JOptionPane.showInputDialog("ID Cliente:");
                String latitud = latitudStr.trim();
                String longitud = longitudStr.trim();
                int idCliente = Integer.parseInt(idClienteStr);
                bdDao.actualizarDireccion(conexion, id, direccion, codigoPostal, localidad, latitud, longitud, idCliente);

            } else if ("TRABAJADORES".equals(tablaSeleccionada)) {
                String idStr = JOptionPane.showInputDialog("ID del Trabajador a Actualizar:");
                int id = Integer.parseInt(idStr);
                String ss = JOptionPane.showInputDialog("Número de Seguridad Social:");
                String puesto = JOptionPane.showInputDialog("Puesto:");
                String idDireccionStr = JOptionPane.showInputDialog("ID Dirección:");
                int idDireccion = Integer.parseInt(idDireccionStr);
                bdDao.actualizarTrabajador(conexion, id, ss, puesto, idDireccion);

            } else if ("SALIDAS".equals(tablaSeleccionada)) {
                String idStr = JOptionPane.showInputDialog("ID de la Salida a Actualizar:");
                int id = Integer.parseInt(idStr);
                String tarea = JOptionPane.showInputDialog("Tarea:");
                String instalacionesStr = JOptionPane.showInputDialog("Instalaciones (true/false):");
                String incidenciasStr = JOptionPane.showInputDialog("Incidencias (true/false):");
                String solucionStr = JOptionPane.showInputDialog("Solución (true/false):");
                String descripcion = JOptionPane.showInputDialog("Descripción:");
                String costeCliente = JOptionPane.showInputDialog("Coste Cliente:");
                String fechaTareaStr = JOptionPane.showInputDialog("Fecha Tarea (yyyy-MM-dd):");
                String idClienteStr = JOptionPane.showInputDialog("ID Cliente:");
                String idDireccionStr = JOptionPane.showInputDialog("ID Dirección:");
                String idTrabajadorStr = JOptionPane.showInputDialog("ID Trabajador:");
                boolean instalaciones = Boolean.parseBoolean(instalacionesStr);
                boolean incidencias = Boolean.parseBoolean(incidenciasStr);
                boolean solucion = Boolean.parseBoolean(solucionStr);

                java.sql.Date fechaTarea = null;
                if (fechaTareaStr != null && !fechaTareaStr.trim().isEmpty()) {
                    try {
                        fechaTarea = java.sql.Date.valueOf(fechaTareaStr);
                    } catch (IllegalArgumentException e) {
                        JOptionPane.showMessageDialog(this, "Formato de fecha inválido. Use yyyy-MM-dd.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }

                int idCliente = Integer.parseInt(idClienteStr);
                int idDireccion = Integer.parseInt(idDireccionStr);
                int idTrabajador = Integer.parseInt(idTrabajadorStr);

                bdDao.actualizarSalida(conexion, id, tarea, instalaciones ? "true" : "", incidencias ? "true" : "", solucion ? "true" : "", 
                		              descripcion, costeCliente, fechaTarea != null ? fechaTarea.toString() : "", idCliente, idDireccion, idTrabajador);

            } else if ("TRABAJADOR SALIDAS".equals(tablaSeleccionada)) {
                String idTrabajadorStr = JOptionPane.showInputDialog("ID del Trabajador a Actualizar:");
                int idTrabajador = Integer.parseInt(idTrabajadorStr);
                String idSalidaStr = JOptionPane.showInputDialog("ID de la Salida:");
                int idSalida = Integer.parseInt(idSalidaStr);
                bdDao.actualizarTrabajadorSalida(conexion, idTrabajador, idSalida);
            }

            listar(); // ACTUALIZA LA TABLA DESPUES DE ACTUALIZAR LOS DATOS
        } catch (SQLException | NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Error al actualizar datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    private void eliminar() {
        String tablaSeleccionada = (String) comboBoxTablas.getSelectedItem();
        try {
            if ("Clientes".equals(tablaSeleccionada)) {
                String idStr = JOptionPane.showInputDialog("ID del Clientes a Eliminar:");
                int id = Integer.parseInt(idStr);
                bdDao.borrarClientePorId(conexion, id);
            } else if ("Direcciones".equals(tablaSeleccionada)) {
                String idStr = JOptionPane.showInputDialog("ID de la Dirección a Eliminar:");
                int id = Integer.parseInt(idStr);
                bdDao.borrarDireccionPorId(conexion, id);
            }  else if ("Trabajadores".equals(tablaSeleccionada)) {                
                String idStr = JOptionPane.showInputDialog("ID del Trabajador a Eliminar:");
                int id = Integer.parseInt(idStr);
                bdDao.borrarTrabajadorPorId(conexion, id);
            } else if ("Salidas".equals(tablaSeleccionada)) {               
                String idStr = JOptionPane.showInputDialog("ID de la Salida a Eliminar:");
                int id = Integer.parseInt(idStr);
                bdDao.borrarSalidaPorId(conexion, id);
            }else if ("Trabajadores Salidas".equals(tablaSeleccionada)) {               
                String idStr = JOptionPane.showInputDialog("ID de la Trabajador Salida a Eliminar:");
                int id = Integer.parseInt(idStr);
                bdDao.borrarSalidaPorId(conexion, id);
            }
            listar(); // ACTUALIZA LA TABLA DESPUES DE ELIMINAR LOS DATOS
        } catch (SQLException | NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Error al eliminar datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    
    }
    private void generarEnlaceGoogleMaps(double latitud, double longitud) {
        String enlace = "https://www.google.com/maps?q=" + latitud + "," + longitud;
        textFieldUrl.setText(enlace); //  MUESTRA EL ENLACE EN EL CAMPO DE TEXTO

        //  HACER QUE EL ENLACE SEA CLICABLE
        textFieldUrl.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                try {
                    Desktop.getDesktop().browse(new java.net.URI(enlace)); // ABRIMOS EL ENLACE EN EL NAVEGADOR
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error al abrir el enlace: " + e.getMessage());
                }
            }
        });
    }

    
}
