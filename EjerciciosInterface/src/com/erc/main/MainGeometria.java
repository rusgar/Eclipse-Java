package com.erc.main;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import com.erc.helpers.CommonHelpers;
import com.erc.model.Geometria;
import com.erc.model.Geometria.InputValidator;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.Color;

public class MainGeometria {

    private JFrame frame;
    private JTextField textBaseNumero;
    private JTextField textAlturaNumero;
    private JTextField textLado1Numero;
    private JTextField textLado2Numero;
    private JRadioButton radioButtonRectangulo, radioButtonCirculo, radioButtonTriangulo;
    private final ButtonGroup buttonGroup = new ButtonGroup();
    private JTextField textAreaResultado;
    private JTextField textPerimetroResultado;
    private JButton btnCalcular;
    private Geometria geometria;
    private CommonHelpers ayudaHelpers;
    private JLabel lblFiguraImagen;
    private boolean calculado; // Variable para indicar si ya se calculó el resultado

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                MainGeometria window = new MainGeometria();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public MainGeometria() {
        geometria = new Geometria();
        ayudaHelpers = new CommonHelpers();
        calculado = false; // Inicializar como falso
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblBase = new JLabel("Base");
        lblBase.setBounds(26, 35, 46, 14);
        frame.getContentPane().add(lblBase);

        JLabel lblAltura = new JLabel("Altura");
        lblAltura.setBounds(26, 109, 46, 14);
        frame.getContentPane().add(lblAltura);

        JLabel lblLado1 = new JLabel("Lado1");
        lblLado1.setBounds(26, 200, 46, 14);
        frame.getContentPane().add(lblLado1);

        JLabel lblLado2 = new JLabel("Lado2");
        lblLado2.setBounds(26, 280, 46, 14);
        frame.getContentPane().add(lblLado2);

        JLabel lblPerimetro = new JLabel("Perímetro");
        lblPerimetro.setBounds(165, 310, 70, 14);
        frame.getContentPane().add(lblPerimetro);

        JLabel lblArea = new JLabel("Área");
        lblArea.setBounds(352, 310, 46, 14);
        frame.getContentPane().add(lblArea);

        JLabel lblFigura = new JLabel("Figura");
        lblFigura.setBounds(222, 35, 46, 14);
        frame.getContentPane().add(lblFigura);

        textBaseNumero = new JTextField();
        textBaseNumero.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                handleKeyTyped(e, textBaseNumero);
            }
        });
        textBaseNumero.setForeground(Color.WHITE);
        textBaseNumero.setBackground(Color.DARK_GRAY);
        textBaseNumero.setBounds(26, 64, 86, 20);
        frame.getContentPane().add(textBaseNumero);
        textBaseNumero.setColumns(10);

        textAlturaNumero = new JTextField();
        textAlturaNumero.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                handleKeyTyped(e, textAlturaNumero);
            }
        });
        textAlturaNumero.setForeground(Color.WHITE);
        textAlturaNumero.setBackground(Color.DARK_GRAY);
        textAlturaNumero.setColumns(10);
        textAlturaNumero.setBounds(26, 150, 86, 20);
        frame.getContentPane().add(textAlturaNumero);

        textLado1Numero = new JTextField();
        textLado1Numero.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                handleKeyTyped(e, textLado1Numero);
            }
        });
        textLado1Numero.setForeground(Color.WHITE);
        textLado1Numero.setBackground(Color.DARK_GRAY);
        textLado1Numero.setColumns(10);
        textLado1Numero.setBounds(26, 225, 86, 20);
        frame.getContentPane().add(textLado1Numero);

        textLado2Numero = new JTextField();
        textLado2Numero.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                handleKeyTyped(e, textLado2Numero);
            }
        });
        textLado2Numero.setForeground(Color.WHITE);
        textLado2Numero.setBackground(Color.DARK_GRAY);
        textLado2Numero.setColumns(10);
        textLado2Numero.setBounds(26, 307, 86, 20);
        frame.getContentPane().add(textLado2Numero);

        textPerimetroResultado = new JTextField();
        textPerimetroResultado.setEditable(false);
        textPerimetroResultado.setColumns(10);
        textPerimetroResultado.setBounds(460, 307, 86, 20);
        frame.getContentPane().add(textPerimetroResultado);

        textAreaResultado = new JTextField();
        textAreaResultado.setEditable(false);
        textAreaResultado.setColumns(10);
        textAreaResultado.setBounds(244, 307, 86, 20);
        frame.getContentPane().add(textAreaResultado);

        radioButtonRectangulo = new JRadioButton("Rectángulo");
        radioButtonRectangulo.setBackground(Color.CYAN);
        buttonGroup.add(radioButtonRectangulo);
        radioButtonRectangulo.setBounds(221, 63, 109, 23);
        frame.getContentPane().add(radioButtonRectangulo);
        radioButtonRectangulo.addActionListener(e -> onRadioButtonSelected());

        radioButtonCirculo = new JRadioButton("Círculo");
        radioButtonCirculo.setBackground(Color.CYAN);
        buttonGroup.add(radioButtonCirculo);
        radioButtonCirculo.setBounds(221, 105, 109, 23);
        frame.getContentPane().add(radioButtonCirculo);
        radioButtonCirculo.addActionListener(e -> onRadioButtonSelected());

        radioButtonTriangulo = new JRadioButton("Triángulo");
        radioButtonTriangulo.setBackground(Color.CYAN);
        buttonGroup.add(radioButtonTriangulo);
        radioButtonTriangulo.setBounds(222, 149, 109, 23);
        frame.getContentPane().add(radioButtonTriangulo);
        radioButtonTriangulo.addActionListener(e -> onRadioButtonSelected());

        lblFiguraImagen = new JLabel();
        lblFiguraImagen.setBounds(385, 67, 96, 83); 
        frame.getContentPane().add(lblFiguraImagen);

        btnCalcular = new JButton("");
        btnCalcular.setEnabled(false);
        btnCalcular.setIcon(new ImageIcon(getClass().getResource("/images/Regla.png")));
        btnCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                actualizarResultados();
                calculado = true; // Marcar que ya se ha calculado
            }
        });
        btnCalcular.setBounds(261, 224, 89, 23);
        frame.getContentPane().add(btnCalcular);

        JLabel lblFondo = new JLabel("");
        lblFondo.setForeground(Color.WHITE);
        lblFondo.setBackground(Color.DARK_GRAY);
        lblFondo.setIcon(new ImageIcon(MainGeometria.class.getResource("/images/fondo.gif")));
        lblFondo.setBounds(0, 0, 600, 400);
        frame.getContentPane().add(lblFondo);
    }

    private void handleKeyTyped(KeyEvent e, JTextField textField) {
        String textoLeido = textField.getText();
        char caracterLeido = e.getKeyChar();
        textoLeido = ayudaHelpers.soloNumeros(textoLeido, caracterLeido);
        textField.setText(textoLeido);
        e.consume();
        InputValidator.actualizarCampos(textBaseNumero, textAlturaNumero, textLado1Numero, textLado2Numero, btnCalcular);
    }
    


    private void onRadioButtonSelected() {
        if (calculado) { // Solo actualizar si ya se ha calculado previamente
            actualizarResultados();
        }
    }

    private void actualizarFiguraImagen() {
        String figura = geometria.obtenerNombreFigura(radioButtonRectangulo.isSelected(), radioButtonCirculo.isSelected(), radioButtonTriangulo.isSelected());
        String imagenPath = geometria.obtenerImagen(figura);

        if (!imagenPath.isEmpty()) {
            try {
                InputStream is = getClass().getResourceAsStream(imagenPath);
                BufferedImage img = ImageIO.read(is);
                ImageIcon icon = new ImageIcon(img);
                lblFiguraImagen.setIcon(icon);
            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "No se pudo cargar la imagen.");
            }
        }
    }

    private void actualizarResultados() {
        try {
            double base = InputValidator.getDoubleFromTextField(textBaseNumero);
            double altura = InputValidator.getDoubleFromTextField(textAlturaNumero);
            double lado1 = InputValidator.getDoubleFromTextField(textLado1Numero);
            double lado2 = InputValidator.getDoubleFromTextField(textLado2Numero);

            geometria.setBase(base);
            geometria.setAltura(altura);
            geometria.setLado1(lado1);
            geometria.setLado2(lado2);

            String tipoFigura = "";
            String tipoOperacion = "";

            if (radioButtonRectangulo.isSelected()) {
                tipoFigura = "Rectangulo";
            } else if (radioButtonCirculo.isSelected()) {
                tipoFigura = "Circulo";
            } else if (radioButtonTriangulo.isSelected()) {
                tipoFigura = "Triangulo";
            } else {
                return; // Ninguna figura seleccionada, salir del método
            }

            tipoOperacion = "area"; // Por defecto, calculamos el área

            double area = geometria.calcularOperacion(tipoFigura, tipoOperacion);
            textAreaResultado.setText(String.format("%.2f", area));

            tipoOperacion = "perimetro"; // Ahora calculamos el perímetro

            double perimetro = geometria.calcularOperacion(tipoFigura, tipoOperacion);
            textPerimetroResultado.setText(String.format("%.2f", perimetro));

            actualizarFiguraImagen();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Por favor, ingrese valores numéricos válidos.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error: " + ex.getMessage());
        }
    }


   
}
