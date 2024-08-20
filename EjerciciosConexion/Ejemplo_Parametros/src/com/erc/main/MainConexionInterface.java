package com.erc.main;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JPasswordField; // Importa JPasswordField

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
    private JPasswordField passwordField; // Usa JPasswordField para la contraseña
    private JTextArea textAreaCheck;
    private JComboBox<String> comboBoxBD;
    private JButton btnConexion;

    /**
     * Launch the application.
     */
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

    /**
     * Create the application.
     */
    public MainConexionInterface() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frmConexionBbdd = new JFrame();
        frmConexionBbdd.getContentPane().setFont(new Font("Comic Sans MS", Font.BOLD, 12));
        frmConexionBbdd.setTitle("CONEXION BBDD");
        frmConexionBbdd.setIconImage(Toolkit.getDefaultToolkit().getImage(MainConexionInterface.class.getResource("/images/BBDD.png")));
        frmConexionBbdd.setBounds(100, 100, 850, 500);
        frmConexionBbdd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmConexionBbdd.getContentPane().setLayout(null);
        
        JLabel lblbaseDatos = new JLabel("BBDD");
        lblbaseDatos.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        lblbaseDatos.setBounds(44, 42, 46, 14);
        frmConexionBbdd.getContentPane().add(lblbaseDatos);
        
        JLabel lblhost = new JLabel("IP");
        lblhost.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        lblhost.setBounds(44, 138, 46, 14);
        frmConexionBbdd.getContentPane().add(lblhost);
        
        JLabel lblpuerto = new JLabel("Puerto");
        lblpuerto.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        lblpuerto.setBounds(44, 216, 46, 14);
        frmConexionBbdd.getContentPane().add(lblpuerto);
        
        JLabel lblusuario = new JLabel("Usuario");
        lblusuario.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        lblusuario.setBounds(44, 327, 86, 14);
        frmConexionBbdd.getContentPane().add(lblusuario);
        
        JLabel lblPassword = new JLabel("Contraseña");
        lblPassword.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        lblPassword.setBounds(155, 327, 86, 14);
        frmConexionBbdd.getContentPane().add(lblPassword);
        
        btnConexion = new JButton("Conectar");
        btnConexion.setIcon(new ImageIcon(MainConexionInterface.class.getResource("/images/conexion.png")));
        btnConexion.setBounds(323, 319, 65, 65);
        frmConexionBbdd.getContentPane().add(btnConexion);
        
        textAreaCheck = new JTextArea();
        textAreaCheck.setEditable(false);
        textAreaCheck.setBounds(424, 342, 200, 40);  // Ajusta el tamaño si es necesario
        frmConexionBbdd.getContentPane().add(textAreaCheck);
        
        comboBoxBD = new JComboBox<>();
        comboBoxBD.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
        comboBoxBD.setModel(new DefaultComboBoxModel<>(new String[] {"", "cine", "neptuno"}));
        comboBoxBD.setBounds(44, 82, 86, 22);
        frmConexionBbdd.getContentPane().add(comboBoxBD);
        
        textFieldIP = new JTextField();
        textFieldIP.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
        textFieldIP.setBounds(44, 168, 86, 20);
        frmConexionBbdd.getContentPane().add(textFieldIP);
        textFieldIP.setColumns(10);
        
        textFieldPuerto = new JTextField();
        textFieldPuerto.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
        textFieldPuerto.setColumns(10);
        textFieldPuerto.setBounds(44, 259, 86, 20);
        frmConexionBbdd.getContentPane().add(textFieldPuerto);
        
        textFieldUsuario = new JTextField();
        textFieldUsuario.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
        textFieldUsuario.setColumns(10);
        textFieldUsuario.setBounds(44, 364, 86, 20);
        frmConexionBbdd.getContentPane().add(textFieldUsuario);
        
        passwordField = new JPasswordField(); // Inicializa JPasswordField
        passwordField.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
        passwordField.setBounds(155, 364, 86, 20);
        frmConexionBbdd.getContentPane().add(passwordField);
        
        btnConexion.addActionListener(e -> {
            String baseDatos = (String) comboBoxBD.getSelectedItem();
            String host = textFieldIP.getText();
            String puerto = textFieldPuerto.getText();
            String usuario = textFieldUsuario.getText();
            String password = new String(passwordField.getPassword()); // Obtiene la contraseña

            ConexionParametros parametros = new ConexionParametros(baseDatos, host, puerto, usuario, password);

            try {
                // Intentar la conexión
                parametros.conectar();
                
                // Mostrar mensaje de éxito
                textAreaCheck.setText("Conectado exitosamente");

            } catch (Exception ex) {
                ex.printStackTrace();
                textAreaCheck.setText("Error en la conexión");
            }
        });
    }
}
