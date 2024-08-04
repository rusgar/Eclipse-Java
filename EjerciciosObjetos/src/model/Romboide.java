package model;

import helpers.CommonHelpers;

public class Romboide extends Rectangulo {

    private double angulo;

    public Romboide(double base, double altura, double angulo) {
        super(base, altura, "Romboide");
        this.angulo = angulo;
    }

    @Override
    public double calcularArea() {
        return base * altura * Math.sin(Math.toRadians(angulo));
    }

    public static void menuRomboide(CommonHelpers helpers) {
        helpers.imprimirSalto("Ingrese la base del romboide: ");
        double base = helpers.leerTecladoDouble();
        helpers.imprimirSalto("Ingrese la altura del romboide: ");
        double altura = helpers.leerTecladoDouble();
        helpers.imprimirSalto("Ingrese el ángulo del romboide (en grados): ");
        double angulo = helpers.leerTecladoDouble();
        Romboide romboide = new Romboide(base, altura, angulo);
        helpers.imprimirSalto("Área: " + String.format("%.2f", romboide.calcularArea()));
        helpers.imprimirSalto("Perímetro: " + String.format("%.2f", romboide.calcularPerimetro()));
    }
}
