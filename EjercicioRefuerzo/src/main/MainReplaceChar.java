package main;

import java.util.Scanner;

public class MainReplaceChar {

	public static void main(String[] args) {
		//DEFINIMOS LAS VARIABLES
		String cadenaInicial= "";
		String cadenaFinal = "";
		char primerCaracter=0;
		char segundoCaracter=0;
		Scanner sca = new Scanner(System.in);

		System.out.print("Introduce una cadena de texto a sustituir: ");
		cadenaInicial = leerTeclado();

		System.out.print("Introduce la letra que deseas sustituir: ");
		primerCaracter =leerTeclado().charAt(0);

		System.out.print("Introduce la letra nueva que vas a sustituir: ");
		segundoCaracter = leerTeclado().charAt(0);

		cadenaFinal = cadenaInicial.replace(primerCaracter,segundoCaracter);


		System.out.println("\nCadena Inicial: " + cadenaInicial);
		System.out.println("Cadena Reemplazada: " + cadenaFinal);
	}
	private static String leerTeclado() {
		String retorno="";
		Scanner sca= new Scanner(System.in);
		retorno=sca.nextLine();
		return retorno;
	}
}