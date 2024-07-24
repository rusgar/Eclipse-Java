package Main;

public class MainBuclesAsteriscos2 {

	public static void main(String[] args) {
        int asteristicos = 5; // Cambia este valor para ajustar el tamaño del patrón
        for (int i = 0; i <= asteristicos; i++) {
            for (int ast = 1; ast <= i; ast++) {
                System.out.print(" * ");
            }
            System.out.println();
        }
        for (int i = asteristicos - 1; i >= 1; i--) {
            for (int ast = 1; ast <= i; ast++) {
                System.out.print(" * ");
            }
            System.out.println();
        }
    }
	
	   
	}



