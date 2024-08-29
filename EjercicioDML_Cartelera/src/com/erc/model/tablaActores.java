package com.erc.model;

public class tablaActores {
	
	private int id, id_persona;
	private double salario;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId_persona() {
		return id_persona;
	}
	public void setId_persona(int id_persona) {
		this.id_persona = id_persona;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	public tablaActores() {
		super();
		this.id = 0;
		this.id_persona = 0;
		this.salario = 0.0;

	}
	public tablaActores(int id, int id_persona, double salario) {
		super();
		this.id = id;
		this.id_persona = id_persona;
		this.salario = salario;
	}
	@Override
	public String toString() {
		return "tablaActores [id=" + id + ", id_persona=" + id_persona + ", salario=" + salario + "]";
	}
	
	
	

}
