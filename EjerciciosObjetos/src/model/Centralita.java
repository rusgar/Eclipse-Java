package model;
import helpers.CommonHelpers;


public class Centralita {
    // ATRIBUTOS
    private double consumoMedio;
    private double consumoInstantaneo;
    private double tiempoAceleracion;
    private double velocidadInstantanea;
    
    
	// METODOS GETTER Y SETTER
    public double getConsumoInstantaneo() {
		return consumoInstantaneo;
	}

	public void setConsumoInstantaneo(double consumoInstantaneo) {
		this.consumoInstantaneo = consumoInstantaneo;
	}

	public double getTiempoAceleracion() {
		return tiempoAceleracion;
	}

	public void setTiempoAceleracion(double tiempoAceleracion) {
		this.tiempoAceleracion = tiempoAceleracion;
	}

	public double getVelocidadInstantanea() {
		return velocidadInstantanea;
	}

	public void setVelocidadInstantanea(double velocidadInstantanea) {
		this.velocidadInstantanea = velocidadInstantanea;
	}

    public double getConsumoMedio() {
        return consumoMedio;
    }

    public void setConsumoMedio(double consumoMedio) {
    	
    	if (consumoMedio >= 0) {
            this.consumoMedio = consumoMedio;
        } else {
        	 throw new IllegalArgumentException("El consumo medio no puede ser negativo.");
        }
    }


    // COSNTRUCTORES
    
    public Centralita() {
		super();
        this.consumoMedio = 0.0;
        this.consumoInstantaneo = 0.0;
        this.tiempoAceleracion = 0.0;
        this.velocidadInstantanea = 0.0;
	}
    
    
    public Centralita(double consumoMedio, double consumoInstantaneo, double tiempoAceleracion, double velocidadInstantanea) {
        this.consumoMedio = consumoMedio;
        this.consumoInstantaneo = consumoInstantaneo;
        this.tiempoAceleracion = tiempoAceleracion;
        this.velocidadInstantanea = velocidadInstantanea;
    }

  
    	@Override
    public String toString() {
        return "Centralita{" +
                "consumoMedio=" + consumoMedio +
                ", consumoInstantaneo=" + consumoInstantaneo +
                ", tiempoAceleracion=" + tiempoAceleracion +
                ", velocidadInstantanea=" + velocidadInstantanea +
                '}';
    }
    	public void mostrarDatos() {
    		 CommonHelpers ayudaHelpers = new CommonHelpers();
            ayudaHelpers.leerTecladoString("Consumo Medio: " + consumoMedio + " litros/100km");
            ayudaHelpers.leerTecladoString("Consumo Instantáneo: " + consumoInstantaneo + " litros/hora");
            ayudaHelpers.leerTecladoString("Tiempo de Aceleración: " + tiempoAceleracion + " segundos (0-100 km/h)");
            ayudaHelpers.leerTecladoString("Velocidad Instantánea: " + velocidadInstantanea + " km/h");
        }
}

