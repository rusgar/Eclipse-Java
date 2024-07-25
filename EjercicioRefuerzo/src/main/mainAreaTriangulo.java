package main;

import java.util.Scanner;

// Realiza un programa que calcule el área de un triangulo de base 3 y altura 5
public class mainAreaTriangulo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Definimos las variables
		int base = 0;
		int altura = 0;
<<<<<<< HEAD
        double area= 0;
=======
<<<<<<< HEAD
        double area= 0;
=======
        int area= 0;
>>>>>>> main
>>>>>>> main
        
        System.out.print("Introduce  la base del triangulo: ");
        base = leerTeclado();
        System.out.print("Introduce la altura del triangulo: ");
        altura = leerTeclado();
        
        area= base*altura/2;
        System.out.println("El área del triangulo  es: "+ base+" * "+altura+" /2 "+" = " + area);
        
        
	}
	private static int leerTeclado() {
    	int retorno=0;
        Scanner sca = new Scanner(System.in);
        retorno= sca.nextInt();
        return retorno;
    }
}
