package model;

import helpers.CommonHelpers;

public class Trapezoide extends Rectangulo {

    private double baseMenor;

    public Trapezoide(double baseMayor, double baseMenor, double altura) {
        super(baseMayor, altura, "Trapezoide");
        this.baseMenor = baseMenor;
    }

    @Override
    public double calcularPerimetro() {
    	// CALCULAMOS LA LONGITUD DE LOS DOS LADOS NO PARALELOS USANDO EL TEOREMA DE PITAGORAS(HIPOTENUSA)
        double hipotenusa = Math.sqrt(Math.pow(altura, 2) + Math.pow(base - baseMenor, 2));
        return base + baseMenor + altura + hipotenusa;
    }

    public static void menuTrapezoide(CommonHelpers helpers) {
        helpers.imprimirSalto("Ingrese la base mayor del Trapezoide: ");
        double baseMayor = helpers.leerTecladoDouble();
        helpers.imprimirSalto("Ingrese la base menor del Trapezoide: ");
        double baseMenor = helpers.leerTecladoDouble();
        helpers.imprimirSalto("Ingrese la altura del Trapezoide: ");
        double altura = helpers.leerTecladoDouble();
        Trapezoide trapecioRectangulo = new Trapezoide(baseMayor, baseMenor, altura);
        helpers.imprimirSalto("Área: " + String.format("%.2f", trapecioRectangulo.calcularArea()));
        helpers.imprimirSalto("Perímetro: " + String.format("%.2f", trapecioRectangulo.calcularPerimetro()));
    }
}
