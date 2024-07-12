package main;
import java.util.Random;

public class mainVocalConsonante {

	public static void main(String[] args) {
	    Random random = new Random();
        char letra = (char) (random.nextInt(26) + 'A');
        
        System.out.println("La letra aleatoria es: " + letra);
        
         boolean esVocal =(letra == 'A' || letra == 'E' || letra == 'I' || letra == 'O' || letra == 'U' ||
            letra == 'a' || letra == 'e' || letra == 'i' || letra == 'o' || letra == 'u');
        
        if (esVocal) {
            System.out.println("Es vocal");
        } else {
            System.out.println("Es consonante");
        }
        System.out.println("la palabra pedida es : " + esVocal);
	}
}
	
	


/*
// TODO Auto-generated method stub
		char letra = (char) (new Random().nextInt(26) + 'A');
        System.out.println("La letra aleatoria es: " + letra);
        System.out.println("Es " + ("AEIOU".indexOf(letra) != -1 ? "vocal" : "consonante"));
        **************************************************************
         Random random = new Random();
        char letra = (char) (random.nextInt(26) + 'a');

        boolean esVocal = "aeiou".indexOf(letra) != -1;
        String tipoLetra = esVocal ? "vocal" : "consonante";

        System.out.println("La letra aleatoria es: " + letra);
        System.out.println("Es " + tipoLetra);
        
       
        */

/* 
        Random random = new Random();
        char letra = (char) (random.nextInt(26) + 'A');
        
        System.out.println("La letra aleatoria es: " + letra);
        
        boolean esVocal;
        
        switch (Character.toUpperCase(letra)) {
            case 'A':
            case 'E':
            case 'I':
            case 'O':
            case 'U':
                esVocal = true;
                break;
            default:
                esVocal = false;
                break;
        }
        
        if (esVocal) {
            System.out.println("Es vocal");
        } else {
            System.out.println("Es consonante");
        }
        
        System.out.println("Es vocal (booleano): " + esVocal);
    }

*/


