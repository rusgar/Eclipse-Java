package Main;

import java.util.Scanner;

public class MainMenuCalculadora {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// definimos las variables
		double operando1=0.0, operando2=0.0;// operadores
		double resultado=0.0;
		int opcion=0;// para recibir las opciones
		boolean ejecutar=true;
		while(ejecutar) {
		// del menú
		System.out.println("\tMenú calculadora");
		System.out.println("\t****************");
		System.out.println("1.Sumar");
		System.out.println("2.Restar");
		System.out.println("3.Multiplicar");
		System.out.println("4.Dividir");
		System.out.println("0.Salir");
		System.out.println("Seleccione una opción");
		opcion=Integer.parseInt(leerTeclado());
		
		/*System.out.println("Dame operando 1");
		operando1=Double.parseDouble(leerTeclado());
		System.out.println("Dame operando 2");
		operando2=Double.parseDouble(leerTeclado());*/
		
		switch(opcion) {
		
		case 1:{
			System.out.println("Dame operando 1");
			operando1=Double.parseDouble(leerTeclado());
			System.out.println("Dame operando 2");
			operando2=Double.parseDouble(leerTeclado());
			
			resultado=operando1+operando2;
			System.out.println(operando1+" + "
			+operando2+" = "+resultado);
			break;
		}
		case 2:{
			System.out.println("Dame operando 1");
			operando1=Double.parseDouble(leerTeclado());
			System.out.println("Dame operando 2");
			operando2=Double.parseDouble(leerTeclado());
			
			resultado=operando1-operando2;
			System.out.println(operando1+" - "
			+operando2+" = "+resultado);
			break;
		}
		case 3:{
			System.out.println("Dame operando 1");
			operando1=Double.parseDouble(leerTeclado());
			System.out.println("Dame operando 2");
			operando2=Double.parseDouble(leerTeclado());
			
			resultado=operando1*operando2;
			System.out.println(operando1+" * "
			+operando2+" = "+resultado);
			break;
		}
		case 4:{
			System.out.println("Dame operando 1");
			operando1=Double.parseDouble(leerTeclado());
			System.out.println("Dame operando 2");
			operando2=Double.parseDouble(leerTeclado());
			
			resultado=operando1/operando2;
			System.out.println(operando1+" / "
			+operando2+" = "+resultado);
			break;
		}
		case 0:{
			// paro la ejcucion pasando la
			// variable de control a false
			ejecutar=false;
			break;
		}
		
		default:
			System.out.println("Opcion no disponible");
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
