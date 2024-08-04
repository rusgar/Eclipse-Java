package model;

import helpers.CommonHelpers;

public class TrianguloIsosceles extends Triangulo {

    public TrianguloIsosceles(double base, double lado) {
        super(base, Math.sqrt(lado * lado - (base * base / 4)), lado, lado, base, "Isósceles");
        // SE UTILIZA EL TEOREMA DE PITÁGORAS PARA ENCONTRAR LA ALTURA,
        //CONSIDERANDO QUE EL TRIÁNGULO ISÓSCELES PUEDE DIVIDIRSE EN DOS TRIÁNGULOS RECTÁNGULOS IGUALES.
    }

    public static void menuTrianguloIsosceles(CommonHelpers helpers) {
        helpers.imprimirSalto("Ingrese la base del triángulo isósceles: ");
        double base = helpers.leerTecladoDouble();
        helpers.imprimirSalto("Ingrese el lado del triángulo isósceles: ");
        double lado = helpers.leerTecladoDouble();
        TrianguloIsosceles isosceles = new TrianguloIsosceles(base, lado);
        helpers.imprimirSalto("Área: " + String.format("%.2f", isosceles.calcularArea()));
        helpers.imprimirSalto("Perímetro: " + String.format("%.2f", isosceles.calcularPerimetro()));
        helpers.imprimirSalto("Ángulo en el vértice superior (radianes): " + String.format("%.2f", isosceles.calcularAnguloA()));
        helpers.imprimirSalto("Ángulo en el vértice superior (grados): " + String.format("%.2f", isosceles.calcularAnguloAEnGrados()));
        helpers.imprimirSalto("Ángulo en los vértices inferiores (radianes): " + String.format("%.2f", isosceles.calcularAnguloB()));
        helpers.imprimirSalto("Ángulo en los vértices inferiores (grados): " + String.format("%.2f", isosceles.calcularAnguloBEnGrados()));
        
    }
}

