package Main;
import java.util.Scanner;

public class MainNumerosRomanosV2 {

	public static void main(String[] args) {
		// T//solución por switch
		int numeroEntero=0;
		String numeroRomano="";
		boolean conversionRealizada=false;// bandera
		boolean ejecutar=true;// control bucle
		
		while(ejecutar) {
		System.out.println("Introduzca un numero entero"
				+ " de 1 a 10");
		numeroEntero=Integer.parseInt(leerTeclado());
		switch (numeroEntero) {
		case 1: {
			numeroRomano="I";
			conversionRealizada=true;
			break;
		}
		case 2: {
			numeroRomano="II";
			conversionRealizada=true;
			break;
		}
		case 3: {
			numeroRomano="III";
			conversionRealizada=true;
			break;
		}
		case 4: {
			numeroRomano="IV";
			conversionRealizada=true;
			break;
		}
		case 5: {
			numeroRomano="V";
			conversionRealizada=true;
			break;
		}
		case 6: {
			numeroRomano="VI";
			conversionRealizada=true;
			break;
		}
		case 7: {
			numeroRomano="VII";
			conversionRealizada=true;
			break;
		}
		case 8: {
			numeroRomano="VIII";
			conversionRealizada=true;
			break;
		}
		case 9: {
			numeroRomano="IX";
			conversionRealizada=true;
			break;
		}
		case 10: {
			numeroRomano="X";
			conversionRealizada=true;
			break;
		}
		default:
			System.out.println("Número fuera de rango");
		}
		// con este if controlo que muestre el print solo
		// cuando la conversión se haya ralizado
		if(conversionRealizada) {
		System.out.println("El número "+numeroEntero+
				 " equivale en números romanos a ..."+
				" => "+numeroRomano);
		System.out.println("¿Desea continuar?(y/n)");
		String respuesta=leerTeclado();
		if(respuesta.equalsIgnoreCase("n")
				||respuesta.equalsIgnoreCase("no")
				) {
			ejecutar=false;// rompe el bucle
			System.out.println("Gracias por usar los servicios"
					+ " de dicampus formación 😊😊😊");
		}else {
			 conversionRealizada=false;
		}
		
		
		}
		
		
		
	}
		
	}
	
	private static String leerTeclado() {
		String retorno="";	
		Scanner escaner	= new Scanner(System.in);
		retorno=escaner.nextLine();	
		return retorno;
		}

	

}
