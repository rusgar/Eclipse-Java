package com.erc.model;

public class tablaDirectores {
	private int id, id_persona;
	private String alma_mater;
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
	public String getAlma_mater() {
		return alma_mater;
	}
	public void setAlma_mater(String alma_mater) {
		this.alma_mater = alma_mater;
	}
	public tablaDirectores() {
		super();
		this.id = 0;
		this.id_persona = 0;
		this.alma_mater = "";
	}
	public tablaDirectores(int id, int id_persona, String alma_mater) {
		super();
		this.id = id;
		this.id_persona = id_persona;
		this.alma_mater = alma_mater;
	}
	@Override
	public String toString() {
		return "tablaDirectores [id=" + id + ", id_persona=" + id_persona + ", alma_mater=" + alma_mater + "]";
	}
	
	

}
