package model;

public class Operacion {

	// defino los atributos de la clase
	private int operador1;
	private int operador2;
	private int opcion;
	
	
	// getter y setter que son lo métods de acceso 
	// a los atributos
	public int getOperador1() {
		return operador1;
	}
	public void setOperador1(int operador1) {
		this.operador1 = operador1;
	}
	public int getOperador2() {
		return operador2;
	}
	public void setOperador2(int operador2) {
		this.operador2 = operador2;
	}
	public int getOpcion() {
		return opcion;
	}
	public void setOpcion(int opcion) {
		this.opcion = opcion;
	}
	
	
 //constructores
	//por defecto
	
	public Operacion() {
		super();
		// TODO Auto-generated constructor stub
		// si quiero inicializar valores por defecto
		/*
		this.operador1 =0;
		this.operador2 =0;
		this.opcion =0;
		*/
		
	}
	//constructor parametrizado
public Operacion(int operador1, int operador2, int opcion) {
	super();
	this.operador1 = operador1;
	this.operador2 = operador2;
	this.opcion = opcion;
}

// método to String que devuelve 
//los atributos de la clase
@Override
public String toString() {
	return "Operacion [operador1=" + operador1 + ", operador2=" + operador2 + ", opcion=" + opcion + "]";
}

// defino un método que realice la operación
//indicada
public void resuelveOperacion() {
	String resultado="";
	switch (opcion) {
	case 1: {
		// suma
		resultado=operador1+" + "+
		operador2+" = "
		+String.valueOf((operador1+operador2));
		System.out.println(resultado);
		break;
	}
	
	case 2: {
		// resta
		resultado=operador1+" - "+
		operador2+" = "
		+String.valueOf((operador1-operador2));
		System.out.println(resultado);
		break;
	}
	case 3: {
		// multiplicacion
		resultado=operador1+" * "+
		operador2+" = "
		+String.valueOf((operador1*operador2));
		System.out.println(resultado);
		break;
	}
	case 4: {
		// división
		try {
		resultado=operador1+" / "+
		operador2+" = "
		+String.valueOf((operador1/operador2));
		System.out.println(resultado);
		}catch(ArithmeticException artEx) {
			System.out.println("no es posible "
					+ "la división por cero");// mensaje de error
		}catch (Exception e) {
			e.printStackTrace();// impimir traza del error// TODO: handle exception
		}
		break;
	}
	default:
		System.out.println("Opción no disponible");
	}
}

public void publicarMenu() {
	System.out.println("\tMenú calculadora");
	System.out.println("\t****************");
	System.out.println("1.Sumar");
	System.out.println("2.Restar");
	System.out.println("3.Multiplicar");
	System.out.println("4.Dividir");
	System.out.println("Seleccione una opción");
}

	


	
	
	
	
}
