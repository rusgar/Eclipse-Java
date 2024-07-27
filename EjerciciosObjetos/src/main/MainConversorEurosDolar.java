package main;


import helpers.CommonHelpers;
import modelo.ConversorMonedas;


public class MainConversorEurosDolar {
	public static void main(String[] args) {

		CommonHelpers ayudaHelpers = new CommonHelpers();
		ConversorMonedas  tasasConversor= new ConversorMonedas();
		double cantidad= 0.0;
		String input ="";
		

		
		ayudaHelpers.imprimirContinuo("Ingrese la cantidad a convertir : ");
		cantidad =  ayudaHelpers.leerTecladoDouble();
		
        
		
		
		ayudaHelpers.imprimirContinuo("Ingrese la moneda de origen (euros o dolares): ");
		String monedaOrigenStr = ayudaHelpers.leerTeclado().toUpperCase();
		tasasConversor.setEuros(cantidad);

		ayudaHelpers.imprimirContinuo("Ingrese la moneda de destino (euros o dolares): ");
		 String monedaDestinoStr = ayudaHelpers.leerTeclado().toUpperCase();
	     tasasConversor.setDolares(tasasConversor.convertir
	    		                  (tasasConversor.getEuros(), monedaOrigenStr, monedaDestinoStr));

	    ayudaHelpers.imprimirSalto(tasasConversor.toString());		
		

		String resultadoFormateado = tasasConversor.FormatearDecimales
				                     (tasasConversor.convertir
				                     (tasasConversor.getEuros(), monedaOrigenStr, monedaDestinoStr));
		ayudaHelpers.imprimirSalto("La converison de monedas es de "+tasasConversor.getEuros()+"  € " + " euros  a dolares  => son  " + resultadoFormateado+ " $");
    }
	}
