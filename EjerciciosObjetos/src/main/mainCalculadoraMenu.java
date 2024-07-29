package main;

import helpers.CommonHelpers;
import model.Operacion;

public class mainCalculadoraMenu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//COMPROBACION DEL METODO Y LAS CLASES FUNCIONAN
        /* Operacion  operaciones= new Operacion();
         operaciones.setOperador1(10);
         operaciones.setOperador2(5);
         operaciones.setOpcion(1);
         operaciones.resuelveOperacion();
         operaciones.setOpcion(2);
         operaciones.resuelveOperacion();
         operaciones.setOpcion(3);
         operaciones.resuelveOperacion();
         operaciones.setOpcion(4);
         operaciones.resuelveOperacion();
         operaciones.setOpcion(5);
         operaciones.resuelveOperacion();*/

       // CREO UN OBJETO DE LA CLASE OPERACION
		Operacion  operaciones= new Operacion();
		CommonHelpers helpers = new CommonHelpers();
		boolean ejecutar=true;
		
		while(ejecutar) {
			 operaciones.publicarMenu();
			 //PEDIMOS LOS DATOS DEL PAQUETE HELPERS Y DENTRO DE LA CLASE COMMONHELPERS EL  STRING PUBLIC DE LEERTECLADO , Y EL PARSEINT TRASNFORMA DEL STRING A UN ENTERO
			 operaciones.setOpcion(Integer.parseInt(helpers.leerTeclado()));
			 
			 if(operaciones.getOpcion() >0 && operaciones.getOpcion()<5); {
				 helpers.imprimirSalto("introduce operando 1");
				 operaciones.setOperador1(Integer.parseInt(helpers.leerTeclado()));
				 
				 helpers.imprimirSalto("introduce operando 2");
				 operaciones.setOperador2(Integer.parseInt(helpers.leerTeclado()));
				 
				 operaciones.resuelveOperacion();
				 helpers.imprimirSalto("Desea continuar ? (y/n)");
				 
				  String leido = helpers.leerTeclado();
				 if (leido.equalsIgnoreCase("n" )||(leido.equalsIgnoreCase("no")) ) {
					 
				 }
			 }
			 
		
			 
		}
		
 

	}

}
