package main;

import java.util.Scanner;

// Realiza un programa que haga la suma de 3 números decimales y los muestre por pantalla.

public class MainDoubleNumber {

    public static void main(String[] args) {
        // Declaración de variables
    	
        double num1, num2, num3, resul;

        // Comprobación del número de argumentos
        
        if(args.length < 3) {
            System.out.println("Numero de argumentos no validos");
        } 
        else {
            resul = 0;

            // Lectura de los números desde el teclado
            
            System.out.println("Introduzca el primer numero:");
            num1 = Double.parseDouble(leerTeclado());

            System.out.println("Introduzca el segundo numero:");
            num2 = Double.parseDouble(leerTeclado());

            System.out.println("Introduzca el tercer numero:");
            num3 = Double.parseDouble(leerTeclado());

            // Cálculo de la suma
            resul = num1 + num2 + num3;

            // Impresión del resultado
            System.out.println("******************");
            System.out.println("La suma de los tres números es: " + num1 + " + " + num2 + " + " + num3 + " = " + resul);
            System.out.println("******************");
        }
    }

    private static String leerTeclado() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}


