package main;

/*  Realice un programa que muestre por pantalla el siguiente mensaje:

“Un progamador nunca acaba pronto ni tarde;

Simplemente cuando se le ha planificado”*/
public class mainMostraPantalla {

    public static void main(String[] args) {
    	String primeraParte = "";
    	String segundaParte = "";
    	String mensajeCompleto = "";
    	
    	
      primeraParte = "Un programador nunca acaba pronto ni tarde;";
      segundaParte = "simplemente cuando se le ha planificado.";

        mensajeCompleto = primeraParte +  segundaParte;
        System.out.print(mensajeCompleto);
    }
}
