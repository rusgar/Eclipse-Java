package com.erc.model;

public class tablaTipos {
	private int id;
	private String nombre;
	
	//GETTERS Y SETTERS
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
	public tablaTipos() {
		super();
		this.id = 0;
		this.nombre = "";
	}
	public tablaTipos(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}
	@Override
	public String toString() {
		return "tablaTipos [id=" + id + ", nombre=" + nombre + "]";
	}
	
	

}
