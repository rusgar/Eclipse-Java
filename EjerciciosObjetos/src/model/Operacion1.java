package model;

import helpers.CommonHelpers;

public class Operacion1 {
	// DEFINO LOS ATRIBUTOS DE LA CLASE
	private int numero1;
	private int numero2;
	private String signo;
	
	//GETTER Y SETTER
	public int getNumero1() {
		return numero1;
	}
	public void setNumero1(int numero1) {
		this.numero1 = numero1;
	}
	public int getNumero2() {
		return numero2;
	}
	public void setNumero2(int numero2) {
		this.numero2 = numero2;
	}
	public String getSigno() {
		return signo;
	}
	public void setSigno(String signo) {
		this.signo = signo;
	}
	public Operacion1() {
		super();
	
		this.numero1 = 0;
		this.numero2 = 0;
		this.signo ="";
	}
	public Operacion1(int numero1, int numero2, String signo) {
		super();
		this.numero1 = numero1;
		this.numero2 = numero2;
		this.signo = signo;
	}
	@Override
	public String toString() {
		return "Operacion1 [numero1=" + numero1 + ", numero2=" + numero2 + ", signo=" + signo + "]";
	}
	
	// DESARROLLAMOS EL METODO QUE RESUELVE LAS OPERACIONES
	public void resuelveOperacion()  throws ArithmeticException{
		CommonHelpers helpers = new CommonHelpers();
		switch (signo) {
		case "+": {	// SUMA
			helpers.imprimirSalto(numero1+ " "+signo+" "+numero2+" = "+String.valueOf(numero1+numero2));
			break;
		}
		
		case "-": {	// RESTA
			helpers.imprimirSalto(numero1+ " "+signo+" "+numero2+" = "+String.valueOf(numero1-numero2));
			break;
		}
		case "*": {	// MULTIPLICACION
			helpers.imprimirSalto(numero1+ " "+signo+" "+numero2+" = "+String.valueOf(numero1*numero2));
			break;
		}
		case "/": {	// DIVISION
			helpers.imprimirSalto(numero1+ " "+signo+" "+numero2+" = "+String.valueOf(numero1/numero2));
			break;
		}
		default:
			helpers.imprimirSalto("Opción no disponible");
		}
	}
	
	}


