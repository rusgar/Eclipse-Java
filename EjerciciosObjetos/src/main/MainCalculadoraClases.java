package main;

import helpers.CommonHelpers;
import model.Operacion;

public class MainCalculadoraClases {

	public static void main(String[] args) {
		
		// CREAMOS LAS VARIABLE A UTILIZAR
			
			String lecturaTeclado= "";
			boolean ejecutar=true; // VARIABLE DE CONTROL
			CommonHelpers ayudaHelpers = new CommonHelpers();
			Operacion calcularOperacion= new Operacion();
			
			while(ejecutar) {
				 ayudaHelpers.imprimirSalto("Introduzca la operacion(3 + 5)");
				 lecturaTeclado=ayudaHelpers.leerTeclado();
				 String [] partes= lecturaTeclado.split(" ");
				 
				 if(partes.length==3){
					 try {
						 calcularOperacion.setOperador1(Integer.parseInt(partes[0]));
						 calcularOperacion.setOperador2(Integer.parseInt(partes[2]));
						 switch(partes [1]) {
						 case "+":{
							 calcularOperacion.setOpcion(1);
							 break;
						 }
						 case "-":{
							 calcularOperacion.setOpcion(2);
							 break;
						 }
						 case "*":{
							 calcularOperacion.setOpcion(3);
							 break;
						 }
						 case "/":{
							 calcularOperacion.setOpcion(4);
							 break;
						 }
						 default:{
							 calcularOperacion.setOpcion(0);
						 }
						 }
					 calcularOperacion.resuelveOperacion();
				 }catch(ArithmeticException artEx) {
					 ayudaHelpers.imprimirSalto("Error por la division por 0");
				 }catch (Exception e) {
						e.printStackTrace();
					}
					 ayudaHelpers.imprimirSalto("¿Desea continuar? (y/n)");
					 lecturaTeclado=ayudaHelpers.leerTeclado();
					 if(lecturaTeclado.equalsIgnoreCase("n") || lecturaTeclado.equalsIgnoreCase("no"))
						 ejecutar= false;
					 ayudaHelpers.imprimirSalto("Saliendo del programa");
					 
				 }else {
					 ayudaHelpers.imprimirSalto("Error en la entrda de parametros");
				 }
				
					 
				 }
					 
				 }

}
