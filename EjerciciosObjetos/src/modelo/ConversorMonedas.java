package modelo;

public class ConversorMonedas {
	private double euros;
    private double dolares;
    private static double tasaCambio =  0.92;
    
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
	
	public double dolaresAEuros() {
        return dolares / tasaCambio;
    }
	public ConversorMonedas() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ConversorMonedas(double euros, double dolares, double   tasaCambio) {
		super();
		this.euros = euros;
		this.dolares = dolares;
		ConversorMonedas.tasaCambio =  tasaCambio;
	}
	@Override
	public String toString() {
		return "ConversorMonedas [euros=" + euros + ", dolares=" + dolares + ", tasaCambio=" + tasaCambio + "]";
	}
	
	
	  

	  public  double convertir(double cantidad, double euros, double dolares) {
	        if (euros.equalsIgnoreCase("euros") && dolares.equalsIgnoreCase("dolares")) {
	            return cantidad * tasaCambio;
	        } else if (euros.equalsIgnoreCase("dolares") && dolares.equalsIgnoreCase("euros")) {
	            return cantidad / tasaCambio;
	        } else {
	            System.out.println("Conversion no válida. Monedas no soportadas.");
	            return 0;
	        }
	    }
	  public String FormatearDecimales(double value) {
		    return String.format("%.2f", value);
		}
	}
    
    



