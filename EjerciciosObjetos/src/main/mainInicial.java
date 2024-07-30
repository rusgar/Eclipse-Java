	package main;

	import java.util.Scanner;
	//  Realiza un programa en Java que muestre la inicial de un nombre contenido en el propio programa(utilizar nombre del alumno)

	public class mainInicial {
	    public static void main(String[] args) {
	    	String nombre = "";
	    		    
	    	 do {
	             System.out.print("Introduce un nombre: ");
	             nombre =  leerTeclado();
	        
	        if (!nombre.isEmpty()) { // con este metodo extraer el primer carácter, comprueba si la nombrecadena está vacía utilizando !nombre.isEmpty
	            char  inicial = nombre.charAt(0); // con este metodo extrae el primer carácter usando nombre.charAt(0)
	            inicial = Character.toUpperCase(inicial); // Convert to uppercase a mayusculas el resultado
	            System.out.println("La inicial de tu nombre es: " + inicial);
	            break;}
	            else {
	                System.out.println("No se ha introducido un nombre válido.");
	            }
	        } while(true);
	        	System.out.println("Fin del ejercicio.");
	        }
	    	 
	    	 
	    
	
	 

		private static String leerTeclado() {
			String retorno="";
			Scanner sca= new Scanner(System.in);
			retorno=sca.nextLine();
			return retorno;
		}
	    
	}
