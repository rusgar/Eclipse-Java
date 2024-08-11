package com.erc.main;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.security.cert.TrustAnchor;
import java.text.DecimalFormat;
import javax.swing.JTextArea;

public class MainCalculadoraWindows {

    private JFrame frame;
    
    private JTextArea textAreaResultado;
    private JButton btnNumeroSiete, btnNumeroOcho, btnNumeroNueve, btnNumeroCuatro, btnNumeroCinco,
            btnNumeroSeis, btnNumeroUno, btnNumeroDos, btnNumeroTres, btnPositivoNegativo,
            btnNumeroCero, btnComa, btnMultiplicacion, btnResta, btnSuma, btnIgual, btnDivision;
    private JButton btnPorcentaje, btnRaizCuadrada, btnReset;
    

    private double primerNumero = 0;
    private double segundoNumero = 0;
    private String operador = "";
    private boolean operadorSeleccionado = false;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                MainCalculadoraWindows window = new MainCalculadoraWindows();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public MainCalculadoraWindows() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setFont(new Font("MV Boli", Font.BOLD, 16));
        frame.getContentPane().setBackground(new Color(233, 103, 0));
        frame.setBounds(100, 100, 450, 550);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        
        textAreaResultado = new JTextArea();
        textAreaResultado.setLineWrap(true);
        textAreaResultado.setFont(new Font("Comic Sans MS", Font.BOLD, 23));
        textAreaResultado.setBounds(65, 11, 270, 98);
        frame.getContentPane().add(textAreaResultado);
        textAreaResultado.setColumns(10);

       

        btnNumeroSiete = new JButton("7");
        btnNumeroSiete.setBackground(new Color(192, 192, 192));
        btnNumeroSiete.setFont(new Font("MV Boli", Font.BOLD, 16));
        btnNumeroSiete.setBounds(65, 196, 60, 60);
        frame.getContentPane().add(btnNumeroSiete);

        btnNumeroOcho = new JButton("8");
        btnNumeroOcho.setBackground(new Color(192, 192, 192));
        btnNumeroOcho.setFont(new Font("MV Boli", Font.BOLD, 16));
        btnNumeroOcho.setBounds(135, 196, 60, 60);
        frame.getContentPane().add(btnNumeroOcho);

        btnNumeroNueve = new JButton("9");
        btnNumeroNueve.setBackground(new Color(192, 192, 192));
        btnNumeroNueve.setFont(new Font("MV Boli", Font.BOLD, 16));
        btnNumeroNueve.setBounds(205, 196, 60, 60);
        frame.getContentPane().add(btnNumeroNueve);

        btnNumeroCuatro = new JButton("4");
        btnNumeroCuatro.setBackground(new Color(192, 192, 192));
        btnNumeroCuatro.setFont(new Font("MV Boli", Font.BOLD, 16));
        btnNumeroCuatro.setBounds(65, 267, 60, 60);
        frame.getContentPane().add(btnNumeroCuatro);

        btnNumeroCinco = new JButton("5");
        btnNumeroCinco.setBackground(new Color(192, 192, 192));
        btnNumeroCinco.setFont(new Font("MV Boli", Font.BOLD, 16));
        btnNumeroCinco.setBounds(135, 267, 60, 60);
        frame.getContentPane().add(btnNumeroCinco);

        btnNumeroSeis = new JButton("6");
        btnNumeroSeis.setBackground(new Color(192, 192, 192));
        btnNumeroSeis.setFont(new Font("MV Boli", Font.BOLD, 16));
        btnNumeroSeis.setBounds(205, 267, 60, 60);
        frame.getContentPane().add(btnNumeroSeis);

        btnNumeroUno = new JButton("1");
        btnNumeroUno.setBackground(new Color(192, 192, 192));
        btnNumeroUno.setFont(new Font("MV Boli", Font.BOLD, 16));
        btnNumeroUno.setBounds(65, 338, 60, 60);
        frame.getContentPane().add(btnNumeroUno);

        btnNumeroDos = new JButton("2");
        btnNumeroDos.setBackground(new Color(192, 192, 192));
        btnNumeroDos.setFont(new Font("MV Boli", Font.BOLD, 16));
        btnNumeroDos.setBounds(135, 338, 60, 60);
        frame.getContentPane().add(btnNumeroDos);

        btnNumeroTres = new JButton("3");
        btnNumeroTres.setBackground(new Color(192, 192, 192));
        btnNumeroTres.setFont(new Font("MV Boli", Font.BOLD, 16));
        btnNumeroTres.setBounds(205, 338, 60, 60);
        frame.getContentPane().add(btnNumeroTres);

