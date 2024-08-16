package com.erc.model;

import javax.swing.JButton;
import javax.swing.JTextField;

public class Geometria {
	
	//ATRIBUTOS
    private double base;
    private double altura;
    private double lado1;
    private double lado2;

  
    //  GETTERS Y SETTERS
    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getLado1() {
        return lado1;
    }

    public void setLado1(double lado1) {
        this.lado1 = lado1;
    }

    public double getLado2() {
        return lado2;
    }

    public void setLado2(double lado2) {
        this.lado2 = lado2;
    }

    
     // CONSTRUCTORES
    public Geometria() {
		super();
		this.base = 0.0;
		this.altura = 0.0;
		this.lado1 = 0.0;
		this.lado2 = 0.0;
	}
    
    

	public Geometria(double base, double altura, double lado1, double lado2) {
		super();
		this.base = base;
		this.altura = altura;
		this.lado1 = lado1;
		this.lado2 = lado2;
	}

	
	// METODO PARA CALCULAS LAS OPERACIONES DE AREA Y PERIMERTO SEGUN LAS NECESIDADES
	public double calcularOperacion(String figuraGeometrica, String operacion) {
	    switch (figuraGeometrica) {
	        case "Rectangulo":
	            if (operacion.equals("area")) {
	                return base * altura;
	            } else {
	                return 2 * (base + altura);
	            }
	        case "Circulo":
	            if (operacion.equals("area")) {
	                return Math.PI * base * base;
	            } else {
	                return 2 * Math.PI * base;
	            }
	        case "Triangulo":
	            if (operacion.equals("area")) {
	                return (base * altura) / 2;
	            } else {
	                return base + lado1 + lado2;
	            }
	        default:
	            throw new IllegalArgumentException("Figura no válida: " + figuraGeometrica);
	    }
	}

    
    
    

	// METODO PARA OBTENER LA RUTA DE LA IMAGEN SEGUN LA FIGURA GEOMETRICA
    public String obtenerImagen(String figura) {
        switch (figura) {
            case "Rectángulo":
                return "/images/Rectangulo.png";
            case "Círculo":
                return "/images/Circulo.png";
            case "Triángulo":
                return "/images/Triangulo.png";
            default:
                return "";
        }
    }
    
    
 
    // METODO PARA OBTENER EL NOMBRE DE LA FIGURA SELECCIONADA SEGUN EL RADIOBUTTON, QUE SON BOLEANOS
    public String obtenerNombreFigura(boolean RbtRectangulo, boolean RbtCirculo, boolean RbtTrinagulo) {
        if (RbtRectangulo) {
            return "Rectángulo";
        } else if (RbtCirculo) {
            return "Círculo";
        } else if (RbtTrinagulo) {
            return "Triángulo";
        } else {
            throw new IllegalArgumentException("Ninguna figura seleccionada");
        }
    }
    
    
    
    // REALIZAMOS OTRA CLASE PARA LAS INVALIDACIONES DE NUMERO O DE LETRAS, PARA DESPUES LLAMARLAS EN EL MAIN
    
    public class InputValidator {

      

        // Método para actualizar la habilitación de los campos de texto y el botón
    	// METODO PARA HABILITAR CADA UNO DE LOS CAMPOS QUE VAMOS A UTILIZAR SI TIENEN ALGUN VALOR, PERMITESEGUIR AL SIGUIENTE
    	// SEGUIR AL SIGUEINTE, 
        public static void actualizarCampos(JTextField textBaseNumero, JTextField textAlturaNumero, JTextField textLado1Numero, JTextField textLado2Numero, JButton btnCalcular) {
            textAlturaNumero.setEditable(!textBaseNumero.getText().isEmpty());
            textLado1Numero.setEditable(!textAlturaNumero.getText().isEmpty());
            textLado2Numero.setEditable(!textLado1Numero.getText().isEmpty());
            btnCalcular.setEnabled(!textLado2Numero.getText().isEmpty());
        }

        // Método para convertir el texto de un campo de texto en un valor double
        public static double getDoubleFromTextField(JTextField textField) {
            String text = textField.getText().trim();
            return text.isEmpty() ? 0 : Double.parseDouble(text);
        }
    }
    
    
}
