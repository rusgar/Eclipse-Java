package model;

import helpers.CommonHelpers;

public class Trapecio extends Rectangulo {

    private double baseMenor;
    private double ladoIzquierdo;
    private double ladoDerecho;
    
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

	public double getBaseMenor() {
		return baseMenor;
	}

	public void setBaseMenor(double baseMenor) {
		this.baseMenor = baseMenor;
	}

	public Trapecio(double baseMayor, double baseMenor, double altura, double ladoIzquierdo, double ladoDerecho) {
        super(baseMayor, altura, "Trapecio");
        if (baseMenor >= baseMayor) {
            throw new IllegalArgumentException("La base menor debe ser menor que la base mayor");
        }
        this.baseMenor = baseMenor;
        this.ladoIzquierdo = ladoIzquierdo;
        this.ladoDerecho = ladoDerecho;
    }

    @Override
    public double calcularArea() {
        return ((base + baseMenor) / 2) * altura;
    }
    @Override
    public double calcularPerimetro() {
        return base + baseMenor + ladoIzquierdo + ladoDerecho;
    }
    
    public double calcularAnguloEntreDiagonales() {
        //USAME LA LEY DE COSENOS PARA EL CALCULO DEL ANGULO ENTRE LAS DIAGONALES
        double diagonalMayor = Math.sqrt(Math.pow(base - baseMenor, 2) + Math.pow(ladoIzquierdo, 2));
        double diagonalMenor = Math.sqrt(Math.pow(base - baseMenor, 2) + Math.pow(ladoDerecho, 2));
        double cosAngDia = (Math.pow(diagonalMayor, 2) + Math.pow(diagonalMenor, 2) - Math.pow(base - baseMenor, 2)) / (2 * diagonalMayor * diagonalMenor);
        cosAngDia = Math.max(-1, Math.min(1, cosAngDia)); // CALCULA EL RANGO VALIDO
        return Math.acos(cosAngDia); // DEVOLVEMOS EN RADIANES
    }
    public double calcularAnguloEntreDiagonalesGrados() {
        return Math.toDegrees(calcularAnguloEntreDiagonales()); // CONVERSION EN GRADOS
    }
    public static void menuTrapecio(CommonHelpers helpers) {
        helpers.imprimirSalto("Ingrese la base mayor del trapecio: ");
        double baseMayor = helpers.leerTecladoDouble();
        helpers.imprimirSalto("Ingrese la base menor del trapecio: ");
        double baseMenor = helpers.leerTecladoDouble();
        helpers.imprimirSalto("Ingrese la altura del trapecio: ");
        double altura = helpers.leerTecladoDouble();
        helpers.imprimirSalto("Ingrese el lado izquierdo del trapecio: ");
        double ladoIzquierdo = helpers.leerTecladoDouble();
        helpers.imprimirSalto("Ingrese el lado derecho del trapecio: ");
        double ladoDerecho = helpers.leerTecladoDouble();
        Trapecio trapecio = new Trapecio(baseMayor, baseMenor, altura, ladoIzquierdo, ladoDerecho);
        helpers.imprimirSalto("Área: " + String.format("%.2f", trapecio.calcularArea()));
        helpers.imprimirSalto("Perímetro: " + String.format("%.2f", trapecio.calcularPerimetro()));
        helpers.imprimirSalto("Ángulo entre diagonales (radianes): " + String.format("%.2f", trapecio.calcularAnguloEntreDiagonales()));
        helpers.imprimirSalto("Ángulo entre diagonales (grados): " + String.format("%.2f", trapecio.calcularAnguloEntreDiagonalesGrados()));
    }
}

