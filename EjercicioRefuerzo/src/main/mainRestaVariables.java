package main;
// Realiza un programa que realice la resta de 2 variables una de ellas entera y la otra decimal.

import java.util.Scanner;

public class mainRestaVariables {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Definimos las variables a utilizar
   int numero1=0;
   float numero2= (float)0.0;
   float resultado=(float)0.0;
   
   
   System.out.println("Introduce un número entero:");
   numero1 = Integer.parseInt(leerTeclado());
   
   System.out.println("Introduce un número decimal:");
   numero2 = Float.parseFloat(leerTeclado());
   resultado = numero1 - numero2;
   
   System.out.println("La resta de " + numero1 + " - " + numero2 + " = " + resultado);
	}
	private static String leerTeclado() {
		String retorno="";
		Scanner sca= new Scanner(System.in);
		retorno=sca.nextLine();
		return retorno;
	}
}
