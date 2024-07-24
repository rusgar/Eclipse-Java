package main;
import helpers.CommonHelpers;
import modelo.Operacion1;

public class MainCalLinea {

	public static void main(String[] args) {
		
	// CREAMOS LAS VARIABLE A UTILIZAR
		
		String lecturaTeclado= "";
		boolean ejecutar=true; // VARIABLE DE CONTROL
		CommonHelpers ayudaHelpers = new CommonHelpers();
		Operacion1  calcularOperacion= new Operacion1();
		
		while(ejecutar) {
			 ayudaHelpers.imprimirSalto("Introduzca la operacion(3 + 5)");
			 lecturaTeclado=ayudaHelpers.leerTeclado();
			 String [] partes= lecturaTeclado.split(" ");
			 
			 if(partes.length==3){
				 try {
				 calcularOperacion.setNumero1(Integer.parseInt(partes[0]));
				 calcularOperacion.setSigno(partes[1]);
				 calcularOperacion.setNumero2(Integer.parseInt(partes[2]));
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
		


