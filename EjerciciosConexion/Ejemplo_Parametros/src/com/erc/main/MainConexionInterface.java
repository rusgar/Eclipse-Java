package com.erc.main;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import com.erc.model.ConexionParametros;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Font;
import javax.swing.SwingConstants;


public class MainConexionInterface {

    private JFrame frmConexionBbdd;
    private JTextField textFieldIP;
    private JTextField textFieldPuerto;
    private JTextField textFieldUsuario;
    private JPasswordField passwordField;
    private JTextArea textAreaCheck;
    private JComboBox<String> comboBoxBD;
    private JButton btnConexion,  btnReset;
    private JLabel lblImagen, lblbaseDatos,lblhost, lblpuerto;  
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainConexionInterface window = new MainConexionInterface();
                    window.frmConexionBbdd.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public MainConexionInterface() {
        initialize();
    }

    private void initialize() {
        frmConexionBbdd = new JFrame();
        frmConexionBbdd.getContentPane().setFont(new Font("Comic Sans MS", Font.BOLD, 12));
        frmConexionBbdd.setTitle("CONEXION BBDD");
        frmConexionBbdd.setIconImage(Toolkit.getDefaultToolkit().getImage(MainConexionInterface.class.getResource("/images/BBDD.png")));
        frmConexionBbdd.setBounds(100, 100, 250, 400);
        frmConexionBbdd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmConexionBbdd.getContentPane().setLayout(null);
        
        lblbaseDatos = new JLabel("BBDD");
        lblbaseDatos.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        lblbaseDatos.setBounds(74, 32, 46, 14);
        frmConexionBbdd.getContentPane().add(lblbaseDatos);
        
        lblhost = new JLabel("IP");
        lblhost.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        lblhost.setBounds(74, 90, 46, 14);
        frmConexionBbdd.getContentPane().add(lblhost);
        
        lblpuerto = new JLabel("Puerto");
        lblpuerto.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        lblpuerto.setBounds(74, 146, 46, 14);
        frmConexionBbdd.getContentPane().add(lblpuerto);
        
        JLabel lblusuario = new JLabel("Usuario");
        lblusuario.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        lblusuario.setBounds(21, 212, 86, 14);
        frmConexionBbdd.getContentPane().add(lblusuario);
        
        JLabel lblPassword = new JLabel("Contraseña");
        lblPassword.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        lblPassword.setBounds(21, 268, 86, 14);
        frmConexionBbdd.getContentPane().add(lblPassword);
        
        btnConexion = new JButton("Conectar");
        btnConexion.setIcon(new ImageIcon(MainConexionInterface.class.getResource("/images/conexion.png")));
        btnConexion.setBounds(117, 217, 96, 96);
        frmConexionBbdd.getContentPane().add(btnConexion);
        
        textAreaCheck = new JTextArea();
        textAreaCheck.setWrapStyleWord(true);
        textAreaCheck.setEditable(false);
        textAreaCheck.setBounds(21, 338, 192, 22);
        frmConexionBbdd.getContentPane().add(textAreaCheck);

       
        lblImagen = new JLabel();
        lblImagen.setBounds(62, 70, 100, 100); 
        frmConexionBbdd.getContentPane().add(lblImagen);
        
        comboBoxBD = new JComboBox<>();
        comboBoxBD.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
        comboBoxBD.setModel(new DefaultComboBoxModel<>(new String[] {"", "cine", "neptuno"}));
        comboBoxBD.setBounds(74, 57, 86, 22);
        frmConexionBbdd.getContentPane().add(comboBoxBD);
        
        textFieldIP = new JTextField();
        textFieldIP.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
        textFieldIP.setBounds(74, 115, 86, 20);
        frmConexionBbdd.getContentPane().add(textFieldIP);
        textFieldIP.setColumns(10);
        
        textFieldPuerto = new JTextField();
        textFieldPuerto.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
        textFieldPuerto.setColumns(10);
        textFieldPuerto.setBounds(74, 181, 86, 20);
        frmConexionBbdd.getContentPane().add(textFieldPuerto);
        
        textFieldUsuario = new JTextField();
        textFieldUsuario.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
        textFieldUsuario.setColumns(10);
        textFieldUsuario.setBounds(21, 237, 86, 20);
        frmConexionBbdd.getContentPane().add(textFieldUsuario);
        
        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
        passwordField.setBounds(21, 293, 86, 20);
        frmConexionBbdd.getContentPane().add(passwordField);
        
        btnReset = new JButton("");
        btnReset.setIcon(new ImageIcon(MainConexionInterface.class.getResource("/images/borrar.png")));
        btnReset.setBounds(0, 0, 40, 40); 
        frmConexionBbdd.getContentPane().add(btnReset);
        
        JLabel lblFondo = new JLabel("");
        lblFondo.setVerticalAlignment(SwingConstants.BOTTOM);
        lblFondo.setForeground(Color.WHITE);
        lblFondo.setBackground(Color.DARK_GRAY);
        lblFondo.setIcon(new ImageIcon(MainConexionInterface.class.getResource("/images/Fondo.png")));
        lblFondo.setBounds(0, 0,250, 400);
        frmConexionBbdd.getContentPane().add(lblFondo);
        
    
        btnReset.addActionListener(e -> {
           
        	//RESTABLECEMOS LOS VALORES DE LOS CAMPOS DE TEXTO
            comboBoxBD.setSelectedIndex(0);
            textFieldIP.setText("");
            textFieldPuerto.setText("");
            textFieldUsuario.setText("");
            passwordField.setText("");

            // RESTABLECEMOS EL TEXTAREA
            textAreaCheck.setText("");
            textAreaCheck.setBackground(null); // RESTABLECEMOS EL COLOR

            // RESTABLECEMOS EL ICONO DE ESTADO
            lblImagen.setIcon(null);

            // HACEMOS VISIBLE LOS CAMPOS QUE ANTES LOS PUSIMOS EN INVISIBLES
            lblbaseDatos.setVisible(true);
            lblhost.setVisible(true);
            lblpuerto.setVisible(true);
            comboBoxBD.setVisible(true);
            textFieldIP.setVisible(true);
            textFieldPuerto.setVisible(true);
        });
        
        btnConexion.addActionListener(e -> {
            String baseDatos = (String) comboBoxBD.getSelectedItem();
            String host = textFieldIP.getText();
            String puerto = textFieldPuerto.getText();
            String usuario = textFieldUsuario.getText();
            String password = new String(passwordField.getPassword());
            
         

            ConexionParametros parametros = new ConexionParametros(baseDatos, host, puerto, usuario, password);
            if(!host.equalsIgnoreCase("")) {
            	parametros.setHost(host);
            }
            if(!puerto.equalsIgnoreCase("")) {
            	parametros.setPuerto(puerto);
            }

            try {
               
             
                
                // INTENTAMOS CONECTAR LLAMANDO AL METODO DE CONECTAR
                parametros.conectar();
            	 
                
                // MOSTRAMOS EL MENSAJE DE LA CONEXION
                textAreaCheck.setText("Conectado exitosamente");
                textAreaCheck.setBackground(Color.GREEN);
                lblImagen.setIcon(new ImageIcon(MainConexionInterface.class.getResource("/images/ok.png")));
                lblbaseDatos.setVisible(false);
                lblhost.setVisible(false);
                lblpuerto.setVisible(false);
                comboBoxBD.setVisible(false);
                textFieldIP.setVisible(false);
                textFieldPuerto.setVisible(false);

            } catch (Exception ex) {
                ex.printStackTrace();
                textAreaCheck.setText("Error en la conexión");
                textAreaCheck.setBackground(Color.RED); 
                lblImagen.setIcon(new ImageIcon(MainConexionInterface.class.getResource("/images/error.png")));
                lblbaseDatos.setVisible(false);
                lblhost.setVisible(false);
                lblpuerto.setVisible(false);
                comboBoxBD.setVisible(false);
                textFieldIP.setVisible(false);
                textFieldPuerto.setVisible(false);
                
            }finally {
            	parametros.cerrarConexion();
                
			}
            
        });
    }
}
