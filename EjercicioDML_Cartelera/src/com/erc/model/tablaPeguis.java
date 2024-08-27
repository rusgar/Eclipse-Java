package com.erc.model;

public class tablaPeguis {
	private int id, edad;
	private String nombre;
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
	public tablaPeguis() {
		super();
		this.id = 0;
		this.edad = 0;
		this.nombre = "";
	}
	
	public tablaPeguis(int id, int edad, String nombre) {
		super();
		this.id = id;
		this.edad = edad;
		this.nombre = nombre;
	}
	@Override
	public String toString() {
		return "tablaPeguis [id=" + id + ", edad=" + edad + ", nombre=" + nombre + "]";
	}
	
	

}
