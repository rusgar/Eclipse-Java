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
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.Color;
import com.erc.helpers.CommonHelpers;
import com.erc.model.Geometria;

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
    private JButton btnReset;
    private Geometria geometria;
    private CommonHelpers ayudaHelpers;
    private JLabel lblFiguraImagen;
    private boolean calculado;
    private Geometria.validacionCampos validacion;

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
        calculado = false;
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
        textPerimetroResultado.setBounds(408, 307, 86, 20);
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
        radioButtonRectangulo.addActionListener(e -> selectorRadioButton());

        radioButtonCirculo = new JRadioButton("Círculo");
        radioButtonCirculo.setBackground(Color.CYAN);
        buttonGroup.add(radioButtonCirculo);
        radioButtonCirculo.setBounds(221, 105, 109, 23);
        frame.getContentPane().add(radioButtonCirculo);
        radioButtonCirculo.addActionListener(e -> selectorRadioButton());

        radioButtonTriangulo = new JRadioButton("Triángulo");
        radioButtonTriangulo.setBackground(Color.CYAN);
        buttonGroup.add(radioButtonTriangulo);
        radioButtonTriangulo.setBounds(222, 149, 109, 23);
        frame.getContentPane().add(radioButtonTriangulo);
        radioButtonTriangulo.addActionListener(e -> selectorRadioButton());

       

        lblFiguraImagen = new JLabel();
        lblFiguraImagen.setBounds(385, 67, 96, 83);
        frame.getContentPane().add(lblFiguraImagen);

        btnCalcular = new JButton("");
        btnCalcular.setEnabled(false);
        btnCalcular.setIcon(new ImageIcon(MainGeometria.class.getResource("/images/Regla.png")));
        btnCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                actualizarResultados();
                calculado = true;
            }
        });
        btnCalcular.setBounds(416, 212, 65, 65);
        frame.getContentPane().add(btnCalcular);

        btnReset = new JButton("");
        btnReset.setIcon(new ImageIcon(MainGeometria.class.getResource("/images/borrar.png")));
        btnReset.addActionListener(e -> resetearCampos());
        btnReset.setBounds(521, 289, 35, 35);
        frame.getContentPane().add(btnReset);

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

        validacion = geometria.new validacionCampos(textBaseNumero, textAlturaNumero, textLado1Numero, textLado2Numero, btnCalcular);
        validacion.actualizarCampos();
    }

    private void selectorRadioButton() {
    	   if (calculado) { 
    	        actualizarResultados();
    	    }
    }
    private void actualizarFiguraImagen() {
        String figura = geometria.obtenerNombreFigura(radioButtonRectangulo.isSelected(),
                                                    radioButtonCirculo.isSelected(),
                                                    radioButtonTriangulo.isSelected());
       
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
        } else {
            lblFiguraImagen.setIcon(null);
        }
    }

    private void actualizarResultados() {
        try {
            // Verifica si los campos necesarios tienen valores antes de continuar
            if (textBaseNumero.getText().isEmpty() || textAlturaNumero.getText().isEmpty() || 
                textLado1Numero.getText().isEmpty() || textLado2Numero.getText().isEmpty()) {
                // Si faltan campos, no calculamos nada y no mostramos la imagen
                return;
            }

            double base = ayudaHelpers.getDoubleFromTextField(textBaseNumero);
            double altura = ayudaHelpers.getDoubleFromTextField(textAlturaNumero);
            double lado1 = ayudaHelpers.getDoubleFromTextField(textLado1Numero);
            double lado2 = ayudaHelpers.getDoubleFromTextField(textLado2Numero);

            geometria.setBase(base);
            geometria.setAltura(altura);
            geometria.setLado1(lado1);
            geometria.setLado2(lado2);

            String tipoFigura = geometria.obtenerTipoFiguraSeleccionada(
                radioButtonRectangulo.isSelected(),
                radioButtonCirculo.isSelected(),
                radioButtonTriangulo.isSelected()
            );

            if (tipoFigura.isEmpty()) {
                return;
            }

            // Actualizar campos con los resultados
            actualizarCampoOperacion(tipoFigura, "area", textAreaResultado);
            actualizarCampoOperacion(tipoFigura, "perimetro", textPerimetroResultado);

            // Actualizar la imagen de la figura después de que los cálculos se hayan realizado correctamente
            actualizarFiguraImagen();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Por favor, ingrese valores numéricos válidos.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error: " + ex.getMessage());
        }
    }


    private void actualizarCampoOperacion(String tipoFigura, String tipoOperacion, JTextField campoResultado) {
        double resultado = geometria.calcularOperacion(tipoFigura, tipoOperacion);
        campoResultado.setText(String.format("%.2f", resultado));
    }

    private void resetearCampos() {
        textBaseNumero.setText("");
        textAlturaNumero.setText("");
        textLado1Numero.setText("");
        textLado2Numero.setText("");
        textAreaResultado.setText("");
        textPerimetroResultado.setText("");
        buttonGroup.clearSelection();
        lblFiguraImagen.setIcon(null);
        btnCalcular.setEnabled(false);
        calculado = false;
    }
}
