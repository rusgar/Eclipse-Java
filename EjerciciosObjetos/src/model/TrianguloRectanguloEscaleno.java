package model;

import helpers.CommonHelpers;

public class TrianguloRectanguloEscaleno extends TrianguloEscaleno {

    public TrianguloRectanguloEscaleno(double base, double altura, double lado1, double lado2, double lado3) {
        super(base, altura, lado1, lado2, lado3);
    }

    public static void menuTrianguloRectanguloEscaleno(CommonHelpers helpers) {
        helpers.imprimirSalto("Ingrese la base del triángulo rectángulo escaleno: ");
        double base = helpers.leerTecladoDouble();
        helpers.imprimirSalto("Ingrese la altura del triángulo rectángulo escaleno: ");
        double altura = helpers.leerTecladoDouble();
        helpers.imprimirSalto("Ingrese el lado 1 del triángulo rectángulo escaleno:");
        double lado1 = helpers.leerTecladoDouble();
        helpers.imprimirSalto("Ingrese el lado 2 del triángulo rectángulo escaleno:");
        double lado2 = helpers.leerTecladoDouble();
        helpers.imprimirSalto("Ingrese el lado 3 del triángulo rectángulo escaleno:");
        double lado3 = helpers.leerTecladoDouble();
        TrianguloRectanguloEscaleno triangulo = new TrianguloRectanguloEscaleno(base, altura, lado1, lado2, lado3);
        helpers.imprimirSalto("Área: " + triangulo.calcularArea());
        helpers.imprimirSalto("Perímetro: " + triangulo.calcularPerimetro());
        helpers.imprimirSalto("Ángulo A (radianes): " + String.format("%.2f", triangulo.calcularAnguloA()));
        helpers.imprimirSalto("Ángulo A (grados): " + String.format("%.2f", triangulo.calcularAnguloAEnGrados()));
        helpers.imprimirSalto("Ángulo B (radianes): " + String.format("%.2f", triangulo.calcularAnguloB()));
        helpers.imprimirSalto("Ángulo B (grados): " + String.format("%.2f", triangulo.calcularAnguloBEnGrados()));
        helpers.imprimirSalto("Ángulo C (radianes): " + String.format("%.2f", triangulo.calcularAnguloC()));
        helpers.imprimirSalto("Ángulo C (grados): " + String.format("%.2f", triangulo.calcularAnguloCEnGrados()));
    }
}

