package com.erc.main;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.erc.model.Calculadora;


public class MainCalcBasc {
   private JFrame frame;
    private JTextField textOperador1;
    private JTextField textOperador2;
    private JTextField textResultado;
    private JLabel lblOperador1;
    private JLabel lblOperador2;
    private JLabel lblResultado;
    private JComboBox<String> comboBoxOperacion;
    private JLabel lblOperacion;
    private JButton btnEjecutar;
    private JButton btnReset;
    private JCheckBox chkMostrarResultadoPopup;
    private Calculadora calculadora;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            try {
                MainCalcBasc window = new MainCalcBasc();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Create the application.
     */
    public MainCalcBasc() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        calculadora = new Calculadora();
        frame = new JFrame();
        frame.getContentPane().setBackground(new Color(203, 103, 0));
        frame.setBounds(100, 100, 600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        // LABEL DONDE INTRODUCIREMOS EL OPERADOR 1
        lblOperador1 = new JLabel("Operador1");
        lblOperador1.setHorizontalAlignment(SwingConstants.CENTER);
        lblOperador1.setBounds(69, 30, 86, 14);
        frame.getContentPane().add(lblOperador1);

        textOperador1 = new JTextField();
        textOperador1.setBounds(69, 69, 86, 20);
        frame.getContentPane().add(textOperador1);
        textOperador1.setColumns(10);

        // LABEL DONDE INTRODUCIREMOS EL OPERADOR 2
        lblOperador2 = new JLabel("Operador2");
        lblOperador2.setHorizontalAlignment(SwingConstants.CENTER);
        lblOperador2.setBounds(69, 130, 86, 14);
        frame.getContentPane().add(lblOperador2);

        textOperador2 = new JTextField();
        textOperador2.setBounds(69, 169, 86, 20);
        textOperador2.setEnabled(false);  // DESHBILITADO INCIALMENTE
        frame.getContentPane().add(textOperador2);
        textOperador2.setColumns(10);

        // LABEL DONDE INTRODUCIREMOS EL RESULTADO
        lblResultado = new JLabel("Resultado");
        lblResultado.setBounds(69, 268, 86, 14);
        frame.getContentPane().add(lblResultado);

        textResultado = new JTextField();
        textResultado.setBounds(69, 293, 220, 20);
        frame.getContentPane().add(textResultado);
        textResultado.setColumns(10);

        // CHECKBOX PARA MOSTRAR RESULTADO EN POPUP
        chkMostrarResultadoPopup = new JCheckBox("Pop Pup");
        chkMostrarResultadoPopup.setBounds(307, 319, 124, 23);
        frame.getContentPane().add(chkMostrarResultadoPopup);

        // MOSTRAMOS LA SELECCION DEL COMBO QUE HEMOS INTRODUCIENDO PREVIAMENTE
        comboBoxOperacion = new JComboBox<>();
        comboBoxOperacion.setModel(new DefaultComboBoxModel<>(new String[] {"", "+", "-", "x", "/"}));
        comboBoxOperacion.setBounds(441, 86, 86, 22);
        comboBoxOperacion.setEnabled(false);  // DESHBILITADO INCIALMENTE
        frame.getContentPane().add(comboBoxOperacion);

        // ES UNA LABEL DONDE NOS INDICA DONDE ESTA EL COMBO
        lblOperacion = new JLabel("Operacion");
        lblOperacion.setHorizontalAlignment(SwingConstants.CENTER);
        lblOperacion.setBounds(441, 30, 86, 14);
        frame.getContentPane().add(lblOperacion);

        // REALIZAMOS UN BOTON QUE EJECUTA LA OPERACION DEL COMBO
        btnEjecutar = new JButton("=");
        btnEjecutar.setBounds(441, 184, 89, 23);
        btnEjecutar.setEnabled(false);  // DESHBILITADO INCIALMENTE
        frame.getContentPane().add(btnEjecutar);

        // REALIZAMOS UN BOTON PARA RESETEAR Y ADEMAS VOLVER AL INICIO DE LA OPERACION
        // CARGANDO LA IMAGEN DESDE NUESTRO ARCHIVO, REDIMENSIONANDO LA IMAGEN
        ImageIcon imagenPapelera = new ImageIcon("C:\\Users\\Ivan\\eclipse-workspace\\09_08_24_interfaces\\Ejemplo_Calculadora_Radio_Combo\\resources\\papelera.png");
        Image imagenNuevaPapelera = imagenPapelera.getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH);
        ImageIcon iconoPapeleraEscalado = new ImageIcon(imagenNuevaPapelera);
        btnReset = new JButton(iconoPapeleraEscalado);
        btnReset.setBounds(500, 284, 35, 35);
        frame.getContentPane().add(btnReset);

        Calculadora calculadora = new Calculadora(0, 0, "");
		// PONERMOS O INICIALIZAMOS LOS COMPONENTES A TRABAJAR
        calculadora.habilitarComponentes(false, false, false, lblOperador2, textOperador2, comboBoxOperacion, btnEjecutar);

        // HABILITAMOS EL COMBO DE LAS OPERACIONBES DESPUES DE INGRESAR EL NUMERO EN EL OPERADOR 1
        textOperador1.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                if (Calculadora.soloNumeros(textOperador1.getText())) {
                    Calculadora calculadora = new Calculadora(0, 0, "");
					calculadora.habilitarComponentes(false, true, false, lblOperador2, textOperador2, comboBoxOperacion, btnEjecutar);
                } else {
                    JOptionPane.showMessageDialog(frame, "Por favor, ingresa un número válido en el operando 1");
                }
            }
        });

        // HABILITAMOS EL CAMPO EL OPERADOR 2 DESPUES DE SELECIONAR UN STRING DE OPERACION DEL COMBO
        comboBoxOperacion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (comboBoxOperacion.getSelectedIndex() > 0) {
                    lblOperador2.setEnabled(true);
                    textOperador2.setEnabled(true);
                } else {
                    textOperador2.setEnabled(false);
                }
            }
        });

        // HABILITAMOS EL BOTON DE IGUAL DESPUES DE INGRESAR EL OPERADOR 2
        textOperador2.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                if (Calculadora.soloNumeros(textOperador2.getText())) {
                    Calculadora calculadora = new Calculadora(0, 0, null);
					calculadora.habilitarComponentes(true, true, true, lblOperador2, textOperador2, comboBoxOperacion, btnEjecutar);
                } else {
                    JOptionPane.showMessageDialog(frame, "Por favor, ingresa un número válido en el operando 2");
                }
            }
        });

        // CON EL ACTIONPERFORMED LO METEMOS EN EL "="
        btnEjecutar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    // OBTENEMOS LOS VALORES DE LOS DOS OPERADORES Y A SU VEZ EN DECIMALES
                    double operador1 = Double.parseDouble(textOperador1.getText());
                    double operador2 = Double.parseDouble(textOperador2.getText());

                    // OBTENEMOS LA OPERACION SELECCIONADA CON EL COMBO
                    String operacion = (String) comboBoxOperacion.getSelectedItem();
                    
                    // REALIZAMOS EL CALCULO
                    double resultado = calculadora.ejecutarOperacion(operador1, operador2, operacion);

                    // FORMATEAMOS EL RESULTADO A DOS DECIMALES
                    double resultadoFormateado = calculadora.resultadoDecimales(resultado);
                    String resultadoComoTexto = String.format("%.2f", resultadoFormateado);
                    
                    // MOSTRAMOS EL RESULTADO SEGÚN EL ESTADO DEL CHECKBOX
                    if (chkMostrarResultadoPopup.isSelected()) {
                        textResultado.setText(""); // LIMPIAMOS EL RESULTADO DEL LABEL DE TEXTRESULTADO
                        JOptionPane.showMessageDialog(frame, "Resultado: " + resultadoComoTexto, "Resultado", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        textResultado.setText(resultadoComoTexto);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Por favor, ingresa números válidos.", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (ArithmeticException ex) {
                    JOptionPane.showMessageDialog(frame, "Error: División por cero.", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Error inesperado: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // CON EL ACTIONPERFORMED PARA EL BOTON DE "C" QUE ES EL RESET, RESETEAMOS TODOS LOS CAMPOS QUE QUEREMOS
        btnReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textOperador1.setText("");
                textOperador2.setText("");
                textResultado.setText("");
                chkMostrarResultadoPopup.setSelected(false);
                comboBoxOperacion.setSelectedIndex(0);
            }
        });
    }
}
