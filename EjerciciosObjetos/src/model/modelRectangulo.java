package model;

import helpers.CommonHelpers;

public class modelRectangulo {

	
	
	CommonHelpers ayudantes= new CommonHelpers();
	
	private float area;
	private float perimetro;
	private float base;
	private float altura;
	
	
	// getter y setter
	
	public float getArea() {
		return area;
	}
	public void setArea(float area) {
		this.area = area;
	}
	public float getPerímetro() {
		return perimetro;
	}
	public void setPerímetro(float perimetro) {
		this.perimetro = perimetro;
	}
	public float getBase() {
		return base;
	}
	public void setBase(float base) {
		this.base = base;
	}
	public float getAltura() {
		return altura;
	}
	public void setAltura(float altura) {
		this.altura = altura;
	}
	
	
	
	// constructor por defecto
	
	public modelRectangulo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//constructor con campos
	
	public modelRectangulo(float area, float perimetro, float base, float altura) {
		super();
		this.area = area;
		this.perimetro = perimetro;
		this.base = base;
		this.altura = altura;
	}
	

	//métodos
	
	public void calcularAreaRectangulo() {
		area=0;
		area= (base * altura);
		
	}
	
	public void calcularPerimetroRectangulo() {
		perimetro=0;
		perimetro= (base+altura)*2;
	
	}

	
}
