package com.erc.main;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class mainRadioButtons {

	private JFrame frame;
	private JTextArea txtAreaInicio;
	private JRadioButton rdbtnColorRojoFondo, rdbtnColorAmarilloFondo, rdbtnColorAzulFondo, rdbtnColorVerdeFondo;
	private JButton btnCambiarFondo;
	private JRadioButton rdbtnColorRojoTexto, rdbtnColorAzulTexto, rdbtnColorAmarilloTexto, rdbtnColorVerdeTexto;
	private JButton btnCambiarTexto;
	private final ButtonGroup rdbtngColoresFondo = new ButtonGroup();
	private final ButtonGroup rdbtngColoresTexto = new ButtonGroup();
	private Color selectedColorFondo = Color.WHITE;
	private Color selectedColorTexto = Color.BLACK;
	private JTextArea txtAreaFinal;
	private JLabel lblNombre;
	private JButton btnReset;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainRadioButtons window = new mainRadioButtons();
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
	public mainRadioButtons() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(192, 192, 192));
		frame.setBounds(100, 100, 709, 413);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);



		txtAreaInicio = new JTextArea();
		txtAreaInicio.setLineWrap(true);
		txtAreaInicio.setWrapStyleWord(true);
		txtAreaInicio.setBounds(232, 16, 230, 103);
		frame.getContentPane().add(txtAreaInicio);
		
		
		//CONFIGURAMOS EL COLOR DE FONDO ROJO

		rdbtnColorRojoFondo = new JRadioButton("Rojo");
		rdbtnColorRojoFondo.setBackground(new Color(168, 99, 42));
		rdbtnColorRojoFondo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedColorFondo = Color.RED;

				// NO ACTUALIZA EL TEXT AREA HASTA QUE SE NO SE HAGA CLIC EN EL BOTON DE CAMBIO DE FONDO
			}
		});
		rdbtngColoresFondo.add(rdbtnColorRojoFondo);
		rdbtnColorRojoFondo.setFont(new Font("MV Boli", Font.PLAIN, 15));
		rdbtnColorRojoFondo.setBounds(10, 56, 113, 21);
		frame.getContentPane().add(rdbtnColorRojoFondo);
		
		
		//CONFIGURAMOS EL COLOR DE FONDO AZUL

		rdbtnColorAzulFondo = new JRadioButton("Azul");
		rdbtnColorAzulFondo.setBackground(new Color(168, 99, 42));
		rdbtnColorAzulFondo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedColorFondo = Color.BLUE;
				// NO ACTUALIZA EL TEXT AREA HASTA QUE SE NO SE HAGA CLIC EN EL BOTON DE CAMBIO DE FONDO
			}
		});
		rdbtngColoresFondo.add(rdbtnColorAzulFondo);
		rdbtnColorAzulFondo.setFont(new Font("MV Boli", Font.PLAIN, 15));
		rdbtnColorAzulFondo.setBounds(10, 96, 113, 21);
		frame.getContentPane().add(rdbtnColorAzulFondo);
		
		
		//CONFIGURAMOS EL COLOR DE FONDO AMARILLO

		rdbtnColorAmarilloFondo = new JRadioButton("Amarillo");
		rdbtnColorAmarilloFondo.setBackground(new Color(168, 99, 42));
		rdbtnColorAmarilloFondo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedColorFondo = Color.YELLOW;
				// NO ACTUALIZA EL TEXT AREA HASTA QUE SE NO SE HAGA CLIC EN EL BOTON DE CAMBIO DE FONDO
			}
		});
		rdbtngColoresFondo.add(rdbtnColorAmarilloFondo);
		rdbtnColorAmarilloFondo.setFont(new Font("MV Boli", Font.PLAIN, 15));
		rdbtnColorAmarilloFondo.setBounds(10, 136, 113, 21);
		frame.getContentPane().add(rdbtnColorAmarilloFondo);
		
		//CONFIGURAMOS EL COLOR DE FONDO VERDE

		rdbtnColorVerdeFondo = new JRadioButton("Verde");
		rdbtnColorVerdeFondo.setBackground(new Color(168, 99, 42));
		rdbtnColorVerdeFondo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedColorFondo = Color.GREEN;
				// NO ACTUALIZA EL TEXT AREA HASTA QUE SE NO SE HAGA CLIC EN EL BOTON DE CAMBIO DE FONDO
			}
		});
		rdbtngColoresFondo.add(rdbtnColorVerdeFondo);
		rdbtnColorVerdeFondo.setFont(new Font("MV Boli", Font.PLAIN, 15));
		rdbtnColorVerdeFondo.setBounds(10, 179, 113, 21);
		frame.getContentPane().add(rdbtnColorVerdeFondo);
		
		//CONFIGURAMOS EL BOTON DE FONDO DE CADA UNO DE LOS ANTERIORES

		btnCambiarFondo = new JButton("Cambiar Color Fondo");
		btnCambiarFondo.setBackground(new Color(0, 198, 232));
		btnCambiarFondo.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		btnCambiarFondo.setBounds(10, 11, 190, 35);
		frame.getContentPane().add(btnCambiarFondo);
		btnCambiarFondo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (selectedColorTexto.equals(selectedColorFondo)) {
					JOptionPane.showMessageDialog(frame, "Este color no se puede usar para el fondo porque ya está siendo usado como color de texto.", "Advertencia", JOptionPane.WARNING_MESSAGE);
				} else {
					lblNombre.setOpaque(true);
					lblNombre.setBackground(new Color(255, 128, 0)); 
					lblNombre.setBounds(297, 280, 113, 14);
					txtAreaFinal.setBackground(selectedColorFondo);
					updateFondoLetra();
					 frame.revalidate();
			            frame.repaint();
				}
			}
		});

		
		//CONFIGURAMOS EL COLOR DE TEXTO ROJO
		
		rdbtnColorRojoTexto = new JRadioButton("Rojo");
		rdbtnColorRojoTexto.setBackground(new Color(168, 99, 42));
		rdbtnColorRojoTexto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedColorTexto = Color.RED;
			}
		});
		rdbtngColoresTexto.add(rdbtnColorRojoTexto);
		rdbtnColorRojoTexto.setFont(new Font("MV Boli", Font.PLAIN, 15));
		rdbtnColorRojoTexto.setBounds(493, 56, 103, 21);
		frame.getContentPane().add(rdbtnColorRojoTexto);
		
		
		//CONFIGURAMOS EL COLOR DE TEXTO AZUL

		rdbtnColorAzulTexto = new JRadioButton("Azul");
		rdbtnColorAzulTexto.setBackground(new Color(168, 99, 42));
		rdbtnColorAzulTexto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedColorTexto = Color.BLUE;
			}
		});
		rdbtngColoresTexto.add(rdbtnColorAzulTexto);
		rdbtnColorAzulTexto.setFont(new Font("MV Boli", Font.PLAIN, 15));
		rdbtnColorAzulTexto.setBounds(493, 96, 103, 21);
		frame.getContentPane().add(rdbtnColorAzulTexto);
		
		
		//CONFIGURAMOS EL COLOR DE TEXTO AMARILLO

		rdbtnColorAmarilloTexto = new JRadioButton("Amarillo");
		rdbtnColorAmarilloTexto.setBackground(new Color(168, 99, 42));
		rdbtnColorAmarilloTexto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedColorTexto = Color.YELLOW;
			}
		});
		rdbtngColoresTexto.add(rdbtnColorAmarilloTexto);
		rdbtnColorAmarilloTexto.setFont(new Font("MV Boli", Font.PLAIN, 15));
		rdbtnColorAmarilloTexto.setBounds(493, 136, 103, 21);
		frame.getContentPane().add(rdbtnColorAmarilloTexto);
		
		//CONFIGURAMOS EL COLOR DE TEXTO VERDE

		rdbtnColorVerdeTexto = new JRadioButton("Verde");
		rdbtnColorVerdeTexto.setBackground(new Color(168, 99, 42));
		rdbtnColorVerdeTexto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedColorTexto = Color.GREEN;
			}
		});
		rdbtngColoresTexto.add(rdbtnColorVerdeTexto);
		rdbtnColorVerdeTexto.setFont(new Font("MV Boli", Font.PLAIN, 15));
		rdbtnColorVerdeTexto.setBounds(493, 179, 103, 21);
		frame.getContentPane().add(rdbtnColorVerdeTexto);
		
		//CONFIGURAMOS EL BOTON DE TEXTO O TIPO DE LETRA DE CADA UNO DE LOS ANTERIORES

		btnCambiarTexto = new JButton("Cambiar Color Texto");
		btnCambiarTexto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (selectedColorFondo.equals(selectedColorTexto)) {
					JOptionPane.showMessageDialog(frame, "Este color no se puede usar para el fondo porque ya está siendo usado como color de texto.", "Advertencia", JOptionPane.WARNING_MESSAGE);
				} else {
					lblNombre.setOpaque(true);
					lblNombre.setBackground(new Color(255, 128, 0)); 
					lblNombre.setBounds(297, 280, 113, 14);
					txtAreaFinal.setBackground(selectedColorTexto);
					updateFondoLetra();
					frame.revalidate();
		            frame.repaint();
				}
			}
			
		});
		btnCambiarTexto.setBackground(new Color(0, 198, 232));
		btnCambiarTexto.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		btnCambiarTexto.setBounds(493, 11, 190, 35);
		frame.getContentPane().add(btnCambiarTexto);
		selectedColorFondo = Color.WHITE;
        selectedColorTexto = Color.BLACK;
		

		lblNombre = new JLabel("Resultado Final");
		lblNombre.setFont(new Font("MV Boli", Font.PLAIN, 14));
		lblNombre.setOpaque(true);
		lblNombre.setBackground(new Color(255, 128, 0));
		lblNombre.setBounds(294, 130, 113, 14);
		frame.getContentPane().add(lblNombre);
		
		

		txtAreaFinal = new JTextArea();
		txtAreaFinal.setWrapStyleWord(true);
		txtAreaFinal.setLineWrap(true);
		txtAreaFinal.setBounds(232, 130, 230, 164);
		frame.getContentPane().add(txtAreaFinal);


		updateFondoLetra();
		
		
		btnReset = new JButton("Reset");
		btnReset.setBackground(new Color(128, 255, 255)); 
		btnReset.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		btnReset.setBounds(257, 316, 190, 35);
		frame.getContentPane().add(btnReset);

		btnReset.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	selectedColorFondo = Color.WHITE;
		        selectedColorTexto = Color.BLACK;		       
		        rdbtngColoresFondo.clearSelection();
		        rdbtngColoresTexto.clearSelection();		       
		        txtAreaFinal.setBackground(selectedColorFondo);
		        txtAreaFinal.setForeground(selectedColorTexto);
		        txtAreaFinal.setText("");		     
		        lblNombre.setBackground(new Color(255, 128, 0));
		        lblNombre.setForeground(Color.BLACK);		      
		        
		    }
		});

	}
	
	//METODO PARA ACTUALIZAR Y DESACTIVAR LOS RADIOBUTTON SI ES EL MISMO COLOR Y LOS COMPARA 

	private void updateFondoLetra() {
		txtAreaFinal.setBackground(selectedColorFondo);
		txtAreaFinal.setForeground(selectedColorTexto);
		txtAreaFinal.setText(txtAreaInicio.getText()); 
		


		rdbtnColorRojoTexto.setEnabled(!selectedColorFondo.equals(Color.RED));
		rdbtnColorAzulTexto.setEnabled(!selectedColorFondo.equals(Color.BLUE));
		rdbtnColorAmarilloTexto.setEnabled(!selectedColorFondo.equals(Color.YELLOW));
		rdbtnColorVerdeTexto.setEnabled(!selectedColorFondo.equals(Color.GREEN));

		rdbtnColorRojoFondo.setEnabled(!selectedColorTexto.equals(Color.RED));
		rdbtnColorAzulFondo.setEnabled(!selectedColorTexto.equals(Color.BLUE));
		rdbtnColorAmarilloFondo.setEnabled(!selectedColorTexto.equals(Color.YELLOW));
		rdbtnColorVerdeFondo.setEnabled(!selectedColorTexto.equals(Color.GREEN));
	}
}






