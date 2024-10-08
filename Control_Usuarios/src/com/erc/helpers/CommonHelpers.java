package com.erc.helpers;


import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


/**
 * LA CLASE COMMONHELPERS PROPORCIONA MÉTODOS DE UTILIDAD COMUNES PARA OPERACIONES  DE CONVERSIÓN,
 *  ENTRADA/SALIDA Y MANEJO DE MENSAJES EN UNA APLICACIÓN.
 *  @author EDU RUS
 */
public class CommonHelpers {


	/**
	 * METODO QUE CONVIERTE UN STRING A DOUBLE
	 * @param valor
	 * @return
	 */
	public double stringToDouble(String entrada) {
		double retorno= 0.0;
		retorno = Double.parseDouble(entrada);
		return retorno;

	}


	/**
	 * METODO QUE REDONDEA EL DOUBLE A DOS DECIMALES
	 * @param valor
	 * @return
	 */
	public double redondear(double valor) {
		double retorno= 0.0;
		String cadena=String.format("%.2f", valor);
		cadena=cadena.replace(",", ".");
		retorno = stringToDouble(cadena);
		return retorno;
	}


	/**
	 * METODO QUE PASA DE UN DOUBLE A UN STRING
	 * @param valor
	 * @return
	 */
	public String doubleToString(double valor) {
		String retorno="";
		retorno=String.valueOf(valor);
		return retorno;
	}


	/**
	 *  METODO QUE PERMITE LA ENTRADA DE SOLO CARACTERES NUMERICOS,CONTROLANDO EL USO
	 *  DE PUNTO DE LOS DECIMALES, Y LOS SIGNOS NEGATIVOS
	 * @param acumulador
	 * @param leido
	 * @return
	 */
	public String soloNumeros(String acumulador, char leido) {
		String retorno=acumulador;
		// cambio coma por punto
		if(leido==',') {
			leido='.';
		}
		boolean existeComa=false;
		if(retorno.contains(".")) {
			existeComa=true;
		}

		if(Character.isDigit(leido)||
				(leido=='.'&& !existeComa)||
				leido=='-'&&retorno.equalsIgnoreCase("")) {
			retorno+=leido;
		}

		if(retorno.equals(".")) {
			retorno="";
		}
		return retorno;
	}


	/**
	 * CON ESTE METODO MOSTRAMOS UN MENSAJE AL USUARIO EN UNA VENTANA DE DIALOGO
	 * @param marco
	 * @param mensaje
	 * @param tipo
	 */
	public void mostrarMensaje(JFrame marco,
			String mensaje,
			String tipo) {
		int recursoIcono=0;
		String titulo="";
		switch (tipo) {
		case "informacion": {
			recursoIcono=JOptionPane.INFORMATION_MESSAGE;
			titulo="Información";
			break;
		}
		case "aviso": {
			recursoIcono=JOptionPane.WARNING_MESSAGE;
			titulo="Aviso";
			break;
		}
		case "error": {
			recursoIcono=JOptionPane.ERROR_MESSAGE;
			titulo="Error";
			break;
		}
		}

		JOptionPane.showMessageDialog(marco, 
				mensaje,titulo,recursoIcono);	

	}


	/**
	 * CON ESTE METODO  CONSEGUIMOS LEER UNA LINEA DE ENTRADA DEL CODIGO
	 * @return
	 */
	public String leerTeclado() {
		String retorno="";
		Scanner sc= new Scanner(System.in);
		retorno=sc.nextLine();
		return retorno;
	}

	/**
	 * CON ESTE METODO IMPRIMIMOS UNA LINEA A CONTINUACION DEL CODIGO
	 * @param entrada
	 */
	public void imprimir(String entrada) {
		System.out.print(entrada);
	}

	/**
	 * CON ESTE METODO IMPRIMIMOS CON UN SALTO DE LINEA EL CODIGO QUE NOS PIDE
	 * @param entrada
	 */
	public void imprimirSalto(String entrada) {
		System.out.println(entrada);
	}


	/**
	 * CONB ESTE METODO CONVERTIMOS UN STRING A UN NUMERO ENTERO
	 * @param entrada
	 * @return
	 */
	public int stringtoInt(String entrada) {
		int retorno=0;
		retorno=Integer.parseInt(entrada);
		return retorno;
	}


	/**
	 * CON ESTE METODO PODEMOS LEER UN NUMERO ENTERO POR EL TECLADO
	 * @return
	 */
	public int leerTecladoInt() {
		Scanner sca = new Scanner(System.in);
		String entrada = sca.nextLine();
		int valor = Integer.parseInt(entrada);
		return valor;
	}



}
