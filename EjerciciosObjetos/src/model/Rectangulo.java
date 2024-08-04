package model;

import helpers.CommonHelpers;

public class Rectangulo {
    protected double base;
    protected double altura;
    protected String tipo;

    public Rectangulo(double base, double altura, String tipo) {
        this.base = base;
        this.altura = altura;
        this.tipo = tipo;
    }

    public double calcularArea() {
        return base * altura;
    }

    public double calcularPerimetro() {
        return 2 * (base + altura);
    }

    public static void menuRectangulo(CommonHelpers helpers) {
    	helpers.imprimirSalto("|********************************************|");
        helpers.imprimirSalto("| \tSELECCIONE EL TIPO DE RECTÁNGULO     |");
        helpers.imprimirSalto("| \t1.        Romboide                   |");
        helpers.imprimirSalto("| \t2.        Trapecio                   |");
        helpers.imprimirSalto("| \t3.        Trapezoide                 |");
        helpers.imprimirSalto("|********************************************|");
        int tipoRectangulo = helpers.leerTecladoInt();
        switch (tipoRectangulo) {
            case 1:
                Romboide.menuRomboide(helpers);
                break;
            case 2:
                Trapecio.menuTrapecio(helpers);
                break;
            case 3:
            	Trapezoide.menuTrapezoide(helpers);
                break;
            default:
                helpers.imprimirSalto("Opción no válida. Por favor, seleccione una opción entre 1 y 3.");
                break;
        }
    }
}
