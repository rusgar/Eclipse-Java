package model;

import helpers.CommonHelpers;

public class Trapezoide extends Rectangulo {

    private double baseMenor;
    private double ladoIzquierdo;
    private double ladoDerecho;
    private double diagonalMayor;
    private double diagonalMenor;
    

    public double getLadoIzquierdo() {
		return ladoIzquierdo;
	}

	public void setLadoIzquierdo(double ladoIzquierdo) {
		this.ladoIzquierdo = ladoIzquierdo;
	}

	public double getLadoDerecho() {
		return ladoDerecho;
	}

	public void setLadoDerecho(double ladoDerecho) {
		this.ladoDerecho = ladoDerecho;
	}

	public double getDiagonalMayor() {
		return diagonalMayor;
	}

	public void setDiagonalMayor(double diagonalMayor) {
		this.diagonalMayor = diagonalMayor;
	}

	public double getDiagonalMenor() {
		return diagonalMenor;
	}

	public void setDiagonalMenor(double diagonalMenor) {
		this.diagonalMenor = diagonalMenor;
	}

	public double getBaseMenor() {
		return baseMenor;
	}

	public void setBaseMenor(double baseMenor) {
		this.baseMenor = baseMenor;
	}

    public Trapezoide(double baseMayor, double baseMenor, double altura, double ladoIzquierdo, double ladoDerecho, double diagonalMayor, double diagonalMenor) {
        super(baseMayor, altura, "Trapezoide");
        if (baseMenor >= baseMayor) {
            throw new IllegalArgumentException("La base menor debe ser menor que la base mayor");
        }
        this.baseMenor = baseMenor;
        this.ladoIzquierdo = ladoIzquierdo;
        this.ladoDerecho = ladoDerecho;
        this.diagonalMayor = diagonalMayor;
        this.diagonalMenor = diagonalMenor;
    }

    @Override
    public double calcularPerimetro() {
    	// CALCULAMOS LA LONGITUD DE LOS DOS LADOS NO PARALELOS USANDO EL TEOREMA DE PITAGORAS(HIPOTENUSA)
        double hipotenusa = Math.sqrt(Math.pow(altura, 2) + Math.pow(base - baseMenor, 2));
        return base + baseMenor + altura + hipotenusa;
    }
    @Override
    public double calcularArea() {
        return ((base + baseMenor) / 2) * altura;
    }
    
    public double calcularAnguloEntreDiagonales() {
        //USAME LA LEY DE COSENOS PARA EL CALCULO DEL ANGULO ENTRE LAS DIAGONALES
        double cosAngDIa = (Math.pow(diagonalMayor, 2) + Math.pow(diagonalMenor, 2) - Math.pow(base - baseMenor, 2)) / (2 * diagonalMayor * diagonalMenor);
        cosAngDIa = Math.max(-1, Math.min(1, cosAngDIa)); // CALCULA EL RANGO VALIDO
        return Math.acos(cosAngDIa); //   DEVUELVE RADIANTES
    }
    
    public double calcularAnguloEntreDiagonalesGrados() {
        return Math.toDegrees(calcularAnguloEntreDiagonales()); // CONVERSION EN GRADOS
    }

    public static void menuTrapezoide(CommonHelpers helpers) {
        helpers.imprimirSalto("Ingrese la base mayor del Trapezoide: ");
        double baseMayor = helpers.leerTecladoDouble();
        helpers.imprimirSalto("Ingrese la base menor del Trapezoide: ");
        double baseMenor = helpers.leerTecladoDouble();
        helpers.imprimirSalto("Ingrese la altura del Trapezoide: ");
        double altura = helpers.leerTecladoDouble();
        helpers.imprimirSalto("Ingrese el lado izquierdo del trapecioide: ");
        double ladoIzquierdo = helpers.leerTecladoDouble();
        helpers.imprimirSalto("Ingrese el lado derecho del trapecioide: ");
        double ladoDerecho = helpers.leerTecladoDouble();
        helpers.imprimirSalto("Ingrese la diagonal mayor del trapecioide: ");
        double diagonalMayor = helpers.leerTecladoDouble();
        helpers.imprimirSalto("Ingrese la diagonal menor del trapecioide: ");
        double diagonalMenor = helpers.leerTecladoDouble();
        
        Trapezoide  trapecioide = new Trapezoide (baseMayor, baseMenor, altura, ladoIzquierdo, ladoDerecho, diagonalMayor, diagonalMenor);
        helpers.imprimirSalto("Área: " + String.format("%.2f", trapecioide.calcularArea()));
        helpers.imprimirSalto("Perímetro: " + String.format("%.2f", trapecioide.calcularPerimetro()));
        helpers.imprimirSalto("Ángulo entre diagonales (radianes): " + String.format("%.2f", trapecioide.calcularAnguloEntreDiagonales()));
        helpers.imprimirSalto("Ángulo entre diagonales (grados): " + String.format("%.2f", trapecioide.calcularAnguloEntreDiagonalesGrados()));
    }
}
