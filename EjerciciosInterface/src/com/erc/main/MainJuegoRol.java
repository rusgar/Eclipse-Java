package com.erc.main;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;


import com.erc.model.JuegoDados;



public class MainJuegoRol {

    private JFrame frame;
    private JComboBox<String> comboBoxTipoDados;
    private JComboBox<String> comboBoxCantidadDados;
    private JTextField textFieldNumeroJugadores;
    private JTextArea textAreaResultado;
    private JLabel lblnumeroJugadores;
    private JButton btnTirada;
    private JButton btnRestear;

    private JuegoDados juegoDados;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                MainJuegoRol window = new MainJuegoRol();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Create the application.
     */
    public MainJuegoRol() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 650, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        lblnumeroJugadores = new JLabel("Numero de Jugadores");
        lblnumeroJugadores.setFont(new Font("MV Boli", Font.BOLD, 12));
        lblnumeroJugadores.setBounds(22, 21, 147, 14);
        frame.getContentPane().add(lblnumeroJugadores);

        textFieldNumeroJugadores = new JTextField();
        textFieldNumeroJugadores.setFont(new Font("MV Boli", Font.BOLD, 12));
        textFieldNumeroJugadores.setBounds(40, 62, 86, 20);
        frame.getContentPane().add(textFieldNumeroJugadores);
        textFieldNumeroJugadores.setColumns(10);
        
       

        JLabel lbltipoDados = new JLabel("Tipo de Dados");
        lbltipoDados.setFont(new Font("MV Boli", Font.BOLD, 12));
        lbltipoDados.setBounds(22, 242, 125, 14);
        frame.getContentPane().add(lbltipoDados);

        comboBoxTipoDados = new JComboBox<>();
        comboBoxTipoDados.setFont(new Font("MV Boli", Font.BOLD, 12));
        comboBoxTipoDados.setModel(new DefaultComboBoxModel<>(new String[] {"", "4", "6", "8", "10", "12", "18", "20"}));
        comboBoxTipoDados.setBounds(22, 294, 80, 22);
        frame.getContentPane().add(comboBoxTipoDados);

        JLabel lblnumeroDados = new JLabel("Cantidad de dados");
        lblnumeroDados.setFont(new Font("MV Boli", Font.BOLD, 12));
        lblnumeroDados.setForeground(new Color(64, 0, 64));
        lblnumeroDados.setBackground(new Color(0, 128, 0));
        lblnumeroDados.setBounds(157, 242, 125, 14);
        frame.getContentPane().add(lblnumeroDados);

        comboBoxCantidadDados = new JComboBox<>();
        comboBoxCantidadDados.setFont(new Font("MV Boli", Font.BOLD, 12));
        comboBoxCantidadDados.setModel(new DefaultComboBoxModel<>(new String[] {"", "1", "2", "3", "4", "5", "6"}));
        comboBoxCantidadDados.setBounds(170, 294, 80, 22);
        frame.getContentPane().add(comboBoxCantidadDados);

        btnTirada = new JButton("");
        btnTirada.setIcon(new ImageIcon(MainJuegoRol.class.getResource("/images/Lanzar_Dados.png")));
        btnTirada.setEnabled(false);
        btnTirada.setFont(new Font("MV Boli", Font.BOLD, 12));
        btnTirada.setBounds(559, 242, 50, 50);
        frame.getContentPane().add(btnTirada);

        btnRestear = new JButton("");
        btnRestear.setIcon(new ImageIcon(MainJuegoRol.class.getResource("/images/borrar.png")));
        btnRestear.setFont(new Font("MV Boli", Font.BOLD, 12));
        btnRestear.setBounds(561, 302, 48, 48);
        frame.getContentPane().add(btnRestear);

        textAreaResultado = new JTextArea();
        textAreaResultado.setForeground(Color.BLACK);
        textAreaResultado.setLineWrap(true);
        textAreaResultado.setWrapStyleWord(true);
        textAreaResultado.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
        textAreaResultado.setEditable(false);
        textAreaResultado.setEnabled(false);
        textAreaResultado.setBounds(361, 48, 248, 157);
        frame.getContentPane().add(textAreaResultado);

        JLabel lblFondo = new JLabel("");
        lblFondo.setIcon(new ImageIcon(MainJuegoRol.class.getResource("/images/dados.gif")));
        lblFondo.setBounds(0, 0, 634, 361);
        frame.getContentPane().add(lblFondo);

        textFieldNumeroJugadores.addActionListener(e -> verificacionCampos());
        comboBoxCantidadDados.addActionListener(e -> verificacionCampos());
        btnTirada.addActionListener(e -> lanzarDados());
        btnRestear.addActionListener(e -> restablecerCampos());

        frame.setVisible(true);
    }

    // Verificar si se han completado todos los campos
    private void verificacionCampos() {
        boolean enabled = !textFieldNumeroJugadores.getText().isEmpty() &&
                comboBoxCantidadDados.getSelectedItem() != null &&
                !comboBoxCantidadDados.getSelectedItem().toString().isEmpty() &&
                comboBoxTipoDados.getSelectedItem() != null &&
                !comboBoxTipoDados.getSelectedItem().toString().isEmpty();
        btnTirada.setEnabled(enabled);
    }

    // Método para lanzar los dados y mostrar el resultado
    private void lanzarDados() {
        try {
            int numeroJugadores = Integer.parseInt(textFieldNumeroJugadores.getText());
            int cantidadDados = Integer.parseInt(comboBoxCantidadDados.getSelectedItem().toString());
            int tipoDado = Integer.parseInt(comboBoxTipoDados.getSelectedItem().toString());

            // Crear instancia de JuegoDados
            juegoDados = new JuegoDados(numeroJugadores, cantidadDados, tipoDado);
            juegoDados.lanzarDados();

            // Obtener resultados
            int jugadorGanador = juegoDados.getJugadorGanador();
            int puntuacionMaxima = juegoDados.getPuntuacionMaxima();
            int puntuacionMaximaPosible = juegoDados.getPuntuacionMaximaPosible();
            List<Integer> combinacionGanadora = juegoDados.getCombinacionGanadora();
            String combinacionGanadoraStr = String.join(" | ", combinacionGanadora.stream().map(String::valueOf).toArray(String[]::new));

            // Mostrar resultados en el textArea
            textAreaResultado.setForeground(Color.BLACK);
            textAreaResultado.setText(
                "Resultado Final:\n" +
                "-----------------------------\n" +
                "Jugador ganador: Jugador " + jugadorGanador + "\n" +
                "Puntuación máxima obtenida: " + puntuacionMaxima + "\n" +
                "Combinación de dados del jugador ganador: " + combinacionGanadoraStr +
                "Puntuación máxima posible: " + puntuacionMaximaPosible + "\n" 
                
            );

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Por favor, ingrese números válidos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para restablecer los campos y el área de resultados
    private void restablecerCampos() {
        textFieldNumeroJugadores.setText("");
        comboBoxCantidadDados.setSelectedIndex(0);
        comboBoxTipoDados.setSelectedIndex(0);
        textAreaResultado.setText("");
        btnTirada.setEnabled(false);
    }
}
