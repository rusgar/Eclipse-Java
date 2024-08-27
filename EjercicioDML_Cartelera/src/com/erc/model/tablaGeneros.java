package com.erc.model;

public class tablaGeneros {
	private int id;
	private String nombre;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public tablaGeneros() {
		super();
		// TODO Auto-generated constructor stub
	}
	public tablaGeneros(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}
	@Override
	public String toString() {
		return "tablaGeneros [id=" + id + ", nombre=" + nombre + "]";
	}
	
	
	

}
