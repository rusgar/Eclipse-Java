package model;
import java.lang.classfile.instruction.ReturnInstruction;
import java.util.Random;

public class Jugador {
	private int tirada;
	private String nombre;
	private   int contadorJugadores=0;
	 
	
	//GETTER
	public int getTirada() {
		return tirada;
	}
	public String getNombre() {
		return nombre;
	}
	public  int getContadorJugadores() {
        return contadorJugadores;
    }
    
	public void setTirada(int tirada) {
		this.tirada = tirada;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setContadorJugadores(int contadorJugadores) {
		this.contadorJugadores = contadorJugadores;
	}
	
	
	
	public Jugador(int tirada, String nombre, int contadorJugadores) {
		super();
		this.tirada = tirada;
		this.nombre = nombre;
		this.contadorJugadores = contadorJugadores;
	}
	
		
	@Override
	public String toString() {
		return "Jugador [tirada=" + tirada + ", nombre=" + nombre + ", contadorJugadores=" + contadorJugadores + "]";
	}
	public void tirarDado() {
		Random random = new Random();
		tirada = random.nextInt(20) + 1;
		
	}
	public Jugador() {
		contadorJugadores++;
		int numeroAleatorio = new Random().nextInt(10);
		this.nombre = "Jugador => " + contadorJugadores;       
        tirarDado();
    }
		




}
