package com.erc.main;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ButtonGroup;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainMenuEscogerLetra {

	private JFrame frame;
	private final ButtonGroup rdbtnGruposColores = new ButtonGroup();
	private JComboBox<String> cbxFuente, cbxTamaño, cbxTipo;
	private JLabel lblFuente, lblTamaño, lblTipo, lblColor, lblMostrar;
	private JRadioButton rdbtnRojo, rdbtnVerde, rdbtnAmarillo, rdbtnPurple;
	private String seleccionFuente, seleccionTipo,seleccionTamaño;	
	private JButton btnReset, btnValidar;
	private JTextArea textArea;
	private Color colorSeleccionado = Color.BLACK;
	private int Tamaño, Tipo;
	private Font fuentePredeterminada;
	private boolean isSelectedColor() {
	    return rdbtnRojo.isSelected() || rdbtnVerde.isSelected() || rdbtnAmarillo.isSelected() || rdbtnPurple.isSelected();
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenuEscogerLetra window = new MainMenuEscogerLetra();
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
	public MainMenuEscogerLetra() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(128, 255, 255));
		frame.setBounds(100, 100, 577, 380);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);



        // COMBO DE SELECCION DE FUENTE
		cbxFuente = new JComboBox();
		cbxFuente.setForeground(new Color(255, 255, 255));
		cbxFuente.setBackground(new Color(201, 148, 148));
		cbxFuente.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				seleccionFuente = cbxFuente.getSelectedItem().toString();
			}
		});
		// REALIZAMOS UN ARRAY DE 5 ELEMENTOS QUE PREVIAMENTE LOS METEMOS EN EL DESIGN
		cbxFuente.setModel(new DefaultComboBoxModel(new String[] {"", "Calibri", "Comic Sans MS", "Euclid Franktur", "MV Boli", "Proxy 1"})); 
		cbxFuente.setFont(new Font("Comic Sans MS", Font.PLAIN, 10));
		cbxFuente.setBounds(20, 52, 98, 22);
		frame.getContentPane().add(cbxFuente);
		
		
		// COMBO DE SELECCION DE TAMAÑO
		cbxTamaño = new JComboBox();
		cbxTamaño.setForeground(new Color(255, 255, 255));
		cbxTamaño.setBackground(new Color(201, 148, 148));
		cbxTamaño.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				seleccionTamaño = cbxTamaño.getSelectedItem().toString();
			}
		});
		// REALIZAMOS UN ARRAY DE 5 ELEMENTOS QUE PREVIAMENTE LOS METEMOS EN EL DESIGN
		cbxTamaño.setModel(new DefaultComboBoxModel(new String[] {"", "10", "14", "20", "34", "50"}));
		cbxTamaño.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		cbxTamaño.setBounds(20, 129, 98, 22);
		frame.getContentPane().add(cbxTamaño);


		// COMBO DE SELECCION DE TIPO
		cbxTipo = new JComboBox();
		cbxTipo.setForeground(new Color(255, 255, 255));
		cbxTipo.setBackground(new Color(201, 148, 148));
		cbxTipo.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				 seleccionTipo = cbxTipo.getSelectedItem().toString();
			}
		});
		// REALIZAMOS UN ARRAY DE 4 ELEMENTOS QUE PREVIAMENTE LOS METEMOS EN EL DESIGN
		cbxTipo.setModel(new DefaultComboBoxModel(new String[] {"", "Cursiva", "Negrita", "Plano", "Negrita Cursiva"}));
		cbxTipo.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		cbxTipo.setBounds(20, 215, 98, 22);
		frame.getContentPane().add(cbxTipo);



        // ETIQUETA FIJA DONDE PONE ENCIMA ESCOJAFUENTE
		lblFuente = new JLabel("Escoja Fuente");
		lblFuente.setBackground(new Color(0, 198, 232));
		lblFuente.setFont(new Font("MV Boli", Font.PLAIN, 14));
		lblFuente.setBounds(20, 27, 98, 14);
		frame.getContentPane().add(lblFuente);
		
		// ETIQUETA FIJA DONDE PONE ENCIMA ESCOJA TAMAÑO
		lblTamaño = new JLabel("Escoja Tamaño");
		lblTamaño.setBackground(new Color(0, 198, 232));
		lblTamaño.setFont(new Font("MV Boli", Font.PLAIN, 14));
		lblTamaño.setBounds(20, 104, 98, 14);
		frame.getContentPane().add(lblTamaño);
		
		// ETIQUETA FIJA DONDE PONE ENCIMA ESCOJA TIPO
		lblTipo = new JLabel("Escoja Tipo");
		lblTipo.setBackground(new Color(0, 198, 232));
		lblTipo.setFont(new Font("MV Boli", Font.PLAIN, 14));
		lblTipo.setBounds(20, 189, 98, 14);
		frame.getContentPane().add(lblTipo);
		

		// ETIQUETA FIJA DONDE PONE ENCIMA ESCOJA COLOR DE LA LETRA
		lblColor = new JLabel("Color Letra");
		lblColor.setFont(new Font("MV Boli", Font.PLAIN, 14));
		lblColor.setBounds(402, 27, 102, 14);
		frame.getContentPane().add(lblColor);
		
		
        // REALIZAMOS LOS COLORES DE CADA RADIOBUTTON
		rdbtnRojo = new JRadioButton("Rojo");
		rdbtnRojo.setBackground(Color.RED);
		rdbtnGruposColores.add(rdbtnRojo);
		rdbtnRojo.setFont(new Font("MV Boli", Font.PLAIN, 14));
		rdbtnRojo.setBounds(395, 52, 109, 23);
		frame.getContentPane().add(rdbtnRojo);

		rdbtnVerde = new JRadioButton("Verde");
		rdbtnVerde.setBackground(Color.GREEN);
		rdbtnGruposColores.add(rdbtnVerde);
		rdbtnVerde.setFont(new Font("MV Boli", Font.PLAIN, 14));
		rdbtnVerde.setBounds(395, 105, 109, 23);
		frame.getContentPane().add(rdbtnVerde);

		rdbtnAmarillo = new JRadioButton("Amarillo");
		rdbtnAmarillo.setBackground(Color.YELLOW);
		rdbtnGruposColores.add(rdbtnAmarillo);
		rdbtnAmarillo.setFont(new Font("MV Boli", Font.PLAIN, 14));
		rdbtnAmarillo.setBounds(395, 162, 109, 23);
		frame.getContentPane().add(rdbtnAmarillo);

		rdbtnPurple = new JRadioButton("Purple");
		rdbtnPurple.setBackground(new Color(128, 0, 255));
		rdbtnGruposColores.add(rdbtnPurple);
		rdbtnPurple.setFont(new Font("MV Boli", Font.PLAIN, 14));
		rdbtnPurple.setBounds(395, 215, 109, 23);
		frame.getContentPane().add(rdbtnPurple);
		
		
        // REALIZAMOS UN AREA DONDE ESCRIBIREMOS EL TEXTO
		textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setFont(new Font("Comic Sans MS", Font.PLAIN, 10));
		textArea.setBounds(173, 52, 168, 184);
		frame.getContentPane().add(textArea);
		
		
        // BOTON DE RESET DONDE METEREMOS LA SELECION DE FUENTE, TAMAÑO,TIPO Y QUE VUELVA A SU ESTADO INICIAL CUNADO LE DAMOS
		btnReset = new JButton("X");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cbxFuente.setSelectedIndex(0);
				cbxTamaño.setSelectedIndex(0);
				cbxTipo.setSelectedIndex(0);
				seleccionFuente = "";
				seleccionTamaño = "";
				seleccionTipo ="";				
				rdbtnGruposColores.clearSelection();
				fuentePredeterminada = new Font("Comic Sans MS", Font.PLAIN, 10);
		        textArea.setFont(fuentePredeterminada);
				colorSeleccionado = Color.BLACK;				
				textArea.setForeground(colorSeleccionado);
				textArea.setText("");
			}
		});
		btnReset.setBounds(292, 294, 89, 23);
		frame.getContentPane().add(btnReset);

		btnValidar = new JButton(" ✔");
		btnValidar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cbxFuente.getSelectedIndex() == 0 ||
					cbxTamaño.getSelectedIndex() == 0 || 
					cbxTipo.getSelectedIndex() == 0 || 
					!isSelectedColor())
				    {
					JOptionPane.showMessageDialog(frame, "Por favor para continuar, seleccione todos los campos", "Advertencia", JOptionPane.WARNING_MESSAGE);
				return;
				}				
				
				Tamaño = Integer.parseInt(seleccionTamaño);
			
				
				Tipo = Font.PLAIN;
				if (cbxTipo.getSelectedItem().toString().equals("Cursiva")) {
					Tipo= Font.ITALIC;
				} else if (cbxTipo.getSelectedItem().toString().equals("Negrita")) {
					Tipo = Font.BOLD;
				} else if (cbxTipo.getSelectedItem().toString().equals("Negrita Cursiva")) {
					Tipo = Font.BOLD + Font.ITALIC;
				}
				Font font = new Font(seleccionFuente, Tipo, Tamaño);
				textArea.setFont(font);

				
				if (rdbtnRojo.isSelected()) {
					colorSeleccionado = Color.RED;
				} else if (rdbtnVerde.isSelected()) {
					colorSeleccionado = Color.GREEN;
				} else if (rdbtnAmarillo.isSelected()) {
					colorSeleccionado = Color.YELLOW;
				} else if (rdbtnPurple.isSelected()) {
					colorSeleccionado = new Color(128, 0, 255); 
				}



				textArea.setForeground(colorSeleccionado);
			}
		});
		
		btnValidar.setBounds(415, 294, 89, 23);
		frame.getContentPane().add(btnValidar);

		lblMostrar = new JLabel("MOSTRAR");
		lblMostrar.setFont(new Font("MV Boli", Font.PLAIN, 14));
		lblMostrar.setBounds(214, 27, 88, 14);
		frame.getContentPane().add(lblMostrar);
	}
}