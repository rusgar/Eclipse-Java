package main;

import java.util.Scanner;
import helpers.CommonHelpers;
import modelo.ConversorMonedas;


public class MainConversorEurosDolar {
	 public static void main(String[] args) {
	
	CommonHelpers ayudaHelpers = new CommonHelpers();
	ConversorMonedas  conversor= new ConversorMonedas();
	


    double resultado= 0.0;
    String resultadoFormateado="";

    ayudaHelpers.imprimirContinuo("Ingrese la cantidad a convertir: ");
    double cantidad =  ayudaHelpers.leerTecladoDouble();
    
    ayudaHelpers.imprimirContinuo("Ingrese la moneda de origen (euros o dolares): ");
    euros = ayudaHelpers.leerTeclado().toLowerCase();

    ayudaHelpers.imprimirContinuo("Ingrese la moneda de destino (euros o dolares): ");
     dolares = ayudaHelpers.leerTeclado().toLowerCase();
     
    

     resultado = conversor.convertir(cantidad, euros, dolares);
     resultadoFormateado = conversor.FormatearDecimales(resultado);

    if (resultado != 0) {
        System.out.println(cantidad + " " + monedaOrigen + " equivalen a " + resultadoFormateado + " " + monedaDestino);
    }

}
}
