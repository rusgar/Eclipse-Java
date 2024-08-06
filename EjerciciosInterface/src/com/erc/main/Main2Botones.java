package com.erc.main;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main2Botones {

	private JFrame frame;
	private JTextField txtIntroducir;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main2Botones window = new Main2Botones();
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
	public Main2Botones() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		String textoPantalla="Escriba frase a mostrar";

		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		// cuidado con el orde de lso elementos
		
		JLabel lblPantalla = new JLabel();
		lblPantalla.setHorizontalAlignment(SwingConstants.CENTER);
		lblPantalla.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblPantalla.setBounds(121, 40, 200, 25);
		lblPantalla.setText(textoPantalla);
		frame.getContentPane().add(lblPantalla);
		
		txtIntroducir = new JTextField();
		txtIntroducir.setBounds(121, 87, 200, 50);
		txtIntroducir.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		frame.getContentPane().add(txtIntroducir);
		txtIntroducir.setColumns(10);
		
		JButton btnImprimir = new JButton("PRINT");
		btnImprimir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// acciones que auiera realizar
				String textoIntroducido=txtIntroducir.getText();// guarda en la variable 
				//el contenido del campo Jtextfield
				// compruba si han introducido alguna cadena para hacer cambios
				if(!textoIntroducido.equalsIgnoreCase("")&& !textoIntroducido.equalsIgnoreCase(" ")) {
				// mostramos la cadena en la Jlabel
				lblPantalla.setText(textoIntroducido);
				// voy a cambiar el color de la letras de la label
				lblPantalla.setForeground(Color.BLUE);
				// voy a cambiar el fondo de la label
				lblPantalla.setOpaque(true);
				lblPantalla.setBackground(Color.white);
				//borro el campos Jtextfield de la que lo imprimo en la pantalla
				txtIntroducir.setText("");
				}
			}
		});
		btnImprimir.setBounds(121, 167, 90, 45);
		btnImprimir.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		frame.getContentPane().add(btnImprimir);
		
		JButton btnBorrar = new JButton();
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// aqui van las acciones a realizar
				//el contenido del campo Jtextfield
				// mostramos la cadena en la Jlabel
				lblPantalla.setText(textoPantalla);
				// voy a cambiar el color de la letras de la label
				lblPantalla.setForeground(Color.BLACK);
				// voy a cambiar el fondo de la label
				lblPantalla.setOpaque(false);
				//borro el campos Jtextfield de la que lo imprimo en la pantalla
				txtIntroducir.setText("");
				
			}
		});
		btnBorrar.setText("DEL");
		btnBorrar.setBounds(231, 167, 90, 45);
		btnBorrar.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		frame.getContentPane().add(btnBorrar);
	}

}
