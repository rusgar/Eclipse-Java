package model;

public class MenuCarne {
	private  double costillas = 150.0;
    private  double panceta = 100.0;
    private  double salchichas = 120.0;
    private double chorizo = 180.0;
    private  double morcilla = 180.0;
    private  double secreto = 200.0;
 
 public static final double adultoGr = 800.0;
 public static final double niñoGR = 400.0;
 
public double getCostillas() {
	return costillas;
}
public void setCostillas(double costillas) {
	this.costillas = costillas;
}
public double getPanceta() {
	return panceta;
}
public void setPanceta(double panceta) {
	this.panceta = panceta;
}
public double getSalchichas() {
	return salchichas;
}
public void setSalchichas(double salchichas) {
	this.salchichas = salchichas;
}
public double getChorizo() {
	return chorizo;
}
public void setChorizo(double chorizo) {
	this.chorizo = chorizo;
}
public double getMorcilla() {
	return morcilla;
}
public void setMorcilla(double morcilla) {
	this.morcilla = morcilla;
}
public double getSecreto() {
	return secreto;
}
public void setSecreto(double secreto) {
	this.secreto = secreto;
}


public double calcularCantidadCostillas(int numAdultos, int numNinos) {
    return calcularCantidad(costillas, numAdultos, numNinos);
}
public double calcularCantidadPanceta(int numAdultos, int numNinos) {
    return calcularCantidad(panceta, numAdultos, numNinos);
}

public double calcularCantidadSalchichas(int numAdultos, int numNinos) {
    return calcularCantidad(salchichas, numAdultos, numNinos);
}
public double calcularCantidadChorizo(int numAdultos, int numNinos) {
    return calcularCantidad(chorizo, numAdultos, numNinos);
}
public double calcularCantidadMorcilla(int numAdultos, int numNinos) {
    return calcularCantidad(morcilla, numAdultos, numNinos);
}
public double calcularCantidadSecreto(int numAdultos, int numNinos) {
    return calcularCantidad(secreto, numAdultos, numNinos);
}
public MenuCarne(double costillas, double panceta, double salchichas, double chorizo, double morcilla,
		double secreto) {
	super();
	this.costillas = costillas;
	this.panceta = panceta;
	this.salchichas = salchichas;
	this.chorizo = chorizo;
	this.morcilla = morcilla;
	this.secreto = secreto;
}
public MenuCarne() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "MenuRestaurante [costillas=" + costillas + ", panceta=" + panceta + ", salchichas=" + salchichas
			+ ", chorizo=" + chorizo + ", morcilla=" + morcilla + ", secreto=" + secreto + "]";
}
public double calcularCantidad(double cantidadPorPlato, int numAdultos, int numNinos) {
	double totalGramos = (numAdultos * adultoGr) + (numNinos * niñoGR);
    return totalGramos / cantidadPorPlato;
}
public double calcularRacionIndividual(double precioPorKilo, double gramosPorPersona) {
    double cantidadNecesariaEnKilos = gramosPorPersona / 1000.0;
    return cantidadNecesariaEnKilos / precioPorKilo;
}
public String obtenerNombrePlato(int opcion) {
    switch (opcion) {
        case 1: return "Costillas";
        case 2: return "Panceta";
        case 3: return "Salchichas";
        case 4: return "Chorizo";
        case 5: return "Morcilla";
        case 6: return "Secreto";
        default: throw new IllegalArgumentException("Opción no válida");
    }
}
    public  double obtenerCantidadPorPlato(int opcion, MenuCarne restaurante) {
        switch (opcion) {
            case 1: return restaurante.getCostillas();
            case 2: return restaurante.getPanceta();
            case 3: return restaurante.getSalchichas();
            case 4: return restaurante.getChorizo();
            case 5: return restaurante.getMorcilla();
            case 6: return restaurante.getSecreto();
            default: throw new IllegalArgumentException("Opción no válida");
        }

    }

}

 

