package com.erc.model;

public class tablaRemitentes {
	
	private int  id;
	private String nombre, apellidos, direccion;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public tablaRemitentes() {
		super();
		this.id = 0;
		this.nombre =  "";
		this.apellidos ="";
		this.direccion = "";
		
	}
	public tablaRemitentes(int id, String nombre, String apellidos, String direccion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.direccion = direccion;
	}
	@Override

	
	public String toString() {
		return "********************************\n"+
	           " Tabla Remitentes: *****************"+
				"\n\t id==>  " + id +
				", \n\t nombre==>  " + nombre + 
				", \n\t apellidos==>  " + apellidos +
				","+ " \n\t direccion==>  "	+ direccion +
				"\n********************************\n";
	}

}
