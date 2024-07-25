package main;

import java.util.Scanner;

//   REALIZA UN PROGAMA QUE MUESTRE LA SERIE DE FIBONACCI DE N TÉRMINOS DÓNDE N ES UN NÚMERO ENTERO SOLICITADO POR TECLADO AYUDA: 
public class MainFibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       int cadena =0;       
       int primerNumero= 0;
       int segundoNumero= 1;
       int Fibonacci = 0;
       
       
       System.out.print("Introduzca el numero entero: ");
	    cadena = Integer.parseInt(leerTeclado()); 
	    
	    if (cadena< 0) {
            System.out.println("Error: El número debe ser mayor o igual a 0.");
        } else {
        	if (cadena== 0) {
                System.out.println("La serie de Fibonacci no incuye términos vacios.");
                return;
            }
        	System.out.print(primerNumero + " -- ");
            System.out.print(segundoNumero+ " --  ");
              
            for (int i = 2; i < cadena; i++) {
                Fibonacci =primerNumero +segundoNumero;
                System.out.print(Fibonacci + " -- ");
               primerNumero = segundoNumero;
                segundoNumero= Fibonacci;
        }
    }
	       
	}

	private static String leerTeclado() {
		String retorno="";
		Scanner sca= new Scanner(System.in);
		retorno=sca.nextLine();
		return retorno;
	}
}
