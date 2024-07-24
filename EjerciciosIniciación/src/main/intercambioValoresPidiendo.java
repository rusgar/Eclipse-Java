package main;
import java.util.Scanner;

public class intercambioValoresPidiendo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar al usuario que ingrese los dos números
        System.out.print("Ingrese el primer número: ");
        double n1 = scanner.nextDouble();

        System.out.print("Ingrese el segundo número: ");
        double n2 = scanner.nextDouble();

        // Mostrar los números ingresados antes del intercambio
        System.out.println("Antes del intercambio:");
        System.out.println("n1 = " + n1);
        System.out.println("n2 = " + n2);

        // Intercambiar valores utilizando una variable temporal
        double temp = n1;
        n1 = n2;
        n2 = temp;

        // Mostrar los números después del intercambio
        System.out.println("Después del intercambio:");
        System.out.println("n1 = " + n1);
        System.out.println("n2 = " + n2);

        // Cerrar el scanner al finalizar
        scanner.close();
    }

}