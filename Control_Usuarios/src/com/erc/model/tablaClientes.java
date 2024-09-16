package com.erc.model;

public class tablaClientes {

    private int id;
    private String nombre;
    private String apellidos;
    private String dni;
    private String telefono;

    // GETTERS Y SETTERS
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


    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    // CONSTRUCTORES
    public tablaClientes() {
        this.id = 0;
        this.nombre = "";
        this.apellidos = "";       
        this.dni = "";
        this.telefono = "";
    }

    public tablaClientes(int id, String nombre, String apellidos, String dni, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;      
        this.dni = dni;
        this.telefono = telefono;
    }

	@Override
	public String toString() {
		return "tablaClientes [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", dni=" + dni
				+ ", telefono=" + telefono + "]";
	}


    
}

