package main;

import model.NumeroEntero;
import helpers.CommonHelpers;

public class mainNumeroEntero {

	public static void main(String[] args) {
		CommonHelpers ayudaHelpers= new CommonHelpers();
        String numeroA="";
        String numeroB="";
	    
	        System.out.print("Ingrese el primer número: ");
	        numeroA = ayudaHelpers.leerTeclado();
	        System.out.print("Ingrese el segundo número: ");
	        numeroB = ayudaHelpers.leerTeclado();


	  
	        NumeroEntero numero1 = new NumeroEntero();
	        NumeroEntero numero2 = new NumeroEntero();

	        
	        System.out.println("Número A: " + numeroA);
	        System.out.println("Número B: " + numeroB);

	      
	        System.out.println("\nOperaciones con el número A:");
	        System.out.println("Valor de A: " + numeroA.getValor());
	        System.out.println("Doble de A: " + numeroA.getDoble());
	        System.out.println("Triple de A: " + numeroA.getTriple());

	        System.out.println("\nOperaciones con el número B:");
	        System.out.println("Valor de B: " + numeroB.getValor());
	        System.out.println("Doble de B: " + numeroB.getDoble());
	        System.out.println("Triple de B: " + numeroB.getTriple());

	 
	        numeroA.sumar(numeroB.getValor());
	        System.out.println("\nDespués de sumar B a A:");
	        System.out.println("Nuevo valor de A: " + numeroA);

	       
	        numeroB.restar(numeroA.getValor());
	        System.out.println("\nDespués de restar A de B:");
	        System.out.println("Nuevo valor de B: " + numeroB);

	}

}
