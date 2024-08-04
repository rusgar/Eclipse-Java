package model;

import helpers.CommonHelpers;

public class TrianguloEquilatero extends Triangulo {

    public TrianguloEquilatero(double lado) {
        super(lado, Math.sqrt(3) / 2 * lado, lado, lado, lado, "Equilátero"); // ALTURA (h) = (LADO * √3) / 2
    }

    public static void menuTrianguloEquilatero(CommonHelpers helpers) {
        helpers.imprimirSalto("Ingrese el lado del triángulo equilátero: ");
        double lado = helpers.leerTecladoDouble();
        TrianguloEquilatero equilatero  = new TrianguloEquilatero(lado);
        helpers.imprimirSalto("Área: " + String.format("%.2f", equilatero.calcularArea()));
        helpers.imprimirSalto("Perímetro: " +String.format("%.2f", equilatero.calcularPerimetro()));
        helpers.imprimirSalto("Ángulo en el vértice superior (radianes): " + String.format("%.2f", equilatero.calcularAnguloA()));
        helpers.imprimirSalto("Ángulo en el vértice superior (grados): " + String.format("%.2f", equilatero.calcularAnguloAEnGrados()));
        helpers.imprimirSalto("Ángulo en los vértices inferiores (radianes): " + String.format("%.2f", equilatero.calcularAnguloB()));
        helpers.imprimirSalto("Ángulo en los vértices inferiores (grados): " + String.format("%.2f", equilatero.calcularAnguloBEnGrados()));
    }
}
