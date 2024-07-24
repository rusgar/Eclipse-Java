package Main;
// Realiza un programa que muestre por pantalla los número en inglés entre 1 y 10( ayuda bucle for y un switch)

public class MainNumerosIngles {

	public static void main(String[] args) {
		
		        // Array con los números en inglés (posición 0 = 1, posición 1 = 2,  y asi continuamos hasta posicion 9 = 10(ten))
		        String[] numerosIngles = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"};
		        
		        
		        // Bucle for para recorrer los números del 1 al 10
		        for (int numero = 0; numero <= 10; numero++) {
		            // Uso del switch para obtener el índice correcto del array
		            switch (numero) {
		                case 1:
		                    System.out.println(numerosIngles[0].toUpperCase());
		                    break;
		                case 2:
		                    System.out.println(numerosIngles[1].toUpperCase());
		                    break;
		                case 3:
		                    System.out.println(numerosIngles[2].toUpperCase());
		                    break;
		                case 4:
		                    System.out.println(numerosIngles[3].toUpperCase());
		                    break;
		                case 5:
		                    System.out.println(numerosIngles[4].toUpperCase());
		                    break;
		                case 6:
		                    System.out.println(numerosIngles[5].toUpperCase());
		                    break;
		                case 7:
		                    System.out.println(numerosIngles[6].toUpperCase());
		                    break;
		                case 8:
		                    System.out.println(numerosIngles[7].toUpperCase());
		                    break;
		                case 9:
		                    System.out.println(numerosIngles[8].toUpperCase());
		                    break;
		                case 10:
		                    System.out.println(numerosIngles[9].toUpperCase());
		                    break;
		            }
		        }
		    }


}
