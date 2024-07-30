package model;

public class NumeroEntero {
    private int valor;

    
    
 // GETTER(OBTENER) Y SETTER(ESTABLECER)

  // METEDO PARA OBTENER EN VALOR DEL NUMERO
    public int getValor() {
        return this.valor;
    }
    
    // METODO PARA OBTENER EL SET VALOR DEL NUMERO
    public void setValor(int valor) {
        this.valor = valor;
    }
    
    
    
    // CONSTRUCTOT POR DEFECTO CON INICIALIZACION A 0
    public NumeroEntero() {
        this.valor = 0;
    }

 
    //CONSTRUCTOR QUE PERMITE INICIALIZAR EL NUMERO
    public NumeroEntero(int numero) {
        this.valor = numero;
    }

    //METODO PARA SUMAR UN NUMERO DADO A NUESTRO NUMERO
    public void sumar(int numero) {
        this.valor += numero;
    }

  //METODO PARA RESTAR UN NUMERO DADO A NUESTRO NUMERO
    public void restar(int numero) {
        this.valor -= numero;
    }
    
    // METODO PARA OBTENER EL VALOR DOBLE DEL NUMERO
    public int getDoble() {
        return this.valor * 2;
    }

    // METODO PARA OBTENER EL VALOR TRIPLE DEL NUMERO
    public int getTriple() {
        return this.valor * 3;
    }
    


    @Override
    public String toString() {
        return "NumeroEntero [numero=" + valor + "]";
    }
    
    
}
