package com.erc.main;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import java.awt.Color;

public class MainRadioButton {

    private JFrame frame;
    private JRadioButton rdbtnAzul;
    private JRadioButton rdbtnRojo;
    private JTextArea textAreaInicio;
    private JTextArea textAreaFinal;
    private JButton btnMostrar;
    private Color colorSeleccionado;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainRadioButton window = new MainRadioButton();
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
    public MainRadioButton() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setBackground(new Color(255, 128, 64));
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        colorSeleccionado = Color.white;
        frame.getContentPane().setLayout(null);
        
        rdbtnAzul = new JRadioButton("Azul");
        rdbtnAzul.setBackground(new Color(128, 255, 255));
        rdbtnAzul.setBounds(36, 46, 109, 23);
        frame.getContentPane().add(rdbtnAzul);
        
        rdbtnRojo = new JRadioButton("Rojo");
        rdbtnRojo.setBackground(new Color(255, 0, 0));
        rdbtnRojo.setBounds(36, 98, 109, 23);
        frame.getContentPane().add(rdbtnRojo);
        
       
        ButtonGroup group = new ButtonGroup();
        group.add(rdbtnAzul);
        group.add(rdbtnRojo);
        
        rdbtnAzul.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    colorSeleccionado = new Color(128, 255, 255);
                    textAreaInicio.setBackground(colorSeleccionado);
                }
            }
        });
        
        rdbtnRojo.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    colorSeleccionado = new Color(255, 0, 0);
                    textAreaInicio.setBackground(colorSeleccionado);
                }
            }
        });
        
        textAreaInicio = new JTextArea();
        textAreaInicio.setBounds(179, 45, 81, 126);
        frame.getContentPane().add(textAreaInicio);
        
        textAreaFinal = new JTextArea();
        textAreaFinal.setBounds(321, 46, 81, 126);
        frame.getContentPane().add(textAreaFinal);
        
        btnMostrar = new JButton("Mostrar");
        btnMostrar.setBounds(36, 195, 89, 23);
        btnMostrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String texto = textAreaInicio.getText();
                textAreaFinal.setText(texto);
                textAreaFinal.setBackground(colorSeleccionado);

               
                Color colorTexto;
                if (colorSeleccionado.equals(new Color(128, 255, 255))) { 
                    colorTexto = Color.RED;
                } else if (colorSeleccionado.equals(new Color(255, 0, 0))) { 
                    colorTexto = Color.BLUE;
                } else {
                    colorTexto = Color.BLACK;
                }
                textAreaFinal.setForeground(colorTexto);

                
                textAreaInicio.setText("");
                textAreaInicio.setBackground(Color.white);
            }
        });
        frame.getContentPane().add(btnMostrar);
    }
}
