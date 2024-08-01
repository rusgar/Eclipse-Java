package model;

public class CarneMenu {
	private String nombre;
	private int gramosPorRacion;
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getGramosPorRacion() {
		return gramosPorRacion;
	}
	public void setGramosPorRacion(int gramos) {
		this.gramosPorRacion = gramos;
	}
	 public  CarneMenu(String nombre, int gramosPorRacion) {
	        this.nombre = nombre;
	        this.gramosPorRacion = gramosPorRacion;
	    }
	public CarneMenu() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "CarneMenu [nombre=" + nombre + ", gramos=" + gramosPorRacion + "]";
	}
	

	
	
	
	

}
