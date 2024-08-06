package com.erc.main;



import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JCheckBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainSanyo {

    private JFrame frame;
    private JTextArea textAreaIzquierda;
    private JTextArea textAreaDerecha;
    private JCheckBox chckbDer;
    private JCheckBox chckbIzq;
    private JButton btnMostrar;
    private JLabel lblMarca;
    private ImageIcon imagenMarca;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainSanyo window = new MainSanyo();
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
    public MainSanyo() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        String textoInicial = "Introduzca su texto por favor. Lorem Ipsum es simplemente el texto de relleno de las imprentas y archivos de texto.";
        frame = new JFrame();
        frame.getContentPane().setBackground(new Color(231, 132, 48));
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        textAreaIzquierda = new JTextArea(textoInicial);
        textAreaIzquierda.setEditable(false);
        textAreaIzquierda.setFont(new Font("Comic Sans MS", Font.PLAIN, 10));
        textAreaIzquierda.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                String textoIntroducido = textAreaIzquierda.getText();
                if (textoIntroducido.equalsIgnoreCase(textoInicial) || textoIntroducido.equalsIgnoreCase(textAreaIzquierda.getText())) {
                    textAreaIzquierda.setText("");
                    textAreaIzquierda.setForeground(Color.black);
                    textAreaDerecha.setText("");
                }
            }
        });
        textAreaIzquierda.setLineWrap(true);
        textAreaIzquierda.setBounds(28, 39, 95, 129);
        textAreaIzquierda.setToolTipText("Seleccione el boton de Pasar a la derecha");
        frame.getContentPane().add(textAreaIzquierda);

        textAreaDerecha = new JTextArea();
        textAreaDerecha.addFocusListener(new FocusAdapter() {
        	@Override
        	public void focusGained(FocusEvent e) {
        		String textoIntroducido = textAreaDerecha.getText();
                if (textoIntroducido.equalsIgnoreCase(textoInicial) || textoIntroducido.equalsIgnoreCase(textAreaDerecha.getText())) {
                    textAreaDerecha.setText("");
                    textAreaDerecha.setForeground(Color.black);
                    textAreaIzquierda.setText("");
                }
        	}
        });
        textAreaDerecha.setFont(new Font("MingLiU_HKSCS-ExtB", Font.BOLD | Font.ITALIC, 13));
        textAreaDerecha.setEditable(false);
        textAreaDerecha.setLineWrap(true);
        textAreaDerecha.setBounds(307, 39, 95, 129);
        textAreaDerecha.setToolTipText("Seleccione el boton de Pasar a la Izquierda");
        frame.getContentPane().add(textAreaDerecha);

        chckbDer = new JCheckBox("Pasar Derecha");
        chckbDer.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
        chckbDer.addItemListener(new ItemListener() { 
        	public void itemStateChanged(ItemEvent e) {
        		 if (chckbDer.isSelected()) {
                     btnMostrar.setEnabled(true);
                     chckbIzq.setSelected(false);
                     textAreaIzquierda.setEditable(true);
                     
                 } else {
                     btnMostrar.setEnabled(chckbIzq.isSelected());
                     textAreaDerecha.setEditable(false);
                 }
             }
        	
        });

        chckbDer.setBounds(162, 53, 124, 23);
        frame.getContentPane().add(chckbDer);

        chckbIzq = new JCheckBox("Pasar Izquierda");
        chckbIzq.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
        chckbIzq.addItemListener(new ItemListener() {
        	public void itemStateChanged(ItemEvent e) {
        		if (chckbIzq.isSelected()) {
                    chckbDer.setSelected(false);
                    btnMostrar.setEnabled(true);
                    textAreaDerecha.setEditable(true);
                } else {
                    btnMostrar.setEnabled(chckbDer.isSelected());
                    textAreaIzquierda.setEditable(false);
                }
        		
        	}
        });
        chckbIzq.setBounds(162, 100, 124, 23);
        frame.getContentPane().add(chckbIzq);
       
        btnMostrar = new JButton("<<<     >>>");
        btnMostrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (chckbDer.isSelected()) {
                    String textoIntroducido = textAreaIzquierda.getText();
                    if (!textoIntroducido.equalsIgnoreCase(textoInicial) && !textoIntroducido.isEmpty()) {
                        textAreaDerecha.setText(textoIntroducido);                       
                        textAreaIzquierda.setText(textoInicial);
                        textAreaIzquierda.setForeground(Color.gray);
                    } else {
                        JOptionPane.showMessageDialog(frame, "No hay texto para mover a la derecha", "Información", JOptionPane.WARNING_MESSAGE);
                    }
                } else if (chckbIzq.isSelected()) {
                    String textoIntroducido = textAreaDerecha.getText();
                    if (!textoIntroducido.equalsIgnoreCase(textoInicial) && !textoIntroducido.isEmpty()) {
                        textAreaIzquierda.setText(textoIntroducido);
                        textAreaDerecha.setText(textoInicial);
                        textAreaDerecha.setForeground(Color.gray);
                    } else {
                        JOptionPane.showMessageDialog(frame, "No hay texto para mover a la izquierda", "Información", JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        });
        btnMostrar.setEnabled(false);
        btnMostrar.setBounds(167, 145, 103, 23);
        btnMostrar.setToolTipText("Selecione el boto para su Instrucion");
        frame.getContentPane().add(btnMostrar);

        lblMarca = new JLabel("SANYO");
        lblMarca.setBackground(new Color(255, 0, 0));
        lblMarca.setOpaque(true);
        lblMarca.setForeground(new Color(255, 0, 0));
        lblMarca.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        lblMarca.setBounds(122, 191, 184, 59);
        frame.getContentPane().add(lblMarca);
        
        imagenMarca= new ImageIcon("D:\\IFCD0111\\Eclipse-Java\\Interface\\resources\\sanyo.png");
        imagenMarca = new ImageIcon(imagenMarca.getImage().getScaledInstance(lblMarca.getWidth(), 
        		                                                             lblMarca.getHeight(),
        		                                                             Image.SCALE_SMOOTH));
       
        
        lblMarca.setIcon(imagenMarca);
    }
}
