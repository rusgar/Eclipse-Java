package com.erc.model;

public class Cliente {
	private int id,punto,idUsuario;
	
	
//getter y setter
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPunto() {
		return punto;
	}

	public void setPunto(int punto) {
		this.punto = punto;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
		// inicializacion por defecto
		this.id = 0;
		this.punto = 0;
		this.idUsuario = 0;
	}

	public Cliente(int id, int punto, int idUsuario) {
		super();
		this.id = id;
		this.punto = punto;
		this.idUsuario = idUsuario;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", punto=" + punto + ", idUsuario=" + idUsuario + "]";
	}
	
	
	

}
