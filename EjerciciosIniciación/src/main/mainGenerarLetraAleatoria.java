package main;
import java.util.Random;

public class mainGenerarLetraAleatoria {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
				
				// definimos las variables
				int numeroAleatorio =0;
		        char letra = ' ';
		        // Creamos la instancia radmon con la formula matematica ((max-min)+1)+min
		        Random aleatorio = new Random();
		        numeroAleatorio = aleatorio.nextInt((122-97)+1)+97;
		        
		        System.out.println("Numero generado ="+  numeroAleatorio+"\n"+"\n**************");
		        
		        //Operacion cash de un numero entero a un char. camnio de formato
		        
		        letra = (char)numeroAleatorio;
		        
		        System.out.println("\n"+"Letra generada =>"+  letra);
			}

		


	}


