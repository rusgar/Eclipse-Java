package Main;

public class MainBuclesAsteriscosPiramide {

	public static void main(String[] args) {
		int asteriscos = 3; // cambiamos el valor de la altura de la piramide
        for (int i = 0; i <= asteriscos; i++) {
            for (int ast = 1; ast <= asteriscos - i; ast++) {
                System.out.print("  ");
            }
            for (int ast = 1; ast <= 2 * i - 1; ast++) {
                System.out.print(" *");
            }
            System.out.println("\n");
        }
	}

}
