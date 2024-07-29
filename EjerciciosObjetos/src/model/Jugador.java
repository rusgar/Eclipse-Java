package model;
import java.util.Random;

public class Jugador {
    private int tirada;

    public Jugador() {
        // Inicializamos la tirada al crear un nuevo jugador
        tirarDado();
    }

    public void tirarDado() {
        Random random = new Random();
        tirada = random.nextInt(20) + 1; // Dado de 20 caras
    }

    public int getTirada() {
        return tirada;
    }
}
