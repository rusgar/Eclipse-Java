package com.erc.model;

public class tablaTrabajadores {
	
	private int id;
	private int idDireccion;   
    private String nombre;
    private String apellidos;
    private String telefono;
    private String ss;
    private String puesto;

    // GETTERS Y SETTERS
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

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
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

	// CONSTRUCTOR POR DEFECTO
	public tablaTrabajadores() {
		super();
		this.id = 0;		
		this.idDireccion = 0;
		this.nombre = "";
		this.apellidos = "";
		this.telefono = "";
		this.ss = "";
		this.puesto = "";
	}
	
	// CONSTRUCTOR PARAMETRIZADO
	public tablaTrabajadores(int id, int idDireccion, String nombre, String apellidos, String telefono, String ss, String puesto) {
		super();
		this.id = id;
		this.idDireccion = idDireccion;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.ss = ss;
		this.puesto = puesto;
	}

	@Override
	public String toString() {
		return "tablaTrabajadores [id=" + id + ", idDireccion=" + idDireccion + ", nombre=" + nombre + ", apellidos=" + apellidos
				+ ", telefono=" + telefono + ", ss=" + ss + ", puesto=" + puesto + "]";
	}
}
