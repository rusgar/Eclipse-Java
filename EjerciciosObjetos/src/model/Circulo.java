package model;
import helpers.CommonHelpers;

public class Circulo {
    private double radio;

    public Circulo(double radio) {
        this.radio = radio;
    }

    public double calcularArea() {
        return Math.PI * Math.pow(radio, 2);
    }

    public double calcularPerimetro() {
        return 2 * Math.PI * radio;
    }
    public static void menuCirculo(CommonHelpers helpers) {
        helpers.imprimirSalto("Ingrese el radio del círculo: ");
        double radio = helpers.leerTecladoDouble();
        Circulo circulo = new Circulo(radio);
        helpers.imprimirSalto("Área: " + circulo.calcularArea());
        helpers.imprimirSalto("Perímetro: " + circulo.calcularPerimetro());
    }
}