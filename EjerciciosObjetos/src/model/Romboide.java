package model;

import helpers.CommonHelpers;

public class Romboide extends Rectangulo {

    private double diagonalMayor;
    private double diagonalMenor;
    

    public Romboide(double base, double altura, double diagonalMayor, double diagonalMenor) {
        super(base, altura, "Romboide");
        this.diagonalMayor = diagonalMayor;
        this.diagonalMenor = diagonalMenor;
    }

    @Override
    public double calcularArea() {
    	return (diagonalMayor * diagonalMenor) / 2;
    	// ES LA FÓRMULA ESPECÍFICA PARA CALCULAR EL ÁREA DE UN ROMBOIDE UTILIZANDO SUS DIAGONALES.
    }
    
    @Override
    public double calcularPerimetro() {
        // CALCULA EL PERIMETRO DE UN ROMBOIDE UTILIZANDO BASE POR ALTURA
        return 2 * (base + altura);
    }
    
    public double calcularLongitudLado() {
        // CALCULA LA LONGITUD DEL LADO USANDO LA BASE, ALTURA Y DIAGONALES
    	 double medioDiagonalMayor = diagonalMayor / 2;
         double medioDiagonalMenor = diagonalMenor / 2;
         return Math.sqrt(Math.pow(medioDiagonalMayor, 2) + Math.pow(medioDiagonalMenor, 2));
    }
    public double calcularAnguloEntreDiagonales() {
        // CALCULA EL ANGULO EN RADIANTES ENTRE LAS DIAGONALES USANDO LA LEY DE COSENOS
        double lado = calcularLongitudLado();
        if (lado <= 0) {
            return Double.NaN; //SI NO PUEDE CALCULARLO DEVOLVER NAN
        }
        double cosAngDia = (Math.pow(diagonalMayor, 2) + Math.pow(diagonalMenor, 2) - 2 * Math.pow(lado, 2)) / (2 * diagonalMayor * diagonalMenor);
        return Math.acos(cosAngDia); // DEVUELVE RADIANTES
    }
    public double calcularAnguloEntreDiagonalesGrados() {
        return Math.toDegrees(calcularAnguloEntreDiagonales()); // CONVERSION EN GRADOS
    }

    public static void menuRomboide(CommonHelpers helpers) {
        helpers.imprimirSalto("Ingrese la base del romboide: ");
        double base = helpers.leerTecladoDouble();
        helpers.imprimirSalto("Ingrese la altura del romboide: ");
        double altura = helpers.leerTecladoDouble();
        helpers.imprimirSalto("Ingrese la diagonal mayor del romboide: ");
        double diagonalMayor = helpers.leerTecladoDouble();
        helpers.imprimirSalto("Ingrese la diagonal menor del romboide: ");
        double diagonalMenor = helpers.leerTecladoDouble();
        
        Romboide romboide = new Romboide(base, altura, diagonalMayor, diagonalMenor);
        helpers.imprimirSalto("Área: " + String.format("%.2f", romboide.calcularArea()));
        helpers.imprimirSalto("Perímetro: " + String.format("%.2f", romboide.calcularPerimetro()));
        helpers.imprimirSalto("Ángulo entre diagonales (radianes): " + String.format("%.2f", romboide.calcularAnguloEntreDiagonales()));
        helpers.imprimirSalto("Ángulo entre diagonales (grados): " + String.format("%.2f", romboide.calcularAnguloEntreDiagonalesGrados()));
    }
}
