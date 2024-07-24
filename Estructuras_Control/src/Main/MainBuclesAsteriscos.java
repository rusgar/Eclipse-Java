package Main;

public class MainBuclesAsteriscos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
			        
		    	// Variable para el número máximo de asteriscos
		        int asteristicos = 4;

		     // Bucle for para recorrer sobre las filas
		        for (int i = 0; i <= asteristicos; i++) {
		           
		            for (int ast = 1; ast <= i; ast++) {
		                System.out.print(" * ");
		            }
		            System.out.println("\n"); 
		        }
		        for (int i = asteristicos; i >=1; i--) {
         
                    for (int ast = 1; ast <= i; ast++) {
                          System.out.print(" * ");
         }
         System.out.println("\n"); 
     }
 }
	
	

		    }
		
	
	


