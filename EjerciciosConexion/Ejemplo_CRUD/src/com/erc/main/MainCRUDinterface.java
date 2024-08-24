package com.erc.main;

import com.erc.helpers.ConexionBd;
import com.erc.helpers.ModeloClientes;
import com.erc.helpers.CommonHelpers;
import com.erc.helpers.ModeloTrabajadores;
import com.erc.helpers.ModeloUsuarios;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;

public class MainCRUDinterface {

    private JFrame frmCrud;
    private JTextField txtBaseDatos;
    private JTextField txtUsuario;
    private JPasswordField txtPassword;
    private Connection conexion;
    private CommonHelpers helpers = new CommonHelpers();
    private ConexionBd bd = new ConexionBd();
    private CardLayout cardLayout;
    private JPanel panelCRUD;
    private JComboBox<String> comboBoxGestiones;
    private JButton btnEjecutar;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                MainCRUDinterface window = new MainCRUDinterface();
                window.frmCrud.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public MainCRUDinterface() {
        initialize();
    }

    private void initialize() {
        frmCrud = new JFrame();
        frmCrud.setTitle("CRUD");
        frmCrud.setIconImage(Toolkit.getDefaultToolkit().getImage(MainCRUDinterface.class.getResource("/images/Mysql.png")));
        frmCrud.setBounds(100, 100, 750, 550);
        frmCrud.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmCrud.getContentPane().setLayout(null);

        JLabel lblBaseDatos = new JLabel("Base de datos:");
        lblBaseDatos.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        lblBaseDatos.setBounds(10, 11, 120, 14);
        frmCrud.getContentPane().add(lblBaseDatos);

        txtBaseDatos = new JTextField();
        txtBaseDatos.setBounds(130, 8, 180, 20);
        frmCrud.getContentPane().add(txtBaseDatos);
        txtBaseDatos.setColumns(10);

        JLabel lblUsuario = new JLabel("Usuario:");
        lblUsuario.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        lblUsuario.setBounds(10, 42, 120, 14);
        frmCrud.getContentPane().add(lblUsuario);

        txtUsuario = new JTextField();
        txtUsuario.setBounds(130, 39, 180, 20);
        frmCrud.getContentPane().add(txtUsuario);
        txtUsuario.setColumns(10);

        JLabel lblPassword = new JLabel("Contraseña:");
        lblPassword.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        lblPassword.setBounds(323, 42, 120, 14);
        frmCrud.getContentPane().add(lblPassword);

        txtPassword = new JPasswordField();
        txtPassword.setBounds(430, 39, 180, 20);
        frmCrud.getContentPane().add(txtPassword);

        JButton btnConectar = new JButton("Conectar");
        btnConectar.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        btnConectar.setBounds(629, 38, 100, 23);
        frmCrud.getContentPane().add(btnConectar);

        JButton btnDesconectar = new JButton("Desconectar");
        btnDesconectar.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        btnDesconectar.setBounds(609, 403, 120, 23);
        frmCrud.getContentPane().add(btnDesconectar);

        JLabel lblMenu = new JLabel("Seleccione operación:");
        lblMenu.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        lblMenu.setBounds(10, 74, 150, 14);
        frmCrud.getContentPane().add(lblMenu);

        comboBoxGestiones = new JComboBox<>(new String[]{"Gestionar Usuarios", "Gestionar Clientes", "Gestionar Trabajadores"});
        comboBoxGestiones.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        comboBoxGestiones.setBounds(10, 100, 200, 23);
        frmCrud.getContentPane().add(comboBoxGestiones);

        btnEjecutar = new JButton("Ejecutar");
        btnEjecutar.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        btnEjecutar.setBounds(220, 100, 100, 23);
        frmCrud.getContentPane().add(btnEjecutar);
        
        
        // UTILIZAMOS EL PANELCRUD Y EL CARDLAYOUT PARA MOSTRAR LOS CAMPOS DE MYSQL
        panelCRUD = new JPanel();
        cardLayout = new CardLayout();
        panelCRUD.setLayout(cardLayout);
        panelCRUD.setBounds(10, 166, 566, 264);
        frmCrud.getContentPane().add(panelCRUD);

        
        // CREAMOS LOS PANELES POR CADA OPCION DEL CRUD, COMO TENEMOS TRES MODELOS CREAMOS TRES PANELES
        JPanel panelUsuarios = crearPanelUsuarios();
        JPanel panelClientes = crearPanelClientes();
        JPanel panelTrabajadores = crearPanelTrabajadores();

       
        // AÑADIMOS LOS PANELES POR CADA UNO DE ELLOS
        panelCRUD.add(panelUsuarios, "Usuarios");
        panelCRUD.add(panelClientes, "Clientes");
        panelCRUD.add(panelTrabajadores, "Trabajadores");

        JLabel lblFondo = new JLabel("");
        lblFondo.setHorizontalAlignment(SwingConstants.TRAILING);
        lblFondo.setVerticalAlignment(SwingConstants.BOTTOM);
        lblFondo.setIcon(new ImageIcon(MainCRUDinterface.class.getResource("/images/Fondo.png")));
        lblFondo.setBounds(0, 0, 729, 511);
        frmCrud.getContentPane().add(lblFondo);

        
        // DESHABILITAMOS TANTO LOS CAMPOS DEL CRUD COMO LOS PANELES PARA QUE NO SE VEAN
        activarCamposCRUD(false);
        panelCRUD.setVisible(false);

       
        // ACTIONLISTENER PARA EL  BOTON DE CONECTAR 
        btnConectar.addActionListener(e -> {
            String baseDatos = txtBaseDatos.getText();
            String usuario = txtUsuario.getText();
            String password = new String(txtPassword.getPassword());

            bd.setBaseDatos(baseDatos);
            bd.setUsuario(usuario);
            bd.setPassword(password);

            try {
                conexion = bd.generarConexion();
                JOptionPane.showMessageDialog(frmCrud, "Conexión realizada con éxito.", "Conexión", JOptionPane.INFORMATION_MESSAGE);
                activarCamposCRUD(true); // ACTIVAMOS LOS CAMPOS SI LA CONEXION ES CORRECTA
            } catch (SQLException ex) {
            	String mensajeError = "Error al conectar a la base de datos. ";
                if (ex.getSQLState().startsWith("28")) { // ESTADO DE ERROR PARA PROBLEMAS DE AUTENTIFICACION (28000, 28001,28002) USUARIO, CONTRASEÑA O COFIGURACION
                    mensajeError += "Verifique el usuario y la contraseña.";
                    JOptionPane.showMessageDialog(frmCrud, mensajeError, "Error de Conexión", JOptionPane.ERROR_MESSAGE);
                } 
            } catch (Exception ex) {
            	 JOptionPane.showMessageDialog(frmCrud, "Error inesperado: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            }
        });

        //  ACTION LISTENER PARA EL BOTON DE DESCONECTAR
        btnDesconectar.addActionListener(e -> {
            try {
                if (conexion != null && !conexion.isClosed()) {
                    conexion.close();
                    JOptionPane.showMessageDialog(frmCrud, "Desconectado de la base de datos.", "Desconexión", JOptionPane.INFORMATION_MESSAGE);
                    activarCamposCRUD(false); //VUELVE A DESHABILITAR COMO AL INICIO EL PANEL CRUD Y EL COMBOBOX
                    panelCRUD.setVisible(false);
                    limpiarCampos(txtBaseDatos, txtUsuario, txtPassword); // LIMPIA LOS CAMPOS PARA VOLVER AL INICIO, PARA QUE NO QUEDEN REFLEJADOS
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });

        //  ACTIONLISTENER PARA EL BOTON EJECUTAR
        btnEjecutar.addActionListener(e -> {
            String seleccion = (String) comboBoxGestiones.getSelectedItem();
            try {
                mostrarPanel(seleccion); // AL EJECUTARLO SE ACTIVA EL PANEL DE SELECCION QUE ENGLOBA EL COMBOBOX
                panelCRUD.setVisible(true); // ADEMAS SE ACTIVA EL PANELCRUD PARA LAS CONSULTAS
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });
    }

    // ***************************************************************************************************************************
    // EMPEZAMOS POR EL PRIMER PANEL DE USUARIOS
    private JPanel crearPanelUsuarios() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(9, 2)); // AJUSTAMOS EL GRID PARA TENER 9 FILAS Y DOS COLUMNAS
        
        // MOSTRAMOS TODOD LOS CAMPOS COMO EN NUESTRA TABLA USUARIOS
        // COMPONENTES QUE VAMOS A UTILIZAR EN ESTE PANEL
        JLabel lblID = new JLabel("ID:");
        lblID.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
        JTextField txtID = new JTextField();
        txtID.setEditable(false); //  DESHABILITADO PUES NO QUEREMOS METER EL ID, PUES LO TENEMOS AUTOINCREMENTAL
        txtID.setBackground(Color.LIGHT_GRAY); // GRIS CLARO PARA MOSTRAR LA DIFERENCIA Y ES SOLO LECTURA

        JLabel lblDNI = new JLabel("DNI:");
        lblDNI.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
        JTextField txtDNI = new JTextField();
        
        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
        JTextField txtNombre = new JTextField();
        
        JLabel lblApellido = new JLabel("Apellido:");
        lblApellido.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
        JTextField txtApellido = new JTextField();
        
        JLabel lblDireccion = new JLabel("Dirección:");
        lblDireccion.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
        JTextField txtDireccion = new JTextField();
        
        JLabel lblTelefono = new JLabel("Teléfono:");
        lblTelefono.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
        JTextField txtTelefono = new JTextField();
        
        JLabel lblMail = new JLabel("Email:");
        lblMail.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
        JTextField txtMail = new JTextField();

        // BOTONES DE NUESTRO GRID
        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
        
        JButton btnLeer = new JButton("Leer");
        btnLeer.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
        
        JButton btnActualizar = new JButton("Actualizar");
        btnActualizar.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
        
        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.setFont(new Font("Comic Sans MS", Font.BOLD, 12));

        
        //  AÑADIMOS LOS COMPONENTES AL PANEL
        panel.add(lblID);
        panel.add(txtID);
        panel.add(lblDNI);
        panel.add(txtDNI);
        panel.add(lblNombre);
        panel.add(txtNombre);
        panel.add(lblApellido);
        panel.add(txtApellido);
        panel.add(lblDireccion);
        panel.add(txtDireccion);
        panel.add(lblTelefono);
        panel.add(txtTelefono);
        panel.add(lblMail);
        panel.add(txtMail);
         // AÑADIMOS LOS BOTONES A CONTINUACION DE LOS LABEL Y TEXTOS
        panel.add(btnGuardar);
        panel.add(btnLeer);
        panel.add(btnActualizar);
        panel.add(btnEliminar);

        // ACCION QUE REALIZA EL BOTON GUARDAR
        btnGuardar.addActionListener(e -> {
            try {
                //  VALIDACION DEL DNI, MOSTRANDO MENSAJE DE 8 + 1 LETRA
                if (!validarDNI(txtDNI.getText())) {
                    JOptionPane.showMessageDialog(frmCrud, "El DNI debe tener 8 dígitos seguidos de una letra.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                // CARGAMOS EL MODELOUSUARIOS, DONDE ESTAN TODOS NUESTROS MODELOS DE NUESTRA CLASES
                ModeloUsuarios modeloUsuarios = new ModeloUsuarios(conexion, helpers);
                // COGEMOS EN ESTE CASO EL METODO DE CREARUSUARIOS
                modeloUsuarios.crearUsuario(txtDNI.getText(), txtNombre.getText(), txtApellido.getText(), txtDireccion.getText(), txtTelefono.getText(), txtMail.getText());
                JOptionPane.showMessageDialog(frmCrud, "Usuario guardado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                // LIMPIA TODOS LOS CAMPOS DE CADA UNO DE LOS PARAMETROS INTRODUCIDOS
                limpiarCampos(txtID, txtDNI, txtNombre, txtApellido, txtDireccion, txtTelefono, txtMail);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });

        // ACCION QUE REALIZA EL BOTON LEER
        btnLeer.addActionListener(e -> {
            txtID.setEditable(true); // ANTES DE NADA HABILITA EL TXTID, PARA QUE BUSQUEMOS POR EL ID
            txtID.setBackground(Color.WHITE); // CAMBIA EL COLOR DE FONDO PARA INDICAR QUE SE PUEDA EDITAR

            try {
            	int id = helpers.getIntFromTextField(txtID);
                ModeloUsuarios modeloUsuarios = new ModeloUsuarios(conexion, helpers);
                ResultSet rsLeer = modeloUsuarios.buscarUsuarioPorID(id);
                if (rsLeer.next()) {
                    txtID.setText(String.valueOf(id)); //  ESTABLECEMOS EL VALOR DE LA ID DENTRO DEL CAMPOS
                    txtDNI.setText(rsLeer.getString("dni"));// RECOGE Y MUESTRA TODOS LOS CAMPOS QUE PEDIMOS EN LOS CAMPOS DE TEXTO
                    txtNombre.setText(rsLeer.getString("nombre"));
                    txtApellido.setText(rsLeer.getString("apellido"));
                    txtDireccion.setText(rsLeer.getString("direccion"));
                    txtTelefono.setText(rsLeer.getString("telefono"));
                    txtMail.setText(rsLeer.getString("mail"));
                } else {
                    JOptionPane.showMessageDialog(frmCrud, "No se encontró ningún usuario con ese ID.", "Información", JOptionPane.INFORMATION_MESSAGE);
                    limpiarCampos(txtID, txtDNI, txtNombre, txtApellido, txtDireccion, txtTelefono, txtMail); // LIMPIA TODOS LOS DATOS SI NO ENCUENTRA NADA
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            } catch (NumberFormatException ex) {
                
            }
        });

        // ACCION QUE REALIZA EL BOTON ACTUALIZAR
        btnActualizar.addActionListener(e -> {
            try {
            	int id = helpers.getIntFromTextField(txtID);
                ModeloUsuarios modeloUsuarios = new ModeloUsuarios(conexion, helpers);
                modeloUsuarios.actualizarUsuario(id, txtDNI.getText(), txtNombre.getText(), txtApellido.getText(), txtDireccion.getText(), txtTelefono.getText(), txtMail.getText());
                JOptionPane.showMessageDialog(frmCrud, "Usuario actualizado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                // LIMPIA LOS CAMPOS UNA VEZ EL USUARIO HA ESTADO INTRODUCIDO
                limpiarCampos(txtID, txtDNI, txtNombre, txtApellido, txtDireccion, txtTelefono, txtMail);
                //  RESTAURA EL CAMPO DE LA ID SOLO EN LECRURA NO PODEMOS EDITARLOS
                txtID.setEditable(false);
             // RESTAURAMEOS TAMBIEN EL COLOR DE FONDO
                txtID.setBackground(Color.LIGHT_GRAY); 
            } catch (SQLException ex) {
                ex.printStackTrace();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frmCrud, "Por favor, ingrese datos válidos.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // ACCION QUE REALIZA EL BOTON ELIMINAR
        btnEliminar.addActionListener(e -> {
            try {
            	int id = helpers.getIntFromTextField(txtID);
                int confirm = JOptionPane.showConfirmDialog
                		(frmCrud, "¿Está seguro que desea eliminar al usuario con ID " + id + "?",
                		"Confirmación", JOptionPane.YES_NO_OPTION);
                         if (confirm == JOptionPane.YES_OPTION) { // MUESTRA ESTE MENSAJE SI LE HEMOS DADOS A CONFIRMAR ELIMNACION
                    ModeloUsuarios modeloUsuarios = new ModeloUsuarios(conexion, helpers);
                    modeloUsuarios.eliminarUsuario(id);
                    JOptionPane.showMessageDialog(frmCrud, "Usuario eliminado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    limpiarCampos(txtID, txtDNI, txtNombre, txtApellido, txtDireccion, txtTelefono, txtMail);
                //  RESTAURA EL CAMPO DE LA ID SOLO EN LECRURA NO PODEMOS EDITARLOS
                    txtID.setEditable(false);
                 // RESTAURAMEOS TAMBIEN EL COLOR DE FONDO 
                    txtID.setBackground(Color.LIGHT_GRAY); 
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frmCrud, "ID inválido. Por favor, ingrese un número.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        return panel;
    }



    // ***************************************************************************************************************************
    // EMPEZAMOS POR EL PRIMER PANEL DE CLIENTES

    private JPanel crearPanelClientes() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));  // AJUSTAMOS EL GRID PARA TENER 5 FILAS Y DOS COLUMNAS

         // MOSTRAMOS TODOD LOS CAMPOS COMO EN NUESTRA TABLA CLIENTES
        // COMPONENTES QUE VAMOS A UTILIZAR EN ESTE PANEL
        JLabel lblPuntos = new JLabel("Puntos:");
        lblPuntos.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
        JTextField txtPuntos = new JTextField();
        
        JLabel lblIDUsuario = new JLabel("ID Usuario:");
        lblIDUsuario.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
        JTextField txtIDUsuario = new JTextField();
        
        JLabel lblIDCliente = new JLabel("ID Cliente:");
        lblIDCliente.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
        JTextField txtIDCliente = new JTextField();
        txtIDCliente.setEditable(false); // DESHABILITADO PUES NO QUEREMOS METER EL ID, PUES LO TENEMOS AUTOINCREMENTAL
        txtIDCliente.setBackground(Color.LIGHT_GRAY); // GRIS CLARO PARA MOSTRAR LA DIFERENCIA Y ES SOLO LECTURA

        // BOTONES DE NUESTRO GRID
        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
        JButton btnLeer = new JButton("Leer");
        btnLeer.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
        JButton btnActualizar = new JButton("Actualizar");
        btnActualizar.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.setFont(new Font("Comic Sans MS", Font.BOLD, 12));

        //  AÑADIMOS LOS COMPONENTES AL PANEL
        panel.add(lblPuntos);
        panel.add(txtPuntos);
        panel.add(lblIDUsuario);
        panel.add(txtIDUsuario);
        panel.add(lblIDCliente);
        panel.add(txtIDCliente);
        // AÑADIMOS LOS BOTONES A CONTINUACION DE LOS LABEL Y TEXTOS
        panel.add(btnLeer);
        panel.add(btnGuardar);
        panel.add(btnActualizar);
        panel.add(btnEliminar);

        // ACCION QUE REALIZA EL BOTON GUARDAR
        btnGuardar.addActionListener(e -> {
            try {
            	// CARGAMOS EL MODELOCLIENTES, DONDE ESTAN TODOS NUESTROS MODELOS DE NUESTRA CLASES
                ModeloClientes modeloClientes = new ModeloClientes(conexion, helpers);
                // OBTENEMOS LOS VALORES DE LOS CAMPOS DE TEXTO
                int puntos = helpers.getIntFromTextField(txtPuntos);
                int idUsuario = helpers.getIntFromTextField(txtIDUsuario);
                // USAMOS LOS VALORES DENTRO DE NUESTRO METODO(CREARCLIENTE) DE LA CLASE(MODELOCIENTES) 
                modeloClientes.crearCliente(puntos, idUsuario);
                
                JOptionPane.showMessageDialog(frmCrud, "Cliente guardado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                limpiarCampos(txtPuntos, txtIDUsuario, txtIDCliente);
                txtIDCliente.setEditable(false); // // DESHABILITADO EL CAMPO DESPUES DE GUARDAR
                txtIDCliente.setBackground(Color.LIGHT_GRAY); //GRIS CLARO PARA MOSTRAR LA DIFERENCIA Y ES SOLO LECTURA
            } catch (SQLException ex) {
                ex.printStackTrace();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frmCrud, "Por favor, ingrese datos válidos.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // ACCION QUE REALIZA NUESTRO BOTON LECTURA
        btnLeer.addActionListener(e -> {
            txtIDCliente.setEditable(true); // HABILITAMOS EL CAMPO CORRESPONDIENTE PUES LO NECESITAMOS 
            txtIDCliente.setBackground(Color.WHITE); // CAMBIA EL COLOR TAMBIEN PUES ES EDITABLE

            try {
            	int id = helpers.getIntFromTextField(txtIDCliente);
                ModeloClientes modeloClientes = new ModeloClientes(conexion, helpers);
                ResultSet rsLeer = modeloClientes.leerCliente(id);
                if (rsLeer.next()) {
                    txtPuntos.setText(String.valueOf(rsLeer.getInt("puntos")));
                    txtIDUsuario.setText(String.valueOf(rsLeer.getInt("id_usuario")));
                    txtIDCliente.setText(String.valueOf(rsLeer.getInt("id"))); //  MUESTRA EL ID DEL CLINTE
                } else {
                    JOptionPane.showMessageDialog(frmCrud, "No se encontró ningún cliente con ese ID_Cliente.", "Información", JOptionPane.INFORMATION_MESSAGE);
                    //LIMPIA LOS CAMPOS PARA QUE QUEDEN VACIOS
                    limpiarCampos(txtPuntos, txtIDUsuario, txtIDCliente);
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            } catch (NumberFormatException ex) {
                
            }
        });

     // ACCION QUE REALIZA NUESTRO BOTON ACTUALIZAR
        btnActualizar.addActionListener(e -> {
            try {
            	int id = helpers.getIntFromTextField(txtIDCliente);
                ModeloClientes modeloClientes = new ModeloClientes(conexion, helpers);
             //  CAMBIAMOS LA CONVERSION DE TEXTO A ENTERO PAR LOS CAMPOS NECESARIOS
                int puntos = helpers.getIntFromTextField(txtPuntos);
                int idUsuario = helpers.getIntFromTextField(txtIDUsuario);
             //  LLAMAMOS AL METODO ACTUALIZAR CLIENTE CON LOS VALORES CONVERTIDOS
                modeloClientes.actualizarCliente(id, puntos, idUsuario);
                
                JOptionPane.showMessageDialog(frmCrud, "Cliente actualizado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
              //LIMPIA LOS CAMPOS PARA QUE QUEDEN VACIOS
                limpiarCampos(txtPuntos, txtIDUsuario, txtIDCliente);                
                txtIDCliente.setEditable(false); //  DESHABILITADO EL CAMPO DESPUES DE ACTUALIZAR
                txtIDCliente.setBackground(Color.LIGHT_GRAY); // RESTAURA EL COLOR DE FONDO ORIGINAL
            } catch (SQLException ex) {
                ex.printStackTrace();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frmCrud, "Por favor, ingrese datos válidos.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

     // ACCION QUE REALIZA NUESTRO BOTON ELIMINAR
        btnEliminar.addActionListener(e -> {
            try {
                int id = Integer.parseInt(txtIDCliente.getText());
                int confirm = JOptionPane.showConfirmDialog(frmCrud, "¿Está seguro que desea eliminar al cliente con ID_Cliente " + id + "?",
                		      "Confirmación", JOptionPane.YES_NO_OPTION);
                              if (confirm == JOptionPane.YES_OPTION) {// MUESTRA ESTE MENSAJE SI LE HEMOS DADOS A CONFIRMAR ELIMNACION
                    ModeloClientes modeloClientes = new ModeloClientes(conexion, helpers);
                    modeloClientes.eliminarCliente(id);
                    JOptionPane.showMessageDialog(frmCrud, "Cliente eliminado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    limpiarCampos(txtPuntos, txtIDUsuario, txtIDCliente);
                    txtIDCliente.setText(""); //  lIMPIA EL CAMPO DEL IDCLIENTE DESPUES DE ELIMINARLO
                    txtIDCliente.setEditable(false); //  DESHABILITADO EL CAMPO DESPUES DE ELIMINARLO
                    txtIDCliente.setBackground(Color.LIGHT_GRAY); // RESTAURA EL COLOR DE FONDO ORIGINAL
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frmCrud, "ID_Cliente inválido. Por favor, ingrese un número.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        return panel;
    }

    
 // ***************************************************************************************************************************
    // EMPEZAMOS POR EL PRIMER PANEL DE TRABAJADORES
    private JPanel crearPanelTrabajadores() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2)); // AJUSTAMOS EL GRID PARA TENER 6 FILAS Y DOS COLUMNAS

        // MOSTRAMOS TODOD LOS CAMPOS COMO EN NUESTRA TABLA CLIENTES
        // COMPONENTES QUE VAMOS A UTILIZAR EN ESTE PANEL
        JLabel lblSS = new JLabel("NSS:");
        lblSS.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
        JTextField txtSS = new JTextField();
        
        JLabel lblSalario = new JLabel("Salario:");
        lblSalario.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
        JTextField txtSalario = new JTextField();
        
        JLabel lblIDUsuario = new JLabel("ID Usuario:");
        lblIDUsuario.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
        JTextField txtIDUsuario = new JTextField();
        
        JLabel lblIDTrabajador = new JLabel("ID Trabajador:");
        lblIDTrabajador.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
        JTextField txtIDTrabajador = new JTextField();
        txtIDTrabajador.setEditable(false); // DESHABILITADO PUES NO QUEREMOS METER EL ID, PUES LO TENEMOS AUTOINCREMENTAL
        txtIDTrabajador.setBackground(Color.LIGHT_GRAY); // GRIS CLARO PARA MOSTRAR LA DIFERENCIA Y ES SOLO LECTURA
        
     // BOTONES DE NUESTRO GRID
        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
        JButton btnLeer = new JButton("Leer");
        btnLeer.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
        JButton btnActualizar = new JButton("Actualizar");
        btnActualizar.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.setFont(new Font("Comic Sans MS", Font.BOLD, 12));

    //  AÑADIMOS LOS COMPONENTES AL PANEL
        panel.add(lblSS);
        panel.add(txtSS);
        panel.add(lblSalario);
        panel.add(txtSalario);
        panel.add(lblIDUsuario);
        panel.add(txtIDUsuario);
        panel.add(lblIDTrabajador);
        panel.add(txtIDTrabajador);
        // AÑADIMOS LOS BOTONES A CONTINUACION DE LOS LABEL Y TEXTOS
        panel.add(btnLeer);
        panel.add(btnGuardar);
        panel.add(btnActualizar);
        panel.add(btnEliminar);

     // ACCION QUE REALIZA EL BOTON GUARDAR
        btnGuardar.addActionListener(e -> {
        	
            try {// ADVERTIMOS QUE EL NUMERO DE LA SS ES DE 12 DIGITOS
            	String nSS = txtSS.getText();
                if (nSS.length() != 12) {
                    JOptionPane.showMessageDialog(frmCrud, "El NSS debe tener exactamente 12 dígitos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    return;
                }
             // CARGAMOS EL MODELOTRABAJADORES, DONDE ESTAN TODOS NUESTROS MODELOS DE NUESTRA CLASES
                ModeloTrabajadores modeloTrabajadores = new ModeloTrabajadores(conexion, helpers);
             // OBTENEMOS EL VALOR DEL CAMPO COMO DOUBLE USANDO HELPERS
                double salario = helpers.getDoubleFromTextField(txtSalario);
             //  // OBTENEMOS EL VALOR DEL CAMPO COMO INT USANDO HELPERS
                int idUsuario = helpers.getIntFromTextField(txtIDUsuario);
             // CREAMOS UN NUEBVO TRABAJADOR USANDO LOS VALORES CONVERTIDOS
                modeloTrabajadores.crearTrabajador(txtSS.getText(), salario, idUsuario);
               
                JOptionPane.showMessageDialog(frmCrud, "Trabajador guardado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
              //LIMPIA LOS CAMPOS PARA QUE QUEDEN VACIOS
                limpiarCampos(txtSS, txtSalario, txtIDUsuario, txtIDTrabajador);
                txtIDTrabajador.setEditable(false); //  DESHABILITADO EL CAMPO DESPUES DE GUARDAR
                txtIDTrabajador.setBackground(Color.LIGHT_GRAY); // RESTAURAMOS EL COLOR DE FONDO ORIGINAL
            } catch (SQLException ex) {
                ex.printStackTrace();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frmCrud, "Por favor, ingrese datos válidos.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

     // ACCION QUE REALIZA EL BOTON LEER
        btnLeer.addActionListener(e -> {
            txtIDTrabajador.setEditable(true); //  HABILITAMOS LA EDICION DEL TEXTO DEL ID_TRABAJDOR
            txtIDTrabajador.setBackground(Color.WHITE); // CAMBIAMOS EL COLOR DE FONDO PARA QUE INDIQUE QUE PODEMOS EDITARLO

            try {
            	int id = helpers.getIntFromTextField(txtIDTrabajador);
                ModeloTrabajadores modeloTrabajadores = new ModeloTrabajadores(conexion, helpers);
                ResultSet rsLeer = modeloTrabajadores.leerTrabajador(id);
                if (rsLeer.next()) {
                    txtSS.setText(rsLeer.getString("ss"));
                    txtSalario.setText(String.valueOf(rsLeer.getDouble("salario")));
                    txtIDUsuario.setText(String.valueOf(rsLeer.getInt("id_usuario")));
                    txtIDTrabajador.setText(String.valueOf(rsLeer.getInt("id"))); // CON ESTA INDICACION MOSTRAMOS EL ID CORRESPONDIENTE
                } else {
                    JOptionPane.showMessageDialog(frmCrud, "No se encontró ningún trabajador con ese ID_Trabajador.", "Información", JOptionPane.INFORMATION_MESSAGE);
                  //LIMPIA LOS CAMPOS PARA QUE QUEDEN VACIOS
                    limpiarCampos(txtSS, txtSalario, txtIDUsuario, txtIDTrabajador);
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            } catch (NumberFormatException ex) {
               
            }
        });

        // ACCION QUE REALIZA EL BOTON ACTUALIZAR
        btnActualizar.addActionListener(e -> {
            try {
            	int id = helpers.getIntFromTextField(txtIDTrabajador);
                ModeloTrabajadores modeloTrabajadores = new ModeloTrabajadores(conexion, helpers);
                modeloTrabajadores.actualizarTrabajador(id, 
                	    txtSS.getText(), 
                	    helpers.getDoubleFromTextField(txtSalario), 
                	    helpers.getIntFromTextField(txtIDUsuario));
                JOptionPane.showMessageDialog(frmCrud, "Trabajador actualizado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
              //LIMPIA LOS CAMPOS PARA QUE QUEDEN VACIOS
                limpiarCampos(txtSS, txtSalario, txtIDUsuario, txtIDTrabajador);
                txtIDTrabajador.setEditable(false); //  DESHABILITADO EL CAMPO DESPUES DE ACTUALIZAR
                txtIDTrabajador.setBackground(Color.LIGHT_GRAY); // RESTAURAMOS EL COLOR DE FONDO ORIGINAL
            } catch (SQLException ex) {
                ex.printStackTrace();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frmCrud, "Por favor, ingrese datos válidos.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

     // ACCION QUE REALIZA EL BOTON DE ELIMINAR
        btnEliminar.addActionListener(e -> {
            try {
            	int id = helpers.getIntFromTextField(txtIDTrabajador);
                int confirm = JOptionPane.showConfirmDialog(frmCrud, "¿Está seguro que desea eliminar al trabajador con ID_Trabajador " + id + "?",
                		      "Confirmación", JOptionPane.YES_NO_OPTION);
                              if (confirm == JOptionPane.YES_OPTION) { // MUESTRA ESTE MENSAJE SI LE HEMOS DADOS A CONFIRMAR ELIMNACION
                    ModeloTrabajadores modeloTrabajadores = new ModeloTrabajadores(conexion, helpers);
                    modeloTrabajadores.eliminarTrabajador(id);
                    JOptionPane.showMessageDialog(frmCrud, "Trabajador eliminado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    limpiarCampos(txtSS, txtSalario, txtIDUsuario, txtIDTrabajador);
                    txtIDTrabajador.setText(""); //  LIMPIA EL CAMPO DEL ID DESPUES DE ELIMINARLO
                    txtIDTrabajador.setEditable(false); //  DESHABILITA EL CAMPO DESPUES DE ELIMINARLO
                    txtIDTrabajador.setBackground(Color.LIGHT_GRAY); // RESTAURA EL COLOR DE FONDO ORIGINAL 
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frmCrud, "ID_Trabajador inválido. Por favor, ingrese un número.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        return panel;
    }


// *****************************************************************************************************************************************


    private void activarCamposCRUD(boolean habilitado) { // METEMOS EN UN PARAMETRO EL BOOLEAN DE HABILITACION DE LOS CAMPOS CRUD
        comboBoxGestiones.setEnabled(habilitado); 
        btnEjecutar.setEnabled(habilitado);
        habilitarComponentes(panelCRUD, habilitado);
        if (!habilitado) { // SINO SE HABILITA, MUESTRA UNA VISTA POR DEFECTO Y CAMBIA EL COLOR DEL MISMO ,TANTO EL CARDLAYOYT COMO EL PANELCRUD
            cardLayout.show(panelCRUD, "default"); // CAMBIA EL PANEL ACTUAL A UNO POR DEFECTO 
            panelCRUD.setBackground(Color.LIGHT_GRAY);// CAMBIA EL PANELCRUD A GRIS CLARO
        } else {
            panelCRUD.setBackground(Color.WHITE);// SI NO SE HABILITA SE QUEDA EN COLOR BLANCO
        }
    }

    private void habilitarComponentes(Component component, boolean enabled) {
    	// CON ESTO ESTA VERIFICANDO QUE EL COMPONENTE ES UNA INSTANCIA DEL CONTENERDOR (ES UNA INSTANCIA DEL SWIG) DE LOS COMPONENTES DE DE PADRE A HIJO
        if (component instanceof Container) {
            Component[] components = ((Container) component).getComponents(); //RECORRE EL ARRAY DE TODOS LOS COMPOENNTES HIJOS DEL CONTENEDOR (GET.COMPONENTS)
            for (int i = 0; i < components.length; i++) {
                Component child = components[i];
                child.setEnabled(enabled);
                habilitarComponentes(child, enabled);
            }
        } else {
            component.setEnabled(enabled);
        }
    }


    private void mostrarPanel(String tipo) throws SQLException {
        if (conexion != null && !conexion.isClosed()) {
            switch (tipo) {
                case "Gestionar Usuarios":
                    cardLayout.show(panelCRUD, "Usuarios");
                    break;
                case "Gestionar Clientes":
                    cardLayout.show(panelCRUD, "Clientes");
                    break;
                case "Gestionar Trabajadores":
                    cardLayout.show(panelCRUD, "Trabajadores");
                    break;
                default:
                    throw new IllegalArgumentException("Opción desconocida: " + tipo);
            }
        }
    }
 //  METODO PARA VALIDAR EL FORMATO DEL FORMATO DNI
    private boolean validarDNI(String dni) {
        //REGEX PARA VALIDAR EL DNI: 8 DIGITOS SEGUIDOS DE UNA LETRA
        String regex = "^[0-9]{8}[A-Za-z]$";
        return dni.matches(regex);
    }
    // METODO PARA ENGLOBAR TODOS LOS CAMPOS JTEXFILED
    private void limpiarCampos(JTextField... campos) { // JTextField ADMITE COMO VARARGS, ACEPTA UN NUMERO INDETERMIONADO DE ARGUEMNTOS DEL MISMO TIPO
        for (int i = 0; i < campos.length; i++) {
            campos[i].setText("");
        }
    }
}
