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

public class EjemploRadioButtons {

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

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    EjemploRadioButtons window = new EjemploRadioButtons();
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
    public EjemploRadioButtons() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 709, 413);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
                lblNombre = new JLabel("Resultado Final");
                lblNombre.setOpaque(false);
                lblNombre.setBackground(new Color(255, 128, 0));
                lblNombre.setBounds(297, 206, 103, 14);
                frame.getContentPane().add(lblNombre);

        txtAreaInicio = new JTextArea();
        txtAreaInicio.setLineWrap(true);
        txtAreaInicio.setWrapStyleWord(true);
        txtAreaInicio.setBounds(232, 16, 230, 164);
        frame.getContentPane().add(txtAreaInicio);

        rdbtnColorRojoFondo = new JRadioButton("Rojo");
        rdbtnColorRojoFondo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                selectedColorFondo = Color.RED;
                // No actualiza el área de texto hasta que se haga clic en el botón de cambio de fondo
            }
        });
        rdbtngColoresFondo.add(rdbtnColorRojoFondo);
        rdbtnColorRojoFondo.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        rdbtnColorRojoFondo.setBounds(33, 56, 67, 21);
        frame.getContentPane().add(rdbtnColorRojoFondo);

        rdbtnColorAzulFondo = new JRadioButton("Azul");
        rdbtnColorAzulFondo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                selectedColorFondo = Color.BLUE;
                // No actualiza el área de texto hasta que se haga clic en el botón de cambio de fondo
            }
        });
        rdbtngColoresFondo.add(rdbtnColorAzulFondo);
        rdbtnColorAzulFondo.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        rdbtnColorAzulFondo.setBounds(33, 96, 67, 21);
        frame.getContentPane().add(rdbtnColorAzulFondo);

        rdbtnColorAmarilloFondo = new JRadioButton("Amarillo");
        rdbtnColorAmarilloFondo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                selectedColorFondo = Color.YELLOW;
                // No actualiza el área de texto hasta que se haga clic en el botón de cambio de fondo
            }
        });
        rdbtngColoresFondo.add(rdbtnColorAmarilloFondo);
        rdbtnColorAmarilloFondo.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        rdbtnColorAmarilloFondo.setBounds(33, 136, 82, 21);
        frame.getContentPane().add(rdbtnColorAmarilloFondo);

        rdbtnColorVerdeFondo = new JRadioButton("Verde");
        rdbtnColorVerdeFondo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                selectedColorFondo = Color.GREEN;
                // No actualiza el área de texto hasta que se haga clic en el botón de cambio de fondo
            }
        });
        rdbtngColoresFondo.add(rdbtnColorVerdeFondo);
        rdbtnColorVerdeFondo.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        rdbtnColorVerdeFondo.setBounds(33, 179, 67, 21);
        frame.getContentPane().add(rdbtnColorVerdeFondo);

        btnCambiarFondo = new JButton("Cambiar Color Fondo");
        btnCambiarFondo.setBounds(10, 11, 190, 35);
        frame.getContentPane().add(btnCambiarFondo);
        btnCambiarFondo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (selectedColorTexto.equals(selectedColorFondo)) {
                    JOptionPane.showMessageDialog(frame, "Este color no se puede usar para el fondo porque ya está siendo usado como color de texto.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                } else {
                    txtAreaFinal.setBackground(selectedColorFondo);
                    updateTextColors();
                }
            }
        });

        rdbtnColorRojoTexto = new JRadioButton("Rojo");
        rdbtnColorRojoTexto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                selectedColorTexto = Color.RED;
            }
        });
        rdbtngColoresTexto.add(rdbtnColorRojoTexto);
        rdbtnColorRojoTexto.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        rdbtnColorRojoTexto.setBounds(536, 56, 103, 21);
        frame.getContentPane().add(rdbtnColorRojoTexto);

        rdbtnColorAzulTexto = new JRadioButton("Azul");
        rdbtnColorAzulTexto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                selectedColorTexto = Color.BLUE;
            }
        });
        rdbtngColoresTexto.add(rdbtnColorAzulTexto);
        rdbtnColorAzulTexto.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        rdbtnColorAzulTexto.setBounds(536, 96, 103, 21);
        frame.getContentPane().add(rdbtnColorAzulTexto);

        rdbtnColorAmarilloTexto = new JRadioButton("Amarillo");
        rdbtnColorAmarilloTexto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                selectedColorTexto = Color.YELLOW;
            }
        });
        rdbtngColoresTexto.add(rdbtnColorAmarilloTexto);
        rdbtnColorAmarilloTexto.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        rdbtnColorAmarilloTexto.setBounds(536, 136, 103, 21);
        frame.getContentPane().add(rdbtnColorAmarilloTexto);

        rdbtnColorVerdeTexto = new JRadioButton("Verde");
        rdbtnColorVerdeTexto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                selectedColorTexto = Color.GREEN;
            }
        });
        rdbtngColoresTexto.add(rdbtnColorVerdeTexto);
        rdbtnColorVerdeTexto.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        rdbtnColorVerdeTexto.setBounds(536, 179, 103, 21);
        frame.getContentPane().add(rdbtnColorVerdeTexto);

        btnCambiarTexto = new JButton("Cambiar Color Texto");
        btnCambiarTexto.setBounds(493, 11, 190, 35);
        frame.getContentPane().add(btnCambiarTexto);
        btnCambiarTexto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (selectedColorFondo.equals(selectedColorTexto)) {
                    JOptionPane.showMessageDialog(frame, "Donde vas bacalao esto no se puede, INTENTA ATENDER EN CLASE", "Advertencia", JOptionPane.WARNING_MESSAGE);
                } else {
                    txtAreaFinal.setForeground(selectedColorTexto);
                    updateTextColors();
                }
            }
        });

        txtAreaFinal = new JTextArea();
        txtAreaFinal.setWrapStyleWord(true);
        txtAreaFinal.setLineWrap(true);
        txtAreaFinal.setBounds(232, 201, 230, 164);
        frame.getContentPane().add(txtAreaFinal);

        updateTextColors();
    }

    private void updateTextColors() {
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





/*rdbtnColorRojoFondo.setEnabled(!selectedColorFondo.equals(Color.RED));
		rdbtnColorAzulFondo.setEnabled(!selectedColorFondo.equals(Color.BLUE));
		rdbtnColorAmarilloFondo.setEnabled(!selectedColorFondo.equals(Color.YELLOW));
		rdbtnColorVerdeFondo.setEnabled(!selectedColorFondo.equals(Color.GREEN));*/
