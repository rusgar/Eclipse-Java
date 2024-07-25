package main;

import java.util.Scanner;

//   REALIZA UN PROGAMA QUE MUESTRE LA SERIE DE FIBONACCI DE N TÉRMINOS DÓNDE N ES UN NÚMERO ENTERO SOLICITADO POR TECLADO AYUDA: 
public class MainFibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
<<<<<<< HEAD
<<<<<<< HEAD
       int cadena =0;       
       int primerNumero= 0;
       int segundoNumero= 1;
=======
       int numero =0;       
       int numero0= 0;
       int numero1= 1;
>>>>>>> main
=======
       int numero =0;       
       int numero0= 0;
       int numero1= 1;
>>>>>>> main
       int Fibonacci = 0;
       
       
       System.out.print("Introduzca el numero entero: ");
<<<<<<< HEAD
<<<<<<< HEAD
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
=======
=======
>>>>>>> main
	    numero = Integer.parseInt(leerTeclado()); 
	    
	    if (numero< 0) {
            System.out.println("Error: El número debe ser mayor o igual a 0.");
        } else {
        	if (numero == 0) {
                System.out.println("La serie de Fibonacci no incuye términos vacios.");
                return;
            }
        	System.out.print(numero0 + " ");
            System.out.print(numero1+ " ");
            
            for (int i = 2; i < numero; i++) {
                Fibonacci = numero0 +numero1;
                System.out.print(Fibonacci + " ");
                numero0 = numero1;
                numero1= Fibonacci;
<<<<<<< HEAD
>>>>>>> main
=======
>>>>>>> main
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
