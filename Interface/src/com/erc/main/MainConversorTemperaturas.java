package com.erc.main;

import java.awt.EventQueue;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import java.awt.Font;

public class MainConversorTemperaturas {

    private JFrame frame;
    private JTextField textField;
    private JTextField textResultado;
    private final ButtonGroup buttonGroup = new ButtonGroup();
    private JRadioButton rdbtnGradosCelsius;
    private JRadioButton rdbtnGradosKelvin;
    private JRadioButton rdbtnGradosFahrenheit;
    private JComboBox<String> comboBox;
    private JCheckBox chkMostrarResultadoPopup;
    private JButton btnConvertirTemperatura;
    private JLabel lblEntradaTemperatura;
    private JLabel lblResultado ;
    private JButton btnReset;
    private JButton btnSalir;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                MainConversorTemperaturas window = new MainConversorTemperaturas();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Create the application.
     */
    public MainConversorTemperaturas() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    
    
    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setBackground(new Color(233, 103, 0));
        frame.setBounds(100, 100, 600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        lblEntradaTemperatura = new JLabel("Entrada Temperatura");
        lblEntradaTemperatura.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
        lblEntradaTemperatura.setBounds(22, 26, 135, 14);
        frame.getContentPane().add(lblEntradaTemperatura);

        textField = new JTextField();
        textField.setBounds(22, 56, 86, 20);
        textField.setColumns(10);
        frame.getContentPane().add(textField);

        rdbtnGradosCelsius = new JRadioButton("º C");
        buttonGroup.add(rdbtnGradosCelsius);
        rdbtnGradosCelsius.setBounds(181, 39, 109, 23);
        rdbtnGradosCelsius.setEnabled(false);  // INICIALMENTE LO DESHABILITAMOS
        frame.getContentPane().add(rdbtnGradosCelsius);

        rdbtnGradosKelvin = new JRadioButton("º K");
        buttonGroup.add(rdbtnGradosKelvin);
        rdbtnGradosKelvin.setBounds(181, 82, 109, 23);
        rdbtnGradosKelvin.setEnabled(false);  //  INICIALMENTE LO DESHABILITAMOS
        frame.getContentPane().add(rdbtnGradosKelvin);

        rdbtnGradosFahrenheit = new JRadioButton("º F");
        buttonGroup.add(rdbtnGradosFahrenheit);
        rdbtnGradosFahrenheit.setBounds(181, 132, 109, 23);
        rdbtnGradosFahrenheit.setEnabled(false);  //  INICIALMENTE LO DESHABILITAMOS
        frame.getContentPane().add(rdbtnGradosFahrenheit);

        comboBox = new JComboBox<>();
        comboBox.setModel(new DefaultComboBoxModel<>(new String[] {"", "CELSIUS", "KELVIN", "FAHRENHEIT"}));
        comboBox.setBounds(321, 176, 86, 22);
        frame.getContentPane().add(comboBox);

        btnConvertirTemperatura = new JButton("Convertir");
        btnConvertirTemperatura.setFont(new Font("MV Boli", Font.PLAIN, 12));
        btnConvertirTemperatura.setBounds(453, 176, 89, 23);
        frame.getContentPane().add(btnConvertirTemperatura);

        textResultado = new JTextField();
        textResultado.setEditable(false);
        textResultado.setBounds(197, 261, 86, 20);
        textResultado.setColumns(10);
        frame.getContentPane().add(textResultado);

        lblResultado = new JLabel("Resultado");
        lblResultado.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
        lblResultado.setBounds(22, 264, 117, 14);
        frame.getContentPane().add(lblResultado);

        chkMostrarResultadoPopup = new JCheckBox("POP PUP");
        chkMostrarResultadoPopup.setFont(new Font("MV Boli", Font.PLAIN, 12));
        chkMostrarResultadoPopup.setBounds(199, 305, 86, 23);
        frame.getContentPane().add(chkMostrarResultadoPopup);
        
        btnReset = new JButton("Reset");
        btnReset.setFont(new Font("MV Boli", Font.PLAIN, 12));
        btnReset.setBounds(365, 305, 89, 23);
        frame.getContentPane().add(btnReset);

        btnSalir = new JButton("Salir");
        btnSalir.setFont(new Font("MV Boli", Font.PLAIN, 12));
        btnSalir.setBounds(474, 305, 89, 23);
        frame.getContentPane().add(btnSalir);
        
        
        // SOLO SE ACTIVAN LOS RADIO BUTTONS CUANDO INGRESAMOS UN NUMERO DENTRO DEL LABEL DE ENTRADA DE TEMPERATURA
        
        textField.addActionListener(e -> {
            try {
                Double.parseDouble(textField.getText().trim());
                rdbtnGradosCelsius.setEnabled(true);
                rdbtnGradosKelvin.setEnabled(true);
                rdbtnGradosFahrenheit.setEnabled(true);
            } catch (NumberFormatException ex) {
                rdbtnGradosCelsius.setEnabled(false);
                rdbtnGradosKelvin.setEnabled(false);
                rdbtnGradosFahrenheit.setEnabled(false);
            }
        });

       // SE ACTIVA EL BOTON DE CONVETIR AL  TENER ACTIVADOS TODOS LOS RADIOBUTTON COMO EL CHECKBOX DEL DESPLEGABLE
        btnConvertirTemperatura.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double temperatura = Double.parseDouble(textField.getText().trim());
                    double resultado = 0;

                    // VERIFICAMOS QUE ESTE SELECIONADO ALGUN RADIOBUTTON
                    if (!rdbtnGradosCelsius.isSelected() && !rdbtnGradosKelvin.isSelected() && !rdbtnGradosFahrenheit.isSelected()) {
                        JOptionPane.showMessageDialog(frame, "Seleccione una unidad de entrada", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    // VERIFICAMOS LA UNIDAD DE SALIDA DENTRO DEL COMBOX, SI HEMOS SELECIONADO ALGUNO
                    String unidadSalida = (String) comboBox.getSelectedItem();
                    if (unidadSalida == null || unidadSalida.isEmpty()) {
                        JOptionPane.showMessageDialog(frame, "Seleccione una unidad de salida", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    // LAS UNIDADES DE ENTRADA COMPRUBA SI ESTAN SELECIONADAS PARA QUE ME MUESTRE UN ERROR SI SON IGUALES DE ENTRADA Y SALIDA
                    String unidadEntrada = "";
                    if (rdbtnGradosCelsius.isSelected()) {
                        unidadEntrada = "CELSIUS";
                    } else if (rdbtnGradosKelvin.isSelected()) {
                        unidadEntrada = "KELVIN";
                    } else if (rdbtnGradosFahrenheit.isSelected()) {
                        unidadEntrada = "FAHRENHEIT";
                    }
                    if (unidadEntrada.equals(unidadSalida)) {
                        JOptionPane.showMessageDialog(frame, " =>>>>>>>>> LOSER <<<<<<<<<=", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                 // CONVERSION DE LA UNIDADES DE MEDIDA DE CADA UNO DE ELLOS Y SUS OPERACIONES MATEMATICAS
                    if (unidadEntrada.equals("CELSIUS")) {
                        if (unidadSalida.equals("KELVIN")) {
                            resultado = temperatura + 273.15;
                        } else if (unidadSalida.equals("FAHRENHEIT")) {
                            resultado = (temperatura * 9/5) + 32;
                        }
                    } else if (unidadEntrada.equals("KELVIN")) {
                        if (unidadSalida.equals("CELSIUS")) {
                            resultado = temperatura - 273.15;
                        } else if (unidadSalida.equals("FAHRENHEIT")) {
                            resultado = (temperatura - 273.15) * 9/5 + 32;
                        }
                    } else if (unidadEntrada.equals("FAHRENHEIT")) {
                        if (unidadSalida.equals("CELSIUS")) {
                            resultado = (temperatura - 32) * 5/9;
                        } else if (unidadSalida.equals("KELVIN")) {
                            resultado = (temperatura - 32) * 5/9 + 273.15;
                        }
                    }

                    String resultadoFormateado = String.format("%.2f", resultado);

                    if (chkMostrarResultadoPopup.isSelected()) {
                        textResultado.setText(""); // LIMPIAMOS EL LABEL DE RESULTADO UNA VEZ ACTIVADO  EL POPPUP
                        JOptionPane.showMessageDialog(frame, "Resultado: " + resultadoFormateado, "Resultado", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        textResultado.setText(resultadoFormateado);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Error: Entrada no válida", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnReset.addActionListener(e -> {
            int response = JOptionPane.showConfirmDialog(frame,
                "¿Desea reiniciar todos los campos?",
                "Confirmar Reinicio",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);

            if (response == JOptionPane.YES_OPTION) {
                // LIMPIAMOS LOS CAMPOS DE HAYAMOS INTRODUCIDOS Y LOS PONE EN BLANCO
                textField.setText("");
                textResultado.setText("");
                comboBox.setSelectedIndex(0);
                buttonGroup.clearSelection();
                rdbtnGradosCelsius.setEnabled(false);
                rdbtnGradosKelvin.setEnabled(false);
                rdbtnGradosFahrenheit.setEnabled(false);
                chkMostrarResultadoPopup.setSelected(false);
            }
        });
         
        // ESTA ES LA ACCION QUE REALIZA EL BOTO DE SALIR
        btnSalir.addActionListener(e -> {
            int response = JOptionPane.showConfirmDialog(frame,
                "¿Está seguro de que desea salir del programa?",
                "Confirmar Salida",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);

            if (response == JOptionPane.YES_OPTION) {
                System.exit(0);
            } else if (response == JOptionPane.NO_OPTION) {
                // REINICIA TODOS LOS CAMPOS ANTES DE SALIR
                textField.setText("");
                textResultado.setText("");
                comboBox.setSelectedIndex(0);
                buttonGroup.clearSelection();
                rdbtnGradosCelsius.setEnabled(false);
                rdbtnGradosKelvin.setEnabled(false);
                rdbtnGradosFahrenheit.setEnabled(false);
                chkMostrarResultadoPopup.setSelected(false);
            }
        });
        
    }
}
