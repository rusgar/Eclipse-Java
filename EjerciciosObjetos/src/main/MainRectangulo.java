package main;

import helpers.CommonHelpers;
import model.Rectangulo;

public class MainRectangulo {

	public static void main(String[] args) {
		CommonHelpers ayudaHelpers = new CommonHelpers();
		double ancho;
		 double alto ;		
		
		System.out.print("Ingrese el ancho del rectángulo: ");
        ancho = ayudaHelpers.leerTecladoDouble();

        System.out.print("Ingrese el alto del rectángulo: ");
         alto = ayudaHelpers.leerTecladoDouble();
		
         Rectangulo poligono = new Rectangulo(ancho, alto);
		 ayudaHelpers.imprimirSalto("El área del rectángulo es: " + String.format("%.2f", poligono.calcularArea()));
		 ayudaHelpers.imprimirSalto("El perímetro del rectángulo es: " + String.format("%.2f", poligono.calcularPerimetro()));

        
	}

}
