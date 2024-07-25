package helpers;
import java.util.Scanner;

public class CommonHelpers {
	
		
		public String leerTeclado() {
		String retorno="";
		Scanner sca= new Scanner(System.in);
		retorno=sca.nextLine();
		return retorno;
	}
		public double leerTecladoDouble() {
			Scanner sca = new Scanner(System.in);
	        String entrada = sca.nextLine();
	        double valor = Double.parseDouble(entrada);
	        return valor;
	}
		

		public void imprimirSalto(String mensaje) {
			 System.out.println(mensaje);
		}
		public void imprimirContinuo(String mensaje) {
			 System.out.print(mensaje);
		}
	}


