package com.erc.model;

public class Geometria {

    private double base;
    private double altura;
    private double lado1;
    private double lado2;

    // Métodos para establecer los valores
    public void setBase(double base) {
        this.base = base;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public void setLado1(double lado1) {
        this.lado1 = lado1;
    }

    public void setLado2(double lado2) {
        this.lado2 = lado2;
    }

    // Métodos para calcular área y perímetro
    public double calcularAreaRectangulo() {
        return base * altura;
    }

    public double calcularPerimetroRectangulo() {
        return 2 * (base + altura);
    }

    public double calcularAreaCirculo() {
        return Math.PI * base * base; // base se usa como radio aquí
    }

    public double calcularPerimetroCirculo() {
        return 2 * Math.PI * base; // base se usa como radio aquí
    }

    public double calcularAreaTriangulo() {
        return (base * altura) / 2;
    }

    public double calcularPerimetroTriangulo() {
        return base + lado1 + lado2;
    }

    
	public Geometria() {
		super();
		this.base = 0;
		this.altura = 0;
		this.lado1 = 0;
		this.lado2 = 0;
	}

	@Override
	public String toString() {
		return "Geometria [base=" + base + ", altura=" + altura + ", lado1=" + lado1 + ", lado2=" + lado2 + "]";
	}
	public double[] calcularMedidas(String figura) {
        double[] resultados = new double[2]; // 0: área, 1: perímetro
        switch (figura) {
            case "Rectangulo":
                resultados[0] = calcularAreaRectangulo();
                resultados[1] = calcularPerimetroRectangulo();
                break;
            case "Circulo":
                resultados[0] = calcularAreaCirculo();
                resultados[1] = calcularPerimetroCirculo();
                break;
            case "Triangulo":
                resultados[0] = calcularAreaTriangulo();
                resultados[1] = calcularPerimetroTriangulo();
                break;
            default:
                throw new IllegalArgumentException("Figura desconocida: " + figura);
        }
        return resultados;
    }
}

