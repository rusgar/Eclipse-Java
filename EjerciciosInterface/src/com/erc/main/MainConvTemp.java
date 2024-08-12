package com.erc.main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ButtonGroup;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class MainConvTemp {

	private JFrame frame;
	private JTextField txtValorEntrada;
	private JTextField txtValorSalida;
	private JComboBox cbxEscalaTempS;
	private JRadioButton rdbtnCelsius;
	private JRadioButton rdbtnFahrenheit;
	private JRadioButton rdbtnKelvin;
	private final ButtonGroup rdbtngEscalaTempEntrada = new ButtonGroup();
	private JButton btnBorrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainConvTemp window = new MainConvTemp();
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
	public MainConvTemp() {
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
		
		txtValorEntrada = new JTextField();
		txtValorEntrada.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				char tecla = e.getKeyChar();
				int teclaFuncion = e.getKeyCode();
				if(!Character.isDigit(tecla) && tecla!='.' && teclaFuncion != KeyEvent.VK_BACK_SPACE) {
					e.consume();
				}else if(txtValorEntrada.getText().equalsIgnoreCase("")) {
					txtValorSalida.setText("");
				} else if(rdbtnCelsius.isSelected() || rdbtnFahrenheit.isSelected() || rdbtnKelvin.isSelected()) {
					convertirTemperatura();
				}
			}
		});
		txtValorEntrada.setBounds(50, 56, 136, 20);
		frame.getContentPane().add(txtValorEntrada);
		txtValorEntrada.setColumns(10);
		
		rdbtnCelsius = new JRadioButton("Celsius");
		rdbtnCelsius.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				convertirTemperatura();
			}
		});
		rdbtngEscalaTempEntrada.add(rdbtnCelsius);
		rdbtnCelsius.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		rdbtnCelsius.setBounds(255, 38, 109, 23);
		frame.getContentPane().add(rdbtnCelsius);
		
		JLabel lblEntrada = new JLabel("Entrada:");
		lblEntrada.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblEntrada.setBounds(50, 31, 71, 14);
		frame.getContentPane().add(lblEntrada);
		
		rdbtnFahrenheit = new JRadioButton("Fahrenheit");
		rdbtnFahrenheit.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				convertirTemperatura();
			}
		});
		rdbtngEscalaTempEntrada.add(rdbtnFahrenheit);
		rdbtnFahrenheit.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		rdbtnFahrenheit.setBounds(255, 64, 109, 23);
		frame.getContentPane().add(rdbtnFahrenheit);
		
		rdbtnKelvin = new JRadioButton("Kelvin");
		rdbtnKelvin.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				convertirTemperatura();
			}
		});
		rdbtngEscalaTempEntrada.add(rdbtnKelvin);
		rdbtnKelvin.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		rdbtnKelvin.setBounds(255, 90, 109, 23);
		frame.getContentPane().add(rdbtnKelvin);
		
		JLabel lblEscalasTempE = new JLabel("Escala de temperatura:");
		lblEscalasTempE.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblEscalasTempE.setBounds(255, 17, 126, 14);
		frame.getContentPane().add(lblEscalasTempE);
		
		JLabel lblSalida = new JLabel("Salida:");
		lblSalida.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblSalida.setBounds(50, 141, 71, 14);
		frame.getContentPane().add(lblSalida);
		
		txtValorSalida = new JTextField();
		txtValorSalida.setEditable(false);
		txtValorSalida.setColumns(10);
		txtValorSalida.setBounds(50, 166, 136, 20);
		frame.getContentPane().add(txtValorSalida);
		
		JLabel lblEscalasTempS = new JLabel("Escala de temperatura:");
		lblEscalasTempS.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblEscalasTempS.setBounds(255, 141, 126, 14);
		frame.getContentPane().add(lblEscalasTempS);
		
		cbxEscalaTempS = new JComboBox();
		cbxEscalaTempS.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (!txtValorEntrada.getText().equalsIgnoreCase("") && 
						(rdbtnCelsius.isSelected() || rdbtnFahrenheit.isSelected() || rdbtnKelvin.isSelected())){
				convertirTemperatura();
				}
			}
		});
		cbxEscalaTempS.setModel(new DefaultComboBoxModel(new String[] {"Celsius", "Fahrenheit", "Kelvin"}));
		cbxEscalaTempS.setBounds(255, 165, 109, 22);
		frame.getContentPane().add(cbxEscalaTempS);
		
		btnBorrar = new JButton();
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtValorEntrada.setText("");
				txtValorSalida.setText("");
				rdbtngEscalaTempEntrada.clearSelection();
				cbxEscalaTempS.setSelectedItem("Celsius");;
			}
		});
		btnBorrar.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnBorrar.setBounds(182, 197, 50, 50);
		
		
		frame.getContentPane().add(btnBorrar);
	}
	
	
	// metodo para convertir temperatura
	private void convertirTemperatura() {
		try {
			String escalaTempEntrada = "";
			String escalaTempSalida = cbxEscalaTempS.getSelectedItem().toString();	
			double valorEntrada = Double.parseDouble(txtValorEntrada.getText());
			double valorSalida = 0;
			txtValorSalida.setText(String.valueOf(0));
			
			if (rdbtnCelsius.isSelected()) {
				escalaTempEntrada = rdbtnCelsius.getText().toString();
			} else if (rdbtnFahrenheit.isSelected()) {
				escalaTempEntrada = rdbtnFahrenheit.getText().toString();
			} else if (rdbtnKelvin.isSelected()) {
				escalaTempEntrada = rdbtnKelvin.getText().toString();
			}
			
			
			switch (escalaTempEntrada) {
			case "Celsius":{
				switch (escalaTempSalida){
				case "Celsius":
					valorSalida = valorEntrada;
					break;
				case "Fahrenheit":
					valorSalida = (valorEntrada * 9.0 / 5.0) + 32.0;
					break;
				case "Kelvin":
					valorSalida = valorEntrada + 273.15;
					break;
				}
				break;
				}
			case "Fahrenheit":{
				switch (escalaTempSalida){
				case "Celsius":
					valorSalida = (valorEntrada -32.0) * 5.0 / 9.0;
					break;
				case "Fahrenheit":
					valorSalida = valorEntrada ;
					break;
				case "Kelvin":
					valorSalida = (valorEntrada -32.0) * 5.0 / 9.0 + 273.15;
					break;
				}
				break;
				}
			case "Kelvin":{
				switch (escalaTempSalida){
				case "Celsius":
					valorSalida = valorEntrada - 273.15;
					break;
				case "Fahrenheit":
					valorSalida = (valorEntrada - 273.15) * 9.0 / 5.0 + 32.0 ;
					break;
				case "Kelvin":
					valorSalida = valorEntrada;
					break;
				}
				break;
				}
			}
			txtValorSalida.setText(String.valueOf(valorSalida));
        } catch (NumberFormatException ex) {

        }
	}
}
