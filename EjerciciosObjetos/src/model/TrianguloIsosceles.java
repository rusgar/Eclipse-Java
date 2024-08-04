package model;

import helpers.CommonHelpers;

public class TrianguloIsosceles extends Triangulo {

    public TrianguloIsosceles(double base, double lado) {
        super(base, Math.sqrt(lado * lado - (base * base / 4)), lado, lado, base, "Isósceles");
    }

    public static void menuTrianguloIsosceles(CommonHelpers helpers) {
        helpers.imprimirSalto("Ingrese la base del triángulo isósceles: ");
        double base = helpers.leerTecladoDouble();
        helpers.imprimirSalto("Ingrese el lado del triángulo isósceles: ");
        double lado = helpers.leerTecladoDouble();
        TrianguloIsosceles isosceles = new TrianguloIsosceles(base, lado);
        helpers.imprimirSalto("Área: " + String.format("%.2f", isosceles.calcularArea()));
        helpers.imprimirSalto("Perímetro: " + String.format("%.2f", isosceles.calcularPerimetro()));
    }
}

