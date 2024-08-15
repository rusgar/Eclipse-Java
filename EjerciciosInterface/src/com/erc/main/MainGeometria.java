package com.erc.main;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JTextArea;
import com.erc.model.Geometria;
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
    private JTextArea textAreaImagen;
    private Geometria geometria; // Instancia de la clase de modelo

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainGeometria window = new MainGeometria();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public MainGeometria() {
        geometria = new Geometria(); // Crear la instancia de la clase de modelo
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

        textBaseNumero = new JTextField();
        textBaseNumero.setForeground(Color.WHITE);
        textBaseNumero.setBackground(Color.DARK_GRAY);
        textBaseNumero.setBounds(26, 64, 86, 20);
        frame.getContentPane().add(textBaseNumero);
        textBaseNumero.setColumns(10);

        textAlturaNumero = new JTextField();
        textAlturaNumero.setForeground(Color.WHITE);
        textAlturaNumero.setBackground(Color.DARK_GRAY);
        textAlturaNumero.setColumns(10);
        textAlturaNumero.setBounds(26, 150, 86, 20);
        frame.getContentPane().add(textAlturaNumero);

        textLado1Numero = new JTextField();
        textLado1Numero.setForeground(Color.WHITE);
        textLado1Numero.setBackground(Color.DARK_GRAY);
        textLado1Numero.setColumns(10);
        textLado1Numero.setBounds(26, 225, 86, 20);
        frame.getContentPane().add(textLado1Numero);

        textLado2Numero = new JTextField();
        textLado2Numero.setForeground(Color.WHITE);
        textLado2Numero.setBackground(Color.DARK_GRAY);
        textLado2Numero.setColumns(10);
        textLado2Numero.setBounds(26, 307, 86, 20);
        frame.getContentPane().add(textLado2Numero);

        JLabel lblPerimetro = new JLabel("Perimetro");
        lblPerimetro.setBounds(165, 310, 70, 14);
        frame.getContentPane().add(lblPerimetro);

        textPerimetroResultado = new JTextField();
        textPerimetroResultado.setColumns(10);
        textPerimetroResultado.setBounds(460, 307, 86, 20);
        frame.getContentPane().add(textPerimetroResultado);

        JLabel lblArea = new JLabel("Area");
        lblArea.setBounds(352, 310, 46, 14);
        frame.getContentPane().add(lblArea);

        textAreaResultado = new JTextField();
        textAreaResultado.setColumns(10);
        textAreaResultado.setBounds(244, 307, 86, 20);
        frame.getContentPane().add(textAreaResultado);

        JLabel lblFigura = new JLabel("Figura");
        lblFigura.setBounds(222, 35, 46, 14);
        frame.getContentPane().add(lblFigura);

        radioButtonRectangulo = new JRadioButton("Rectangulo");
        radioButtonRectangulo.setBackground(Color.CYAN);
        buttonGroup.add(radioButtonRectangulo);
        radioButtonRectangulo.setBounds(221, 63, 109, 23);
        frame.getContentPane().add(radioButtonRectangulo);

        radioButtonCirculo = new JRadioButton("Circulo");
        radioButtonCirculo.setBackground(Color.CYAN);
        buttonGroup.add(radioButtonCirculo);
        radioButtonCirculo.setBounds(221, 105, 109, 23);
        frame.getContentPane().add(radioButtonCirculo);

        radioButtonTriangulo = new JRadioButton("Triangulo");
        radioButtonTriangulo.setBackground(Color.CYAN);
        buttonGroup.add(radioButtonTriangulo);
        radioButtonTriangulo.setBounds(222, 149, 109, 23);
        frame.getContentPane().add(radioButtonTriangulo);

        textAreaImagen = new JTextArea();
        textAreaImagen.setBounds(416, 35, 130, 164);
        frame.getContentPane().add(textAreaImagen);

        JButton btnMedida = new JButton("");
        btnMedida.setIcon(new ImageIcon(MainGeometria.class.getResource("/images/Regla.png")));
        btnMedida.setBounds(280, 225, 50, 50);
        frame.getContentPane().add(btnMedida);

        // Añade el fondo después de todos los demás componentes
        JLabel lblFondo = new JLabel("");
        lblFondo.setForeground(Color.WHITE);
        lblFondo.setBackground(Color.DARK_GRAY);
        lblFondo.setIcon(new ImageIcon(MainGeometria.class.getResource("/images/fondo.gif")));
        lblFondo.setBounds(0, 0, 600, 400);
        frame.getContentPane().add(lblFondo);

        btnMedida.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularMedidas();
            }
        });
    }
    private void calcularMedidas() {
        double base = 0, altura = 0, lado1 = 0, lado2 = 0;
        String figura = "";

        // Leer valores de los campos de texto
        if (textBaseNumero.isVisible() && textBaseNumero.getText().trim().length() > 0) {
            base = Double.parseDouble(textBaseNumero.getText());
        }
        if (textAlturaNumero.isVisible() && textAlturaNumero.getText().trim().length() > 0) {
            altura = Double.parseDouble(textAlturaNumero.getText());
        }
        if (textLado1Numero.isVisible() && textLado1Numero.getText().trim().length() > 0) {
            lado1 = Double.parseDouble(textLado1Numero.getText());
        }
        if (textLado2Numero.isVisible() && textLado2Numero.getText().trim().length() > 0) {
            lado2 = Double.parseDouble(textLado2Numero.getText());
        }

        // Actualizar los valores en la instancia de Geometria
        geometria.setBase(base);
        geometria.setAltura(altura);
        geometria.setLado1(lado1);
        geometria.setLado2(lado2);

        if (radioButtonRectangulo.isSelected()) {
            figura = "Rectangulo";
        } else if (radioButtonCirculo.isSelected()) {
            figura = "Circulo";
        } else if (radioButtonTriangulo.isSelected()) {
            figura = "Triangulo";
        }

        // Obtener resultados del modelo
        double[] resultados = geometria.calcularMedidas(figura);

        // Mostrar los resultados
        textAreaResultado.setText(String.format("%.2f", resultados[0])); // Área
        textPerimetroResultado.setText(String.format("%.2f", resultados[1])); // Perímetro

        // Actualizar el JTextArea para mostrar la figura seleccionada
        textAreaImagen.setText("Figura: " + figura);
    }

}
