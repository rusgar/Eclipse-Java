package com.erc.main;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JLabel;
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
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JComboBox<String> cbxFuente, cbxTamaño, cbxTipo;
	private JLabel lblFuente, lblTamaño, lblTipo, lblColor, lblMostrar;
	private JRadioButton rdbtnRojo, rdbtnVerde, rdbtnAmarillo, rdbtnPurple;
	private String seleccionFuente, seleccionTipo,seleccionTamaño;	
	private JButton btnReset, btnValidar;
	private JTextArea textArea;
	private Color colorSeleccionado = Color.BLACK;
	private int Tamaño, Fuente;
	private Font fuentePredeterminada;

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
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);




		cbxFuente = new JComboBox();
		cbxFuente.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				seleccionFuente = cbxFuente.getSelectedItem().toString();
			}
		});
		cbxFuente.setModel(new DefaultComboBoxModel(new String[] {"", "Calibri", "Comic Sans MS", "Euclid Franktur", "MV Boli", "Proxy 1"}));
		cbxFuente.setFont(new Font("Comic Sans MS", Font.PLAIN, 10));
		cbxFuente.setBounds(20, 52, 77, 22);
		frame.getContentPane().add(cbxFuente);

		cbxTamaño = new JComboBox();
		cbxTamaño.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				seleccionTamaño = cbxTamaño.getSelectedItem().toString();
			}
		});
		cbxTamaño.setModel(new DefaultComboBoxModel(new String[] {"", "6", "8", "10", "12", "20"}));
		cbxTamaño.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		cbxTamaño.setBounds(20, 129, 77, 22);
		frame.getContentPane().add(cbxTamaño);



		cbxTipo = new JComboBox();
		cbxTipo.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				 seleccionTipo = cbxTipo.getSelectedItem().toString();
			}
		});
		cbxTipo.setModel(new DefaultComboBoxModel(new String[] {"", "Italic", "Bold", "Plain", "Bold Italic"}));
		cbxTipo.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		cbxTipo.setBounds(20, 214, 77, 22);
		frame.getContentPane().add(cbxTipo);




		lblFuente = new JLabel("Escoja Fuente");
		lblFuente.setBackground(new Color(0, 198, 232));
		lblFuente.setFont(new Font("MV Boli", Font.PLAIN, 14));
		lblFuente.setBounds(20, 27, 98, 14);
		frame.getContentPane().add(lblFuente);

		lblTamaño = new JLabel("Escoja Tamaño");
		lblTamaño.setBackground(new Color(0, 198, 232));
		lblTamaño.setFont(new Font("MV Boli", Font.PLAIN, 14));
		lblTamaño.setBounds(20, 104, 98, 14);
		frame.getContentPane().add(lblTamaño);

		lblTipo = new JLabel("Escoja Tipo");
		lblTipo.setBackground(new Color(0, 198, 232));
		lblTipo.setFont(new Font("MV Boli", Font.PLAIN, 14));
		lblTipo.setBounds(20, 189, 98, 14);
		frame.getContentPane().add(lblTipo);

		lblColor = new JLabel("Color Letra");
		lblColor.setFont(new Font("MV Boli", Font.PLAIN, 14));
		lblColor.setBounds(278, 27, 102, 14);
		frame.getContentPane().add(lblColor);

		rdbtnRojo = new JRadioButton("Rojo");
		rdbtnRojo.setBackground(Color.RED);
		buttonGroup.add(rdbtnRojo);
		rdbtnRojo.setFont(new Font("MV Boli", Font.PLAIN, 14));
		rdbtnRojo.setBounds(278, 50, 109, 23);
		frame.getContentPane().add(rdbtnRojo);

		rdbtnVerde = new JRadioButton("Verde");
		rdbtnVerde.setBackground(Color.GREEN);
		buttonGroup.add(rdbtnVerde);
		rdbtnVerde.setFont(new Font("MV Boli", Font.PLAIN, 14));
		rdbtnVerde.setBounds(278, 85, 109, 23);
		frame.getContentPane().add(rdbtnVerde);

		rdbtnAmarillo = new JRadioButton("Amarillo");
		rdbtnAmarillo.setBackground(Color.YELLOW);
		buttonGroup.add(rdbtnAmarillo);
		rdbtnAmarillo.setFont(new Font("MV Boli", Font.PLAIN, 14));
		rdbtnAmarillo.setBounds(278, 120, 109, 23);
		frame.getContentPane().add(rdbtnAmarillo);

		rdbtnPurple = new JRadioButton("Purple");
		rdbtnPurple.setBackground(new Color(128, 0, 255));
		buttonGroup.add(rdbtnPurple);
		rdbtnPurple.setFont(new Font("MV Boli", Font.PLAIN, 14));
		rdbtnPurple.setBounds(278, 150, 109, 23);
		frame.getContentPane().add(rdbtnPurple);

		textArea = new JTextArea();
		textArea.setFont(new Font("Comic Sans MS", Font.PLAIN, 10));
		textArea.setBounds(155, 51, 98, 124);
		frame.getContentPane().add(textArea);

		btnReset = new JButton("X");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cbxFuente.setSelectedIndex(0);
				cbxTamaño.setSelectedIndex(0);
				cbxTipo.setSelectedIndex(0);
				seleccionFuente = "";
				seleccionTamaño = "";
				seleccionTipo ="";				
				buttonGroup.clearSelection();
				fuentePredeterminada = new Font("Comic Sans MS", Font.PLAIN, 10);
		        textArea.setFont(fuentePredeterminada);
				colorSeleccionado = Color.BLACK;				
				textArea.setForeground(colorSeleccionado);
				textArea.setText("");
			}
		});
		btnReset.setBounds(220, 214, 89, 23);
		frame.getContentPane().add(btnReset);

		btnValidar = new JButton(" ✔");
		btnValidar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tamaño= 8;
				if (!seleccionTamaño.isEmpty()) {
				    Tamaño = Integer.parseInt(seleccionTamaño);
				} else {
				    Tamaño = 10;
				}
				
				Fuente = Font.PLAIN;
				if (cbxTipo.getSelectedItem().toString().equals("Italic")) {
					Fuente = Font.ITALIC;
				} else if (cbxTipo.getSelectedItem().toString().equals("Bold")) {
					Fuente = Font.BOLD;
				} else if (cbxTipo.getSelectedItem().toString().equals("Bold Italic")) {
					Fuente = Font.BOLD + Font.ITALIC;
				}
				Font font = new Font(seleccionTipo, Fuente, Tamaño);
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
		btnValidar.setBounds(320, 214, 89, 23);
		frame.getContentPane().add(btnValidar);

		lblMostrar = new JLabel("MOSTRAR");
		lblMostrar.setFont(new Font("MV Boli", Font.PLAIN, 14));
		lblMostrar.setBounds(165, 27, 88, 14);
		frame.getContentPane().add(lblMostrar);
	}
}
