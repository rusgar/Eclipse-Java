package Main;
import java.util.Scanner;

public class MainPalabraRepetidas {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String palabra = "salida"; // Replace "salida" with your desired keyword
        String almacenar = ""; // Almacenar palabras
        boolean ejecutar=true;

        System.out.println("Introduce palabras (escribe '" + palabra + "' para finalizar):");

        while (ejecutar) {
            String textoCadena = scanner.nextLine();

            if (textoCadena.equalsIgnoreCase(palabra)) {
                ejecutar=false; // salida del ciclo 
            }     else {      
           
             
            almacenar += textoCadena+ " ";}
        }

        System.out.println("\nPalabras introducidas:");
        System.out.println(almacenar); 
    }
}
