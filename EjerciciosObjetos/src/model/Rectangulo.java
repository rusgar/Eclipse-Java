package model;
public class Rectangulo {
    private double ancho;
    private double alto;
       
    

    public double getAncho() {
		return ancho;
	}

	public void setAncho(double ancho) {
		this.ancho = ancho;
	}

	public double getAlto() {
		return alto;
	}

	public void setAlto(double alto) {
		this.alto = alto;
	}
		

	public Rectangulo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Rectangulo(double ancho, double alto) {
        this.ancho = ancho;
        this.alto = alto;
    }
	
	
	@Override
	public String toString() {
		return "Rectangulo [ancho=" + ancho + ", alto=" + alto + "]";
	}

	public double calcularArea() {
        return ancho * alto;
    }

    public double calcularPerimetro() {
        return 2 * (ancho + alto);
    }

    
}
