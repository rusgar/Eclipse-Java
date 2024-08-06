package com.erc.main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MainEjemploCamposTextoEditables {

	private JFrame frame;
	// definimos aqui los elmeentos gráficos para que no haya problemas de acceso entre ellos
	private JTextField txtTexto;
	private JLabel lblPantalla;
	private JButton btnCambiar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainEjemploCamposTextoEditables window = new MainEjemploCamposTextoEditables();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainEjemploCamposTextoEditables() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);;
		
		btnCambiar = new JButton("New button");
		btnCambiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String texto= txtTexto.getText();// con esto cojo el contenido
				lblPantalla.setText(texto);// com esto cambio el contenido de la etiqueta
			}
		});
		btnCambiar.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnCambiar.setBounds(154, 197, 150, 25);
		btnCambiar.setText("Cambiar Mensaje");
		frame.getContentPane().add(btnCambiar);
		
		lblPantalla = new JLabel("New label");
		lblPantalla.setBounds(135, 72, 200, 25);
		lblPantalla.setText("Hola introduzca texto a cambiar");
		lblPantalla.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		frame.getContentPane().add(lblPantalla);
		
		txtTexto = new JTextField();
		// evento de tecla pulsada en el teclado
		// controlado desde el campo JtexField
		txtTexto.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				if(e.getKeyCode()== KeyEvent.VK_ENTER) {
					String texto= txtTexto.getText();// con esto cojo el contenido
					lblPantalla.setText(texto);// com esto cambvio el contenido de la etiqueta
				}
				
			}
		});
		txtTexto.setBounds(124, 132, 200, 25);
		txtTexto.setText("");
		txtTexto.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		frame.getContentPane().add(txtTexto);
		txtTexto.setColumns(10);
	}
	
}
