package com.erc.model;

public class tablaPersonajes_Peliculas {
 private int id, id_genero,id_pelicula;

 
 // GETTER Y SETTER
public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public int getid_genero() {
	return id_genero;
}

public void setid_genero(int id_genero) {
	this.id_genero = id_genero;
}

public int getId_pelicula() {
	return id_pelicula;
}

public void setId_pelicula(int id_pelicula) {
	this.id_pelicula = id_pelicula;
}




public tablaPersonajes_Peliculas() {
	super();
	this.id = this.id_genero = this.id_pelicula = 0;
}

public tablaPersonajes_Peliculas(int id, int id_genero, int id_pelicula, int id_actor) {
	super();
	this.id = id;
	this.id_genero = id_genero;
	this.id_pelicula = id_pelicula;
	
}

@Override
public String toString() {
	return "tablPersonajes_Peliculas [id=" + id + ", id_genero=" + id_genero + ","
			+ " id_pelicula=" + id_pelicula	+ "]";
}
 
 
 
 
 
}
