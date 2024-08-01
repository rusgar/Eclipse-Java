package main;

import model.Raciones;
import helpers.CommonHelpers;

public class mainComedor {

	public static void main(String[] args) {
		Raciones raciones = new Raciones();
		CommonHelpers ayudaHelpers = new CommonHelpers();
		int numAdultos=0;
        int numNinos=0;

        ayudaHelpers.imprimirContinuo("Ingrese el número de adultos en la reserva: ");
         numAdultos = ayudaHelpers.leerTecladoInt();
         ayudaHelpers.imprimirContinuo("Ingrese el número de niños en la reserva: ");
         numNinos = ayudaHelpers.leerTecladoInt();

        raciones.setRaciones(numAdultos, numNinos);
        raciones.calcularRaciones();
	}

}
