package com.erc.main;



import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import com.erc.helpers.CommonHelpers;
import com.erc.model.ConexionBd;

import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class MainConexionInterfaz {

	private JFrame frmConexionBd;
	private JTextField txtBaseDatos;
	private JTextField txtHost;
	private JTextField txtPuerto;
	private JTextField txtUsuario;
	private JPasswordField txtPassword;
	CommonHelpers helpers;
	ConexionBd bd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainConexionInterfaz window = new MainConexionInterfaz();
					window.frmConexionBd.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainConexionInterfaz() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
	    bd = new ConexionBd();
	    frmConexionBd = new JFrame();
	    frmConexionBd.setTitle("Conexion BD");
	    frmConexionBd.setIconImage(Toolkit.getDefaultToolkit().getImage(MainConexionInterfaz.class.getResource("/images/base-de-datos-64.png")));
	    frmConexionBd.setBounds(100, 100, 300, 500);
	    frmConexionBd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frmConexionBd.getContentPane().setLayout(null);

	    JLabel lblBaseDatos = new JLabel("Base de datos:");
	    lblBaseDatos.setFont(new Font("Times New Roman", Font.PLAIN, 14));
	    lblBaseDatos.setBounds(87, 10, 120, 25);
	    frmConexionBd.getContentPane().add(lblBaseDatos);

	    txtBaseDatos = new JTextField();
	    txtBaseDatos.setBounds(87, 41, 120, 25);
	    frmConexionBd.getContentPane().add(txtBaseDatos);
	    txtBaseDatos.setColumns(10);

	    JLabel lblHost = new JLabel("Host:");
	    lblHost.setFont(new Font("Times New Roman", Font.PLAIN, 14));
	    lblHost.setBounds(87, 76, 120, 25);
	    frmConexionBd.getContentPane().add(lblHost);

	    txtHost = new JTextField("localhost");
	    txtHost.setColumns(10);
	    txtHost.setBounds(87, 107, 120, 25);
	    txtHost.setBackground(Color.LIGHT_GRAY);
	    frmConexionBd.getContentPane().add(txtHost);

	    txtHost.addFocusListener(new FocusAdapter() {
	        @Override
	        public void focusGained(FocusEvent e) {
	            txtHost.setBackground(Color.WHITE);
	            if (txtHost.getText().equals(bd.getHost())) {
	                txtHost.setText("");
	            }
	        }

	        @Override
	        public void focusLost(FocusEvent e) {
	            if (txtHost.getText().isEmpty()) {
	                txtHost.setBackground(Color.LIGHT_GRAY);
	                txtHost.setText(bd.getHost());
	            }
	        }
	    });

	    JLabel lblPuerto = new JLabel("Puerto:\r\n");
	    lblPuerto.setFont(new Font("Times New Roman", Font.PLAIN, 14));
	    lblPuerto.setBounds(87, 142, 120, 25);
	    frmConexionBd.getContentPane().add(lblPuerto);

	    txtPuerto = new JTextField("3306");
	    txtPuerto.setColumns(10);
	    txtPuerto.setBounds(87, 173, 120, 25);
	    txtPuerto.setBackground(Color.LIGHT_GRAY);
	    frmConexionBd.getContentPane().add(txtPuerto);

	    txtPuerto.addFocusListener(new FocusAdapter() {
	        @Override
	        public void focusGained(FocusEvent e) {
	            txtPuerto.setBackground(Color.WHITE);
	            if (txtPuerto.getText().equals(bd.getHost())) {
	                txtPuerto.setText("");
	            }
	        }

	        @Override
	        public void focusLost(FocusEvent e) {
	            if (txtPuerto.getText().isEmpty()) {
	                txtPuerto.setBackground(Color.LIGHT_GRAY);
	                txtPuerto.setText(bd.getHost());
	            }
	        }
	    });

	    JLabel lblUsuario = new JLabel("Usuario:");
	    lblUsuario.setFont(new Font("Times New Roman", Font.PLAIN, 14));
	    lblUsuario.setBounds(87, 208, 120, 25);
	    frmConexionBd.getContentPane().add(lblUsuario);

	    txtUsuario = new JTextField();
	    txtUsuario.setColumns(10);
	    txtUsuario.setBounds(87, 239, 120, 25);
	    frmConexionBd.getContentPane().add(txtUsuario);

	    JLabel lblPassword = new JLabel("Password:");
	    lblPassword.setFont(new Font("Times New Roman", Font.PLAIN, 14));
	    lblPassword.setBounds(87, 274, 120, 25);
	    frmConexionBd.getContentPane().add(lblPassword);

	    txtPassword = new JPasswordField();
	    txtPassword.setFont(new Font("Times New Roman", Font.PLAIN, 14));
	    txtPassword.setBounds(87, 309, 120, 25);
	    frmConexionBd.getContentPane().add(txtPassword);

	    JLabel lblImagen = new JLabel("");
	    lblImagen.setVisible(false);
	    lblImagen.setBounds(122, 389, 64, 64);
	    frmConexionBd.getContentPane().add(lblImagen);

	    JButton btnConectar = new JButton("Conectar");
	    btnConectar.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            helpers = new CommonHelpers();
	            String baseDatos = txtBaseDatos.getText();
	            String host = txtHost.getText();
	            String puerto = txtPuerto.getText();
	            String usuario = txtUsuario.getText();
	            String password = new String(txtPassword.getPassword());

	            bd.setBaseDatos(baseDatos);

	            if (!host.equalsIgnoreCase("")) {
	                bd.setHost(host);
	            }
	            if (!puerto.equalsIgnoreCase("")) {
	                bd.setPuerto(puerto);
	            }

	            bd.setUsuario(usuario);
	            bd.setPassword(password);
	            try (Connection conexion = bd.generarConexion()) {
	               
	                lblImagen.setVisible(true);
	                lblImagen.setIcon(new ImageIcon(MainConexionInterfaz.class.getResource("/images/pulgar-arriba-64.png")));
	            } catch (SQLException sqlE) {
	                lblImagen.setVisible(true);
	                lblImagen.setIcon(new ImageIcon(MainConexionInterfaz.class.getResource("/images/pulgar-hacia-abajo-64.png")));
	                helpers.mostrarMensaje(frmConexionBd, sqlE.getMessage(), "error");
	            } catch (Exception eX) {
	                lblImagen.setVisible(true);
	                lblImagen.setIcon(new ImageIcon(MainConexionInterfaz.class.getResource("/images/pulgar-hacia-abajo-64.png")));
	                helpers.mostrarMensaje(frmConexionBd, eX.getMessage(), "error");
	            }
	        }
	    });
	    btnConectar.setFont(new Font("Times New Roman", Font.PLAIN, 14));
	    btnConectar.setBounds(87, 354, 120, 25);
	    frmConexionBd.getContentPane().add(btnConectar);
	}

}
