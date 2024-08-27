package com.erc.model;

public class tablaNacionalidades {
  private int id;
  private String gentilicio, pais;
  
  // GETTER Y SETTER
  
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getGentilicio() {
	return gentilicio;
}
public void setGentilicio(String gentilicio) {
	this.gentilicio = gentilicio;
}
public String getPais() {
	return pais;
}
public void setPais(String pais) {
	this.pais = pais;
}
public tablaNacionalidades() {
	super();
	this.id = 0;
	this.gentilicio = "";
	this.pais = "";
}
public tablaNacionalidades(int id, String gentilicio, String pais) {
	super();
	this.id = id;
	this.gentilicio = gentilicio;
	this.pais = pais;
}
@Override
public String toString() {
	return "tablaNacionalidades [id=" + id + ", gentilicio=" + gentilicio + ", pais=" + pais + "]";
}


  

}
