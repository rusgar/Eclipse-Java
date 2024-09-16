package com.erc.model;

public class tablaTrabajadoresSalidas {
    private int id, idTrabajador, idSalida;
    
 // GETTERES Y SETTERS
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(int idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    public int getIdSalida() {
        return idSalida;
    }

    public void setIdSalida(int idSalida) {
        this.idSalida = idSalida;
    }

    
    public tablaTrabajadoresSalidas() {
        super();
        this.id = 0;
        this.idTrabajador = 0;
        this.idSalida = 0;
    }

    // CONSTRUCTOR PARAMETRIZADO
    public tablaTrabajadoresSalidas(int id, int idTrabajador, int idSalida) {
        super();
        this.id = id;
        this.idTrabajador = idTrabajador;
        this.idSalida = idSalida;
    }

    
    @Override
    public String toString() {
        return "tablaTrabajadoresSalidas [id=" + id + ", idTrabajador=" + idTrabajador + ", idSalida=" + idSalida + "]";
    }

	
}
