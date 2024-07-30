package model;

public class Barbacoa {
	private double costillasKg;
	private double ensaladaKg;


	// GETTER Y SETTER

	public double getCostillasKg() {
		return costillasKg;
	}

	public double getEnsaladaKg() {
		return ensaladaKg;
	}
	public void setCostillasKg(double costillasKg) {
		this.costillasKg = costillasKg;
	}

	public void setEnsaladaKg(double ensaladaKg) {
		this.ensaladaKg = ensaladaKg;
	}

	// CONSTRUCTORES
	public Barbacoa() {
		this.costillasKg = 0;
		this.ensaladaKg = 0;
	}


	public Barbacoa(double costillasKg, double ensaladaKg) {
		super();
		this.costillasKg = costillasKg;
		this.ensaladaKg = ensaladaKg;
	}

	@Override
	public String toString() {
		return "Barbacoa [costillasKg=" + costillasKg + ", ensaladaKg=" + ensaladaKg + "]";
	}

	// METODO PARA CALCULAR LOS CLIENTES QUE PODAMOS SERVIR
	// SEGUN EL EJERCICIO POR CADA 3 CLIENTES SE CONSUMEN 2 KG DE COSTILLAS Y 1 KG DE ENSALADA

	public int calcularClientes() {        
		int clientesPorCostillas = (int) (costillasKg / 2) * 3;
		int clientesPorEnsalada = (int) (ensaladaKg / 1) * 3;        
		return Math.min(clientesPorCostillas, clientesPorEnsalada);
	}


}
