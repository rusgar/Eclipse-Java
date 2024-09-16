package com.erc.helpers;


import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class CommonHelpers {
public double stringToDouble(String entrada) {
	double retorno= 0.0;
	retorno = Double.parseDouble(entrada);
	return retorno;


}


public double redondear(double valor) {
	double retorno= 0.0;
	String cadena=String.format("%.2f", valor);
	cadena=cadena.replace(",", ".");
	retorno = stringToDouble(cadena);
	return retorno;
}

public String doubleToString(double valor) {
	String retorno="";
	retorno=String.valueOf(valor);
	return retorno;
}

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

public String leerTeclado() {
	String retorno="";
	Scanner sc= new Scanner(System.in);
	retorno=sc.nextLine();
	return retorno;
}

public void imprimir(String entrada) {
	System.out.print(entrada);
}

public void imprimirSalto(String entrada) {
	System.out.println(entrada);
}

public int stringtoInt(String entrada) {
	int retorno=0;
	retorno=Integer.parseInt(entrada);
	return retorno;
}

public int leerTecladoInt() {
	Scanner sca = new Scanner(System.in);
    String entrada = sca.nextLine();
    int valor = Integer.parseInt(entrada);
    return valor;
}



}
