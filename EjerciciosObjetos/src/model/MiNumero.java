package model;

import helpers.CommonHelpers;

public class MiNumero {
	// ATRIBUTOS
	private double numero;

	// GETTER(OBTENER) Y SETTER(ESTABLECER)

	public double getNumero() {
		return numero;
	}

	public void setNumero(double numero) {
		this.numero = numero;				
	}
	
	
	// CONSTRUCTORES
	public MiNumero() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MiNumero(double numero) {
		super();
		this.numero = numero;
	}

	@Override
	public String toString() {
		return String.format("Número original: %.2f\n" +
                                        "Doble: %.2f\n" +
                                       "Triple: %.2f\n" +
                                       "Cuádruple: %.2f",
                                        numero, 
                                        numero * 2,
                                        numero * 3, 
                                        numero * 4);
	}

 
	public void DetallesMiNumero( ) {
		 CommonHelpers ayudaHelpers = new CommonHelpers();
		     		ayudaHelpers.imprimirContinuo(toString());
	}
}





