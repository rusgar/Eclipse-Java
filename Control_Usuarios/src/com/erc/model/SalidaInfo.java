package com.erc.model;

public class SalidaInfo {

    private tablaSalidas salida;
    private String puesto;
    private String localidad;
    private String nombreUsuario;
    private String enlaceGoogleMaps;

    public SalidaInfo(tablaSalidas salida, String puesto, String localidad, String nombreUsuario, String enlaceGoogleMaps) {
        this.salida = salida;
        this.puesto = puesto;
        this.localidad = localidad;
        this.nombreUsuario = nombreUsuario;
        this.enlaceGoogleMaps = enlaceGoogleMaps;
    }

    // Getters y setters para los atributos
    public tablaSalidas getSalida() {
        return salida;
    }

    public void setSalida(tablaSalidas salida) {
        this.salida = salida;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getEnlaceGoogleMaps() {
        return enlaceGoogleMaps;
    }

    public void setEnlaceGoogleMaps(String enlaceGoogleMaps) {
        this.enlaceGoogleMaps = enlaceGoogleMaps;
    }
}
