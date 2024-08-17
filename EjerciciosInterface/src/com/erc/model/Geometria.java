package com.erc.model;

import javax.swing.JButton;
import javax.swing.JTextField;


public class Geometria {
	
	//ATRIBUTOS
    private double base;
    private double altura;
    private double lado1;
    private double lado2;
    private String tipoTriangulo;

  
    public String getTipoTriangulo() {
		return tipoTriangulo;
	}

	public void setTipoTriangulo(String tipoTriangulo) {
		this.tipoTriangulo = tipoTriangulo;
	}

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
		this.tipoTriangulo="";
	}
    
    

	public Geometria(double base, double altura, double lado1, double lado2,String tipoTriangulo) {
		super();
		this.base = base;
		this.altura = altura;
		this.lado1 = lado1;
		this.lado2 = lado2;
		this.tipoTriangulo=tipoTriangulo;
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
                	double s = (base + lado1 + lado2) / 2;
                	return Math.sqrt(s * (s - base) * (s - lado1) * (s - lado2));
                } else { 
                	return base + lado1 + lado2;
                }
	        default:
	            throw new IllegalArgumentException("Figura no válida: " + figuraGeometrica);
	    }
	    
	}

    
    
    

	// METODO PARA OBTENER LA RUTA DE LA IMAGEN SEGUN LA FIGURA GEOMETRICA
    public String obtenerImagen(String figura ) {
        switch (figura) {
            case "Rectángulo":
                return "/images/Rectangulo.png";
            case "Círculo":
                return "/images/Circulo.png";
            case "Triángulo":
            	 switch (tipoTriangulo) {
                 case "Equilátero":
                     return "/images/TrianguloEquilatero.png";
                 case "Isósceles":
                     return "/images/TrianguloIsosceles.png";
                 case "Escaleno":
                     return "/images/TrianguloEscaleno.png";
                 default:
                     return "/images/Triangulo.png"; // Imagen genérica por defecto
             }
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
    
    public String obtenerTipoFiguraSeleccionada(boolean esRectangulo, boolean esCirculo, boolean esTriangulo) {
        if (esRectangulo) {
            return "Rectangulo";
        } else if (esCirculo) {
            return "Circulo";
        } else if (esTriangulo) {
            return "Triangulo";
        } else {
            return "";
        }
    }
    
    // REALIZAMOS OTRA CLASE PARA LAS INVALIDACIONES DE NUMERO O DE LETRAS, PARA DESPUES LLAMARLAS EN EL MAIN
    
    public class validacionCampos {
  
    	// ATRIBUTOS
    	    private JTextField textBaseNumero;
    	    private JTextField textAlturaNumero;
    	    private JTextField textLado1Numero;
    	    private JTextField textLado2Numero;
    	    private JButton btnCalcular;
    	    
    	    
      

        
    	public JTextField getTextBaseNumero() {
				return textBaseNumero;
			}





			public void setTextBaseNumero(JTextField textBaseNumero) {
				this.textBaseNumero = textBaseNumero;
			}





			public JTextField getTextAlturaNumero() {
				return textAlturaNumero;
			}





			public void setTextAlturaNumero(JTextField textAlturaNumero) {
				this.textAlturaNumero = textAlturaNumero;
			}





			public JTextField getTextLado1Numero() {
				return textLado1Numero;
			}





			public void setTextLado1Numero(JTextField textLado1Numero) {
				this.textLado1Numero = textLado1Numero;
			}





			public JTextField getTextLado2Numero() {
				return textLado2Numero;
			}





			public void setTextLado2Numero(JTextField textLado2Numero) {
				this.textLado2Numero = textLado2Numero;
			}





			public JButton getBtnCalcular() {
				return btnCalcular;
			}





			public void setBtnCalcular(JButton btnCalcular) {
				this.btnCalcular = btnCalcular;
			}


            


		public validacionCampos(JTextField textBaseNumero, JTextField textAlturaNumero, JTextField textLado1Numero,
					JTextField textLado2Numero, JButton btnCalcular) {
				super();
				this.textBaseNumero = textBaseNumero;
				this.textAlturaNumero = textAlturaNumero;
				this.textLado1Numero = textLado1Numero;
				this.textLado2Numero = textLado2Numero;
				this.btnCalcular = btnCalcular;
			}





		public validacionCampos() {
			// TODO Auto-generated constructor stub
		}





		@Override
		public String toString() {
			return "validacionCampos [textBaseNumero=" + textBaseNumero + ", textAlturaNumero=" + textAlturaNumero
					+ ", textLado1Numero=" + textLado1Numero + ", textLado2Numero=" + textLado2Numero + ", btnCalcular="
					+ btnCalcular + "]";
		}





		// METODO PARA HABILITAR CADA UNO DE LOS CAMPOS QUE VAMOS A UTILIZAR SI TIENEN ALGUN VALOR, PERMITE SEGUIR AL SIGUIENTE
    	// SEGUIR AL SIGUEINTE, 
        public  void actualizarCampos() {
            textAlturaNumero.setEditable(!textBaseNumero.getText().isEmpty()); // SE HABILITA EL CAMPO CORRESPONDIENTE SI LA BASE NO ESTA VACIA
            textLado1Numero.setEditable(!textAlturaNumero.getText().isEmpty()); // SE HABILITA EL CAMPO CORRESPONDIENTE SI LA ALTURA NO ESTA VACIA
            textLado2Numero.setEditable(!textLado1Numero.getText().isEmpty()); // SE HABILITA EL CAMPO CORRESPONDIENTE SI LA LADO1 NO ESTA VACIA
            btnCalcular.setEnabled(!textLado2Numero.getText().isEmpty()); // // SE HABILITA EL CAMPO CORRESPONDIENTE SI LA LADO2 NO ESTA VACIA
        }





	
      
     
        
    }
    
    
}
