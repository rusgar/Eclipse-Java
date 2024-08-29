package com.erc.model;

public class tablaPersonajesPeliculas {
	 private int id, id_personaje,id_pelicula,id_actor;

	 
	 // GETTER Y SETTER
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_personaje() {
		return id_personaje;
	}

	public void setId_personaje(int id_personaje) {
		this.id_personaje = id_personaje;
	}

	public int getId_pelicula() {
		return id_pelicula;
	}

	public void setId_pelicula(int id_pelicula) {
		this.id_pelicula = id_pelicula;
	}

	public int getId_actor() {
		return id_actor;
	}

	public void setId_actor(int id_actor) {
		this.id_actor = id_actor;
	}

	public tablaPersonajesPeliculas() {
		super();
		this.id = this.id_personaje = this.id_pelicula = this.id_actor = 0;
	}

	public tablaPersonajesPeliculas(int id, int id_personaje, int id_pelicula, int id_actor) {
		super();
		this.id = id;
		this.id_personaje = id_personaje;
		this.id_pelicula = id_pelicula;
		this.id_actor = id_actor;
	}

	@Override
	public String toString() {
		return "tablaPersonajesPeliculas [id=" + id + ", id_personaje=" + id_personaje + ", id_pelicula=" + id_pelicula
				+ ", id_actor=" + id_actor + "]";
	}
	
	
}
