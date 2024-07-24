package Main;
import java.util.Scanner;

public class MainMayorMenor {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// defino las variables de lo elementos
		int num1=0, num2=0, num3=0;
		int max=0, min=0;
		System.out.println("Introduzca por favor"
				+ " el primer numero");
		num1=Integer.parseInt(leerTeclado());
		System.out.println("Introduzca por favor"
				+ " el segundo numero");
		num2=Integer.parseInt(leerTeclado());	
		System.out.println("Introduzca por favor"
				+ " el tercero numero");
		num3=Integer.parseInt(leerTeclado());
		
		// ahora lo organizamos tutilizando el
		// elemento pivote
		max=num1;
		if(max<num2) {
			max=num2;
		}
		if(max<num3) {
			max=num3;
		}
		
		min=num1;
		if(min>num2) {
			min=num2;
		}
		if(min>num3) {
			min=num3;
		}
		System.out.println("max => "+max+
				"\nmin => "+min);
		// resolucion por arrays
		int [ ]numeros= new int[3];
		numeros[0]=num1;
		numeros[1]=num2;
		numeros[2]=num3;
		
		// calculo el max
		max=num1;
		min=num1;
		for (int i=0;i<numeros.length;i++) {
			if(max < numeros[i]) {
				max=numeros[i];
			}
			if(min > numeros[i]) {
				min=numeros[i];
			}
			
		}
		
		
		System.out.println("Resolución por array"
				+ "\nmax => "+max+
				"\nmin => "+min);
		
	}
	
private static String leerTeclado() {
String retorno="";	
Scanner escaner	= new Scanner(System.in);
retorno=escaner.nextLine();	
return retorno;
}
	
	
}
