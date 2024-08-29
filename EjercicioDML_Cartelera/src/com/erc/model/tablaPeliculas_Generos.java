package com.erc.model;

public class tablaPeliculas_Generos {
 private int id, id_genero, id_pelicula;
 
 //GETTER Y SETTER

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public int getId_genero() {
	return id_genero;
}

public void setId_genero(int id_genero) {
	this.id_genero = id_genero;
}

public int getId_pelicula() {
	return id_pelicula;
}

public void setId_pelicula(int id_pelicula) {
	this.id_pelicula = id_pelicula;
}

public tablaPeliculas_Generos() {
	super();
	this.id = this.id_genero = this.id_pelicula= 0;
	
}

public tablaPeliculas_Generos(int id, int id_genero, int id_pelicula) {
	super();
	this.id = id;
	this.id_genero = id_genero;
	this.id_pelicula = id_pelicula;
}

@Override
public String toString() {
	return "tablaPeliculas_Generos [id=" + id + ", id_genero=" + id_genero + ", id_pelicula=" + id_pelicula + "]";
}
 
 
}
