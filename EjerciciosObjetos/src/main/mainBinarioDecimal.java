package main;

//REALIZA UN PROGRAMA QUE CONVIERTA UN NÚMERO DE BINARIO A DECIMAL  AYUDA 
import java.util.Scanner;

public class mainBinarioDecimal {

	public static void main(String[] args) {


        int numeroDecimal = 0;
        char digito;
        String binario = "";

        System.out.print("Introduce el número binario: ");
        binario = leerTeclado();

        
        // VERIFICAMOS LOS CARACTERES INVALIDOS Y LA CONVERSION DE BINARIO A DECIMAL	
        for (int i = binario.length() - 1; i >= 0; i--) {
            digito = binario.charAt(i);
            if (digito != '0' && digito != '1') {
                System.out.println("Error: El número binario contiene caracteres inválidos.");
                return;
            }
            numeroDecimal += (digito - '0') * Math.pow(2, binario.length() - i - 1);
        }

        System.out.println("El número decimal equivalente es: " + numeroDecimal);
    

    

		// TODO Auto-generated method stub
            
		
		int base = 1;
		int numeroEntero=0;
		
		
			  
		System.out.print("Introduce el número binario: ");
		binario = leerTeclado();
		for (int i = binario.length() - 1; i >= 0; i--) {
             digito = binario.charAt(i);

		if (digito != '0' && digito != '1') {
            System.out.println("Error: El número binario contiene caracteres inválidos.");
            break; 
        }   numeroEntero= Character.getNumericValue(digito); // OBTENEMOS CON ESTE METODO UN SOLO CHAR, ASOCIADO AL DIGITO
        numeroDecimal+=(digito - '0') * base ; //DECLARACIÓN CALCULA DIRECTAMENTE LA CONTRIBUCIÓN DEL DÍGITO ACTUAL AL NÚMERO DECIMAL. 
        base*= 2;                                                            // 
    }
	 System.out.println("El número decimal equivalente es: " + numeroDecimal);
		    
	}



	private static String leerTeclado() {
		String retorno="";
		Scanner sca= new Scanner(System.in);
		retorno=sca.nextLine();
		return retorno;
	}

}
