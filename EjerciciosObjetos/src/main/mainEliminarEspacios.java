package main;

import java.util.Scanner;

//  Introducida una cadena por código eliminar sus espacios en blanco. Pista buscar inforamción function trim()
public class mainEliminarEspacios {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//DEFINIMOS LAS VARIABLES
   String cadena= "";
   String cadenaSinEspacios = "";
   
   // LLAMAMOS A LA CADENA
   System.out.println("Introduce una cadena:");
     cadena=leerTeclado();
     
     //LLAMAMOS A LA CADENA SIN LOS ESPACIOS
     cadenaSinEspacios = cadena.trim();  // TRIM() METODO PARA ELIMINAR LOS ESPACIOS EN BLANCO INICIAL Y FINAL 
     System.out.println("Cadena original: " + cadena);
     System.out.println("Cadena sin los espacios   => "+cadenaSinEspacios );
   
    
	}

	private static String leerTeclado() {
		String retorno="";
		Scanner sca= new Scanner(System.in);
		retorno=sca.nextLine();
		return retorno;
	}
}
