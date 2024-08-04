package model;

import helpers.CommonHelpers;

public class Triangulo  {
    private double base;
    private double altura;
    private double lado1;
    private double lado2;
    private double lado3;
    private String tipo;

    public Triangulo(double base, double altura, double lado1, double lado2, double lado3, String tipo) {
    	this.base = base;
        this.altura = altura;
        this.lado1 = lado1;
        this.lado2 = lado2;
        this.lado3 = lado3;
        this.tipo = tipo;
    }

 

	public double calcularArea() {
        return (base * altura) / 2;
    }

    public double calcularPerimetro() {
        return lado1 + lado2 + lado3;
    }
    public String getTipo() {
        return tipo;
    }

public static void menuTriangulo(CommonHelpers helpers) {
	helpers.imprimirSalto("|********************************************|");
    helpers.imprimirSalto("| \tSELECCIONE EL TIPO DE TRIÁNGULO      |");
    helpers.imprimirSalto("| \t1.      Equilátero                   |");
    helpers.imprimirSalto("| \t2.      Isósceles                    |");
    helpers.imprimirSalto("| \t3.      Escaleno                     |");
    helpers.imprimirSalto("|       Ingrese una opción:                  |");
    helpers.imprimirSalto("|********************************************|");
    int tipoTriangulo = helpers.leerTecladoInt();
    
    switch (tipoTriangulo) {
    case 1:
        TrianguloEquilatero.menuTrianguloEquilatero(helpers);
        break;
    case 2:
        TrianguloIsosceles.menuTrianguloIsosceles(helpers);
        break;
    case 3:
        menuTrianguloEscaleno(helpers);
        break;
    default:
        helpers.imprimirSalto("Opción no válida. Por favor, seleccione una opción entre 1 y 3.");
        break;
}
}
private static void menuTrianguloEscaleno(CommonHelpers helpers) {
	helpers.imprimirSalto("|********************************************|");
    helpers.imprimirSalto("| \tSELECCIONE EL TIPO DE  ESCALENO      |");
    helpers.imprimirSalto("|\t1.         Acutángulo                |");
    helpers.imprimirSalto("|\t2.         Rectángulo                |");
    helpers.imprimirSalto("|\t3.         Obtusángulo               |");
    helpers.imprimirSalto("|       Ingrese una opción:                  |");
    helpers.imprimirSalto("|********************************************|");
    int tipoEscaleno = helpers.leerTecladoInt();
    switch (tipoEscaleno) {
        case 1:
            TrianguloAcutanguloEscaleno.menuTrianguloAcutanguloEscaleno(helpers);
            break;
        case 2:
            TrianguloRectanguloEscaleno.menuTrianguloRectanguloEscaleno(helpers);
            break;
        case 3:
            TrianguloObtusanguloEscaleno.menuTrianguloObtusanguloEscaleno(helpers);
            break;
        default:
            helpers.imprimirSalto("Opción no válida. Por favor, seleccione una opción entre 1 y 3.");
            break;
    }
}
}

