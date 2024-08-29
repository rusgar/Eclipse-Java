package com.erc.model;

import java.sql.Date;

public class tablaPeliculas {
	private int id, id_director,id_productor, id_pegui, duracion;
	private String titulo;
	private Date fecha;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId_director() {
		return id_director;
	}
	public void setId_director(int id_director) {
		this.id_director = id_director;
	}
	public int getId_productor() {
		return id_productor;
	}
	public void setId_productor(int id_productor) {
		this.id_productor = id_productor;
	}
	public int getId_pegui() {
		return id_pegui;
	}
	public void setId_pegui(int id_pegui) {
		this.id_pegui = id_pegui;
	}
	public int getDuracion() {
		return duracion;
	}
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public tablaPeliculas() {
		super();
		this.id = 0;
		this.id_director = 0;
		this.id_productor = 0;
		this.id_pegui = 0;
		this.duracion = 0;
		
		this.titulo = "";
		this.fecha =  Date.valueOf("1970-01-01");
	}
	public tablaPeliculas(int id, int id_director, int id_productor, int id_pegui, int duracion, String titulo,
			Date fecha) {
		super();
		this.id = id;
		this.id_director = id_director;
		this.id_productor = id_productor;
		this.id_pegui = id_pegui;
		this.duracion = duracion;
		this.titulo = titulo;
		this.fecha = fecha;
	}
	@Override
	public String toString() {
		return "tablaPeliculas [id=" + id + ", id_director=" + id_director + ", id_productor=" + id_productor
				+ ", id_pegui=" + id_pegui + ", duracion=" + duracion + ", titulo=" + titulo + ", fecha=" + fecha + "]";
	}
	
	
	

}
