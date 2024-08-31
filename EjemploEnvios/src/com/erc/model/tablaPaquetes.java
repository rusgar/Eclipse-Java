package com.erc.model;

public class tablaPaquetes {
	
	private int id, id_remitente, id_tarifa;
	private String referencia, destinatario,direccion= "";
	private double peso;
	
	
	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public int getId_remitente() {
		return id_remitente;
	}



	public void setId_remitente(int id_remitente) {
		this.id_remitente = id_remitente;
	}



	public int getId_tarifa() {
		return id_tarifa;
	}



	public void setId_tarifa(int id_tarifa) {
		this.id_tarifa = id_tarifa;
	}



	public String getReferencia() {
		return referencia;
	}



	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}



	public String getDestinatario() {
		return destinatario;
	}



	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}



	public String getDireccion() {
		return direccion;
	}



	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}



	public double getPeso() {
		return peso;
	}



	public void setPeso(double peso) {
		this.peso = peso;
	}


	public tablaPaquetes() {
		super();
		this.id = 0;
		this.id_remitente = 0;
		this.id_tarifa = 0;
		this.referencia = "";
		this.destinatario = "";
		this.direccion = "";
		this.peso = 0.0; 
	}


	public tablaPaquetes(int id, int id_remitente, int id_tarifa, String referencia, String destinatario,
			String direccion, double peso) {
		super();
		this.id = id;
		this.id_remitente = id_remitente;
		this.id_tarifa = id_tarifa;
		this.referencia = referencia;
		this.destinatario = destinatario;
		this.direccion = direccion;
		this.peso = peso;
	}





	@Override

	
	public String toString() {
		return "********************************\n"+
	           " Tabla Paquetes: ***************"+
				"\n\t id==>  " + id +
				", \n\t id_remitente==>  " + id_remitente + 
				", \n\t id_tarifa==>  " + id_tarifa + 
				", \n\t referencia==>  " + referencia +
				","+ " \n\t destinatario==>  "	+ destinatario +
				", \n\t direccion==>  " 	+ direccion + 
				", \n\t peso=>  " + peso +
				"\n********************************\n";
	}
	

}
