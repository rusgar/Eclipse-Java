package main;
import java.util.Random;

public class MainLoteria {

    public static void main(String[] args) {
        Random random = new Random();
       
        
        int[] numerosPrincipales = new int[6];
        for (int i = 0; i < numerosPrincipales.length; i++) {
            int numeroAleatorio;
            do {
                numeroAleatorio = random.nextInt(49) + 1;
            } while (yaExiste(numerosPrincipales, numeroAleatorio));
            numerosPrincipales[i] = numeroAleatorio;
        }

        // Generar número aleatorio complementario entre 1 y 49
        int numeroComplementario = random.nextInt(49) + 1;

        // Generar número aleatorio de reintegro entre 0 y 9
        int numeroReintegro = random.nextInt(10);

        // Mostrar resultados
        System.out.println("Números principales:");
        for (int numero : numerosPrincipales) {
            System.out.print(numero + " ");
        }
        System.out.println("\nNúmero complementario: " + numeroComplementario);
        System.out.println("Número de reintegro: " + numeroReintegro);
    }

    // Método auxiliar para verificar si un número ya existe en un array
    private static boolean yaExiste(int[] array, int numero) {
        for (int elemento : array) {
            if (elemento == numero) {
                return true;
            }
        }
        return false;
    }
}

