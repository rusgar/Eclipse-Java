package main;

import helpers.CommonHelpers;
import modelo.ConversorBD;

public class MainConversorBD {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CommonHelpers ayudaHelpers = new CommonHelpers();
		ConversorBD conversor= new ConversorBD();
		boolean ejecutar=true;
		
		while(ejecutar) {
			conversor.setDecimal(0);
			conversor.setBinario("");
			conversor.imprimeMenu();
			int opcion=Integer.parseInt(ayudaHelpers.leerTeclado());
			switch(opcion) {
			case 1: {
				ayudaHelpers.imprimirSalto("Dame un numero decimal");
				conversor.setDecimal(Integer.parseInt(ayudaHelpers.leerTeclado()));
				conversor.convertirBinario();
				ayudaHelpers.imprimirSalto(conversor.toString());
				break;
			}
			case 2: {
				ayudaHelpers.imprimirSalto("Dame un numero Binariol");
				conversor.setBinario(ayudaHelpers.leerTeclado());
				conversor.convertirDecimal();
				ayudaHelpers.imprimirSalto(conversor.toString());	
				
				break;			
			}
			case 3: {
				
				ejecutar=false;
				ayudaHelpers.imprimirSalto("Gracias por utilizar el programa");
				break;
			}
			default:
			ayudaHelpers.imprimirSalto("opcion no disponible");
		}
		
	}

	}
}
