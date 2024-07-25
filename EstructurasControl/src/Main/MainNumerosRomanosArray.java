package Main;

import java.util.Scanner;

public class MainNumerosRomanosArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int numeroEntero=0;
		boolean conversionRealizada=false;// bandera
		String [] numerosRomanos= {
				"I","II","III","IV","V",
				"VI","VII","VIII","IX","X"	
		};
		
		
		System.out.println("Introduzca un numero entero"
				+ " de 1 a 10");
		numeroEntero=Integer.parseInt(leerTeclado());
		if(numeroEntero>0 && numeroEntero<=10) {
			System.out.println(numeroEntero +" => "+
		numerosRomanos[numeroEntero-1]);
		}else {
			System.out.println("Número incorrecto");
		}
		
	}

	private static String leerTeclado() {
		String retorno="";	
		Scanner escaner	= new Scanner(System.in);
		retorno=escaner.nextLine();	
		return retorno;
		}
	
}