        btnPositivoNegativo = new JButton("+/-");
        btnPositivoNegativo.setFont(new Font("MV Boli", Font.BOLD, 16));
        btnPositivoNegativo.setBounds(65, 409, 60, 60);
        frame.getContentPane().add(btnPositivoNegativo);

        btnNumeroCero = new JButton("0");
        btnNumeroCero.setBackground(new Color(192, 192, 192));
        btnNumeroCero.setFont(new Font("MV Boli", Font.BOLD, 16));
        btnNumeroCero.setBounds(135, 409, 60, 60);
        frame.getContentPane().add(btnNumeroCero);

        btnComa = new JButton(",");
        btnComa.setFont(new Font("MV Boli", Font.BOLD, 16));
        btnComa.setBounds(205, 409, 60, 60);
        frame.getContentPane().add(btnComa);

        btnMultiplicacion = new JButton("X");
        btnMultiplicacion.setBackground(new Color(233, 233, 233));
        btnMultiplicacion.setFont(new Font("MV Boli", Font.BOLD, 16));
        btnMultiplicacion.setBounds(275, 196, 60, 60);
        btnMultiplicacion.setEnabled(false);
        frame.getContentPane().add(btnMultiplicacion);

        btnResta = new JButton("-");
        btnResta.setBackground(new Color(233, 233, 233));
        btnResta.setFont(new Font("MV Boli", Font.BOLD, 20));
        btnResta.setBounds(275, 266, 60, 60);
        btnResta.setEnabled(false);
        frame.getContentPane().add(btnResta);

        btnSuma = new JButton("+");
        btnSuma.setBackground(new Color(233, 233, 233));
        btnSuma.setFont(new Font("MV Boli", Font.BOLD, 16));
        btnSuma.setBounds(275, 338, 60, 60);
        btnSuma.setEnabled(false);
        frame.getContentPane().add(btnSuma);

        btnIgual = new JButton("=");
        btnIgual.setFont(new Font("MV Boli", Font.BOLD, 20));
        btnIgual.setBounds(275, 408, 60, 60);
        frame.getContentPane().add(btnIgual);

        btnDivision = new JButton("/");
        btnDivision.setBackground(new Color(233, 233, 233));
        btnDivision.setFont(new Font("MV Boli", Font.BOLD, 16));
        btnDivision.setBounds(275, 125, 60, 60);
        btnDivision.setEnabled(false);
        frame.getContentPane().add(btnDivision);
        
        btnReset = new JButton("C");
        btnReset.setFont(new Font("MV Boli", Font.BOLD, 16));
        btnReset.setBounds(205, 125, 60, 60);
        btnReset.addActionListener(e -> resetearCalculadora());
        frame.getContentPane().add(btnReset);
        
        btnPorcentaje = new JButton("%");
        btnPorcentaje.setFont(new Font("MV Boli", Font.BOLD, 16));
        btnPorcentaje.setBounds(135, 125, 60, 60);
        btnPorcentaje.addActionListener(e -> calcularPorcentaje());
        frame.getContentPane().add(btnPorcentaje);
        
        btnRaizCuadrada = new JButton("√");
        btnRaizCuadrada.setFont(new Font("MV Boli", Font.BOLD, 16));
        btnRaizCuadrada.setBounds(65, 125, 60, 60);
        btnRaizCuadrada.addActionListener(e -> calcularRaizCuadrada());
        frame.getContentPane().add(btnRaizCuadrada);
        
        
     // ARRAY CON TODOS LOS NUMEROS DE LA CALCULADORA
        String[] numeros = {"7", "8", "9", "4", "5", "6", "1", "2", "3", "0"};
        JButton[] botonesNumeros = {btnNumeroSiete, btnNumeroOcho, btnNumeroNueve ,btnNumeroCuatro,btnNumeroCinco, btnNumeroSeis,btnNumeroUno,btnNumeroDos,btnNumeroTres, btnNumeroCero};
     
       // REALIZAMSO UN BUCLE PARA ASIGNAR EL ACCIONLISTENER A CADA BOTON
        for (int i = 0; i < numeros.length; i++) {
            int index = i; //  CAPTURAMOS EL VALOR DE I PARA CADA INTERACION
            botonesNumeros[i].addActionListener(e -> agregarNumero(numeros[index]));
        }

      
        
        // AÑADIMOS LA FUNCIONALIDAD AL BOTON DE LA COMA
        btnComa.addActionListener(e -> {
            if (!textAreaResultado.getText().contains(",")) {
            	textAreaResultado.setText(textAreaResultado.getText() + ",");
            }
        });
        
        JButton[] botonesOperadores = {btnSuma, btnResta, btnMultiplicacion, btnDivision};
        String[] operadores = {"+", "-", "X", "/"};

