package main;

import java.util.Random;
import helpers.CommonHelpers;
import modelo.aleatorio;

public class MainBonoloto {

	public static void main(String[] args) {
		Random random = new Random();
		CommonHelpers ayudaHelpers = new CommonHelpers();
		int numeroMin = 1;
		int numeroMax = 49;
		double costoPorLinea = 0.5;
		int[] numerosSet= new int[6];
		double apuestaTotal = 0.0;
		
		ayudaHelpers.imprimirSalto("Ingrese la cantidad que desea apostar en euros: ");
		apuestaTotal = ayudaHelpers.leerTecladoDouble();
		int numeroLineas = (int) Math.floor(apuestaTotal / costoPorLinea);
		
		
		
		ayudaHelpers.imprimirSalto("\nSu apuesta total es de " + apuestaTotal + " euros.");
		ayudaHelpers.imprimirSalto("Puede generar " + numeroLineas + " líneas de números.");


		for (int i = 0; i < numeroLineas; i++) {          

			for (int j = 0; j < numerosSet.length; j++) {
				int numeroAleatorio;
				do {
					numeroAleatorio = random.nextInt(numeroMax - numeroMin + 1) + numeroMin;
				} while (aleatorio.yaExiste(numerosSet, numeroAleatorio));
				numerosSet[j] = numeroAleatorio;
			}


<<<<<<< HEAD
			System.out.print("\n"+"Línea " + (i + 1) + ":");
=======
<<<<<<< HEAD
<<<<<<< HEAD
			System.out.print("\n"+"Línea " + (i + 1) + ":");
=======
			ayudaHelpers.imprimirSalto("\n"+"Línea " + (i + 1) + ":");
>>>>>>> main
>>>>>>> main
=======
			ayudaHelpers.imprimirSalto("\n"+"Línea " + (i + 1) + ":");
>>>>>>> main
>>>>>>> main
			for (int numero : numerosSet) { // VARIABLE DE ITERACION Y EL ARRAY QUE ITERAMOS
				ayudaHelpers.imprimirContinuo("  "+numero + " ");
			}
			
		}

		int numeroComplementario = aleatorio.generarNumeroComplementario(random);
		int numeroReintegro = aleatorio.generarNumeroReintegro(random);

		ayudaHelpers.imprimirSalto("\n"+"Número complementario: " + numeroComplementario);
		ayudaHelpers.imprimirSalto("\n"+"Número de reintegro: " + numeroReintegro);
	}
}


