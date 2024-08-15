package com.erc.main;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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

import com.erc.helpers.CommonHelpers;
import com.erc.model.Calculadora;

public class MainCalculadorBasic {
	Calculadora calculadora = new Calculadora();
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
	    private JLabel lblInformacion;
	    private JLabel lblInformacion2;
	    private JLabel lblImagenOperacion;

	    /**
	     * Launch the application.
	     */
	    public static void main(String[] args) {
	        EventQueue.invokeLater(new Runnable() {
	            public void run() {
	                try {
	                    MainCalculadorBasic window = new MainCalculadorBasic();
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
	    public MainCalculadorBasic() {
	        initialize();
	    }

	    /**
	     * Initialize the contents of the frame.
	     */
	    private void initialize() {
	    	CommonHelpers ayudaHelpers = new CommonHelpers();
	        frame = new JFrame();
	        frame.getContentPane().setBackground(Color.CYAN);
	        frame.setBounds(100, 100, 600, 400);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.getContentPane().setLayout(null);

	        // LABEL DONDE INTRODUCIREMOS EL OPERADOR 1
	        lblOperador1 = new JLabel("Operador1");
	        lblOperador1.setHorizontalAlignment(SwingConstants.CENTER);
	        lblOperador1.setBounds(69, 30, 86, 14);
	        frame.getContentPane().add(lblOperador1);
	        textOperador1 = new JTextField();
	        textOperador1.setForeground(Color.CYAN);
	        textOperador1.setFont(new Font("MV Boli", Font.BOLD, 14));
	        textOperador1.setBackground(Color.GRAY);
	        textOperador1.setBounds(69, 69, 86, 20);
	        frame.getContentPane().add(textOperador1);
	        textOperador1.setColumns(10);

	        // LABEL DONDE INTRODUCIREMOS EL OPERADOR 2
	        lblOperador2 = new JLabel("Operador2");
	        lblOperador2.setHorizontalAlignment(SwingConstants.CENTER);
	        lblOperador2.setBounds(69, 130, 86, 14);
	        frame.getContentPane().add(lblOperador2);

	        textOperador2 = new JTextField();
	        textOperador2.setForeground(Color.CYAN);
	        textOperador2.setFont(new Font("MV Boli", Font.BOLD, 14));
	        textOperador2.setBackground(Color.GRAY);
	        textOperador2.setBounds(69, 169, 86, 20);
	        textOperador2.setEnabled(false);  // DESHBILITADO INCIALMENTE
	        frame.getContentPane().add(textOperador2);
	        textOperador2.setColumns(10);

	        // LABEL DONDE INTRODUCIREMOS EL RESULTADO
	        lblResultado = new JLabel("Resultado");
	        lblResultado.setBounds(69, 268, 86, 14);
	        frame.getContentPane().add(lblResultado);

	        textResultado = new JTextField();
	        textResultado.setEditable(false);
	        textResultado.setHorizontalAlignment(SwingConstants.CENTER);
	        textResultado.setBounds(69, 293, 220, 20);
	        frame.getContentPane().add(textResultado);
	        textResultado.setColumns(10);
	        
	     // CHECKBOX PARA MOSTRAR RESULTADO EN POPUP
	        chkMostrarResultadoPopup = new JCheckBox("Pop Pup");
	        chkMostrarResultadoPopup.setBounds(316, 292, 124, 23);
	        frame.getContentPane().add(chkMostrarResultadoPopup);

	        // MOSTRAMOS LA SELECCION DEL COMBO QUE HEMOS INTRODUCIENDO PREVIAMENTE
	        comboBoxOperacion = new JComboBox<>();
	        comboBoxOperacion.setForeground(Color.CYAN);
	        comboBoxOperacion.setFont(new Font("MV Boli", Font.BOLD, 14));
	        comboBoxOperacion.setBackground(Color.GRAY);
	        comboBoxOperacion.setModel(new DefaultComboBoxModel<>(new String[] {"", "+", "-", "x", "/"}));
	        comboBoxOperacion.setBounds(242, 98, 86, 22);
	        comboBoxOperacion.setEnabled(false);  // DESHBILITADO INCIALMENTE
	        frame.getContentPane().add(comboBoxOperacion);
	        
	        lblImagenOperacion = new JLabel("");
	        lblImagenOperacion.setBounds(350, 75, 50, 50);  // Ajusta la posición y tamaño según tus necesidades
	        frame.getContentPane().add(lblImagenOperacion);

	        // ES UNA LABEL DONDE NOS INDICA DONDE ESTA EL COMBO
	        lblOperacion = new JLabel("Operacion");
	        lblOperacion.setHorizontalAlignment(SwingConstants.CENTER);
	        lblOperacion.setBounds(232, 73, 86, 14);
	        frame.getContentPane().add(lblOperacion);

	        // REALIZAMOS UN BOTON QUE EJECUTA LA OPERACION DEL COMBO
	        btnEjecutar = new JButton("");
	        btnEjecutar.setToolTipText("Calcula la operacion");
	        Image calculadora = new ImageIcon(MainCalculadorBasic.class.getResource("/images/calcular.png")).getImage();
	        Image calculadoraScaled = calculadora.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
	        btnEjecutar.setIcon(new ImageIcon(calculadoraScaled));
	        btnEjecutar.setForeground(Color.CYAN);
	        btnEjecutar.setFont(new Font("MV Boli", Font.BOLD, 14));
	      
	        btnEjecutar.setBounds(495, 169, 50, 50);
	        frame.getContentPane().add(btnEjecutar);

	        // REALIZAMOS UN BOTON PARA RESETEAR Y ADEMAS VOLVER AL INICIO DE LA OPERACION
	        // CARGANDO LA IMAGEN DESDE NUESTRO ARCHIVO, REDIMENSIONANDO LA IMAGEN
	        
	        
	        btnReset = new JButton("");
	        btnReset.setToolTipText("Reinicia el programa");
	        Image borrar = new ImageIcon(MainCalculadorBasic.class.getResource("/images/reiniciar.png")).getImage();	       
	        Image borrarScaled = borrar.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
	        btnReset.setIcon(new ImageIcon(borrarScaled));
	        btnReset.setBounds(495, 263, 50, 50);
	        frame.getContentPane().add(btnReset);
	        
	        lblInformacion = new JLabel("");
	        Image informacion = new ImageIcon(MainCalculadorBasic.class.getResource("/images/informacion.png")).getImage();
	        Image informacionScaled = informacion.getScaledInstance(15, 15, Image.SCALE_SMOOTH);
	        lblInformacion.setIcon(new ImageIcon(informacionScaled));
	        lblInformacion.setToolTipText("Introduzca un numero ");
	        lblInformacion.setHorizontalAlignment(SwingConstants.CENTER);
	        lblInformacion.setBounds(165, 69, 15, 15);
	        frame.getContentPane().add(lblInformacion);
	        
	        lblInformacion2 = new JLabel("");
	        lblInformacion2.setToolTipText("Introduzca un numero");
	        Image informacion2 = new ImageIcon(MainCalculadorBasic.class.getResource("/images/informacion.png")).getImage();
	        Image informacion2Scaled = informacion2.getScaledInstance(15, 15, Image.SCALE_SMOOTH);
	        lblInformacion2.setIcon(new ImageIcon(informacion2Scaled));
	        lblInformacion2.setBounds(168, 173, 15, 15);
	        frame.getContentPane().add(lblInformacion2);
	        
	    
	        
	        
	        // HABILITAMOS EL COMBO DE LAS OPERACIONBES DESPUES DE INGRESAR EL NUMERO EN EL OPERADOR 1
	       
	        textOperador1.addKeyListener(new KeyAdapter() {			
	            @Override
	            public void keyTyped(KeyEvent e) {
	            	
	                try {
	                	String textoLeido =textOperador1.getText();
	                	char caracterLeido = e.getKeyChar();
	                	textoLeido= ayudaHelpers.soloNumeros(textoLeido, caracterLeido);
	                	textOperador1.setText(textoLeido);
	                	e.consume();
	                	ayudaHelpers.obtenerDouble(textOperador1.getText().trim().replaceAll(",", "."));
	                    lblOperacion.setEnabled(true);
	                    comboBoxOperacion.setEnabled(true);
	                } catch (NumberFormatException ex) {
	                    JOptionPane.showMessageDialog(frame, "Error: Entrada no válida en Operador 1", "Error", JOptionPane.ERROR_MESSAGE);
	                }
	            }
	        });
	        
	        // HABILITAMOS EL  CAMPO EL OPERADOR 2 DESPUES DE SELECIONAR UN STRING DE OPERACION DEL COMBO
	        comboBoxOperacion.addActionListener(new ActionListener() {
	        	
	            public void actionPerformed(ActionEvent e) {
	            	 int selectedIndex = comboBoxOperacion.getSelectedIndex();
	            	 String selectedItem = (String) comboBoxOperacion.getSelectedItem();
	                if (selectedIndex > 0) {
	                    lblOperador2.setEnabled(true);
	                    textOperador2.setEnabled(true);	
	                    ImageIcon icon;
	                    switch (selectedItem) {
	                        case "+":
	                        	ImageIcon iconMas = new ImageIcon(MainCalculadorBasic.class.getResource("/images/signo-mas.png"));
	                            Image mas = iconMas.getImage();
	                            Image masScaled = mas.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
	                            icon = new ImageIcon(masScaled);
	                            break;
	                        case "-":
	                        	ImageIcon iconMenos = new ImageIcon(MainCalculadorBasic.class.getResource("/images/signo-menos.png"));
	                            Image menos = iconMenos.getImage();
	                            Image menosScaled = menos.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
	                            icon = new ImageIcon(menosScaled);
	                            break;
	                        case "x":
	                        	ImageIcon iconMultiplicar = new ImageIcon(MainCalculadorBasic.class.getResource("/images/signo-multiplicar.png"));
	                            Image multiplicar = iconMultiplicar.getImage();
	                            Image multiplicarScaled = multiplicar.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
	                            icon = new ImageIcon(multiplicarScaled);
	                            break;
	                        case "/":
	                        	ImageIcon iconDividir = new ImageIcon(MainCalculadorBasic.class.getResource("/images/signo-dividir.png"));
	                            Image dividir = iconDividir.getImage();
	                            Image dividirScaled = dividir.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
	                            icon = new ImageIcon(dividirScaled);
	                            break;
	                        default:
	                            icon = null;
	                            break;
	                    }
	                    lblImagenOperacion.setIcon(icon);
	                } else {
	                    textOperador2.setEnabled(false);
	                    lblImagenOperacion.setIcon(null);
	                }
	            }
	        });

	        
	        // HABILITAMOS EL BOTON DE IGUAL DESPUES DE INGRESAR EL OPERADOR 2
	       
	        textOperador2.addKeyListener(new KeyAdapter() {		
	            @Override
	            public void keyTyped(KeyEvent e) {
	            	
	                try {
	                	String textoLeido =textOperador2.getText();
	                	char caracterLeido = e.getKeyChar();
	                	textoLeido= ayudaHelpers.soloNumeros(textoLeido, caracterLeido);
	                	textOperador2.setText(textoLeido);
	                	e.consume();	                	
	                	ayudaHelpers.obtenerDouble(textOperador2.getText().trim().replaceAll(",", "."));
	                    btnEjecutar.setEnabled(true);
	                } catch (NumberFormatException ex) {
	                    JOptionPane.showMessageDialog(frame, "Error: Entrada no válida en Operador 2", "Error", JOptionPane.ERROR_MESSAGE);
	                }
	            }
	        });
	        
	        

	        btnEjecutar.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                try {
	                    // OBTIENE LOS VALORES DE LOS CAMPOS DE TEXTO Y COMBOBOX
		                    double operador1 =ayudaHelpers.obtenerDouble(textOperador1.getText());
		                    double operador2 = ayudaHelpers.obtenerDouble(textOperador2.getText());
		                    String operacion = (String) comboBoxOperacion.getSelectedItem();

	                    // CREA UNA INSTANCIA DE LA CLASE CALCULADORA
	                    Calculadora calculadora = new Calculadora(operador1, operador2, operacion);

	                    // CALCULA EL RESULTADO
	                    double resultado = calculadora.calcularOperacion();

	                    // FORMATEA EL RESULTADO
	                    String resultadoFormateado = calculadora.resultadoDecimales(resultado);

	                    // MUESTRA EL RESULTADO
	                    if (chkMostrarResultadoPopup.isSelected()) {
	                        textResultado.setText("");
	                        JOptionPane.showMessageDialog(frame, "Resultado: " + resultadoFormateado, "Resultado", JOptionPane.INFORMATION_MESSAGE);
	                    } else {
	                        textResultado.setText(resultadoFormateado);
	                    }
	                } catch (NumberFormatException ex) {
	                    JOptionPane.showMessageDialog(frame, "Error: Entrada no válida", "Error", JOptionPane.ERROR_MESSAGE);
	                } catch (ArithmeticException ex) {
	                    JOptionPane.showMessageDialog(frame, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	                } catch (IllegalArgumentException ex) {
	                    JOptionPane.showMessageDialog(frame, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	                }
	            }
	        });
	        // CON EL ACTIONPERFORMED PARA EL BOTON DE "C" QUE ES EL RESET, RESETEAMOS TODOS LOS CAMPOS QUE QUEREMOS
	        btnReset.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	Calculadora calculadora = new Calculadora(0, 0, null);
	                textOperador1.setText("");
	                textOperador2.setText("");
	                textResultado.setText("");	                
					calculadora.setOperador1(0);
					calculadora.setOperador2(0);
					calculadora.setOperacion("");
	               
	                comboBoxOperacion.setSelectedIndex(0);
	            }
	        });
	    }
}
