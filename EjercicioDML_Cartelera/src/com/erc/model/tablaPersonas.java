package com.erc.model;

import java.sql.Date;


public class tablaPersonas {
	private int id, idNacionalidad;
	private String nombre, apellido;
	private Date fechaNacimiento;
	
	// GETTER Y SETTER
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdNacionalidad() {
		return idNacionalidad;
	}
	public void setIdNacionalidad(int idNacionalidad) {
		this.idNacionalidad = idNacionalidad;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
		
	}	
	
	public tablaPersonas() {
		super();
		this.id = 0;
		this.idNacionalidad = 0;
		this.nombre = "";
		this.apellido = "";
		this.fechaNacimiento = Date.valueOf("1970-01-01");
	}
	public tablaPersonas(int id, int idNacionalidad, String nombre, String apellido, Date fechaNacimiento) {
		super();
		this.id = id;
		this.idNacionalidad = idNacionalidad;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
	}
	@Override
	public String toString() {
		return "tablaPersonas [id=" + id + ", idNacionalidad=" + idNacionalidad + ", nombre=" + nombre + ", apellido="
				+ apellido + ", fechaNacimiento=" + fechaNacimiento + "]";
	}
	
	

}
