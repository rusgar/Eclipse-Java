package com.erc.main;

import java.awt.Color;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class MainTipoLetraClases {

	private JFrame frame;
	private JTextField txtfieldTipo;
	private JTextField txtfieldTamaño;
	private JTextField txtfieldEstilo;
	private JTextArea txtAreaGuardado;
	private JTextArea txtAreaConfigurado;
	private JButton btnGuardar;
	private JButton btnMostrar;
	private JButton btnAplicar;
	private final ButtonGroup rdbtngColorLetra = new ButtonGroup();
	
	String tipo;
	int estilo;
	int tamaño;
	Color color;
	// usar clase TipoLetra
	private TipoLetra tipoLetra = new TipoLetra(tipo, estilo, tamaño, color);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainTipoLetraClases window = new MainTipoLetraClases();
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
	public MainTipoLetraClases() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 526, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtAreaGuardado = new JTextArea();
		txtAreaGuardado.setWrapStyleWord(true);
		txtAreaGuardado.setLineWrap(true);
		txtAreaGuardado.setText("FUENTE GUARDADA");
		txtAreaGuardado.setBounds(357, 23, 127, 58);
		frame.getContentPane().add(txtAreaGuardado);
		
		txtAreaConfigurado = new JTextArea();
		txtAreaConfigurado.setWrapStyleWord(true);
		txtAreaConfigurado.setText("FUENTE CONFIGURADA");
		txtAreaConfigurado.setLineWrap(true);
		txtAreaConfigurado.setBounds(357, 152, 127, 58);
		frame.getContentPane().add(txtAreaConfigurado);
		
		
		txtfieldTipo = new JTextField();
		txtfieldTipo.setBounds(59, 42, 127, 20);
		frame.getContentPane().add(txtfieldTipo);
		txtfieldTipo.setColumns(10);
				
		txtfieldTamaño = new JTextField();
		txtfieldTamaño.setColumns(10);
		txtfieldTamaño.setBounds(59, 124, 127, 20);
		frame.getContentPane().add(txtfieldTamaño);
		
		txtfieldEstilo = new JTextField();
		txtfieldEstilo.setColumns(10);
		txtfieldEstilo.setBounds(59, 82, 127, 20);
		frame.getContentPane().add(txtfieldEstilo);
		
		
		JLabel lblNewLabel = new JLabel("Tipo:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		lblNewLabel.setBounds(10, 45, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblTamao = new JLabel("Tamaño:");
		lblTamao.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		lblTamao.setBounds(10, 127, 46, 14);
		frame.getContentPane().add(lblTamao);
		
		JLabel lblEstilo = new JLabel("Estilo:");
		lblEstilo.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		lblEstilo.setBounds(10, 85, 46, 14);
		frame.getContentPane().add(lblEstilo);
		
		JRadioButton rdbtnRojo = new JRadioButton("Rojo");
		rdbtnRojo.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		rdbtngColorLetra.add(rdbtnRojo);
		rdbtnRojo.setBounds(238, 56, 98, 23);
		frame.getContentPane().add(rdbtnRojo);
		
		JRadioButton rdbtnAzul = new JRadioButton("Azul");
		rdbtnAzul.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		rdbtngColorLetra.add(rdbtnAzul);
		rdbtnAzul.setBounds(238, 82, 98, 23);
		frame.getContentPane().add(rdbtnAzul);
		
		JRadioButton rdbtnMagenta = new JRadioButton("Magenta");
		rdbtnMagenta.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		rdbtngColorLetra.add(rdbtnMagenta);
		rdbtnMagenta.setBounds(238, 106, 98, 23);
		frame.getContentPane().add(rdbtnMagenta);
		
		JRadioButton rdbtnVerde = new JRadioButton("Verde");
		rdbtnVerde.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		rdbtngColorLetra.add(rdbtnVerde);
		rdbtnVerde.setBounds(238, 132, 98, 23);
		frame.getContentPane().add(rdbtnVerde);
		
		JLabel lblColor = new JLabel("Color:");
		lblColor.setBounds(238, 35, 46, 14);
		frame.getContentPane().add(lblColor);
		
		// BOTON DE APLICAR
		btnAplicar = new JButton("Aplicar");
		btnAplicar.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		btnAplicar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// obtener tipo
				tipo = txtfieldTipo.getText();				
				// obtener estilo
				switch (txtfieldEstilo.getText().toLowerCase()) {
                case "plain":
                    estilo = Font.PLAIN;
                    break;
                case "bold":
                    estilo = Font.BOLD;
                    break;
                case "italic":
                    estilo = Font.ITALIC;
                    break;
                case "bold+italic":
                    estilo = Font.BOLD | Font.ITALIC;
                    break;
                default:
                    JOptionPane.showMessageDialog(frame, "Estilo desconocido. Usa 'plain', 'bold', 'italic', o 'bold+italic'.", 
                    		"Aviso", JOptionPane.ERROR_MESSAGE);
                    return;
            }
				// obtener tamaño
				tamaño = Integer.parseInt(txtfieldTamaño.getText());
				
				// obtener color
				if (rdbtnRojo.isSelected()) {
                    color = Color.RED;
                } else if (rdbtnAzul.isSelected()) {
                    color = Color.BLUE;
                } else if (rdbtnMagenta.isSelected()) {
                    color = Color.MAGENTA;
                } else if (rdbtnVerde.isSelected()) {
                    color = Color.GREEN;
                }
			
				//aplicarlo a la fuente
				Font fuente = new Font(tipo, estilo,tamaño);
				txtAreaConfigurado.setFont(fuente);		
				txtAreaConfigurado.setForeground(color);	
			}
		});
		
		btnAplicar.setBounds(370, 227, 89, 23);
		frame.getContentPane().add(btnAplicar);
		
		// BOTON DE GUARDAR
		btnGuardar = new JButton("Guardar fuente");
		btnGuardar.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// obtener tipo
				tipoLetra.setTipo(txtfieldTipo.getText());
				
				// obtener estilo
				switch (txtfieldEstilo.getText().toLowerCase()) {
                case "plain":
                	tipoLetra.setEstilo(Font.PLAIN);
                    break;
                case "bold":
                	tipoLetra.setEstilo(Font.BOLD);
                    break;
                case "italic":
                	tipoLetra.setEstilo(Font.ITALIC);
                    break;
                case "bold+italic":
                	tipoLetra.setEstilo(Font.BOLD | Font.ITALIC);
                    break;
                default:
                    JOptionPane.showMessageDialog(frame, "Estilo desconocido. Usa 'plain', 'bold', 'italic', o 'bold+italic'.", 
                    		"Aviso", JOptionPane.ERROR_MESSAGE);
                    return;
            }
				// obtener tamaño
				tipoLetra.setTamaño(Integer.parseInt(txtfieldTamaño.getText()));
				
				// obtener color
				if (rdbtnRojo.isSelected()) {
					tipoLetra.setColor(Color.RED);
                } else if (rdbtnAzul.isSelected()) {
                	tipoLetra.setColor(Color.BLUE);
                } else if (rdbtnMagenta.isSelected()) {
                	tipoLetra.setColor(Color.MAGENTA);
                } else if (rdbtnVerde.isSelected()) {
                	tipoLetra.setColor(Color.GREEN);
                }	
			}
		});
		
		btnGuardar.setBounds(120, 175, 155, 23);
		frame.getContentPane().add(btnGuardar);
		
		
		// BOTON DE MOSTRAR GUARDADO
		btnMostrar = new JButton("Mostrar guardado");
		btnMostrar.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		btnMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtAreaGuardado.setFont(tipoLetra.obtenerTipoLetra());
				txtAreaGuardado.setForeground(tipoLetra.getColor());
			}
		});
		btnMostrar.setBounds(357, 92, 127, 23);
		frame.getContentPane().add(btnMostrar);
	}
	
}
