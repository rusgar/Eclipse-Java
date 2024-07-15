package Main;
import java.util.Random;


public class Main_Ejer9_Rol_Trucado {

    public static void main(String[] args) {
        // Definimos las variables
    	 int tirada1;
         int tirada2;
         int tirada3;
         int tirada4;

        Random aleatorio = new Random();
        int TiradaGanadora = 0;
        String JugadorGanador = "";
        String jugador1 = "Jugador 1";
        String jugador2 = "Jugador 2";
        String jugador3 = "Jugador 3";
        String jugador4 = "Jugador 4";
        
        tirada1 = (aleatorio.nextInt((20-1) + 1)+1)+1;
        tirada2 = (aleatorio.nextInt((20-1) + 1)+1)+2;
        tirada3 = (aleatorio.nextInt((20-1) + 1)+1)+3;
        tirada4 = (aleatorio.nextInt((20-1) + 1)+1)+4;
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
        System.out.println("******************"+"\n"+"El jugador ganador de la partida trucada es: " + JugadorGanador + " con un tiro de " + TiradaGanadora + ".");
    }

}
