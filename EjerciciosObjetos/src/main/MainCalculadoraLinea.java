package main;

import helpers.CommonHelpers;
import modelo.Operacion;

public class MainCalculadoraLinea {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Operacion  operaciones= new Operacion();
		CommonHelpers helpers = new CommonHelpers();
		boolean ejecutar=true;
		String operacion="";


		while(ejecutar){
			System.out.println("introduzca la"
					+ " operacion(4 + 6)"
					+ "para salir (esc)");
			operacion=(helpers.leerTeclado());
			//VOY A DIVIDIR LA OPERACION EN CADA UNA DE  SUS PARTES CON UN SPLIT
			if(operacion.equalsIgnoreCase("esc")) {
				ejecutar=false;
				System.out.println("Que pase un buen día!!");
			}else {
				String [] partes=operacion.split(" ");

				if(partes.length==3) {
					// COMPROBACION PARA SABER QUE TENGO BIEN EL NÚMERO DE ELMENTOS

					try {
						operaciones.setOperador1(Integer.parseInt(helpers.leerTeclado()));
						String signo = partes[1];
						operaciones.setOperador2(Integer.parseInt(helpers.leerTeclado()));

						// LLAMO AL MÉTODO ESTÁTICO DE LA CLASE RESUELVEOPERACIONPARA RESOLVER LA OPERACIÓN
						operaciones.resuelveOperacion();
					} catch (NumberFormatException e) {
						System.out.println("Error: Formato de número no válido.");
					}
				} else {
					// SI LA LONGITUD DEL ARREGLO NO ES CORRECTA, MUESTRO UN MENSAJE DE ERROR
					System.out.println("Error: Formato de operación no válido.");
				}
			}
		}
	}
}