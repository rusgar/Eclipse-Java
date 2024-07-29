package main;

import model.Jugador;

public class MainJuegoRol {
    public static void main(String[] args) {
    	// CREAR UN ARREGLO DE 5 JUGADORES
        Jugador[] jugadores = new Jugador[5];

     // INICIALIZAR CADA JUGADOR
        for (int i = 0; i < jugadores.length; i++) {
            jugadores[i] = new Jugador();
        }

        // ENCONTRAR AL JUGADOR CON LA TIRADA MÁS ALTA (SIN ORDENAMIENTO)
        int maxTirada = Integer.MIN_VALUE;
        int indiceJugadorMax = -1;
        for (int i = 0; i < jugadores.length; i++) {
            if (jugadores[i].getTirada() > maxTirada) {
                maxTirada = jugadores[i].getTirada();
                indiceJugadorMax = i;
            }
        }

        System.out.println("El jugador que inicia es el jugador " + (indiceJugadorMax + 1) + " con una tirada de " + maxTirada);
    }
}
