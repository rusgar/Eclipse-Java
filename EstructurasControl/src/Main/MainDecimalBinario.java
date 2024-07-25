package Main;
//Realiza un programa que devuelva la conversion de un número decimal a binario

import java.util.Scanner;

public class MainDecimalBinario {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        System.out.print("Introduzca el numero entero: ");
        int NumberDecimal = scanner.nextInt();

     
        String binario = Integer.toBinaryString(NumberDecimal);
        System.out.println("el Numero Binario pedido es " + binario);
        
        

    int NumberConvertir = 0;
    String NumberBinario ="";
    System.out.print("Introduzca el numero entero: ");
    NumberConvertir = Integer.parseInt(leerTeclado()); 
    
    NumberBinario = Integer.toBinaryString(NumberDecimal); 
    System.out.println("el Numero Binario pedido por segunda vez " + NumberBinario);
    }
    
    
   
    
    private static String leerTeclado() {
		String retorno="";
		Scanner scanner= new Scanner(System.in);
		retorno=scanner.nextLine();
		return retorno;
	}
}

