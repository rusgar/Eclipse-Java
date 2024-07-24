package Main;

import java.util.Scanner;

public class MainCalculadora {

    public static void main(String[] args) {
        Scanner sca = new Scanner(System.in);
        boolean ejecutar = true;
        
        // Bucle para el menú principal
        while (ejecutar) {
            System.out.println("\n--- Menú Calculadora ---");
            System.out.println("---1. Sumar---");
            System.out.println("---2. Restar---");
            System.out.println("---3. Multiplicar---");
            System.out.println("---4. Division---");
            System.out.println("---5. Salir---");
            System.out.print("Selecciona una opción: ");
            int opcion = Integer.parseInt(leerTeclado());
            int operador1=0;
            int operador2=0;
            int resultado=0;

            switch (opcion) {
                case 1:{
                    
                    System.out.print("Introduce el primer operador: ");
                     operador1 = Integer.parseInt(leerTeclado());

                    System.out.print("Introduce el segundo operador: ");
                     operador2 = Integer.parseInt(leerTeclado());

                     resultado = operador1 + operador2;
                    System.out.println("La suma de " + operador1 + " + " + operador2 + " = " + resultado);
                    break;}
                case 2:{
                	System.out.print("Introduce el primer operador: ");
                      operador1 = Integer.parseInt(leerTeclado());

                    System.out.print("Introduce el segundo operador: ");
                      operador2 = Integer.parseInt(leerTeclado());

                    resultado = operador1 - operador2;
                    System.out.println("La resta de " + operador1 + " - " + operador2 + " = " + resultado);
                    break;}
                case 3:{
                	System.out.print("Introduce el primer operador: ");
                      operador1 = Integer.parseInt(leerTeclado());

                    System.out.print("Introduce el segundo operador: ");
                      operador2 = Integer.parseInt(leerTeclado());

                    resultado = operador1 * operador2;
                    System.out.println("La multiplicacion de " + operador1 + " * " + operador2 + " = " + resultado);
                    break;}
                case 4:{
                	System.out.print("Introduce el primer operador: ");
                      operador1 = Integer.parseInt(leerTeclado());

                    System.out.print("Introduce el segundo operador: ");
                      operador2 = Integer.parseInt(leerTeclado());

                    resultado = operador1 / operador2;
                    System.out.println("La division de " + operador1 + " / " + operador2 + " = " + resultado);
                    break;}
                	
                	
                case 5:{
                    System.out.println("¡Adiós! Saliendo del programa...👍");
                    ejecutar= false; }
                default:
                    System.out.println("Opción no válida 🤔. Inténtalo de nuevo🙌.");
            }
        }
        

    }
    
    private static String leerTeclado() {
		String retorno="";
		Scanner sca= new Scanner(System.in);
		retorno=sca.nextLine();
		return retorno;
		}
}


