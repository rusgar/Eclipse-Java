package main;

import helpers.CommonHelpers;
import modelo.Operacion;

public class MainCalculadora {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// creo un objeto de la clase operacion
		Operacion operaciones=new Operacion();
		CommonHelpers helpers= new CommonHelpers();
		boolean ejecutar=true;
		
		while(ejecutar) {
			//publicar el menu
			operaciones.publicarMenu();
			// pedir los datos
			//operaciones.setOpcion
			//(Integer.parseInt(helpers.leerTeclado()));
			String leido= helpers.leerTeclado();//leo el teclado
			//transformo el string leido en entero
			int opcionEntero=Integer.parseInt(leido);
			// voy a guardar el valor en operaciones
			operaciones.setOpcion(opcionEntero);
			
			if(operaciones.getOpcion()>0 &&
					operaciones.getOpcion()<5) {
				// pedir los operandos
				helpers.imprimirSalto
				("Introduce operando 1");
				//operaciones.setOperando1
				//(Integer.parseInt(helpers.leerTeclado()));
				leido= helpers.leerTeclado();//leo el teclado
				//transformo el string leido en entero
				int operando=Integer.parseInt(leido);
				// voy a guardar el valor en operaciones
				operaciones.setOperador1(operando);
				
				
				
				helpers.imprimirSalto
				("Introduce operando 2");
				//operaciones.setOperando2
				//(Integer.parseInt(helpers.leerTeclado()));
				leido= helpers.leerTeclado();//leo el teclado
				//transformo el string leido en entero
				operando=Integer.parseInt(leido);
				// voy a guardar el valor en operaciones
				operaciones.setOperador2(operando);
				
			
				}
			
			//resuelvo la operación
			operaciones.resuelveOperacion();
			
			helpers.imprimirSalto(" ¿Desea continuar?(y/n)");
			leido= helpers.leerTeclado();//leo el teclado
			if(leido.equalsIgnoreCase("n")||
					(leido.equalsIgnoreCase("no"))) {
				ejecutar=false;
				helpers.imprimirSalto("Gracias por usar"
						+ "los servicos de cálculo de IMS");
			}
		}
		
		
		
	}

}
