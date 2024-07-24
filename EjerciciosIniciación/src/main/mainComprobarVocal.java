package main;
import java.util.Random;

// Realice un programa que genere una letra aleatoria y compruebe si es vocal o consonante
public class mainComprobarVocal {

    public static void main(String[] args) {   
       
           

   
    Random random = new Random(); // Utiliamos la funcion random Random para generar datos aleatorios
    
    
    char letra = (char) ('a' + random.nextInt(26)); // Generar una letra aleatoria entre 'a' y 'z'
    
    
    System.out.println("La letra aleatoria pedida en el ejercicio es: " + letra); // Mostrar la letra generada
    
                                                                      // Comprobar si la letra es vocal o consonante
    if ("aeiou".indexOf(letra) != -1) {
        System.out.println("Es una vocal.");
    } else {
        System.out.println("Es una consonante.");
    }
}
}


/********************************************************************************************************
 *  Random random = new Random(); // Creamos un objeto Random para generar datos aleatorios
        char letra = (char) (random.nextInt(26) + 'a'); // Generamos una letra aleatoria del alfabeto español

        boolean esVocal = "aeiou".indexOf(letra) != -1;
        String tipoLetra = esVocal ? "vocal" : "consonante"; // Comprobamos si la letra es vocal o consonante con el operardor ternario ? que sustitute al if/else

        System.out.println("La letra aleatoria pedida en el ejercicio es: " + letra); // Mostramos el resultado
        System.out.println("Es " + tipoLetra);
 */

