package model;

public class NumeroEntero {
	// ATRIBUTOS
	private int valor;


	// GETTER Y SETTER
	public int getValor() {
		return this.valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}


	// CONSTRUCTOR POR DEFECTO DE INICIO = 0
	public NumeroEntero() {
		this.valor = 0;
	}

	// CONSTRUCTOR QUE PERMITE INICIALIZAR EL NUMERO
	public NumeroEntero(int numero) {
		this.valor = numero;
	}



	// METODOS  QUE PERMITE SUMAR DE UN NUMERO DADO
	public void sumar(int numero) {
		this.valor += numero;
	}

	// METODOS  QUE PERMITE RESTAR DE UN NUMERO DADO
	public void restar(int numero) {
		this.valor -= numero;
	}

	// METODO QUE PERMITE OBTENER EL VALOR DOBLE DEL NUMERO PEDIDO
	public int getDoble() {
		return this.valor * 2;
	}

	// METODO QUE PERMITE OBTENER EL VALOR TRIPLE DEL NUMERO PEDIDO
	public int getTriple() {
		return this.valor * 3;
	}

	// METODO QUE PERMITE OBTENER EL VALOR CUADRUPLE DEL NUMERO PEDIDO
	public int getCuadruple() {
		return this.valor * 4;
	}

	@Override
	public String toString() {
		return "NumeroEntero [numero=" + valor + "]";
	}
}

