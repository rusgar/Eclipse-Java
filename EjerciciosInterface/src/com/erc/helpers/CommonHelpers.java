package com.erc.helpers;

import java.text.DecimalFormat;
import java.util.Scanner;

public class CommonHelpers {
	
		
		public String leerTeclado() {
		String retorno="";
		Scanner sca= new Scanner(System.in);
		retorno=sca.nextLine();
		return retorno;
	}
		public int leerTecladoInt() {
			Scanner sca = new Scanner(System.in);
	        String entrada = sca.nextLine();
	        int valor = Integer.parseInt(entrada);
	        return valor;
		}
		public double leerTecladoDouble() {
			Scanner sca = new Scanner(System.in);
	        String entrada = sca.nextLine();
	        double valor = Double.parseDouble(entrada);
	        return valor;
	}
		

		public void imprimirSalto(String mensaje) {
			 System.out.println(mensaje);
		}
		public void imprimirContinuo(String mensaje) {
			 System.out.print(mensaje);
		}
		
		public int obtenerEntero(String cadena) {
			int retorno=0;
			retorno = Integer.parseInt(cadena);
			return retorno;
		}
		public double obtenerDouble(String cadena) {
			double retorno=0;
			retorno =Double.parseDouble(cadena);
			return retorno;
		}
		
		public String obtenerString(int entrada) {
			String retorno= "";
			retorno = String.valueOf(retorno);
			return retorno;
		}
		public String obtenerString(double entrada) {
			String retorno= "";
			retorno = String.valueOf(retorno);
			return retorno;
		}
		public String obtenerString(float entrada) {
			String retorno= "";
			retorno = String.valueOf(retorno);
			return retorno;
		}
		public float redondearFloat(float numero) {
			float numeroRedondeado = (float)0.0;
			String cadenaFormateada=String.format("%.2f", numero);
			numeroRedondeado = Float.parseFloat(cadenaFormateada);
			return numeroRedondeado;
		}
		public double redondearDouble(double numero) {
			double numeroRedondeado = 0.0;
			String cadenaFormateada=String.format("%.2f", numero);
			numeroRedondeado = Double.parseDouble(cadenaFormateada);
			return numeroRedondeado;
		}
		
		public double redondearDoubleN(double numero, int numeroDecimales) {
			double numeroRedondeado = (float)0.0;
			String cadenaFormateada=String.format("%" +numeroDecimales+".2f", numero);
			numeroRedondeado = Double.parseDouble(cadenaFormateada);
			return numeroRedondeado;
		}
	
		public double redondearND(double numero,
				int numeroDecimales) {
			double numeroRedondeado=0.0;
			String cadenaFormateada=
					String.format("%."+numeroDecimales+"f",
							numero);
			cadenaFormateada=cadenaFormateada.replace(',','.');
			numeroRedondeado= Double.parseDouble(cadenaFormateada);
			return numeroRedondeado;
		}
		
		public double redondear2D(double numero) {
			double numeroRedondeado=0.0;
			String cadenaFormateada=
					String.format("%.2f", numero);
			cadenaFormateada=cadenaFormateada.replace(',','.');
			numeroRedondeado= Double.parseDouble(cadenaFormateada);
			return numeroRedondeado;
		}
		
		public float redondear2D(float numero) {
			float numeroRedondeado=(float)0.0;
			DecimalFormat df = new DecimalFormat("#.00");
			String cadenaFormateada= df.format(numero);
			cadenaFormateada=cadenaFormateada.replace(',','.');
			numeroRedondeado= Float.parseFloat(cadenaFormateada);
			return numeroRedondeado;
		}
		
		 public boolean continuarBucle() {
			 boolean retorno=true;
			 imprimirSalto("¿Desea continuar? (y/n)");
			 String leido= leerTeclado();
			 if(leido.equalsIgnoreCase("n") ||(leido.equalsIgnoreCase("no"))) {
				 retorno =false;
				 imprimirSalto("Recuerdo que Java es molto divertente");
			 }return retorno;
		 }
			public String soloNumeros(String acumulador, char leido) {
				String retorno = acumulador;
				if(leido==',') {
					leido = '.';
				}
				boolean existeComa= false;
				if(retorno.contains(".")) {
					existeComa =true;
				}
			
				if(Character.isDigit(leido) || (leido== '.' && !existeComa)  || leido == '-'&& retorno.equalsIgnoreCase("") ) {
					retorno+=leido;
				}
				if(retorno.equals("") ) {
					retorno = "";
				}
				return retorno;
			}
			
		
	}


