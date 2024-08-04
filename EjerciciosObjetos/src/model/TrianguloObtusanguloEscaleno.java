package model;

import helpers.CommonHelpers;

public class TrianguloObtusanguloEscaleno extends TrianguloEscaleno {

    public TrianguloObtusanguloEscaleno(double base, double altura, double lado1, double lado2, double lado3) {
        super(base, altura, lado1, lado2, lado3);
    }

    public static void menuTrianguloObtusanguloEscaleno(CommonHelpers helpers) {
        helpers.imprimirSalto("Ingrese la base del triángulo obtusángulo escaleno: ");
        double base = helpers.leerTecladoDouble();
        helpers.imprimirSalto("Ingrese la altura del triángulo obtusángulo escaleno: ");
        double altura = helpers.leerTecladoDouble();
        helpers.imprimirSalto("Ingrese el lado 1 del triángulo obtusángulo escaleno:");
        double lado1 = helpers.leerTecladoDouble();
        helpers.imprimirSalto("Ingrese el lado 2 del triángulo obtusángulo escaleno:");
        double lado2 = helpers.leerTecladoDouble();
        helpers.imprimirSalto("Ingrese el lado 3 del triángulo obtusángulo escaleno:");
        double lado3 = helpers.leerTecladoDouble();
        TrianguloObtusanguloEscaleno triangulo = new TrianguloObtusanguloEscaleno(base, altura, lado1, lado2, lado3);
        helpers.imprimirSalto("Área: " +  String.format("%.2f",triangulo.calcularArea()));
        helpers.imprimirSalto("Perímetro: " +  String.format("%.2f",triangulo.calcularPerimetro()));
    }
}
