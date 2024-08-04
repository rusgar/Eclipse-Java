package main;
import helpers.CommonHelpers;

import model.barbacoa;

public class MainParillaBarbacoa {

	public static void main(String[] args) {
		 

	        
		 // CREAMOS LA INSTANCIA NUEVA DE BARBACOA Y DE COMMONhELPERS
	        barbacoa barbacoa = new barbacoa();
	        CommonHelpers ayudaHelpers = new CommonHelpers();

	        // SOLICIARAMOS LA CANTIDAD DE COSTILLAS POR KG
	        System.out.print("Ingrese la cantidad de costillas en kg: ");
	        double costillasKg = ayudaHelpers.leerTecladoDouble();
	        barbacoa.setCostillasKg(costillasKg);

	        // SOLICITAMOS LA CANTIDAD DE ENSALADAS POR KG
	        System.out.print("Ingrese la cantidad de ensalada en kg: ");
	        double ensaladaKg = ayudaHelpers.leerTecladoDouble();
	        barbacoa.setEnsaladaKg(ensaladaKg);

	        // CALCULAMOS LA CANTIDAD DE CLIENTES SEGUN LOS INGREDIENTES DISPONIBLES
	        int clientes = barbacoa.calcularClientes();
	        System.out.println("Se pueden servir a " + clientes + " clientes el plato estrella “costillas con ensalada de patata estilo campesino”.");

	}

}
