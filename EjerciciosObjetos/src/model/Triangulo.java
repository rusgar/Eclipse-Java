package model;

import helpers.CommonHelpers;

public class Triangulo  {
    private double base;
    private double altura;
    private double lado1;
    private double lado2;
    private double lado3;
    private String tipo;

    public double getBase() {
		return base;
	}



	public void setBase(double base) {
		this.base = base;
	}



	public double getAltura() {
		return altura;
	}



	public void setAltura(double altura) {
		this.altura = altura;
	}



	public double getLado1() {
		return lado1;
	}



	public void setLado1(double lado1) {
		this.lado1 = lado1;
	}



	public double getLado2() {
		return lado2;
	}



	public void setLado2(double lado2) {
		this.lado2 = lado2;
	}



	public double getLado3() {
		return lado3;
	}



	public void setLado3(double lado3) {
		this.lado3 = lado3;
	}



	public void setTipo(String tipo) {
		this.tipo = tipo;
	}



	public Triangulo(double base, double altura, double lado1, double lado2, double lado3, String tipo) {
    	this.base = base;
        this.altura = altura;
        this.lado1 = lado1;
        this.lado2 = lado2;
        this.lado3 = lado3;
        this.tipo = tipo;
        if (!esTrianguloValido(lado1, lado2, lado3)) {
            throw new IllegalArgumentException("Los lados proporcionados no forman un triángulo válido.");
        }
    }
	private boolean esTrianguloValido(double a, double b, double c) {
        return (a + b > c) && (a + c > b) && (b + c > a);
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

    
    // EN UN TRIANGULO , EL ANGULO A ES EL ANGULO OPUESTO AL LADO 1 Y 
    // ASI CON LOS DEMAS ANGULO B ES EL LADO OPUESTO AL B
    // EL ANGULO C ES EL LADO OPUESTO AL C
    
    public double calcularAnguloA() {
        double anguloA = Math.acos((Math.pow(lado2, 2) + Math.pow(lado3, 2) - Math.pow(lado1, 2)) / (2 * lado2 * lado3));
        return anguloA;
    }
    
    public double calcularAnguloB() {
        double anguloB = Math.acos((Math.pow(lado1, 2) + Math.pow(lado3, 2) - Math.pow(lado2, 2)) / (2 * lado1 * lado3));
        return anguloB;
    }
    
    public double calcularAnguloC() {
        double anguloC = Math.acos((Math.pow(lado1, 2) + Math.pow(lado2, 2) - Math.pow(lado3, 2)) / (2 * lado1 * lado2));
        return anguloC;
    }
    
    public double calcularAnguloAEnGrados() {
        return Math.toDegrees(calcularAnguloA());
    }
    
    public double calcularAnguloBEnGrados() {
        return Math.toDegrees(calcularAnguloB());
    }
    
    public double calcularAnguloCEnGrados() {
        return Math.toDegrees(calcularAnguloC());
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

