package Main;
import java.util.Scanner;
//Realiza un programa que pase un número entero básico(1-10) a un número romano( 1=I,2=II,3=III…);

public class MainNumerosRomanos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		    
	        System.out.print("Por favor, ingresa uun número entero básico(1-10) ");
	        int numero = Integer.parseInt(leerTeclado());
	        String romano= "";

	        switch (numero) {
	            case 1:
	                romano = "I";
	                break;
	            case 2:
	                romano = "II";
	                break;
	            case 3:
	                romano = "III";
	                break;
	            case 4:
	                romano = "IV";
	                break;
	            case 5:
	                romano = "V";
	                break;
	            case 6:
	                romano = "VI";
	                break;
	            case 7:
	                romano = "VII";
	                break;
	            case 8:
	                romano = "VIII";
	                break;
	            case 9:
	                romano = "IX";
	                break;
	            case 10:
	                romano = "X";
	                break;
	            default:
	                romano = "Número inválido";
	                break;
	        }

	        System.out.println("Numero ingresado: "+numero+" transformado a romano correspondiente es: " + romano);
	    }

	
	
	
	private static String leerTeclado() {
		String retorno="";
		Scanner scanner= new Scanner(System.in);
		retorno=scanner.nextLine();
		return retorno;
		}
}

