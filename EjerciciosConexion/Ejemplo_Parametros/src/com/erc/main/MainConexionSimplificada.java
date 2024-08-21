package com.erc.main;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.erc.helpers.CommonHelpers;
import com.erc.model.ConexionBd;

public class MainConexionSimplificada {

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
					MainConexionSimplificada window = new MainConexionSimplificada();
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
	public MainConexionSimplificada() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		bd= new ConexionBd();
		frmConexionBd = new JFrame();
		frmConexionBd.setTitle("Conexion BD");
		frmConexionBd.setIconImage(Toolkit.getDefaultToolkit().getImage(MainConexionSimplificada.class.getResource("/images/base-de-datos-64.png")));
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
		
		txtHost = new JTextField();
		txtHost.setColumns(10);
		txtHost.setBounds(87, 107, 120, 25);
		frmConexionBd.getContentPane().add(txtHost);
		
		JLabel lblPuerto = new JLabel("Puerto:\r\n");
		lblPuerto.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblPuerto.setBounds(87, 142, 120, 25);
		frmConexionBd.getContentPane().add(lblPuerto);
		
		txtPuerto = new JTextField();
		txtPuerto.setColumns(10);
		txtPuerto.setBounds(87, 173, 120, 25);
		frmConexionBd.getContentPane().add(txtPuerto);
		
		txtUsuario = new JTextField();
		txtUsuario.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				//añadido Pablo/Angelly/Fran
				//muestra el contenido de los campos no cubiertos
				String host=txtHost.getText();
				String puerto=txtPuerto.getText();
				if(host.equalsIgnoreCase("")) {
					txtHost.setText(bd.getHost());
				}
				if(puerto.equalsIgnoreCase("")) {
					txtPuerto.setText(bd.getPuerto());
				}
			}
		});
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(87, 239, 120, 25);
		frmConexionBd.getContentPane().add(txtUsuario);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblUsuario.setBounds(87, 208, 120, 25);
		frmConexionBd.getContentPane().add(lblUsuario);
		
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
				// inicialiados helpers y conexion a bd
				helpers= new CommonHelpers();
				//bd= new ConexionBd();
				//capturar los valores del interfaz
				String baseDatos=txtBaseDatos.getText();
				String host=txtHost.getText();
				String puerto=txtPuerto.getText();
				String usuario=txtUsuario.getText();
				String password=
						new String(txtPassword.getPassword());
				// le paso los valores al modelo
				bd.setBaseDatos(baseDatos);
				//comprobar si el host es dsitinto de vacio
				// para usar o no el valor por defecto
				if(!host.equalsIgnoreCase("")) {
					bd.setHost(host);
				}
				if(!puerto.equalsIgnoreCase("")) {
					bd.setPuerto(puerto);
				}
				
				bd.setUsuario(usuario);
				bd.setPassword(password);
				/*String url = 	"jdbc:mysql://"
						+bd.getHost()+":"
						+bd.getPuerto()+
						"/"+bd.getBaseDatos()
						+bd.PARADIC; sin método generarConexion*/
				try(Connection c=bd.generarConexion()
					// Connection c= DiverManager.getConnection(url,bd.getUsuario()
						//,bd.getPassword()) sin metodo generar conexion	
						) {
					
					
					lblImagen.setVisible(true);
					lblImagen.setIcon(new ImageIcon
							(MainConexionSimplificada.class.getResource
									("/images/pulgar-arriba-64.png")));
				}catch(SQLException sqlE) {
					lblImagen.setVisible(true);
					lblImagen.setIcon(new ImageIcon
							(MainConexionSimplificada.class.getResource
									("/images/pulgar-hacia-abajo-64.png")));
					helpers.mostrarMensaje(frmConexionBd,sqlE.getMessage(), "error");
				}catch(Exception eX) {
					lblImagen.setVisible(true);
					lblImagen.setIcon(new ImageIcon
							(MainConexionSimplificada.class.getResource
									("/images/pulgar-hacia-abajo-64.png")));
					helpers.mostrarMensaje(frmConexionBd,eX.getMessage(), "error");
				}
				
			}
		});
		btnConectar.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnConectar.setBounds(87, 354, 120, 25);
		frmConexionBd.getContentPane().add(btnConectar);
		
	}

}
