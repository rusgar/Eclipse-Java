package main;

import helpers.CommonHelpers;
import model.Numero;

public class MiNumero {

	public static void main(String[] args) {
		CommonHelpers ayudaHelpers = new CommonHelpers();
        int numero = ayudaHelpers.obtenerEntero(ayudaHelpers.leerTeclado("¿Cual es el numero que desea introducir? "));
        Numero miNumero = new Numero(numero); // Pasa el valor al constructor
        miNumero.mostrarResultados();
	    }
}