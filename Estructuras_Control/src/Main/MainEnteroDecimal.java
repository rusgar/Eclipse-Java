package Main;

import java.util.Scanner;

public class MainEnteroDecimal {

	public static void main(String[] args) {
		 
		
	    int numeroConvertir = 0;
	    System.out.print("Introduzca el numero entero: ");
	    numeroConvertir = Integer.parseInt(leerTeclado()); 
		 
		int dividendo= numeroConvertir;
		int resto=0;
		String resultado="";
		while(dividendo >=2) {
			resto=dividendo%2;
			dividendo =dividendo/2;
			resultado=resultado+resto;
			if(dividendo <2 ){
				resultado=resultado+dividendo;
				
			}
			
		}
		StringBuilder inversoResultado=new StringBuilder(resultado).reverse();
		System.out.println("StringBuilder"+" Numero pedido es:  "+numeroConvertir+" => "+inversoResultado+"  en binario");
		
		String inversoResultado2="";
		for(int i=resultado.length()-1;i>=0;i--) {
			inversoResultado2+=resultado.charAt(i);
			
		}
		System.out.println("InvertiendoString"+" Numero pedido es:  "+numeroConvertir+" => "+inversoResultado+"  en binario");
		
		
	}
	
private static String leerTeclado() {
	String retorno="";
	Scanner scanner= new Scanner(System.in);
	retorno=scanner.nextLine();
	return retorno;
}

}

