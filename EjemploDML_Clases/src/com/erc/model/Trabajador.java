package com.erc.model;

public class Trabajador {
private int id,idUsuario;
private String ss;
private double salario;


//getter y setter
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getIdUsuario() {
	return idUsuario;
}
public void setIdUsuario(int idUsuario) {
	this.idUsuario = idUsuario;
}
public String getSs() {
	return ss;
}
public void setSs(String ss) {
	this.ss = ss;
}
public double getSalario() {
	return salario;
}
public void setSalario(double salario) {
	this.salario = salario;
}

//constructores
public Trabajador() {
	super();
	// TODO Auto-generated constructor stub
	// inicialización por defecto
	this.id = 0;
	this.idUsuario =0;
	this.ss = "";
	this.salario = 0.0;
}
public Trabajador(int id, int idUsuario, String ss, double salario) {
	super();
	this.id = id;
	this.idUsuario = idUsuario;
	this.ss = ss;
	this.salario = salario;
}
@Override
public String toString() {
	return "Trabajador [id=" + id + ", idUsuario=" + idUsuario + ", ss=" + ss + ", salario=" + salario + "]";
}




}
