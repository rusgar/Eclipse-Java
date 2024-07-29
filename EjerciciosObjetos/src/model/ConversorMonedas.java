package model;

public class ConversorMonedas {
	private double euros, dolares;
	private double tasaCambio =  1.08;
	private double tasaCambio1 =  0.92;
    
    // GETTER Y SETTER
	public double getEuros() {
		return euros;
	}
	public void setEuros(double euros) {
		this.euros = euros;
	}
	public double getDolares() {
		return dolares;
	}
	public void setDolares(double dolares) {
		this.dolares = dolares;
	}

	public double eurosADolares(double tasaCambio) {
        return euros * tasaCambio;
    }
	
	public double dolaresAEuros(double tasaCambio) {
        return dolares / tasaCambio;
    }
	

	
	public ConversorMonedas() {
		super();
		this.euros=0;
		this.dolares=0;
		// TODO Auto-generated constructor stub
	}
	public ConversorMonedas(double euros, double dolares, double   tasaCambio) {
		super();
		this.euros = euros;
		this.dolares = dolares;
		this.tasaCambio =  tasaCambio;
	}
	@Override
	public String toString() {
		return "ConversorMonedas [euros=" + euros + ", dolares=" + dolares + ", tasaCambio=" + tasaCambio + "]";
	}
	public String toString_1() {
		return "ConversorMonedas [dolares=" + dolares +", euros=" + euros + ",  tasaCambio=" + tasaCambio1 + "]";
	}
	
	
	public double monedasConvertir(double cantidad, String monedaOrigen, String monedaDestino) {
        if (monedaOrigen.equalsIgnoreCase("euros") && monedaDestino.equalsIgnoreCase("dolares")) {
            return cantidad * tasaCambio;
        } else if (monedaOrigen.equalsIgnoreCase("dolares") && monedaDestino.equalsIgnoreCase("euros")) {
            return cantidad / tasaCambio;
        } else {
            throw new IllegalArgumentException("Conversion no válida. Monedas no soportadas.");
        }
    }


	  public String formatearDecimales(double value) {
		  String numeroRedondeado = "";
		  numeroRedondeado=String.format("%.2f", value);			
			return numeroRedondeado;
		}
	}
    
    



