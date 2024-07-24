package Main;


import java.util.Scanner;

public class MainParesExistentes {

	public static void main(String[] args) {
		 int LimitNumber =0; // Numero limite hasta mostrar los pares

	        System.out.println("Introduce un número límite solictado: ");
	        LimitNumber = Integer.parseInt(leerTeclado());

	        System.out.println("Números pares hasta " + LimitNumber + ":");

	        for (int i = 1; i <= LimitNumber; i++) {
	            if (i % 2 == 0) {
	                System.out.print(i + "/");
	            }
	        }

	        System.out.println("\nSe han terminado el listado de numeros pares.");
	    }

	

	private static String leerTeclado() {
		String retorno="";
		Scanner scanner= new Scanner(System.in);
		retorno=scanner.nextLine();
		return retorno;
	}
}

