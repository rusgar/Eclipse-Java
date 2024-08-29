package com.erc.model;

import java.sql.Date;

public class tablaPremios {
	private int id, id_pelicula, id_tipo;
	private String nombre;
	private Date fecha;
	
	//GETTER Y SETTER
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId_pelicula() {
		return id_pelicula;
	}
	public void setId_pelicula(int id_pelicula) {
		this.id_pelicula = id_pelicula;
	}
	public int getId_tipo() {
		return id_tipo;
	}
	public void setId_tipo(int id_tipo) {
		this.id_tipo = id_tipo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public tablaPremios() {
		super();
		this.id = 0;
		this.id_pelicula = 0;
		this.id_tipo = 0;
		this.nombre = "";
		this.fecha = Date.valueOf("1970-01-01");
	}
	public tablaPremios(int id, int id_pelicula, int id_tipo, String nombre, Date fecha) {
		super();
		this.id = id;
		this.id_pelicula = id_pelicula;
		this.id_tipo = id_tipo;
		this.nombre = nombre;
		this.fecha = fecha;
	}
	@Override
	public String toString() {
		return "tablaPremios [id=" + id + ", id_pelicula=" + id_pelicula + ", id_tipo=" + id_tipo + ", nombre=" + nombre
				+ ", fecha=" + fecha + "]";
	}
	
	
	

}
