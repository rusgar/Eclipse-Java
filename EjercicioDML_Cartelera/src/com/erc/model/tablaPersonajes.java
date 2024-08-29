package com.erc.model;

public class tablaPersonajes {
	private int id, edad;
	private String nombre, descripcion;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public tablaPersonajes() {
		super();
		this.id = 0;
		this.edad = 0;
		this.nombre = "";
		this.descripcion = "";
	}
	public tablaPersonajes(int id, int edad, String nombre, String descripcion) {
		super();
		this.id = id;
		this.edad = edad;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}
	@Override
	public String toString() {
		return "tablaPersonajes [id=" + id + ", edad=" + edad + ", nombre=" + nombre + ", descripcion=" + descripcion
				+ "]";
	}
	
	
	
	
	
}
