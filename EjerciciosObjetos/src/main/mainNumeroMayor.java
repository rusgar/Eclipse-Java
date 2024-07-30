package main;

import java.util.Scanner;

// Realiza un programa que muestre el mayor de dos números previamente introducidos por código en el programa
public class mainNumeroMayor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         int numero1=0;
         int numero2=0;
         int mayor=0;
		 
         
         System.out.println("Introduce un número entero:");
         numero1 = Integer.parseInt(leerTeclado());
        
         System.out.println("Introduce un número entero:");
         numero2 = Integer.parseInt(leerTeclado());
        
         
         mayor = Math.max(numero1,numero2 ); 
         System.out.println("El número mayor de los numeros  es : " + mayor);
	}
         
         
                  
	private static String leerTeclado() {
		String retorno="";
		Scanner sca= new Scanner(System.in);
		retorno=sca.nextLine();
		return retorno;
	}
}
