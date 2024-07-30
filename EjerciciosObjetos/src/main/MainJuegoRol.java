package main;

import helpers.CommonHelpers;
import model.Jugador;


public class MainJuegoRol {
	public static void main(String[] args) {
		
		CommonHelpers ayudaHelpers = new CommonHelpers();
		int maxTirada = 0;
		int indiceJugadorMax = 0;
		int cantidadJugadores =0;
		
		// PEDIDOS LA CANTIDAD DE JUGADORES  A PEDIR
		ayudaHelpers.imprimirContinuo("¿Cuántos jugadores participarán en la partida? ");
        cantidadJugadores = ayudaHelpers.obtenerEntero(ayudaHelpers.leerTeclado());

		// INICIALIZAMOS LA CANTIDAD DE JUGADORES SEGUN LA CANTIDAD PEDIDA
		Jugador[] jugadores = new Jugador[cantidadJugadores];
		
		// INICIALIAMOS CON 4 JUGADORES
		//Jugador[] jugadores = new Jugador[4];

		// INICIALIZAR CADA JUGADOR
		for (int i = 0; i < jugadores.length; i++) {
			jugadores[i] = new Jugador();
		}

		// ENCONTRAR AL JUGADOR CON LA TIRADA MÁS ALTA 
		maxTirada = jugadores[0].getTirada();

		for (int i = 1; i < jugadores.length; i++) {
			if (jugadores[i].getTirada() > maxTirada) {
				maxTirada = jugadores[i].getTirada();
				indiceJugadorMax = i;
			}
		}

		System.out.println("El jugador que inicia es " + jugadores[indiceJugadorMax].getNombre() +
                " con una tirada de " + maxTirada);
	}
}
