package main;
 /* Nos encontramos jugando una partida de ROL ONLINE con otros 4 jugadores, el primer jugador en indicar su acción
   será el que saque el valor más alto en un dado de 10 caras. Crear un programa que nos indique que jugador será el primero en realizar la acción.*/


import java.util.Random;

public class mainRolOnline {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random random = new Random();
		
		   // Inicialiamos las variables
		    String jugador1 = "T1";
	        String jugador2 = "T2";
	        String jugador3 = "T3";
	        String jugador4 = "T4";
	        int tiradaGanadora = 0;
	        String primerJugador="";
	        
	        // Inicialiamos las tiradas
	        
	        int tirada1 = 0;
	        int tirada2 = 0;
	        int tirada3 = 0;
	        int tirada4 = 0;
	        
	        System.out.println("¡Tirando dados para determinar el primer jugador!");
	        tirada1 = random.nextInt(10) + 1; 
	        tirada2= random.nextInt(10) + 1;
	        tirada3 = random.nextInt(10) + 1;
	        tirada4 = random.nextInt(10) + 1;
	        
	        
	        if (tirada1 >= tirada2 && tirada1 >= tirada3 && tirada1 >= tirada4) {
	            primerJugador = jugador1;
	            tiradaGanadora = tirada1;
	        } else if (tirada2 >= tirada1 && tirada2 >= tirada3 && tirada2 >= tirada4) {
	            primerJugador = jugador2;
	            tiradaGanadora = tirada2;
	        } else if (tirada3 >= tirada1 && tirada3 >= tirada2 && tirada3 >= tirada4) {
	            primerJugador = jugador3;
	            tiradaGanadora = tirada3;
	        } else {
	            primerJugador = jugador4;
	            tiradaGanadora = tirada4;
	        }
	        
	        System.out.println("¡El jugador " +primerJugador + " ha sacado el valor más alto✔ (" + tiradaGanadora + ") y será el primero en tirar 👌👌👌!");
	}
}
