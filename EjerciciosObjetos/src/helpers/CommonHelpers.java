package helpers;
import java.lang.classfile.instruction.ReturnInstruction;
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
		
		public int obtenerEntero(String cadena) {
			int retorno=0;
			retorno = Integer.parseInt(cadena);
			return retorno;
		}
		public double obtenerDouble(String cadena) {
			double retorno=0;
			retorno =Double.parseDouble(cadena);
			return retorno;
		}
		
		public String obtenerString(int entrada) {
			String retorno= "";
			retorno = String.valueOf(retorno);
			return retorno;
		}
		public String obtenerString(double entrada) {
			String retorno= "";
			retorno = String.valueOf(retorno);
			return retorno;
		}
		public String obtenerString(float entrada) {
			String retorno= "";
			retorno = String.valueOf(retorno);
			return retorno;
		}
		public float redondearFloat(float numero) {
			float numeroRedondeado = (float)0.0;
			String cadenaFormateada=String.format("%.2f", numero);
			numeroRedondeado = Float.parseFloat(cadenaFormateada);
			return numeroRedondeado;
		}
		public double redondearDouble(double numero) {
			double numeroRedondeado = 0.0;
			String cadenaFormateada=String.format("%.2f", numero);
			numeroRedondeado = Double.parseDouble(cadenaFormateada);
			return numeroRedondeado;
		}
		
		public double redondearDoubleN(double numero, int numeroDecimales) {
			double numeroRedondeado = (float)0.0;
			String cadenaFormateada=String.format("%" +numeroDecimales+".2f", numero);
			numeroRedondeado = Double.parseDouble(cadenaFormateada);
			return numeroRedondeado;
		}
		 public boolean continuarBucle() {
			 boolean retorno=true;
			 imprimirSalto("¿Desea continuar? (y/n)");
			 String leido= leerTeclado();
			 if(leido.equalsIgnoreCase("n") ||(leido.equalsIgnoreCase("no"))) {
				 retorno =false;
				 imprimirSalto("Recuerdo que Java es molto divertente");
			 }return retorno;
		 }
	}


