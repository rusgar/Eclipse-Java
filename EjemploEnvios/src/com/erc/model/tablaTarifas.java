package com.erc.model;

public class tablaTarifas {
	
	private int id;
	private double precio;
	private String nombre;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	public tablaTarifas() {
		super();
		// TODO Auto-generated constructor stub
	}
	public tablaTarifas(int id, double precio, String nombre) {
		super();
		this.id = id;
		this.precio = precio;
		this.nombre = nombre;
	}
	@Override
	public String toString() {
		return "tablaTarifas [id=" + id + ", precio=" + precio + ", nombre=" + nombre + "]";
	}

	public String toString() {
		return "********************************\n"+
	           " Tabla Tarifas: *****************"+
				"\n\t id==>  " + id +
				", \n\t precio==>  " + precio + 
				", \n\t nombre==>  " + nombre + 
				"\n********************************\n";
	}
	
	
	
}
	
	
	