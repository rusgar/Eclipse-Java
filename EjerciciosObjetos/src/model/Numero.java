package model;


public class Numero {
    private int numero;

    
    // GETTER Y SETTER
       public int getDoble() {
        return numero * 2;
    }
         public int getTriple() {
           return numero * 3;
       }
       public int getCuadruple() {
           return numero * 4;
       }

       public Numero() {
    	   super();          
       }
  

    public Numero(int numero) {
    	  super();
        this.numero = numero;
    }
     
    @Override
	public String toString() {
		return "MiNumero [numero=" + numero + "]";
	}
    
    
	public void mostrarResultados() {
        System.out.println("El número es: " + numero);
        System.out.println("El doble es: " + getDoble());
        System.out.println("El triple es: " + getTriple());
        System.out.println("El cuádruple es: " + getCuadruple());
    }
}

