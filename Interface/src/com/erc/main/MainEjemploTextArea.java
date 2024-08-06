package com.erc.main;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainEjemploTextArea {

	private JFrame frame;
	private JTextArea txtAreaIzq;
	private JTextArea txtAreaDer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainEjemploTextArea window = new MainEjemploTextArea();
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
	public MainEjemploTextArea() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		String textoInicial="Introduzca aqui su texto";
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnCambiar = new JButton(">>>>>");
		btnCambiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String textoIntroducido=txtAreaIzq.getText();
				if(!textoIntroducido.equalsIgnoreCase(textoInicial)) {
				txtAreaDer.setText(textoIntroducido);
				}
				else {
					
					 JOptionPane.showMessageDialog(frame, 
							 "Por favor introduzca texto", 
							 "Aviso", JOptionPane.WARNING_MESSAGE);
					
				}
				
			}
		});
		btnCambiar.setBounds(172, 117, 85, 21);
		frame.getContentPane().add(btnCambiar);
		
		txtAreaIzq = new JTextArea(textoInicial);
		txtAreaIzq.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				// tomo el valor del campo texta area izquierdo
				String textoIntroducido=txtAreaIzq.getText();
				// compruebo si el valor coincide con el por dfecto
				if(textoIntroducido.equalsIgnoreCase(textoInicial)||
						textoIntroducido.equalsIgnoreCase(txtAreaIzq.getText())) {
					// borro y cambio el color de la letra
					txtAreaIzq.setText("");
					txtAreaIzq.setForeground(Color.black);
					txtAreaDer.setText("");
				}
				
			}
		});
		txtAreaIzq.setLineWrap(true);
		txtAreaIzq.setForeground(Color.GRAY);
		txtAreaIzq.setBounds(10, 33, 152, 193);
		frame.getContentPane().add(txtAreaIzq);
		
		txtAreaDer = new JTextArea();
		txtAreaDer.setEditable(false);
		txtAreaDer.setLineWrap(true);
		txtAreaDer.setBounds(275, 33, 152, 193);
		frame.getContentPane().add(txtAreaDer);
		
		// es el codigo para indicar que un elmento tiene el focus inicial
		
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				btnCambiar.requestFocusInWindow();
			}
		});
		
	}
}
