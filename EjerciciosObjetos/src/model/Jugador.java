package model;
import java.util.Random;

public class Jugador {
	private int tirada;
	
	//GETTER
	public int getTirada() {
		return tirada;
	}
	


	public void tirarDado() {
		Random random = new Random();
		tirada = random.nextInt(20) + 1;
	}
	public Jugador() {
		tirarDado();
	}


}
