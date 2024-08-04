package main;

import helpers.CommonHelpers;
import model.Rectangulo;
import model.modelRectangulo;

public class MainCalcularRectangulo {

	/*
	 * Realiza una clase rectángulo que contenga su ancho y alto
	 *  de manera que podamos calcular su área y perímetro. 
	 *  Recuerda probarlo luego 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		CommonHelpers ayudantes= new CommonHelpers();
		modelRectangulo rectangulo = new modelRectangulo();
		
		ayudantes.imprimirSalto("Introduce la base del rectángulo ");
		rectangulo.setBase(Float.parseFloat(ayudantes.leerTeclado()));
		
		ayudantes.imprimirSalto("Introduce la altura del rectángulo ");
		rectangulo.setAltura(Float.parseFloat(ayudantes.leerTeclado()));
		
	        rectangulo.calcularAreaRectangulo();
	        rectangulo.calcularPerimetroRectangulo();

	        
	        ayudantes.imprimirSalto("El área del rectángulo es "
	        +rectangulo.getArea()+
	        		" y el perímetro del rectángulo es "
	        + rectangulo.getPerímetro());
	        
	}
		
		
	}

