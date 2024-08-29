package com.erc.helpers;


import java.util.Scanner;

/**
 * CLASE CON METODOS DE USO GENERAL
 * @author EDU RC
 */
public class CommonHelpers {

	
	
	/**
	 * CON ESTE METODO GENERAMOS LA ENTRADA DESDE EL TECLADO
	 * @return string
	 */
	public static String leerTeclado() {
		String retorno="";
		Scanner sca= new Scanner(System.in);
		retorno=sca.nextLine();
		return retorno;
	}
	
	
	
	
	/**
	 * CON ESTE METODO NOS CONVIERTE EL STRING DE ENTRADA A UN TIPO DOUBLE
	 * @param entrada string
	 * @return double
	 */
	public static double stringToDouble(String entrada) {
		double retorno =0.0;
		retorno = Double.parseDouble(entrada);
        return retorno;
     }
	
	
	
	
	/**
	 *  CON ESTE METODO REDONDEAMOS EL VALOR DEL NUMERO PARA MOSTRAR SOLO DOS DECIMALES
	 * @param valor double
	 * @return double
	 */
	public static double redondearDouble(double valor) {
		double numero = 0.0;
		String cadena=String.format("%.2f", valor);
		numero = Double.parseDouble(cadena);
		return numero;
	}

	
	/**
	 * CON ESTE METODO REDONDEAMOS EL VALOR DE NUMERO A DOS DECIMALES 
	 * @param valor
	 * @param numeroDecimales
	 * @return double
	 */
	
	public static double redondearxDecimanles(double valor, double numeroDecimales) {
		double retorno =0.0;
		double exp= Math.pow(10, numeroDecimales);
		retorno = Math.ceil(valor*exp)/exp;		
		return retorno;		
	}
	
	
	
	
	
	public static String eliminarEspacios(String entrada) {
		
		String retorno="";
		retorno = retorno.replace(" ", "");
		return retorno;		
	}
	
}
