package model;

import helpers.CommonHelpers;

public class PoligonoRegular {
    private int numeroLados;
    private double longitudLado;

    public PoligonoRegular(int numeroLados, double longitudLado) {
        this.numeroLados = numeroLados;
        this.longitudLado = longitudLado;
    }

    public double calcularPerimetro() {
        return numeroLados * longitudLado;
    }

    public double calcularArea() {
        double apotema = longitudLado / (2 * Math.tan(Math.PI / numeroLados));
        return (calcularPerimetro() * apotema) / 2;
    }

    public static void menuPoligonoRegular(CommonHelpers helpers) {
    	int numeroLados = 0;
    	while (true) {
    	helpers.imprimirSalto("Ingrese el número de lados del polígono regular (entre 5 y 10, o 0 para volver al menú principal): ");
        numeroLados = helpers.leerTecladoInt();
        if (numeroLados == 0) {
            return;  
        }
        if (numeroLados >= 5 && numeroLados <= 10) {
            break;  
        } else {
            helpers.imprimirSalto("Número de lados no válido. Debe ser entre 5 y 10.");
        }
    }

    helpers.imprimirSalto("Ingrese la longitud de cada lado: ");
    double longitudLado = helpers.leerTecladoDouble();
    PoligonoRegular poligono = new PoligonoRegular(numeroLados, longitudLado);
    helpers.imprimirSalto("Área: " + String.format("%.2f", poligono.calcularArea()));
    helpers.imprimirSalto("Perímetro: " + String.format("%.2f", poligono.calcularPerimetro()));
}
}
