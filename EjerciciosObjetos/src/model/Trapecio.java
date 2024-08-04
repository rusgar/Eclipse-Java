package model;

import helpers.CommonHelpers;

public class Trapecio extends Rectangulo {

    private double baseMenor;

    public Trapecio(double baseMayor, double baseMenor, double altura) {
        super(baseMayor, altura, "Trapecio");
        this.baseMenor = baseMenor;
    }

    @Override
    public double calcularArea() {
        return ((base + baseMenor) / 2) * altura;
    }

    public static void menuTrapecio(CommonHelpers helpers) {
        helpers.imprimirSalto("Ingrese la base mayor del trapecio: ");
        double baseMayor = helpers.leerTecladoDouble();
        helpers.imprimirSalto("Ingrese la base menor del trapecio: ");
        double baseMenor = helpers.leerTecladoDouble();
        helpers.imprimirSalto("Ingrese la altura del trapecio: ");
        double altura = helpers.leerTecladoDouble();
        Trapecio trapecio = new Trapecio(baseMayor, baseMenor, altura);
        helpers.imprimirSalto("Área: " + String.format("%.2f", trapecio.calcularArea()));
        helpers.imprimirSalto("Perímetro: " + String.format("%.2f", trapecio.calcularPerimetro()));
    }
}

