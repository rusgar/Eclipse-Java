package main;


import helpers.CommonHelpers;
import modelo.ConversorMonedas;


public class MainConversorEurosDolar {
	public static void main(String[] args) {

		CommonHelpers ayudaHelpers = new CommonHelpers();
		ConversorMonedas  tasasConversor= new ConversorMonedas();
		double cantidad= 0.0;
		String monedaOrigenStr="";
		String monedaDestinoStr="";



		do {

			ayudaHelpers.imprimirContinuo("Ingrese la cantidad a convertir : ");
			cantidad =  ayudaHelpers.leerTecladoDouble();	

			ayudaHelpers.imprimirContinuo("Ingrese la moneda de origen (euros o dolares): ");
			monedaOrigenStr = ayudaHelpers.leerTeclado().toUpperCase();

			ayudaHelpers.imprimirContinuo("Ingrese la moneda de destino (euros o dolares): ");
			monedaDestinoStr = ayudaHelpers.leerTeclado().toUpperCase();

			if (monedaOrigenStr.equals("EUROS") || monedaOrigenStr.equals("DOLARES")) {
				tasasConversor.setEuros(cantidad);
				break;
			}

			else {
				ayudaHelpers.imprimirSalto("Moneda no válida. Introduce 'euros' o 'dolares'.");
			}
		}
		while (true); {	

			tasasConversor.setDolares(tasasConversor.monedasConvertir
					(tasasConversor.getEuros(), monedaOrigenStr, monedaDestinoStr));

			ayudaHelpers.imprimirSalto(tasasConversor.toString());		


			String resultadoEuros = tasasConversor.formatearDecimales
					(tasasConversor.monedasConvertir
							(tasasConversor.getEuros(), monedaOrigenStr, monedaDestinoStr));
			String resultadoDolares= tasasConversor.formatearDecimales
					(tasasConversor.monedasConvertir
							(tasasConversor.getDolares(), monedaOrigenStr, monedaDestinoStr));
			ayudaHelpers.imprimirSalto("La converison del dimero  de "+tasasConversor.getEuros()+"  € " + " euros  a dolares  => son  " + resultadoEuros+ " $");
			ayudaHelpers.imprimirSalto("La converison del dimero  de "+tasasConversor.getDolares()+"  $ " + " dolares  a euros  => son  " + resultadoDolares+ " €");
		}
	}
}
