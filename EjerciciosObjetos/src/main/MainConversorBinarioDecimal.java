package main;

import helpers.CommonHelpers;

public class MainConversorBinarioDecimal {

	public static void main(String[] args) {
		//
		CommonHelpers ayudaHelpers = new CommonHelpers();// OBJETO DE LA CLASE COMMONHELPERS
		String numeroBinario="";//RECIBE EL NUMERO DEL USUARIO
		int numeroDecimal=0;
		boolean esBinario=true;
		ayudaHelpers.imprimirSalto("Dame el numero Binario");
		numeroBinario=ayudaHelpers.leerTeclado();
		
		for(int i=0;i<numeroBinario.length();i++) {
			if(numeroBinario.charAt(i)=='1') {
				numeroDecimal+=(int)Math.pow(2, numeroBinario.length()-i -1);
			}else {
				if(numeroBinario.charAt(i)!='0') {
					ayudaHelpers.imprimirSalto("Error: El número binario contiene caracteres inválidos.");
					esBinario=false;
				}
				}
			}if (esBinario) {
				ayudaHelpers.imprimirSalto("El numero binario"+numeroBinario+" => "+ numeroDecimal);
				
			}else {
				ayudaHelpers.imprimirSalto("Error: El número binario contiene caracteres inválidos.");
			}
			
		}
	}
	

