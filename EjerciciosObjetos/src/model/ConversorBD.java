package model;

import helpers.CommonHelpers;

public class ConversorBD {
//ATRIBUTOS Y PROPIEDADES  DE LA CLASE
private String binario;
 private int decimal;
 
 //GETTER Y SETTER
public String getBinario() {
	return binario;
}
public void setBinario(String binario) {
	this.binario = binario;
}
public int getDecimal() {
	return decimal;
}
public void setDecimal(int decimal) {
	this.decimal = decimal;
}


public ConversorBD() {
	super();
	this.binario = "";
	this.decimal = 0;}

//CONTRUCTOR DE TODOS LOS PARAMETROS
public ConversorBD(String binario, int decimal) {
	super();
	this.binario = binario;
	this.decimal = decimal;
}

// TO STRING
@Override
public String toString() {
	return "ConversorBD [binario=" + binario + ", decimal=" + decimal + "]";
}

//METODO VACIO QUE ALMACENA LAS CONVERSIOBES EN LA CLASE
public void convertirDecimal() {
	for(int i=0;i<binario.length();i++) {
		if(binario.charAt(i)=='1') {
			decimal+=(int)Math.pow(2, binario.length()-i -1);
		}
	
}
}

public void convertirBinario() {
	boolean ejecutar=true;
	int numDecimal=decimal;
	String numBinario="";
	while(ejecutar) {
 	numBinario+=String.valueOf(numDecimal%2);
		numDecimal = numDecimal/2;
		
		if(numDecimal ==1) {
			numBinario+=String.valueOf(numDecimal);
			ejecutar=false;
			
		}
		
	}for(int i = numBinario.length() - 1; i >= 0; i--) {
		binario+=numBinario.charAt(i);
	}
		
}

public void imprimeMenu() {
	 CommonHelpers ayudaHelpers = new CommonHelpers();
	 ayudaHelpers.imprimirSalto("\t\tMenu Conversor");
	 ayudaHelpers.imprimirSalto("\t\t1.Convierte a Binario");
	 ayudaHelpers.imprimirSalto("\t\t2.Convierte a Decimal");
	 ayudaHelpers.imprimirSalto("\t\t3.Salir");
	 ayudaHelpers.imprimirSalto("\t\tSeleccione una opción:");
	 
	 
}

}
