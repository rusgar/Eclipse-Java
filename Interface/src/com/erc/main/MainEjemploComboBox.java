package com.erc.main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.Font;

public class MainEjemploComboBox {

	private JFrame frame;
	private JComboBox cbxLIstaDesplegable;
	private JLabel lblPantalla;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainEjemploComboBox window = new MainEjemploComboBox();
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
	public MainEjemploComboBox() {
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
		
		
		cbxLIstaDesplegable = new JComboBox();
		cbxLIstaDesplegable.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				String seleccionado = cbxLIstaDesplegable.getSelectedItem().toString();
				lblPantalla.setText(seleccionado);
			}
		});
		cbxLIstaDesplegable.setModel(new DefaultComboBoxModel(new String[] {"", "Manzana", "Pera", "Naranja", "Mandarina", "Fresa", "Arandano", "Frambuesa"}));
		cbxLIstaDesplegable.setFont(new Font("MV Boli", Font.PLAIN, 12));
		cbxLIstaDesplegable.setBounds(29, 94, 120, 30);
		frame.getContentPane().add(cbxLIstaDesplegable);
		
		lblPantalla = new JLabel("Esperando");
		lblPantalla.setFont(new Font("MV Boli", Font.PLAIN, 14));
		lblPantalla.setHorizontalAlignment(SwingConstants.CENTER);
		lblPantalla.setBounds(272, 94, 120, 30);
		frame.getContentPane().add(lblPantalla);
	}
}
