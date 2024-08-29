package com.erc.model;

public class Usuario {
	private int id;
	private String dni,nombre,apellidos,direccion,telefono,email;
	
	// getter y setter
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
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
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	// constructores
	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
		// inicializaciones por defecto
		this.id =0;
		this.dni ="";
		this.nombre = "";
		this.apellidos = "";
		this.direccion = "";
		this.telefono = "";
		this.email = "";
	}
	public Usuario(int id, String dni, String nombre, String apellidos, String direccion, String telefono,
			String email) {
		super();
		this.id = id;
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.direccion = direccion;
		this.telefono = telefono;
		this.email = email;
	}
	@Override
	public String toString() {
		return "********************************\n"+
	           " Tabla Usuario: *****************"+
				"\n\t id==>  " + id +
				", \n\t dni==>  " + dni + 
				", \n\t nombre==>  " + nombre + 
				", \n\t apellidos==>  " + apellidos +
				","+ " \n\t direccion==>  "	+ direccion +
				", \n\t telefono==>  " 	+ telefono + 
				", \n\t email==>  " + email +
				"\n********************************\n";
	}

	
	
	

}
