package main;
//  Realiza un programa en el cual haya un método que genere un número aleatorio entre 1 y 49

import java.util.Random;
public class mainNumeroAleatorio {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		    Random random = new Random();

		  

		


		    int min = 1;
	        int max = 49;	       
	        int numeroAleatorio = random.nextInt(max - min + 1) + min;
	        System.out.println("Número aleatorio: " + numeroAleatorio);
	      
	}

}
