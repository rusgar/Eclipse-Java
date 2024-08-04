package model;

import helpers.CommonHelpers;

public class TrianguloAcutanguloEscaleno extends TrianguloEscaleno {

    public TrianguloAcutanguloEscaleno(double base, double altura, double lado1, double lado2, double lado3) {
        super(base, altura, lado1, lado2, lado3);
    }

    public static void menuTrianguloAcutanguloEscaleno(CommonHelpers helpers) {
        helpers.imprimirSalto("Ingrese la base del triángulo acutángulo escaleno: ");
        double base = helpers.leerTecladoDouble();
        helpers.imprimirSalto("Ingrese la altura del triángulo acutángulo escaleno: ");
        double altura = helpers.leerTecladoDouble();
        helpers.imprimirSalto("Ingrese el lado 1 del triángulo acutángulo escaleno:");
        double lado1 = helpers.leerTecladoDouble();
        helpers.imprimirSalto("Ingrese el lado 2 del triángulo acutángulo escaleno:");
        double lado2 = helpers.leerTecladoDouble();
        helpers.imprimirSalto("Ingrese el lado 3 del triángulo acutángulo escaleno:");
        double lado3 = helpers.leerTecladoDouble();
        TrianguloAcutanguloEscaleno triangulo = new TrianguloAcutanguloEscaleno(base, altura, lado1, lado2, lado3);
        helpers.imprimirSalto("Área: " +  String.format("%.2f",triangulo.calcularArea()));
        helpers.imprimirSalto("Perímetro: " +  String.format("%.2f",triangulo.calcularPerimetro()));
    }
}