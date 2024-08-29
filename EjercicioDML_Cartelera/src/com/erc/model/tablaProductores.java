package com.erc.model;

public class tablaProductores {

	
	private int id, id_persona;
	private double inversion;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId_persona() {
		return id_persona;
	}
	public void setId_persona(int id_persona) {
		this.id_persona = id_persona;
	}
	public double getInversion() {
		return inversion;
	}
	public void setInversion(double inversion) {
		this.inversion = inversion;
	}
	public tablaProductores() {
		super();
		this.id = 0;
		this.id_persona = 0;
		this.inversion = 0.0;
	}
	public tablaProductores(int id, int id_persona, double inversion) {
		super();
		this.id = id;
		this.id_persona = id_persona;
		this.inversion = inversion;
	}
	@Override
	public String toString() {
		return "tablaProductores [id=" + id + ", id_persona=" + id_persona + ", inversion=" + inversion + "]";
	}
	
	
	
	
}
