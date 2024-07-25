package main;
import java.util.Random;

public class mainRolOnline {

    public static void main(String[] args) {
        // Definir los nombres de los jugadores como variables individuales
        String jugador1 = "T1";
        String jugador2 = "T2";
        String jugador3 = "T3";
        String jugador4 = "T4";

           
        

        // Generar tiradas aleatorias para cada jugador y encontrar al ganador
        Random random = new Random();
        int TiradaGanadora = 0;
        String JugadorGanador = "";
        int tirada1 = random.nextInt((20-1) + 1)+1;
        int tirada2 = random.nextInt((20-1) + 1)+1;
        int tirada3 = random.nextInt((20-1) + 1)+1;
        int tirada4 = random.nextInt((20-1) + 1)+1;

        
        
        if (tirada1 > TiradaGanadora) {
            TiradaGanadora = tirada1;
            JugadorGanador = jugador1;
        }
        
     
        if (tirada2 > TiradaGanadora) {
            TiradaGanadora = tirada2;
            JugadorGanador = jugador2;
        }

                
        if (tirada3 >TiradaGanadora) {
            TiradaGanadora = tirada3;
            JugadorGanador = jugador3;
        }

               
        if (tirada4 > TiradaGanadora) {
            TiradaGanadora = tirada4;
            JugadorGanador = jugador4;
        }

        // Mostrar los resultados de todas las tiradas de los jugadores
        System.out.println("Tiradas de los jugadores:");
        System.out.println("\t"+jugador1 + ": " + tirada1);
        System.out.println("\t"+jugador2 + ": " + tirada2);
        System.out.println("\t"+jugador3 + ": " + tirada3);
        System.out.println("\t"+jugador4 + ": " + tirada4);

        // Mostrar al jugador ganador
        System.out.println("******************"+"\n"+"El jugador ganador de la partida es: " + JugadorGanador + " con un tiro de " + TiradaGanadora + ".");
    }

}


