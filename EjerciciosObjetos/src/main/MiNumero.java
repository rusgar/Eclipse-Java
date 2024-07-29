package main;

import helpers.CommonHelpers;

public class MiNumero {

	public static void main(String[] args) {
		CommonHelpers ayudaHelpers = new CommonHelpers();
		 MiNumero miNumero = new MiNumero();
		 int numeroIngresado =0;
		 
		 ayudaHelpers.imprimirContinuo("Ingrese un número: ");

          numeroIngresado = ayudaHelpers.leerTeclado();

        
        miNumero.mostrarResultados();
    }

}