        for (int i = 0; i < operadores.length; i++) {
            int index = i;
            botonesOperadores[i].addActionListener(e -> seleccionarOperador(operadores[index]));
        }

             

     // AÑADIMOS LA FUNCIONALIDAD AL BOTON DE IGUAL
        btnIgual.addActionListener(e -> realizarOperacion());

        // FUNCINALODAD DEL BOTON POSITIVO Y NEGATIVO
        btnPositivoNegativo.addActionListener(e -> {
            String NumeroActual = textAreaResultado.getText();
            if (!NumeroActual.isEmpty() && !NumeroActual.equals("0")) {
                if (NumeroActual.startsWith("-")) {
                	textAreaResultado.setText(NumeroActual.substring(1));
                } else {
                	textAreaResultado.setText("-" + NumeroActual);
                }
            }
        });

       

              
    }

    private void agregarNumero(String numero) {
        if (operadorSeleccionado) {
        	textAreaResultado.setText("");
            operadorSeleccionado = false;
        }
        textAreaResultado.setText(textAreaResultado.getText() + numero);
        habilitarOperadores();
    }

    private void habilitarOperadores() {
    	boolean habilitar = !textAreaResultado.getText().isEmpty();
        JButton[] botones = {btnSuma, btnResta, btnMultiplicacion, btnDivision};

        for (int i = 0; i < botones.length; i++) {
            botones[i].setEnabled(habilitar);
        }
    }

    private void seleccionarOperador(String operadorSeleccionado) {
        primerNumero = Double.parseDouble(textAreaResultado.getText().replace(",", "."));
        operador = operadorSeleccionado;
        this.operadorSeleccionado = true;
        habilitarOperadores();
    }

    private void realizarOperacion() {
        segundoNumero = Double.parseDouble(textAreaResultado.getText().replace(",", "."));
        double resultado = 0;

        switch (operador) {
            case "+":
                resultado = primerNumero + segundoNumero;
                break;
            case "-":
                resultado = primerNumero - segundoNumero;
                break;
            case "X":
                resultado = primerNumero * segundoNumero;
                break;
            case "/":
                if (segundoNumero != 0) {
                    resultado = primerNumero / segundoNumero;
                } else {
                	
                	textAreaResultado.setText("Error,  division no permitida");
                	
                    return;
                }
                break;
        }
        
        // MOSTRAMOS SOLO LOS NUMERO ENTEROS EN EL RESULTADO SI NDECIMALES CON EL METODO MAS BAJO DESCRITO
        textAreaResultado.setText(formatearResultado(resultado));
    }

    //  METODO PARA AJUSTAR  EL PATRON Y  MOSTRAR SOLO ENTEROS SI LE RESULTADO ES ENTERO
    private String formatearResultado(double resultado) {
        DecimalFormat df = new DecimalFormat("#,###.###"); 
        return df.format(resultado);
    }

    private void calcularPorcentaje() {
    	try{
        if (!textAreaResultado.getText().isEmpty()) {
            double numero = Double.parseDouble(textAreaResultado.getText().replace(",", "."));
            double resultado = primerNumero * numero / 100;
            if (resultado < 0) {
                textAreaResultado.setText(formatearResultado(resultado) + " (descuento)");
            } else {
                textAreaResultado.setText(formatearResultado(resultado));
            }
        } 
        }catch (NumberFormatException e) {
            // CON ESTO MANEJAMOS EL FORMATO DE ERROR DE NUMERO
        	textAreaResultado.setText("Error");
		}
    }

    

    private void calcularRaizCuadrada() {
    	
        try {
            if (!textAreaResultado.getText().isEmpty()) {
                double numero = Double.parseDouble(textAreaResultado.getText().replace(",", "."));
                if (numero >= 0) {
                    double resultado = Math.sqrt(numero);
                    textAreaResultado.setText(formatearResultado(resultado));
                } else {
                	textAreaResultado.setText("No se puede realizar esta operacion");
                }
            }
        } catch (NumberFormatException e) {
        	textAreaResultado.setText("Error: Entrada inválida");
        }
    }

    private void resetearCalculadora() {
    	try {
    	textAreaResultado.setText("");
        primerNumero = 0;
        segundoNumero = 0;
        operador = "";
        operadorSeleccionado = false;
        habilitarOperadores();
        textAreaResultado.requestFocus();//  DESHABILITAMOS LOS NUMEROS DESPUES DE RESETEARLOS
    	} catch (Exception e) {
            // CONTROL DE ERRORES
            System.err.println("Error al resetear la calculadora: " + e.getMessage()); //  -- GETMESSAHE =>DEVOLUCION DEL STRING DE UNA CADENA DE CARACTERES
        }
    }
}
