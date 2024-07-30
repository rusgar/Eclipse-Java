package main;

import java.util.Scanner;

//  Introducida una cadena por código, cambia todas sus aes por ies. Pista buscar información función replace()
public class mainReplace {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//DEFINIMOS LAS VARIABLES
		String  cadena= "";
		String replacedString="";
		
		System.out.print("Introduce una cadena: ");
		cadena = leerTeclado();
		replacedString = cadena.replace("aes", "ies");
		
		//IMPRESION DE LAS CADENAS ORIGINALES Y LA REEMPLEADAS
		System.out.println("Cadena original: " + cadena);
        System.out.println("Cadena reemplazada: " + replacedString);

                
        //AHORA CON UNA STRING DE PALABRAS YA PREDISEÑADAS
        
        String[] cadenas = {"caes", "maes", "raes"};        
    
        
        for (int i = 0; i < cadenas.length; i++) {
            cadenas[i] = cadenas[i].replace("aes", "ias");
        }

		//IMPRESION DE LAS CADENAS ORIGINALES Y LA REEMPLEADAS
        for (String cad : cadenas) {
            System.out.print("   Segunda Opcion de cadena reemplazada:  =>" + cad);
        }

	}
	private static String leerTeclado() {
		String retorno="";
		Scanner sca= new Scanner(System.in);
		retorno=sca.nextLine();
		return retorno;
	}
}
