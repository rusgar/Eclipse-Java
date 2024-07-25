package modelo;

<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> main
import java.util.Arrays;
import java.util.Random;

public class aleatorio {
    
	// DEFINO LOS ATRIBUTOS DE LA CLASE
	private int  elemento;
	private int numeroComplementario;
	private int[] numerosSet= new int[6];
	private int reintegro;
	
	
	
	
	public int getElemento() {
		return elemento;
	}
	public void setElemento(int elemento) {
		this.elemento = elemento;
	}
	public int getNumeroComplementario() {
		return numeroComplementario;
	}
	public void setNumeroComplementario(int numeroComplementario) {
		this.numeroComplementario = numeroComplementario;
	}
	public int[] getNumerosSet() {
		return numerosSet;
	}
	public void setNumerosSet(int[] numerosSet) {
		this.numerosSet = numerosSet;
	}
	public int getReintegro() {
		return reintegro;
	}
	public void setReintegro(int reintegro) {
		this.reintegro = reintegro;
	}
	
	
	
	
	public aleatorio() {
		super();
		this. elemento= 0;
		this.numeroComplementario=0;
		this.numerosSet= new int[6];
		this.reintegro=0;
	}
	
	
	
	public aleatorio(int elemento, int numeroComplementario, int[] numerosSet, int reintegro) {
		super();
		this.elemento = elemento;
		this.numeroComplementario = numeroComplementario;
		this.numerosSet = numerosSet;
		this.reintegro = reintegro;
	}
	
	
	
	@Override
	public String toString() {
		return "aleatorio [elemento=" + elemento + ", numeroComplementario=" + numeroComplementario + ", numerosSet="
				+ Arrays.toString(numerosSet) + ", reintegro=" + reintegro + "]";
	}
	public static boolean yaExiste( int[] array,  int numero) {
        for (  int elemento : array) { // ITERA CADA ELEMENTO EN UN ARRAY
<<<<<<< HEAD
=======
=======
import java.util.Random;

public class aleatorio {

	public static boolean yaExiste( int[] array,  int numero) {
        for (int elemento : array) { // ITERA CADA ELEMENTO EN UN ARRAY
>>>>>>> main
>>>>>>> main
            if (elemento == numero) { // CADA ELEMENTO ES UN NUMERO
                return true; 
            }
        }
        return false;// SI DEVUELVE UN REPETIDO DEVUELVE UN FALSE
    }
	public static int generarNumeroComplementario(Random random) {
	    int numeroComplementario;
	    int[] numerosSet= new int[6];
	    do {
	        numeroComplementario = random.nextInt(49) + 1; 
	    } while (aleatorio.yaExiste(numerosSet, numeroComplementario)); 
	    return numeroComplementario;
	}
	public static int generarNumeroReintegro(Random random) {
	    return random.nextInt(10); 
	}
}
