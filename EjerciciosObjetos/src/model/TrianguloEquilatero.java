package model;

import helpers.CommonHelpers;

public class TrianguloEquilatero extends Triangulo {

    public TrianguloEquilatero(double lado) {
        super(lado, Math.sqrt(3) / 2 * lado, lado, lado, lado, "Equilátero");
    }

    public static void menuTrianguloEquilatero(CommonHelpers helpers) {
        helpers.imprimirSalto("Ingrese el lado del triángulo equilátero: ");
        double lado = helpers.leerTecladoDouble();
        TrianguloEquilatero equilatero  = new TrianguloEquilatero(lado);
        helpers.imprimirSalto("Área: " + String.format("%.2f", equilatero.calcularArea()));
        helpers.imprimirSalto("Perímetro: " +String.format("%.2f", equilatero.calcularPerimetro()));
    }
}
