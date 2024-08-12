package com.erc.model;

public class Calculadora {
	
	
	// ATRIBUTOS
	private double Operador1;
	private double Operador2;
	private String Operacion;
	
	// GETTER Y SETTE

    public double getOperador1() {
		return Operador1;
	}

	public void setOperador1(double operador1) {
		Operador1 = operador1;
	}

	public double getOperador2() {
		return Operador2;
	}

	public void setOperador2(double operador2) {
		Operador2 = operador2;
	}

	public String getOperacion() {
		return Operacion;
	}

	public void setOperacion(String operacion) {
		Operacion = operacion;
	}

	
	// CONSTRUCTORES
	
	public Calculadora(double operador1, double operador2, String operacion) {
		super();
		Operador1 = operador1;
		Operador2 = operador2;
		Operacion = operacion;
	}
	
	
	public Calculadora() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	@Override
	public String toString() {
		return "Calculadora [Operador1=" + Operador1 + ", Operador2=" + Operador2 + ", Operacion=" + Operacion + "]";
	}
	
	
	
	
	
	



	public double ejecutarOperacion(double Operador1, double Operador2, String Operacion) throws ArithmeticException {
        switch (Operacion) {
            case "+":
                return Operador1 + Operador2;
            case "-":
                return Operador1 - Operador2;
            case "x":
                return Operador1 * Operador2;
            case "/":
                if (Operador2 == 0) {
                    throw new ArithmeticException("Error: No se puede dividir un número por 0");
                }
                return Operador1 / Operador2;
            default:
                throw new IllegalArgumentException("Operacion Invalida");
        }
    }

    public double resultadoDecimales(double numero) {
    	double numeroRedondeado=0.0;
    	String cadenaFormateada=
				String.format("%.2f", numero);
    	cadenaFormateada=cadenaFormateada.replace(',','.');
    	numeroRedondeado= Double.parseDouble(cadenaFormateada);
    	return numeroRedondeado;
    }
    
    

}
