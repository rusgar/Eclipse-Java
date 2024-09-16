package com.erc.model;

public class tablaTrabajadores {
	
	private int id,  idDireccion;   
    private String ss, puesto;
  
    
    // GETTER Y SETTER
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public int getIdDireccion() {
		return idDireccion;
	}
	public void setIdDireccion(int idDireccion) {
		this.idDireccion = idDireccion;
	}

	public String getSs() {
		return ss;
	}
	public void setSs(String ss) {
		this.ss = ss;
	}
	public String getPuesto() {
		return puesto;
	}
	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}
	public tablaTrabajadores() {
		super();
		this.id = 0;		
		this.idDireccion = 0;
		this.ss = "";
		this.puesto = "";
	}
	
	// CONSTRUCTOR PARAMETRIZADO
	public tablaTrabajadores(int id,  int idDireccion,  String ss, String puesto) {
		super();
		this.id = id;		
		this.idDireccion = idDireccion;
		this.ss = ss;
		this.puesto = puesto;
	}
	@Override
	public String toString() {
		return "tablaTrabajadores [id=" + id + ",  idDireccion=" + idDireccion + ", ss="
				+ ss + ", puesto=" + puesto + "]";
	}

	
    
   

}
